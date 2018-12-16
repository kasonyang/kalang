package kalang.compiler.compile;

import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.FieldNotFoundException;
import kalang.compiler.MethodNotFoundException;
import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParser.*;
import kalang.compiler.antlr.KalangParserVisitor;
import kalang.compiler.ast.*;
import kalang.compiler.core.*;
import kalang.compiler.exception.Exceptions;
import kalang.compiler.function.FunctionType;
import kalang.compiler.function.LambdaExpr;
import kalang.compiler.util.*;
import kalang.type.FunctionClasses;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 *  build ast from antlr parse tree
 * 
 * @author Kason Yang
 */
public class AstBuilder extends AbstractParseTreeVisitor implements KalangParserVisitor {

    private ClassNodeBuilder classNodeBuilder;
    private ClassNodeMetaBuilder classNodeMetaBuilder;
    
    private DiagnosisReporter diagnosisReporter;
    
    private SemanticAnalyzer semanticAnalyzer;
    
    private Map<LambdaExpr,KalangParser.LambdaExprContext> lambdaExprCtxMap = new HashMap();

    private Map<String,ClassNode> staticImportMembers = new HashMap<>();

    private List<ClassNode> staticImportPaths = new LinkedList<>();
    
    //private Map<MethodNode,List<StatContext>> lambdaStatMap = new HashMap();
    
    private int anonymousClassCounter = 0;

    @Override
    public Object visitEmptyStat(KalangParser.EmptyStatContext ctx) {
        BlockStmt b = this.newBlock();
        this.popBlock();
        return b;
    }

