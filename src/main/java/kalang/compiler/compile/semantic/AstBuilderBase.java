package kalang.compiler.compile.semantic;

import kalang.annotation.MixinMethod;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParserBaseVisitor;
import kalang.compiler.ast.*;
import kalang.compiler.compile.*;
import kalang.compiler.compile.semantic.analyzer.StatementAnalyzer;
import kalang.compiler.compile.util.DiagnosisReporter;
import kalang.compiler.core.*;
import kalang.compiler.util.Exceptions;
import kalang.compiler.util.*;
import kalang.mixin.CollectionMixin;
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
    protected final StatementAnalyzer statementAnalyzer;
    private CompilationUnit compilationUnit;

    private Map<FieldNode, MethodNode> privateFieldReaderMap = new HashMap<>();

    private Map<FieldNode, MethodNode> privateFieldWriterMap = new HashMap<>();

    protected MethodContext methodCtx;

    private int tempVarCounter = 0;

    public AstBuilderBase(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        this.diagnosisReporter = new DiagnosisReporter(compilationUnit);
        this.statementAnalyzer = new StatementAnalyzer(compilationUnit);
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

    public void importMixinMethod(ClassNode classNode, @Nullable String name) {
        if (name != null && !name.isEmpty()) {
            compilationUnit.importedMixinMethods.put(name, classNode);
        } else {
            compilationUnit.importedMixinPaths.add(classNode);
        }
    }

    protected OffsetRange offset(ParserRuleContext ctx) {
        return OffsetRangeHelper.getOffsetRange(ctx);
    }

    protected OffsetRange offset(Token token) {
        return OffsetRangeHelper.getOffsetRange(token);
    }


    protected ExprNode getObjectFieldLikeExpr(ExprNode expr,String fieldName, OffsetRange offset, @Nullable ExprNode assignValue){

        Type type = expr.getType();
        if(!(type instanceof  ObjectType)){
            return null;
        }
        ObjectType exprType = (ObjectType) type;
        if ((exprType instanceof ArrayType) && fieldName.equals("length")) {
            ArrayLengthExpr ret = new ArrayLengthExpr(expr);
            if (assignValue != null) {
                throw new NodeException("could not assign a value to final variable", offset);
            }
            return mapAst(ret, offset);
        } else {
            try {
                FieldExpr fe = ObjectFieldExpr.create(expr, fieldName, getCurrentClass());
                if (assignValue != null) {
                    AssignExpr result = new AssignExpr(fe, assignValue);
                    return mapAst(result, offset);
                }
                return fe;
            } catch (FieldNotFoundException ex) {
                ExprNode ret;
                Type targetType = expr.getType();
                if (!(targetType instanceof ClassType)) {
                    return null;
                }
                ClassNode targetClassNode = ((ClassType) targetType).getClassNode();
                if (!InheritanceUtil.isInnerClassOf(getCurrentClass(), targetClassNode)) {
                    return null;
                }
                FieldNode field = CollectionMixin.find(targetClassNode.getFields(), f -> fieldName.equals(f.getName()));
                if (field == null) {
                    return null;
                }
                boolean isWrite = assignValue != null;
                if (isWrite) {
                    MethodNode writer = getPrivateFieldAccessor(field, true);
                    ClassReference clsRef = new ClassReference(writer.getClassNode());
                    ret = StaticInvokeExpr.create(clsRef, writer.getName(), new ExprNode[]{expr, assignValue}, getCurrentClass());
                } else {
                    MethodNode reader = getPrivateFieldAccessor(field, false);
                    ClassReference clsRef = new ClassReference(reader.getClassNode());
                    ret = StaticInvokeExpr.create(clsRef, reader.getName(), new ExprNode[]{expr}, getCurrentClass());
                }
                return ret;
            }
        }
    }

    @Nonnull
    protected ExprNode requireObjectFieldLikeExpr(ExprNode expr,String fieldName, OffsetRange offset,@Nullable ExprNode assignValue){
        ExprNode fe = getObjectFieldLikeExpr(expr, fieldName ,offset, assignValue);
        if (fe == null) {
            throw new NodeException("field not found:" + fieldName,offset);
        }
        return fe;
    }

    protected void processConstructorsAndStaticInitStmts() {
        ClassNode thisClazz = getCurrentClass();
        MethodNode[] methods = thisClazz.getDeclaredMethodNodes();
        for(MethodNode m:methods) {
            BlockStmt mbody = m.getBody();
            if(AstUtil.isConstructor(m)){
                assert mbody != null;
                List<Statement> bodyStmts = mbody.statements;
                if(!AstUtil.hasConstructorCallStatement(bodyStmts)){
                    try {
                        bodyStmts.add(0, AstUtil.createDefaultSuperConstructorCall(thisClazz));
                    } catch (MethodNotFoundException|AmbiguousMethodException ex) {
                        handleSyntaxError("default constructor not found",m.offset);
                    }
                }
                //check super()
                int stmtsSize = mbody.statements.size();
                assert stmtsSize > 0;
                Statement firstStmt = mbody.statements.get(0);
                if(!AstUtil.isConstructorCallStatement(firstStmt)){
                    handleSyntaxError("missing constructor call", firstStmt.offset);
                }
                mbody.statements.addAll(1, buildFieldInitStmts(false));
            }
        }
        thisClazz.staticInitStmts.addAll(buildFieldInitStmts(true));
    }

    protected void checkMethod() {
        MethodNode m = this.methodCtx.method;
        boolean needReturn = m.getType() != null && !m.getType().equals(Types.VOID_TYPE);
        BlockStmt mbody = m.getBody();
        if (mbody != null && needReturn && !methodCtx.returned) {
            ConstExpr defaultVal = m.getDefaultReturnValue();
            if (defaultVal!=null) {
                mbody.statements.add(new ReturnStmt(defaultVal));
            } else {
                handleSyntaxError("Missing return statement in method:" + MethodUtil.toString(methodCtx.method), m.offset);
            }
        }
    }

    @Nonnull
    protected LocalVarNode declareTempLocalVar(Type type){
        return declareLocalVar("$temp$" + tempVarCounter++, type,0,OffsetRange.NONE);
    }

    @Nonnull
    protected LocalVarNode declareLocalVar(@Nullable String name,Type type,int modifier,OffsetRange offset){
        LocalVarNode localVarNode = new LocalVarNode(type,name,modifier);
        if(name!=null){
            ParameterNode param = methodCtx.getNamedParameter(name);
            LocalVarNode var = methodCtx.getNamedLocalVar(name);
            if (param != null || var != null){
                throw new NodeException("variable is defined",  offset);
            }
            this.methodCtx.varTables.put(name,localVarNode);
        }
        return localVarNode;
    }

    protected boolean isDefinedId(String id){
        return methodCtx!=null &&
                (methodCtx.getNamedLocalVar(id) != null || methodCtx.getNamedParameter(id) != null);
    }

    protected void enterMethod(MethodNode method) {
        methodCtx = new MethodContext(this.getCurrentClass(),method);
        methodCtx.returned = false;
    }

    @Nullable
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

    @Nonnull
    protected BinaryExpr constructBinaryExpr(ExprNode expr1,ExprNode expr2,String op){
        BinaryExpr binExpr;
        switch(op){
            case BinaryExpr.OP_EQ:
            case BinaryExpr.OP_NE:
            case BinaryExpr.OP_GT:
            case BinaryExpr.OP_GE:
            case BinaryExpr.OP_LT:
            case BinaryExpr.OP_LE:
                binExpr = new CompareBinaryExpr(expr1, expr2, op);
                break;
            case BinaryExpr.OP_LOGIC_AND:
            case BinaryExpr.OP_LOGIC_OR:
                binExpr = new LogicBinaryExpr(expr1, expr2, op);
                break;
            case BinaryExpr.OP_ADD:
            case BinaryExpr.OP_SUB:
            case BinaryExpr.OP_MUL:
            case BinaryExpr.OP_DIV:
            case BinaryExpr.OP_REM:
                binExpr = new ArithmeticBinaryExpr(expr1, expr2, op);
                break;
            case BinaryExpr.OP_SHIFT_LEFT:
            case BinaryExpr.OP_SHIFT_RIGHT:
            case BinaryExpr.OP_UNSIGNED_SHIFT_RIGHT:
            case BinaryExpr.OP_AND:
            case BinaryExpr.OP_OR:
            case BinaryExpr.OP_XOR:
                binExpr = new BitwiseBinaryExpr(expr1, expr2, op);
                break;
            default:
                throw Exceptions.unexpectedValue(op);
        }
        statementAnalyzer.validateBinaryExpr(binExpr);
        return binExpr;
    }

    protected NodeException createMethodNotFoundException(OffsetRange offset, String className,String methodName,ExprNode[] params){
        Type[] types = AstUtil.getExprTypes(params);
        return new NodeException("method not found:" + MethodUtil.toString(className,methodName, types), offset);
    }

    @Nonnull
    protected ExprNode concatExpressionsToStringExpr(ExprNode[] expr){
        ExprNode ret;
        try {
            ret = new NewObjectExpr(Types.requireClassType("java.lang.StringBuilder"),new ExprNode[0]);
        } catch (MethodNotFoundException | AmbiguousMethodException ex) {
            throw Exceptions.unexpectedException(ex);
        }
        for (ExprNode exprNode : expr) {
            ret = ObjectInvokeExpr.create(ret, "append", new ExprNode[]{exprNode});
        }
        return ObjectInvokeExpr.create(ret,"toString",new ExprNode[0]);
    }

    @Nonnull
    protected ExprNode requireImplicitCast(Type resultType, ExprNode expr,OffsetRange offset) {
        Type exprType = expr.getType();
        ExprNode result = BoxUtil.assign(expr, exprType, resultType);
        if (result == null) {
            throw new NodeException(String.format("%s cannot be converted to %s", exprType,resultType), offset);
        }
        return result;
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

    @Nonnull
    protected ExprNode requireCastToPrimitiveDataType(ExprNode expr, OffsetRange offsetRange) {
        Type oldType = expr.getType();
        expr = BoxUtil.assignToPrimitiveDataType(expr,oldType);
        if (expr == null) {
            throw new NodeException("unable to cast " + oldType + " to primitive type", offsetRange);
        }
        return expr;
    }

    protected int parseModifier(KalangParser.VarModifierContext modifier) {
        int defaultModifier = Modifier.PUBLIC;
        if (modifier == null) {
            return defaultModifier;
        }
        String modifierText = parseTreeToText(modifier);
        if (modifierText.isEmpty()) return defaultModifier;
        try {
            return ModifierUtil.parse(modifierText);
        } catch (InvalidModifierException ex) {
            this.handleSyntaxError(ex.getMessage(), offset(modifier));
            return defaultModifier;
        }
    }

    protected void handleSyntaxError(String desc, OffsetRange offsetRange) {
        diagnosisReporter.report(Diagnosis.Kind.ERROR, desc, offsetRange);
    }

    protected void mapAst(@Nonnull AstNode node, @Nonnull ParserRuleContext tree) {
        node.offset = OffsetRangeHelper.getOffsetRange(tree);
    }

    protected void mapAst(AstNode node,OffsetRange offsetRange, boolean recursive) {
        node.offset = offsetRange;
        if (recursive) {
            List<AstNode> children = node.getChildren();
            for (AstNode c: children) {
                mapAst(c, offsetRange, true);
            }
        }
    }

    protected <T extends AstNode> T mapAst(T node,OffsetRange offsetRange) {
        mapAst(node, offsetRange, false);
        return node;
    }


    @Nullable
    protected ClassNode resolveNamedClass(String id,ClassNode topClass,ClassNode currentClass){
        TypeNameResolver typeNameResolver = compilationUnit.getTypeNameResolver();
        String resolvedName = typeNameResolver.resolve(id, topClass, currentClass);
        return resolvedName==null ? null : getAst(resolvedName);
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
            throw new NodeException(msg,offset(ctx));
        }
        Type[] paramTypes = new Type[paramCount];
        for(int i=0;i<paramTypes.length;i++) {
            paramTypes[i] = this.parseType(paramTypeCtxList.get(i));
        }
        return Types.getFunctionType(returnType, paramTypes, nullable);
    }

    @Nonnull
    protected Type parseType(KalangParser.TypeContext ctx) {
        KalangParser.ClassTypeContext ct = ctx.classType();
        KalangParser.PrimitiveTypeContext pt = ctx.primitiveType();
        if(ct != null){
            return parseClassType(ct);
        }else if(pt != null){
            return Types.getPrimitiveType(pt.getText());
        }else{
            NullableKind nullable = ctx.nullable!=null ? NullableKind.NULLABLE : NullableKind.NONNULL;
            KalangParser.TypeContext t = ctx.type();
            Type cpt = parseType(t);
            return Types.getArrayType(cpt,nullable);
        }
    }

    @Nonnull
    protected ObjectType parseClassType(KalangParser.ClassTypeContext ctx) {
        NullableKind nullable = ctx.nullable == null ? NullableKind.NONNULL : NullableKind.NULLABLE;
        KalangParser.LambdaTypeContext lambdaType = ctx.lambdaType();
        if (lambdaType != null) {
            return this.parseLambdaType(lambdaType);
        }
        Token rawTypeToken = ctx.rawClass;
        List<String> classNameParts = new LinkedList<>();
        for (Token p : ctx.paths) {
            classNameParts.add(p.getText());
        }
        classNameParts.add(rawTypeToken.getText());
        String rawType = String.join(".", classNameParts);
        for (GenericType gt : getCurrentClass().getGenericTypes()) {
            if (rawType.equals(gt.getName())) {
                return gt;
            }
        }
        ObjectType clazzType = requireClassType(rawType, rawTypeToken);
        ClassNode clazzNode = clazzType.getClassNode();
        GenericType[] clzDeclaredGenericTypes = clazzNode.getGenericTypes();
        List<KalangParser.ParameterizedElementTypeContext> parameterTypes = ctx.parameterTypes;
        if (parameterTypes != null && !parameterTypes.isEmpty()) {
            Type[] typeArguments = new Type[parameterTypes.size()];
            if (clzDeclaredGenericTypes.length != parameterTypes.size()) {
                throw new NodeException("wrong number of type arguments", offset(ctx));
            }
            for (int i = 0; i < typeArguments.length; i++) {
                typeArguments[i] = parseParameterizedElementType(parameterTypes.get(i));
                Objects.requireNonNull(typeArguments[i]);
            }
            return Types.getClassType(clazzType.getClassNode(), typeArguments, nullable);
        } else {
            return Types.getClassType(clazzType.getClassNode(), nullable);
        }
    }

    @Nonnull
    protected ObjectType requireClassType(@Nonnull Token token){
        return requireClassType(token.getText(),token);
    }

    @Nonnull
    protected ObjectType requireClassType(@Nonnull String id,@Nonnull Token token){
        ClassNode ast = requireAst(id, token,false);
        return Types.getClassType(ast,new Type[0]);
    }

    @Nonnull
    protected ClassNode requireAst(Token token,boolean fullname){
        return requireAst(token.getText(),token,fullname);
    }

    /**
     * checks whether a class is available
     * @param id
     * @param token
     * @return
     */
    @Nonnull
    protected ClassNode requireAst(String id,Token token,boolean fullname) {
        ClassNode ast;
        if (fullname) {
            ast = getAst(id);
        } else {
            ast = resolveNamedClass(id, getTopClass(), getCurrentClass());
        }
        if(ast == null){
            throw new NodeException("class not found:" + id, offset(token));
        }
        return ast;
    }

    /**
     * checks whether a class is available
     * @param id
     * @return
     */
    @Nonnull
    protected ClassNode requireAst(String id, boolean fullName, OffsetRange offset) {
        ClassNode ast;
        if (fullName) {
            ast = getAst(id);
        } else {
            ast = resolveNamedClass(id, getTopClass(), getCurrentClass());
        }
        if (ast == null) {
            throw new NodeException("class not found:" + id, offset);
        }
        return ast;
    }

    @Nonnull
    protected ExprNode parseLiteral(KalangParser.LiteralContext ctx){
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
            Object constValue;
            try{
                if (Types.INT_TYPE.equals(constType)) {
                    constValue = StringLiteralUtil.parseInteger(t);
                } else  {
                    constValue = StringLiteralUtil.parseLong(t);
                }
            }catch(NumberFormatException ex){
                throw new NodeException("invalid number", offset(ctx));
            }
            ce = new ConstExpr(constValue);
        } else if (ctx.FloatingPointLiteral() != null) {
            Type constType = Types.DOUBLE_TYPE;
            if(t.toUpperCase().endsWith("D")){
                t = t.substring(0,t.length()-1);
                constType = Types.DOUBLE_TYPE;
            }else if(t.toUpperCase().endsWith("F")){
                t = t.substring(0,t.length()-1);
                constType = Types.FLOAT_TYPE;
            }
            Object val;
            try{
                if (Types.FLOAT_TYPE.equals(constType)) {
                    val = Float.parseFloat(t);
                } else {
                    val = Double.parseDouble(t);
                }
            }catch(NumberFormatException ex){
                throw new NodeException("invalid float value", offset(ctx));
            }
            ce = new ConstExpr(val);
        } else if (ctx.BooleanLiteral() != null) {
            ce = new ConstExpr(Boolean.valueOf(t));
        } else if (ctx.CharacterLiteral() != null) {
            ce = new ConstExpr(StringLiteralUtil.parse(t).charAt(1));
        } else if (ctx.StringLiteral() != null) {
            ce = new ConstExpr(StringLiteralUtil.parse(t.substring(1, t.length() - 1)));
        } else if (ctx.MultiLineStringLiteral()!=null){
            ce = new ConstExpr(StringLiteralUtil.parse(t.substring(3,t.length()-3)));
        } else if (ctx.Identifier() != null || ctx.primitiveType() != null){
            boolean isArray = ctx.arrayPrefix != null;
            Type type;
            if (ctx.Identifier() != null) {
                type = requireClassType(ctx.Identifier().getSymbol());
                if (isArray) {
                    type = Types.getArrayType(type);
                }
            } else {
                type = Types.getPrimitiveType(ctx.primitiveType().getText());
                if (isArray) {
                    type = Types.getArrayType(type);
                } else {
                    ObjectType intClassType = requireClassType("Integer", ctx.primitiveType().getStart());
                    Objects.requireNonNull(intClassType);
                    ClassReference clsRef = new ClassReference(intClassType.getClassNode());
                    AssignableExpr staticFieldExpr = getStaticFieldExpr(clsRef, "TYPE", offset(ctx.primitiveType()));
                    Objects.requireNonNull(staticFieldExpr);
                    return staticFieldExpr;
                }
            }
            ce = new ConstExpr(type);
        } else if (ctx.getText().equals("null")) {
            ce = new ConstExpr(null);
        } else {
            throw Exceptions.unexpectedValue(ctx.getText());
        }
        mapAst(ce,ctx);
        return ce;
    }


    @Nonnull
    protected AnnotationNode parseAnnotation(KalangParser.AnnotationContext ctx) {
        ClassNode anType = requireAst(ctx.annotationType,false);
        List<Token> vk = ctx.annotationValueKey;
        KalangParser.LiteralContext dv = ctx.annotationDefaultValue;
        AnnotationNode anNode = new AnnotationNode(anType);
        mapAst(anNode, ctx);
        if(vk!=null && vk.size()>0){
            List<KalangParser.LiteralContext> anValues = ctx.annotationValue;
            int ksize = vk.size();
            for(int i=0;i<ksize;i++){
                String kname = vk.get(i).getText();
                //TODO annotation value may be field
                ConstExpr value = (ConstExpr) parseLiteral(anValues.get(i));
                anNode.values.put(kname, value);
            }
        }else if(dv!=null){
            //TODO annotation value may be field
            ConstExpr defaultValue = (ConstExpr) parseLiteral(dv);
            anNode.values.put("value", defaultValue);
        }
        if(!statementAnalyzer.validateAnnotation(anNode)) return null;
        //TODO validate annotation's values
        return anNode;
    }

    protected List<AnnotationNode> getAnnotations(@Nullable List<KalangParser.AnnotationContext> ctxs){
        List<AnnotationNode> list = new LinkedList<>();
        if(ctxs!=null){
            for(KalangParser.AnnotationContext an:ctxs){
                list.add(parseAnnotation(an));
            }
        }
        return list;
    }

    @Nullable
    protected FieldExpr getObjectFieldExpr(ExprNode expr,String fieldName,OffsetRange offset){
        FieldExpr ret;
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
        mapAst(ret, offset, true);
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

    @Nonnull
    protected ExprNode createBinaryBoolOperateExpr(ExprNode expr1,ExprNode expr2,String op) {
        expr1 = requireCastToPrimitiveDataType(expr1,expr1.offset);
        expr2 = requireCastToPrimitiveDataType(expr2,expr2.offset);
        return constructBinaryExpr(expr1, expr2, op);
    }


    @Nonnull
    protected ExprNode createBinaryMathExpr(ExprNode expr1,ExprNode expr2,String op, OffsetRange offset){
        Type type1 = expr1.getType();
        Type type2 = expr2.getType();
        boolean isPrimitive1 = type1 instanceof PrimitiveType;
        boolean isPrimitive2 = type2 instanceof PrimitiveType;
        PrimitiveType numPriType1 = isPrimitive1 ? (PrimitiveType)type1 : Types.getPrimitiveType((ObjectType)type1);
        PrimitiveType numPriType2 = isPrimitive2 ? (PrimitiveType)type2 : Types.getPrimitiveType((ObjectType)type2);
        if (!MathType.isSupportedType(numPriType1) || !MathType.isSupportedType(numPriType2)) {
            throw new NodeException("Operator \"" + op + "\" could not be applied to " + type1.getName() + " and " + type2.getName(), offset);
        }
        PrimitiveType resultType = MathType.getType(numPriType1, numPriType2);
        expr1 = requireImplicitCast(resultType,requireImplicitCast(numPriType1, expr1, expr1.offset),expr1.offset);
        expr2 = requireImplicitCast(resultType, requireImplicitCast(numPriType2, expr2, expr2.offset), expr2.offset);
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

    protected List<MethodDescriptor> getImportedMixinMethod(String methodName) {
        List<MethodDescriptor> results = new LinkedList<>();
        Collection<MethodDescriptor> staticImportedMds = getImportedMethods(
                compilationUnit.importedMixinMethods
                , compilationUnit.importedMixinPaths
                , methodName
        );
        for(MethodDescriptor m:staticImportedMds) {
            if (AnnotationUtil.has(m.getMethodNode().getAnnotations(), MixinMethod.class.getName())) {
                results.add(m);
            }
        }
        return results;
    }

    protected List<MethodDescriptor> getStaticImportedMethods(String methodName) {
        return getImportedMethods(compilationUnit.staticImportMembers, compilationUnit.staticImportPaths, methodName);
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

    Type inferLambdaType(Type type) {
        if (type instanceof WildcardType) {
            WildcardType wt = (WildcardType) type;
            //TODO handle two lower bounds or more
            Type[] lbs = wt.getLowerBounds();
            if (lbs.length > 1) {
                return type;
            }
            if (lbs.length == 1) {
                return lbs[0];
            }
            Type[] ubs = wt.getUpperBounds();
            if (ubs.length > 1) {
                return type;
            }
            if (ubs.length == 1) {
                return ubs[0];
            }
            return type;
        } else if (type instanceof ClassType) {
            ClassType ct = (ClassType) type;
            Type[] typeArgs = ct.getTypeArguments();
            if (typeArgs.length > 0) {
                Type[] newTypeArgs = new Type[typeArgs.length];
                for(int i = 0; i < newTypeArgs.length; i++) {
                    newTypeArgs[i] = inferLambdaType(typeArgs[i]);
                }
                return Types.getClassType(ct.getClassNode(), newTypeArgs);
            }
            return ct;
        } else if (type instanceof ArrayType) {
            ArrayType at = (ArrayType) type;
            return Types.getArrayType(inferLambdaType(at.getComponentType()));
        } else {
            return type;
        }
    }

    protected VarExpr createSafeAccessibleExpr(ExprNode target, List<Statement> initStmtsHolder) {
        LocalVarNode tmpTarget = declareTempLocalVar(target.getType());
        initStmtsHolder.add(new VarDeclStmt(tmpTarget));
        initStmtsHolder.add(new ExprStmt(new AssignExpr(new VarExpr(tmpTarget),target)));
        return new VarExpr(tmpTarget);
    }

    @Nonnull
    protected ExprNode visitExpression(KalangParser.ExpressionContext expression) {
        Object node = visit(expression);
        if(node instanceof ExprNode){
            return (ExprNode) node;
        }else{
            ExprNode expr;
            if(node instanceof AstNode){
                expr = new ErrorousExpr((AstNode)node);
            }else{
                expr = new ErrorousExpr();
            }
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, "not an expression",offset(expression));
            return expr;
        }
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
        Type[] bounds = new Type[]{classType};
        String boundKind = ctx.boundKind.getText();
        if(boundKind.equals("super")){
            return new WildcardType(new Type[]{Types.getRootType()},bounds);
        }else{
            return new WildcardType(bounds,null);
        }
    }

    @Nullable
    private ClassNode getAst(String className) {
        return compilationUnit.getCompileContext().getAstLoader().getAst(className);
    }

    protected ClassNode loadAst(String className) {
        return compilationUnit.getCompileContext().getAstLoader().loadAst(className);
    }

    protected List<MethodDescriptor> getImportedMethods(Map<String, ClassNode> importedMethods, List<ClassNode> importedPaths, String methodName) {
        ClassNode classOfStaticImport = importedMethods.get(methodName);
        if (classOfStaticImport != null) {
            return getStaticMethods(classOfStaticImport, methodName);
        }
        for (int i = importedPaths.size() - 1; i >= 0; i--) {
            ClassNode sc = importedPaths.get(i);
            List<MethodDescriptor> mds = getStaticMethods(sc, methodName);
            if (!mds.isEmpty()) {
                return mds;
            }
        }
        return Collections.emptyList();
    }

    private MethodNode getPrivateFieldAccessor(FieldNode field, boolean isWriter) {
        Map<FieldNode, MethodNode> accessorMap = isWriter ? privateFieldWriterMap : privateFieldReaderMap;
        MethodNode accessor = accessorMap.get(field);
        if (accessor != null) {
            return accessor;
        }
        ClassNode cn = field.getClassNode();
        MethodNode mn = cn.createMethodNode(field.getType(), "access$" + accessorMap.size(), Modifier.STATIC | Modifier.SYNCHRONIZED);
        ParameterNode objPn = mn.createParameter(Types.getClassType(cn), "obj");
        if (isWriter) {
            ParameterNode valuePn = mn.createParameter(field.getType(), "value");
            mn.getBody().statements.add(new ExprStmt(
                    new AssignExpr(
                            new ObjectFieldExpr(new ParameterExpr(objPn), field)
                            , new ParameterExpr(valuePn)
                    )
            ));
            mn.getBody().statements.add(new ReturnStmt(new ParameterExpr(valuePn)));
        } else {
            mn.getBody().statements.add(new ReturnStmt(
                    new ObjectFieldExpr(new ParameterExpr(objPn), field)
            ));
        }
        accessorMap.put(field, mn);
        return mn;
    }

    private List<Statement> buildFieldInitStmts(boolean isStatic) {
        List<Statement> stmts = new LinkedList<>();
        ClassNode clazz = getCurrentClass();
        for (Map.Entry<FieldNode, KalangParser.ExpressionContext> e: clazz.fieldInitExprMap.entrySet()) {
            FieldNode fn = e.getKey();
            KalangParser.ExpressionContext exprCtx = e.getValue();
            if (isStatic != ModifierUtil.isStatic(fn.getModifier())) {
                continue;
            }
            ExprNode initExpr = requireImplicitCast(fn.getType(), visitExpression(exprCtx), offset(exprCtx));
            ExprStmt initExprStmt;
            if (isStatic) {
                initExprStmt = new ExprStmt(new AssignExpr(new StaticFieldExpr(new ClassReference(clazz), fn), initExpr));
            } else {
                initExprStmt = new ExprStmt(
                        new AssignExpr(new ObjectFieldExpr(new ThisExpr(Types.getClassType(clazz)), fn), initExpr)
                );
            }
            mapAst(initExprStmt, offset(exprCtx), true);
            stmts.add(initExprStmt);
        }
        return stmts;
    }

}
