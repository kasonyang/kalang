grammar Kalang;

compiliantUnit:
  importDeclList
    (
        classType='class'
        |classType='interface'
    ) (QUESTION|BANG)? 
    ('extends' parentClass = Identifier)? 
    ( 'implements' interfaces+=Identifier ( ',' interfaces+=Identifier)* )?
    '{' classBody '}'
;
importDeclList:
  importDecl*
;
importDecl:
   'import' STATIC? importPath ';'
;
importPath:
  qualifiedName ('.' '*')?
;
qualifiedName:
   Identifier ('.' Identifier)*
;
classBody:
  fieldDeclList
  methodDeclList
;
fieldDeclList:
  fieldDecl*
;
fieldDecl:
   STATIC? ('val'|'var') Identifier (QUESTION|BANG)? ('as' type)? varInit? setter? getter? ';'
;
setter:
  'set' '(' argumentDeclList ')' '{' statList '}'
;
getter:
  'get' '{' statList '}'
;
methodDeclList:
  methodDecl*
;
methodDecl:
   STATIC? 'var' Identifier (QUESTION|BANG)? '(' argumentDeclList? ')' ('as' type)? '{' statList '}'
;
type:
  noArrayType  ( '[]' )?
;
noArrayType:
  (Identifier|DOUBLE|LONG|FLOAT|INT)
;

argumentDeclList:
   argumentDecl (',' argumentDecl)*
;
argumentDecl:   
  Identifier ('as' type)?
;

statList:
    stat*
;

ifStat:
    IF '(' expression ')' '{' statList '}' ifStatSuffix?
    ;
ifStatSuffix:
    ELSE '{' statList '}'
;

stat:
    postIfStmt
    |exprStat
    |ifStat
    |whileStat
    |doWhileStat
    |forStat
    |breakStat
    |continueStat
    |varDeclStat
    |returnStat
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
  ('var'|'val') Identifier ('as' type)? varInit?
;
varInit:
 '=' expression
;

breakStat:BREAK ';';
continueStat:CONTINUE ';';
whileStat:
    WHILE '(' expression ')' '{' statList '}'
;
doWhileStat:
    DO '{' statList '}' WHILE '(' expression ')' ';'
;

forStat:
  FOR '(' forInit? ';' expression? ';' forUpdate? ')' '{' statList '}'
;

forInit:
        varDecl
       |expressions
    ;
forUpdate
    :   expressions
;

expressions:
    expression (',' expression)*
;

exprStat:
expression ';'
;

expression
    :   primary #exprPrimay
    | map #mapExpr
    | listOrArray # listOrArrayExpr
    |   expression '.' Identifier #exprGetField
    //|   expression '.' 'this'
    //|   expression '.' 'new' nonWildcardTypeArguments? innerCreator
    //|   expression '.' 'super' superSuffix
    |     expression '.' Identifier arguments  #exprInvocation
    |     Identifier arguments  #exprMemberInvocation
    |  expression '[' expression ']' #exprGetArrayElement    
    |   NEW Identifier  arguments     #newExpr
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
primary
    :   LPAREN 
        expression 
        RPAREN #primayParen
    //|   'this'
    //|   'super'
    |   literal #primaryLiteral
    |   Identifier #primaryIdentifier 
    //|   type '.' 'class'
    //|   'void' '.' 'class'
    //|   nonWildcardTypeArguments (explicitGenericInvocationSuffix | 'this' arguments)
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

arguments
    :  '(' (expression (',' expression)*)? ')'
    ;
// LEXER

//Modifier:( '!' | '?' );
//STATIC:'static';
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

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;