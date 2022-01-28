package kalang.compiler.compile.semantic;

import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParserBaseVisitor;
import kalang.compiler.ast.*;
import kalang.compiler.compile.CompilationUnit;
import kalang.compiler.compile.Diagnosis;
import kalang.compiler.compile.OffsetRange;
import kalang.compiler.compile.TypeNameResolver;
import kalang.compiler.compile.semantic.analyzer.StatementAnalyzer;
import kalang.compiler.compile.semantic.analyzer.TerminalStatementAnalyzer;
import kalang.compiler.compile.util.DiagnosisReporter;
import kalang.compiler.core.*;
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
import java.util.function.Function;

import static kalang.compiler.util.AstUtil.findGetterByPropertyName;
import static kalang.compiler.util.AstUtil.findSetterByPropertyName;
import static kalang.compiler.util.BoxUtil.requireImplicitCast;
import static kalang.mixin.CollectionMixin.map;

public abstract class AstBuilderBase extends KalangParserBaseVisitor<Object> {

    protected final DiagnosisReporter diagnosisReporter;
    protected final StatementAnalyzer statementAnalyzer;
    private CompilationUnit compilationUnit;

    private Map<FieldNode, MethodNode> privateFieldReaderMap = new HashMap<>();

    private Map<FieldNode, MethodNode> privateFieldWriterMap = new HashMap<>();

    protected TerminalStatementAnalyzer terminalStmtAnalyzer = new TerminalStatementAnalyzer();

    protected MethodContext methodCtx;

    protected Map<LambdaExpr,ParserRuleContext> lambdaExprCtxMap;

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

    public void importStaticMember(ClassNode classNode,@Nullable String name, @Nullable String alias) {
        if (name!=null && !name.isEmpty()) {
            CompilationUnit.MemberImport mi = new CompilationUnit.MemberImport(classNode, name);
            compilationUnit.staticImportMembers.put(alias == null ? name : alias, mi);
        } else {
            compilationUnit.staticImportPaths.add(classNode);
        }
    }

    public void importStaticMember(ClassNode classNode) {
        importStaticMember(classNode, null, null);
    }


    public void importMixinMethod(ClassNode classNode, @Nullable String name, @Nullable String alias) {
        if (name != null && !name.isEmpty()) {
            CompilationUnit.MemberImport mi = new CompilationUnit.MemberImport(classNode, name);
            compilationUnit.importedMixinMethods.put(alias == null ? name : alias, mi);
        } else {
            compilationUnit.importedMixinPaths.add(classNode);
        }
    }

    public void importMixinMethod(ClassNode classNode) {
        importMixinMethod(classNode, null, null);
    }

    protected void buildDefaultMembers(ClassNode clazz) {
        for (ClassNode c : clazz.classes) {
            buildDefaultMembers(c);
        }
        if (!ModifierUtil.isInterface(clazz.getModifier()) && !AstUtil.containsConstructor(clazz)
                && !AstUtil.createEmptyConstructor(clazz)) {
            handleSyntaxError("failed to create constructor with no parameters", clazz.offset);
        }
        if (clazz.isScript) {
            AstUtil.createScriptMainMethodIfNotExists(clazz);
        }
        MethodNode[] methods = clazz.getDeclaredMethodNodes();
        for (MethodNode node : methods) {
            BlockStmt body = node.getBody();
            if (body != null) {
                if (AstUtil.isConstructor(node)) {//constructor
                    if (AstUtil.isNonStaticInnerClass(clazz)) {
                        ClassNode enclosingClass = clazz.enclosingClass;
                        if (enclosingClass == null) {
                            throw Exceptions.unexpectedValue(null);
                        }
                        ParameterNode outerInstanceParam = node.createParameter(0, Types.getClassType(enclosingClass), "this$0");
                        AssignableExpr parentFieldExpr = getObjectFieldExpr(
                                new ThisExpr(Types.getClassType(clazz)), "this$0", OffsetRange.NONE
                        );
                        if (parentFieldExpr == null) {
                            throw Exceptions.unexpectedValue(null);
                        }
                        ExprStmt initThis$0Stmt = new ExprStmt(new AssignExpr(parentFieldExpr, new VarExpr(outerInstanceParam)));
                        AstUtil.mapOffset(initThis$0Stmt, OffsetRange.NONE, true);
                        body.statements.add(1, initThis$0Stmt);
                    }
                }
            }
        }
        for (FieldNode fieldNode : clazz.getFields()) {
            int mdf = fieldNode.getModifier();
            if (Modifier.isStatic(mdf)){
                continue;
            }
            if (!Modifier.isPublic(mdf) && !Modifier.isProtected(mdf)){
                continue;
            }
            if (!AstUtil.hasGetter(clazz, fieldNode)) {
                AstUtil.createGetter(clazz, fieldNode, mdf);
            }
            if (!ModifierUtil.isFinal(fieldNode.getModifier()) && !AstUtil.hasSetter(clazz, fieldNode)) {
                AstUtil.createSetter(clazz, fieldNode, mdf);
            }
            fieldNode.setModifier(ModifierUtil.setPrivate(mdf));
        }
    }