    @Override
    public Object visitAssertStmt(KalangParser.AssertStmtContext ctx) {
        ExprNode failExpr = visitExpression(ctx.testCondition);
        if (failExpr == null) return null;
        failExpr = BoxUtil.assign(failExpr, failExpr.getType(), Types.BOOLEAN_TYPE);
        if (failExpr == null){
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, "boolean type expected" , ctx.testCondition);
            return null;
        }
        failExpr = new UnaryExpr(failExpr,UnaryExpr.OPERATION_LOGIC_NOT);
        ExprNode failMsgExpr = null;
        if ( ctx.failMessage!=null ){
            failMsgExpr = visitExpression(ctx.failMessage);
            if (failMsgExpr == null) return null;
            if (Types.VOID_TYPE.equals(failMsgExpr.getType())){
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, "non-void type expected",ctx.failMessage);
                return null;
            }
        }
        BlockStmt body = this.newBlock();
        NewObjectExpr newErrorExpr;
        try {
            newErrorExpr = new NewObjectExpr(
                Types.requireAssertionErrorClassType()
                , failMsgExpr != null ? new ExprNode[]{failMsgExpr} : new ExprNode[0]
            );
        }catch(MethodNotFoundException|AmbiguousMethodException ex){
            throw Exceptions.unexceptedException(ex);
        }
        body.statements.add(new ThrowStmt(newErrorExpr));
        popBlock();
        return new IfStmt(failExpr,body,null);
    }
    
    static class VarInfo{
        public Type type;
        public String name;
        public int modifier;
    }
    
    public static final int 
            PARSING_PHASE_INIT = 1,
            PARSING_PHASE_META = 2,
            PARSING_PHASE_ALL = 3;
   
    private int parsingPhase=0;
    //static String DEFAULT_VAR_TYPE;// = "java.lang.Object";
    
    protected ClassNode thisClazz;
    
    private ClassNode topClass;
    
    private boolean returned = false;
    
    private MethodNode method;
    
    private VarTable<VarObject,Type> overrideTypes = new VarTable();
    
    //TODO merge SemanticAnalyzer.assignedVars
    //private VarTable<VarObject,NullableKind> assignedNullables = new VarTable();
    
    //private VarTable<VarObject,Boolean> mustNullorNonnull = new VarTable();
    
    private static final int NULLSTATE_MUST_NULL = 0,
            NULLSTATE_MUST_NONNULL = 1,
            NULLSTATE_UNKNOWN = 2,
            NULLSTATE_NULLABLE = 3;
    
    private VarTable<VarObject,Integer> nullState = new VarTable();
    
    private VarTable<String,LocalVarNode> varTables = new VarTable();
    //private final HashMap<MethodNode,BlockStmtContext> methodBodys = new HashMap<>();

    @Nonnull
    private AstLoader astLoader;
    
    private final TypeNameResolver typeNameResolver = new TypeNameResolver();

    private ParserRuleContext compilationContext;

    @Nonnull
    private TokenStream tokenStream;

    @Nonnull
    private final String className;
        
    @Nonnull
    private KalangParser parser;
    
    private final CompilationUnit compilationUnit;
    
    private void newOverrideTypeStack(){
        overrideTypes = new VarTable(overrideTypes);
    }
    
    private void popOverrideTypeStack(){
        overrideTypes = overrideTypes.getParent();
    }
    
    private void removeOverrideType(ExprNode expr){
        VarObject key = getOverrideTypeKey(expr);
        if(key!=null) overrideTypes.remove(key, true);
    }
    
    @Nullable
    private VarObject getOverrideTypeKey(ExprNode expr){
        VarObject key ;
        //It isn't supported to override type of field because it is not safe
        if(expr instanceof VarExpr){
            key = ((VarExpr) expr).getVar();
        }else if(expr instanceof ParameterExpr){
            key = ((ParameterExpr) expr).getParameter();
        }else{
            key = null;
        }
        return key;
    }
    
    private void changeTypeTemporarilyIfCould(ExprNode expr,Type type){
        VarObject key = getOverrideTypeKey(expr);
        if(key!=null){
            overrideTypes.put(key, type);
        }
    }
    
    private void onNull(ExprNode expr,boolean onTrue,boolean isEQ){
        boolean mustNull = (onTrue && isEQ) || (!onTrue && !isEQ);
        VarObject key = this.getOverrideTypeKey(expr);
        if(key!=null){
            nullState.put(key,mustNull ? NULLSTATE_MUST_NULL : NULLSTATE_MUST_NONNULL);
        }
    }
    
    protected void onIf(ExprNode expr,boolean onTrue){
        if(expr instanceof InstanceOfExpr && onTrue){
            InstanceOfExpr ie = (InstanceOfExpr) expr;
            changeTypeTemporarilyIfCould(ie.getExpr(),Types.getClassType(ie.getTarget().getReferencedClassNode()));
        } else if(expr instanceof CompareExpr) {
            CompareExpr ce = (CompareExpr) expr;
            ExprNode e1 = ce.getExpr1();
            ExprNode e2 = ce.getExpr2();
            boolean isEQ = ce.getOperation().equals(CompareExpr.OP_EQ);
            if (e1.getType().equals(Types.NULL_TYPE)) {
                onNull(e2, onTrue, isEQ);
            } else if (e2.getType().equals(Types.NULL_TYPE)) {
                onNull(e1, onTrue, isEQ);
            }
        } else if (expr instanceof StaticInvokeExpr) {
            StaticInvokeExpr sie = (StaticInvokeExpr) expr;
            ExprNode[] args = sie.getArguments();
            if (args==null || args.length != 2) {
                return;
            }
            String invokeClass = sie.getInvokeClass().getReferencedClassNode().name;
            if (!Objects.class.getName().equals(invokeClass)) {
                return;
            }
            String methodName = sie.getMethod().getName();
            if (!"equals".equals(methodName) && !"deepEquals".equals(methodName)) {
                return;
            }
            if (Types.NULL_TYPE.equals(args[0].getType())) {
                onNull(args[1],onTrue,true);
            } else if (Types.NULL_TYPE.equals(args[1].getType())) {
                onNull(args[0],onTrue,true);
            }
        } else if(expr instanceof UnaryExpr){
            onIf(((UnaryExpr) expr).getExpr(),!onTrue);
        } else if(expr instanceof LogicExpr){
            LogicExpr le = (LogicExpr) expr;
            if(le.getOperation().equals(LogicExpr.OP_LOGIC_AND)){
                if(onTrue){
                    onIf(le.getExpr1(),true);
                    onIf(le.getExpr2(),true);
                }
            }else if(le.getOperation().equals(LogicExpr.OP_LOGIC_OR)){
                if(!onTrue){
                    onIf(le.getExpr1(),false);
                    onIf(le.getExpr2(),false);
                }
            }
        }
        
    }
    
    public ParserRuleContext getParseTree(){
        return compilationContext;
    }

    @Nonnull
    public String getClassName() {
        return className;
    }
    
    @Nullable
    private ClassReference requireClassReference(@Nonnull Token token){
        ClassNode ast = requireAst(token);
        if(ast==null) return null;
        return new ClassReference(ast);
    }
    
    @Nullable
    protected ObjectType requireClassType(@Nonnull Token token){
        return requireClassType(token.getText(),token);
    }
    
    @Nullable
    private ObjectType requireClassType(@Nonnull String id,@Nonnull Token token){
        ClassNode ast = requireAst(id, token);
        if(ast==null) return null;
        return Types.getClassType(ast,new Type[0]);
    }

    public void compile(){
        compile(PARSING_PHASE_ALL,null);
    }
    
    public void compile(int targetPhase){
        compile(targetPhase, null);
    }
    
    public void compile(int targetPhase,@Nullable AstLoader astLoader) {
        if(astLoader==null){
            this.astLoader = new AstLoader();
        }else{
            this.astLoader = astLoader;
        }
        this.typeNameResolver.setAstLoader(astLoader);
        this.semanticAnalyzer = new SemanticAnalyzer(compilationUnit, astLoader);
        if(targetPhase>=PARSING_PHASE_INIT && parsingPhase < PARSING_PHASE_INIT){
            parsingPhase = PARSING_PHASE_INIT;
            CompilationUnitContext cunit = parser.compilationUnit();
            this.compilationContext = cunit;
            for(ImportDeclContext ic:cunit.importDecl()){
                this.visitImportDecl(ic);
            }
            this.classNodeBuilder = new ClassNodeBuilder(this.compilationUnit,this);
            topClass = classNodeBuilder.build(cunit);
        }
        if(targetPhase>=PARSING_PHASE_META
                && parsingPhase < PARSING_PHASE_META){
            parsingPhase = PARSING_PHASE_META;
            this.classNodeMetaBuilder = new ClassNodeMetaBuilder(this.compilationUnit, this, classNodeBuilder);
            classNodeMetaBuilder.build(topClass, classNodeBuilder.isScript());
        }
        if(targetPhase>=PARSING_PHASE_ALL
                && parsingPhase < PARSING_PHASE_ALL){
            parsingPhase = PARSING_PHASE_ALL;
            visitMethods(topClass);
            processConstructor(topClass);
            buildLambdaExpressions(topClass);
            checkAndBuildInterfaceMethods(topClass);
        }
    }
    
    private void visitMethods(ClassNode clazz){
        thisClazz = clazz;
        for(MethodNode m:thisClazz.getDeclaredMethodNodes()){
            BlockStmt mbody = m.getBody();
            StatContext[] stats = classNodeMetaBuilder.getStatContexts(m);
            if(stats!=null){
                enterMethod(m);
                visitBlockStmt(stats,mbody);
                checkMethod();
            }
        }
        for(ClassNode c:clazz.classes){
            this.visitMethods(c);
        }
    }

    public AstBuilder(@Nonnull CompilationUnit compilationUnit, @Nonnull KalangParser parser) {
        this.compilationUnit = compilationUnit;
        this.className = compilationUnit.getSource().getClassName();
        this.parser = parser;
        tokenStream = parser.getTokenStream();
        this.diagnosisReporter = new DiagnosisReporter(compilationUnit);
    }
    
    @Nonnull
    private String getPackageName(){
        if (className.contains(".")) {
            return className.substring(0, className.lastIndexOf('.'));
        }
        return "";
    }    
        
    @Override
    public String toString(){
        return getClass().getName() + ":" + className;
    }

    @Nonnull
    public AstLoader getAstLoader() {
        return astLoader;
    }

    @Nonnull
    public TokenStream getTokenStream() {
        return tokenStream;
    }

    @Nonnull
    public KalangParser getParser() {
        return parser;
    }
    
    @Nullable
    private ClassNode requireAst(Token token){
        return requireAst(token.getText(),token);
    }

    /**
     * checks whether a class is available
     * @param id
     * @param token
     * @return 
     */
    @Nullable
    private ClassNode requireAst(String id,Token token) {
        String resolvedName = this.typeNameResolver.resolve(id, topClass, thisClazz);
        ClassNode ast = resolvedName==null ? null : astLoader.getAst(resolvedName);
        if(ast==null){
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "class not found:" + id, token);
        }
        return ast;
    }
    
    @Nullable
    private ClassNode getAst(String id){
        String resolvedName = this.typeNameResolver.resolve(id, topClass, thisClazz);
        ClassNode ast = resolvedName==null ? null : astLoader.getAst(resolvedName);
        return ast;
    }
    
    @Nullable
    protected ObjectType parseClassType(KalangParser.ClassTypeContext ctx){
        NullableKind nullable = ctx.nullable==null ? NullableKind.NONNULL : NullableKind.NULLABLE;
        KalangParser.LambdaTypeContext lambdaType = ctx.lambdaType();
        if (lambdaType!=null) {
            return this.visitLambdaType(lambdaType);
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
        for(GenericType gt:thisClazz.getGenericTypes()){
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

    @Override
    public ObjectType visitLambdaType(KalangParser.LambdaTypeContext ctx) {
        NullableKind nullable = ctx.nullable==null ? NullableKind.NONNULL : NullableKind.NULLABLE;
        TypeContext returnTypeCtx = ctx.returnType;
        Type returnType = this.parseType(returnTypeCtx);
        List<TypeContext> paramTypeCtxList = ctx.paramsTypes;
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
    protected Type parseType(TypeContext ctx) {
        KalangParser.ClassTypeContext ct = ctx.classType();
        KalangParser.PrimitiveTypeContext pt = ctx.primitiveType();
        if(ct!=null){
            return parseClassType(ct);
        }else if(pt!=null){
            return Types.getPrimitiveType(pt.getText());
        }else{
            NullableKind nullable = ctx.nullable!=null ? NullableKind.NULLABLE : NullableKind.NONNULL;
            TypeContext t = ctx.type();
            Type cpt = parseType(t);
            if(cpt==null) return null;
            return Types.getArrayType(cpt,nullable);
        }
    }

    @Override
    public Object visit(ParseTree tree) {
        if (tree == null) {
            System.err.print("visit null");
            Exception ex = new Exception();
            ex.printStackTrace(System.err);
            return null;
        }
        if(tree instanceof StatContext && returned){
            diagnosisReporter.report(Diagnosis.Kind.ERROR
                    ,"unreachable statement"
                    , (StatContext) tree
            );
        }
        return super.visit(tree);
    }

    public void importPackage(@Nonnull String packageName) {
        this.typeNameResolver.importPackage(packageName);
    }
    
    BlockStmt wrapBlock(Statement... statms){
        BlockStmt bs = newBlock();
        bs.statements.addAll(Arrays.asList(statms));
        popBlock();
        return bs;
    }
    
    private void newFrame(){
        this.varTables = this.varTables.newStack();
    }
    
    private void popFrame(){
        this.varTables = this.varTables.popStack();
    }
    
    BlockStmt newBlock(){
        BlockStmt bs = new BlockStmt();
        this.newFrame();
        return bs;
    }
    
    void popBlock(){
        this.popFrame();
    }

    @Nonnull
    public ClassNode getAst() {
        return this.topClass;
    }
    
    protected void mapAst(@Nonnull AstNode node,@Nonnull ParserRuleContext tree){
         node.offset = OffsetRangeHelper.getOffsetRange(tree);
    }
    
    protected void mapAst(@Nonnull AstNode node,@Nonnull Token token){
        node.offset = OffsetRangeHelper.getOffsetRange(token);
    }
    
    @Override
    public ThrowStmt visitThrowStat(KalangParser.ThrowStatContext ctx) {
        ThrowStmt ts = new ThrowStmt(visitExpression(ctx.expression()));
        mapAst(ts, ctx);
        this.returned = true;
        return ts;
    }

    @Override
    public MultiStmtExpr visitMapExpr(KalangParser.MapExprContext ctx) {
        List<ExpressionContext> keys = ctx.keys;
        List<ExpressionContext> values = ctx.values;
        ExprNode[] keyExprs = new ExprNode[keys.size()];
        ExprNode[] valuesExprs = new ExprNode[values.size()];
        for (int i = 0; i < keys.size(); i++) {
            ExpressionContext ke = keys.get(i);
            ExpressionContext e = values.get(i);
            ExprNode k = visitExpression(ke);
            if (k==null) {
                return null;
            }
            ExprNode v = visitExpression(e);
            if (v==null) {
                return null;
            }
            keyExprs[i] = k;
            valuesExprs[i] = v;
        }
        Type[] valuesTypes = AstUtil.getExprTypes(valuesExprs);
        Objects.requireNonNull(valuesTypes);
        Type[] keyTypes = AstUtil.getExprTypes(keyExprs);
        Objects.requireNonNull(keyTypes);
        ObjectType keyType = ctx.keyType != null
                ? requireClassType(ctx.keyType)
                : getTypeForGeneric(TypeUtil.getCommonType(keyTypes));
        ObjectType valueType = ctx.valueType != null
                ? requireClassType(ctx.valueType)
                : getTypeForGeneric(TypeUtil.getCommonType(valuesTypes));
        if(keyType==null || valueType == null) return null;
        LocalVarNode vo = declareTempLocalVar(Types.getClassType(Types.getMapImplClassType().getClassNode(),new Type[]{keyType,valueType}));
        VarDeclStmt vds = new VarDeclStmt(vo);
        NewObjectExpr newExpr;
        try {
            newExpr = new NewObjectExpr(Types.getMapImplClassType());
        } catch (MethodNotFoundException|AmbiguousMethodException ex) {
            throw Exceptions.unexceptedException(ex);
        }
        List<Statement> stmts = new LinkedList<>();
        stmts.add(vds);
        stmts.add(new ExprStmt(new AssignExpr(new VarExpr(vo), newExpr)));
        VarExpr ve = new VarExpr(vo);
        for(int i=0;i<keyExprs.length;i++) {
            ExprNode[] args = new ExprNode[]{keyExprs[i],valuesExprs[i]};
            InvocationExpr iv;
            try {
                iv = ObjectInvokeExpr.create(ve, "put",args);
            } catch (MethodNotFoundException|AmbiguousMethodException ex) {
                throw Exceptions.unexceptedException(ex);
            }
            ExprStmt es = new ExprStmt(iv);
            stmts.add(es);
        }
        MultiStmtExpr mse = new MultiStmtExpr(stmts, ve);
        mapAst(mse,ctx);
        return mse;
    }

    @Override
    public ExprNode visitNewArrayExpr(KalangParser.NewArrayExprContext ctx) {
        Type type = parseType(ctx.type());
        ExprNode ret;
        if(ctx.size!=null){
            ExprNode size = visitExpression(ctx.size);
            ret = new NewArrayExpr(type,size);
        }else{
            ExprNode[] initExprs = new ExprNode[ctx.initExpr.size()];
            for(int i=0;i<initExprs.length;i++){
                initExprs[i] = visitExpression(ctx.initExpr.get(i));
            }
            ret= createInitializedArray(type, initExprs);
        }
        mapAst(ret, ctx);
        return ret;
    }

    @Override
    public AstNode visitQuestionExpr(KalangParser.QuestionExprContext ctx) {
        List<Statement> stmts = new LinkedList<>();
        ExprNode conditionExpr = (ExprNode) visit(ctx.expression(0));
        newOverrideTypeStack();
        onIf(conditionExpr,true);
        ExprNode trueExpr = (ExprNode) visit(ctx.expression(1));
        popOverrideTypeStack();
        newOverrideTypeStack();
        onIf(conditionExpr,false);
        ExprNode falseExpr = (ExprNode)  visit(ctx.expression(2));
        popOverrideTypeStack();
        Type trueType = trueExpr.getType();
        Type falseType  = falseExpr.getType();
        Type type;
        if(trueType.equals(falseType)){
            type = trueType;
        }else{
            type = TypeUtil.getCommonType(trueType,falseType);
        }
        LocalVarNode vo = this.declareTempLocalVar(type);
        VarDeclStmt vds = new VarDeclStmt(vo);
        stmts.add(vds);
        VarExpr ve = new VarExpr(vo);
        IfStmt is = new IfStmt(conditionExpr);
        is.getTrueBody().statements.add(new ExprStmt(new AssignExpr(ve, trueExpr)));
        is.getFalseBody().statements.add(new ExprStmt(new AssignExpr(ve,falseExpr)));
        stmts.add(is);
        MultiStmtExpr mse = new MultiStmtExpr(stmts, ve);
        mapAst(ve, ctx);
        return mse;
    }

    @Override
    public AstNode visitPostIfStmt(KalangParser.PostIfStmtContext ctx) {
        ExprNode leftExpr = visitExpression(ctx.expression(0));
        if (!(leftExpr instanceof AssignExpr)) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR, "AssignExpr required", ctx);
        }
        AssignExpr assignExpr = (AssignExpr) leftExpr;
        AssignableExpr to = assignExpr.getTo();
        ExprNode from = assignExpr.getFrom();
        ExprNode cond = visitExpression(ctx.expression(1));
        Token op = ctx.op;
        if (op != null) {
            String opStr = op.getText();
            //TODO check type
            cond = this.createBinaryMathExpr(to, cond, opStr);
        }
        AssignExpr as = new AssignExpr(to, from);
        IfStmt is = new IfStmt(cond);
        is.getTrueBody().statements.add(new ExprStmt(as));
        mapAst(is,ctx);
        return is;
    }

    @Override
    public AstNode visitCompilationUnit(CompilationUnitContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public AstNode visitClassBody(ClassBodyContext ctx) {
        this.visitChildren(ctx);
        mapAst(thisClazz, ctx);
        return null;
    }

    @Override
    public Void visitFieldDecl(FieldDeclContext ctx) {
        int fieldModifier = this.parseModifier(ctx.varModifier());
        for(VarDeclContext vd:ctx.varDecl()){
            ExprNode initExpr;
            if(vd.expression()!=null){
                initExpr = visitExpression(vd.expression());
            }else{
                initExpr = null;
            }
            VarInfo varInfo = varDecl(vd,initExpr==null
                    ?Types.getRootType()
                    :initExpr.getType()
            );
            varInfo.modifier |= fieldModifier;
            FieldNode fieldNode = thisClazz.createField(varInfo.type, varInfo.name,varInfo.modifier);
            //TODO simplify it
            if(initExpr!=null){
                if(AstUtil.isStatic(fieldNode.modifier)){
                    thisClazz.staticInitStmts.add(new ExprStmt(new AssignExpr(new StaticFieldExpr(new ClassReference(thisClazz), fieldNode), initExpr)));
                }else{
                    thisClazz.initStmts.add(new ExprStmt(new AssignExpr(new ObjectFieldExpr(new ThisExpr(getThisType()), fieldNode), initExpr)));
                }
            }
        }
        return null;
    }
    
    private boolean isNonStaticInnerClass(ClassNode clazz){
        return clazz.enclosingClass!=null && !Modifier.isStatic(clazz.modifier);
    }
    
    private boolean isDeclaringNonStaticInnerClass(){
        return isNonStaticInnerClass(thisClazz);
    }

    @Override
    public AstNode visitMethodDecl(MethodDeclContext ctx) {
        throw Exceptions.unexceptedException("");
    }

    @Override
    public AstNode visitType(TypeContext ctx) {
        //do nothing
        return null;
    }

    public List<Object> visitAll(List<? extends ParserRuleContext> list) {
        List<Object> ret = new ArrayList<>(list.size());
        for (ParserRuleContext i : list) {
            ret.add(visit(i));
        }
        return ret;
    }

    @Override
    public AstNode visitIfStat(IfStatContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        if (expr == null){
            return null;
        }
        Type exprType = expr.getType();
        expr = BoxUtil.assign(expr, expr.getType(), Types.BOOLEAN_TYPE);
        if (expr == null) {
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, exprType + " cannot be converted to boolean", ctx.expression());
            return null;
        }
        BlockStmt trueBody = null;
        BlockStmt falseBody = null;
        VarTable<VarObject,Integer> trueAssigned,falseAssigned;
        this.nullState = trueAssigned = this.nullState.newStack();
        newOverrideTypeStack();
        onIf(expr, true);
        if (ctx.trueStmt != null) {
            trueBody=requireBlock(ctx.trueStmt);
        }
        popOverrideTypeStack();
        this.nullState = this.nullState.popStack();
        boolean trueReturned = this.returned;
        this.returned = false;
        this.nullState = falseAssigned = this.nullState.newStack();
        newOverrideTypeStack();
        onIf(expr,false);
        if (ctx.falseStmt != null) {
            falseBody=requireBlock(ctx.falseStmt);
        }
        popOverrideTypeStack();
        this.nullState = this.nullState.popStack();
        handleMultiBranchedAssign(trueAssigned.vars(),falseAssigned.vars());
        boolean falseReturned = this.returned;
        if(trueReturned) onIf(expr,false);
        if(falseReturned) onIf(expr,true);
        this.returned = falseReturned && trueReturned;
        IfStmt ifStmt = new IfStmt(expr,trueBody,falseBody);
        mapAst(ifStmt,ctx);
        return ifStmt;
    }
    
    private void handleMultiBranchedAssign(Map<VarObject,Integer>... assignedTable){
        if(assignedTable.length<2){
            throw Exceptions.illegalArgument(assignedTable);
        }
        HashMap<VarObject,Integer> ret = new HashMap();
        ret.putAll(assignedTable[0]);
        for(int i=1;i<assignedTable.length;i++){
            Map<VarObject,Integer> other = assignedTable[i];
            for(Map.Entry<VarObject,Integer> e:ret.entrySet()){
                Integer oneNullable = e.getValue();
                Integer otherNullable = other.get(e.getKey());
                if(oneNullable.equals(otherNullable)) continue;
                if(otherNullable==null) ret.remove(e.getKey());
                else{
                    int ns;
                    if(
                            (oneNullable.equals(NULLSTATE_MUST_NONNULL) && otherNullable.equals(NULLSTATE_UNKNOWN))                           || (otherNullable.equals(NULLSTATE_MUST_NONNULL) && oneNullable.equals(NULLSTATE_UNKNOWN))
                            ){
                        ns = NULLSTATE_UNKNOWN;
                    }else{
                        ns = NULLSTATE_NULLABLE;
                    }
                    ret.put(e.getKey(),ns);
                }
            }
        }
        for(Map.Entry<VarObject,Integer> e:ret.entrySet()){
            this.nullState.put(e.getKey(), e.getValue());
        }
    }

    protected ExprNode visitExpression(ExpressionContext expression) {
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
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, "not an expression",expression);
            return expr;
        }
    }

    @Override
    public Statement visitStat(StatContext ctx) {
        ParseTree child = ctx.getChild(0);
        return child==null ? null : (Statement)visit(child);
    }

    @Override
    public AstNode visitReturnStat(ReturnStatContext ctx) {
        ReturnStmt rs = new ReturnStmt();
        mapAst(rs,ctx);
        if (ctx.expression() != null) {
            rs.expr = visitExpression(ctx.expression());
        }
        if(!semanticAnalyzer.validateReturnStmt(method, rs)) return null;
        this.returned = true;
        return rs;
    }

    @Override
    public Statement visitVarDeclStat(VarDeclStatContext ctx) {
        Statement vars = visitLocalVarDecl(ctx.localVarDecl());
        mapAst(vars,ctx);            
        return vars;
    }

    @Override
    public VarObject visitVarDecl(VarDeclContext ctx) {
        throw Exceptions.unexceptedException("It should never be executed");
    }
    
    protected VarInfo varDecl(VarDeclContext ctx,Type inferedType){
        VarInfo vds = new VarInfo();
        String name = ctx.name.getText();
        TypeContext type = null;
        if (ctx.varType != null) {
            type = ctx.varType;
        } else if (ctx.type() != null) {
            type = ctx.type();
        }
        Type declType = type != null ? parseType(type) : inferedType;
        if (isDefindedId(name)) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR,"the name is definded:" + name, ctx);
        }
        vds.name = name;
        vds.type = declType;
        vds.modifier = ctx.valToken != null ? Modifier.FINAL : 0;
