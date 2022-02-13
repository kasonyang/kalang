package kalang.compiler.compile.semantic;

import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.antlr.KalangParser.*;
import kalang.compiler.antlr.KalangParserVisitor;
import kalang.compiler.antlr.SLLErrorStrategy;
import kalang.compiler.ast.*;
import kalang.compiler.compile.*;
import kalang.compiler.compile.semantic.analyzer.AstNodeCollector;
import kalang.compiler.compile.semantic.analyzer.TerminalStatementAnalyzer;
import kalang.compiler.core.*;
import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;
import kalang.compiler.util.*;
import kalang.lang.Completable;
import kalang.mixin.CollectionMixin;
import kalang.runtime.dynamic.FieldVisitor;
import kalang.runtime.dynamic.MethodDispatcher;
import kalang.type.Function0;
import kalang.type.Function1;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Supplier;

import static kalang.compiler.util.BoxUtil.requireImplicitCast;
import static kalang.mixin.CollectionMixin.map;

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

    private ClassNodeInitializer classNodeInitializer;
    private ClassNodeStructureBuilder classNodeStructureBuilder;

    protected ClassNode thisClazz;

    protected ClassNode topClass;

    @Nonnull
    private ClassNodeLoader classNodeLoader;

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

    Profiler PROFILER = Profiler.getInstance();

    @Override
    public Object visitEmptyStat(KalangParser.EmptyStatContext ctx) {
        return this.newBlock((Supplier) null);
    }

    @Override
    public Object visitAssertStmt(KalangParser.AssertStmtContext ctx) {
        ExprNode failExpr = new UnaryExpr(
                requireImplicitCast(Types.BOOLEAN_TYPE, visitExpression(ctx.testCondition), offset(ctx))
                ,UnaryExpr.OPERATION_LOGIC_NOT
        );
        ExprNode failMsgExpr = null;
        if ( ctx.failMessage != null ){
            failMsgExpr = visitExpression(ctx.failMessage);
            if (Types.VOID_TYPE.equals(failMsgExpr.getType())){
                throw new NodeException("non-void type expected",offset(ctx.failMessage));
            }
        }
        ExprNode theFailMsgExpr = failMsgExpr;
        BlockStmt body = this.newBlock(() -> {
            NewObjectExpr newErrorExpr;
            try {
                newErrorExpr = new NewObjectExpr(
                        Types.requireAssertionErrorClassType()
                        , theFailMsgExpr != null ? new ExprNode[]{theFailMsgExpr} : new ExprNode[0]
                );
            }catch(MethodNotFoundException|AmbiguousMethodException ex){
                throw Exceptions.unexpectedException(ex);
            }
            return new ThrowStmt(newErrorExpr);
        });
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

    public void parseInit() {
        Span span = Profiler.getInstance().beginSpan("parse");
        ParserRuleContext cunit = buildCompilationUnitContext();
        Profiler.getInstance().endSpan(span);
        this.compilationContext = cunit;
        this.classNodeInitializer = new ClassNodeInitializer(this.compilationUnit);
        topClass = classNodeInitializer.build(cunit);
    }

    public void parseMemberDeclaration(ClassNodeLoader classNodeLoader) {
        setupClassNodeLoader(classNodeLoader);
        List<ImportDeclContext> importDecls = compilationContext.getRuleContexts(ImportDeclContext.class);
        for(ImportDeclContext ic : importDecls){
            this.visitImportDecl(ic);
        }
        this.classNodeStructureBuilder = new ClassNodeStructureBuilder(this.compilationUnit, parser);
        buildClassNodeMeta(topClass);
    }

    public void buildDefaultMembers() {
        buildDefaultMembers(topClass);
    }

    public void parseMemberBody(ClassNodeLoader classNodeLoader) {
        setupClassNodeLoader(classNodeLoader);
        PROFILER.spanRun("parseMethods", () -> visitMethods(topClass));
        buildMissParamMethods();
        processConstructorsAndStaticInitStmts(topClass);
        checkAndBuildInterfaceMethods(topClass);
        markStructureFinished(topClass);
    }
    
    private void visitMethods(ClassNode clazz){
        thisClazz = clazz;
        for(MethodNode m:thisClazz.getDeclaredMethodNodes()){
            StatContext[] stats = classNodeStructureBuilder.getStatContexts(m);
            TerminalStatementAnalyzer terminalStatAnalyzer = new TerminalStatementAnalyzer();
            if(stats!=null){
                BlockStmt mbody = m.getBody();
                assert mbody != null;
                enterMethod(m, () -> {
                    Statement prevStmt = null;
                    for (StatContext s: stats) {
                        if (terminalStatAnalyzer.isTerminalStatement(prevStmt)) {
                            handleSyntaxError("unreachable statement", offset(s));
                        }
                        prevStmt = visitStat(s);
                        mbody.statements.add(prevStmt);
                    }
                    checkMethod();
                });
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
    public ClassNodeLoader getClassNodeLoader() {
        return compilationUnit.getCompileContext().getClassNodeLoader();
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

    private BlockStmt newBlock(StatementSupplier statementSupplier) {
        List<Statement> list = new ArrayList<>();
        Statement stmt = statementSupplier == null ? null : statementSupplier.get();
        if (stmt != null) {
            list.add(stmt);
        }
        return newBlock(() -> list);
    }

    private BlockStmt newBlock(Supplier<List<Statement>> blockStmtConstructor) {
        BlockStmt bs = new BlockStmt();
        if (blockStmtConstructor != null) {
            methodCtx.newFrame(() -> bs.statements.addAll(blockStmtConstructor.get()));
        }
        return bs;
    }

    @Nonnull
    public ClassNode getAst() {
        return this.topClass;
    }

    @Override
    public ThrowStmt visitThrowStat(KalangParser.ThrowStatContext ctx) {
        ThrowStmt ts = new ThrowStmt(visitExpression(ctx.expression()));
        mapAst(ts, ctx);
        return ts;
    }

    @Override
    public MultiStmtExpr visitMapExpr(KalangParser.MapExprContext ctx) {
        List<ExpressionContext> keys = ctx.keys;
        List<ExpressionContext> values = ctx.values;
        ExprNode[] keyExprs = new ExprNode[keys.size()];
        ExprNode[] valuesExprs = new ExprNode[values.size()];
        for (int i = 0; i < keys.size(); i++) {
            keyExprs[i] = visitExpression(keys.get(i));
            valuesExprs[i] = visitExpression(values.get(i));
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
        for(int i=0;i<keyExprs.length;i++) {
            ExprNode[] args = new ExprNode[]{keyExprs[i],valuesExprs[i]};
            try {
                stmts.add(new ExprStmt(ObjectInvokeExpr.create(new VarExpr(vo), "put",args)));
            } catch (MethodNotFoundException|AmbiguousMethodException ex) {
                throw Exceptions.unexpectedException(ex);
            }
        }
        MultiStmtExpr mse = new MultiStmtExpr(stmts, new VarExpr(vo));
        mapAst(mse,ctx);
        return mse;
    }

    @Override
    public ExprNode visitNewArrayExpr(KalangParser.NewArrayExprContext ctx) {
        Type type = parseType(ctx.type());
        ExprNode ret;
        if(ctx.initExpr.isEmpty()){
            ExprNode[] sizeNodes = new ExprNode[ctx.sizes.size()];
            for (int i = 0; i < sizeNodes.length; i++){
                sizeNodes[i] = requireImplicitCast(Types.INT_TYPE, visitExpression(ctx.sizes.get(i)));
            }
            int dimensions = sizeNodes.length + ctx.suffix.size();
            for (int i = 0; i < dimensions - 1; i++) {
                type = Types.getArrayType(type);
            }
            ret = new NewArrayExpr(type,sizeNodes);
        }else{
            ExprNode[] initExprs = new ExprNode[ctx.initExpr.size()];
            for(int i=0;i<initExprs.length;i++){
                initExprs[i] = visitExpression(ctx.initExpr.get(i));
            }
            ret= AstUtil.createInitializedArray(type, initExprs);
        }
        mapAst(ret, ctx);
        return ret;
    }

    @Override
    public AstNode visitQuestionExpr(KalangParser.QuestionExprContext ctx) {
        List<Statement> stmts = new LinkedList<>();
        ExprNode conditionExpr = (ExprNode) visit(ctx.expression(0));
        ExprNode trueExpr = methodCtx.doInCondition(conditionExpr,true, () -> visitExpression(ctx.expression(1)));
        ExprNode falseExpr = methodCtx.doInCondition(conditionExpr,false, () -> visitExpression(ctx.expression(2)));
        Type trueType = trueExpr.getType();
        Type falseType  = falseExpr.getType();
        Type type = trueType.equals(falseType) ? trueType : TypeUtil.getCommonType(trueType,falseType);
        trueExpr = requireImplicitCast(type, trueExpr, trueExpr.offset);
        falseExpr = requireImplicitCast(type, falseExpr, falseExpr.offset);
        LocalVarNode vo = this.declareTempLocalVar(type);
        VarDeclStmt vds = new VarDeclStmt(vo);
        stmts.add(vds);
        IfStmt is = new IfStmt(conditionExpr);
        is.getTrueBody().statements.add(new ExprStmt(new AssignExpr(new VarExpr(vo), trueExpr)));
        is.getFalseBody().statements.add(new ExprStmt(new AssignExpr(new VarExpr(vo),falseExpr)));
        stmts.add(is);
        MultiStmtExpr mse = new MultiStmtExpr(stmts, new VarExpr(vo));
        mapAst(mse, offset(ctx), true);
        return mse;
    }

    @Override
    public Object visitStandardCompilationUnit(StandardCompilationUnitContext ctx) {
        return processCompilationUnit(ctx);
    }

    @Override
    public Object visitScriptCompilationUnit(ScriptCompilationUnitContext ctx) {
        return processCompilationUnit(ctx);
    }

    public AstNode processCompilationUnit(ParserRuleContext ctx) {
        try {
            visitChildren(ctx);
        } catch (NodeException ex) {
            handleSyntaxError(ex.getMessage(), ex.getOffsetRange());
        }
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
        return clazz.enclosingClass!=null && !Modifier.isStatic(clazz.getModifier());
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
        ExprNode expr  = requireImplicitCast(Types.BOOLEAN_TYPE, visitExpression(ctx.expression()), offset(ctx));
        VarTable<Object,Integer> trueNullState,falseNullState;
        this.methodCtx.nullState = trueNullState = this.methodCtx.nullState.newStack();
        BlockStmt trueBody = ctx.trueStmt == null ? null : methodCtx.doInCondition(expr, true, () -> requireBlock(ctx.trueStmt));
        this.methodCtx.nullState = this.methodCtx.nullState.popStack();
        this.methodCtx.nullState = falseNullState = this.methodCtx.nullState.newStack();
        BlockStmt falseBody = ctx.falseStmt == null ? null : methodCtx.doInCondition(expr,false, () -> requireBlock(ctx.falseStmt));
        this.methodCtx.nullState = this.methodCtx.nullState.popStack();
        methodCtx.handleMultiBranchedNullState(trueNullState.vars(),falseNullState.vars());
        if(terminalStmtAnalyzer.isTerminalStatement(trueBody)){
            methodCtx.onIf(expr,false);
        }
        if(terminalStmtAnalyzer.isTerminalStatement(falseBody)){
            methodCtx.onIf(expr,true);
        }
        IfStmt ifStmt = new IfStmt(expr,trueBody,falseBody);
        mapAst(ifStmt,ctx);
        return ifStmt;
    }

    @Override
    @Nonnull
    public Statement visitStat(StatContext ctx) {
        ParseTree child = ctx.getChild(0);
        Statement result;
        try {
            result = child == null ? null : (Statement) visit(child);
        } catch (NodeException ex) {
            handleSyntaxError(ex.getMessage(), ex.getOffsetRange());
            result = null;
        }
        // return a empty block statement to avoid NPE when result is null
        return result == null ? new BlockStmt() : result;
    }

    @Override
    public AstNode visitReturnStat(ReturnStatContext ctx) {
        ReturnStmt rs = new ReturnStmt();
        mapAst(rs,ctx);
        if (ctx.expression() != null) {
            ExprNode expr = visitExpression(ctx.expression());
            MethodNode method = methodCtx.method;
            Type expectedType = MethodUtil.getExpectedReturnType(method);
            rs.setExpr(requireImplicitCast(expectedType, expr, offset(ctx)));
        } else if (methodCtx.method.getType().equals(Types.getVoidClassType())) {
            ConstExpr nullExpr = new ConstExpr(null);
            nullExpr.offset = offset(ctx);
            rs.setExpr(nullExpr);
        }
        // if(!statementAnalyzer.validateReturnStmt(methodCtx.method, rs)) return null;
        return this.onReturnStmt(rs);
    }

    @Override
    public Object visitVarDeclStat(VarDeclStatContext ctx) {
        if (ctx.localVarDecl() != null) {
            return visit(ctx.localVarDecl());
        } else {
            return visit(ctx.destructuringLocalVarDecl());
        }
    }

    @Override
    public Object visitDestructuringLocalVarDecl(DestructuringLocalVarDeclContext ctx) {
        List<Statement> initStats = new LinkedList<>();
        ExprNode expr = visitExpression(ctx.expression());
        Type exprType = expr.getType();
        TypeValidator.requireNonVoidType(expr);
        LocalVarNode tmpVarForExpr = declareTempLocalVar(exprType);
        initStats.add(new VarDeclStmt(tmpVarForExpr));
        initStats.add(new ExprStmt(new AssignExpr(new VarExpr(tmpVarForExpr), expr)));
        String op = ctx.op.getText();
        int modifier = ctx.key.getText().equals("val") ? Modifier.FINAL : 0;
        List<TerminalNode> idList = ctx.Identifier();
        for (int i = 0; i < idList.size(); i++) {
            TerminalNode id = idList.get(i);
            String varName = id.getText();
            checkVarName(varName, offset(id.getSymbol()));
            if (op.equals("[")) {
                Type eleType = TypeValidator.requireType(exprType, ArrayType.class, "array type expected", expr.offset)
                        .getComponentType();
                LocalVarNode varNode = declareLocalVar(varName, eleType, modifier, offset(id.getSymbol()));
                initStats.add(new VarDeclStmt(varNode));
                AssignExpr assignExpr = new AssignExpr(
                        new VarExpr(varNode),
                        new ElementExpr(new VarExpr(tmpVarForExpr), new ConstExpr(i))
                );
                methodCtx.onAssign(assignExpr);
                initStats.add(new ExprStmt(assignExpr));
            } else if (op.equals("{")) {
                ClassType clsType = TypeValidator.requireType(exprType, ClassType.class, "class type expected", expr.offset);
                MethodDescriptor getter = AstUtil.findGetterByPropertyName(clsType, varName, thisClazz);
                if (getter == null) {
                    handleSyntaxError("no method found for name:" + varName, offset(id.getSymbol()));
                    continue;
                }
                LocalVarNode varNode = declareLocalVar(varName, getter.getReturnType(), modifier, offset(id.getSymbol()));
                initStats.add(new VarDeclStmt(varNode));
                AssignExpr assignExpr = new AssignExpr(
                        new VarExpr(varNode),
                        new ObjectInvokeExpr(new VarExpr(tmpVarForExpr), getter, new ExprNode[0]));
                methodCtx.onAssign(assignExpr);
                initStats.add(new ExprStmt(assignExpr));
            }
        }
        MultiStmt ms = new MultiStmt(initStats);
        mapAst(ms, offset(ctx), true);
        return ms;
    }

    @Override
    public AssignableObject visitVarDecl(VarDeclContext ctx) {
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
        checkVarName(name, offset(ctx));
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
        LoopStmt ls = new LoopStmt(null, postConditionExpr, loopBody, null);
        mapAst(ls, ctx);
        return ls;
    }

    @Override
    public AstNode visitForStat(ForStatContext ctx) {
        return newBlock(() -> {
            List<Statement> statements = new LinkedList<>();
            if (ctx.localVarDecl() != null) {
                Statement vars = visitLocalVarDecl(ctx.localVarDecl());
                statements.add(vars);
            }
            if (ctx.initExpressions != null) {
                statements.addAll(visitExpressions(ctx.initExpressions));
            }
            ExprNode preConditionExpr = ctx.condition != null ? visitExpression(ctx.condition) : null;
            BlockStmt bs = newBlock(() -> {
                LinkedList<Statement> ubStatements = new LinkedList<>();
                if (ctx.stat() != null) {
                    Statement st = visitStat(ctx.stat());
                    if (st instanceof BlockStmt) {
                        ubStatements.addAll(((BlockStmt) st).statements);
                    } else if (st != null) {
                        ubStatements.add(st);
                    }
                }
                return ubStatements;
            });
            BlockStmt updateBs = newBlock(() -> {
                if (ctx.updateExpressions != null) {
                    return visitExpressions(ctx.updateExpressions);
                }
                return Collections.emptyList();
            });
            LoopStmt ls = new LoopStmt(preConditionExpr, null, bs, updateBs);
            mapAst(ls, ctx);
            statements.add(ls);
            return statements;
        });
    }

    @Override
    public List<Statement> visitExpressions(ExpressionsContext ctx) {
        List<Statement> list = new LinkedList<>();
        for (ExpressionContext e : ctx.expression()) {
            ExprNode expr = visitExpression(e);
            list.add(new ExprStmt(expr));
        }
        return list;
    }

    @Override
    public Object visitUnterminatedStmt(UnterminatedStmtContext ctx) {
        handleSyntaxError("';' expected", offset(ctx));
        return super.visitUnterminatedStmt(ctx);
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
            if(clazz==null) throw Exceptions.unexpectedValue(null);
            try {
                InvocationExpr.MethodSelection apply = InvocationExpr.applyMethod(clazz, methodName, args,clazz.getConstructorDescriptors(thisClazz));
                ie = onInvocationExpr(new ObjectInvokeExpr(target, apply.selectedMethod, apply.appliedArguments));
            } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                throw createMethodNotFoundException(offset(ctx.start), clazz.getName(), methodName, args);
            }
        }else{
            ie= getImplicitInvokeExpr(methodName,args,ctx);
        }
        return ie;
    }

    @Nonnull
    protected ExprNode createFieldExpr(GetFieldExprContext to, @Nullable Function0<ExprNode> fromExprCb, OffsetRange offsetRange) {
        OffsetRange toOffset = offset(to);
        String refKey = to.refKey.getText();
        ExpressionContext exp = to.expression();
        String fname;
        if (to.Identifier() != null) {
            fname = to.Identifier().getText();
        } else {
            fname = parseStringLiteral(to.StringLiteral(), 1,1);
        }
        AstNode expr = (AstNode) visit(exp);
        Objects.requireNonNull(expr);
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
                Objects.requireNonNull(params[2]);
                methodName = "set";
            }
            return getStaticInvokeExpr(fieldVisitorClsRef, methodName, params, toOffset);
        };
        if (refKey.equals(".")) {
            if (expr instanceof ExprNode) {
                return createField.call((ExprNode) expr);
            } else if (expr instanceof ClassReference) {
                AssignableExpr sfe = getStaticFieldExpr((ClassReference) expr, fname, offsetRange);
                if (sfe == null) {
                    throw new NodeException("field not found:" + fname, offsetRange);
                }
                if (fromExprCb != null) {
                    return mapAst(new AssignExpr(sfe, fromExprCb.call()), offsetRange);
                }
                return mapAst(sfe, offsetRange);
            } else {
                throw new UnknownError("unknown node:" + expr);
            }
        } else if (refKey.equals("->>")) {
            if (!(expr instanceof ExprNode)) {
                throw new NodeException("not an expression", expr.offset);
            }
            return createDynamicField.call((ExprNode) expr);
        } else if (refKey.equals("*.")) {
            return createStarNavigateExpr(expr, createField, toOffset);
        } else if (refKey.equals("*->>")) {
            return createStarNavigateExpr(expr, createDynamicField, toOffset);
        } else if (refKey.equals("?.")) {
            return createSafeNavigateExpr(expr, createField, toOffset);
        } else if (refKey.equals("?->>")) {
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
                    throw new NodeException("expression expected", offset(ctx));
                }
                return (ExprNode) nodeExpr;
            } else {
                ExprNode toExpr = visitExpression(toCtx);
                if (!(toExpr instanceof AssignableExpr)) {
                    throw new NodeException("expression is not assignable", offset(toCtx));
                }
                AssignableExpr to = (AssignableExpr) toExpr;
                ExprNode from = visitExpression(fromCtx);
                from = requireImplicitCast(to.getType(), from, offset(ctx));
                AssignExpr assignExpr = new AssignExpr(to, from);
                mapAst(assignExpr, ctx);
                if (from instanceof LambdaExpr) {
                    inferLambdaIfNeed((LambdaExpr)from,  toExpr.getType());
                }
                methodCtx.onAssign(toExpr, from);
                return assignExpr;
            }
        } else {
            ExprNode toValue = visitExpression(toCtx);
            String op = assignOp.substring(0, assignOp.length() - 1);
            List<Statement> initStmts = new LinkedList<>();
            if (toValue instanceof AssignableExpr) {
                AstNodeMaker<AssignableExpr> toMaker = getSafeAccessorForAssignableExpr((AssignableExpr) toValue, initStmts);
                ExprNode from = createBinaryExpr(op, toMaker.make(), () -> visitExpression(fromCtx), offset(ctx));
                AssignExpr assignExpr = new AssignExpr(toMaker.make(), from);
                mapAst(assignExpr, offset(ctx));
                methodCtx.onAssign(assignExpr);
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
                    throw new NodeException("expression expected", offset(ctx));
                }
                return (ExprNode) nodeExpr;
            } else {
                throw new NodeException("expression is not assignable", offset(toCtx));
            }
        }
    }

    @Nonnull
    private ExprNode createBinaryExpr(String op, ExprNode expr1, AstNodeMaker<ExprNode> expr2Maker, OffsetRange offset){
        ExprNode expr2;
        if ("&&".equals(op) || "||".equals(op)) {
            expr1 = requireCastToPrimitiveDataType(expr1,expr1.offset);
            expr2 = methodCtx.doInCondition(expr1,"&&".equals(op), expr2Maker::make);
        } else {
            expr2 = expr2Maker.make();
        }
        Type type1 = expr1.getType();
        Type type2 = expr2.getType();
        boolean isPrimitive1 = (type1 instanceof PrimitiveType);
        boolean isPrimitive2 = (type2 instanceof PrimitiveType);
        ExprNode expr;        
        String errMsg = String.format("bad operand types:%s %s %s",type1,op,type2);
        if (Types.VOID_TYPE.equals(type1) || Types.VOID_TYPE.equals(type2)) {
            throw new NodeException(String.format("bad operand types:%s %s %s",type1,op,type2),offset);
        }
        
        if ("+".equals(op)) {
            if (Types.isNumber(type1) && Types.isNumber(type2)) {
                expr = this.createBinaryMathExpr(expr1, expr2, op, offset);
            } else if (Types.isStringType(type1)||Types.isStringType(type2)) {
                expr = this.concatExpressionsToStringExpr(new ExprNode[]{expr1,expr2});
            } else {
                throw new NodeException(errMsg,offset);
            }
        } else if ("==".equals(op) || "!=".equals(op)) {
            if (type1 instanceof ObjectType) {
                ClassReference objectsRef = new ClassReference(this.classNodeLoader.loadClassNode(Objects.class.getName()));
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
                throw new NodeException("object type is required", offset);
            }
            expr = constructBinaryExpr(expr1,expr2,op.substring(0,2));
        } else if (">>>".equals(op) || "<<".equals(op) || ">>".equals(op)) {
            if (Types.isExactNumber(type1) && Types.INT_TYPE.equals(type2)) {
                expr1 = BoxUtil.assignToPrimitiveDataType(expr1, type1);
                Objects.requireNonNull(expr1);
                expr1 = BoxUtil.assign(expr1, type1, MathType.getType((PrimitiveType) expr1.getType(), Types.INT_TYPE));
                expr = constructBinaryExpr(expr1, expr2, op);
            } else {
                throw new NodeException(errMsg, offset);
            }
        } else if ("&&".equals(op) || "||".equals(op)) {
            expr2 = requireCastToPrimitiveDataType(expr2,expr2.offset);
            expr = this.createBinaryBoolOperateExpr(expr1, expr2, op);
        } else {
            expr = this.createBinaryMathExpr(expr1, expr2, op, offset);
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

    @Override
    public ExprNode visitNullDefaultExpr(NullDefaultExprContext ctx) {
        OffsetRange offset = offset(ctx);
        ExprNode expr1 = visitExpression(ctx.expression(0));
        TypeValidator.requireType(expr1.getType(), ObjectType.class, "object type required", offset);
        ExprNode expr2 = requireCastToObjectType(visitExpression(ctx.expression(1)), offset);
        ObjectType expr2Type = (ObjectType) expr2.getType();
        ObjectType commonType =(ObjectType) TypeUtil.getCommonType(expr1.getType(), expr2Type);
        ObjectType returnType = Types.getObjectType(commonType, expr2Type.getNullable());
        LocalVarNode tmpVar = declareTempLocalVar(commonType);
        List<Statement> statements = new LinkedList<>();
        statements.add(new VarDeclStmt(tmpVar));
        statements.add(new ExprStmt(new AssignExpr(new VarExpr(tmpVar), expr1)));
        statements.add(new IfStmt(
                new CompareBinaryExpr(new VarExpr(tmpVar),new ConstExpr(null), BinaryExpr.OP_EQ),
                newBlock(() -> new ExprStmt(new AssignExpr(new VarExpr(tmpVar), expr2))),
                null
        ));
        return mapAst(new MultiStmtExpr(statements, new VarExpr(tmpVar, returnType)), offset(ctx), true);
    }

    @Nullable
    private ExprNode getImplicitInvokeExpr(String methodName,ExprNode[] args, ParserRuleContext ctx){
        AstNode namedNode = this.accessNamedNode(methodName, offset(ctx.start), null, null);
        if (namedNode instanceof VarExpr) {
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
                //methodName may be alias
                methodName = namedMethods[0].getName();
            }
        }
        if (namedMethods.length <= 0) {
            namedMethods = getImportedMixinMethod(methodName).toArray(new MethodDescriptor[0]);
            if (namedMethods.length > 0) {
                return getObjectInvokeExpr(invokeTarget, namedMethods[0].getName(), args, offset(ctx));
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
            throw createMethodNotFoundException(offset(ctx.getStart()), clazzType.getName(), methodName, args);
        } catch (AmbiguousMethodException ex) {
            throw new NodeException(ex.getMessage(), offset(ctx.start));
        }
        mapAst(expr, ctx);
        return expr;
    }
    
    @Nullable
    private ExprNode getObjectInvokeExpr(ExprNode target,String methodName,List<ExpressionContext> argumentsCtx,OffsetRange offset){
        List<Object> argsList = visitAll(argumentsCtx);
        if (argsList.contains(null)) return null;
        ExprNode[] args = argsList.toArray(new ExprNode[0]);
        return getObjectInvokeExpr(target, methodName, args, offset);
    }

    @Nullable
    private ExprNode getMixinInvokeExpr(ExprNode target,String methodName, ExprNode[] args,OffsetRange offset){
        List<MethodDescriptor> mixinMethods = getImportedMixinMethod(methodName);
        if (mixinMethods.isEmpty()) {
            return null;
        }
        MethodDescriptor mixinMethod = mixinMethods.get(0);
        ClassNode mixinCls = mixinMethod.getMethodNode().getClassNode();
        ExprNode[] newArgs = new ExprNode[args.length + 1];
        newArgs[0] = target;
        System.arraycopy(args, 0, newArgs, 1, args.length);
        return getStaticInvokeExpr(new ClassReference(mixinCls), mixinMethod.getName() , newArgs, offset);
    }

    private ExprNode getObjectInvokeExpr(ExprNode target,String methodName, ExprNode[] args,OffsetRange offset){
        if("<init>".equals(methodName)){
            throw Exceptions.unexpectedException("Don't get constructor by this method.");
        }
        Type targetType = target.getType();
        if(!(targetType instanceof ObjectType)){
            throw new NodeException("class type required.", offset);
        }
        ObjectType targetClassType = (ObjectType) targetType;
        if(targetClassType.getNullable()==NullableKind.NULLABLE){
            throw new NodeException("expression may be null", offset);
        }
        MethodDescriptor[] methods = targetClassType.getMethodDescriptors(thisClazz, methodName, true, true);
        ExprNode expr;
        try {
            if (methods.length<=0) {//find mixin method
                ExprNode mixinInvoke = getMixinInvokeExpr(target, methodName, args, offset);
                if (mixinInvoke != null) {
                    handleSyntaxWarning("Invoking mixin method using dot has been deprecated", offset);
                    return mixinInvoke;
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
            throw createMethodNotFoundException(offset, targetType.toString(), methodName, args);
        } catch(AmbiguousMethodException ex){
            throw new NodeException(ex.getMessage(), offset);
        }
        mapAst(expr, offset);
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

    @Nonnull
    private  ExprNode getStaticInvokeExpr(ClassReference clazz,String methodName, ExprNode[] argumentsCtx, OffsetRange offset){
        ExprNode expr;
        try {
            expr = onInvocationExpr(StaticInvokeExpr.create(clazz, methodName, argumentsCtx, thisClazz));
        } catch (MethodNotFoundException ex) {
            throw createMethodNotFoundException(offset, clazz.getReferencedClassNode().getName(), methodName, argumentsCtx);
        } catch(AmbiguousMethodException ex){
            throw new NodeException(ex.getMessage(), offset);
        }
        mapAst(expr, offset);
        return expr;
    }

    @Override
    public AstNode visitInvokeExpr(InvokeExprContext ctx) {
        OffsetRange offsetRange = offset(ctx);
        AstNode target = (AstNode) visit(ctx.target);
        String mdName;
        if (ctx.Identifier() != null) {
            mdName = ctx.Identifier().getText();
        } else {
            mdName = parseStringLiteral(ctx.StringLiteral(), 1,1);
        }
        Function0<ExprNode[]> paramsBuilder = () ->  map(ctx.params, this::visitExpression).toArray(new ExprNode[0]);
        Function1<ExprNode, ExprNode> createDotInvoke = (invokeTarget) -> getObjectInvokeExpr(invokeTarget, mdName, ctx.params, offsetRange);
        Function1<ExprNode, ExprNode> createDynamicInvoke = (invokeTarget) -> {
            ExprNode[] invokeArgs = new ExprNode[]{
                    invokeTarget, new ConstExpr(mdName), AstUtil.createInitializedArray(Types.getRootType(), paramsBuilder.call())
            };
            ClassNode dispatcherAst = classNodeLoader.getClassNode(MethodDispatcher.class.getName());
            if (dispatcherAst == null) {
                throw Exceptions.unexpectedValue("Runtime library is required!");
            }
            return getStaticInvokeExpr(new ClassReference(dispatcherAst), "invokeMethod", invokeArgs, offset(ctx));
        };
        Function1<ExprNode, ExprNode> createMixinInvoke = (invokeTarget) -> {
            ExprNode mixinInvoke = getMixinInvokeExpr(invokeTarget, mdName, paramsBuilder.call(), offsetRange);
            if (mixinInvoke == null) {
                throw new NodeException("mixin method not found:" + mdName, offsetRange);
            }
            return mixinInvoke;
        };
        Function0<ExprNode> requireTargetAsExpr = () -> {
            if (!(target instanceof ExprNode)) {
                throw new NodeException("expression required", offset(ctx.expression));
            }
            return (ExprNode) target;
        };
        if (target == null) return null;
        String refKey = ctx.refKey.getText();
        if (refKey.equals(".")) {
            if (target instanceof ClassReference) {
                return getStaticInvokeExpr((ClassReference) target, mdName, ctx.params, offsetRange);
            } else if (target instanceof ExprNode) {
                return createDotInvoke.call((ExprNode) target);
            } else {
                throw Exceptions.unexpectedValue(target);
            }
        } else if (refKey.equals("->>")) {
            return createDynamicInvoke.call(requireTargetAsExpr.call());
        } else if (refKey.equals("..")) {
            return createMixinInvoke.call(requireTargetAsExpr.call());
        }
        else if (refKey.equals("*.")) {
            return createStarNavigateExpr(target, createDotInvoke, offsetRange);
        } else if (refKey.equals("*->>")) {
            return createStarNavigateExpr(target, createDynamicInvoke, offsetRange);
        } else if (refKey.equals("?.")) {
            return createSafeNavigateExpr(target, createDotInvoke, offsetRange);
        } else if (refKey.equals("?->>")) {
            return createSafeNavigateExpr(target, createDynamicInvoke, offsetRange);
        } else if (refKey.equals("?..")) {
            return createSafeNavigateExpr(target, createMixinInvoke, offsetRange);
        } else {
            throw Exceptions.unexpectedValue(refKey);
        }
    }

    @Override
    public ExprNode visitGetFieldExpr(GetFieldExprContext ctx) {
        return createFieldExpr(ctx, null,OffsetRangeHelper.getOffsetRange(ctx));
    }

    @Override
    public ExprNode visitMethodRefExpr(MethodRefExprContext ctx) {
        LambdaExpr le = new LambdaExpr(new LambdaType(0));
        lambdaExprCtxMap.put(le, ctx);
        return le;
    }

    @Override
    public ExprNode visitUnaryExpr(UnaryExprContext ctx) {
        String op = ctx.getChild(0).getText();
        ExpressionContext exprCtx = ctx.expression();
        ExprNode expr = visitExpression(exprCtx);
        switch(op){
            case UnaryExpr.OPERATION_LOGIC_NOT:
                expr = requireImplicitCast(Types.BOOLEAN_TYPE, expr, OffsetRangeHelper.getOffsetRange(exprCtx));
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
        ExprNode indexExpr = visitExpression(ctx.expression(1));
        indexExpr = requireImplicitCast(Types.INT_TYPE, indexExpr, indexExpr.offset);
        ElementExpr ee = new ElementExpr(visitExpression(ctx.expression(0)), indexExpr);
        mapAst(ee, offset(ctx), true);
        if(!statementAnalyzer.validateElementExpr(ee)) return null;
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
                assignValue = requireImplicitCast(ve.getType(), assignValue, offset);
                result = new AssignExpr(ve, assignValue);
                mapAst(result, exprOffset);
                methodCtx.onAssign(ve, assignValue);
            } else {
                result = ve;
            }
            return result;
        }
        //find parameters
        ParameterNode paramNode = methodCtx==null ? null : methodCtx.getNamedParameter(name);
        if(paramNode!=null){
            ExprNode result;
            VarExpr ve = new VarExpr(paramNode,methodCtx.getVarObjectType(paramNode, paramNode.getType()));
            mapAst(ve, offset);
            if (assignValue != null) {
                result = new AssignExpr(ve, assignValue);
                mapAst(result, exprOffset);
                methodCtx.onAssign(ve, assignValue);
            } else {
                result = ve;
            }
            return result;
        }
        //find field
        ExprNode outerClassInstanceExpr = createThisExpr(offset);
        while(outerClassInstanceExpr != null){
            ExprNode fe = this.getObjectFieldLikeExpr(outerClassInstanceExpr, name, offset, assignValue, false);
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
                throw new NodeException("expression expected.", offset);
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
        List<Token> names = ctx.qualifiedName().names;
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
        TypeNameResolver typeNameResolver = compilationUnit.getTypeNameResolver();
        if (ctx.star != null) {
            //import all
            if (isImportStatic || isImportMixin) {
                ClassNode locationCls = resolveQualifiedNamedClass(names, this::getAst, true);
                if (locationCls == null) {
                    return null;
                }
                if (isImportStatic) {
                    importStaticMember(locationCls);
                } else {
                    importMixinMethod(locationCls);
                }
            } else {
                typeNameResolver.importPackage(ctx.qualifiedName().getText());
            }
        } else {
            String alias = ctx.alias == null ? null : ctx.alias.getText();
            if (isImportStatic || isImportMixin) {
                LinkedList<Token> clsTokens = new LinkedList<>(names);
                Token memberToken = clsTokens.pollLast();
                assert memberToken != null;
                ClassNode locationCls = resolveQualifiedNamedClass(clsTokens, this::getAst, true);
                if (locationCls == null) {
                    return null;
                }
                String name = memberToken.getText();
                String key = alias == null ? name : alias;
                if (isImportStatic) {
                    importStaticMember(locationCls,name, key);
                } else {
                    importMixinMethod(locationCls, name, key);
                }
            } else {
                ClassNode cls = resolveQualifiedNamedClass(names, this::getAst, true);
                if (cls == null) {
                    return null;
                }
                String key = alias != null ? alias : names.get(names.size() - 1).getText();
                typeNameResolver.importClass(cls.getName(), key);
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
        List<Object> paramExprsList = visitAll(ctx.params);
        if (paramExprsList.contains(null)) {
            return null;
        }
        ExprNode[] params = paramExprsList.toArray(new ExprNode[0]);
        return createNewExpr(ctx.classType(), params, offset(ctx));
    }

    @Override
    public Object visitStructuringNewExpr(StructuringNewExprContext ctx) {
        NewObjectExpr newExpr = createNewExpr(ctx.classType(), new ExprNode[0], offset(ctx));
        ClassType objType = (ClassType) newExpr.getType();
        LocalVarNode tmpVar = declareTempLocalVar(objType);
        List<Statement> initStmts = new LinkedList<>();
        initStmts.add(new VarDeclStmt(tmpVar));
        initStmts.add(new ExprStmt(new AssignExpr(new VarExpr(tmpVar), newExpr)));
        for (OptionalKeyValueContext kvc: ctx.keyValues) {
            OffsetRange propOffset = offset(kvc.Identifier().getSymbol());
            String propName = kvc.Identifier().getText();
            ExprNode propVal;
            if (kvc.expression() == null) {
                AstNode idVal = this.accessNamedNode(propName, propOffset, null, null);
                if (!(idVal instanceof ExprNode)) {
                    throw new NodeException("expression expected", propOffset);
                }
                propVal = (ExprNode) idVal;
            } else {
                propVal = visitExpression(kvc.expression());
            }
            MethodDescriptor setter = AstUtil.findOneSetterByPropertyName(
                    objType, propName, propVal.getType(), thisClazz, propOffset
            );
            if (setter == null) {
                handleSyntaxError("no setter found for name:" + propName, propOffset);
                continue;
            }
            propVal = requireImplicitCast(setter.getParameterTypes()[0], propVal, OffsetRange.NONE);
            InvocationExpr ie = onInvocationExpr(new ObjectInvokeExpr(new VarExpr(tmpVar), setter, propVal));
            mapAst(ie, offset(kvc));
            initStmts.add(new ExprStmt(ie));
        }
        MultiStmtExpr mse = new MultiStmtExpr(initStmts, new VarExpr(tmpVar));
        mapAst(mse, offset(ctx));
        return mse;
    }

    @Override
    public AstNode visitCastExpr(CastExprContext ctx) {
        ExprNode castExpr;
        ExprNode expr = visitExpression(ctx.expression());
        Type toType = parseType(ctx.type());
        Type fromType = expr.getType();
        if(fromType instanceof PrimitiveType){
            if(toType instanceof PrimitiveType) {
                castExpr = new PrimitiveCastExpr((PrimitiveType) fromType, (PrimitiveType) toType, expr);
            } else if (
                    Objects.equals(fromType, Types.NULL_TYPE)
                    && (toType instanceof ObjectType)
                    && ((ObjectType) toType).getNullable().isAssignableFrom(NullableKind.NULLABLE)){
                castExpr = new CastExpr(toType, expr);
            } else {
                throw new NodeException("unable to cast primitive type to nonnull class type", offset(ctx));
            }
        }else{
            if(toType instanceof PrimitiveType){
                throw new NodeException("unable to cast class type to primitive type", offset(ctx));
            }else{
                castExpr = new CastExpr(toType,expr);
            }
        }
        mapAst(castExpr,ctx);
        return castExpr;
    }

    @Override
    public AstNode visitTryStat(TryStatContext ctx) {
        List<VarDeclContext> resources = ctx.resources;
        boolean hasCatch = ctx.catchTypes != null && !ctx.catchTypes.isEmpty();
        boolean hasFinally = ctx.finallyExec != null && !ctx.finallyExec.isEmpty();
        BlockStmt tryExecStmt;
        if (resources != null && !resources.isEmpty()) {
            List<Statement> tryWithResStmts = buildTryWithResourceStmt(resources, 0, ctx.exec);
            if (!hasCatch && !hasFinally) {
                return new MultiStmt(tryWithResStmts);
            }
            tryExecStmt = newBlock(() -> tryWithResStmts);
        } else {
            tryExecStmt = requireBlock(ctx.exec);
            if (!hasCatch && !hasFinally) {
                handleSyntaxError("'catch' or 'finally' expected", offset(ctx.exec.stop));
                return tryExecStmt;
            }
        }
        List<CatchBlock> tryCatchBlocks = new LinkedList<>();
        if (ctx.catchTypes != null) {
            for (int i = 0; i < ctx.catchTypes.size(); i++) {
                final int catchIdx = i;
                methodCtx.newFrame(() -> {
                    String vName = ctx.catchVarNames.get(catchIdx).getText();
                    String vType = ctx.catchTypes.get(catchIdx).getText();
                    LocalVarNode vo = this.declareLocalVar(vName, requireClassType(vType, ctx.catchTypes.get(catchIdx).start), Modifier.FINAL, offset(ctx));
                    BlockStmt catchExecStmt = requireBlock(ctx.catchExec.get(catchIdx));
                    CatchBlock catchStmt = new CatchBlock(vo, catchExecStmt);
                    tryCatchBlocks.add(catchStmt);
                });
            }
        }
        FinallyBlock tryFinallyBlock = null;
        if (ctx.finallyExec != null) {
            tryFinallyBlock = new FinallyBlock(requireBlock(ctx.finallyExec));
        }
        TryStmt tryStmt = new TryStmt(tryExecStmt,tryCatchBlocks,tryFinallyBlock);
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
                    throw new NodeException("could not create variable for " + initType.getName() + " type", offset(ctx));
                }
            }
            VarInfo varInfo = varDecl(v,initExpr==null
                    ?Types.getRootType()
                    :initExpr.getType()
            );
            LocalVarNode localVar = this.declareLocalVar(varInfo.name, varInfo.type,varInfo.modifier,offset(ctx));
            VarDeclStmt vds = new VarDeclStmt(localVar);
            ms.statements.add(vds);
            if(initExpr!=null){
                initExpr = requireImplicitCast(localVar.getType(), initExpr, offset(ctx));
                if (initExpr instanceof LambdaExpr) {
                    inferLambdaIfNeed((LambdaExpr)initExpr,  localVar.getType());
                }
                AssignExpr assignExpr = new AssignExpr(new VarExpr(localVar), initExpr);
                methodCtx.onAssign(assignExpr.getTo(), initExpr);
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
            throw new NodeException(name + " is undefined!", offset(ctx));
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


    @Override
    public AstNode visitBlockStmt(BlockStmtContext ctx) {
        BlockStmt bs =newBlock(() -> {
            List<Statement> statList = new LinkedList<>();
            List<StatContext> stats = ctx.stat();
            if(stats!=null){
                for (StatContext s: stats) {
                    statList.add(visitStat(s));
                }
            }
            return statList;
        });
        mapAst(bs,ctx);
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
            throw new NodeException("require assignable expression", offset(expressionContext));
        }
        boolean isDesc = op.equals("--");
        if (expr instanceof VarExpr && Types.INT_TYPE.equals(expr.getType())) {
            ConstExpr increment = isDesc ? new ConstExpr(-1) : new ConstExpr(1);
            return mapAst(new IncExpr(((VarExpr) expr).getVar(),increment , isOperatorFirst), offset(expressionContext));
        }
        ExprNode reference;
        List<Statement> initStmts = new LinkedList<>();
        AstNodeMaker<AssignableExpr> toMaker = getSafeAccessorForAssignableExpr((AssignableExpr) expr, initStmts);
        if (!isOperatorFirst) {
            LocalVarNode tmpVar = declareTempLocalVar(expr.getType());
            initStmts.add(new VarDeclStmt(tmpVar));
            initStmts.add(new ExprStmt(new AssignExpr(new VarExpr(tmpVar), toMaker.make())));
            reference = new VarExpr(tmpVar);
        } else {
            reference = toMaker.make();
        }
        AssignableExpr toRight = toMaker.make();
        ExprNode addOneExpr = createBinaryMathExpr(toRight, new ConstExpr(1), isDesc ? "-" : "+", toRight.offset);
        initStmts.add(new ExprStmt(new AssignExpr(toMaker.make(), addOneExpr)));
        return new  MultiStmtExpr(initStmts, reference);
    }

    @Override
    public Object visitErrorousStat(KalangParser.ErrorousStatContext ctx) {
        handleSyntaxError("missing ';'", offset(ctx));
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
            throw new NodeException("unsupported type", offset(ts));
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
        KalangParser.LambdaTypeContext lambdaTypeCtx = null;
        ClassType functionType = null;
        List<Token> lambdaParams = ctx.lambdaParams;
        int lambdaParamsCount = lambdaParams == null ? 0 : lambdaParams.size();
        Type type = new LambdaType(lambdaParamsCount);
        LambdaExpr ms = new LambdaExpr(type);
        Map<String, AssignableObject> accessibleVars = new HashMap<>();
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
        for(Map.Entry<String, AssignableObject> e:accessibleVars.entrySet()) {
            ms.putAccessibleVarObject(e.getKey(), e.getValue());
        }
        lambdaExprCtxMap.put(ms, ctx);
        mapAst(ms, offset(ctx));
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
            return newBlock(() -> (Statement)visit(stmt));
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
        return newBlock(() -> {
            ExprNode exprToLoop = this.visitExpression(ctx.expression());
            Type exprType = exprToLoop.getType();
            List<Statement> blockStatements = new LinkedList<>();
            AstNodeMaker<VarExpr> exprAccessor = createSafeAccessor(exprToLoop, blockStatements);
            LocalVarNode indexVar = null;
            Token varId = ctx.valueId;
            Token indexId = ctx.indexId;
            if (indexId != null) {
                indexVar = this.declareLocalVar(indexId.getText(), Types.INT_TYPE, 0, offset(ctx));
                blockStatements.add(new VarDeclStmt(indexVar));
            }
            LoopStmt loopStmt;
            if (exprType instanceof ArrayType) {
                LocalVarNode localVarNode = this.declareLocalVar(varId.getText(), ((ArrayType) exprType).getComponentType(), 0, offset(ctx));
                blockStatements.add(new VarDeclStmt(localVarNode));
                LocalVarNode lenVar = this.declareTempLocalVar(Types.INT_TYPE);
                LocalVarNode counterVar = this.declareTempLocalVar(Types.INT_TYPE);
                blockStatements.add(new VarDeclStmt(lenVar));//var len
                blockStatements.add(new VarDeclStmt(counterVar));//var i
                blockStatements.add(new ExprStmt(new AssignExpr(new VarExpr(lenVar), new ArrayLengthExpr(exprAccessor.make()))));//l = array.length
                blockStatements.add(new ExprStmt(new AssignExpr(new VarExpr(counterVar), new ConstExpr(0))));//i=0
                ExprNode cnd = new CompareBinaryExpr(new VarExpr(counterVar), new VarExpr(lenVar), CompareBinaryExpr.OP_LT);
                LocalVarNode theIndexVar = indexVar;
                BlockStmt loopBodyBs = this.newBlock(() -> {
                    List<Statement> loopBodyStatements = new LinkedList<>();
                    loopBodyStatements.add(new ExprStmt(
                            new AssignExpr(new VarExpr(localVarNode), new ElementExpr(exprAccessor.make(), new VarExpr(counterVar)))
                    ));
                    if (theIndexVar != null) {
                        loopBodyStatements.add(new ExprStmt(new AssignExpr(new VarExpr(theIndexVar), new VarExpr(counterVar))));
                    }
                    loopBodyStatements.add(visitStat(ctx.stat()));
                    return loopBodyStatements;
                });
                BlockStmt updateBs = newBlock(() -> {
                    //increment counter
                    return new ExprStmt(
                            new AssignExpr(
                                    new VarExpr(counterVar), new ArithmeticBinaryExpr(new VarExpr(counterVar), new ConstExpr(1), ArithmeticBinaryExpr.OP_ADD)
                            )
                    );
                });
                loopStmt = new LoopStmt(cnd, null, loopBodyBs, updateBs);
            } else {
                ObjectType iterType = Types.getIterableClassType();
                if (iterType.isAssignableFrom(exprType)) {
                    ObjectInvokeExpr getIterableExpr;
                    try {
                        getIterableExpr = ObjectInvokeExpr.create(exprAccessor.make(), "iterator", null);
                    } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                        throw Exceptions.unexpectedException(ex);
                    }
                    LocalVarNode iterableVarNode = this.declareTempLocalVar(getIterableExpr.getType());
                    blockStatements.add(new VarDeclStmt(iterableVarNode));
                    blockStatements.add(new ExprStmt(new AssignExpr(new VarExpr(iterableVarNode), getIterableExpr)));
                    //set index = 0
                    if (indexVar != null) {
                        blockStatements.add(new ExprStmt(new AssignExpr(new VarExpr(indexVar), new ConstExpr(0))));
                    }
                    ObjectInvokeExpr cnd;
                    try {
                        cnd = ObjectInvokeExpr.create(new VarExpr(iterableVarNode), "hasNext", null);
                    } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                        throw Exceptions.unexpectedException(ex);
                    }
                    BlockStmt loopBodyBs = this.newBlock(() -> {
                        List<Statement> loopBodyStatements = new LinkedList<>();
                        ObjectInvokeExpr nextInvokeExpr;
                        try {
                            nextInvokeExpr = ObjectInvokeExpr.create(new VarExpr(iterableVarNode), "next", null);
                        } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                            throw Exceptions.unexpectedException(ex);
                        }
                        LocalVarNode localVarNode = this.declareLocalVar(varId.getText(), nextInvokeExpr.getType(), 0, offset(ctx));
                        VarExpr localVariable = new VarExpr(localVarNode);
                        loopBodyStatements.add(new VarDeclStmt(localVarNode));
                        loopBodyStatements.add(new ExprStmt(
                                new AssignExpr(localVariable, new CastExpr(localVariable.getType(), nextInvokeExpr))
                        ));
                        loopBodyStatements.add(visitStat(ctx.stat()));
                        return loopBodyStatements;
                    });
                    LocalVarNode theIndexVar = indexVar;
                    BlockStmt updateBs = theIndexVar == null ? null : newBlock(() -> {
                        //do index++
                        return new ExprStmt(
                                new AssignExpr(
                                        new VarExpr(theIndexVar)
                                        , new ArithmeticBinaryExpr(new VarExpr(theIndexVar), new ConstExpr(1), BinaryExpr.OP_ADD)
                                )
                        );
                    });
                    loopStmt = new LoopStmt(cnd, null, loopBodyBs, updateBs);
                } else {
                    this.handleSyntaxError("require array type or iterable type", offset(ctx.expression()));
                    loopStmt = null;
                }
            }
            if (loopStmt != null) blockStatements.add(loopStmt);
            return blockStatements;
        });
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
            initExprs[i] = requireImplicitCast(type, initExprs[i], OffsetRangeHelper.getOffsetRange(exprCtx.get(i)));
        }
        ExprNode arrExpr = AstUtil.createInitializedArray(type, initExprs);
        mapAst(arrExpr, ctx);
        return arrExpr;
    }

    @Override
    public Object visitInterpolationExpr(KalangParser.InterpolationExprContext ctx) {
        List<ParseTree> children = ctx.children;
        ExprNode[] exprs = new ExprNode[children.size()];
        for(int i=0;i<exprs.length;i++){
            ParseTree c = children.get(i);
            if(c instanceof TerminalNode){
                Token token = ((TerminalNode) c).getSymbol();
                int t = token.getType();
                String rawText = c.getText();
                String text;
                switch(t){
                    case KalangLexer.InterpolationPreffixString:
                        text = parseStringLiteral((TerminalNode)c, 1, 2);
                        break;
                    case KalangLexer.INTERPOLATION_STRING:
                        text = parseStringLiteral((TerminalNode)c, 0, 0);
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
                exprs[i]=new ConstExpr(text);
            }else if(c instanceof ExpressionContext){
                exprs[i] = this.visitExpression((ExpressionContext) c);
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
        methodCtx.newFrame(() -> {
            for (StatContext s: ctx.stat()) {
                Statement statement = visitStat(s);
                initStmts.add(statement);
            }
        });
        MultiStmtExpr e = new MultiStmtExpr(initStmts, new VarExpr(thisVar));
        mapAst(e, ctx);
        thisVar = oldThisVar;
        return e;
    }

    @Override
    public Object visitYieldStat(YieldStatContext ctx) {
        MethodNode method = methodCtx.method;
        if (!ExtendModifiers.isGenerator(method.getExtendModifier())) {
            throw new NodeException("yield keyword is only allowed in generator methods", offset(ctx.YIELD()));
        }
        Type genResultType = MethodUtil.getExpectedReturnType(method);
        ExprNode expr = visitExpression(ctx.expression());
        expr = requireImplicitCast(genResultType, expr, expr.offset);
        YieldStmt ye = new YieldStmt(expr);
        mapAst(ye, ctx);
        return ye;
    }

    @Override
    public Object visitAwaitExpr(AwaitExprContext ctx) {
        MethodNode method = methodCtx.method;
        if (!ExtendModifiers.isAsync(method.getExtendModifier())) {
            throw new NodeException("await keyword is only allowed in async method", offset(ctx.AWAIT()));
        }
        ExprNode expr = visitExpression(ctx.expression());
        ObjectType completableType = Types.getClassType(Completable.class);
        expr = requireImplicitCast(completableType, expr);
        AwaitExpr ae = new AwaitExpr(expr);
        mapAst(ae, offset(ctx));
        return ae;
    }

    private void createLambdaForMethodRef(LambdaExpr lambdaExpr, MethodRefExprContext ctx, ClassType lambdaType) {
        MethodDescriptor funcMethod = lambdaExpr.getInterfaceMethod();
        ExprNode[] fakeParams = map(funcMethod.getParameterDescriptors(), ExprNode.class, t -> new VarExpr(
                new LocalVarNode(t.getType(), t.getName())
        ));
        ExprNode[] fakeParamsWithoutFirst = CollectionMixin.slice(fakeParams, 1);
        Type[] paramTypes = funcMethod.getParameterTypes();
        Object target = visit(ctx.expression());
        String method = ctx.Identifier().getText();
        ExprNode targetExpr = null;
        ClassType targetType;
        InvocationExpr.MethodSelection mdSelect;
        if (target instanceof ExprNode) {
            targetExpr = (ExprNode) target;
            targetType = requireExprWithType(targetExpr, ClassType.class, "class type expected");
        } else if (target instanceof ClassReference) {
            ClassReference targetCr = (ClassReference) target;
            targetType = Types.getClassType(targetCr.getReferencedClassNode(), NullableKind.UNKNOWN);
        } else {
            throw new NodeException("class type expected", offset(ctx.expression()));
        }
        MethodDescriptor[] md = targetType.getMethodDescriptors(thisClazz, method, true, true);
        if (md.length <= 0) {
            throw new NodeException(method + " not found", offset(ctx));
        }
        MethodDescriptor[] staticMds = CollectionMixin.findAll(md, it -> ModifierUtil.isStatic(it.getModifier()));
        MethodDescriptor[] virtualMds = CollectionMixin.findAll(md, it -> !ModifierUtil.isStatic(it.getModifier()));
        if (targetExpr != null) {
            try {
                mdSelect = InvocationExpr.applyMethod(targetType, method, fakeParams, virtualMds);
            } catch (MethodNotFoundException | AmbiguousMethodException ex) {
                handleSyntaxError(ex.getMessage(), offset(ctx));
                return;
            }
            lambdaExpr.getCaptureArguments().add(targetExpr);
        } else {
            InvocationExpr.MethodSelection virtualSelect;
            InvocationExpr.MethodSelection staticSelect;
            try {
                try {
                    virtualSelect = InvocationExpr.applyMethod(targetType, method, fakeParamsWithoutFirst , virtualMds);
                } catch (MethodNotFoundException ex) {
                    virtualSelect = null;
                }
                try {
                    staticSelect = InvocationExpr.applyMethod(targetType, method, fakeParams, staticMds);
                } catch (MethodNotFoundException ex) {
                    staticSelect = null;
                }
            } catch (AmbiguousMethodException ex) {
                handleSyntaxError(ex.getMessage(), offset(ctx));
                return;
            }
            if (staticSelect != null && virtualSelect != null) {
                handleSyntaxError(method + "is ambiguous", offset(ctx));
                return;
            } else if (staticSelect == null && virtualSelect == null) {
                handleSyntaxError("method not found:" + MethodUtil.toString(targetType.getName(), method, paramTypes), offset(ctx));
                return;
            }
            mdSelect = virtualSelect == null ? staticSelect : virtualSelect;
        }
        MethodDescriptor selectedMd = mdSelect.selectedMethod;
        Type[] declaredFuncTypes = MethodUtil.getReturnAndParamTypes(funcMethod);
        Type[] actualFuncTypes = MethodUtil.getReturnAndParamTypes(selectedMd.getReturnType(), funcMethod.getParameterTypes());
        Map<ClassNode, Type> genericTypeMap = ParameterizedUtil.getGenericTypeMap(declaredFuncTypes, actualFuncTypes);
        ClassType parameterizedType = lambdaType.toParameterized(genericTypeMap);
        lambdaExpr.fixType(parameterizedType);
        lambdaExpr.setInvokeMethod(mdSelect.selectedMethod.getMethodNode());
    }

    private void createLambdaNode(LambdaExpr lambdaExpr,KalangParser.LambdaExprContext ctx, ClassType lambdaType){
        MethodDescriptor funcMethod = lambdaExpr.getInterfaceMethod();
        Type returnType = funcMethod.getReturnType();
        Type[] paramTypes = funcMethod.getParameterTypes();
        MethodContext oldMethodCtx = this.methodCtx;
        String methodName = oldMethodCtx.method.getName();
        if ("<init>".equals(methodName)) {
            methodName = "constructor";
        }
        String lambdaName = "lambda$" + methodName + "$" + ++oldMethodCtx.lambdaMethodCounter;
        int modifier = Modifier.PRIVATE | (oldMethodCtx.method.getModifier() & Modifier.STATIC);
        BlockStmt methodNodeBody = new BlockStmt();
        methodNodeBody.offset = offset(ctx);
        MethodNode methodNode = thisClazz.createMethodNode(returnType, lambdaName , modifier, methodNodeBody);
        mapAst(methodNode, ctx.start);
        enterMethod(methodNode, ()-> {
            Map<String, AssignableObject> accessibleVars = lambdaExpr.getAccessibleVarObjects();
            for( Map.Entry<String, AssignableObject> v:accessibleVars.entrySet()) {
                String name = v.getKey();
                AssignableObject var = v.getValue();
                methodNode.createParameter(
                        TypeUtil.normalizeForMethod(var.getType()),
                        name,
                        Modifier.FINAL | ModifierConstant.SYNTHETIC
                );
            }
            List<Token> lambdaParams = ctx.lambdaParams;
            if (paramTypes.length < lambdaParams.size()) {
                String msg = String.format("expected %d parameters but got %d",paramTypes.length,lambdaParams.size());
                handleSyntaxError(msg, offset(ctx));
                return;
            }
            for (int i=0;i<paramTypes.length;i++) {
                Type pt = paramTypes[i];
                String name = null;
                if (i<ctx.lambdaParams.size()) {
                    name = ctx.lambdaParams.get(i).getText();
                }
                ParameterNode pn = methodNode.createParameter(
                        TypeUtil.normalizeForMethod(pt),
                        name
                );
                if (i < ctx.lambdaParams.size()) {
                    mapAst(pn, ctx.lambdaParams.get(i));
                }
            }
            BlockStmt bs = this.newBlock(() -> {
                LinkedList<Statement> bsStatements = new LinkedList<>();
                ExpressionContext bodyExprCtx = ctx.expression();
                if (bodyExprCtx != null) {
                    ExprNode bodyExpr = visitExpression(bodyExprCtx);
                    if (!returnType.equals(Types.VOID_TYPE)) {
                        bodyExpr = requireImplicitCast(methodCtx.method.getType(), bodyExpr, offset(bodyExprCtx));
                        ReturnStmt retStmt = new ReturnStmt(bodyExpr);
                        retStmt.offset = bodyExpr.offset;
                        bsStatements.add(onReturnStmt(retStmt));
                    } else {
                        ExprStmt exprStmt = new ExprStmt(bodyExpr);
                        exprStmt.offset = bodyExpr.offset;
                        bsStatements.add(exprStmt);
                    }
                } else {
                    List<StatContext> stats = ctx.blockStmt().stat();
                    for (StatContext s : stats) {
                        bsStatements.add(visitStat(s));
                    }
                }
                if (returnType.equals(Types.getVoidClassType())) {
                    ReturnStmt defaultRetStmt = new ReturnStmt(new ConstExpr(null));
                    AstUtil.mapOffset(defaultRetStmt, OffsetRange.NONE, true);
                    bsStatements.add(onReturnStmt(defaultRetStmt));
                }
                return bsStatements;
            });
            bs.offset =  offset(ctx);
            methodNodeBody.statements.add(bs);
            checkMethod();
            Type[] declaredFuncTypes = MethodUtil.getReturnAndParamTypes(funcMethod);
            Type[] actualFuncTypes = MethodUtil.getReturnAndParamTypes(methodNode.inferredReturnType, funcMethod.getParameterTypes());
            Map<ClassNode, Type> genericTypeMap = ParameterizedUtil.getGenericTypeMap(declaredFuncTypes, actualFuncTypes);
            ClassType parameterizedType = lambdaType.toParameterized(genericTypeMap);
            if (!genericTypeMap.isEmpty()) {
                //parameterized return type
                methodNode.setType(TypeUtil.normalizeForMethod(
                        ParameterizedUtil.parameterizedType(methodNode.getType(), genericTypeMap)
                ));
            }
            lambdaExpr.fixType(parameterizedType);
            //TODO check return
            Set<VarObject> usedVars = new HashSet<>();
            new AstNodeCollector().collect(methodNode, VarExpr.class).forEach(it -> usedVars.add(it.getVar()));
            for (ParameterNode p: methodNode.getParameters()) {
                if (!ModifierUtil.isSynthetic(p.getModifier())) {
                    break;
                }
                if (!usedVars.contains(p)) {
                    methodNode.removeParameter(p);
                }
            }
            lambdaExpr.setInvokeMethod(methodNode);
            List<ExprNode> captureArgs = lambdaExpr.getCaptureArguments();
            if (!ModifierUtil.isStatic(oldMethodCtx.method.getModifier())) {
                captureArgs.add(new ThisExpr(getThisType()));
            }
            for (ParameterNode p: methodNode.getParameters()) {
                if (!ModifierUtil.isSynthetic(p.getModifier())) {
                    break;
                }
                AssignableObject captureVar = accessibleVars.get(p.getName());
                Objects.requireNonNull(captureVar);
                if (captureVar instanceof VarObject) {
                    captureArgs.add(new VarExpr((VarObject) captureVar));
                }  else {
                    throw Exceptions.unexpectedValue(captureVar);
                }
            }
        });
    }

    private void processConstructorsAndStaticInitStmts(ClassNode clazz) {
        thisClazz = clazz;
        processConstructorsAndStaticInitStmts();
        for (ClassNode c:thisClazz.classes) {
            processConstructorsAndStaticInitStmts(c);
        }
    }

    @Nullable
    private ExprNode getLambdaCall(String name,ExprNode namedExpr,ExprNode[] args,ParserRuleContext ctx) {
        Type namedExprType = namedExpr.getType();
        if(!Types.isFunctionType(namedExprType)){
            throw new NodeException(name+" is not callable", OffsetRangeHelper.getOffsetRange(ctx));
        }
        return this.getObjectInvokeExpr(namedExpr,"call",args, offset(ctx));
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
        if(rs.getExpr() != null) {
            Type eType = rs.getExpr().getType();
            Type oldType = methodCtx.method.inferredReturnType;
            methodCtx.method.inferredReturnType = oldType == null ? eType : TypeUtil.getCommonType(oldType, eType);
        }
        return rs;
    }

    private InvocationExpr onInvocationExpr(InvocationExpr invocationExpr){
        ExprNode[] args = invocationExpr.getArguments();
        Type[] paramTypes = invocationExpr.getMethod().getParameterTypes();
        for(int i=0;i<args.length;i++) {
            ExprNode arg = args[i];
            if (arg instanceof LambdaExpr) {
                this.inferLambdaIfNeed((LambdaExpr) arg,paramTypes[i]);
            }
        }
        Type[] actualTypes = AstUtil.getExprTypes(args);
        Map<ClassNode, Type> inferredTypes = ParameterizedUtil.getGenericTypeMap(paramTypes, actualTypes);
        if (!inferredTypes.isEmpty()) {
            MethodDescriptor md = invocationExpr.getMethod();
            MethodDescriptor newMd = md.toParameterized(inferredTypes, actualTypes);
            if (invocationExpr instanceof StaticInvokeExpr) {
                invocationExpr = new StaticInvokeExpr(((StaticInvokeExpr) invocationExpr).getInvokeClass(),newMd,args);
            } else if (invocationExpr instanceof ObjectInvokeExpr) {
                invocationExpr = new ObjectInvokeExpr(((ObjectInvokeExpr) invocationExpr).getInvokeTarget(),newMd,args);
            }
        }
        return invocationExpr;
    }

    private void inferLambdaIfNeed(LambdaExpr lambdaExpr, Type inferredType) {
        boolean isInit = lambdaExpr.getInterfaceMethod() != null;
        if (!isInit) {
            if (inferredType instanceof LambdaType) {
                handleSyntaxError("lambda type is not specified", lambdaExpr.offset);
                return;
            }
            String errorMsg = "cannot create lambda expression for type:" + inferredType.getName();
            Type inferredLambdaType = inferLambdaType(inferredType);
            if (!(inferredLambdaType instanceof ClassType)) {
                handleSyntaxError(errorMsg, lambdaExpr.offset);
                return;
            }
            ClassType lambdaType = (ClassType) inferredLambdaType;
            MethodDescriptor funcMethod = LambdaUtil.getFunctionalMethod(lambdaType);
            if (funcMethod == null) {
                handleSyntaxError(errorMsg, lambdaExpr.offset);
                return;
            }
            lambdaExpr.setInterfaceMethod(funcMethod);
            ParserRuleContext ctx = lambdaExprCtxMap.remove(lambdaExpr);
            if (ctx instanceof LambdaExprContext) {
                createLambdaNode(lambdaExpr, (LambdaExprContext) ctx, lambdaType);
            } else if (ctx instanceof MethodRefExprContext) {
                createLambdaForMethodRef(lambdaExpr, (MethodRefExprContext) ctx, lambdaType);
            } else {
                throw Exceptions.unexpectedValue(ctx);
            }
        }
    }

    @Nonnull
    private ExprNode createStarNavigateExpr(AstNode target, Function1<ExprNode, ExprNode> navigateExprMaker, OffsetRange offset) {
        if (!(target instanceof ExprNode)) {
            throw new NodeException("expression required", target.offset);
        }
        ExprNode targetExpr = (ExprNode) target;
        Type targetType = targetExpr.getType();
        if (!(targetType instanceof ArrayType)) {
            throw new NodeException("array required", target.offset);
        }
        List<Statement> stats = new LinkedList<>();
        AstNodeMaker<VarExpr> targetAccessor = createSafeAccessor(targetExpr, stats);
        LocalVarNode varArrLen = this.declareTempLocalVar(Types.INT_TYPE);
        LocalVarNode varCounter = this.declareTempLocalVar(Types.INT_TYPE);
        stats.add(new VarDeclStmt(Arrays.asList(varArrLen, varCounter)));
        stats.add(new ExprStmt(new AssignExpr(new VarExpr(varArrLen), new ArrayLengthExpr(targetAccessor.make()))));
        stats.add(new ExprStmt(new AssignExpr(new VarExpr(varCounter), new ConstExpr(0))));
        CompareBinaryExpr conditionExpr = new CompareBinaryExpr(new VarExpr(varCounter), new VarExpr(varArrLen), CompareBinaryExpr.OP_LT);
        ExprNode targetEleExpr = new ElementExpr(targetAccessor.make(), new VarExpr(varCounter));
        ExprNode invokeExpr = navigateExprMaker.call(targetEleExpr);
        assert invokeExpr != null;
        LocalVarNode varRet = this.declareTempLocalVar(Types.getArrayType(invokeExpr.getType()));
        stats.add(new VarDeclStmt(varRet));
        stats.add(new ExprStmt(new AssignExpr(new VarExpr(varRet), new NewArrayExpr(invokeExpr.getType(), new VarExpr(varArrLen)))));
        BlockStmt loopBody = this.newBlock(() ->
                new ExprStmt(new AssignExpr(new ElementExpr(new VarExpr(varRet), new VarExpr(varCounter)), invokeExpr))
        );
        BlockStmt updateBody = newBlock(() ->
                new ExprStmt(new AssignExpr(new VarExpr(varCounter), new ArithmeticBinaryExpr(new VarExpr(varCounter), new ConstExpr(1), ArithmeticBinaryExpr.OP_ADD)))
        );
        LoopStmt loopStmt = new LoopStmt(conditionExpr, null, loopBody, updateBody);
        stats.add(loopStmt);
        MultiStmtExpr expr = new MultiStmtExpr(stats, new VarExpr(varRet));
        mapAst(expr, offset);
        return expr;
    }

    @Nonnull
    private ExprNode createSafeNavigateExpr(AstNode target, Function1<ExprNode, ExprNode> navigateExprMaker, OffsetRange offsetRange) {
        if (!(target instanceof ExprNode)) {
            throw new NodeException("expression required", target.offset);
        }
        ExprNode targetExpr = (ExprNode) target;
        List<Statement> stmts = new LinkedList<>();
        LocalVarNode targetTmpVar = declareTempLocalVar(targetExpr.getType());
        stmts.add(new VarDeclStmt(targetTmpVar));
        stmts.add(new ExprStmt(new AssignExpr(new VarExpr(targetTmpVar), targetExpr)));
        ExprNode conditionExpr = new CompareBinaryExpr(new VarExpr(targetTmpVar), new ConstExpr(null), "==");
        methodCtx.doInCondition(conditionExpr, true, null);
        ExprNode falseExpr = methodCtx.doInCondition(conditionExpr, false, () -> {
            ExprNode targetTmpExpr = new VarExpr(targetTmpVar, methodCtx.getVarObjectType(targetTmpVar, targetTmpVar.getType()));
            return navigateExprMaker.call(targetTmpExpr);
        });
        boolean isVoidType = Types.VOID_TYPE.equals(falseExpr.getType());
        ExprNode refVar;
        IfStmt is = new IfStmt(conditionExpr);
        if (isVoidType) {
            is.getFalseBody().statements.add(new ExprStmt(falseExpr));
            refVar = null;
        } else {
            ExprNode trueExpr =  Values.getDefaultValue(falseExpr.getType());
            Type commonType = TypeUtil.getCommonType(trueExpr.getType(), falseExpr.getType());
            LocalVarNode vo = this.declareTempLocalVar(commonType);
            stmts.add(new VarDeclStmt(vo));
            is.getTrueBody().statements.add(new ExprStmt(new AssignExpr(new VarExpr(vo), trueExpr)));
            is.getFalseBody().statements.add(new ExprStmt(new AssignExpr(new VarExpr(vo), falseExpr)));
            refVar = new VarExpr(vo);
        }
        stmts.add(is);
        MultiStmtExpr mse = new MultiStmtExpr(stmts, refVar);
        mapAst(mse, offsetRange, true);
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

    private ParserRuleContext buildCompilationUnitContext() {
        ANTLRErrorStrategy oldErrorHandler = parser.getErrorHandler();
        List<? extends ANTLRErrorListener> oldErrorListeners = new ArrayList<>(parser.getErrorListeners());
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
        parser.removeErrorListeners();
        parser.setErrorHandler(new SLLErrorStrategy(compilationUnit));
        boolean script = compilationUnit.getSource().isScript();
        try {
            ParserRuleContext ctx = script ? parser.scriptCompilationUnit() : parser.standardCompilationUnit();
            oldErrorListeners.forEach(parser::addErrorListener);
            parser.setErrorHandler(oldErrorHandler);
            return ctx;
        } catch (Throwable throwable) {
            parser.getInputStream().seek(0);
            parser.getInterpreter().setPredictionMode(PredictionMode.LL);
            oldErrorListeners.forEach(parser::addErrorListener);
            parser.setErrorHandler(oldErrorHandler);
            return script ? parser.scriptCompilationUnit() : parser.standardCompilationUnit();
        }
    }

    private List<Statement> buildTryWithResourceStmt(List<VarDeclContext> resources, int currentIdx, ParserRuleContext execCtx) {
        List<Statement> stats = new LinkedList<>();
        VarDeclContext res = resources.get(currentIdx);
        ExprNode initExpr = visitExpression(res.expression());
        VarInfo varInfo = varDecl(res, initExpr.getType());
        LocalVarNode resVar = declareLocalVar(varInfo.name, varInfo.type, varInfo.modifier, offset(res));
        ClassType autoCloseableType = Types.requireClassType(AutoCloseable.class, NullableKind.UNKNOWN);
        boolean isResCloseable = autoCloseableType.isAssignableFrom(resVar.getType());
        if (!isResCloseable) {
            handleSyntaxError(autoCloseableType.getName() + " type expected", offset(res));
        }
        LocalVarNode exVar = declareTempLocalVar(Types.getThrowableClassType(NullableKind.UNKNOWN));
        stats.add(new VarDeclStmt(resVar));
        stats.add(new VarDeclStmt(exVar));
        AssignExpr resAssignExpr = new AssignExpr(new VarExpr(resVar), initExpr);
        AssignExpr exAssignExpr = new AssignExpr(new VarExpr(exVar), new ConstExpr(null));
        methodCtx.onAssign(resAssignExpr);
        methodCtx.onAssign(exAssignExpr);
        stats.add(new ExprStmt(resAssignExpr));
        stats.add(new ExprStmt(exAssignExpr));
        BlockStmt execBlock;
        if (currentIdx < resources.size() - 1) {
            execBlock = newBlock(() -> buildTryWithResourceStmt(resources, currentIdx + 1, execCtx));
        } else {
            execBlock = requireBlock(execCtx);
        }
        List<CatchBlock> catchBlocks =  methodCtx.newFrame(() -> {
            LocalVarNode catchVar =  declareTempLocalVar(exVar.getType());
            BlockStmt catchExecStmt = newBlock(()-> Arrays.asList(
                    new ExprStmt(new AssignExpr(new VarExpr(exVar), new VarExpr(catchVar)))
                    ,new ThrowStmt(new VarExpr(exVar))
            ));
            return Collections.singletonList(new CatchBlock(catchVar,catchExecStmt));
        });
        StatementSupplier closeStmtBuilder = () -> new ExprStmt(
                getObjectInvokeExpr(new VarExpr(resVar), "close", new ExprNode[0], OffsetRange.NONE)
        );
        FinallyBlock finallyBlock = !isResCloseable ? null : new FinallyBlock(newBlock(() -> new IfStmt(
                new CompareBinaryExpr(new VarExpr(resVar), new ConstExpr(null), BinaryExpr.OP_NE)
                ,newBlock(() -> new IfStmt(
                        new CompareBinaryExpr(new VarExpr(exVar), new ConstExpr(null), BinaryExpr.OP_NE),
                        newBlock(() -> {
                            BlockStmt tryExec = newBlock(closeStmtBuilder);
                            LocalVarNode catchVarForClose = declareTempLocalVar(exVar.getType());
                            BlockStmt catchExec = newBlock(() -> new ExprStmt(
                                    getObjectInvokeExpr(
                                            new VarExpr(exVar)
                                            , "addSuppressed"
                                            , new ExprNode[]{new VarExpr(catchVarForClose)}
                                            , OffsetRange.NONE)
                                    )
                            );
                            CatchBlock catchBlock = new CatchBlock(catchVarForClose, catchExec);
                            return new TryStmt(tryExec,Collections.singletonList(catchBlock), null);
                        }),
                        newBlock(closeStmtBuilder)
                    )
                )
                , null)));
        stats.add(new TryStmt(execBlock, catchBlocks, finallyBlock));
        return stats;
    }

    private void setupClassNodeLoader(@Nullable ClassNodeLoader classNodeLoader) {
        if(classNodeLoader==null){
            this.classNodeLoader = new DefaultClassNodeLoader();
        }else{
            this.classNodeLoader = classNodeLoader;
        }
        compilationUnit.getTypeNameResolver().setClassNodeLoader(classNodeLoader);
    }

    private void buildMissParamMethods() {
        List<MissingParamMethodInfo> missParamsMethods = classNodeStructureBuilder.getMissParamMethods();
        for (MissingParamMethodInfo e: missParamsMethods) {
            MethodNode m = e.getMissingParamMethod();
            MethodDeclContext mdCtx = e.getMethodDeclContext();
            MethodNode originMethod = e.getOriginMethod();
            ParameterNode[] mnParams = m.getParameters();
            ParameterNode[] originParams = originMethod.getParameters();
            ClassNode oldThisClazz = thisClazz;
            thisClazz = m.getClassNode();
            try {
                enterMethod(m, () -> {
                    thisClazz = m.getClassNode();
                    ExprNode[] callParams = new ExprNode[originParams.length];
                    for (int i = 0; i < mnParams.length; i++) {
                        callParams[i] = new VarExpr(mnParams[i]);
                    }
                    for (int i = mnParams.length; i < originParams.length; i++) {
                        ParamDeclContext pCtx = mdCtx.params.get(i);
                        ExpressionContext defValCtx = pCtx.paramDefVal;
                        if (defValCtx == null) {
                            handleSyntaxError("missing default value for parameter " + pCtx.paramId.getText(), offset(pCtx));
                            return;
                        } else {
                            callParams[i] = requireImplicitCast(originParams[i].getType(), visitExpression(defValCtx), offset(defValCtx));
                            if (Types.NULL_TYPE.equals(callParams[i].getType())) {
                                callParams[i] = new CastExpr(originParams[i].getType(), callParams[i]);
                            }
                        }
                    }
                    ExprNode callExpr;
                    if (ModifierUtil.isStatic(originMethod.getModifier())) {
                        callExpr = getStaticInvokeExpr(new ClassReference(thisClazz), m.getName(), callParams, OffsetRange.NONE);
                    } else {
                        callExpr = getObjectInvokeExpr(createThisExpr(OffsetRange.NONE), m.getName(), callParams, OffsetRange.NONE);
                    }
                    Objects.requireNonNull(callExpr);
                    BlockStmt mbody = m.getBody();
                    assert mbody != null;
                    if (Types.VOID_TYPE.equals(m.getType())) {
                        mbody.statements.add(new ExprStmt(callExpr));
                    } else {
                        mbody.statements.add((new ReturnStmt(callExpr)));
                    }
                    AstUtil.mapOffset(mbody, OffsetRange.NONE, true);
                });
            } finally {
                thisClazz = oldThisClazz;
            }
        }
    }

    private NewObjectExpr createNewExpr(ClassTypeContext classTypeCtx, ExprNode[] params, OffsetRange offset) {
        ObjectType clsType = parseClassType(classTypeCtx);
        List<ExprNode> paramList = new LinkedList<>(Arrays.asList(params));
        NewObjectExpr newExpr;
        try {
            if(this.isNonStaticInnerClass(clsType.getClassNode())){
                paramList.add(0,new ThisExpr(this.getThisType()));
            }
            params = paramList.toArray(new ExprNode[0]);
            newExpr = new NewObjectExpr(clsType,params,thisClazz);
            onInvocationExpr(newExpr.getConstructor());
            mapAst(newExpr, offset);
            return newExpr;
        } catch (MethodNotFoundException ex) {
            throw createMethodNotFoundException(offset(classTypeCtx), clsType.getName(), "<init>", params);
        } catch(AmbiguousMethodException ex){
            throw new NodeException(ex.getMessage(), offset(classTypeCtx));
        }
    }

}