    protected OffsetRange offset(ParserRuleContext ctx) {
        return OffsetRangeHelper.getOffsetRange(ctx);
    }

    protected OffsetRange offset(Token token) {
        return OffsetRangeHelper.getOffsetRange(token);
    }

    protected OffsetRange offset(TerminalNode terminalNode) {
        return OffsetRangeHelper.getOffsetRange(terminalNode.getSymbol());
    }


    protected ExprNode getObjectFieldLikeExpr(
            ExprNode expr,String fieldName, OffsetRange offset, @Nullable ExprNode assignValue, boolean allowGetterOrSetter
    ){

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
                ClassType targetClassType = (ClassType) targetType;
                ClassNode targetClassNode = targetClassType.getClassNode();
                boolean isWrite = assignValue != null;
                if (allowGetterOrSetter) {
                    if (isWrite) {
                        List<MethodDescriptor> setters = findSetterByPropertyName(targetClassType, fieldName
                                , assignValue.getType(), getCurrentClass());
                        if (setters.size() > 1) {
                            List<String> settersDesc = map(setters, it -> MethodUtil.toString(it.getMethodNode()));
                            throw new NodeException("setter is ambiguous:\n" + String.join("\n", settersDesc), offset);
                        } else if (setters.size() == 1) {
                            return mapAst(new ObjectInvokeExpr(expr, setters.get(0), assignValue), offset);
                        }
                    } else {
                        MethodDescriptor getter = findGetterByPropertyName(targetClassType, fieldName, getCurrentClass());
                        if (getter != null) {
                            return mapAst(new ObjectInvokeExpr(expr, getter), offset);
                        }
                    }
                }
                if (!InheritanceUtil.isInnerClassOf(getCurrentClass(), targetClassNode)) {
                    return null;
                }
                FieldNode field = CollectionMixin.find(targetClassNode.getFields(), f -> fieldName.equals(f.getName()));
                if (field == null) {
                    return null;
                }
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
        ExprNode fe = getObjectFieldLikeExpr(expr, fieldName ,offset, assignValue, true);
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
        if (mbody != null && needReturn && !terminalStmtAnalyzer.isTerminalStatement(mbody)) {
            ConstExpr defaultVal = m.getDefaultReturnValue();
            if (defaultVal!=null) {
                ReturnStmt defaultRetStmt = new ReturnStmt(defaultVal);
                AstUtil.mapOffset(defaultRetStmt, OffsetRange.NONE, true);
                mbody.statements.add(defaultRetStmt);
            } else {
                handleSyntaxError("Missing return statement in method:" + MethodUtil.toString(methodCtx.method), OffsetRangeHelper.lastCharOffset(m.offset));
            }
        }
        for (Map.Entry<LambdaExpr, ParserRuleContext> e : lambdaExprCtxMap.entrySet()) {
            handleSyntaxError("Invalid lambda expression", offset(e.getValue()));
        }
    }

    @Nonnull
    protected LocalVarNode declareTempLocalVar(Type type){
        return declareLocalVar("$temp$" + tempVarCounter++, type,0,OffsetRange.NONE);
    }

