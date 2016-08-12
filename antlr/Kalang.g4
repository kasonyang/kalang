/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr, Sam Harwell
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/*
* The kalang grammar file modified from Java.g4
*/
grammar Kalang;

@lexer::members {
    public static final int WHITESPACE = 3;
    public static final int COMMENTS =    4; 
} 

compilationUnit:
    importDecl*
    (classDef | scriptDef)
;
scriptDef:
        (methodDecl | stat)*
;
classDef:
    annotation*
    varModifier?
    (
        classKind='class' ('<' genericTypes+=Identifier (',' genericTypes+=Identifier)* '>')?
        |classKind='interface'
    ) 
    ('extends' parentClass = classType)? 
    ( 'implements' interfaces+=classType ( ',' interfaces+=classType)* )?
    '{' classBody '}'
;

importDecl:
   (
        'import' (root='\\')? 
        path+=Identifier ('\\' path+=Identifier)*
        delim='\\' ( 
            (name=Identifier ('as' alias=Identifier)? )
            |(name='*')
        ) 
    |
        'import' 
        path+=Identifier ('.' path+=Identifier)*
        delim='.' ( 
            (name=Identifier ('as' alias=Identifier)? )
            |(name='*')
        )
    )
    ';'
;
qualifiedName:
   Identifier ('.' Identifier)*
;
classBody:
  fieldDecl*
  methodDecl*
;
fieldDecl:
   varModifier? varDecl (',' varDecl)* ';'
;
methodDecl:
   annotation*
   OVERRIDE? DEFAULT? varModifier? 
   (
     (returnType=type name=Identifier )
     |(prefix='constructor')
   )
   '('   
        (
            paramTypes+=type paramIds+=Identifier
            (',' paramTypes+=type paramIds+=Identifier)*
        )?
    ')'
   ('throws' exceptionTypes+=Identifier (',' exceptionTypes+=Identifier)*)?
   ( blockStmt | ';')
;
annotation:
    '@' annotationType=Identifier 
        ( '('  
            (
                ( annotationValueKey+=Identifier '=' annotationValue+=literal (',' annotationValueKey+=Identifier '=' annotationValue+=literal)* ) 
                | annotationDefaultValue=literal
            )?
         ')'  )?
;
type:
    classType
    | primitiveType
    |  type '[' ']' (nullable='?')?
;
classType:
    rawClass=Identifier 
        ('<' parameterTypes+=parameterizedElementType 
                    ( ',' parameterTypes+=parameterizedElementType)* 
        '>')?
        (nullable='?')?
;
parameterizedElementType:
    type | wildcardType
;
wildcardType:
    '?' boundKind=('extends'|'super') classType
;
primitiveType:
  DOUBLE|LONG|FLOAT|INT|CHAR|BOOLEAN|BYTE|VOID
;

localVarDecl:
   varDecl (',' varDecl)*
;

ifStat:
    IF '(' expression ')' trueStmt=stat ( ELSE falseStmt=stat)?
    ;
stat:
    blockStmt
    |varDeclStat
    |postIfStmt
    |exprStat
    |ifStat
    |whileStat
    |doWhileStat
    |forStat
    |forEachStat
    |breakStat
    |continueStat
    |returnStat
    |tryStat
    |throwStat
    |errorousStat
;
errorousStat:
    expression
;
throwStat:
    'throw' expression ';'
;
blockStmt:
    '{' stat* '}'
;
tryStat:
    'try' exec=blockStmt
    ('catch' '(' catchTypes+=classType catchVarNames+=Identifier ')'
        catchExec += blockStmt
    )*
    ('finally' finallyExec=blockStmt)?
;
returnStat:
    'return' expression? ';'
;
postIfStmt:
    expression //(ASSIGN|MULTI_ASSIGN) expression 
     'if' (
            op = '=='
            |op ='<'
            |op ='>'
            |op ='!='
            |op ='>='
            |op ='<='
     )? expression ';'
;
varDeclStat:
  localVarDecl ';'
