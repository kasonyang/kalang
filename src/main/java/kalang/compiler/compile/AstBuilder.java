package kalang.compiler.compile;

import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.MethodNotFoundException;
import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParser.*;
import kalang.compiler.antlr.KalangParserVisitor;
import kalang.compiler.ast.*;
import kalang.compiler.compile.analyzer.AstNodeCollector;
import kalang.compiler.core.*;
import kalang.compiler.exception.Exceptions;
import kalang.compiler.function.LambdaExpr;
import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;
import kalang.compiler.util.*;
import kalang.runtime.dynamic.FieldVisitor;
import kalang.runtime.dynamic.MethodDispatcher;
import kalang.type.Function0;
import kalang.type.Function1;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
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
public class AstBuilder extends AstBuilderBase implements KalangParserVisitor<Object> {

    static class VarInfo{
        public Type type;
        public String name;
        public int modifier;
    }

    public static final int
            PARSING_PHASE_INIT = 1,
            PARSING_PHASE_META = 2,
            PARSING_PHASE_ALL = 3;

    private ClassNodeInitializer classNodeInitializer;
    private ClassNodeStructureBuilder classNodeStructureBuilder;

    private Map<LambdaExpr,KalangParser.LambdaExprContext> lambdaExprCtxMap = new HashMap();
    
    private int anonymousClassCounter = 0;

    private int parsingPhase=0;
    //static String DEFAULT_VAR_TYPE;// = "java.lang.Object";

    protected ClassNode thisClazz;

    protected ClassNode topClass;

    @Nonnull
    private AstLoader astLoader;

    private ParserRuleContext compilationContext;

    @Nonnull
    private TokenStream tokenStream;

    @Nonnull
    private final String className;

    @Nonnull
    private KalangParser parser;

    private final CompilationUnit compilationUnit;

