grammar Kalang;

@lexer::members {
    public static final int WHITESPACE = 3;
    public static final int COMMENTS =    4; 
} 

compiliantUnit:
    importDecl*
    varModifier?
    (
        classType='class'
        |classType='interface'
    ) 
    ('extends' parentClass = Identifier)? 
    ( 'implements' interfaces+=Identifier ( ',' interfaces+=Identifier)* )?
    '{' classBody '}'
;
importDecl:
   'import' (root='\\')? 
    path+=Identifier ('\\' path+=Identifier)*
    '\\'( 
        (name=Identifier ('as' alias=Identifier)? )
        |(name='*')
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
   varModifier? varDecls ';'
;
methodDecl:
   varModifier? 
   (
     ((type|'void') name=Identifier )
     |(prefix='constructor')
   )
   '(' varDecls? ')'
   ('throws' exceptionTypes+=Identifier (',' exceptionTypes+=Identifier)*)?
   ( stat | ';')
;
type:
  noArrayType  ( '[]' )?
;
noArrayType:
  (Identifier|DOUBLE|LONG|FLOAT|INT|CHAR|BOOLEAN|BYTE)
;

varDecls:
   varDecl (',' varDecl)*
;

/*
statList:
    stat*
;
* 
*/

ifStat:
    IF '(' expression ')' trueStmt=stat ( ELSE falseStmt=stat)?
    ;
stat:
    blockStmt
    |postIfStmt
    |exprStat
    |ifStat
    |whileStat
    |doWhileStat
    |forStat
    |breakStat
    |continueStat
    |varDeclStat
    |returnStat
    |tryStat
    |throwStat
;
throwStat:
    'throws' expression ';'
;
blockStmt:
    '{' stat* '}'
;
tryStat:
    'try' '{' tryStmtList=stat* '}'
    ('catch' '(' catchTypes+=noArrayType catchVarNames+=Identifier ')'
        '{' catchStmts+=stat* '}'
    )*
    ('finally' '{' finalStmtList = stat* '}')?
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
  varDecl ';'
;
varDecl:
  (
      ('var'|'val') name=Identifier ('as' type)? ('=' expression)?
  )|(
      varType=type name=Identifier ('=' expression)?
  )
;
breakStat:BREAK ';';
continueStat:CONTINUE ';';
whileStat:
    WHILE '(' expression ')' stat
;
doWhileStat:
    DO stat WHILE '(' expression ')' ';'
;

forStat:
  FOR '(' varDecls? ';' expression? ';' expressions? ')'
  stat
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
        RPAREN #exprParen
    |   ref=('this'|'super') #exprSelfRef
    //|   'super'
    |   literal #exprLiteral
    |   Identifier #exprIdentifier 
    | map #mapExpr
    | listOrArray # listOrArrayExpr
    |   expression '.' Identifier #exprGetField
    //|   expression '.' 'this'
    //|   expression '.' 'new' nonWildcardTypeArguments? innerCreator
    //|   expression '.' 'super' superSuffix
    |    target=expression '.' Identifier 
        '(' (params+=expression (',' params+=expression)*)? ')'  #exprInvocation
    |     (Identifier|key='this'|key='super') 
        '(' (params+=expression (',' params+=expression)*)? ')'   #exprMemberInvocation
    |  expression '[' expression ']' #exprGetArrayElement    
    |   NEW Identifier 
         '(' (params+=expression (',' params+=expression)*)? ')'     #newExpr
    |   NEW noArrayType '[' expression ']'     #exprNewArray
    |   '(' type ')' expression #castExpr
    |   expression ('++' | '--') #exprSelfOp
    |   ('+'|'-'|'++'|'--') expression #exprSelfOpPre
    |   ('~'|'!') expression  #exprSelfOpPre
    |   expression ('*'|'/'|'%') expression #exprMidOp
    |   expression ('+'|'-') expression #exprMidOp
    |   expression ('<' '<' | '>' '>' '>' | '>' '>') expression #exprMidOp
    |   expression ('<=' | '>=' | '>' | '<') expression #exprMidOp
    //|   expression INSTANCEOF type
    |   expression ('=='|'!=') expression #exprMidOp
    |   expression '&' expression #exprMidOp
    |   expression '^' expression #exprMidOp
    |   expression '|' expression #exprMidOp
    |   expression ('&&'|'||') expression #exprMidOp
    |   expression '?' expression ':' expression #exprQuestion
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
        expression #exprAssign
;
map:
noArrayType? '{' ( Identifier ':' expression ( ',' Identifier ':' expression)*)? '}'
;
listOrArray:
'[]'
| noArrayType? '[' ( expression ( ',' expression )* ) ']'
;

literal
    :   IntegerLiteral 
    |   FloatingPointLiteral 
    |   CharacterLiteral 
    |   StringLiteral 
    |   BooleanLiteral 
    |   'null' 
    ;

// LEXER

varModifier:('static'|'final'|'private'|'public'|'protected')+;

// §3.9 Keywords

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