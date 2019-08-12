package kalang.compiler.compile;

import kalang.compiler.AmbiguousMethodException;
import kalang.compiler.MethodNotFoundException;
import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParser.*;
import kalang.compiler.antlr.KalangParserVisitor;
import kalang.compiler.ast.*;
import kalang.compiler.core.*;
import kalang.compiler.exception.Exceptions;
import kalang.compiler.function.LambdaExpr;
import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;
import kalang.compiler.util.*;
import kalang.runtime.dynamic.MethodDispatcher;
import kalang.type.Function2;
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

    private ClassNode topClass;

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
        expr = BoxUtil.assignToPrimitiveDataType(expr, expr.getType());
        if (expr == null) {
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, exprType + " cannot be converted to primitive data type", ctx.expression());
            return null;
        }
        if (!Types.isIntCompatibleType(expr.getType())) {
            expr = createBinaryMathExpr(expr,new ConstExpr(0),BinaryExpr.OP_NE);
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
            rs.expr = visitExpression(ctx.expression());
        } else if (methodCtx.method.getType().equals(Types.getVoidClassType())) {
            rs.expr = new ConstExpr(null);
        }
        if(!semanticAnalyzer.validateReturnStmt(methodCtx.method, rs)) return null;
        this.methodCtx.returned = true;
        Type rType = methodCtx.method.getType();
        if(rs.expr!=null && rType instanceof GenericType) {
            Type eType = rs.expr.getType();
            Type oldType = thisClazz.inferredGenericTypes.get(rType);
            Type newType = oldType == null ? eType : TypeUtil.getCommonType(oldType, eType);
            thisClazz.inferredGenericTypes.put((GenericType) rType,newType);
        }
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
        ExprNode[] args = argsList.toArray(new ExprNode[argsList.size()]);
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
                fieldExpr = getObjectFieldLikeExpr(exprNode,fname,offset(to));
            }else if(expr instanceof ClassReference){
                fieldExpr = getStaticFieldExpr((ClassReference)expr, fname, offset(to));
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
                methodCtx.onAssign(toExpr,from);
                expr = aexpr;
            }else{
                AstBuilder.this.handleSyntaxError("unsupported assign statement",ctx);
                return null;
            }
        }
        return expr;
    }
    
    private ExprNode createBinaryExpr(String op,ExpressionContext exprCtx1,ExpressionContext exprCtx2,ParserRuleContext ctx){
        ExprNode expr1 = visitExpression(exprCtx1);
        if (expr1 == null) {
            return null;
        }
        ExprNode expr2;
        if ("&&".equals(op) || "||".equals(op)) {
            methodCtx.newOverrideTypeStack();
            expr1 = requireCastToPrimitiveDataType(expr1,OffsetRangeHelper.getOffsetRange(exprCtx1));
            if (expr1 == null) {
                return null;
            }
            methodCtx.onIf(expr1,"&&".equals(op));
            expr2 = visitExpression(exprCtx2);
            methodCtx.popOverrideTypeStack();
        } else {
            expr2 = visitExpression(exprCtx2);
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
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR, String.format("bad operand types:%s %s %s",type1,op,type2),ctx);
            return null;
        }
        
        if ("+".equals(op)) {
            if (Types.isNumber(type1) && Types.isNumber(type2)) {
                expr = this.createBinaryMathExpr(expr1, expr2, op);
            } else if (Types.isStringType(type1)||Types.isStringType(type2)) {
                expr = this.concatExpressionsToStringExpr(new ExprNode[]{expr1,expr2});
            } else {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR, errMsg,ctx);
                return null;
            }
        } else if ("==".equals(op) || "!=".equals(op)) {
            if (type1 instanceof ObjectType) {
                ClassReference objectsRef = new ClassReference(this.astLoader.loadAst(Objects.class.getName()));
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
            expr2 = requireCastToPrimitiveDataType(expr2,OffsetRangeHelper.getOffsetRange(exprCtx2));
            if (expr2 == null ){
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
        ExprNode invokeTarget = new ThisExpr(clazzType);
        MethodDescriptor[] namedMethods = clazzType.getMethodDescriptors(thisClazz, methodName ,true, true);
        if (namedMethods.length<=0 && namedNode instanceof FieldExpr) {
            return this.getLambdaCall(methodName,(FieldExpr)namedNode,args,ctx);
        }
        if (namedMethods.length<=0) {
            ExprNode outerClassExpr = new ThisExpr(thisClazz);
            while(namedMethods.length<=0 && (outerClassExpr = getOuterClassInstanceExpr(outerClassExpr))!=null) {
                namedMethods = ((ObjectType)outerClassExpr.getType()).getMethodDescriptors(thisClazz,methodName,true,true);
            }
            invokeTarget = outerClassExpr;
        }
        if (namedMethods.length<=0) {
            namedMethods = getStaticImportedMethods(methodName).toArray(new MethodDescriptor[0]);
            if (namedMethods.length>0) {
                clazzType = Types.getClassType(namedMethods[0].getMethodNode().getClassNode());
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
        ExprNode[] args = argsList.toArray(new ExprNode[argsList.size()]);
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
            if (methods.length<=0) {//find plugin method
                List<MethodDescriptor> pluginMethods = getImportedPluginMethod(methodName);
                if (!pluginMethods.isEmpty()) {
                    ClassNode pluginClass = pluginMethods.get(0).getMethodNode().getClassNode();
                    LinkedList<ExprNode> newArgs = new LinkedList();
                    newArgs.add(target);
                    newArgs.addAll(Arrays.asList(args));
                    return getStaticInvokeExpr(new ClassReference(pluginClass),methodName, newArgs.toArray(new ExprNode[0]),ctx);
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
            expr = onInvocationExpr(StaticInvokeExpr.create(clazz, methodName, args));
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
        Function2<ExprNode,AstNode,String> createDotInvoke = (target, mdName) -> {
            if(target instanceof ClassReference){
                return getStaticInvokeExpr((ClassReference) target, mdName,ctx.params, ctx);
            }else if(target instanceof ExprNode){
                return getObjectInvokeExpr((ExprNode) target, mdName, ctx.params,ctx);
            }else{
                throw Exceptions.unexpectedValue(target);
            }
        };
        Function2<ExprNode,ExprNode,String> createDynamicInvoke = (target,mdName) -> {
            ExprNode[] invokeArgs = new ExprNode[3];
            ExprNode[] params = new ExprNode[ctx.params.size()];
            invokeArgs[0] = target;
            invokeArgs[1] = new ConstExpr(mdName);
            for(int i=0;i<params.length;i++){
                params[i] = visitExpression(ctx.params.get(i));
            }
            invokeArgs[2] = createInitializedArray(Types.getRootType(), params);
            ClassNode dispatcherAst = astLoader.getAst(MethodDispatcher.class.getName());
            if(dispatcherAst==null){
                throw Exceptions.unexpectedValue("Runtime library is required!");
            }
            return getStaticInvokeExpr(new ClassReference(dispatcherAst), "invokeMethod", invokeArgs, ctx);
        };
        Object target = visit(ctx.target);
        if(target==null) return null;
        String mdName = ctx.Identifier().getText();
        String refKey = ctx.refKey.getText();
        if(refKey.equals(".")){
            return createDotInvoke.call((AstNode)target,mdName);
        }else if(refKey.equals("->")){
            if(!(target instanceof ExprNode)){
                handleSyntaxError("expression required", ctx.expression);
                return null;
            }
            return createDynamicInvoke.call((ExprNode)target,mdName);
        }else if(refKey.equals("*.") || refKey.equals("*->")){
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
            List<Statement> stats = new LinkedList<>();
            LocalVarNode varArrLen = this.declareTempLocalVar(Types.INT_TYPE);
            LocalVarNode varCounter = this.declareTempLocalVar(Types.INT_TYPE);
            stats.add(new VarDeclStmt(Arrays.asList(varArrLen,varCounter)));
            VarExpr varArrLenExpr = new VarExpr(varArrLen);
            VarExpr varCounterExpr = new VarExpr(varCounter);
            stats.add(new ExprStmt(new AssignExpr(varArrLenExpr,new ArrayLengthExpr(targetExpr))));
            stats.add(new ExprStmt(new AssignExpr(varCounterExpr,new ConstExpr(0))));
            CompareExpr conditionExpr = new CompareExpr(varCounterExpr,varArrLenExpr,CompareExpr.OP_LT);
            ExprNode targetEleExpr = new ElementExpr(targetExpr, varCounterExpr);
            ExprNode invokeExpr = refKey.equals("*.")
                    ? createDotInvoke.call(targetEleExpr,mdName) : createDynamicInvoke.call(targetEleExpr,mdName);
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
            MultiStmtExpr expr = new MultiStmtExpr(stats, varRetExpr);
            mapAst(expr,ctx);
            return expr;
        } else if (refKey.equals("?.") || refKey.equals("?->")) {
            if(!(target instanceof ExprNode)){
                handleSyntaxError("expression required", ctx.expression);
                return null;
            }
            ExprNode targetExpr = (ExprNode) target;
            List<Statement> stmts = new LinkedList<>();
            LocalVarNode targetTmpVar = declareTempLocalVar(targetExpr.getType());
            stmts.add(new VarDeclStmt(targetTmpVar));
            stmts.add(new ExprStmt(new AssignExpr(new VarExpr(targetTmpVar),targetExpr)));
            ExprNode conditionExpr = new CompareExpr(new VarExpr(targetTmpVar), new ConstExpr(null),"==");
            methodCtx.newOverrideTypeStack();
            methodCtx.onIf(conditionExpr,true);
            ExprNode trueExpr = new ConstExpr(null);
            methodCtx.popOverrideTypeStack();
            methodCtx.newOverrideTypeStack();
            methodCtx.onIf(conditionExpr,false);
            ExprNode targetTmpExpr = new VarExpr(targetTmpVar,methodCtx.getVarObjectType(targetTmpVar));
            ExprNode invokeExpr = refKey.equals("?.") ? createDotInvoke.call(targetTmpExpr,mdName) : createDynamicInvoke.call(targetTmpExpr, mdName);
            if (invokeExpr == null) {
                return null;
            }
            ExprNode falseExpr = BoxUtil.assignToObjectType(invokeExpr);
            if (falseExpr == null) {
                handleSyntaxError("unable cast " + invokeExpr.getType() + " to object type",invokeExpr.offset);
                return null;
            }
            methodCtx.popOverrideTypeStack();
            LocalVarNode vo = this.declareTempLocalVar(falseExpr.getType());
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
        }else{
            throw Exceptions.unexpectedValue(refKey);
        }
    }

    @Override
    public ExprNode visitGetFieldExpr(GetFieldExprContext ctx) {
        return createFieldExpr(ctx, null,OffsetRangeHelper.getOffsetRange(ctx));
    }

    @Override
    public UnaryExpr visitUnaryExpr(UnaryExprContext ctx) {
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
        if(!semanticAnalyzer.validateElementExpr(ee)) return null;
        mapAst(ee, ctx);
        return ee;
    }

    @Nullable
    private AstNode getNodeById(@Nonnull String name,@Nullable Token token) {
        //find local var
        LocalVarNode var = methodCtx!=null ? methodCtx.getNamedLocalVar(name) : null;
        if(var!=null){
            VarExpr ve = new VarExpr(var,methodCtx.getVarObjectType(var));
            if(token!=null) mapAst(ve, token);
            return ve;
        }
        //find parameters
        ParameterNode paramNode = methodCtx==null ? null : methodCtx.getNamedParameter(name);
        if(paramNode!=null){
            ParameterExpr ve = new ParameterExpr(paramNode,methodCtx.getVarObjectType(paramNode));
            if(token!=null) mapAst(ve, token);
            return ve;
        }
        //find field
        ExprNode fieldExpr = this.getObjectFieldExpr(new ThisExpr(this.getThisType()), name, ParserRuleContext.EMPTY);
        if(fieldExpr==null) fieldExpr = this.getStaticFieldExpr(new ClassReference(thisClazz), name, OffsetRange.NONE);
        if(fieldExpr!=null) return fieldExpr;
        ExprNode outerClassInstanceExpr = this.getOuterClassInstanceExpr(new ThisExpr(this.getThisType()));
        while(outerClassInstanceExpr!=null){
            ExprNode fe = this.getObjectFieldExpr(outerClassInstanceExpr, name, ParserRuleContext.EMPTY);
            if(fe==null) fe = this.getStaticFieldExpr(new ClassReference(thisClazz), name, OffsetRange.NONE);
            if(fe!=null) return fe;
            outerClassInstanceExpr = this.getOuterClassInstanceExpr(outerClassInstanceExpr);
        }
        String resolvedTypeName = compilationUnit.getTypeNameResolver().resolve(name, topClass, thisClazz);
        if (resolvedTypeName!=null) {
            ClassReference clsRef = new ClassReference(requireAst(resolvedTypeName,token,true));
            if(token!=null) mapAst(clsRef, token);
            return clsRef;
        }
        return null;
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
        boolean isStaticImport = ctx.importMode != null;
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
        TypeNameResolver typeNameResolver = compilationUnit.getTypeNameResolver();
        if (name.equals("*")) {
            String location = prefix.substring(0, prefix.length() - 1);
            if (isStaticImport) {
                ClassNode locationCls = requireAst(location, ctx.stop,true);
                if (locationCls==null) {
                    return null;
                }
                importStaticMember(locationCls,null);
            } else {
                typeNameResolver.importPackage(location);
            }

        } else {
            String key = name;
            if (ctx.alias != null) {
                key = ctx.alias.getText();
            }
            if (isStaticImport) {
                //TODO support alias
                String location = prefix.substring(0,prefix.length()-1);
                ClassNode locationCls = requireAst(location, ctx.stop,true);
                if (locationCls==null) return null;
                importStaticMember(locationCls,name);
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
            LocalVarNode localVar = this.declareLocalVar(varInfo.name, varInfo.type,varInfo.modifier,offset(ctx));
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
        LocalVarNode tmpVar = this.declareTempLocalVar(Types.getRootType());
        LambdaExpr ms = new LambdaExpr(tmpVar);
        ms.getReferenceExpr().overrideType(type);
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
            createLambdaNode(functionType,funcMethod,ms,ctx);
        } else {
            lambdaExprCtxMap.put(ms, ctx);
        }
        return ms;
    }

    @Nullable
    private ExprNode getOuterClassInstanceExpr(ExprNode expr){
        return this.getObjectFieldExpr(expr, "this$0", null);
    }

    @Override
    public Object visitClassDef(KalangParser.ClassDefContext ctx) {
        throw Exceptions.unexpectedException("");
    }

    @Override
    @Nullable
    public AnnotationNode visitAnnotation(KalangParser.AnnotationContext ctx) {
        ClassNode anType = requireAst(ctx.annotationType,false);
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
            LocalVarNode localVarNode = this.declareLocalVar(varId.getText(),  ((ArrayType) exprType).getComponentType(),Modifier.FINAL,offset(ctx));
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
                LocalVarNode localVarNode = this.declareLocalVar(varId.getText(), nextInvokeExpr.getType(),Modifier.FINAL,offset(ctx));
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
            throw Exceptions.unexpectedValue(ctx);
        }
        return this.createBinaryExpr(op, ctx.expression(0), ctx.expression(1), ctx);
    }
    
    public DiagnosisReporter getDiagnosisReporter() {
        return diagnosisReporter;
    }

    private ClassNode createFunctionClassNode(ClassType interfaceType,MethodDescriptor funcMethod,LambdaExpr lambdaExpr,KalangParser.LambdaExprContext ctx){
        Type returnType = funcMethod.getReturnType();
        Type[] paramTypes = funcMethod.getParameterTypes();
        String lambdaName = this.thisClazz.name + "$" + ++anonymousClassCounter;
        ClassNode oldClass = thisClazz;
        MethodContext oldMethodCtx = this.methodCtx;
        ClassNode classNode = thisClazz = new ClassNode(lambdaName,Modifier.PUBLIC);
        classNode.fileName = topClass.fileName;
        classNode.setSuperType(Types.getRootType());
        if (!Modifier.isStatic(methodCtx.method.getModifier())){
            FieldNode outerClassField = classNode.createField(Types.getClassType(oldClass), "this$0", Modifier.PUBLIC);
            ObjectFieldExpr outerFieldExpr = new ObjectFieldExpr(lambdaExpr.getReferenceExpr(), outerClassField);
            lambdaExpr.addStatement(new ExprStmt(new AssignExpr(outerFieldExpr,new ThisExpr(oldClass))));
        }
        Map<String, VarObject> accessibleVars = lambdaExpr.getAccessibleVarObjects();
        for( Map.Entry<String, VarObject> v:accessibleVars.entrySet()) {
            String name = v.getKey();
            VarObject var = v.getValue();
            FieldNode f = classNode.createField(var.getType(),name, Modifier.PUBLIC&Modifier.FINAL);
            AssignExpr assignExpr;
            ObjectFieldExpr fieldExpr = new ObjectFieldExpr(lambdaExpr.getReferenceExpr(), f);
            if (var instanceof LocalVarNode) {
                assignExpr = new AssignExpr(fieldExpr,new VarExpr((LocalVarNode)var));
            } else if (var instanceof ParameterNode) {
                assignExpr = new AssignExpr(fieldExpr,new ParameterExpr((ParameterNode)var));
            } else {
                throw Exceptions.unexpectedValue(var);
            }
            lambdaExpr.addStatement(new ExprStmt(assignExpr));
        }
        MethodNode methodNode = classNode.createMethodNode(returnType, funcMethod.getName(), Modifier.PUBLIC);
        enterMethod(methodNode);
        List<Token> lambdaParams = ctx.lambdaParams;
        int lambdaParamsCount = ctx.lambdaParams.size();
        if (paramTypes.length < lambdaParams.size()) {
            String msg = String.format("expected %d parameters but got %d",paramTypes.length,lambdaParams.size());
            this.diagnosisReporter.report(Diagnosis.Kind.ERROR,msg,ctx);
            return null;
        }
        for (int i=0;i<paramTypes.length;i++) {
            Type pt = paramTypes[i];
            String name = null;
            if (i<ctx.lambdaParams.size()) {
                name = ctx.lambdaParams.get(i).getText();
            }
            methodNode.createParameter(pt,name);
        }
        classNode.addInterface(interfaceType);
//        for(int i=lambdaParamsCount+1;i<=FunctionClasses.CLASSES.length-1;i++) {
//            LambdaUtil.createBridgeRunMethod(classNode, methodNode,paramTypes, i);
//        }
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
            methodCtx.returned = true;
        }
        methodNode.getBody().statements.add(bs);
        checkMethod();
        //TODO check return
        thisClazz = oldClass;
        methodCtx = oldMethodCtx;
        return classNode;
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

    private ClassNode createLambdaNode(ClassType interfaceClass,MethodDescriptor funcMethod,LambdaExpr lambdaExpr,KalangParser.LambdaExprContext ctx){
        ClassNode lambdaClassNode = this.createFunctionClassNode(interfaceClass,funcMethod,lambdaExpr,ctx);
        ClassType lambdaType = Types.getClassType(lambdaClassNode);
        //lambdaExpr.getReferenceExpr()
        NewObjectExpr newExpr;
        try {
            newExpr = new NewObjectExpr(lambdaType, new ExprNode[0],thisClazz);
        } catch (MethodNotFoundException | AmbiguousMethodException ex) {
            throw Exceptions.unexpectedException(ex);
        }
        lambdaExpr.setInitExpr(newExpr);
        lambdaExpr.getReferenceExpr().overrideType(lambdaType);
        thisClazz.classes.add(lambdaClassNode);
        return lambdaClassNode;
    }

    private InvocationExpr onInvocationExpr(InvocationExpr invocationExpr){
        ExprNode[] args = invocationExpr.getArguments();
        Type[] paramTypes = invocationExpr.getMethod().getParameterTypes();
        Map<GenericType,Type> inferredTypes = new HashMap<>();
        for(int i=0;i<args.length;i++) {
            ExprNode arg = args[i];
            if (arg instanceof LambdaExpr) {
                boolean isInit = ((LambdaExpr) arg).getInitExpr() != null;
                if (!isInit) {
                    ClassType lambdaType = (ClassType) paramTypes[i];
                    LambdaExprContext ctx = lambdaExprCtxMap.get(arg);
                    MethodDescriptor funcMethod = LambdaUtil.getFunctionalMethod(lambdaType);
                    Objects.requireNonNull(funcMethod);
                    ClassNode lambdaClassNode = createLambdaNode(lambdaType, funcMethod,(LambdaExpr) arg, ctx);
                    Map<GenericType, Type> iTypes = lambdaClassNode.inferredGenericTypes;
                    if (!iTypes.isEmpty()) {
                        inferredTypes.putAll(iTypes);
                    }
                }
            }
        }
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

    private OffsetRange offset(ParserRuleContext ctx) {
        return OffsetRangeHelper.getOffsetRange(ctx);
    }

}
