package kalang.compiler.compile;

import kalang.annotation.PluginMethod;
import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.FieldNotFoundException;
import kalang.compiler.MethodNotFoundException;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParserBaseVisitor;
import kalang.compiler.ast.*;
import kalang.compiler.core.*;
import kalang.compiler.exception.Exceptions;
import kalang.compiler.util.*;
import kalang.type.FunctionClasses;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.*;

public abstract class AstBuilderBase extends KalangParserBaseVisitor<Object> {

    protected final DiagnosisReporter diagnosisReporter;
    protected final SemanticAnalyzer semanticAnalyzer;
    private CompilationUnit compilationUnit;

    protected MethodContext methodCtx;

    public AstBuilderBase(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        this.diagnosisReporter = new DiagnosisReporter(compilationUnit);
        this.semanticAnalyzer = new SemanticAnalyzer(compilationUnit, compilationUnit.getCompileContext().getAstLoader());
    }

    abstract ClassNode getCurrentClass();

    abstract ClassNode getTopClass();

    public void importPackage(@Nonnull String packageName) {
        compilationUnit.getTypeNameResolver().importPackage(packageName);
    }

    public void importStaticMember(ClassNode classNode,@Nullable String name) {
        if (name!=null && !name.isEmpty()) {
            compilationUnit.staticImportMembers.put(name,classNode);
        } else {
            compilationUnit.staticImportPaths.add(classNode);
        }
    }

