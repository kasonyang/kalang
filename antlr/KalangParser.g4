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
    compileOption*
    importDecl*
    (classDef | scriptDef)
;

compileOption:
    COMPILE_OPTION_LINE
;

scriptDef:
        (methodDecl | stat | classDef)*
;
classDef:
    annotation*
    varModifier?
    (
        classKind='class' ('<' typeParam+=typeParameter (',' typeParam+= typeParameter)* '>')?
        |classKind='interface'
    ) 
    name=Identifier?
    ('extends' parentClass = classType)? 
    ( 'implements' interfaces+=classType ( ',' interfaces+=classType)* )?
    '{' classBody '}'
;

importDecl:
   (
        'import' (importMode=('static' | 'mixin') )? (root='\\')?
        path+=Identifier ('\\' path+=Identifier)*
        delim='\\' ( 
            (name=Identifier ('as' alias=Identifier)? )
            |(name='*')
        ) 
    |
        'import' (importMode=('static' | 'mixin') )?
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
     (
       ('<' typeParam+=typeParameter (',' typeParam+=typeParameter)* '>')?
       returnType=type name=Identifier
     )|(
        prefix='constructor'
     )
   )
   '('   
        (
            params+=paramDecl
            (',' params+=paramDecl)*
        )?
    ')'
   ('throws' exceptionTypes+=Identifier (',' exceptionTypes+=Identifier)*)?
   ( blockStmt | ';')
;
paramDecl:
    paramType=type (VARARGS='...')? paramId=Identifier  ( '=' paramDefVal=expression)?
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
        (typeArgsPrefix='<'
            (
                parameterTypes+=parameterizedElementType
                ( ',' parameterTypes+=parameterizedElementType)*
            )?
        '>')?
        (nullable='?')?
     | lambdaType
;

lambdaType:
    '&' returnType=type '(' (paramsTypes+=type (',' paramsTypes+=type)*)? ')' (nullable='?')?
;

parameterizedElementType:
    type | wildcardType
;
wildcardType:
    '?' (boundKind=('extends'|'super') classType)?
;
typeParameter:
    Identifier ('extends' bounds+=classType ('&' bounds+=classType)* )?
;
primitiveType:
  DOUBLE|LONG|FLOAT|INT|SHORT|CHAR|BOOLEAN|BYTE|VOID
;

localVarDecl:
   varDecl (',' varDecl)*
;

destructuringLocalVarDecl:
    key=('val'|'var')
    ( op='{' Identifier (',' Identifier)* '}' | op='[' Identifier (',' Identifier)* ']')
    '=' expression
;

ifStat:
    IF '(' expression ')' trueStmt=stat ( ELSE falseStmt=stat)?
    ;
stat:
    emptyStat
    |blockStmt
    |varDeclStat
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
    |assertStmt
;
emptyStat:
    ';'
;
errorousStat:
    expression
;

assertStmt:
    ASSERT testCondition=expression ( ':' failMessage=expression )?
;

throwStat:
    'throw' expression ';'
;
blockStmt:
    '{' stat* '}'
;
tryStat:
    'try'
    ('(' resources+=varDecl (';' resources+=varDecl)* ';' ? ')')?
    exec=blockStmt
    ('catch' '(' catchTypes+=classType catchVarNames+=Identifier ')'
        catchExec += blockStmt
    )*
    ('finally' finallyExec=blockStmt)?
;
returnStat:
    'return' expression? ';'
;
varDeclStat:
  localVarDecl ';'
  | destructuringLocalVarDecl ';'
;
varDecl:
  (
      (varToken='var'|valToken='val') name=Identifier ('as' type)? ('=' expression)?
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
    FOR '(' valueId=Identifier (',' indexId=Identifier)? IN expression ')' stat
    | 'foreach' '(' expression 'as' ( indexId=Identifier ',' )? valueId=Identifier ')' stat
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
    |   Identifier #identifierExpr
    |   ref=('this'|'super') #selfRefExpr
    |   literal #literalExpr
    | (
        ( lambdaType? '{' ( lambdaParams+=Identifier (',' lambdaParams+=Identifier)* '=>')? stat* '}' )
      | (
            ( ('(' (lambdaParams+=Identifier (',' lambdaParams+=Identifier)*)? ')' ) | lambdaParams+=Identifier)
            '=>'
            (('{' stat* '}') | expression)
         )
      ) #lambdaExpr
    | ( '<' keyType=Identifier ',' valueType=Identifier '>' )? ( '['  keys+=expression ':' values+=expression ( ',' keys+=expression ':' values+=expression)*  ','? ']'
          | '[' ':' ']'
      ) #mapExpr
    | ('<' type '>')? '[' ( expression ( ',' expression )* )? ','? ']'  # arrayExpr
    //|   expression '.' 'this'
    //|   expression '.' 'new' nonWildcardTypeArguments? innerCreator
    //|   expression '.' 'super' superSuffix
    |    target=expression refKey=('.'|'->>'|'..'|'*.'|'*->>'|'?.'|'?->>'|'?..') ( Identifier | StringLiteral)
        '(' (params+=expression (',' params+=expression)*)? ')'  #invokeExpr
    |   expression refKey=('.'|'->>'|'*.'|'*->>'|'?.'|'?->>') (Identifier | StringLiteral) #getFieldExpr
    |     (Identifier|key='this'|key='super') 
        '(' (params+=expression (',' params+=expression)*)? ')'   #memberInvocationExpr
    |  expression '[' expression ']' #getArrayElementExpr    
    |   'new' classType
         '(' (params+=expression (',' params+=expression)*)? ')'     #newExpr
    |   ( 'new' type ( '[' sizes+=expression ']' )+ ( suffix+='[' ']' )*
            | 'new' type '[' ']' '{' (initExpr+=expression (','  initExpr += expression)*)? '}' //TODO support multi dimensions
        )    #newArrayExpr
    |   expression '::' Identifier  #methodRefExpr
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
    |   expression ('=='|'==='|'!='|'!==') expression #binaryExpr
    |   expression '&' expression #binaryExpr
    |   expression '^' expression #binaryExpr
    |   expression '|' expression #binaryExpr
    |   expression '&&' expression #binaryExpr
    |   expression '||' expression #binaryExpr
    |   expression '??' expression #nullDefaultExpr
    |   expression '?' expression ':' expression #questionExpr
    |   expression '.' #errorousMemberExpr
    |   InterpolationPreffixString expression ( '}' INTERPOLATION_STRING? INTERPOLATION_INTERUPT expression)* '}' INTERPOLATION_STRING? INTERPOLATION_END #interpolationExpr
    |   WITH '(' expression ')' '{' stat* '}' #withExpr
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

literal:
    IntegerLiteral
    |   FloatingPointLiteral 
    |   CharacterLiteral 
    |   StringLiteral 
    |   MultiLineStringLiteral
    |   BooleanLiteral
    |   (primitiveType | Identifier) (arrayPrefix='[' ']')? '.' 'class'
    |   'null' 
    ;
varModifier:('static'|'final'|'private'|'public'|'protected'|'synchronized'|'abstract'|'native'|'transient'|'volatile')+;