;
varDecl:
  (
      ('var'|'val') name=Identifier ('as' type)? ('=' expression)?
  )|(
      varType=type name=Identifier ('=' expression)?
  )
;
breakStat:'break' ';';
continueStat:'continue' ';';
whileStat:
    WHILE '(' expression ')' stat
;
doWhileStat:
    DO blockStmt WHILE '(' expression ')' ';'
;

forStat:
  FOR '(' localVarDecl? ';' expression? ';' expressions? ')'
  stat
;
forEachStat:
    'foreach' '(' expression 'as' ( Identifier ',' )? Identifier ')' stat
;
expressions:
    expression (',' expression)*
;

exprStat:
    expression ';'
;

expression
    :   LPAREN 
        expression 
        RPAREN #parenExpr
    |   ref=('this'|'super') #selfRefExpr
    |   literal #literalExpr
    | ( '<' keyType=Identifier ',' valueType=Identifier '>' )? ( '['  keys+=Identifier ':' values+=expression ( ',' keys+=Identifier ':' values+=expression)*  ']' 
          | '[' ':' ']'
      ) #mapExpr
    | ('<' type '>')? '[' ( expression ( ',' expression )* )? ']'  # arrayExpr
    //|   expression '.' 'this'
    //|   expression '.' 'new' nonWildcardTypeArguments? innerCreator
    //|   expression '.' 'super' superSuffix
    |    target=expression refKey=('.'|'->'|'*.') Identifier 
        '(' (params+=expression (',' params+=expression)*)? ')'  #invokeExpr
    |   expression refKey=('.'|'->') Identifier #getFieldExpr
    |     (Identifier|key='this'|key='super') 
        '(' (params+=expression (',' params+=expression)*)? ')'   #memberInvocationExpr
    |  expression '[' expression ']' #getArrayElementExpr    
    |   'new' classType
         '(' (params+=expression (',' params+=expression)*)? ')'     #newExpr
    |   ( 'new' type '[' size=expression ']' 
            | 'new' type '[' ']' '{' (initExpr+=expression (','  initExpr += expression)*)? '}'
        )    #newArrayExpr
    |   '(' type ')' expression #castExpr
    |   expression op=('++' | '--') #incExpr
    |   ( '+' | '-' ) expression #unaryExpr
    |   op=( '++' | '--' ) expression #preIncExpr
    |   ('~'|'!') expression  #unaryExpr
    |   expression ('*'|'/'|'%') expression #binaryExpr
    |   expression ('+'|'-') expression #binaryExpr
    |   expression ('<<' | '>>>' | '>>') expression #binaryExpr
    |   expression ('<=' | '>=' | '>' | '<') expression #binaryExpr
    |   expression INSTANCEOF Identifier  #instanceofExpr
    |   expression ('=='|'!=') expression #binaryExpr
    |   expression '&' expression #binaryExpr
    |   expression '^' expression #binaryExpr
    |   expression '|' expression #binaryExpr
    |   expression ('&&'|'||') expression #binaryExpr
    |   expression '?' expression ':' expression #questionExpr
    |   Identifier #identifierExpr 
    |   expression '.' #errorousMemberExpr
    |   <assoc=right> expression
         ( '=' 
        |   '+='
        |   '-='
        |   '*='
        |   '/='
        |   '&='
        |   '|='
        |   '^='
        |   '>>='
        |   '>>>='
        |   '<<='
        |   '%='
        )
        expression #assignExpr
;

literal
    :   IntegerLiteral 
    |   FloatingPointLiteral 
    |   CharacterLiteral 
    |   StringLiteral 
    |   BooleanLiteral 
    |   Identifier '.' 'class'
    |   'null' 
    ;

// LEXER

varModifier:('static'|'final'|'private'|'public'|'protected')+;