    protected ExprNode getObjectFieldLikeExpr(ExprNode expr,String fieldName, OffsetRange offset){
        ExprNode ret;
        Type type = expr.getType();
        if(!(type instanceof  ObjectType)){
            diagnosisReporter.report(Diagnosis.Kind.ERROR,"unsupported type",offset);
            return null;
        }
        ObjectType exprType = (ObjectType) type;
        if ((exprType instanceof ArrayType)
                && fieldName.equals("length")) {
            ret = new ArrayLengthExpr(expr);
        } else {
            try {
                ret = ObjectFieldExpr.create(expr, fieldName,getCurrentClass());
            } catch (FieldNotFoundException ex) {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, "field not found:" + fieldName,offset);
                ret = new UnknownFieldExpr(expr,exprType.getClassNode(),fieldName);
            }
        }
        mapAst(ret, offset);
        return ret;
    }

    protected void processConstructor() {
        ClassNode thisClazz = getCurrentClass();
        MethodNode[] methods = thisClazz.getDeclaredMethodNodes();
        for(MethodNode m:methods) {
            BlockStmt mbody = m.getBody();
            if(AstUtil.isConstructor(m)){
                @SuppressWarnings("null")
                List<Statement> bodyStmts = mbody.statements;
                if(!AstUtil.hasConstructorCallStatement(bodyStmts)){
                    try {
                        bodyStmts.add(0, AstUtil.createDefaultSuperConstructorCall(thisClazz));
                    } catch (MethodNotFoundException|AmbiguousMethodException ex) {
                        diagnosisReporter.report(Diagnosis.Kind.ERROR
                                ,"default constructor not found"
                                ,m.offset
                        );
                    }
                }
                //check super()
                int stmtsSize = mbody.statements.size();
                assert stmtsSize > 0;
                Statement firstStmt = mbody.statements.get(0);
                if(!AstUtil.isConstructorCallStatement(firstStmt)){
                    //TODO handle error
                    throw new RuntimeException("missing constructor call");
                }
                mbody.statements.addAll(1, thisClazz.initStmts);
            }
        }
    }

    protected void checkMethod() {
        MethodNode m = this.methodCtx.method;
        boolean needReturn = (
                m.getType() != null
                        && !m.getType().equals(Types.VOID_TYPE)
        );
        BlockStmt mbody = m.getBody();
        if (mbody != null && needReturn && !methodCtx.returned) {
            ConstExpr defaultVal = m.getDefaultReturnValue();
            if (defaultVal!=null) {
                mbody.statements.add(new ReturnStmt(defaultVal));
            } else {
                this.diagnosisReporter.report(
                        Diagnosis.Kind.ERROR
                        , "Missing return statement in method:" + MethodUtil.toString(methodCtx.method)
                        , m.offset
                );
            }
        }
        new InitializationAnalyzer(compilationUnit, compilationUnit.getCompileContext().getAstLoader()).check(getCurrentClass(), m);
    }

    @Nonnull
    protected LocalVarNode declareTempLocalVar(Type type){
        LocalVarNode var = declareLocalVar(null, type,0,OffsetRange.NONE);
        if(var==null) throw Exceptions.unexpectedValue(var);
        return var;
    }

    @Nullable
    protected LocalVarNode declareLocalVar(@Nullable String name,Type type,int modifier,OffsetRange offset){
        LocalVarNode localVarNode = new LocalVarNode(type,name,modifier);
        if(name!=null){
            ParameterNode param = methodCtx.getNamedParameter(name);
            LocalVarNode var = methodCtx.getNamedLocalVar(name);
            if (param != null || var != null){
                diagnosisReporter.report(Diagnosis.Kind.ERROR,"variable is defined",  offset);
                return null;
            }
            this.methodCtx.varTables.put(name,localVarNode);
        }
        return localVarNode;
    }

    protected boolean isDefinedId(String id){
        return methodCtx!=null &&
                (methodCtx.getNamedLocalVar(id)!=null
                        || methodCtx.getNamedParameter(id) != null);
    }

    protected void enterMethod(MethodNode method) {
        methodCtx = new MethodContext(this.getCurrentClass(),method);
        methodCtx.returned = false;
    }

    protected AssignableExpr getStaticFieldExpr(ClassReference clazz,String fieldName,OffsetRange offset){
        AssignableExpr ret;
        try {
            ret = StaticFieldExpr.create(clazz,fieldName,getCurrentClass());
        } catch (FieldNotFoundException ex) {
            //ret = new UnknownFieldExpr(clazz, clazz.getReferencedClassNode(), fieldName);
            return null;
        }
        mapAst(ret, offset);
        return ret;
    }

    protected BinaryExpr constructBinaryExpr(ExprNode expr1,ExprNode expr2,String op){
        BinaryExpr binExpr;
        switch(op){
            case "==":
            case "!=":
            case ">":
            case ">=":
            case "<":
            case "<=":
                binExpr = new CompareExpr(expr1, expr2, op);
                break;
            case "&&":
            case "||":
                binExpr = new LogicExpr(expr1, expr2, op);
                break;
            default:
                binExpr = new MathExpr(expr1, expr2, op);
                break;
        }
        semanticAnalyzer.validateBinaryExpr(binExpr);
        return binExpr;
    }

    protected void methodIsAmbiguous(Token token , AmbiguousMethodException ex){
        diagnosisReporter.report(Diagnosis.Kind.ERROR, ex.getMessage(), token);
    }

    protected void methodIsAmbiguous(OffsetRange offset , AmbiguousMethodException ex){
        diagnosisReporter.report(Diagnosis.Kind.ERROR, ex.getMessage(), offset);
    }


    protected void methodNotFound(Token token , Type type,String methodName,ExprNode[] params){
        methodNotFound(token,type.getName(),methodName,params);
    }

    protected void methodNotFound(Token token , String className,String methodName,ExprNode[] params){
        Type[] types = AstUtil.getExprTypes(params);
        diagnosisReporter.report(Diagnosis.Kind.ERROR
                , "method not found:" + MethodUtil.toString(className,methodName, types)
                , token
        );
    }

    protected void methodNotFound(OffsetRange offset, String className,String methodName,ExprNode[] params){
        Type[] types = AstUtil.getExprTypes(params);
        diagnosisReporter.report(Diagnosis.Kind.ERROR
                , "method not found:" + MethodUtil.toString(className,methodName, types)
                ,offset
        );
    }

    @Nullable
    protected ExprNode concatExpressionsToStringExpr(ExprNode[] expr){
        ExprNode ret;
        try {
            ret = new NewObjectExpr(Types.requireClassType("java.lang.StringBuilder"),new ExprNode[0]);
        } catch (MethodNotFoundException | AmbiguousMethodException ex) {
            throw Exceptions.unexpectedException(ex);
        }
        for(int i=0;i<expr.length;i++){
            ret = ObjectInvokeExpr.create(ret, "append",new ExprNode[]{expr[i]});
        }
        return ObjectInvokeExpr.create(ret,"toString",new ExprNode[0]);
    }

    @Nullable
    protected ExprNode requireImplicitCast(Type resultType,@Nullable ExprNode expr,OffsetRange offset) {
        if (expr==null) {
            return null;
        }
        Type exprType = expr.getType();
        ExprNode result = BoxUtil.assign(expr, exprType, resultType);
        if (result == null) {
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, String.format("%s cannot be converted to %s", exprType,resultType), offset);
            return null;
        }
        return result;
    }

    @Nullable
    protected ExprNode requireCastable(ExprNode expr1, Type fromType, Type toType,OffsetRange offset) {
        ExprNode expr = BoxUtil.assign(expr1,fromType,toType);
        if(expr==null){
            diagnosisReporter.report(Diagnosis.Kind.ERROR
                    , "unable to cast " + fromType + " to " + toType, offset);
        }
        return expr;
    }

    @Nonnull
    protected ObjectType getTypeForGeneric(Type type) {
        if (Types.NULL_TYPE.equals(type)) {
            return Types.getRootType();
        } else if (type instanceof PrimitiveType) {
            ObjectType objType = Types.getClassType((PrimitiveType) type);
            Objects.requireNonNull(objType);
            return objType;
        }
        return (ObjectType) type;
    }

    @Nullable
    protected ExprNode requireCastToPrimitiveDataType(ExprNode expr, OffsetRange offsetRange) {
        Type oldType = expr.getType();
        expr = BoxUtil.assignToPrimitiveDataType(expr,oldType);
        if (expr == null) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR
                    , "unable to cast " + oldType + " to primitive type", offsetRange);
        }
        return expr;
    }

    protected int parseModifier(KalangParser.VarModifierContext modifier) {
        int defaultModifier = Modifier.PUBLIC;
        if (modifier == null) return defaultModifier;
        String modifierText = parseTreeToText(modifier);
        if (modifierText.isEmpty()) return defaultModifier;
        try {
            return ModifierUtil.parse(modifierText);
        } catch (InvalidModifierException ex) {
            this.handleSyntaxError(ex.getMessage(), modifier);
            return defaultModifier;
        }
    }

    //TODO add stop token
    protected void handleSyntaxError(String msg, Token token) {
        //TODO what does EMPTY means?
        handleSyntaxError(msg, (ParserRuleContext.EMPTY), token, token);
    }

    protected void handleSyntaxError(String msg, ParserRuleContext tree) {
        handleSyntaxError(msg, tree, tree.start, tree.stop);
    }

    //TODO remove rule
    protected void handleSyntaxError(String desc, ParserRuleContext rule, Token start, Token stop) {
        diagnosisReporter.report(Diagnosis.Kind.ERROR, desc, start, stop);
    }

    protected void handleSyntaxError(String desc, OffsetRange offsetRange) {
        diagnosisReporter.report(Diagnosis.Kind.ERROR, desc, offsetRange);
    }


    protected void mapAst(@Nonnull AstNode node, @Nonnull ParserRuleContext tree) {
        node.offset = OffsetRangeHelper.getOffsetRange(tree);
    }

    protected void mapAst(AstNode node,OffsetRange offsetRange) {
        node.offset = offsetRange;
    }

    protected void mapAst(@Nonnull AstNode node, @Nonnull Token token) {
        node.offset = OffsetRangeHelper.getOffsetRange(token);
    }

    @Nullable
    protected ClassNode resolveNamedClass(String id,ClassNode topClass,ClassNode currentClass){
        TypeNameResolver typeNameResolver = compilationUnit.getTypeNameResolver();
        String resolvedName = typeNameResolver.resolve(id, topClass, currentClass);
        ClassNode ast = resolvedName==null ? null : getAst(resolvedName);
        return ast;
    }

    protected ClassType parseLambdaType(KalangParser.LambdaTypeContext ctx) {
        NullableKind nullable = ctx.nullable==null ? NullableKind.NONNULL : NullableKind.NULLABLE;
        KalangParser.TypeContext returnTypeCtx = ctx.returnType;
        Type returnType = this.parseType(returnTypeCtx);
        List<KalangParser.TypeContext> paramTypeCtxList = ctx.paramsTypes;
        int paramCount = paramTypeCtxList.size();
        int maxParamCount = FunctionClasses.CLASSES.length-1;
        if (paramCount > maxParamCount) {
            String msg = "only support " +maxParamCount + " parameters";
            diagnosisReporter.report(Diagnosis.Kind.ERROR,msg,ctx);
            return Types.getRootType();
        }
        Type[] paramTypes = new Type[paramCount];
        for(int i=0;i<paramTypes.length;i++) {
            paramTypes[i] = this.parseType(paramTypeCtxList.get(i));
        }
        return Types.getFunctionType(returnType, paramTypes, nullable);
    }

    @Nullable
    protected Type parseType(KalangParser.TypeContext ctx) {
        KalangParser.ClassTypeContext ct = ctx.classType();
        KalangParser.PrimitiveTypeContext pt = ctx.primitiveType();
        if(ct!=null){
            return parseClassType(ct);
        }else if(pt!=null){
            return Types.getPrimitiveType(pt.getText());
        }else{
            NullableKind nullable = ctx.nullable!=null ? NullableKind.NULLABLE : NullableKind.NONNULL;
            KalangParser.TypeContext t = ctx.type();
            Type cpt = parseType(t);
            if(cpt==null) return null;
            return Types.getArrayType(cpt,nullable);
        }
    }

    @Nullable
    protected ObjectType parseClassType(KalangParser.ClassTypeContext ctx){
        NullableKind nullable = ctx.nullable==null ? NullableKind.NONNULL : NullableKind.NULLABLE;
        KalangParser.LambdaTypeContext lambdaType = ctx.lambdaType();
        if (lambdaType!=null) {
            return this.parseLambdaType(lambdaType);
        }
        Token rawTypeToken = ctx.rawClass;
        List<String> classNameParts = new LinkedList();
        for(Token p:ctx.paths){
            classNameParts.add(p.getText());
        }
        if(ctx.innerClass!=null){
            classNameParts.add(rawTypeToken.getText() + "$" + ctx.innerClass.getText());
        }else{
            classNameParts.add(rawTypeToken.getText());
        }
        String rawType = String.join(".", classNameParts);
        for(GenericType gt:getCurrentClass().getGenericTypes()){
            if(rawType.equals(gt.getName())) return gt;
        }
        ObjectType clazzType = requireClassType(rawType,rawTypeToken);
        if(clazzType==null) return null;
        ClassNode clazzNode = clazzType.getClassNode();
        GenericType[] clzDeclaredGenericTypes = clazzNode.getGenericTypes();
        List<KalangParser.ParameterizedElementTypeContext> parameterTypes = ctx.parameterTypes;
        if(parameterTypes!=null && !parameterTypes.isEmpty()){
            Type[] typeArguments = new Type[parameterTypes.size()];
            if(parameterTypes!=null && parameterTypes.size()>0){
                if(clzDeclaredGenericTypes.length!=parameterTypes.size()){
                    diagnosisReporter.report(
                            Diagnosis.Kind.ERROR
                            , "wrong number of type arguments"
                            ,ctx
                    );
                    return null;
                }
                for(int i=0;i<typeArguments.length;i++){
                    typeArguments[i] = parseParameterizedElementType(parameterTypes.get(i));
                    //TODO should return null?
                    if(typeArguments[i]==null) return null;
                }
            }
            return Types.getClassType(clazzType.getClassNode(), typeArguments,nullable);
        } else {
            return Types.getClassType(clazzType.getClassNode(), nullable);
        }
    }

    @Nullable
    protected ObjectType requireClassType(@Nonnull Token token){
        return requireClassType(token.getText(),token);
    }

    @Nullable
    protected ObjectType requireClassType(@Nonnull String id,@Nonnull Token token){
        ClassNode ast = requireAst(id, token,false);
        if(ast==null) return null;
        return Types.getClassType(ast,new Type[0]);
    }

    @Nullable
    protected ClassNode requireAst(Token token,boolean fullname){
        return requireAst(token.getText(),token,fullname);
    }

    /**
     * checks whether a class is available
     * @param id
     * @param token
     * @return
     */
    @Nullable
    protected ClassNode requireAst(String id,Token token,boolean fullname) {
        ClassNode ast;
        if (fullname) {
            ast = getAst(id);
        } else {
            ast = resolveNamedClass(id, getTopClass(), getCurrentClass());
        }
        if(ast==null){
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "class not found:" + id, token);
        }
        return ast;
    }

    protected ConstExpr parseLiteral(KalangParser.LiteralContext ctx){
        String t = ctx.getText();
        ConstExpr ce;
        if (ctx.IntegerLiteral() != null) {
            //NOTE should show tip for autocast?
            Type constType = Types.INT_TYPE;
            if (t.toUpperCase().endsWith("L")){
                t = t.substring(0,t.length()-1);
                constType = Types.LONG_TYPE;
            } else if (t.toUpperCase().endsWith("I")){
                t = t.substring(0,t.length()-1);
                constType = Types.INT_TYPE;
            }
            String constValue;
            try{
                if (Types.INT_TYPE.equals(constType)) {
                    constValue = String.valueOf(StringLiteralUtil.parseInteger(t));
                } else  {
                    constValue = String.valueOf(StringLiteralUtil.parseLong(t));
                }
            }catch(NumberFormatException ex){
                this.handleSyntaxError("invalid number", ctx);
                return null;
            }
            ce = new ConstExpr(constType, constValue);
        } else if (ctx.FloatingPointLiteral() != null) {
            Type constType = Types.DOUBLE_TYPE;
            if(t.toUpperCase().endsWith("D")){
                t = t.substring(0,t.length()-1);
                constType = Types.DOUBLE_TYPE;
            }else if(t.toUpperCase().endsWith("F")){
                t = t.substring(0,t.length()-1);
                constType = Types.FLOAT_TYPE;
            }
            try{
                if (Types.FLOAT_TYPE.equals(constType)) {
                    Float.parseFloat(t);
                } else {
                    Double.parseDouble(t);
                }
            }catch(NumberFormatException ex){
                this.handleSyntaxError("invalid float value", ctx);
                return null;
            }
            ce = new ConstExpr(constType, t);
        } else if (ctx.BooleanLiteral() != null) {
            ce = new ConstExpr(Types.BOOLEAN_TYPE, t);
        } else if (ctx.CharacterLiteral() != null) {
            ce = new ConstExpr(Types.CHAR_TYPE, StringLiteralUtil.parse(t));
        } else if (ctx.StringLiteral() != null) {
            ce = new ConstExpr(Types.getStringClassType(), StringLiteralUtil.parse(t.substring(1, t.length() - 1)));
        } else if (ctx.MultiLineStringLiteral()!=null){
            ce = new ConstExpr(Types.getStringClassType(), StringLiteralUtil.parse(t.substring(3,t.length()-3)));
        } else if (ctx.Identifier()!=null){
            ClassReference clsRef = requireClassReference(ctx.Identifier().getSymbol());
            if (clsRef == null) {
                return null;
            }
            //TODO fix type parameter
            ce = new ConstExpr(Types.getClassClassType(), clsRef.getReferencedClassNode().name);
        } else if (ctx.getText().equals("null")) {
            ce = new ConstExpr(Types.NULL_TYPE,"null");
        } else {
            throw Exceptions.unexpectedValue(ctx.getText());
        }
        mapAst(ce,ctx);
        return ce;
    }


    @Nullable
    protected AnnotationNode parseAnnotation(KalangParser.AnnotationContext ctx) {
        ClassNode anType = requireAst(ctx.annotationType,false);
        if(anType==null) return null;
        List<Token> vk = ctx.annotationValueKey;
        KalangParser.LiteralContext dv = ctx.annotationDefaultValue;
        AnnotationNode anNode = new AnnotationNode(anType);
        if(vk!=null && vk.size()>0){
            List<KalangParser.LiteralContext> anValues = ctx.annotationValue;
            int ksize = vk.size();
            for(int i=0;i<ksize;i++){
                String kname = vk.get(i).getText();
                ConstExpr value = parseLiteral(anValues.get(i));
                anNode.values.put(kname, value);
            }
        }else if(dv!=null){
            ConstExpr defaultValue = parseLiteral(dv);
            anNode.values.put("value", defaultValue);
        }
        if(!semanticAnalyzer.validateAnnotation(anNode)) return null;
        //TODO validate annotation's values
        return anNode;
    }

    protected List<AnnotationNode> getAnnotations(@Nullable List<KalangParser.AnnotationContext> ctxs){
        List<AnnotationNode> list = new LinkedList<>();
        if(ctxs!=null){
            for(KalangParser.AnnotationContext an:ctxs){
                AnnotationNode anNode = parseAnnotation(an);
                if(anNode!=null) list.add(anNode);
            }
        }
        return list;
    }

    @Nullable
    protected ExprNode getObjectFieldExpr(ExprNode expr,String fieldName,@Nullable ParserRuleContext rule){
        ExprNode ret;
        Type type = expr.getType();
        if(!(type instanceof  ObjectType)){
            //AstBuilder.this.handleSyntaxError("unsupported type", rule==null ? ParserRuleContext.EMPTY : rule);
            return null;
        }
        ObjectType exprType = (ObjectType) type;
        if ((exprType instanceof ArrayType)){
            return null;
        } else {
            try {
                ret = ObjectFieldExpr.create(expr, fieldName,exprType.getClassNode());
            } catch (FieldNotFoundException ex) {
                return null;
            }
        }
        if(rule!=null) mapAst(ret, rule);
        return ret;
    }

    protected List<MethodDescriptor> getStaticMethods(ClassNode clazz,String methodName) {
        ClassType scType = Types.getClassType(clazz);
        MethodDescriptor[] scMethods = scType.getMethodDescriptors(getCurrentClass(), methodName,true, true);
        List<MethodDescriptor> scStaticMethods = new LinkedList<>();
        for(MethodDescriptor m:scMethods) {
            if (Modifier.isStatic(m.getModifier())) {
                scStaticMethods.add(m);
            }
        }
        return scStaticMethods;
    }

    protected ExprNode createInitializedArray(Type type,ExprNode[] exprs){
        NewArrayExpr ae = new NewArrayExpr(type,new ConstExpr(exprs.length));
        if(exprs.length>0){
            Statement[] initStmts = new Statement[exprs.length+2];
            //TODO create a method for temp var creation
            //TODO localVarNode should add a type parameter
            LocalVarNode local = this.declareTempLocalVar(ae.getType());
            initStmts[0] = new VarDeclStmt(local);
            VarExpr arrVar = new VarExpr(local);
            initStmts[1] = new ExprStmt(new AssignExpr(arrVar,ae));
            for(int i=0;i<exprs.length;i++){
                initStmts[i+2] =new ExprStmt(
                        new AssignExpr(
                                new ElementExpr(arrVar, new ConstExpr(i))
                                , exprs[i]
                        )
                );
            }
            return new MultiStmtExpr(Arrays.asList(initStmts), arrVar);
        }else{
            return ae;
        }
    }

    protected boolean isInConstructor(){
        return "<init>".equals(this.methodCtx.method.getName());
    }

    protected ExprNode createBinaryBoolOperateExpr(ExprNode expr1,ExprNode expr2,String op) {
        expr1 = requireCastToPrimitiveDataType(expr1,expr1.offset);
        expr2 = requireCastToPrimitiveDataType(expr2,expr2.offset);
        if (expr1 == null || expr2 == null) {
            return null;
        }
        return constructBinaryExpr(expr1, expr2, op);
    }


    protected ExprNode createBinaryMathExpr(ExprNode expr1,ExprNode expr2,String op){
        Type type1 = expr1.getType();
        Type type2 = expr2.getType();
        boolean isPrimitive1 = type1 instanceof PrimitiveType;
        boolean isPrimitive2 = type2 instanceof PrimitiveType;
        PrimitiveType numPriType1 = isPrimitive1 ? (PrimitiveType)type1 : Types.getPrimitiveType((ObjectType)type1);
        PrimitiveType numPriType2 = isPrimitive2 ? (PrimitiveType)type2 : Types.getPrimitiveType((ObjectType)type2);
        PrimitiveType resultType = MathType.getType(numPriType1, numPriType2);
        expr1 = requireImplicitCast(resultType,requireImplicitCast(numPriType1, expr1, expr1.offset),expr1.offset);
        expr2 = requireImplicitCast(resultType, requireImplicitCast(numPriType2, expr2, expr2.offset), expr2.offset);
        if (expr1 == null || expr2 == null) {
            return null;
        }
        return constructBinaryExpr(expr1, expr2, op);
    }

    protected void checkAndBuildInterfaceMethods(ClassNode clazz) {
        for(ClassNode c:clazz.classes) {
            checkAndBuildInterfaceMethods(c);
        }
        if (Modifier.isAbstract(clazz.modifier)) {
            return;
        }
        Map<MethodDescriptor, MethodNode> implementationMap = InterfaceUtil.getImplementationMap(clazz);
        for(Map.Entry<MethodDescriptor,MethodNode> e:implementationMap.entrySet()) {
            MethodDescriptor interfaceMethod = e.getKey();
            MethodNode implementedMethod = e.getValue();
            if (implementedMethod == null && Modifier.isAbstract(interfaceMethod.getModifier())) {
                String msg = String.format(
                        "please override abstract method %s in %s",
                        interfaceMethod.toString()
                        ,interfaceMethod.getMethodNode().getClassNode().name
                );
                diagnosisReporter.report(Diagnosis.Kind.ERROR,msg, clazz.offset);
            }
        }
    }

    protected List<MethodDescriptor> getImportedPluginMethod(String methodName) {
        List<MethodDescriptor> results = new LinkedList<>();
        Collection<MethodDescriptor> staticImportedMds = getStaticImportedMethods(methodName);
        for(MethodDescriptor m:staticImportedMds) {
            if (AnnotationUtil.has(m.getMethodNode().getAnnotations(), PluginMethod.class.getName())) {
                results.add(m);
            }
        }
        return results;
    }

    protected List<MethodDescriptor> getStaticImportedMethods(String methodName) {
        ClassNode classOfStaticImport = compilationUnit.staticImportMembers.get(methodName);
        if (classOfStaticImport!=null) {
            return getStaticMethods(classOfStaticImport,methodName);
        }
        for (int i=compilationUnit.staticImportPaths.size()-1;i>=0;i--) {
            ClassNode sc = compilationUnit.staticImportPaths.get(i);
            List<MethodDescriptor> mds = getStaticMethods(sc, methodName);
            if (!mds.isEmpty()) {
                return mds;
            }
        }
        return Collections.EMPTY_LIST;
    }

    protected AssignableExpr getSafeAccessibleAssignableExpr(AssignableExpr expr,List<Statement> initStmtsHolder) {
        if (expr instanceof ObjectFieldExpr) {
            ObjectFieldExpr fe = (ObjectFieldExpr) expr;
            ExprNode originTarget = fe.getTarget();
            if (isSafeAccessibleExpr(originTarget)) {
                return expr;
            }
            ExprNode safeTarget = createSafeAccessibleExpr(originTarget, initStmtsHolder);
            return new ObjectFieldExpr(safeTarget, fe.getField());
        } else if (expr instanceof ElementExpr) {
            //element execute order:array -> index
            ElementExpr eleExpr = (ElementExpr) expr;
            ExprNode arrayExpr = eleExpr.getArrayExpr();
            ExprNode indexExpr = eleExpr.getIndex();
            boolean isArraySafeAccessible = isSafeAccessibleExpr(arrayExpr);
            boolean isIndexSafeAccessible = isSafeAccessibleExpr(indexExpr);
            if (isArraySafeAccessible && isIndexSafeAccessible) {
                return expr;
            }
            ExprNode safeArrayExpr = isArraySafeAccessible ? arrayExpr : createSafeAccessibleExpr(arrayExpr, initStmtsHolder);
            ExprNode safeIndexExpr = isIndexSafeAccessible ? indexExpr : createSafeAccessibleExpr(indexExpr, initStmtsHolder);
            return new ElementExpr(safeArrayExpr, safeIndexExpr);
        } else if (isSafeAccessibleExpr(expr)) {
            return expr;
        } else {
            throw Exceptions.unexpectedValue(expr);
        }
    }

    private VarExpr createSafeAccessibleExpr(ExprNode target, List<Statement> initStmtsHolder) {
        LocalVarNode tmpTarget = declareTempLocalVar(target.getType());
        initStmtsHolder.add(new VarDeclStmt(tmpTarget));
        initStmtsHolder.add(new ExprStmt(new AssignExpr(new VarExpr(tmpTarget),target)));
        return new VarExpr(tmpTarget);
    }

    private boolean isSafeAccessibleExpr(ExprNode expr) {
        return expr instanceof VarExpr
                || expr instanceof ParameterExpr
                || expr instanceof StaticFieldExpr
                || expr instanceof ConstExpr
                ;
    }

    private String parseTreeToText(ParseTree ctx) {
        if (ctx instanceof TerminalNode) return ctx.getText();
        StringBuilder sb = new StringBuilder();
        int childCount = ctx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i > 0) sb.append(" ");
            sb.append(parseTreeToText(ctx.getChild(i)));
        }
        return sb.toString();
    }

    private Type parseParameterizedElementType(KalangParser.ParameterizedElementTypeContext ctx){
        KalangParser.TypeContext type = ctx.type();
        if(type!=null){
            return parseType(type);
        }else{
            return parseWildcardType(ctx.wildcardType());
        }
    }

    private Type parseWildcardType(KalangParser.WildcardTypeContext ctx){
        ObjectType classType = parseClassType(ctx.classType());
        if(classType==null) return null;
        Type[] bounds = new Type[]{classType};
        String boundKind = ctx.boundKind.getText();
        if(boundKind.equals("super")){
            return new WildcardType(new Type[]{Types.getRootType()},bounds);
        }else{
            return new WildcardType(bounds,null);
        }
    }

    @Nullable
    private ClassReference requireClassReference(@Nonnull Token token){
        ClassNode ast = requireAst(token,false);
        if(ast==null) return null;
        return new ClassReference(ast);
    }

    @Nullable
    private ClassNode getAst(String className) {
        AstLoader astLoader = compilationUnit.getCompileContext().getAstLoader();
        return astLoader.getAst(className);
    }

}