    @Nonnull
    protected LocalVarNode declareLocalVar(@Nullable String name,Type type,int modifier,OffsetRange offset){
        LocalVarNode localVarNode = new LocalVarNode(type,name,modifier);
        localVarNode.offset = offset;
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

    protected boolean checkVarName(String name, OffsetRange offset) {
        if (isDefinedId(name)) {
            handleSyntaxError("the name is defined already:" + name, offset);
            return false;
        }
        return true;
    }

    protected void enterMethod(MethodNode method, Runnable callback) {
        MethodContext oldMethodCtx = methodCtx;
        Map<LambdaExpr, ParserRuleContext> oldLambdaExprCtxMap = lambdaExprCtxMap;
        try {
            methodCtx = new MethodContext(this.getCurrentClass(), method);
            lambdaExprCtxMap = new HashMap<>();
            callback.run();
        } finally {
            methodCtx = oldMethodCtx;
            lambdaExprCtxMap = oldLambdaExprCtxMap;
        }
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

    protected ExprNode requireCastToObjectType(ExprNode expr, OffsetRange offset) {
        Type oldType = expr.getType();
        expr = BoxUtil.assignToObjectType(expr);
        if (expr == null) {
            throw new NodeException("unable to cast " + oldType + " to object type", offset);
        }
        return expr;
    }

    @SuppressWarnings("unchecked")
    protected <T> T requireExprWithType(ExprNode expr,Class<T> expected, String errMsg) {
        Type type = expr.getType();
        if (!expected.isAssignableFrom(type.getClass())) {
            throw new NodeException(errMsg, expr.offset);
        }
        return (T) type;
    }

    protected long parseModifier(KalangParser.VarModifierContext modifier) {
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

    protected void handleSyntaxWarning(String desc, OffsetRange offsetRange) {
        diagnosisReporter.report(Diagnosis.Kind.WARNING, desc, offsetRange);
    }

    protected void handleSyntaxError(String desc, OffsetRange offsetRange) {
        diagnosisReporter.report(Diagnosis.Kind.ERROR, desc, offsetRange);
    }

    protected void mapAst(@Nonnull AstNode node, @Nonnull ParserRuleContext tree) {
        node.offset = OffsetRangeHelper.getOffsetRange(tree);
    }

    protected void mapAst(@Nonnull AstNode node, @Nonnull Token token) {
        node.offset = OffsetRangeHelper.getOffsetRange(token);
    }

    protected <T extends AstNode> T mapAst(T node,OffsetRange offsetRange, boolean recursive) {
        return AstUtil.mapOffset(node, offsetRange, recursive);
    }

    protected <T extends AstNode> T mapAst(T node,OffsetRange offsetRange) {
        mapAst(node, offsetRange, false);
        return node;
    }


    @Nullable
    protected ClassNode resolveNamedClass(String id){
        TypeNameResolver typeNameResolver = compilationUnit.getTypeNameResolver();
        String resolvedName = typeNameResolver.resolve(id, getTopClass(), getCurrentClass());
        return resolvedName==null ? null : getAst(resolvedName);
    }

    @Nullable
    protected ClassNode resolveQualifiedNamedClass(List<Token> nameTokens, Function<String, ClassNode> nameResolver, boolean reportError) {
        Queue<Token> names = new LinkedList<>(nameTokens);
        StringBuilder nameBuilder = new StringBuilder();
        ClassNode clazzNode;
        for (;;) {
            if (nameBuilder.length() > 0) {
                nameBuilder.append(".");
            }
            Token token = names.peek();
            assert token != null;
            nameBuilder.append(token.getText());
            clazzNode = nameResolver.apply(nameBuilder.toString());
            if (clazzNode != null) {
                names.poll();
                break;
            }
            if (names.size() <= 1) {
                break;
            }
            names.poll();
        }
        if (clazzNode != null) {
            while (!names.isEmpty()) {
                List<ClassNode> subclasses = clazzNode.classes;
                Token symbol = names.peek();
                String expectedName = clazzNode.getName() + "$" + symbol.getText();
                clazzNode = CollectionMixin.find(subclasses, it -> expectedName.equals(it.getName()));
                if (clazzNode == null) {
                    break;
                }
                names.poll();
            }
        }
        if (clazzNode == null && reportError) {
            Token token = names.peek();
            assert token != null;
            handleSyntaxError("Cannot resolve symbol '" + token.getText() + "'", offset(token));
        }
        return clazzNode;
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
    protected GenericType parseGenericType(KalangParser.TypeParameterContext ctx) {
        String name = ctx.Identifier().getText();
        List<KalangParser.ClassTypeContext> bounds = ctx.bounds;
        ObjectType superType = Types.getRootType(NullableKind.UNKNOWN);
        List<ObjectType> interfaces = Collections.emptyList();
        if (bounds != null && !bounds.isEmpty()) {
            interfaces = new ArrayList<>(bounds.size());
            for (int i = 0; i < bounds.size(); i++) {
                KalangParser.ClassTypeContext b = bounds.get(i);
                ObjectType classType = parseClassType(b);
                if (i > 0 && !ModifierUtil.isInterface(classType.getModifier())) {
                    diagnosisReporter.error("interface expected", offset(b));
                    continue;
                }
                if (ModifierUtil.isInterface(classType.getModifier())) {
                    interfaces.add(classType);
                } else {
                    superType = classType;
                }
            }
        }
        return new GenericType(name, superType, interfaces.toArray(new ObjectType[0]), NullableKind.UNKNOWN);
    }

    @Nonnull
    protected ObjectType parseClassType(KalangParser.ClassTypeContext ctx) {
        NullableKind nullable = ctx.nullable == null ? NullableKind.NONNULL : NullableKind.NULLABLE;
        KalangParser.LambdaTypeContext lambdaType = ctx.lambdaType();
        if (lambdaType != null) {
            return this.parseLambdaType(lambdaType);
        }
        List<Token> names = ctx.qualifiedName().names;
        if (names.size() == 1) {
            Token name = names.get(0);
            assert name != null;
            GenericType[] allGenericTypes = getCurrentClass().getGenericTypes();
            if (methodCtx != null) {
                allGenericTypes = CollectionMixin.concat(allGenericTypes, methodCtx.method.getGenericTypes());
            }
            GenericType gt = CollectionMixin.find(
                    allGenericTypes,
                    it -> name.getText().equals(it.getName())
            );
            if (gt != null) {
                return gt;
            }
        }
        ClassNode clazzNode = resolveQualifiedNamedClass(names, this::resolveNamedClass, true);
        if (clazzNode == null) {
            return Types.getRootType(NullableKind.UNKNOWN);
        }
        ObjectType clazzType = Types.getClassType(clazzNode);
        GenericType[] clzDeclaredGenericTypes = clazzNode.getGenericTypes();
        boolean isRawType = ctx.typeArgsPrefix == null;
        if (isRawType) {
            return Types.getClassType(clazzType.getClassNode(), nullable);
        }
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
            return Types.getClassType(clazzType.getClassNode(), clzDeclaredGenericTypes, nullable);
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
            ast = resolveNamedClass(id);
        }
        if(ast == null){
            diagnosisReporter.error("class not found:" + id, offset(token));
            return Types.getRootType(NullableKind.UNKNOWN).getClassNode();
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
            ast = resolveNamedClass(id);
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
            ce = new ConstExpr(parseStringLiteral(ctx.CharacterLiteral(), 1, 1).charAt(0));
        } else if (ctx.StringLiteral() != null) {
            ce = new ConstExpr(parseStringLiteral(ctx.StringLiteral(), 1,1));
        } else if (ctx.MultiLineStringLiteral()!=null){
            ce = new ConstExpr(parseStringLiteral(ctx.MultiLineStringLiteral(), 3,3));
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

    protected String parseStringLiteral(TerminalNode node, int leftWrapperLen, int rightWrapperLen) {
        String text = node.getText();
        try {
            return StringLiteralUtil.parse(text.substring(leftWrapperLen, text.length() - rightWrapperLen));
        } catch (IllegalArgumentException ex) {
            throw new NodeException(ex.getMessage(), offset(node.getSymbol()));
        }
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
        statementAnalyzer.validateAnnotation(anNode);
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
        if (Modifier.isAbstract(clazz.getModifier())) {
            return;
        }
        Map<MethodDescriptor, MethodNode> implementationMap = ImplementationUtil.getImplementationMap(clazz);
        for(Map.Entry<MethodDescriptor,MethodNode> e:implementationMap.entrySet()) {
            MethodDescriptor interfaceMethod = e.getKey();
            MethodNode implementedMethod = e.getValue();
            if (implementedMethod == null && Modifier.isAbstract(interfaceMethod.getModifier())) {
                String msg = String.format(
                        "please override abstract method %s in %s",
                        interfaceMethod.toString()
                        , interfaceMethod.getMethodNode().getClassNode().getName()
                );
                diagnosisReporter.report(Diagnosis.Kind.ERROR,msg, clazz.offset);
            }
        }
    }

    protected List<MethodDescriptor> getImportedMixinMethod(String methodName) {
        return getImportedMethods(
                compilationUnit.importedMixinMethods
                , compilationUnit.importedMixinPaths
                , methodName
        );
    }

    protected List<MethodDescriptor> getStaticImportedMethods(String methodName) {
        return getImportedMethods(compilationUnit.staticImportMembers, compilationUnit.staticImportPaths, methodName);
    }

    protected AstNodeMaker<AssignableExpr> getSafeAccessorForAssignableExpr(AssignableExpr expr, List<Statement> initStmtsHolder) {
        OffsetRange offset = expr.offset;
        if (expr instanceof ObjectFieldExpr) {
            ObjectFieldExpr fe = (ObjectFieldExpr) expr;
            ExprNode originTarget = fe.getTarget();
            AstNodeMaker<VarExpr> targetAccessor = createSafeAccessor(originTarget, initStmtsHolder);
            return () -> mapAst(new ObjectFieldExpr(targetAccessor.make(), fe.getField()), offset);
        } else if (expr instanceof ElementExpr) {
            //element execute order:array -> index
            ElementExpr eleExpr = (ElementExpr) expr;
            ExprNode arrayExpr = eleExpr.getArrayExpr();
            ExprNode indexExpr = eleExpr.getIndex();
            AstNodeMaker<VarExpr> arrayAccessor = createSafeAccessor(arrayExpr, initStmtsHolder);
            AstNodeMaker<VarExpr> indexAccessor = createSafeAccessor(indexExpr, initStmtsHolder);
            return () -> mapAst(new ElementExpr(arrayAccessor.make(), indexAccessor.make()),offset);
        } else if (expr instanceof VarExpr) {
            return () -> mapAst(new VarExpr(((VarExpr) expr).getVar(), expr.getType()), offset);
        } else if (expr instanceof StaticFieldExpr) {
            StaticFieldExpr se = (StaticFieldExpr) expr;
            return () -> mapAst(new StaticFieldExpr(se.getClassReference(), se.getField()), offset);
        }  else {
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

    protected AstNodeMaker<VarExpr> createSafeAccessor(ExprNode target, List<Statement> initStmtsHolder) {
        LocalVarNode tmpTarget = declareTempLocalVar(target.getType());
        initStmtsHolder.add(new VarDeclStmt(tmpTarget));
        initStmtsHolder.add(new ExprStmt(new AssignExpr(new VarExpr(tmpTarget),target)));
        return () -> mapAst(new VarExpr(tmpTarget), target.offset);
    }

    @Override
    public Object visit(ParseTree tree) {
        Object node = super.visit(tree);
        if (node instanceof AstNode) {
            AstNode astNode = (AstNode) node;
            OffsetRange offset = OffsetRange.NONE;
            if (tree instanceof ParserRuleContext) {
                offset = offset((ParserRuleContext) tree);
            }
            mapAst(astNode, offset, true);
        }
        return node;
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

    protected void markStructureFinished(ClassNode clazz) {
        clazz.isStructureFinished = true;
        for (ClassNode c : clazz.classes) {
            markStructureFinished(c);
        }
    }

    private boolean isSafeAccessibleExpr(ExprNode expr) {
        return expr instanceof VarExpr
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
        Token boundKind = ctx.boundKind;
        if(boundKind != null && boundKind.getText().equals("super")){
            return new WildcardType(
                    new Type[]{Types.getRootType(NullableKind.UNKNOWN)},
                    new Type[]{parseClassType(ctx.classType())},
                    NullableKind.UNKNOWN
            );
        } else {
            Type upperBound = boundKind != null
                    ? parseClassType(ctx.classType())
                    : Types.getRootType(NullableKind.UNKNOWN);
            return new WildcardType(new Type[]{upperBound},null, NullableKind.UNKNOWN);
        }
    }

    @Nullable
    protected ClassNode getAst(String className) {
        return compilationUnit.getCompileContext().getClassNodeLoader().getClassNode(className);
    }

    protected ClassNode loadAst(String className) {
        return compilationUnit.getCompileContext().getClassNodeLoader().loadClassNode(className);
    }

    protected List<MethodDescriptor> getImportedMethods(Map<String, CompilationUnit.MemberImport> importedMethods, List<ClassNode> importedPaths, String methodName) {
        CompilationUnit.MemberImport classOfStaticImport = importedMethods.get(methodName);
        if (classOfStaticImport != null) {
            return getStaticMethods(classOfStaticImport.classNode, classOfStaticImport.member);
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
        BlockStmt mnBody = new BlockStmt();
        MethodNode mn = cn.createMethodNode(field.getType(), "access$" + accessorMap.size(), Modifier.STATIC | Modifier.SYNCHRONIZED, mnBody);
        ParameterNode objPn = mn.createParameter(Types.getClassType(cn), "obj");
        if (isWriter) {
            ParameterNode valuePn = mn.createParameter(field.getType(), "value");
            mnBody.statements.add(new ExprStmt(
                    new AssignExpr(
                            new ObjectFieldExpr(new VarExpr(objPn), field)
                            , new VarExpr(valuePn)
                    )
            ));
            mnBody.statements.add(new ReturnStmt(new VarExpr(valuePn)));
        } else {
            mnBody.statements.add(new ReturnStmt(
                    new ObjectFieldExpr(new VarExpr(objPn), field)
            ));
        }
        accessorMap.put(field, mn);
        AstUtil.mapOffset(mn, field.offset, true);
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