// §3.9 Keywords
OVERRIDE   : 'override' ;
ABSTRACT      : 'abstract';
ASSERT        : 'assert';
BOOLEAN       : 'boolean';
BREAK         : 'break';
BYTE          : 'byte';
CASE          : 'case';
CATCH         : 'catch';
CHAR          : 'char';
CLASS         : 'class';
CONST         : 'const';
CONTINUE      : 'continue';
DEFAULT       : 'default';
DO            : 'do';
DOUBLE        : 'double';
ELSE          : 'else';
ENUM          : 'enum';
EXTENDS       : 'extends';
FINAL         : 'final';
FINALLY       : 'finally';
FLOAT         : 'float';
FOR           : 'for';
IF            : 'if';
GOTO          : 'goto';
IMPLEMENTS    : 'implements';
IMPORT        : 'import';
INSTANCEOF    : 'instanceof';
INT           : 'int';
INTERFACE     : 'interface';
LONG          : 'long';
NATIVE        : 'native';
NEW           : 'new';
PACKAGE       : 'package';
PRIVATE       : 'private';
PROTECTED     : 'protected';
PUBLIC        : 'public';
RETURN        : 'return';
SHORT         : 'short';
STATIC        : 'static';
STRICTFP      : 'strictfp';
SUPER         : 'super';
SWITCH        : 'switch';
SYNCHRONIZED  : 'synchronized';
THIS          : 'this';
THROW         : 'throw';
THROWS        : 'throws';
TRANSIENT     : 'transient';
TRY           : 'try';
VOID          : 'void';
VOLATILE      : 'volatile';
WHILE         : 'while';

// §3.10.1 Integer Literals

IntegerLiteral
    :   DecimalIntegerLiteral
    |   HexIntegerLiteral
    |   OctalIntegerLiteral
    |   BinaryIntegerLiteral
    ;

fragment
DecimalIntegerLiteral
    :   DecimalNumeral IntegerTypeSuffix?
    ;

fragment
HexIntegerLiteral
    :   HexNumeral IntegerTypeSuffix?
    ;

fragment
OctalIntegerLiteral
    :   OctalNumeral IntegerTypeSuffix?
    ;

fragment
BinaryIntegerLiteral
    :   BinaryNumeral IntegerTypeSuffix?
    ;

fragment
IntegerTypeSuffix
    :   [lL]
    ;

fragment
DecimalNumeral
    :   '0'
    |   NonZeroDigit (Digits? | Underscores Digits)
    ;

fragment
Digits
    :   Digit (DigitOrUnderscore* Digit)?
    ;

fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;

fragment
NonZeroDigit
    :   [1-9]
    ;

fragment
DigitOrUnderscore
    :   Digit
    |   '_'
    ;

fragment
Underscores
    :   '_'+
    ;

fragment
HexNumeral
    :   '0' [xX] HexDigits
    ;

fragment
HexDigits
    :   HexDigit (HexDigitOrUnderscore* HexDigit)?
    ;

fragment
HexDigit
    :   [0-9a-fA-F]
    ;

fragment
HexDigitOrUnderscore
    :   HexDigit
    |   '_'
    ;

fragment
OctalNumeral
    :   '0' Underscores? OctalDigits
    ;

fragment
OctalDigits
    :   OctalDigit (OctalDigitOrUnderscore* OctalDigit)?
    ;

fragment
OctalDigit
    :   [0-7]
    ;

fragment
OctalDigitOrUnderscore
    :   OctalDigit
    |   '_'
    ;

fragment
BinaryNumeral
    :   '0' [bB] BinaryDigits
    ;

fragment
BinaryDigits
    :   BinaryDigit (BinaryDigitOrUnderscore* BinaryDigit)?
    ;

fragment
BinaryDigit
    :   [01]
    ;

fragment
BinaryDigitOrUnderscore
    :   BinaryDigit
    |   '_'
    ;

// §3.10.2 Floating-Point Literals

FloatingPointLiteral
    :   DecimalFloatingPointLiteral
    |   HexadecimalFloatingPointLiteral
    ;

fragment
DecimalFloatingPointLiteral
    :   Digits '.' Digits? ExponentPart? FloatTypeSuffix?
    |   '.' Digits ExponentPart? FloatTypeSuffix?
    |   Digits ExponentPart FloatTypeSuffix?
    |   Digits FloatTypeSuffix
    ;