    @Nullable
    private LocalVarNode thisVar;

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
            throw Exceptions.unexpectedException(ex);
        }
        body.statements.add(new ThrowStmt(newErrorExpr));
        popBlock();
        return new IfStmt(failExpr,body,null);
    }

    @Override
    ClassNode getCurrentClass() {
        return thisClazz;
    }

    @Override
    ClassNode getTopClass() {
        return topClass;
    }
    
    public ParserRuleContext getParseTree(){
        return compilationContext;
    }

    @Nonnull
    public String getClassName() {
        return className;
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
        compilationUnit.getTypeNameResolver().setAstLoader(astLoader);
        if(targetPhase>=PARSING_PHASE_INIT && parsingPhase < PARSING_PHASE_INIT){
            parsingPhase = PARSING_PHASE_INIT;
            Span span = Profiler.getInstance().beginSpan("parse");
            CompilationUnitContext cunit = parser.compilationUnit();
            Profiler.getInstance().endSpan(span);
            this.compilationContext = cunit;
            for(ImportDeclContext ic:cunit.importDecl()){
                this.visitImportDecl(ic);
            }
            this.classNodeInitializer = new ClassNodeInitializer(this.compilationUnit);
            topClass = classNodeInitializer.build(cunit);
        }
        if(targetPhase>=PARSING_PHASE_META
                && parsingPhase < PARSING_PHASE_META){
            parsingPhase = PARSING_PHASE_META;
            this.classNodeStructureBuilder = new ClassNodeStructureBuilder(this.compilationUnit, parser);
            buildClassNodeMeta(topClass);
        }
        if(targetPhase>=PARSING_PHASE_ALL
                && parsingPhase < PARSING_PHASE_ALL){
            parsingPhase = PARSING_PHASE_ALL;
            visitMethods(topClass);
            processConstructor(topClass);
            checkAndBuildInterfaceMethods(topClass);
        }
    }
    
    private void visitMethods(ClassNode clazz){
        thisClazz = clazz;
        for(MethodNode m:thisClazz.getDeclaredMethodNodes()){
            BlockStmt mbody = m.getBody();
            StatContext[] stats = classNodeStructureBuilder.getStatContexts(m);
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
        super(compilationUnit);
        this.compilationUnit = compilationUnit;
        this.className = compilationUnit.getSource().getClassName();
        this.parser = parser;
        tokenStream = parser.getTokenStream();

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
        return compilationUnit.getCompileContext().getAstLoader();
    }

    @Nonnull
    public TokenStream getTokenStream() {
        return tokenStream;
    }

    @Nonnull
    public KalangParser getParser() {
        return parser;
    }

    @Override
    public ClassType visitLambdaType(KalangParser.LambdaTypeContext ctx) {
        return parseLambdaType(ctx);
    }

    @Override
    public Object visit(ParseTree tree) {
        if (tree == null) {
            System.err.print("visit null");
            Exception ex = new Exception();
            ex.printStackTrace(System.err);
            return null;
        }
        if(tree instanceof StatContext && methodCtx.returned){
            diagnosisReporter.report(Diagnosis.Kind.ERROR
                    ,"unreachable statement"
                    , (StatContext) tree
            );
        }
        return super.visit(tree);
    }
    
    private BlockStmt newBlock(){
        BlockStmt bs = new BlockStmt();
        methodCtx.newFrame();
        return bs;
    }
    
    private void popBlock(){
        methodCtx.popFrame();
    }

    @Nonnull
    public ClassNode getAst() {
        return this.topClass;
    }

    @Override
    public ThrowStmt visitThrowStat(KalangParser.ThrowStatContext ctx) {
        ThrowStmt ts = new ThrowStmt(visitExpression(ctx.expression()));
        mapAst(ts, ctx);
        this.methodCtx.returned = true;
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
            throw Exceptions.unexpectedException(ex);
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
                throw Exceptions.unexpectedException(ex);
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
        methodCtx.newOverrideTypeStack();
        methodCtx.onIf(conditionExpr,true);
        ExprNode trueExpr = (ExprNode) visit(ctx.expression(1));
        methodCtx.popOverrideTypeStack();
        methodCtx.newOverrideTypeStack();
        methodCtx.onIf(conditionExpr,false);
        ExprNode falseExpr = (ExprNode)  visit(ctx.expression(2));
        methodCtx.popOverrideTypeStack();
        Type trueType = trueExpr.getType();
        Type falseType  = falseExpr.getType();
        Type type;
        if(trueType.equals(falseType)){
            type = trueType;
        }else{
            type = TypeUtil.getCommonType(trueType,falseType);
        }
        trueExpr = requireImplicitCast(type, trueExpr, trueExpr.offset);
        falseExpr = requireImplicitCast(type, falseExpr, falseExpr.offset);
        LocalVarNode vo = this.declareTempLocalVar(type);
        VarDeclStmt vds = new VarDeclStmt(vo);
        stmts.add(vds);
        VarExpr ve = new VarExpr(vo);
        IfStmt is = new IfStmt(conditionExpr);
        is.getTrueBody().statements.add(new ExprStmt(new AssignExpr(ve, trueExpr)));
        is.getFalseBody().statements.add(new ExprStmt(new AssignExpr(ve,falseExpr)));
        stmts.add(is);
        MultiStmtExpr mse = new MultiStmtExpr(stmts, ve);
        mapAst(ve, offset(ctx), true);
        return mse;
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
        throw Exceptions.unexpectedException("please create nodes in class node structure builder");
    }
    
    private boolean isNonStaticInnerClass(ClassNode clazz){
        return clazz.enclosingClass!=null && !Modifier.isStatic(clazz.modifier);
    }

    @Override
    public AstNode visitMethodDecl(MethodDeclContext ctx) {
        throw Exceptions.unexpectedException("");
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
        expr = BoxUtil.assign(expr, Types.BOOLEAN_TYPE);
        if (expr == null) {
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, exprType + " cannot be converted to boolean type", ctx.expression());
            return null;
        }
        BlockStmt trueBody = null;
        BlockStmt falseBody = null;
        VarTable<VarObject,Integer> trueAssigned,falseAssigned;
        this.methodCtx.nullState = trueAssigned = this.methodCtx.nullState.newStack();
        methodCtx.newOverrideTypeStack();
        methodCtx.onIf(expr, true);
        if (ctx.trueStmt != null) {
            trueBody=requireBlock(ctx.trueStmt);
        }
        methodCtx.popOverrideTypeStack();
        this.methodCtx.nullState = this.methodCtx.nullState.popStack();
        boolean trueReturned = this.methodCtx.returned;
        this.methodCtx.returned = false;
        this.methodCtx.nullState = falseAssigned = this.methodCtx.nullState.newStack();
        methodCtx.newOverrideTypeStack();
        methodCtx.onIf(expr,false);
        if (ctx.falseStmt != null) {
            falseBody=requireBlock(ctx.falseStmt);
        }
        methodCtx.popOverrideTypeStack();
        this.methodCtx.nullState = this.methodCtx.nullState.popStack();
        methodCtx.handleMultiBranchedAssign(trueAssigned.vars(),falseAssigned.vars());
        boolean falseReturned = this.methodCtx.returned;
        if(trueReturned) methodCtx.onIf(expr,false);
        if(falseReturned) methodCtx.onIf(expr,true);
        this.methodCtx.returned = falseReturned && trueReturned;
        IfStmt ifStmt = new IfStmt(expr,trueBody,falseBody);
        mapAst(ifStmt,ctx);
        return ifStmt;
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
            ExprNode expr = visitExpression(ctx.expression());
            rs.expr = requireImplicitCast(methodCtx.method.getType(), expr, offset(ctx));
            if (rs.expr == null) {
                return null;
            }
        } else if (methodCtx.method.getType().equals(Types.getVoidClassType())) {
            rs.expr = new ConstExpr(null);
        }
        // if(!semanticAnalyzer.validateReturnStmt(methodCtx.method, rs)) return null;
        return this.onReturnStmt(rs);
    }

    @Override
    public Statement visitVarDeclStat(VarDeclStatContext ctx) {
        Statement vars = visitLocalVarDecl(ctx.localVarDecl());
        mapAst(vars,ctx);            
        return vars;
    }

    @Override
    public VarObject visitVarDecl(VarDeclContext ctx) {
        throw Exceptions.unexpectedException("It should never be executed");
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
        if (isDefinedId(name)) {
            diagnosisReporter.report(Diagnosis.Kind.ERROR,"the name is defined already:" + name, ctx);
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
        ExprNode[] args = argsList.toArray(new ExprNode[0]);
        ExprNode ie;
        if(methodName.equals("<init>")){
            if(clazz==null) throw Exceptions.unexpectedValue(clazz);
            try {
                InvocationExpr.MethodSelection apply = InvocationExpr.applyMethod(clazz, methodName, args,clazz.getConstructorDescriptors(thisClazz));
                ie = onInvocationExpr(new ObjectInvokeExpr(target, apply.selectedMethod, apply.appliedArguments));
            } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                this.methodNotFound(ctx.start, clazz.getName(), methodName, args);
                return null;
            }
        }else{
            ie= getImplicitInvokeExpr(methodName,args,ctx);
        }
        return ie;
    }

    protected ExprNode createFieldExpr(GetFieldExprContext to, @Nullable Function0<ExprNode> fromExprCb, OffsetRange offsetRange) {
        //TODO support iterating syntax
        OffsetRange toOffset = offset(to);
        String refKey = to.refKey.getText();
        ExpressionContext exp = to.expression();
        String fname = to.Identifier().getText();
        AstNode expr = (AstNode) visit(exp);
        if (expr == null) return null;
        Function1<ExprNode, ExprNode> createField = (target) -> requireObjectFieldLikeExpr(target, fname, offset(to) ,fromExprCb == null ? null : fromExprCb.call());
        Function1<ExprNode, ExprNode> createDynamicField = (target) -> {
            ExprNode[] params;
            String methodName;
            ClassReference fieldVisitorClsRef = new ClassReference(Types.requireClassType(FieldVisitor.class.getName(), NullableKind.NONNULL).getClassNode());
            if (fromExprCb == null) {
                params = new ExprNode[2];
                params[0] = target;
                params[1] = new ConstExpr(fname);
                methodName = "get";
            } else {
                params = new ExprNode[3];
                params[0] = target;
                params[1] = new ConstExpr(fname);
                params[2] = fromExprCb.call();
                if (params[2] == null) {
                    return null;
                }
                methodName = "set";
            }
            return getStaticInvokeExpr(fieldVisitorClsRef, methodName, params, toOffset);
        };
        if (refKey.equals(".")) {
            if (expr instanceof ExprNode) {
                return createField.call((ExprNode) expr);
            } else if (expr instanceof ClassReference) {
                AssignableExpr sfe = getStaticFieldExpr((ClassReference) expr, fname, toOffset);
                if (sfe == null) {
                    return null;
                }
                if (fromExprCb != null) {
                    return mapAst(new AssignExpr(sfe, fromExprCb.call()), offsetRange);
                }
                return sfe;
            } else {
                throw new UnknownError("unknown node:" + expr);
            }
        } else if (refKey.equals("->")) {
            if (!(expr instanceof ExprNode)) {
                handleSyntaxError("not an expression", expr.offset);
                return null;
            }
            return createDynamicField.call((ExprNode) expr);
        } else if (refKey.equals("*.")) {
            return createStarNavigateExpr(expr, createField, toOffset);
        } else if (refKey.equals("*->")) {
            return createStarNavigateExpr(expr, createDynamicField, toOffset);
        } else if (refKey.equals("?.")) {
            return createSafeNavigateExpr(expr, createField, toOffset);
        } else if (refKey.equals("?->")) {
            return createSafeNavigateExpr(expr, createDynamicField, toOffset);
        } else {
            throw Exceptions.unknownValue(refKey);
        }
    }

    @Override
    public ExprNode visitAssignExpr(AssignExprContext ctx) {
        // execute order: to->from
        String assignOp = ctx.getChild(1).getText();
        ExpressionContext toCtx = ctx.expression(0);
        ExpressionContext fromCtx = ctx.expression(1);
        if ("=".equals(assignOp)) {
            if (toCtx instanceof GetFieldExprContext) {
                return createFieldExpr((GetFieldExprContext) toCtx, ()-> visitExpression(fromCtx), offset(ctx));
            } else if (toCtx instanceof IdentifierExprContext) {
                IdentifierExprContext toIdCtx = (IdentifierExprContext) toCtx;
                AstNode nodeExpr = accessNamedNode(toIdCtx.getText(), offset(toIdCtx), visitExpression(fromCtx), offset(ctx));
                if (!(nodeExpr instanceof  ExprNode)) {
                    handleSyntaxError("expression expected", offset(ctx));
                    return null;
                }
                return (ExprNode) nodeExpr;
            } else {
                ExprNode toExpr = visitExpression(toCtx);
                if (!(toExpr instanceof AssignableExpr)) {
                    handleSyntaxError("expression is not assignable", offset(toCtx));
                    return null;
                }
                AssignableExpr to = (AssignableExpr) toExpr;
                ExprNode from = visitExpression(fromCtx);
                if (from == null) {
                    return null;
                }
                from = requireImplicitCast(to.getType(), from, offset(ctx));
                if (from == null) {
                    return null;
                }
                if (!this.semanticAnalyzer.validateAssign(to, from, offset(ctx), isInConstructor())) {
                    return null;
                }
                AssignExpr assignExpr = new AssignExpr(to, from);
                mapAst(assignExpr, ctx);
                //TODO remove override information before assign
                methodCtx.onAssign(toExpr, from);
                return assignExpr;
            }
        } else {
            ExprNode toValue = visitExpression(toCtx);
            String op = assignOp.substring(0, assignOp.length() - 1);
            List<Statement> initStmts = new LinkedList<>();
            if (toValue instanceof AssignableExpr) {
                AssignableExpr to = (AssignableExpr) toValue;
                to = getSafeAccessibleAssignableExpr(to, initStmts);
                ExprNode from = createBinaryExpr(op, to, () -> visitExpression(fromCtx), offset(ctx));
                if (from == null) {
                    return null;
                }
                AssignExpr assignExpr = new AssignExpr(to, from);
                mapAst(assignExpr, offset(ctx));
                return initStmts.isEmpty() ? assignExpr : mapAst(new MultiStmtExpr(initStmts, assignExpr), offset(ctx));
            }
            if (toCtx instanceof GetFieldExprContext) {
                ExprNode from = createBinaryExpr(op, toValue, () -> visitExpression(fromCtx), offset(ctx));
                return createFieldExpr((GetFieldExprContext)toCtx, () -> from  , offset(ctx));
            } else if (toCtx instanceof IdentifierExprContext) {
                IdentifierExprContext toIdCtx = (IdentifierExprContext) toCtx;
                ExprNode from = createBinaryExpr(op, toValue, () -> visitExpression(fromCtx), offset(ctx));
                AstNode nodeExpr = accessNamedNode(toIdCtx.getText(), offset(toIdCtx), from, offset(ctx));
                if (!(nodeExpr instanceof  ExprNode)) {
                    handleSyntaxError("expression expected", offset(ctx));
                    return null;
                }
                return (ExprNode) nodeExpr;
            } else {
                handleSyntaxError("expression is not assignable", offset(toCtx));
                return null;
            }
        }
    }
    
    private ExprNode createBinaryExpr(String op, ExprNode expr1, ExprCreator expr2Creator, OffsetRange offset){
        ExprNode expr2;
        if ("&&".equals(op) || "||".equals(op)) {
            methodCtx.newOverrideTypeStack();
            expr1 = requireCastToPrimitiveDataType(expr1,expr1.offset);
            if (expr1 == null) {
                return null;
            }
            methodCtx.onIf(expr1,"&&".equals(op));
            expr2 = expr2Creator.createExpr();
            methodCtx.popOverrideTypeStack();
        } else {
            expr2 = expr2Creator.createExpr();
        }
        if (expr2 == null){
            return null;
        }
        Type type1 = expr1.getType();
        Type type2 = expr2.getType();
        boolean isPrimitive1 = (type1 instanceof PrimitiveType);
        boolean isPrimitive2 = (type2 instanceof PrimitiveType);
        ExprNode expr;        
        String errMsg = String.format("bad operand types:%s %s %s",type1,op,type2);
        if (Types.VOID_TYPE.equals(type1) || Types.VOID_TYPE.equals(type2)) {
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, String.format("bad operand types:%s %s %s",type1,op,type2),offset);
            return null;
        }
        
        if ("+".equals(op)) {
            if (Types.isNumber(type1) && Types.isNumber(type2)) {
                expr = this.createBinaryMathExpr(expr1, expr2, op, offset);
            } else if (Types.isStringType(type1)||Types.isStringType(type2)) {
                expr = this.concatExpressionsToStringExpr(new ExprNode[]{expr1,expr2});
            } else {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, errMsg,offset);
                return null;
            }
        } else if ("==".equals(op) || "!=".equals(op)) {
            if (type1 instanceof ObjectType) {
                ClassReference objectsRef = new ClassReference(this.astLoader.loadAst(Objects.class.getName()));
                expr = this.getStaticInvokeExpr(objectsRef, "equals", new ExprNode[]{expr1, expr2}, offset);
                if ("!=".equals(op)) {
                    expr = new UnaryExpr(expr, "!");
                }
            } else if (Types.isNumber(type1) && Types.isNumber(type2) && (isPrimitive1 || isPrimitive2)) {
                expr = this.createBinaryMathExpr(expr1, expr2, op, offset);
            } else if (Types.isBoolean(type1) && Types.isBoolean(type2) && (isPrimitive1 || isPrimitive2)) {
                expr = this.createBinaryBoolOperateExpr(expr1, expr2, op);
            } else {
                expr = this.constructBinaryExpr(expr1, expr2, op);
            }
        } else if ("===".equals(op) || "!==".equals(op)) {
            if (!(type1 instanceof ObjectType)) {
                String msg = "object type is required";
                diagnosisReporter.report(Diagnosis.Kind.ERROR,msg, offset);
                return null;
            }
            expr = constructBinaryExpr(expr1,expr2,op.substring(0,2));
        } else if (">>>".equals(op) || "<<".equals(op) || ">>".equals(op)) {
            if (Types.isExactNumber(type1) && Types.INT_TYPE.equals(type2)) {
                expr1 = BoxUtil.assignToPrimitiveDataType(expr1, type1);
                Objects.requireNonNull(expr1);
                expr1 = BoxUtil.assign(expr1, type1, MathType.getType((PrimitiveType) expr1.getType(), Types.INT_TYPE));
                expr = constructBinaryExpr(expr1, expr2, op);
            } else {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, errMsg, offset);
                return null;
            }
        } else if ("&&".equals(op) || "||".equals(op)) {
            expr2 = requireCastToPrimitiveDataType(expr2,expr2.offset);
            if (expr2 == null ){
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, errMsg, offset);
                return null;
            }
            expr = this.createBinaryBoolOperateExpr(expr1, expr2, op);
        } else {
            expr = this.createBinaryMathExpr(expr1, expr2, op, offset);
        }
        if (expr == null) {
            return null;
        }
        mapAst(expr, offset);
        return expr;
    }

    @Override
    public AstNode visitBinaryExpr(BinaryExprContext ctx) {
        TerminalNode opNode = (TerminalNode) ctx.getChild(1);
        String op = opNode.getText();
        ExprNode expr = createBinaryExpr(op, visitExpression(ctx.expression(0)), () -> visitExpression(ctx.expression(1)), offset(ctx));
        ExprNode valuatedExpr = ConstExprUtil.evaluate(expr);
        return valuatedExpr != null ? valuatedExpr : expr;
    }
    
    @Nullable
    private ExprNode getImplicitInvokeExpr(String methodName,ExprNode[] args, ParserRuleContext ctx){
        AstNode namedNode = this.accessNamedNode(methodName, offset(ctx.start), null, null);
        if (namedNode instanceof ParameterExpr || namedNode instanceof VarExpr) {
            return this.getLambdaCall(methodName,(ExprNode) namedNode,args,ctx);
        }
        ExprNode expr;
        ExprNode invokeTarget = createThisExpr(offset(ctx));
        Type thisType = invokeTarget.getType();

        MethodDescriptor[] namedMethods = new MethodDescriptor[0];
        ClassType clazzType = null;
        if (thisType instanceof ClassType) {
            clazzType = (ClassType) thisType;
            namedMethods = clazzType.getMethodDescriptors(thisClazz, methodName ,true, true);
        }
        if (namedMethods.length<=0 && namedNode instanceof FieldExpr) {
            return this.getLambdaCall(methodName,(FieldExpr)namedNode,args,ctx);
        }
        if (namedMethods.length<=0) {
            ExprNode outerClassExpr = new ThisExpr(thisClazz);
            while(namedMethods.length<=0 && (outerClassExpr = getOuterClassInstanceExpr(outerClassExpr))!=null) {
                namedMethods = ((ObjectType)outerClassExpr.getType()).getMethodDescriptors(thisClazz,methodName,true,true);
            }
            if (namedMethods.length > 0) {
                invokeTarget = outerClassExpr;
            }
        }
        if (namedMethods.length<=0) {
            namedMethods = getStaticImportedMethods(methodName).toArray(new MethodDescriptor[0]);
            if (namedMethods.length>0) {
                clazzType = Types.getClassType(namedMethods[0].getMethodNode().getClassNode());
            }
        }
        if (namedMethods.length <= 0) {
            namedMethods = getImportedMixinMethod(methodName).toArray(new MethodDescriptor[0]);
            if (namedMethods.length > 0) {
                return getObjectInvokeExpr(invokeTarget, methodName, args, ctx);
            }
        }
        try {
            InvocationExpr.MethodSelection ms = InvocationExpr.applyMethod(clazzType, methodName, args,namedMethods);
            if(Modifier.isStatic(ms.selectedMethod.getModifier())){
                expr = onInvocationExpr(new StaticInvokeExpr(new ClassReference(clazzType.getClassNode()), ms.selectedMethod, ms.appliedArguments));
            }else{
                expr = onInvocationExpr(new ObjectInvokeExpr(invokeTarget, ms.selectedMethod, ms.appliedArguments));
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
        ExprNode[] args = argsList.toArray(new ExprNode[0]);
        return getObjectInvokeExpr(target, methodName, args, ctx);
    }
    
    @Nullable
    private ExprNode getObjectInvokeExpr(ExprNode target,String methodName,ExprNode[] args,ParserRuleContext ctx){
        if("<init>".equals(methodName)){
            throw Exceptions.unexpectedException("Don't get constructor by this method.");
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
        MethodDescriptor[] methods = targetClassType.getMethodDescriptors(thisClazz, methodName, true, true);
        ExprNode expr;
        try {
            if (methods.length<=0) {//find mixin method
                List<MethodDescriptor> mixinMethods = getImportedMixinMethod(methodName);
                if (!mixinMethods.isEmpty()) {
                    ClassNode pluginClass = mixinMethods.get(0).getMethodNode().getClassNode();
                    LinkedList<ExprNode> newArgs = new LinkedList();
                    newArgs.add(target);
                    newArgs.addAll(Arrays.asList(args));
                    return getStaticInvokeExpr(new ClassReference(pluginClass),methodName, newArgs.toArray(new ExprNode[0]), offset(ctx));
                }
            }
            InvocationExpr.MethodSelection ms = ObjectInvokeExpr.applyMethod(targetClassType, methodName, args,methods);
            MethodDescriptor md = ms.selectedMethod;
            if(AstUtil.isStatic(md.getModifier())){
                throw new MethodNotFoundException(methodName + " is static");
            }
            InvocationExpr invoke = onInvocationExpr(new ObjectInvokeExpr(target, md, ms.appliedArguments));
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
    
    private  ExprNode getStaticInvokeExpr(ClassReference clazz,String methodName,List<ExpressionContext> argumentsCtx, OffsetRange offsetRange){
        List<Object> argsList = visitAll(argumentsCtx);
        if (argsList.contains(null)) {
            return null;
        }
        ExprNode[] args = argsList.toArray(new ExprNode[0]);
        return getStaticInvokeExpr(clazz, methodName, args, offsetRange);
    }
    
    private  ExprNode getStaticInvokeExpr(ClassReference clazz,String methodName, ExprNode[] argumentsCtx, OffsetRange offset){
        ExprNode expr;
        try {
            expr = onInvocationExpr(StaticInvokeExpr.create(clazz, methodName, argumentsCtx));
        } catch (MethodNotFoundException ex) {
            methodNotFound(offset, clazz.getReferencedClassNode().name, methodName, argumentsCtx);
            expr = new UnknownInvocationExpr(clazz, methodName , argumentsCtx);
        } catch(AmbiguousMethodException ex){
            methodIsAmbiguous(offset, ex);
            return null;
        }
        mapAst(expr, offset);
        return expr;
    }

    @Override
    public AstNode visitInvokeExpr(InvokeExprContext ctx) {
        OffsetRange offsetRange = offset(ctx);
        String mdName = ctx.Identifier().getText();
        Function1<ExprNode, ExprNode> createDotInvoke = (target) -> getObjectInvokeExpr(target, mdName, ctx.params, ctx);
        Function1<ExprNode, ExprNode> createDynamicInvoke = (target) -> {
            ExprNode[] invokeArgs = new ExprNode[3];
            ExprNode[] params = new ExprNode[ctx.params.size()];
            invokeArgs[0] = target;
            invokeArgs[1] = new ConstExpr(mdName);
            for (int i = 0; i < params.length; i++) {
                params[i] = visitExpression(ctx.params.get(i));
            }
            invokeArgs[2] = createInitializedArray(Types.getRootType(), params);
            ClassNode dispatcherAst = astLoader.getAst(MethodDispatcher.class.getName());
            if (dispatcherAst == null) {
                throw Exceptions.unexpectedValue("Runtime library is required!");
            }
            return getStaticInvokeExpr(new ClassReference(dispatcherAst), "invokeMethod", invokeArgs, offset(ctx));
        };
        AstNode target = (AstNode) visit(ctx.target);
        if (target == null) return null;
        String refKey = ctx.refKey.getText();
        if (refKey.equals(".")) {
            if (target instanceof ClassReference) {
                return getStaticInvokeExpr((ClassReference) target, mdName, ctx.params, offset(ctx));
            } else if (target instanceof ExprNode) {
                return createDotInvoke.call((ExprNode) target);
            } else {
                throw Exceptions.unexpectedValue(target);
            }
        } else if (refKey.equals("->")) {
            if (!(target instanceof ExprNode)) {
                handleSyntaxError("expression required", ctx.expression);
                return null;
            }
            return createDynamicInvoke.call((ExprNode) target);
        } else if (refKey.equals("*.")) {
            return createStarNavigateExpr(target, createDotInvoke, offsetRange);
        } else if (refKey.equals("*->")) {
            return createStarNavigateExpr(target, createDynamicInvoke, offsetRange);
        } else if (refKey.equals("?.")) {
            return createSafeNavigateExpr(target, createDotInvoke, offsetRange);
        } else if (refKey.equals("?->")) {
            return createSafeNavigateExpr(target, createDynamicInvoke, offsetRange);
        } else {
            throw Exceptions.unexpectedValue(refKey);
        }
    }

    @Override
    public ExprNode visitGetFieldExpr(GetFieldExprContext ctx) {
        return createFieldExpr(ctx, null,OffsetRangeHelper.getOffsetRange(ctx));
    }

    @Override
    public ExprNode visitUnaryExpr(UnaryExprContext ctx) {
        String op = ctx.getChild(0).getText();
        ExpressionContext exprCtx = ctx.expression();
        ExprNode expr = visitExpression(exprCtx);
        if (expr == null) {
            return null;
        }
        switch(op){
            case UnaryExpr.OPERATION_LOGIC_NOT:
                expr = requireCastable(expr,expr.getType(),Types.BOOLEAN_TYPE,OffsetRangeHelper.getOffsetRange(exprCtx));
                //TODO create a new node for logic-not expression?
                break;
            case UnaryExpr.OPERATION_NEG:
            case UnaryExpr.OPERATION_POS:
            case UnaryExpr.OPERATION_NOT:
                expr = requireCastToPrimitiveDataType(expr,OffsetRangeHelper.getOffsetRange(exprCtx));
                break;
            default:
                throw Exceptions.unexpectedValue(op);
        }
        if (expr == null) {
            return null;
        }
        if (expr instanceof ConstExpr) {
            ConstExpr ce = (ConstExpr) expr;
            if (op.equals(UnaryExpr.OPERATION_LOGIC_NOT)) {
                ce = new ConstExpr(!(Boolean)ce.getValue());
                mapAst(ce, ctx);
                return ce;
            } else if (op.equals(UnaryExpr.OPERATION_NEG)) {
                Object v = ce.getValue();
                if (v instanceof Byte) {
                    v = - (Byte) v;
                } else if (v instanceof Character) {
                    v = - (Character) v;
                } else if (v instanceof Short) {
                    v = - (Short) v;
                } else if (v instanceof Integer) {
                    v = -(Integer) v;
                } else if (v instanceof Long) {
                    v = -(Long) v;
                } else if (v instanceof Float) {
                    v = - (Float) v;
                } else if (v instanceof Double) {
                    v = - (Double) v;
                } else {
                    throw Exceptions.unexpectedValue(v);
                }
                ce = new ConstExpr(v);
                mapAst(ce, ctx);
                return ce;
            }
        }
        UnaryExpr ue = new UnaryExpr(expr, op);
        mapAst(ue, ctx);
        return ue;
    }

    @Override
    public ElementExpr visitGetArrayElementExpr(GetArrayElementExprContext ctx) {
        ElementExpr ee = new ElementExpr(
                visitExpression(ctx.expression(0))
                ,visitExpression(ctx.expression(1))
        );
        mapAst(ee, offset(ctx), true);
        if(!semanticAnalyzer.validateElementExpr(ee)) return null;
        return ee;
    }

    private AstNode accessNamedNode(@Nonnull String name, OffsetRange offset, @Nullable ExprNode assignValue, OffsetRange exprOffset) {
        AstNode node = accessOriginalNamedNode(name, offset,assignValue, exprOffset);
        if (node instanceof ExprNode) {
            ExprNode en = (ExprNode) node;
            Type overrideType = methodCtx.getOverrideType(en);
            if (overrideType != null) {
                node = new CastExpr(overrideType, en);
            }
        }
        return node;
    }

    @Nullable
    private AstNode accessOriginalNamedNode(@Nonnull String name, OffsetRange offset, @Nullable ExprNode assignValue, @Nullable OffsetRange exprOffset) {
        //find local var
        LocalVarNode var = methodCtx!=null ? methodCtx.getNamedLocalVar(name) : null;
        if(var!=null){
            ExprNode result;
            VarExpr ve = new VarExpr(var);
            mapAst(ve, offset);
            if (assignValue != null) {
                result = new AssignExpr(ve, assignValue);
                mapAst(result, exprOffset);
            } else {
                result = ve;
            }
            return result;
        }
        //find parameters
        ParameterNode paramNode = methodCtx==null ? null : methodCtx.getNamedParameter(name);
        if(paramNode!=null){
            ExprNode result;
            ParameterExpr ve = new ParameterExpr(paramNode,methodCtx.getVarObjectType(paramNode));
            mapAst(ve, offset);
            if (assignValue != null) {
                result = new AssignExpr(ve, assignValue);
                mapAst(result, exprOffset);
            } else {
                result = ve;
            }
            return result;
        }
        //find field
        ExprNode outerClassInstanceExpr = createThisExpr(offset);
        while(outerClassInstanceExpr != null){
            ExprNode fe = this.getObjectFieldLikeExpr(outerClassInstanceExpr, name, offset, assignValue);
            if (fe == null && outerClassInstanceExpr instanceof ThisExpr) {
                ClassType outerClassType = (ClassType) outerClassInstanceExpr.getType();
                AssignableExpr staticExpr = this.getStaticFieldExpr(new ClassReference(outerClassType.getClassNode()), name, offset);
                if (staticExpr != null && assignValue != null) {
                    ExprNode result = new AssignExpr(staticExpr, assignValue);
                    mapAst(result, exprOffset);
                    return result;
                }
                fe = staticExpr;
            }
            if (fe == null){
                FieldExpr fieldExpr = this.getObjectFieldExpr(outerClassInstanceExpr, "this$0$" + name, offset);
                if (fieldExpr != null && assignValue != null) {
                    ExprNode result = new AssignExpr(fieldExpr, assignValue);
                    mapAst(result, exprOffset);
                    return result;
                }
                fe = fieldExpr;
            }
            if (fe != null){

                return fe;
            }
            if (outerClassInstanceExpr instanceof FieldExpr || outerClassInstanceExpr instanceof ThisExpr) {
                outerClassInstanceExpr = this.getOuterClassInstanceExpr(outerClassInstanceExpr);
            } else if (outerClassInstanceExpr instanceof VarExpr) {
                outerClassInstanceExpr = new ThisExpr(getThisType());
            } else {
                throw Exceptions.unexpectedValue(outerClassInstanceExpr);
            }
        }
        String resolvedTypeName = compilationUnit.getTypeNameResolver().resolve(name, topClass, thisClazz);
        if (resolvedTypeName!=null) {
            ClassReference clsRef = new ClassReference(requireAst(resolvedTypeName,true, offset));
            mapAst(clsRef, offset);
            if (assignValue != null) {
                handleSyntaxError("expression expected.", offset);
                return null;
            }
            return clsRef;
        }
        return null;
    }

    @Override
    public ExprNode visitLiteral(LiteralContext ctx) {
        return this.parseLiteral(ctx);
    }

    @Override
    public AstNode visitImportDecl(ImportDeclContext ctx) {
        String name = ctx.name.getText();
        String delim = ctx.delim.getText();
        StringBuilder prefix = new StringBuilder();
        String importMode = ctx.importMode != null ? ctx.importMode.getText() : "";
        boolean isImportStatic = false;
        boolean isImportMixin = false;
        if (importMode.equals("static")) {
            isImportStatic = true;
        } else if (importMode.equals("mixin")) {
            isImportMixin = true;
        } else if (!importMode.isEmpty()) {
            throw Exceptions.unexpectedValue(importMode);
        }
        if("\\".equals(delim)){
            boolean relative = ctx.root == null || ctx.root.getText().length() == 0;
            String packageName = this.getPackageName();
            if (relative && packageName.length() > 0) {
                prefix = new StringBuilder(packageName + ".");
            }
        }
        if (ctx.path != null) {
            for (Token p : ctx.path) {
                prefix.append(p.getText()).append(".");
            }
        }
        TypeNameResolver typeNameResolver = compilationUnit.getTypeNameResolver();
        if (name.equals("*")) {
            String location = prefix.substring(0, prefix.length() - 1);
            if (isImportStatic || isImportMixin) {
                ClassNode locationCls = requireAst(location, ctx.stop,true);
                if (locationCls==null) {
                    return null;
                }
                if (isImportStatic) {
                    importStaticMember(locationCls,null);
                } else {
                    importMixinMethod(locationCls, null);
                }
            } else {
                typeNameResolver.importPackage(location);
            }

        } else {
            String key = name;
            if (ctx.alias != null) {
                key = ctx.alias.getText();
            }
            if (isImportStatic || isImportMixin) {
                //TODO support alias
                String location = prefix.substring(0,prefix.length()-1);
                ClassNode locationCls = requireAst(location, ctx.stop,true);
                if (locationCls==null) return null;
                if (isImportStatic) {
                    importStaticMember(locationCls,name);
                } else {
                    importMixinMethod(locationCls, name);
                }
            }else{
                typeNameResolver.importClass(prefix + name,key);
            }
        }        
        return null;
    }

    @Override
    public AstNode visitQualifiedName(QualifiedNameContext ctx) {
        //do nothing
        return null;
    }

    @Override
    public AstNode visitNewExpr(NewExprContext ctx) {
        ObjectType clsType = parseClassType(ctx.classType());
        if(clsType==null) return null;
        List<Object> paramExprsList = visitAll(ctx.params);
        if (paramExprsList.contains(null)) {
            return null;
        }
        ExprNode[] params = paramExprsList.toArray(new ExprNode[0]);
        List<ExprNode> paramList = new LinkedList(Arrays.asList(params));
        NewObjectExpr newExpr;
        try {
            if(this.isNonStaticInnerClass(clsType.getClassNode())){
                paramList.add(0,new ThisExpr(this.getThisType()));
            }
            params = paramList.toArray(new ExprNode[0]);
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
        boolean tryReturned = this.methodCtx.returned;
        List<CatchBlock> tryCatchBlocks = new LinkedList<>();
        if (ctx.catchTypes != null) {
            for (int i = 0; i < ctx.catchTypes.size(); i++) {
                methodCtx.newFrame();
                this.methodCtx.returned = false;
                String vName = ctx.catchVarNames.get(i).getText();
                String vType = ctx.catchTypes.get(i).getText();
                LocalVarNode vo = this.declareLocalVar(vName,requireClassType(vType, ctx.catchTypes.get(i).start),Modifier.FINAL,offset(ctx));
                if(vo==null) return null;
                BlockStmt catchExecStmt = requireBlock(ctx.catchExec.get(i));
                CatchBlock catchStmt = new CatchBlock(vo,catchExecStmt); 
                tryCatchBlocks.add(catchStmt);
                this.methodCtx.returned = this.methodCtx.returned && tryReturned;
                methodCtx.popFrame();
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
            ExprNode initExpr = null;
            ExpressionContext initExprContext = v.expression();
            if(initExprContext!=null){
                if(initExprContext instanceof LiteralExprContext){
                    initExpr = this.parseLiteral(((LiteralExprContext) initExprContext).literal());
                }else{
                    initExpr = visitExpression(initExprContext);
                }
            }
            if (initExpr != null) {
                Type initType = initExpr.getType();
                if (Types.isVoid(initType)) {
                    handleSyntaxError("could not create variable for " + initType.getName() + " type", offset(ctx));
                    return null;
                }
            }
            VarInfo varInfo = varDecl(v,initExpr==null
                    ?Types.getRootType()
                    :initExpr.getType()
            );
            LocalVarNode localVar = this.declareLocalVar(varInfo.name, varInfo.type,varInfo.modifier,offset(ctx));
            if(localVar==null) return null;
            VarDeclStmt vds = new VarDeclStmt(localVar);
            ms.statements.add(vds);
            if(initExpr!=null){
                initExpr = requireImplicitCast(localVar.getType(), initExpr, offset(ctx));
                if (initExpr == null) {
                    continue;
                }
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
        AstNode expr = this.accessNamedNode(name, offset(ctx.Identifier().getSymbol()), null, null);
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
        methodCtx.newFrame();
        if (stats == null) {
            return;
        }
        for (StatContext s : stats) {
            blockStmt.statements.add(visitStat(s));
        }
        methodCtx.popFrame();
    }

    @Override
    public AstNode visitBlockStmt(BlockStmtContext ctx) {
        BlockStmt bs =newBlock();
        List<StatContext> stats = ctx.stat();
        if(stats!=null){
            this.visitBlockStmt(stats.toArray(new StatContext[0]), bs);
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
        if(key.equals("this")){
            return this.createThisExpr(offset(ctx));
        }else if(key.equals("super")){
            ExprNode expr = new SuperExpr(thisClazz);
            mapAst(expr, ctx);
            return expr;
        }else{
            throw Exceptions.unknownValue(key);
        }
    }

    @Override
    public Object visitPrimitiveType(KalangParser.PrimitiveTypeContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ExprNode visitIncExpr(KalangParser.IncExprContext ctx) {
        return getIncrementExpr(ctx.expression(), ctx.op.getText(), false);
    }

    @Override
    public ExprNode visitPreIncExpr(KalangParser.PreIncExprContext ctx) {
        return getIncrementExpr(ctx.expression(), ctx.op.getText(), true);
    }
    
    public ExprNode getIncrementExpr(ExpressionContext expressionContext,String op,boolean isOperatorFirst){
        ExprNode expr = visitExpression(expressionContext);
        if(!(expr instanceof AssignableExpr)){
            AstBuilder.this.handleSyntaxError("require assignable expression", expressionContext);
            return null;
        }
        boolean isDesc = op.equals("--");
        ExprNode reference;
        List<Statement> initStmts = new LinkedList<>();
        AssignableExpr safeTo = getSafeAccessibleAssignableExpr((AssignableExpr) expr, initStmts);
        if (!isOperatorFirst) {
            LocalVarNode tmpVar = declareTempLocalVar(safeTo.getType());
            initStmts.add(new VarDeclStmt(tmpVar));
            initStmts.add(new ExprStmt(new AssignExpr(new VarExpr(tmpVar), safeTo)));
            reference = new VarExpr(tmpVar);
        } else {
            reference = safeTo;
        }
        ExprNode addOneExpr = createBinaryMathExpr(safeTo, new ConstExpr(1), isDesc ? "-" : "+", safeTo.offset);
        initStmts.add(new ExprStmt(new AssignExpr(safeTo, addOneExpr)));
        return new  MultiStmtExpr(initStmts, reference);
    }

    @Override
    public Object visitErrorousStat(KalangParser.ErrorousStatContext ctx) {
        handleSyntaxError("missing ';'", ctx.start , ctx.stop);
        return null;
    }

    @Override
    public Object visitErrorousMemberExpr(KalangParser.ErrorousMemberExprContext ctx) {
        handleSyntaxError("identifier excepted", ctx.stop , ctx.stop);
        return null;
    }

    @Override
    public Object visitInstanceofExpr(KalangParser.InstanceofExprContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        Token ts = ctx.Identifier().getSymbol();
        AstNode tnode = accessNamedNode(ts.getText(), offset(ts), null, null);
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
        throw Exceptions.unexpectedException("");
    }

    @Override
    public Object visitCompileOption(KalangParser.CompileOptionContext ctx) {
        return null;//Do noting
        //throw Exceptions.unexpectedException("");
    }
    
    @Override
    public Object visitLambdaExpr(KalangParser.LambdaExprContext ctx) {
        KalangParser.LambdaTypeContext lambdaTypeCtx = ctx.lambdaType();
        ClassType functionType = null;
        if (lambdaTypeCtx!=null) {
            ClassType lambdaType = this.visitLambdaType(lambdaTypeCtx);
            //TODO handle unexpected type?
            if (Types.isFunctionType(lambdaType)) {
                functionType = lambdaType;
            }
        }
        List<Token> lambdaParams = ctx.lambdaParams;
        int lambdaParamsCount = lambdaParams == null ? 0 : lambdaParams.size();
        Type type = functionType!=null ? functionType : new LambdaType(lambdaParamsCount);
        LambdaExpr ms = new LambdaExpr(type);
        Map<String,VarObject> accessibleVars = new HashMap();
        VarTable<String, LocalVarNode> vtb = this.methodCtx.varTables;
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
        ParameterNode[] paramNodes = this.methodCtx.method.getParameters();
        for(ParameterNode p:paramNodes) {
            String name = p.getName();
            if (!accessibleVars.containsKey(name)) {
                accessibleVars.put(name, p);
            }
        }
        for(Map.Entry<String, VarObject> e:accessibleVars.entrySet()) {
            ms.putAccessibleVarObject(e.getKey(), e.getValue());
        }
        if (functionType!=null){
            MethodDescriptor funcMethod = LambdaUtil.getFunctionalMethod(functionType);
            Objects.requireNonNull(funcMethod);
            ms.setInterfaceMethod(funcMethod);
            createLambdaNode(ms,ctx);
        } else {
            lambdaExprCtxMap.put(ms, ctx);
        }
        return ms;
    }

    @Nullable
    private ExprNode getOuterClassInstanceExpr(ExprNode expr){
        return this.getObjectFieldExpr(expr, "this$0", OffsetRange.NONE);
    }

    @Override
    public Object visitClassDef(KalangParser.ClassDefContext ctx) {
        throw Exceptions.unexpectedException("");
    }

    @Override
    @Nullable
    public AnnotationNode visitAnnotation(KalangParser.AnnotationContext ctx) {
        return parseAnnotation(ctx);
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

    @Override
    public Object visitWildcardType(KalangParser.WildcardTypeContext ctx) {
        return null;
    }

    public ObjectType getThisType() {
        return Types.getClassType(thisClazz);
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
            LocalVarNode indexVar = this.declareLocalVar(indexId.getText(),Types.INT_TYPE,Modifier.FINAL,offset(ctx));
            if(indexVar==null) return null;
            block.statements.add(new VarDeclStmt(indexVar));
            indexVarExpr = new VarExpr(indexVar);         
            varId = idsCtx.get(1);
        }
        LoopStmt loopStmt;
        if(exprType instanceof ArrayType){
            LocalVarNode localVarNode = this.declareLocalVar(varId.getText(),  ((ArrayType) exprType).getComponentType(), 0, offset(ctx));
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
            ExprNode cnd = new CompareBinaryExpr(counterVarExpr, lenVarExpr, CompareBinaryExpr.OP_LT);
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
                        counterVarExpr,new ArithmeticBinaryExpr(counterVarExpr, new ConstExpr(1), ArithmeticBinaryExpr.OP_ADD)
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
                    throw Exceptions.unexpectedException(ex);
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
                    throw Exceptions.unexpectedException(ex);
                }
                BlockStmt loopBody = this.newBlock();
                ObjectInvokeExpr nextInvokeExpr;
                try {
                    nextInvokeExpr = ObjectInvokeExpr.create(iterableVarExpr, "next", null);
                } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                    throw Exceptions.unexpectedException(ex);
                }
                LocalVarNode localVarNode = this.declareLocalVar(varId.getText(), nextInvokeExpr.getType(),0, offset(ctx));
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
                                    ,new ArithmeticBinaryExpr(indexVarExpr,new ConstExpr(1),BinaryExpr.OP_ADD)
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
            if(exprCtx==null) throw Exceptions.unexpectedValue(exprCtx);
            initExprs[i] = requireCastable(initExprs[i], initExprs[i].getType(), type,OffsetRangeHelper.getOffsetRange(exprCtx.get(i)));
            if(initExprs[i]==null) return null;
        }
        ExprNode arrExpr = createInitializedArray(type, initExprs);
        mapAst(arrExpr, ctx);
        return arrExpr;
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
                        throw Exceptions.unexpectedValue(t);
                }
                exprs[i]=new ConstExpr(StringLiteralUtil.parse(text));
                exprTokens[i] = token;
            }else if(c instanceof ExpressionContext){
                ExprNode expr = this.visitExpression((ExpressionContext) c);
                if(expr==null) return null;
                exprs[i]=expr;
                exprTokens[i] = ((ExpressionContext) c).getStart();
            }else{
                throw Exceptions.unexpectedValue(c);
            }
        }
        return this.concatExpressionsToStringExpr(exprs);
    }

    @Override
    public Object visitBitShiftExpr(KalangParser.BitShiftExprContext ctx) {
        String op;
        if(ctx.left!=null){
            op = "<<";
        }else if(ctx.right!=null){
            op = ">>";
        }else if(ctx.uright!=null){
            op = ">>>";
        }else{
            throw Exceptions.unexpectedValue(ctx);
        }
        return this.createBinaryExpr(op, visitExpression(ctx.expression(0)),()->visitExpression(ctx.expression(1)), offset(ctx));
    }

    @Override
    public Object visitWithExpr(WithExprContext ctx) {
        ExprNode targetExpr = visitExpression(ctx.expression());
        LocalVarNode oldThisVar = thisVar;
        thisVar = declareTempLocalVar(targetExpr.getType());
        List<Statement> initStmts = new LinkedList<>();
        initStmts.add(new VarDeclStmt(thisVar));
        initStmts.add(new ExprStmt(new AssignExpr(new VarExpr(thisVar),targetExpr)));
        methodCtx.newFrame();
        for (StatContext s: ctx.stat()) {
            Statement statement = visitStat(s);
            initStmts.add(statement);
        }
        methodCtx.popFrame();
        MultiStmtExpr e = new MultiStmtExpr(initStmts, new VarExpr(thisVar));
        mapAst(e, ctx);
        thisVar = oldThisVar;
        return e;
    }

    public DiagnosisReporter getDiagnosisReporter() {
        return diagnosisReporter;
    }

    private void createLambdaNode(LambdaExpr lambdaExpr,KalangParser.LambdaExprContext ctx){
        MethodDescriptor funcMethod = lambdaExpr.getInterfaceMethod();
        Type returnType = funcMethod.getReturnType();
        Type[] paramTypes = funcMethod.getParameterTypes();
        String lambdaName = "lambda$" + ++anonymousClassCounter;
        MethodContext oldMethodCtx = this.methodCtx;
        MethodNode methodNode = thisClazz.createMethodNode(returnType, lambdaName , Modifier.PUBLIC);
        enterMethod(methodNode);
        Map<String, VarObject> accessibleVars = lambdaExpr.getAccessibleVarObjects();
        for( Map.Entry<String, VarObject> v:accessibleVars.entrySet()) {
            String name = v.getKey();
            VarObject var = v.getValue();
            methodNode.createParameter(var.getType(), name, Modifier.FINAL | ModifierConstant.SYNTHETIC);
        }
        List<Token> lambdaParams = ctx.lambdaParams;
        if (paramTypes.length < lambdaParams.size()) {
            String msg = String.format("expected %d parameters but got %d",paramTypes.length,lambdaParams.size());
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR,msg,ctx);
            return;
        }
        for (int i=0;i<paramTypes.length;i++) {
            Type pt = paramTypes[i];
            String name = null;
            if (i<ctx.lambdaParams.size()) {
                name = ctx.lambdaParams.get(i).getText();
            }
            methodNode.createParameter(pt,name);
        }
        BlockStmt bs = this.newBlock();
        ExpressionContext bodyExprCtx = ctx.expression();
        if (bodyExprCtx != null) {
            ExprNode bodyExpr = visitExpression(bodyExprCtx);
            if (!returnType.equals(Types.VOID_TYPE)) {
                bodyExpr = requireImplicitCast(methodCtx.method.getType(), bodyExpr, offset(bodyExprCtx));
                if (bodyExpr != null) {
                    bs.statements.add(onReturnStmt(new ReturnStmt(bodyExpr)));
                }
            } else {
                bs.statements.add(new ExprStmt(bodyExpr));
            }
        } else {
            List<StatContext> stats = ctx.stat();
            for(StatContext s:stats) {
                Statement statement = visitStat(s);
                if(statement!=null) {
                    bs.statements.add(statement);
                }
            }
        }
        if (returnType.equals(Types.getVoidClassType())) {
            bs.statements.add(onReturnStmt(new ReturnStmt(new ConstExpr(null))));
            methodCtx.returned = true;
        }
        methodNode.getBody().statements.add(bs);
        popBlock();
        checkMethod();
        //TODO check return
        Set<ParameterNode> usedParamNodes = new HashSet<>();
        new AstNodeCollector().collect(methodNode, ParameterExpr.class).forEach(it -> usedParamNodes.add(it.getParameter()));
        for (ParameterNode p: methodNode.getParameters()) {
            if (!ModifierUtil.isSynthetic(p.modifier)) {
                break;
            }
            if (!usedParamNodes.contains(p)) {
                methodNode.removeParameter(p);
            }
        }
        lambdaExpr.setInvokeMethod(methodNode);
        List<ExprNode> captureArgs = lambdaExpr.getCaptureArguments();
        for (ParameterNode p: methodNode.getParameters()) {
            if (!ModifierUtil.isSynthetic(p.modifier)) {
                break;
            }
            VarObject captureVar = accessibleVars.get(p.getName());
            Objects.requireNonNull(captureVar);
            if (captureVar instanceof LocalVarNode) {
                captureArgs.add(new VarExpr((LocalVarNode) captureVar));
            } else if (captureVar instanceof ParameterNode) {
                captureArgs.add(new ParameterExpr((ParameterNode) captureVar));
            } else {
                throw Exceptions.unexpectedValue(captureVar);
            }
        }
        methodCtx = oldMethodCtx;
    }

    private void processConstructor(ClassNode clazz) {
        thisClazz = clazz;
        processConstructor();
        for (ClassNode c:thisClazz.classes) {
            processConstructor(c);
        }
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

    private void buildClassNodeMeta(ClassNode cn) {
        ParserRuleContext ctx = classNodeInitializer.getClassNodeDefContext(cn);
        if (ctx!=null) {
            classNodeStructureBuilder.build(topClass,cn,ctx);
        }
        for(ClassNode c:cn.classes) {
            buildClassNodeMeta(c);
        }
    }

    private ReturnStmt onReturnStmt(ReturnStmt rs) {
        this.methodCtx.returned = true;
        Type rType = methodCtx.method.getType();
        if(rs.expr != null && rType instanceof GenericType) {
            Type eType = rs.expr.getType();
            Type oldType = thisClazz.inferredGenericTypes.get(rType);
            Type newType = oldType == null ? eType : TypeUtil.getCommonType(oldType, eType);
            thisClazz.inferredGenericTypes.put((GenericType) rType,newType);
        }
        return rs;
    }

    private InvocationExpr onInvocationExpr(InvocationExpr invocationExpr){
        ExprNode[] args = invocationExpr.getArguments();
        Type[] paramTypes = invocationExpr.getMethod().getParameterTypes();
        for(int i=0;i<args.length;i++) {
            ExprNode arg = args[i];
            if (arg instanceof LambdaExpr) {
                boolean isInit = ((LambdaExpr) arg).getInterfaceMethod() != null;
                if (!isInit) {
                    ClassType lambdaType = (ClassType) inferLambdaType(paramTypes[i]);
                    LambdaExprContext ctx = lambdaExprCtxMap.get(arg);
                    MethodDescriptor funcMethod = LambdaUtil.getFunctionalMethod(lambdaType);
                    Objects.requireNonNull(funcMethod);
                    LambdaExpr lambdaArg = (LambdaExpr) arg;
                    lambdaArg.setInterfaceMethod(funcMethod);
                    createLambdaNode(lambdaArg, ctx);
                }
            }
        }
        Map<GenericType, Type> inferredTypes = thisClazz.inferredGenericTypes;
        if (!inferredTypes.isEmpty()) {
            MethodDescriptor md = invocationExpr.getMethod();
            for(int i=0;i<paramTypes.length;i++) {
                if (paramTypes[i] instanceof ClassType) {
                    paramTypes[i] = ((ClassType) paramTypes[i]).toParameterized(inferredTypes);
                }
            }
            MethodDescriptor newMd = md.toParameterized(inferredTypes, paramTypes);
            if (invocationExpr instanceof StaticInvokeExpr) {
                invocationExpr = new StaticInvokeExpr(((StaticInvokeExpr) invocationExpr).getInvokeClass(),newMd,args);
            } else if (invocationExpr instanceof ObjectInvokeExpr) {
                invocationExpr = new ObjectInvokeExpr(((ObjectInvokeExpr) invocationExpr).getInvokeTarget(),newMd,args);
            }
        }
        return invocationExpr;
    }

    private ExprNode createStarNavigateExpr(AstNode target, Function1<ExprNode, ExprNode> navigateExprMaker, OffsetRange offset) {
        if (!(target instanceof ExprNode)) {
            handleSyntaxError("expression required", target.offset);
            return null;
        }
        ExprNode targetExpr = (ExprNode) target;
        Type targetType = targetExpr.getType();
        if (!(targetType instanceof ArrayType)) {
            handleSyntaxError("array required", target.offset);
            return null;
        }
        List<Statement> stats = new LinkedList<>();
        targetExpr = createSafeAccessibleExpr(targetExpr, stats);
        LocalVarNode varArrLen = this.declareTempLocalVar(Types.INT_TYPE);
        LocalVarNode varCounter = this.declareTempLocalVar(Types.INT_TYPE);
        stats.add(new VarDeclStmt(Arrays.asList(varArrLen, varCounter)));
        VarExpr varArrLenExpr = new VarExpr(varArrLen);
        VarExpr varCounterExpr = new VarExpr(varCounter);
        stats.add(new ExprStmt(new AssignExpr(varArrLenExpr, new ArrayLengthExpr(targetExpr))));
        stats.add(new ExprStmt(new AssignExpr(varCounterExpr, new ConstExpr(0))));
        CompareBinaryExpr conditionExpr = new CompareBinaryExpr(varCounterExpr, varArrLenExpr, CompareBinaryExpr.OP_LT);
        ExprNode targetEleExpr = new ElementExpr(targetExpr, varCounterExpr);
        ExprNode invokeExpr = navigateExprMaker.call(targetEleExpr);
        if (invokeExpr == null) return null;
        LocalVarNode varRet = this.declareTempLocalVar(Types.getArrayType(invokeExpr.getType()));
        VarExpr varRetExpr = new VarExpr(varRet);
        stats.add(new VarDeclStmt(varRet));
        stats.add(new ExprStmt(new AssignExpr(varRetExpr, new NewArrayExpr(invokeExpr.getType(), varArrLenExpr))));
        BlockStmt loopBody = this.newBlock();
        loopBody.statements.add(new ExprStmt(new AssignExpr(new ElementExpr(varRetExpr, varCounterExpr), invokeExpr)));
        popBlock();
        BlockStmt updateBs = newBlock();
        updateBs.statements.add(new ExprStmt(new AssignExpr(varCounterExpr, new ArithmeticBinaryExpr(varCounterExpr, new ConstExpr(1), ArithmeticBinaryExpr.OP_ADD))));
        this.popBlock();
        LoopStmt loopStmt = new LoopStmt(conditionExpr, null, loopBody, updateBs);
        stats.add(loopStmt);
        MultiStmtExpr expr = new MultiStmtExpr(stats, varRetExpr);
        mapAst(expr, offset);
        return expr;
    }

    private ExprNode createSafeNavigateExpr(AstNode target, Function1<ExprNode, ExprNode> navigateExprMaker, OffsetRange offsetRange) {
        if (!(target instanceof ExprNode)) {
            handleSyntaxError("expression required", target.offset);
            return null;
        }
        ExprNode targetExpr = (ExprNode) target;
        List<Statement> stmts = new LinkedList<>();
        LocalVarNode targetTmpVar = declareTempLocalVar(targetExpr.getType());
        stmts.add(new VarDeclStmt(targetTmpVar));
        stmts.add(new ExprStmt(new AssignExpr(new VarExpr(targetTmpVar), targetExpr)));
        ExprNode conditionExpr = new CompareBinaryExpr(new VarExpr(targetTmpVar), new ConstExpr(null), "==");
        methodCtx.newOverrideTypeStack();
        methodCtx.onIf(conditionExpr, true);
        methodCtx.popOverrideTypeStack();
        methodCtx.newOverrideTypeStack();
        methodCtx.onIf(conditionExpr, false);
        ExprNode targetTmpExpr = new VarExpr(targetTmpVar, methodCtx.getVarObjectType(targetTmpVar));
        ExprNode falseExpr = navigateExprMaker.call(targetTmpExpr);
        if (falseExpr == null) {
            return null;
        }
        ExprNode trueExpr = Values.getDefaultValue(falseExpr.getType());
        methodCtx.popOverrideTypeStack();
        LocalVarNode vo = this.declareTempLocalVar(falseExpr.getType());
        VarDeclStmt vds = new VarDeclStmt(vo);
        stmts.add(vds);
        VarExpr ve = new VarExpr(vo);
        IfStmt is = new IfStmt(conditionExpr);
        is.getTrueBody().statements.add(new ExprStmt(new AssignExpr(ve, trueExpr)));
        is.getFalseBody().statements.add(new ExprStmt(new AssignExpr(ve, falseExpr)));
        stmts.add(is);
        MultiStmtExpr mse = new MultiStmtExpr(stmts, ve);
        mapAst(ve, offsetRange);
        return mse;
    }

    private ExprNode createThisExpr(OffsetRange offset) {
        ExprNode expr;
        if (thisVar != null) {
            expr = new VarExpr(thisVar);
        } else {
            expr = new ThisExpr(getThisType());
        }
        expr.offset = offset;
        return expr;
    }



}