//        if (ctx.expression() != null) {
//            vds.initExpr = visitExpression(ctx.expression());
//            if(vds.type==null && vds.initExpr!=null){
//                vds.type = vds.initExpr.getType();
//            }
//        }
        if(vds.type==null){
            vds.type = Types.getRootType();
        }
        return vds;
    }
    
    public void methodIsAmbiguous(Token token , AmbiguousMethodException ex){
        diagnosisReporter.report(Diagnosis.Kind.ERROR, ex.getMessage(), token);
    }

    public void methodNotFound(Token token , Type type,String methodName,ExprNode[] params){
        methodNotFound(token,type.getName(),methodName,params);
    }

    public void methodNotFound(Token token , String className,String methodName,ExprNode[] params){
        Type[] types = AstUtil.getExprTypes(params);
        diagnosisReporter.report(Diagnosis.Kind.ERROR
                , "method not found:" + MethodUtil.toString(className,methodName, types)
                , token
        );
    }
    
    //TODO add stop token
    private void handleSyntaxError(String msg, Token token) {
        //TODO what does EMPTY means?
        handleSyntaxError(msg, (ParserRuleContext.EMPTY), token, token);
    }

    private void handleSyntaxError(String msg,ParserRuleContext tree) {
        handleSyntaxError(msg, tree, tree.start, tree.stop);
    }
    
    //TODO remove rule
    private void handleSyntaxError(String desc,ParserRuleContext rule,Token start,Token stop){
        diagnosisReporter.report(Diagnosis.Kind.ERROR, desc,start,stop);
    }

    @Override
    public AstNode visitBreakStat(BreakStatContext ctx) {
        BreakStmt bs = new BreakStmt();
        mapAst(bs,ctx);
        return bs;
    }

    @Override
    public AstNode visitContinueStat(ContinueStatContext ctx) {
        ContinueStmt cs = new ContinueStmt();
        mapAst(cs,ctx);
        return cs;
    }

    @Override
    public AstNode visitWhileStat(WhileStatContext ctx) {
        
        ExprNode preConditionExpr = visitExpression(ctx.expression());
        BlockStmt loopBody = null;
        if (ctx.stat() != null) {
            loopBody = requireBlock(ctx.stat());
        }
        LoopStmt ws = new LoopStmt(preConditionExpr,null, loopBody,null);
        mapAst(ws,ctx);
        return ws;
    }

    @Override
    public AstNode visitDoWhileStat(DoWhileStatContext ctx) {
        BlockStmt loopBody = null;
        if (ctx.blockStmt() != null) {
            loopBody = requireBlock(ctx.blockStmt());
        }
        ExprNode postConditionExpr = visitExpression(ctx.expression());
        LoopStmt ls = new LoopStmt(null,postConditionExpr, loopBody,null);
        mapAst(ls,ctx);
        return ls;
    }

    @Override
    public AstNode visitForStat(ForStatContext ctx) {
        //TODO It seems that here lacks of var stack
        BlockStmt forStmt = newBlock();
        if(ctx.localVarDecl()!=null){
            Statement vars = visitLocalVarDecl(ctx.localVarDecl());
            forStmt.statements.add(vars);
        }
        if(ctx.initExpressions!=null){
            forStmt.statements.addAll(visitExpressions(ctx.initExpressions));
        }
        ExprNode preConditionExpr = ctx.condition!=null ? visitExpression(ctx.condition) : null;
        BlockStmt bs =newBlock();
        if (ctx.stat() != null) {
            Statement st = visitStat(ctx.stat());
            if(st instanceof BlockStmt){
                bs.statements.addAll(((BlockStmt)st).statements);
            } else if (st != null) {
                bs.statements.add(st);
            }
        }
        popBlock();
        BlockStmt updateBs = newBlock();
        if(ctx.updateExpressions!=null){
            updateBs.statements.addAll(visitExpressions(ctx.updateExpressions));
        }
        popBlock();
        LoopStmt ls = new LoopStmt(preConditionExpr, null, bs ,updateBs);
        mapAst(ls,ctx);
        forStmt.statements.add(ls);
        popBlock();
        return forStmt;
    }

    @Override
    public List<Statement> visitExpressions(ExpressionsContext ctx) {
        List<Statement> list = new LinkedList();
        for (ExpressionContext e : ctx.expression()) {
            ExprNode expr = visitExpression(e);
            list.add(new ExprStmt(expr));
        }
        return list;
    }

    @Override
    public AstNode visitExprStat(ExprStatContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        ExprStmt es = new ExprStmt(expr);
        mapAst(es,ctx);
        return es;
    }

    @Override
    public ExprNode visitMemberInvocationExpr(MemberInvocationExprContext ctx) {
        String methodName;
        ExprNode target;
        ObjectType clazz;
        if (ctx.key != null) {
            methodName = ctx.key.getText();
        } else {
            methodName = ctx.Identifier().getText();
        }
        if(methodName.equals("this")){
            methodName = "<init>";
            target = new ThisExpr(this.getThisType());
            clazz = this.getThisType();
        }else if(methodName.equals("super")){
            methodName = "<init>";
            target = new SuperExpr(thisClazz);
            clazz = thisClazz.getSuperType();
        }else{
            target = new ThisExpr(this.getThisType());
            clazz = this.getThisType();
        }
        List<Object> argsList = visitAll(ctx.params);
        if(argsList.contains(null)) return null;
        ExprNode[] args = argsList.toArray(new ExprNode[argsList.size()]);
        ExprNode ie;
        if(methodName.equals("<init>")){
            if(clazz==null) throw Exceptions.unexceptedValue(clazz);
            try {
                InvocationExpr.MethodSelection apply = InvocationExpr.applyMethod(clazz, methodName, args,clazz.getConstructorDescriptors(thisClazz));
                ie = new ObjectInvokeExpr(target, apply.selectedMethod, apply.appliedArguments);
            } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                this.methodNotFound(ctx.start, clazz.getName(), methodName, args);
                return null;
            }
        }else{
            ie= getImplicitInvokeExpr(methodName,args,ctx);
        }
        return ie;
    }
    
    private BinaryExpr constructBinaryExpr(ExprNode expr1,ExprNode expr2,String op){
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
    
    protected ExprNode createFieldExpr(GetFieldExprContext to,@Nullable ExpressionContext fromCtx,OffsetRange offsetRange){
        //TODO support iterating syntax
        String refKey = to.refKey.getText();
        ExpressionContext exp = to.expression();
        String fname = to.Identifier().getText();
        AssignableExpr toExpr;
        Object expr = visit(exp);
        if (expr==null) return null;
        if(refKey.equals(".")){
            ExprNode fieldExpr;
            if(expr instanceof ExprNode){
                ExprNode exprNode = (ExprNode) expr;
                fieldExpr = getObjectFieldLikeExpr(exprNode,fname,to);
            }else if(expr instanceof ClassReference){
                fieldExpr = getStaticFieldExpr((ClassReference)expr, fname, to);
            }else{
                throw new UnknownError("unknown node:" + expr);
            }
            if(fromCtx==null){
                return fieldExpr;
            }else{
                if(fieldExpr instanceof AssignableExpr){
                    toExpr = (AssignableExpr) fieldExpr;
                }else{
                    AstBuilder.this.handleSyntaxError("unsupported", to);
                    return null;
                }
                ExprNode fromExpr = visitExpression(fromCtx);
                if(!this.semanticAnalyzer.validateAssign(toExpr, fromExpr,offsetRange,isInConstructor())){
                  return null;
                }
                return new AssignExpr(toExpr,fromExpr);
            }
        }else if(refKey.equals("->")){
            ExprNode[] params;
            String methodName;
            if(fromCtx==null){
                params = new ExprNode[0];
                methodName = "get" + NameUtil.firstCharToUpperCase(fname);
            }else{
                params = new ExprNode[1];
                methodName = "set" + NameUtil.firstCharToUpperCase(fname);
            }
            if(expr instanceof ExprNode){
                if(fromCtx!=null) params[0] = visitExpression(fromCtx);
                return getObjectInvokeExpr((ExprNode)expr, methodName, params, to);
            }else{
                //don't support static property
                handleSyntaxError("object expression required.", to);
                return null;
            }
        }else{
            throw Exceptions.unknownValue(refKey);
        }
    }

    @Override
    public ExprNode visitAssignExpr(AssignExprContext ctx) {
        ExprNode expr;
        String assignOp = ctx.getChild(1).getText();
        ExpressionContext toCtx = ctx.expression(0);
        ExpressionContext fromCtx = ctx.expression(1);
        if(toCtx instanceof GetFieldExprContext){
            //TODO check readonly
            expr = createFieldExpr((GetFieldExprContext)toCtx,fromCtx,OffsetRangeHelper.getOffsetRange(ctx));
        }else{
            ExprNode to = visitExpression(toCtx);
            ExprNode from = visitExpression(fromCtx);
            if (assignOp.length() > 1) {
                String op = assignOp.substring(0, assignOp.length() - 1);
                from = createBinaryExpr(op,toCtx, fromCtx,ctx);
            }
            AssignableExpr toExpr;
            if(to instanceof AssignableExpr){
                toExpr = (AssignableExpr) to;
                if(!this.semanticAnalyzer.validateAssign(toExpr, from, OffsetRangeHelper.getOffsetRange(ctx),isInConstructor())){
                  return null;
                }
                AssignExpr aexpr = new AssignExpr(toExpr,from);
                mapAst(aexpr, ctx);
                //TODO remove override information before assign
                onAssign(toExpr,from);
                expr = aexpr;
            }else{
                AstBuilder.this.handleSyntaxError("unsupported assign statement",ctx);
                return null;
            }
        }
        return expr;
    }
    
    private int getNullState(NullableKind nullable){
        int ns;
        if(nullable==NullableKind.NONNULL){
            ns = NULLSTATE_MUST_NONNULL;
        }else if(nullable==NullableKind.NULLABLE){
            ns = NULLSTATE_NULLABLE;
        }else if(nullable==NullableKind.UNKNOWN){
            ns = NULLSTATE_UNKNOWN;
        }else{
            throw Exceptions.unexceptedValue(nullable);
        }
        return ns;
    }
    
    private void onAssign(ExprNode to,ExprNode expr){
        removeOverrideType(to);
        if(to instanceof VarExpr){
            ((VarExpr)to).removeOverrideType();
        }else if(to instanceof ParameterExpr){
            ((ParameterExpr) to).removeOverrideType();
        }
        VarObject key = getOverrideTypeKey(to);
        if(key!=null){
            Type toType = to.getType();
            if(toType instanceof ObjectType){
                Type type = expr.getType();
                int ns;
                if(Types.NULL_TYPE.equals(type)){
                    ns = NULLSTATE_MUST_NULL;
                }else if(type instanceof ObjectType){
                    ns = getNullState(((ObjectType) type).getNullable());
                }else{
                    throw Exceptions.unexceptedValue(type);
                }
                nullState.put(key, ns);
            }
        }
    }
    
    @Nullable
    private ExprNode concatExpressionsToStringExpr(ExprNode[] expr,Token[] startTokens){
        ExprNode ret;
        try {
            ret = new NewObjectExpr(Types.requireClassType("java.lang.StringBuilder"),new ExprNode[0]);
        } catch (MethodNotFoundException | AmbiguousMethodException ex) {
            throw Exceptions.unexceptedException(ex);
        }
        for(int i=0;i<expr.length;i++){
            try {
                ret = ObjectInvokeExpr.create(ret, "append",new ExprNode[]{expr[i]});
            } catch (MethodNotFoundException|AmbiguousMethodException ex) {
                throw Exceptions.unexceptedException(ex);
            }
        }
        try {         
            return ObjectInvokeExpr.create(ret,"toString",new ExprNode[0]);
        } catch (MethodNotFoundException | AmbiguousMethodException ex) {
            throw Exceptions.unexceptedException(ex);
        }
    }
    
    private ExprNode createBinaryExpr(String op,ExpressionContext exprCtx1,ExpressionContext exprCtx2,ParserRuleContext ctx){
        ExprNode expr1 = visitExpression(exprCtx1);
        ExprNode expr2 = visitExpression(exprCtx2);
        if (expr1==null || expr2==null){
            return null;
        }
        Type type1 = expr1.getType();
        Type type2 = expr2.getType();
        boolean isPrimitive1 = (type1 instanceof PrimitiveType);
        boolean isPrimitive2 = (type2 instanceof PrimitiveType);
        ExprNode expr;        
        String errMsg = String.format("bad operand types:%s %s %s",type1,op,type2);
        if (Types.VOID_TYPE.equals(type1) || Types.VOID_TYPE.equals(type2)) {
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, String.format("bad operand types:%s %s %s",type1,op,type2),ctx);
            return null;
        }
        
        if ("+".equals(op)) {
            if (Types.isNumber(type1) && Types.isNumber(type2)) {
                expr = this.createBinaryMathExpr(expr1, expr2, op);
            } else if (Types.isStringType(type1)||Types.isStringType(type2)) {
                expr = this.concatExpressionsToStringExpr(new ExprNode[]{expr1,expr2}, new Token[]{exprCtx1.getStart(),exprCtx2.getStart()});
            } else {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, errMsg,ctx);
                return null;
            }
        } else if ("==".equals(op) || "!=".equals(op)) {
            if (type1 instanceof ObjectType) {
                ClassReference objectsRef = new ClassReference(Types.requireClassType(Objects.class.getName()).getClassNode());
                expr = this.getStaticInvokeExpr(objectsRef, "equals", new ExprNode[]{expr1, expr2}, ctx);
                if ("!=".equals(op)) {
                    expr = new UnaryExpr(expr, "!");
                }
            } else if (Types.isNumber(type1) && Types.isNumber(type2) && (isPrimitive1 || isPrimitive2)) {
                expr = this.createBinaryMathExpr(expr1, expr2, op);
            } else if (Types.isBoolean(type1) && Types.isBoolean(type2) && (isPrimitive1 || isPrimitive2)) {
                expr = this.createBinaryBoolOperateExpr(expr1, expr2, op);
            } else {
                expr = this.constructBinaryExpr(expr1, expr2, op);
            }
        } else if ("===".equals(op) || "!==".equals(op)) {
            if (!(type1 instanceof ObjectType)) {
                String msg = "object type is required";
                diagnosisReporter.report(Diagnosis.Kind.ERROR,msg,ctx);
                return null;
            }
            expr = constructBinaryExpr(expr1,expr2,op.substring(0,2));
        } else if (">>>".equals(op) || "<<".equals(op) || ">>".equals(op)) {
            if (Types.isExactNumber(type1) && Types.isExactNumber(type2)) {
                expr = this.createBinaryMathExpr(expr1, expr2, op);
            } else {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, errMsg,ctx);
                return null;
            }
        } else if ("&&".equals(op) || "||".equals(op)) {
            if (!Types.isBoolean(type1) || !Types.isBoolean(type2)) {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, errMsg,ctx);
                return null;
            }
            expr = this.createBinaryBoolOperateExpr(expr1, expr2, op);
        } else {
            expr = this.createBinaryMathExpr(expr1, expr2, op);
        }
        if (expr == null) {
            return null;
        }
        mapAst(expr, ctx);
        return expr;
    }

    @Override
    public AstNode visitBinaryExpr(BinaryExprContext ctx) {
        TerminalNode opNode = (TerminalNode) ctx.getChild(1);
        String op = opNode.getText();
        return createBinaryExpr(op, ctx.expression(0), ctx.expression(1),ctx);
    }
    
    @Nullable
    private ExprNode getImplicitInvokeExpr(String methodName,ExprNode[] args, ParserRuleContext ctx){
        AstNode namedNode = this.getNodeById(methodName, ctx.start);
        if (namedNode!=null && (namedNode instanceof ParameterExpr || namedNode instanceof VarExpr)) {
            return this.getLambdaCall(methodName,(ExprNode) namedNode,args,ctx);
        }
        ExprNode expr;
        ObjectType clazzType = getThisType();
        MethodDescriptor[] namedMethods = clazzType.getMethodDescriptors(thisClazz, methodName ,true, true);
        if (namedMethods.length<=0 && namedNode instanceof FieldExpr) {
            return this.getLambdaCall(methodName,(FieldExpr)namedNode,args,ctx);
        }
        if (namedMethods.length<=0) {
            ClassNode classOfStaticImport = staticImportMembers.get(methodName);
            if (classOfStaticImport!=null) {
                return this.getStaticInvokeExpr(new ClassReference(classOfStaticImport),methodName,args,ctx);
            }
            for (int i=staticImportPaths.size()-1;i>=0;i--) {
                ClassNode sc = staticImportPaths.get(i);
                ClassType scType = Types.getClassType(sc);
                MethodDescriptor[] scMethods = scType.getMethodDescriptors(thisClazz, methodName,true, true);
                List<MethodDescriptor> scStaticMethods = new LinkedList<>();
                for(MethodDescriptor m:scMethods) {
                    if (Modifier.isStatic(m.getModifier())) {
                        scStaticMethods.add(m);
                    }
                }
                if (!scStaticMethods.isEmpty()) {
                    clazzType = scType;
                    namedMethods = scStaticMethods.toArray(new MethodDescriptor[0]);
                    break;
                }
            }
        }
        try {
            InvocationExpr.MethodSelection ms = InvocationExpr.applyMethod(clazzType, methodName, args,namedMethods);
            if(Modifier.isStatic(ms.selectedMethod.getModifier())){
                expr = new StaticInvokeExpr(new ClassReference(clazzType.getClassNode()), ms.selectedMethod, ms.appliedArguments);
            }else{
                expr = new ObjectInvokeExpr(new ThisExpr(clazzType), ms.selectedMethod, ms.appliedArguments);
            }
        } catch (MethodNotFoundException ex) {
            this.methodNotFound(ctx.getStart(), clazzType, methodName, args);
            expr = new UnknownInvocationExpr(null, methodName, args);
        } catch (AmbiguousMethodException ex) {
            methodIsAmbiguous(ctx.start, ex);
            return null;
        }
        mapAst(expr, ctx);
        return expr;
    }
    
    @Nullable
    private ExprNode getObjectInvokeExpr(ExprNode target,String methodName,List<ExpressionContext> argumentsCtx,ParserRuleContext ctx){
        List<Object> argsList = visitAll(argumentsCtx);
        if (argsList.contains(null)) return null;
        ExprNode[] args = argsList.toArray(new ExprNode[argsList.size()]);
        return getObjectInvokeExpr(target, methodName, args, ctx);
    }
    
    @Nullable
    private ExprNode getObjectInvokeExpr(ExprNode target,String methodName,ExprNode[] args,ParserRuleContext ctx){
        if("<init>".equals(methodName)){
            throw Exceptions.unexceptedException("Don't get constructor by this method.");
        }
        Type targetType = target.getType();
        if(!(targetType instanceof ObjectType)){
            handleSyntaxError("class type required.", ctx);
            return null;
        }
        ObjectType targetClassType = (ObjectType) targetType;
        if(targetClassType.getNullable()==NullableKind.NULLABLE){
            handleSyntaxError("expression may be null", ctx);
            return null;
        }
        ExprNode expr;
        try {
            ObjectInvokeExpr invoke = ObjectInvokeExpr.create(target, methodName, args,thisClazz);
            if(invoke.getMethod().getMethodNode().getType() instanceof GenericType){
                Type invokeType = invoke.getType();
                if(invokeType instanceof ObjectType){
                    expr = new CastExpr(invokeType, invoke);
                }else{
                    expr = invoke;
                }
            }else{
                expr = invoke;
            }
        } catch (MethodNotFoundException ex) {
            methodNotFound(ctx.start, targetType, methodName, args);
            expr= new UnknownInvocationExpr(target,methodName,args);
        } catch(AmbiguousMethodException ex){
            methodIsAmbiguous(ctx.start,ex);
            return null;
        }
        mapAst(expr, ctx);
        return expr;
    }
    
    private  ExprNode getStaticInvokeExpr(ClassReference clazz,String methodName,List<ExpressionContext> argumentsCtx,ParserRuleContext ctx){
        List<Object> argsList = visitAll(argumentsCtx);
        if (argsList.contains(null)) {
            return null;
        }
        ExprNode[] args = argsList.toArray(new ExprNode[argsList.size()]);
        return getStaticInvokeExpr(clazz, methodName, args, ctx);
    }
    
    private  ExprNode getStaticInvokeExpr(ClassReference clazz,String methodName, ExprNode[] argumentsCtx,ParserRuleContext ctx){
        ExprNode[] args = argumentsCtx;
        ExprNode expr;
        try {
            expr = StaticInvokeExpr.create(clazz, methodName, args);
        } catch (MethodNotFoundException ex) {
            methodNotFound(ctx.start, clazz.getReferencedClassNode().name, methodName, args);
            expr = new UnknownInvocationExpr(clazz, methodName , args);
        } catch(AmbiguousMethodException ex){
            methodIsAmbiguous(ctx.start, ex);
            return null;
        }
        mapAst(expr, ctx);
        return expr;
    }

    @Override
    public AstNode visitInvokeExpr(InvokeExprContext ctx) {
        Object target = visit(ctx.target);
        if(target==null) return null;
        String mdName = ctx.Identifier().getText();
        String refKey = ctx.refKey.getText();
        if(refKey.equals(".")){
            if(target instanceof ClassReference){
                return getStaticInvokeExpr((ClassReference) target, mdName,ctx.params, ctx);
            }else if(target instanceof ExprNode){
                return getObjectInvokeExpr((ExprNode) target, mdName, ctx.params,ctx);
            }else{
                throw Exceptions.unexceptedValue(target);
            }
        }else if(refKey.equals("->")){
            ExprNode[] invokeArgs = new ExprNode[3];
            ExprNode[] params = new ExprNode[ctx.params.size()];
            if(target instanceof ClassReference){
                invokeArgs[0] = new ConstExpr(null);
            }else if(target instanceof ExprNode){
                invokeArgs[0] = ((ExprNode) target);
            }
            invokeArgs[1] = new ConstExpr(mdName);
            for(int i=0;i<params.length;i++){
                params[i] = visitExpression(ctx.params.get(i));
            }
            invokeArgs[2] = createInitializedArray(Types.getRootType(), params);
            ClassNode dispatcherAst = getAst("kalang.runtime.dynamic.MethodDispatcher");
            if(dispatcherAst==null){
                throw Exceptions.unexceptedException("Runtime library is required!");
            }
            return getStaticInvokeExpr(new ClassReference(dispatcherAst), "invokeMethod", invokeArgs, ctx);
        }else if(refKey.equals("*.")){
            if(!(target instanceof ExprNode)){
                handleSyntaxError("expression required", ctx.expression);
                return null;
            }
            ExprNode targetExpr = (ExprNode) target;
            Type targetType = targetExpr.getType();
            if(!(targetType instanceof ArrayType)){
                handleSyntaxError("array required",ctx.expression);
                return null;
            }
            List<Statement> stats = new LinkedList();
            LocalVarNode varArrLen = this.declareTempLocalVar(Types.INT_TYPE);
            LocalVarNode varCounter = this.declareTempLocalVar(Types.INT_TYPE);
            stats.add(new VarDeclStmt(Arrays.asList(varArrLen,varCounter)));
            VarExpr varArrLenExpr = new VarExpr(varArrLen);
            VarExpr varCounterExpr = new VarExpr(varCounter);
            stats.add(new ExprStmt(new AssignExpr(varArrLenExpr,new ArrayLengthExpr(targetExpr))));
            stats.add(new ExprStmt(new AssignExpr(varCounterExpr,new ConstExpr(0))));
            CompareExpr conditionExpr = new CompareExpr(varCounterExpr,varArrLenExpr,CompareExpr.OP_LT);
            ExprNode targetEleExpr = new ElementExpr(targetExpr, varCounterExpr);
            ExprNode invokeExpr = getObjectInvokeExpr(targetEleExpr, mdName, ctx.params, ctx);
            if(invokeExpr==null) return null;
            LocalVarNode varRet = this.declareTempLocalVar(Types.getArrayType(invokeExpr.getType()));
            VarExpr varRetExpr = new VarExpr(varRet);
            stats.add(new VarDeclStmt(varRet));
            stats.add(new ExprStmt(new AssignExpr(varRetExpr,new NewArrayExpr(invokeExpr.getType(),varArrLenExpr))));
            BlockStmt loopBody = this.newBlock();
            loopBody.statements.add(new ExprStmt(new AssignExpr(new ElementExpr(varRetExpr,varCounterExpr),invokeExpr)));
            popBlock();
            BlockStmt updateBs = newBlock();
            updateBs.statements.add(new ExprStmt(new AssignExpr(varCounterExpr,new MathExpr(varCounterExpr,new ConstExpr(1),MathExpr.OP_ADD))));
            this.popBlock();
            LoopStmt loopStmt = new LoopStmt(conditionExpr,null, loopBody , updateBs);
            stats.add(loopStmt);
            return new MultiStmtExpr(stats,varRetExpr);
        }else{
            throw Exceptions.unexceptedException(refKey);
        }
    }

    @Override
    public ExprNode visitGetFieldExpr(GetFieldExprContext ctx) {
        return createFieldExpr(ctx, null,OffsetRangeHelper.getOffsetRange(ctx));
    }

    @Override
    public UnaryExpr visitUnaryExpr(UnaryExprContext ctx) {
        String op = ctx.getChild(0).getText();   
        UnaryExpr ue = new UnaryExpr( visitExpression( ctx.expression() ) , op );
        if(!semanticAnalyzer.validateUnaryExpr(ue)) return null;
        mapAst(ue, ctx);
        return ue;
    }

    @Override
    public ElementExpr visitGetArrayElementExpr(GetArrayElementExprContext ctx) {
        ElementExpr ee = new ElementExpr(
                visitExpression(ctx.expression(0))
                ,visitExpression(ctx.expression(1))
        );
        if(!semanticAnalyzer.validateElementExpr(ee)) return null;
        mapAst(ee, ctx);
        return ee;
    }
     
    private boolean isDefindedId(String id){
        return this.getNamedLocalVar(id)!=null 
                || this.getNamedParameter(id) != null;
    }
    
    @Nullable
    private ParameterNode getNamedParameter(String name){
        if (method != null) {
            for (ParameterNode p : method.getParameters()) {
                if (p.getName().equals(name)) {
                    return p;
                }
            }
        }
        return null;
    }
    
    @Nullable
    private LocalVarNode getNamedLocalVar(String name){
        return this.varTables.get(name);
    }

    @Nullable
    private AstNode getNodeById(@Nonnull String name,@Nullable Token token) {
        //find local var
        LocalVarNode var = this.getNamedLocalVar(name);
        if(var!=null){
            VarExpr ve = new VarExpr(var,getVarObjectType(var));
            if(token!=null) mapAst(ve, token);
            return ve;
        }
        //find parameters
        ParameterNode paramNode = this.getNamedParameter(name);
        if(paramNode!=null){
            ParameterExpr ve = new ParameterExpr(paramNode,this.getVarObjectType(paramNode));
            if(token!=null) mapAst(ve, token);
            return ve;
        }
        //find field
        ExprNode fieldExpr = this.getObjectFieldExpr(new ThisExpr(this.getThisType()), name, ParserRuleContext.EMPTY);
        if(fieldExpr==null) fieldExpr = this.getStaticFieldExpr(new ClassReference(thisClazz), name, ParserRuleContext.EMPTY);
        if(fieldExpr!=null) return fieldExpr;
        ExprNode outerClassInstanceExpr = this.getOuterClassInstanceExpr(new ThisExpr(this.getThisType()));
        while(outerClassInstanceExpr!=null){
            ExprNode fe = this.getObjectFieldExpr(outerClassInstanceExpr, name, ParserRuleContext.EMPTY);
            if(fe==null) fe = this.getStaticFieldExpr(new ClassReference(thisClazz), name, ParserRuleContext.EMPTY);
            if(fe!=null) return fe;
            outerClassInstanceExpr = this.getOuterClassInstanceExpr(outerClassInstanceExpr);
        }
        String resolvedTypeName = this.typeNameResolver.resolve(name, topClass, thisClazz);
        if (resolvedTypeName!=null) {
            ClassReference clsRef = new ClassReference(requireAst(resolvedTypeName,token));
            if(token!=null) mapAst(clsRef, token);
            return clsRef;
        }
        return null;
    }
    
    public ConstExpr parseLiteral(LiteralContext ctx,@Nullable Type exceptedType){
        String t = ctx.getText();
        Object v;
        if (ctx.IntegerLiteral() != null) {
            //NOTE should show tip for autocast?
            if(t.toUpperCase().endsWith("L")){
                t = t.substring(0,t.length()-1);
                exceptedType = Types.LONG_TYPE;
            }else if(t.toLowerCase().endsWith("i")){
                t = t.substring(0,t.length()-1);
                exceptedType = Types.INT_TYPE;
            }
            Number intValue;
            try{
                intValue = StringLiteralUtil.parseInteger(t);
            }catch(NumberFormatException ex){
                this.handleSyntaxError("invalid number", ctx);
                return null;
            }
            if(Types.BYTE_TYPE.equals(exceptedType)){
                //TODO check range
                v = intValue.byteValue();
            }else if(Types.LONG_TYPE.equals(exceptedType)){
                v =  intValue.longValue();
            }else{
                //TODO check range
                v = intValue;
            }
        } else if (ctx.FloatingPointLiteral() != null) {
            Number floatPointValue;
            try{
                floatPointValue = StringLiteralUtil.parseFloatPoint(t);
            }catch(NumberFormatException ex){
                this.handleSyntaxError("invalid float value", ctx);
                return null;
            }
            if(Types.FLOAT_TYPE.equals(exceptedType)){
                v = floatPointValue.floatValue();
            }else{
                v = floatPointValue;
            }
        } else if (ctx.BooleanLiteral() != null) {
            v = ( Boolean.parseBoolean(t));
        } else if (ctx.CharacterLiteral() != null) {
            String strValue = StringLiteralUtil.parse(t);
            char[] chars = strValue.toCharArray();
            v = ( chars[1]);
        } else if (ctx.StringLiteral() != null) {
            v = (StringLiteralUtil.parse(t.substring(1, t.length() - 1)));
        } else if(ctx.MultiLineStringLiteral()!=null){
            v = StringLiteralUtil.parse(t.substring(3,t.length()-3));
        }else if(ctx.Identifier()!=null){
            ClassReference cr = requireClassReference(ctx.Identifier().getSymbol());
            v = (cr);
        } else if(ctx.getText().equals("null")) {
            v = null;
        }else{
            throw Exceptions.unexceptedValue(ctx.getText());
        }
        ConstExpr ce = new ConstExpr(v);
        mapAst(ce,ctx);
        return ce;
    }

    @Override
    public ConstExpr visitLiteral(LiteralContext ctx) {
        return this.parseLiteral(ctx, null);
    }

    @Override
    public AstNode visitImportDecl(ImportDeclContext ctx) {
        String name = ctx.name.getText();
        String delim = ctx.delim.getText();
        String prefix = "";
        if("\\".equals(delim)){
            boolean relative = ctx.root == null || ctx.root.getText().length() == 0;
            String packageName = this.getPackageName();
            if (relative && packageName.length() > 0) {
                prefix = packageName + ".";
            }
        }
        if (ctx.path != null) {
            for (Token p : ctx.path) {
                prefix += p.getText() + ".";
            }
        }
        if (name.equals("*")) {
            this.typeNameResolver.importPackage(prefix.substring(0, prefix.length() - 1));
        } else {
            String key = name;
            if (ctx.alias != null) {
                key = ctx.alias.getText();
            }
            this.typeNameResolver.importClass(prefix + name,key);
        }        
        return null;
    }

    @Override
    public AstNode visitQualifiedName(QualifiedNameContext ctx) {
        //do nothing
        return null;
    }
    
    protected String parseTreeToText(ParseTree ctx){
        if(ctx instanceof TerminalNode) return ctx.getText();
        StringBuilder sb = new StringBuilder();
        int childCount = ctx.getChildCount();
        for(int i=0;i<childCount;i++){
            if(i>0) sb.append(" ");
            sb.append(parseTreeToText(ctx.getChild(i)));
        }
        return sb.toString();
    }

    protected int parseModifier(VarModifierContext modifier) {
        int defaultModifier = Modifier.PUBLIC;
        if (modifier == null) return defaultModifier;
        String modifierText = parseTreeToText(modifier);
        if(modifierText.isEmpty()) return defaultModifier;
        try {
            return ModifierUtil.parse(modifierText);
        } catch (InvalidModifierException ex) {
            this.handleSyntaxError(ex.getMessage(), modifier);
            return defaultModifier;
        }
    }

    @Override
    public AstNode visitNewExpr(NewExprContext ctx) {
        ObjectType clsType = parseClassType(ctx.classType());
        if(clsType==null) return null;
        List<Object> paramExprsList = visitAll(ctx.params);
        if (paramExprsList.contains(null)) {
            return null;
        }
        ExprNode[] params = paramExprsList.toArray(new ExprNode[paramExprsList.size()]);
        List<ExprNode> paramList = new LinkedList(Arrays.asList(params));
        NewObjectExpr newExpr;
        try {
            if(this.isNonStaticInnerClass(clsType.getClassNode())){
                paramList.add(0,new ThisExpr(this.getThisType()));
            }
            params = paramList.toArray(new ExprNode[paramList.size()]);
            newExpr = new NewObjectExpr(clsType,params,thisClazz);
            mapAst(newExpr,ctx);
            return newExpr;
        } catch (MethodNotFoundException ex) {
            methodNotFound(ctx.classType().rawClass, clsType.getName(), "<init>", params);
            return null;
        } catch(AmbiguousMethodException ex){
            methodIsAmbiguous(ctx.classType().rawClass ,ex);
            return null;
        }
    }

    @Override
    public AstNode visitCastExpr(CastExprContext ctx) {
        ExprNode castExpr;
        ExprNode expr = visitExpression(ctx.expression());
        Type toType = parseType(ctx.type());
        Type fromType = expr.getType();
        if(fromType instanceof PrimitiveType){
            if(toType instanceof PrimitiveType){
                castExpr = new PrimitiveCastExpr((PrimitiveType)fromType,(PrimitiveType)toType, expr);
            }else{
                this.handleSyntaxError("unable to cast primitive type to class type", ctx);
                return null;
            }
        }else{
            if(toType instanceof PrimitiveType){
                this.handleSyntaxError("unable to cast class type to primitive type", ctx);
                return null;
            }else{
                castExpr = new CastExpr(toType,expr);
            }
        }
        mapAst(castExpr,ctx);
        return castExpr;
    }

    @Override
    public AstNode visitTryStat(TryStatContext ctx) {
        //TODO handle multi-branched assign
        BlockStmt tryExecStmt = requireBlock(ctx.exec);
        boolean tryReturned = this.returned;
        List<CatchBlock> tryCatchBlocks = new LinkedList<>();
        if (ctx.catchTypes != null) {
            for (int i = 0; i < ctx.catchTypes.size(); i++) {
                this.newFrame();
                this.returned = false;
                String vName = ctx.catchVarNames.get(i).getText();
                String vType = ctx.catchTypes.get(i).getText();
                LocalVarNode vo = this.declareLocalVar(vName,requireClassType(vType, ctx.catchTypes.get(i).start),Modifier.FINAL,ctx);
                if(vo==null) return null;
                BlockStmt catchExecStmt = requireBlock(ctx.catchExec.get(i));
                CatchBlock catchStmt = new CatchBlock(vo,catchExecStmt); 
                tryCatchBlocks.add(catchStmt);
                this.returned = this.returned && tryReturned;
                this.popFrame();
            }
        }
        BlockStmt tryFinallyStmt = null;
        if (ctx.finallyExec != null) {
            tryFinallyStmt = requireBlock(ctx.finallyExec);
        }
        TryStmt tryStmt = new TryStmt(tryExecStmt,tryCatchBlocks,tryFinallyStmt);
        mapAst(tryStmt,ctx);
        return tryStmt;
    }

    @Override
    public Statement visitLocalVarDecl(LocalVarDeclContext ctx) {
        MultiStmt ms = new MultiStmt();
        for (VarDeclContext v : ctx.varDecl()) {
            TypeContext varType = v.varType;
            Type exceptedType =varType==null ? null :  parseType(varType);
            ExprNode initExpr = null;
            ExpressionContext initExprContext = v.expression();
            if(initExprContext!=null){
                if(initExprContext instanceof LiteralExprContext){
                    initExpr = this.parseLiteral(((LiteralExprContext) initExprContext).literal(), exceptedType);
                }else{
                    initExpr = visitExpression(initExprContext);
                }
            }
            VarInfo varInfo = varDecl(v,initExpr==null
                    ?Types.getRootType()
                    :initExpr.getType()
            );
            LocalVarNode localVar = this.declareLocalVar(varInfo.name, varInfo.type,varInfo.modifier,ctx);
            if(localVar==null) return null;
            VarDeclStmt vds = new VarDeclStmt(localVar);
            ms.statements.add(vds);
            if(initExpr!=null){
               AssignExpr assignExpr = new AssignExpr(new VarExpr(localVar), initExpr);
                mapAst(assignExpr, v);
                ms.statements.add(new ExprStmt(assignExpr));
            }
            mapAst(localVar,ctx);
        }
        return ms;
    }

    @Override
    public AstNode visitIdentifierExpr(IdentifierExprContext ctx) {
        String name = ctx.Identifier().getText();
        AstNode expr = this.getNodeById(name,ctx.Identifier().getSymbol());
        if (expr == null) {
            this.handleSyntaxError(name + " is undefined!", ctx);
            return null;
        }
        mapAst(expr,ctx);
        return expr;
    }

    @Override
    public AstNode visitLiteralExpr(LiteralExprContext ctx) {
        return visitLiteral(ctx.literal());
    }

    @Override
    public AstNode visitParenExpr(ParenExprContext ctx) {
        return visitExpression(ctx.expression());
    }
    
    public void visitBlockStmt(StatContext[] stats,BlockStmt blockStmt){
        this.newFrame();
        if (stats == null) {
            return;
        }
        for (StatContext s : stats) {
            blockStmt.statements.add(visitStat(s));
        }
        this.popFrame();
    }

    @Override
    public AstNode visitBlockStmt(BlockStmtContext ctx) {
        BlockStmt bs =newBlock();
        List<StatContext> stats = ctx.stat();
        if(stats!=null){
            this.visitBlockStmt(stats.toArray(new StatContext[stats.size()]), bs);
        }
        mapAst(bs,ctx);
        popBlock();
        return bs;
    }

    @Override
    public AstNode visitVarModifier(VarModifierContext ctx) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AstNode visitSelfRefExpr(SelfRefExprContext ctx) {
        String key = ctx.ref.getText();
        AstNode expr;
        if(key.equals("this")){
            expr = new ThisExpr(getThisType());
        }else if(key.equals("super")){
            expr = new SuperExpr(thisClazz);
        }else{
            throw Exceptions.unknownValue(key);
        }
        mapAst(expr, ctx);
        return expr;
    }

    @Override
    public Object visitPrimitiveType(KalangParser.PrimitiveTypeContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IncrementExpr visitIncExpr(KalangParser.IncExprContext ctx) {
        return getIncrementExpr(ctx.expression(), ctx.op.getText(), false);
    }

    @Override
    public IncrementExpr visitPreIncExpr(KalangParser.PreIncExprContext ctx) {
        return getIncrementExpr(ctx.expression(), ctx.op.getText(), true);
    }
    
    public IncrementExpr getIncrementExpr(ExpressionContext expressionContext,String op,boolean isPrefix){
        ExprNode expr = visitExpression(expressionContext);
        if(!(expr instanceof AssignableExpr)){
            AstBuilder.this.handleSyntaxError("require assignable expression", expressionContext);
            return null;
        }
        boolean isDesc = op.equals("--");
        return new IncrementExpr((AssignableExpr) expr, isDesc, isPrefix);
    }

    
    
    private ExprNode requireCastable(ExprNode expr1, Type fromType, Type toType,Token token) {
        ExprNode expr = BoxUtil.assign(expr1,fromType,toType);
        if(expr==null){
            diagnosisReporter.report(Diagnosis.Kind.ERROR
                    , "unable to cast " + fromType + " to " + toType, token);
        }
        return expr;
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
    
    protected ExprNode getObjectFieldLikeExpr(ExprNode expr,String fieldName,@Nullable ParserRuleContext rule){
        ExprNode ret;
        Type type = expr.getType();
        if(!(type instanceof  ObjectType)){
            AstBuilder.this.handleSyntaxError("unsupported type", rule==null ? ParserRuleContext.EMPTY : rule);
            return null;
        }
        ObjectType exprType = (ObjectType) type;
        if ((exprType instanceof ArrayType)
                && fieldName.equals("length")) {
            ret = new ArrayLengthExpr(expr);
        } else {
            try {
                ret = ObjectFieldExpr.create(expr, fieldName,thisClazz);
            } catch (FieldNotFoundException ex) {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, "field not found:" + fieldName,rule);
                ret = new UnknownFieldExpr(expr,exprType.getClassNode(),fieldName);
            }
        }
        if(rule!=null) mapAst(ret, rule);
        return ret;
    }
    
    protected AssignableExpr getStaticFieldExpr(ClassReference clazz,String fieldName,ParserRuleContext rule){
        AssignableExpr ret;
        try {
            ret = StaticFieldExpr.create(clazz,fieldName,thisClazz);
        } catch (FieldNotFoundException ex) {
            //ret = new UnknownFieldExpr(clazz, clazz.getReferencedClassNode(), fieldName);
            return null;
        }
        mapAst(ret, rule);
        return ret;
    }

    @Override
    public Object visitErrorousStat(KalangParser.ErrorousStatContext ctx) {
        handleSyntaxError("missing ';'", ctx, ctx.start , ctx.stop);
        return null;
    }

    @Override
    public Object visitErrorousMemberExpr(KalangParser.ErrorousMemberExprContext ctx) {
        handleSyntaxError("identifier excepted", ctx, ctx.stop , ctx.stop);
        return null;
    }

    @Override
    public Object visitInstanceofExpr(KalangParser.InstanceofExprContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        Token ts = ctx.Identifier().getSymbol();
        AstNode tnode = getNodeById(ts.getText(), ts);
        if(tnode instanceof ClassReference){
            InstanceOfExpr ie = new InstanceOfExpr(expr, (ClassReference)tnode);
            mapAst(ie, ctx);
            return ie;
        }else{
            AstBuilder.this.handleSyntaxError("unsupported type", ts);
            return null;
        }
    }

    @Override
    public Object visitScriptDef(KalangParser.ScriptDefContext ctx) {
        throw Exceptions.unexceptedException("");
    }

    @Override
    public Object visitCompileOption(KalangParser.CompileOptionContext ctx) {
        return null;//Do noting
        //throw Exceptions.unexceptedException("");
    }
    
    @Override
    public Object visitLambdaExpr(KalangParser.LambdaExprContext ctx) {
        KalangParser.LambdaTypeContext lambdaTypeCtx = ctx.lambdaType();
        FunctionType functionType = null;
        if (lambdaTypeCtx!=null) {
            ObjectType lambdaType = this.visitLambdaType(lambdaTypeCtx);
            if (lambdaType instanceof FunctionType) {
                functionType = (FunctionType) lambdaType;
            }
        }
        Type type = functionType!=null ? functionType : Types.requireClassType(Types.FUNCTION_CLASS_NAME);
        LocalVarNode tmpVar = this.declareTempLocalVar(type);
        LambdaExpr ms = new LambdaExpr(tmpVar,functionType);
        Map<String,VarObject> accessibleVars = new HashMap();
        VarTable<String, LocalVarNode> vtb = this.varTables;
        while(vtb!=null) {
            for(Map.Entry<String, LocalVarNode> v:vtb.vars().entrySet()) {
                String name = v.getKey();
                LocalVarNode var = v.getValue();
                if (!accessibleVars.containsKey(name)) {
                    accessibleVars.put(name, var);
                }
            }
            vtb = vtb.getParent();
        }
        ParameterNode[] paramNodes = this.method.getParameters();
        for(ParameterNode p:paramNodes) {
            String name = p.getName();
            if (!accessibleVars.containsKey(name)) {
                accessibleVars.put(name, p);
            }
        }
        for(Map.Entry<String, VarObject> e:accessibleVars.entrySet()) {
            ms.putAccessibleVarObject(e.getKey(), e.getValue());
        }
        this.lambdaExprCtxMap.put(ms, ctx);
        return ms;
    }
    
    protected List<AnnotationNode> getAnnotations(@Nullable List<KalangParser.AnnotationContext> ctxs){
        List<AnnotationNode> list = new LinkedList<>();
        if(ctxs!=null){
            for(KalangParser.AnnotationContext an:ctxs){
                AnnotationNode anNode = visitAnnotation(an);
                if(anNode!=null) list.add(anNode);
            }
        }
        return list;
    }
    
    @Nullable
    private ExprNode getOuterClassInstanceExpr(ExprNode expr){
        return this.getObjectFieldExpr(expr, "this$0", null);
    }
    
    private ExprNode requireOuterClassInstanceExpr(ExprNode e){
        ExprNode expr = this.getOuterClassInstanceExpr(e);
        if(expr==null) throw Exceptions.unexceptedException("BUG!");
        return expr;
    }

    @Override
    public Object visitClassDef(KalangParser.ClassDefContext ctx) {
        throw Exceptions.unexceptedException("");
    }

    @Override
    @Nullable
    public AnnotationNode visitAnnotation(KalangParser.AnnotationContext ctx) {
        ClassNode anType = requireAst(ctx.annotationType);
        if(anType==null) return null;
        List<Token> vk = ctx.annotationValueKey;
        LiteralContext dv = ctx.annotationDefaultValue;
        AnnotationNode anNode = new AnnotationNode(anType);
        if(vk!=null && vk.size()>0){
            List<LiteralContext> anValues = ctx.annotationValue;
            int ksize = vk.size();
            for(int i=0;i<ksize;i++){
                String kname = vk.get(i).getText();
                ConstExpr value = visitLiteral(anValues.get(i));
                anNode.values.put(kname, value);
            }
        }else if(dv!=null){
            ConstExpr defaultValue = visitLiteral(dv);
            anNode.values.put("value", defaultValue);
        }
        if(!semanticAnalyzer.validateAnnotation(anNode)) return null;
        //TODO validate annotation's values
        return anNode;
    }

    private BlockStmt requireBlock(ParserRuleContext stmt) {
        if(stmt instanceof BlockStmtContext){
            return (BlockStmt)visit(stmt);
        }else{
            BlockStmt bs = newBlock();
            bs.statements.add((Statement)visit(stmt));
            popBlock();
            return bs;
        }
    }

    @Override
    public Object visitClassType(KalangParser.ClassTypeContext ctx) {
        //see parseClassType
        return null;
    }

    @Override
    public Object visitParameterizedElementType(KalangParser.ParameterizedElementTypeContext ctx) {
        return null;
    }
    
    private Type parseParameterizedElementType(KalangParser.ParameterizedElementTypeContext ctx){
        TypeContext type = ctx.type();
        if(type!=null){
            return parseType(type);
        }else{
            return parseWildcardType(ctx.wildcardType());
        }
    }

    @Override
    public Object visitWildcardType(KalangParser.WildcardTypeContext ctx) {
        return null;
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

    public ObjectType getThisType() {
        return Types.getClassType(thisClazz);
    }
    
    @Nonnull
    private LocalVarNode declareTempLocalVar(Type type){
        LocalVarNode var = declareLocalVar(null, type,0,ParserRuleContext.EMPTY);
        if(var==null) throw Exceptions.unexceptedValue(var);
        return var;
    }
    
    @Nullable
    private LocalVarNode declareLocalVar(String name,Type type,int modifier,ParserRuleContext ctx){
        LocalVarNode localVarNode = new LocalVarNode(type,name,modifier);
        ParameterNode param = this.getNamedParameter(name);
        LocalVarNode var = this.getNamedLocalVar(name);
        if(param!=null || var!=null){
            handleSyntaxError("variable is defined", ctx);
            return null;
        }
        if(name!=null){
            this.varTables.put(name,localVarNode);
        }
        return localVarNode;
    }

    @Override
    public Object visitForEachStat(KalangParser.ForEachStatContext ctx) {
        BlockStmt block = newBlock();
        ExprNode expr = this.visitExpression(ctx.expression());
        Type exprType = expr.getType();
        List<TerminalNode> idsCtx = ctx.Identifier();
        VarExpr indexVarExpr = null;
        TerminalNode varId;
        if(idsCtx.size()==1){
            varId = idsCtx.get(0);
        }else{
            TerminalNode indexId = idsCtx.get(0);
            LocalVarNode indexVar = this.declareLocalVar(indexId.getText(),Types.INT_TYPE,Modifier.FINAL,ctx);
            if(indexVar==null) return null;
            block.statements.add(new VarDeclStmt(indexVar));
            indexVarExpr = new VarExpr(indexVar);         
            varId = idsCtx.get(1);
        }
        LoopStmt loopStmt;
        if(exprType instanceof ArrayType){
            LocalVarNode localVarNode = this.declareLocalVar(varId.getText(),  ((ArrayType) exprType).getComponentType(),Modifier.FINAL,ctx);
            if(localVarNode==null) return null;
            VarExpr localVariable = new VarExpr(localVarNode);
            block.statements.add(new VarDeclStmt(localVarNode));
            LocalVarNode lenVar = this.declareTempLocalVar(Types.INT_TYPE);
            LocalVarNode counterVar = this.declareTempLocalVar(Types.INT_TYPE);
            block.statements.add(new VarDeclStmt(lenVar));//var len
            block.statements.add(new VarDeclStmt(counterVar));//var i
            VarExpr counterVarExpr = new VarExpr(counterVar);
            VarExpr lenVarExpr = new VarExpr(lenVar);
            block.statements.add(
                    new ExprStmt(new AssignExpr(lenVarExpr,new ArrayLengthExpr(expr)))
            );//l = array.length
            block.statements.add(
                    new ExprStmt(
                        new AssignExpr(counterVarExpr,new ConstExpr(0))
                    )
            );//i=0
            ExprNode cnd = new CompareExpr(counterVarExpr, lenVarExpr, CompareExpr.OP_LT);
            BlockStmt loopBody = this.newBlock();
            loopBody.statements.add(new ExprStmt(
                    new AssignExpr(localVariable,new ElementExpr(expr, counterVarExpr))
            ));
            if(indexVarExpr!=null){
                loopBody.statements.add(new ExprStmt(
                     new AssignExpr(indexVarExpr,counterVarExpr)
                ));
            }
            loopBody.statements.add(visitStat(ctx.stat()));
            popBlock();
            BlockStmt updateBs = newBlock();
            //increment counter
            updateBs.statements.add(new ExprStmt(
                    new AssignExpr(
                        counterVarExpr,new MathExpr(counterVarExpr, new ConstExpr(1), MathExpr.OP_ADD)
                    )
            ));
            popBlock();
            loopStmt = new LoopStmt(cnd, null, loopBody,updateBs);
        }else{
            ObjectType iterType = Types.getIterableClassType();
            if(iterType.isAssignableFrom(exprType)){
                ObjectInvokeExpr getIterableExpr;
                try {
                    getIterableExpr = ObjectInvokeExpr.create(expr, "iterator", null);
                } catch (MethodNotFoundException|AmbiguousMethodException ex) {
                    throw Exceptions.unexceptedException(ex);
                }
                LocalVarNode iterableVarNode = this.declareTempLocalVar(getIterableExpr.getType());
                block.statements.add(new VarDeclStmt(iterableVarNode));
                VarExpr iterableVarExpr = new VarExpr(iterableVarNode);
                block.statements.add(new ExprStmt(new AssignExpr(
                        iterableVarExpr,getIterableExpr
                )));
                //set index = 0
                if(indexVarExpr!=null){
                    block.statements.add(new ExprStmt(new AssignExpr(indexVarExpr,new ConstExpr(0))));
                }
                ObjectInvokeExpr cnd;
                try {
                    cnd = ObjectInvokeExpr.create(iterableVarExpr, "hasNext", null);
                } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                    throw Exceptions.unexceptedException(ex);
                }
                BlockStmt loopBody = this.newBlock();
                ObjectInvokeExpr nextInvokeExpr;
                try {
                    nextInvokeExpr = ObjectInvokeExpr.create(iterableVarExpr, "next", null);
                } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                    throw Exceptions.unexceptedException(ex);
                }
                LocalVarNode localVarNode = this.declareLocalVar(varId.getText(), nextInvokeExpr.getType(),Modifier.FINAL,ctx);
                if(localVarNode==null) return null;
                VarExpr localVariable = new VarExpr(localVarNode);
                loopBody.statements.add(new VarDeclStmt(localVarNode));
                loopBody.statements.add(new ExprStmt(
                        new AssignExpr(localVariable,new CastExpr(localVariable.getType(),nextInvokeExpr))
                ));
                loopBody.statements.add(visitStat(ctx.stat()));
                popBlock();
                BlockStmt updateBs = newBlock();
                if(indexVarExpr!=null){
                    //do index++
                    updateBs.statements.add(new ExprStmt(
                            new AssignExpr(
                                    indexVarExpr
                                    ,new MathExpr(indexVarExpr,new ConstExpr(1),BinaryExpr.OP_ADD)
                            )
                    ));
                }
                popBlock();
                loopStmt = new LoopStmt(cnd, null, loopBody,updateBs);
            }else{
                this.handleSyntaxError("require array type or iterable type", ctx.expression());
                loopStmt = null;
            }
        }        
        popBlock();
        if(loopStmt!=null) block.statements.add(loopStmt);
        return block;
    }

    @Override
    public Object visitArrayExpr(KalangParser.ArrayExprContext ctx) {
        ExprNode[] initExprs;
        List<ExpressionContext> exprCtx = ctx.expression();
        if(exprCtx!=null){
            initExprs = new ExprNode[exprCtx.size()];
            for(int i=0;i<initExprs.length;i++){
                initExprs[i] = visitExpression(exprCtx.get(i));
            }
        }else{
            initExprs = new ExprNode[0];
        }
        TypeContext typeCtx = ctx.type();
        Type type;
        if(typeCtx!=null){
             type = parseType(typeCtx);
        }else{
             type = TypeUtil.getCommonType(AstUtil.getExprTypes(initExprs));
        }
        for(int i=0;i<initExprs.length;i++){
            if(exprCtx==null) throw Exceptions.unexceptedValue(exprCtx);
            initExprs[i] = requireCastable(initExprs[i], initExprs[i].getType(), type, exprCtx.get(i).getStart());
            if(initExprs[i]==null) return null;
        }
        ExprNode arrExpr = createInitializedArray(type, initExprs);
        mapAst(arrExpr, ctx);
        return arrExpr;
    }

    private Type getVarObjectType(VarObject p) {
        Type type = this.overrideTypes.get(p);
        if(type==null) type = p.getType();
        //TODO handle other object type
        if(type instanceof ClassType){
            Integer ns = nullState.get(p);
            NullableKind nullable;
            if(ns==null){
                nullable = ((ObjectType) type).getNullable();
            }else if(ns==NULLSTATE_MUST_NONNULL){
                nullable = NullableKind.NONNULL;
            }else if(ns==NULLSTATE_UNKNOWN){
                nullable = NullableKind.UNKNOWN;
            }else if(ns==NULLSTATE_MUST_NULL|| ns== NULLSTATE_NULLABLE){
                nullable = NullableKind.NULLABLE;
            }else{
                throw Exceptions.unexceptedValue(ns);
            }
            return Types.getClassType((ClassType)type,nullable);
        }else{
            return type;
        }
    }

    @Override
    public Object visitInterpolationExpr(KalangParser.InterpolationExprContext ctx) {
        List<ParseTree> children = ctx.children;
        ExprNode[] exprs = new ExprNode[children.size()];
        Token[] exprTokens = new Token[children.size()];
        for(int i=0;i<exprs.length;i++){
            ParseTree c = children.get(i);
            if(c instanceof TerminalNode){
                Token token = ((TerminalNode) c).getSymbol();
                int t = token.getType();
                String rawText = c.getText();
                String text;
                switch(t){
                    case KalangLexer.InterpolationPreffixString:
                        text = rawText.substring(1,rawText.length()-2);
                        break;
                    case KalangLexer.INTERPOLATION_STRING:
                        text = rawText;
                        break;
                    case KalangLexer.RBRACE:
                    case KalangLexer.INTERPOLATION_END:
                    case KalangLexer.INTERPOLATION_INTERUPT:
                        //TODO optimize empty string
                        text = "";
                        break;
                    default :
                        throw Exceptions.unexceptedValue(t);
                }
                exprs[i]=new ConstExpr(StringLiteralUtil.parse(text));
                exprTokens[i] = token;
            }else if(c instanceof ExpressionContext){
                ExprNode expr = this.visitExpression((ExpressionContext) c);
                if(expr==null) return null;
                exprs[i]=expr;
                exprTokens[i] = ((ExpressionContext) c).getStart();
            }else{
                throw Exceptions.unexceptedValue(c);
            }
        }
        return this.concatExpressionsToStringExpr(exprs,exprTokens);
    }

    @Override
    public Object visitBitShiftExpr(KalangParser.BitShiftExprContext ctx) {
        String op;
        Token opStart;
        if(ctx.left!=null){
            op = "<<";
            opStart = ctx.left;
        }else if(ctx.right!=null){
            op = ">>";
            opStart = ctx.right;
        }else if(ctx.uright!=null){
            op = ">>>";
            opStart = ctx.uright;
        }else{
            throw Exceptions.unexceptedValue(ctx);
        }
        return this.createBinaryExpr(op, ctx.expression(0), ctx.expression(1), ctx);
    }
    
    public ExprNode createInitializedArray(Type type,ExprNode[] exprs){
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
    
    public DiagnosisReporter getDiagnosisReporter() {
        return diagnosisReporter;
    }

    public void importStaticMember(ClassNode classNode,@Nullable String name) {
        if (name!=null && !name.isEmpty()) {
            this.staticImportMembers.put(name,classNode);
        } else {
            this.staticImportPaths.add(classNode);
        }
    }
    
    private boolean isInConstructor(){
        return "<init>".equals(this.method.getName());
    }
    
    @Nullable
    private ExprNode requireImplicitCast(Type resultType,@Nullable ExprNode expr,OffsetRange offset) {
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
    
    private ExprNode createBinaryBoolOperateExpr(ExprNode expr1,ExprNode expr2,String op) {
        Type type1 = expr1.getType();
        Type type2 = expr2.getType();
        boolean isPrimitive1 = type1 instanceof PrimitiveType;
        boolean isPrimitive2 = type2 instanceof PrimitiveType;
        PrimitiveType numPriType1 = isPrimitive1 ? (PrimitiveType)type1 : Types.getPrimitiveType((ObjectType)type1);
        PrimitiveType numPriType2 = isPrimitive2 ? (PrimitiveType)type2 : Types.getPrimitiveType((ObjectType)type2);
        expr1 = requireImplicitCast(numPriType1, expr1, expr1.offset);
        expr2 = requireImplicitCast(numPriType2, expr2, expr2.offset);
        if (expr1 == null || expr2 == null) {
            return null;
        }
        return constructBinaryExpr(expr1, expr2, op);
    }
    
    private ExprNode createBinaryMathExpr(ExprNode expr1,ExprNode expr2,String op){
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
    
    private void checkAndBuildInterfaceMethods(ClassNode clazz) {
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

    private void buildLambdaExpressions(ClassNode classNode){
        for(ClassNode c:classNode.classes) {
            buildLambdaExpressions(c);
        }
        List<ClassNode> newLambdaClasses = new LinkedList();
        final List<LambdaExpr> lambdaExprs = new LinkedList<>();
        final Map<LambdaExpr,ClassType> lambdaTypes = new HashMap();
        AstVisitor astVisitor = new AstVisitor(){
            @Override
            public Object visitInvocationExpr(InvocationExpr node) {
                ExprNode[] args = node.getArguments();
                if (args!=null) {
                    Type[] argTypes = node.getMethod().getParameterTypes();
                    for(int i=0;i<args.length;i++) {
                        ExprNode arg = args[i];
                        if (arg instanceof LambdaExpr) {
                            lambdaTypes.put((LambdaExpr) arg ,(ClassType) argTypes[i]);
                        }
                    }
                }
                return super.visitInvocationExpr(node);
            }

            @Override
            public Object visitMultiStmtExpr(MultiStmtExpr node) {
                if (node instanceof LambdaExpr) {
                    lambdaExprs.add((LambdaExpr) node);
                }
                return super.visitMultiStmtExpr(node);
            }
        };
        astVisitor.visit(classNode);
        for (LambdaExpr lambdaExpr:lambdaExprs) {
            ClassType functionType = lambdaExpr.getFunctionType();
            if (functionType==null) {
                functionType = lambdaTypes.get(lambdaExpr);
            }
            if (functionType==null) {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR,"missing type",lambdaExpr.offset);
                continue;
            }
            KalangParser.LambdaExprContext ctx = this.lambdaExprCtxMap.get(lambdaExpr);
            ClassNode lambdaClassNode = this.createFunctionClassNode(functionType,lambdaExpr,ctx);
            ClassType lambdaType = Types.getClassType(lambdaClassNode);
            //lambdaExpr.getReferenceExpr()
            NewObjectExpr newExpr;
            try {
                newExpr = new NewObjectExpr(lambdaType, new ExprNode[0], classNode);
            } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                throw Exceptions.unexceptedException(ex);
            }
            lambdaExpr.setInitExpr(newExpr);
            if (lambdaClassNode!=null) {
                classNode.classes.add(lambdaClassNode);
                newLambdaClasses.add(lambdaClassNode);
            }
        }
        for(ClassNode c:newLambdaClasses) {
            buildLambdaExpressions(c);
        }
    }
    
    private ClassNode createFunctionClassNode(ClassType type,LambdaExpr lambdaExpr,KalangParser.LambdaExprContext ctx){
        Type[] typeArguments = type.getTypeArguments();
        Type returnType = typeArguments[0];
        Type[] paramTypes = new Type[typeArguments.length-1];
        if (paramTypes.length>0){
            System.arraycopy(typeArguments,1,paramTypes,0,paramTypes.length);
        }
        String lambdaName = this.thisClazz.name + "$" + ++anonymousClassCounter;
        ClassNode oldClass = thisClazz;
        MethodNode oldMethod = method;
        ClassNode classNode = thisClazz = new ClassNode(lambdaName,Modifier.PUBLIC);
        classNode.setSuperType(Types.getRootType());
        Map<String, VarObject> accessibleVars = lambdaExpr.getAccessibleVarObjects();
        for( Map.Entry<String, VarObject> v:accessibleVars.entrySet()) {
            String name = v.getKey();
            VarObject var = v.getValue();
            FieldNode f = classNode.createField(var.getType(),name, Modifier.PUBLIC&Modifier.FINAL);
            AssignExpr assignExpr;
            ObjectFieldExpr fieldExpr = new ObjectFieldExpr(new VarExpr(lambdaExpr.getReferenceVar()), f);
            if (var instanceof LocalVarNode) {
                assignExpr = new AssignExpr(fieldExpr,new VarExpr((LocalVarNode)var));
            } else if (var instanceof ParameterNode) {
                assignExpr = new AssignExpr(fieldExpr,new ParameterExpr((ParameterNode)var));
            } else {
                throw Exceptions.unexceptedValue(var);
            }
            lambdaExpr.addStatement(new ExprStmt(assignExpr));
        }
        MethodNode methodNode = classNode.createMethodNode(returnType, "call", Modifier.PUBLIC);
        enterMethod(methodNode);
        List<Token> lambdaParams = ctx.lambdaParams;
        int lambdaParamsCount = ctx.lambdaParams.size();
        if (paramTypes.length < lambdaParams.size()) {
            String msg = String.format("expected %d parameters but got %d",paramTypes.length,lambdaParams.size());
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR,msg,ctx);
            return null;
        }
        for (int i=0;i<lambdaParamsCount;i++) {
            Type pt = paramTypes[i];
            methodNode.createParameter(pt,ctx.lambdaParams.get(i).getText());
        }
        ClassType interfaceType = Types.getFunctionType(returnType, MethodUtil.getParameterTypes(methodNode), NullableKind.NONNULL);
        classNode.addInterface(interfaceType);
        for(int i=lambdaParamsCount+1;i<=FunctionClasses.CLASSES.length-1;i++) {
            LambdaUtil.createBridgeRunMethod(classNode, methodNode,paramTypes, i);
        }
        AstUtil.createEmptyConstructor(classNode);
        List<StatContext> stats = ctx.stat();
        BlockStmt bs = this.newBlock();
        for(StatContext s:stats) {
            Statement statement = visitStat(s);
            if(statement!=null) {
                bs.statements.add(statement);
            }
        }
        if (returnType.equals(Types.getVoidClassType())) {
            bs.statements.add(new ReturnStmt(new ConstExpr(null)));
            returned = true;
        }
        methodNode.getBody().statements.add(bs);
        checkMethod();
        //TODO check return
        thisClazz = oldClass;
        method = oldMethod;
        return classNode;
    }
    
    private void enterMethod(MethodNode method) {
        this.method = method;
        returned = false;
    }
    
    private void checkMethod() {
        MethodNode m = this.method;
        boolean needReturn = (
            m.getType() != null
            && !m.getType().equals(Types.VOID_TYPE)
        );
        BlockStmt mbody = m.getBody();
        if (mbody != null && needReturn && !returned) {
            ConstExpr defaultVal = m.getDefaultReturnValue();
            if (defaultVal!=null) {
                mbody.statements.add(new ReturnStmt(defaultVal));
            } else {
                this.diagnosisReporter.report(
                        Diagnosis.Kind.ERROR
                        , "Missing return statement in method:" + MethodUtil.toString(method)
                        , m.offset
                );
            }
        }
        new InitializationAnalyzer(compilationUnit, astLoader).check(thisClazz, m);
    }
    
    private void processConstructor(ClassNode clazz) {
        thisClazz = clazz;
        processConstructor();
        for (ClassNode c:thisClazz.classes) {
            processConstructor(c);
        }
    }
    
    private void processConstructor() {
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
                mbody.statements.addAll(1, this.thisClazz.initStmts);
            }
        }
    }

    @Nonnull
    private ObjectType getTypeForGeneric(Type type) {
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
    private ExprNode getLambdaCall(String name,ExprNode namedExpr,ExprNode[] args,ParserRuleContext ctx) {
        Type namedExprType = namedExpr.getType();
        if(!Types.isFunctionType(namedExprType)){
            diagnosisReporter.report(Diagnosis.Kind.ERROR,name+" is not callable");
            return null;

        }
        return this.getObjectInvokeExpr(namedExpr,"call",args,ctx);
    }
}