fragment
ExponentPart
    :   ExponentIndicator SignedInteger
    ;

fragment
ExponentIndicator
    :   [eE]
    ;

fragment
SignedInteger
    :   Sign? Digits
    ;

fragment
Sign
    :   [+-]
    ;

fragment
FloatTypeSuffix
    :   [fFdD]
    ;

fragment
HexadecimalFloatingPointLiteral
    :   HexSignificand BinaryExponent FloatTypeSuffix?
    ;

fragment
HexSignificand
    :   HexNumeral '.'?
    |   '0' [xX] HexDigits? '.' HexDigits
    ;

fragment
BinaryExponent
    :   BinaryExponentIndicator SignedInteger
    ;

fragment
BinaryExponentIndicator
    :   [pP]
    ;

// §3.10.3 Boolean Literals

BooleanLiteral
    :   'true'
    |   'false'
    ;

// §3.10.4 Character Literals

CharacterLiteral
    :   '\'' SingleCharacter '\''
    |   '\'' EscapeSequence '\''
    ;

fragment
SingleCharacter
    :   ~['\\]
    ;

// §3.10.5 String Literals

StringLiteral
    :   '"' StringCharacters? '"'
    ;

fragment
StringCharacters
    :   StringCharacter+
    ;

fragment
StringCharacter
    :   ~["\\]
    |   EscapeSequence
    ;

// §3.10.6 Escape Sequences for Character and String Literals

fragment
EscapeSequence
    :   '\\' [btnfr"'\\]
    |   OctalEscape
    |   UnicodeEscape
    ;

fragment
OctalEscape
    :   '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' ZeroToThree OctalDigit OctalDigit
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
ZeroToThree
    :   [0-3]
    ;

// §3.10.7 The Null Literal

NullLiteral
    :   'null'
    ;

// §3.11 Separators

LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
LBRACK          : '[';
RBRACK          : ']';
SEMI            : ';';
COMMA           : ',';
DOT             : '.';

// §3.12 Operators
LEFT_SHIFT   : '<<';
RIGHT_SHIFT   : '>>';
UNSIGNED_RIGHT_SHIFT : '>>>';
ASSIGN          : '=';
GT              : '>';
LT              : '<';
BANG            : '!';
TILDE           : '~';
QUESTION        : '?';
COLON           : ':';
EQUAL           : '==';
LE              : '<=';
GE              : '>=';
NOTEQUAL        : '!=';
AND             : '&&';
OR              : '||';
INC             : '++';
DEC             : '--';
ADD             : '+';
SUB             : '-';
MUL             : '*';
DIV             : '/';
BITAND          : '&';
BITOR           : '|';
CARET           : '^';
MOD             : '%';

ADD_ASSIGN      : '+=';
SUB_ASSIGN      : '-=';
MUL_ASSIGN      : '*=';
DIV_ASSIGN      : '/=';
AND_ASSIGN      : '&=';
OR_ASSIGN       : '|=';
XOR_ASSIGN      : '^=';
MOD_ASSIGN      : '%=';
LSHIFT_ASSIGN   : '<<=';
RSHIFT_ASSIGN   : '>>=';
URSHIFT_ASSIGN  : '>>>=';

// §3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
    :   JavaLetter JavaLetterOrDigit*
    ;

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0xFF
    |   // covers all characters above 0xFF which are not a surrogate
        ~[\u0000-\u00FF\uD800-\uDBFF]
        {Character.isJavaIdentifierStart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0xFF
    |   // covers all characters above 0xFF which are not a surrogate
        ~[\u0000-\u00FF\uD800-\uDBFF]
        {Character.isJavaIdentifierPart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

//
// Additional symbols not defined in the lexical specification
//

AT : '@';
ELLIPSIS : '...';

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> channel(WHITESPACE)
    ;

COMMENT
    :   '/*' .*? '*/' -> channel(COMMENTS)
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* ->  channel(COMMENTS)
    ;