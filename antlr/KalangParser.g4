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
parser grammar KalangParser;
options { tokenVocab=KalangLexer; }

compilationUnit:
    importDecl*
    (classDef | scriptDef)
;
scriptDef:
        (methodDecl | stat | classDef)*
;
classDef:
    annotation*
    varModifier?
    (
        classKind='class' ('<' genericTypes+=Identifier (',' genericTypes+=Identifier)* '>')?
        |classKind='interface'
    ) 
    name=Identifier?
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
  ( fieldDecl | methodDecl | classDef )*
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
     ( paths +=Identifier '\\')* rawClass=Identifier 
     ('::' innerClass=Identifier)?
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
    emptyStat
    |blockStmt
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
emptyStat:
    ';'
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
    FOR '(' 
        (localVarDecl | initExpressions=expressions)?
        ';'  condition=expression?  
        ';'  updateExpressions=expressions? 
    ')'
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
    //don't write as '<<' , '>>>' or '>>' because it would cause problem when visit HashMap<String,List<String>>
    |   expression (
                  left='<'    stop='<' 
                | uright='>'  '>'  stop='>' 
                | right='>'     stop='>'
        ) expression #bitShiftExpr
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
    |   InterpolationPreffixString expression ( '}' INTERPOLATION_STRING? INTERPOLATION_INTERUPT expression)* '}' INTERPOLATION_STRING? INTERPOLATION_END #interpolationExpr 
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
    |   MultiLineStringLiteral
    |   BooleanLiteral 
    |   Identifier '.' 'class'
    |   'null' 
    ;
varModifier:('static'|'final'|'private'|'public'|'protected')+;
