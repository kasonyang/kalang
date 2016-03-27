package kalang.compiler;

import javax.annotation.Nonnull;
import kalang.ast.ClassNode;
import kalang.ast.ElementExpr;
import kalang.ast.AssignExpr;
import kalang.ast.Statement;
import kalang.ast.MultiStmtExpr;
import kalang.ast.MethodNode;
import kalang.ast.ContinueStmt;
import kalang.ast.VarObject;
import kalang.ast.ExprNode;
import kalang.ast.AstNode;
import kalang.ast.LoopStmt;
import kalang.ast.InvocationExpr;
import kalang.ast.ExprStmt;
import kalang.ast.BinaryExpr;
import kalang.ast.VarExpr;
import kalang.ast.ThisExpr;
import kalang.ast.ConstExpr;
import kalang.ast.TryStmt;
import kalang.ast.ThrowStmt;
import kalang.ast.CatchBlock;
import kalang.ast.CastExpr;
import kalang.ast.BlockStmt;
import kalang.ast.BreakStmt;
import kalang.ast.UnaryExpr;
import kalang.ast.NewArrayExpr;
import kalang.ast.IfStmt;
import kalang.ast.FieldExpr;
import kalang.ast.ReturnStmt;
import kalang.util.AstUtil;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.antlr.KalangParser;
import kalang.antlr.KalangParser.BlockStmtContext;
import kalang.antlr.KalangParser.BreakStatContext;
import kalang.antlr.KalangParser.CastExprContext;
import kalang.antlr.KalangParser.ClassBodyContext;
import kalang.antlr.KalangParser.CompilantUnitContext;
import kalang.antlr.KalangParser.ContinueStatContext;
import kalang.antlr.KalangParser.DoWhileStatContext;
import kalang.antlr.KalangParser.ExprAssignContext;
import kalang.antlr.KalangParser.ExprGetArrayElementContext;
import kalang.antlr.KalangParser.ExprGetFieldContext;
import kalang.antlr.KalangParser.ExprIdentifierContext;
import kalang.antlr.KalangParser.ExprInvocationContext;
import kalang.antlr.KalangParser.ExprLiteralContext;
import kalang.antlr.KalangParser.ExprMemberInvocationContext;
import kalang.antlr.KalangParser.ExprMidOpContext;
import kalang.antlr.KalangParser.ExprParenContext;
import kalang.antlr.KalangParser.ExprSelfOpPreContext;
import kalang.antlr.KalangParser.ExprSelfRefContext;
import kalang.antlr.KalangParser.ExprStatContext;
import kalang.antlr.KalangParser.ExpressionContext;
import kalang.antlr.KalangParser.ExpressionsContext;
import kalang.antlr.KalangParser.FieldDeclContext;
import kalang.antlr.KalangParser.ForStatContext;
import kalang.antlr.KalangParser.IfStatContext;
import kalang.antlr.KalangParser.ImportDeclContext;
import kalang.antlr.KalangParser.LiteralContext;
import kalang.antlr.KalangParser.MethodDeclContext;
import kalang.antlr.KalangParser.NewExprContext;
import kalang.antlr.KalangParser.QualifiedNameContext;
import kalang.antlr.KalangParser.ReturnStatContext;
import kalang.antlr.KalangParser.StatContext;
import kalang.antlr.KalangParser.TryStatContext;
import kalang.antlr.KalangParser.TypeContext;
import kalang.antlr.KalangParser.VarDeclContext;
import kalang.antlr.KalangParser.VarDeclStatContext;
import kalang.antlr.KalangParser.VarModifierContext;
import kalang.antlr.KalangParser.WhileStatContext;
import kalang.antlr.KalangVisitor;
import kalang.core.VarTable;
import javax.annotation.Nullable;
import kalang.antlr.KalangParser.LocalVarDeclContext;
import kalang.ast.ArrayLengthExpr;
import kalang.ast.AssignableExpr;
import kalang.ast.ClassReference;
import kalang.ast.CompareExpr;
import kalang.ast.ErrorousExpr;
import kalang.ast.FieldNode;
import kalang.ast.IncrementExpr;
import kalang.ast.LocalVarNode;
import kalang.ast.LogicExpr;
import kalang.ast.MathExpr;
import kalang.ast.NewObjectExpr;
import kalang.ast.ObjectFieldExpr;
import kalang.ast.ObjectInvokeExpr;
import kalang.ast.ParameterNode;
import kalang.ast.StaticFieldExpr;
import kalang.ast.StaticInvokeExpr;
import kalang.ast.UnknownFieldExpr;
import kalang.ast.UnknownInvocationExpr;
import kalang.ast.VarDeclStmt;
import kalang.core.ArrayType;
import kalang.core.ClassType;
import kalang.core.PrimitiveType;
import kalang.core.Type;
import kalang.core.Types;
import kalang.util.BoxUtil;
import kalang.util.OffsetRangeHelper;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *  build ast from antlr parse tree
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class AstBuilder extends AbstractParseTreeVisitor implements KalangVisitor {
    
    public static final int 
            PARSING_PHASE_META = 1,
            PARSING_PHASE_ALL = 2;
   
    private int parsingPhase=0;
    //static String DEFAULT_VAR_TYPE;// = "java.lang.Object";

    //short name to full name
    @Nonnull
    private final Map<String, String> fullNames = new HashMap<>();
    @Nonnull
    private final List<String> importPaths = new LinkedList<>();
    @Nonnull
    private final ClassNode classAst = new ClassNode();
    private MethodNode method;
    private final HashMap<MethodNode,StatContext> methodBodys = new HashMap<>();

    @Nonnull
    private AstLoader astLoader;

    private ParserRuleContext compilationContext;

    @Nonnull
    private TokenStream tokenStream;

    @Nonnull
    private final String className;
    
    @Nonnull
    private String classPath;

    @Nonnull
    private VarTable<String, LocalVarNode> vtb;
    
    @Nonnull
    private KalangParser parser;
    
    private CompileErrorHandler errorHandler = (error) ->{
        System.err.println(error);
    };
    
    private final CompilationUnit compilationUnit;
    
    public CompileErrorHandler getErrorHandler() {
        return errorHandler;
    }

    public void setErrorHandler(CompileErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }
    
    public ParserRuleContext getParseTree(){
        return compilationContext;
    }
      
    @Override
    public ThrowStmt visitThrowStat(KalangParser.ThrowStatContext ctx) {
        ExprNode expr = (ExprNode) visit(ctx.expression());
        ThrowStmt ts = new ThrowStmt(expr);
        mapAst(ts, ctx);
        return ts;
    }

    @Nonnull
    public String getClassName() {
        return className;
    }
    
    @Nullable
    private ClassType requireClassType(@Nonnull Token token){
        return requireClassType(token.getText(),token);
    }
    
    @Nullable
    private ClassType requireClassType(@Nonnull String id,@Nonnull Token token){
        ClassNode ast = requireAst(id, token);
        if(ast==null) return null;
        return Types.getClassType(ast);
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
        if(targetPhase>=PARSING_PHASE_META
                && parsingPhase < PARSING_PHASE_META){
            parsingPhase = PARSING_PHASE_META;
            this.compilationContext = parser.compilantUnit();
            visit(compilationContext);
            if(AstUtil.getMethodsByName(classAst, "<init>").length<1){
                AstUtil.createEmptyConstructor(classAst);
            }
        }
        if(targetPhase>=PARSING_PHASE_ALL
                && parsingPhase < PARSING_PHASE_ALL){
            parsingPhase = PARSING_PHASE_ALL;
            for(MethodNode m:classAst.getMethodNodes()){
                StatContext body = methodBodys.get(m);
                if(body!=null){
                    method = m;
                    newVarStack();
                    m.body = (BlockStmt) visitStat(body);
                    if(m.body!=null && AstUtil.isConstructor(m)){   
                        @SuppressWarnings("null")
                        List<Statement> bodyStmts = m.body.statements;
                        if(!AstUtil.hasConstructorCallStatement(bodyStmts)){
                            try {
                                bodyStmts.add(0, AstUtil.createDefaultSuperConstructorCall(classAst));
                            } catch (MethodNotFoundException ex) {
                                reportError("default constructor not found", body.start);
                            }
                        }
                    }
                    popVarStack();
                }
            }
        }
    }

    public AstBuilder(@Nonnull CompilationUnit compilationUnit, @Nonnull KalangParser parser) {
        this.compilationUnit = compilationUnit;
        this.className = compilationUnit.getSource().getClassName();
        classAst.name = className;
        this.classPath = "";
        this.parser = parser;
        tokenStream = parser.getTokenStream();
        if (className.contains(".")) {
            classPath = className.substring(0, className.lastIndexOf('.'));
        }
    }

    @Override
    public Object visit(ParseTree tree) {
        if (tree == null) {
            System.err.println("visit null");
            return null;
        }
        return super.visit(tree);
    }

    public void importPackage(@Nonnull String packageName) {
        this.importPaths.add(packageName);
    }

    void newVarStack() {
        if (vtb != null) {
            vtb = new VarTable<>(vtb);
        } else {
            vtb = new VarTable<>();
        }
    }

    void popVarStack() {
        vtb = vtb.getParent();
    }

    @Nonnull
    public ClassNode getAst() {
        return this.classAst;
    }
    
    private void mapAst(@Nonnull AstNode node,@Nonnull ParserRuleContext tree){
         node.offset = OffsetRangeHelper.getOffsetRange(tree);
    }
    
    private void mapAst(@Nonnull AstNode node,@Nonnull Token token){
        node.offset = OffsetRangeHelper.getOffsetRange(token);
    }

    @Override
    public MultiStmtExpr visitMapExpr(KalangParser.MapExprContext ctx) {
        return visitMap(ctx.map());
    }

    @Override
    public MultiStmtExpr visitListOrArrayExpr(KalangParser.ListOrArrayExprContext ctx) {
        return visitListOrArray(ctx.listOrArray());
    }

    @Override
    public MultiStmtExpr visitMap(KalangParser.MapContext ctx) {
        MultiStmtExpr mse = MultiStmtExpr.create();
        LocalVarNode vo = new LocalVarNode();
        VarDeclStmt vds = new VarDeclStmt(vo);
        vo.type = Types.MAP_IMPL_CLASS_TYPE;
        NewObjectExpr newExpr;
        try {
            newExpr = new NewObjectExpr(Types.MAP_IMPL_CLASS_TYPE);
        } catch (MethodNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        vo.initExpr = newExpr;
        mse.stmts.add(vds);
        VarExpr ve = new VarExpr(vo);
        List<TerminalNode> ids = ctx.Identifier();
        for (int i = 0; i < ids.size(); i++) {
            ExpressionContext e = ctx.expression(i);
            ExprNode v = (ExprNode) visit(e);
            ConstExpr k = new ConstExpr();
            k.setConstType(Types.STRING_CLASS_TYPE);// STRING_CLASS_NAME;
            k.setValue(ctx.Identifier(i).getText());
            ExprNode[] args = new ExprNode[]{k,v};
            InvocationExpr iv;
            try {
                iv = ObjectInvokeExpr.create(ve, "put",args);
            } catch (MethodNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            ExprStmt es = new ExprStmt(iv);
            mse.stmts.add(es);
        }
        mse.reference = ve;
        mapAst(mse,ctx);
        //TODO set generic toType
        return mse;
    }

    @Override
    public MultiStmtExpr visitListOrArray(KalangParser.ListOrArrayContext ctx) {
        MultiStmtExpr mse = MultiStmtExpr.create();
        LocalVarNode vo = new LocalVarNode();
        VarDeclStmt vds = new VarDeclStmt(vo);
        vo.type = Types.LIST_IMPL_CLASS_TYPE;
        NewObjectExpr newExpr;
        try {
            newExpr = new NewObjectExpr(Types.LIST_IMPL_CLASS_TYPE);
        } catch (MethodNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        vo.initExpr = newExpr;
        mse.stmts.add(vds);
        VarExpr ve = new VarExpr(vo);
        for (ExpressionContext e : ctx.expression()) {
            InvocationExpr iv;
            try {
                iv = ObjectInvokeExpr.create(ve,"add",new ExprNode[]{visitExpression(e)});
            } catch (MethodNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            mse.stmts.add(new ExprStmt(iv));
        }
        mse.reference = ve;
        //TODO set generic toType
        mapAst(mse,ctx);
        return mse;
    }

    @Override
    public AstNode visitExprNewArray(KalangParser.ExprNewArrayContext ctx) {
        NewArrayExpr nae = new NewArrayExpr();
        nae.setSize((ExprNode) visit(ctx.expression()));
        nae.setComponentType(parseSingleType(ctx.singleType()));
        mapAst(nae, ctx);
        return nae;
    }

    @Override
    public AstNode visitExprQuestion(KalangParser.ExprQuestionContext ctx) {
        MultiStmtExpr mse = MultiStmtExpr.create();
        LocalVarNode vo = new LocalVarNode();
        VarDeclStmt vds = new VarDeclStmt(vo);
        mse.stmts.add(vds);
        VarExpr ve = new VarExpr(vo);
        IfStmt is = new IfStmt();
        is.setConditionExpr((ExprNode) visit(ctx.expression(0)));
        ExprNode trueExpr = (ExprNode) visit(ctx.expression(1));
        ExprNode falseExpr = (ExprNode)  visit(ctx.expression(2));
        is.setTrueBody(new ExprStmt(new AssignExpr(ve, trueExpr)));
        is.setFalseBody(new ExprStmt(new AssignExpr(ve,falseExpr)));
        Type trueType = trueExpr.getType();
        Type falseType  = falseExpr.getType();
        if(trueType.equals(falseType)){
            vo.type = trueType;
        }else{
            //TODO get common type
            vo.type = Types.ROOT_TYPE;
        }
        mse.stmts.add(is);
        mse.reference = ve;
        mapAst(ve, ctx);
        return mse;
    }

    @Override
    public AstNode visitPostIfStmt(KalangParser.PostIfStmtContext ctx) {
        ExprNode leftExpr = visitExpression(ctx.expression(0));
        if (!(leftExpr instanceof AssignExpr)) {
            this.reportError("AssignExpr required", ctx);
        }
        AssignExpr assignExpr = (AssignExpr) leftExpr;
        AssignableExpr to = assignExpr.getTo();
        ExprNode from = assignExpr.getFrom();
        ExprNode cond = visitExpression(ctx.expression(1));
        Token op = ctx.op;
        if (op != null) {
            String opStr = op.getText();
            BinaryExpr be = createBinaryExpr(to, cond, opStr);
            cond = be;
        }
        AssignExpr as = new AssignExpr(to, from);
        IfStmt is = new IfStmt();
        is.setConditionExpr(cond);
        is.setTrueBody(new ExprStmt(as));
        mapAst(is,ctx);
        return is;
    }

    @Override
    public AstNode visitCompilantUnit(CompilantUnitContext ctx) {
        this.visitAll(ctx.importDecl());
        classAst.name = this.className;
        classAst.modifier = parseModifier(ctx.varModifier());
        Token clsType = ctx.classType;
        if(clsType!=null){
            if (clsType.getText().equals("interface")) {
                classAst.isInterface = true;
            }
        }
        if (ctx.parentClass != null) {
            classAst.parent =  requireAst(ctx.parentClass);
        }else{
            classAst.parent = Types.ROOT_TYPE.getClassNode();
        }
        if (ctx.interfaces != null && ctx.interfaces.size() > 0) {
            for (Token itf : ctx.interfaces) {
                ClassNode itfClassNode = requireAst(itf);
                if(itfClassNode!=null){
                    classAst.interfaces.add(itfClassNode);
                }
            }
        }
        visitClassBody(ctx.classBody());
        mapAst(classAst, ctx);
        return null;
    }

    @Override
    public AstNode visitClassBody(ClassBodyContext ctx) {
        this.newVarStack();
        this.visitChildren(ctx);
        this.popVarStack();
        mapAst(classAst, ctx);
        return null;
    }

    @Override
    public Void visitFieldDecl(FieldDeclContext ctx) {
        int mdf = this.parseModifier(ctx.varModifier());
        for(VarDeclContext vd:ctx.varDecl()){
            FieldNode fieldNode = classAst.createField();
            fieldNode.modifier = mdf;
            varDecl(vd,fieldNode);
        }
        return null;
    }

    @Override
    public AstNode visitMethodDecl(MethodDeclContext ctx) {
        method = classAst.createMethodNode();
        String name;
        Type type;
        int mdf = parseModifier(ctx.varModifier());
        if (ctx.prefix != null && ctx.prefix.getText().equals("constructor")) {
            type = Types.VOID_TYPE;
            name = "<init>";
        } else {
            if (ctx.type() == null) {
                type = Types.VOID_TYPE;
            } else {
                type = parseType(ctx.type());
            }
            name = ctx.name.getText();
        }
        method.modifier = mdf;
        method.type = type;
        method.name = name;
        if (ctx.varDecl() != null) {
            for(VarDeclContext vd:ctx.varDecl()){
                ParameterNode pn = ParameterNode.create(method);
                varDecl(vd, pn);
                method.parameters.add(pn);
            }
        }
        if (ctx.stat() != null) {
            methodBodys.put(method, ctx.stat());
        }
        if (ctx.exceptionTypes != null) {
            for (Token et : ctx.exceptionTypes) {
                ClassType exType = requireClassType(et);
                if(exType!=null){
                    method.exceptionTypes.add(exType);
                }
            }
        }
        mapAst(method, ctx);
        return method;
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
        IfStmt ifStmt = new IfStmt();
        ExprNode expr = visitExpression(ctx.expression());
        ifStmt.setConditionExpr(expr);
        if (ctx.trueStmt != null) {
            ifStmt.setTrueBody(visitStat(ctx.trueStmt));
        }
        if (ctx.falseStmt != null) {
            ifStmt.setFalseBody(visitStat(ctx.falseStmt));
        }
        mapAst(ifStmt,ctx);
        return ifStmt;
    }

    private ExprNode visitExpression(ExpressionContext expression) {
        Object node = visit(expression);
        if(node instanceof ExprNode){
            return (ExprNode) node;
        }else if(node instanceof AstNode){
            return new ErrorousExpr((AstNode)node);
        }else{
            throw new UnsupportedOperationException("unsupported node:" + node);
        }
    }

    @Override
    public Statement visitStat(StatContext ctx) {
        return (Statement) visit(ctx.getChild(0));
    }

    @Override
    public AstNode visitReturnStat(ReturnStatContext ctx) {
        ReturnStmt rs = new ReturnStmt();
        if (ctx.expression() != null) {
            rs.expr = visitExpression(ctx.expression());
        }
        mapAst(rs,ctx);
        return rs;
    }

    @Override
    public VarDeclStmt visitVarDeclStat(VarDeclStatContext ctx) {
        List<LocalVarNode> vars = visitLocalVarDecl(ctx.localVarDecl());
        VarDeclStmt vds = new VarDeclStmt(vars);
        for(LocalVarNode v:vars){
            vtb.put(v.name, v);
        }
        mapAst(vds,ctx);            
        return vds;
    }

    @Override
    public VarObject visitVarDecl(VarDeclContext ctx) {
        throw new UnsupportedOperationException();
    }
    
    public void varDecl(VarDeclContext ctx,VarObject vds){
        String name = ctx.name.getText();
        TypeContext type = null;
        if (ctx.varType != null) {
            type = ctx.varType;
        } else if (ctx.type() != null) {
            type = ctx.type();
        }
        Type declType =null;
        if (type != null) {
            declType = parseType(type);
        }
        if (isDefindedId(name)) {
            reportError("the name is definded:" + name, ctx);
        }
        vds.name = name;
        vds.type = declType;
        if (ctx.expression() != null) {
            vds.initExpr = (ExprNode) visit(ctx.expression());
            if(vds.type==null && vds.initExpr!=null){
                vds.type = vds.initExpr.getType();
            }
        }
        if(vds.type==null){
            vds.type = Types.ROOT_TYPE;
        }
        mapAst(vds,ctx);
    }
    
    public void reportSyntaxError(String desc,ParserRuleContext rule,Token token){
        SyntaxError syntaxError = new SyntaxError(desc, compilationUnit, rule, token);
        errorHandler.handleCompileError(syntaxError);
    }
    
    public void reportError(String msg, Token token) {
        SourceParsingException ex = new SourceParsingException(msg, compilationUnit ,OffsetRangeHelper.getOffsetRange(token), this);
        errorHandler.handleCompileError(ex);
    }

    public void reportError(String msg,ParserRuleContext tree) {
        SourceParsingException ex = new SourceParsingException(msg,compilationUnit ,OffsetRangeHelper.getOffsetRange(tree), this);
        errorHandler.handleCompileError(ex);
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
        LoopStmt ws = new LoopStmt();
        ws.preConditionExpr = visitExpression(ctx.expression());
        if (ctx.stat() != null) {
            ws.loopBody = visitStat(ctx.stat());
        }
        mapAst(ws,ctx);
        return ws;
    }

    @Override
    public AstNode visitDoWhileStat(DoWhileStatContext ctx) {
        LoopStmt ls = new LoopStmt();
        if (ctx.stat() != null) {
            this.newVarStack();
            ls.loopBody = visitStat(ctx.stat());
            this.popVarStack();
        }
        ls.postConditionExpr = (ExprNode) visit(ctx.expression());
        mapAst(ls,ctx);
        return ls;
    }

    @Override
    public AstNode visitForStat(ForStatContext ctx) {
        this.newVarStack();
        LoopStmt ls = LoopStmt.create();
        List<LocalVarNode> vars = visitLocalVarDecl(ctx.localVarDecl());
        VarDeclStmt vds = new VarDeclStmt(vars);
        ls.initStmts.add(vds);
        ls.preConditionExpr = (ExprNode) visit(ctx.expression());
        BlockStmt bs =new BlockStmt();
        if (ctx.stat() != null) {
            Statement st = visitStat(ctx.stat());
            if(st instanceof BlockStmt){
                bs.statements.addAll(((BlockStmt)st).statements);
            }
        }
        if(ctx.expressions()!=null){
            bs.statements.addAll(visitExpressions(ctx.expressions()));
        }
        ls.loopBody = bs;
        this.popVarStack();
        mapAst(ls,ctx);
        return ls;
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
        AstNode expr = visitExpression(ctx.expression());
        ExprStmt es = new ExprStmt();
        es.setExpr((ExprNode) expr);
        mapAst(es,ctx);
        return es;
    }

    @Override
    public ExprNode visitExprMemberInvocation(ExprMemberInvocationContext ctx) {
        String methodName;
        Token id;
        ClassNode specialClass = null;
        if (ctx.key != null) {
            id = ctx.key;
            methodName = ctx.key.getText();
        } else {
            id = ctx.Identifier().getSymbol();
            methodName = ctx.Identifier().getText();
        }
        if(methodName.equals("this")){
            methodName = "<init>";
            specialClass = this.classAst;
        }else if(methodName.equals("super")){
            methodName = "<init>";
            specialClass = this.classAst.parent;
        }else{
            specialClass = this.classAst;
        }
        ExprNode[] args = visitAll(ctx.params).toArray(new ExprNode[0]);
        ExprNode ie = getImplicitInvokeExpr(methodName,args,ctx);
        return ie;
    }
    
    private BinaryExpr createBinaryExpr(ExprNode expr1,ExprNode expr2,String op){
        switch(op){
            case "==":
            case "!=":
            case ">":
            case ">=":
            case "<":
            case "<=":
                return new CompareExpr(expr1, expr2, op);
            case "&&":
            case "||":
                return new LogicExpr(expr1, expr2, op);
            default:
                return new MathExpr(expr1, expr2, op);
        }
    }

    @Override
    public AssignExpr visitExprAssign(ExprAssignContext ctx) {
        String assignOp = ctx.getChild(1).getText();
        ExprNode to = visitExpression(ctx.expression(0));
        ExprNode from = visitExpression(ctx.expression(1));
        if (assignOp.length() > 1) {
            String op = assignOp.substring(0, assignOp.length() - 1);
            from = createBinaryExpr(to, from, op);
        }
        ExprNode fromExpr = (ExprNode) from;
        AssignableExpr toExpr = null;
        if(to instanceof AssignableExpr){
            toExpr = (AssignableExpr) to;
        }else{
            reportError("unsupported assign statement",ctx);
        }
        AssignExpr aexpr = new AssignExpr(toExpr,fromExpr);
        mapAst(aexpr, ctx);
        return aexpr;
    }

    @Override
    public AstNode visitExprMidOp(ExprMidOpContext ctx) {
        String op = ctx.getChild(1).getText();
        ExprNode expr1 = (ExprNode) visitExpression(ctx.expression(0));
        ExprNode expr2 = (ExprNode) visitExpression(ctx.expression(1));
        Type type1 = expr1.getType();
        Type type2 = expr2.getType();
        boolean isPrimitive1 = (type1 instanceof PrimitiveType);
        boolean isPrimitive2 = (type2 instanceof PrimitiveType);
        ExprNode expr;
        if(isPrimitive1 && isPrimitive2){
            BinaryExpr be = createBinaryExpr(expr1,expr2,op);
            expr = be;
        }else if(Types.isNumber(type1) && Types.isNumber(type2)){
            PrimitiveType t = SemanticAnalyzer.getMathType(type1, type2, op);
            expr1 = BoxUtil.assign(expr1, type1, t);
            expr2 = BoxUtil.assign(expr2, type2, t);
            if(expr1==null || expr2 == null){
                throw new UnknownError("cast fail");
            }
            expr = createBinaryExpr(expr1, expr2, op);
        }else if(op.equals("==") || op.equals("!=")){
            expr = createBinaryExpr(expr1, expr2, op);
        }else if(op.equals("+")){
            if(!Types.STRING_CLASS_TYPE.equals(type1)){
                expr1 = checkBox(expr1,expr1.getType(),Types.STRING_CLASS_TYPE,ctx.expression(0).getStart());
            }
            if(!Types.STRING_CLASS_TYPE.equals(type2)){
                expr2 = checkBox(expr2,expr2.getType(),Types.STRING_CLASS_TYPE,ctx.expression(1).getStart());
            }
            InvocationExpr ie;
            try {
                ie = ObjectInvokeExpr.create(expr1, "concat",new ExprNode[]{expr2});
            } catch (MethodNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            expr = ie;
        }else{
            throw new UnknownError("unknown binary expression");
        }
        mapAst(expr, ctx);
        return expr;
    }
    
    private ExprNode getImplicitInvokeExpr(String methodName,ExprNode[] args, ParserRuleContext ctx){
        ExprNode expr;
        try {
            InvocationExpr.MethodSelection ms = InvocationExpr.applyMethod(classAst, methodName, args);
            if(Modifier.isStatic(ms.selectedMethod.modifier)){
                expr = new StaticInvokeExpr(new ClassReference(classAst), ms.selectedMethod, ms.appliedArguments);
            }else{
                expr = new ObjectInvokeExpr(new ThisExpr(Types.getClassType(classAst)), ms.selectedMethod, ms.appliedArguments);
            }
        } catch (MethodNotFoundException ex) {
            expr = new UnknownInvocationExpr(null, methodName, args);
        }
        mapAst(expr, ctx);
        return expr;
    }
    
    private ExprNode getObjectInvokeExpr(ExprNode target,String methodName,List<ExpressionContext> argumentsCtx,ParserRuleContext ctx){
        ExprNode[] args = visitAll(argumentsCtx).toArray(new ExprNode[0]);
        ExprNode expr;
        try {
            expr = ObjectInvokeExpr.create(target, methodName, args);
        } catch (MethodNotFoundException ex) {
            expr= new UnknownInvocationExpr(target,methodName,args);
        }
        mapAst(expr, ctx);
        return expr;
    }
    
    private  ExprNode getStaticInvokeExpr(ClassReference clazz,String methodName,List<ExpressionContext> argumentsCtx,ParserRuleContext ctx){
        ExprNode[] args = visitAll(argumentsCtx).toArray(new ExprNode[0]);
        ExprNode expr;
        try {
            expr = StaticInvokeExpr.create(clazz, methodName, args);
        } catch (MethodNotFoundException ex) {
            expr = new UnknownInvocationExpr(clazz, methodName , args);
        }
        mapAst(expr, ctx);
        return expr;
    }

    @Override
    public AstNode visitExprInvocation(ExprInvocationContext ctx) {
        Object target = visit(ctx.target);
        if(target==null) return null;
        String mdName = ctx.Identifier().getText();
        if(target instanceof ClassReference){
            return getStaticInvokeExpr((ClassReference) target, mdName,ctx.params, ctx);
        }else if(target instanceof ExprNode){
            return getObjectInvokeExpr((ExprNode) target, mdName, ctx.params,ctx);
        }else{
            throw new UnknownError("unknown node:"+ target);
        }
    }

    @Override
    public ExprNode visitExprGetField(ExprGetFieldContext ctx) {
        Object expr = visit(ctx.expression());
        if(expr==null) return null;
        String name = ctx.Identifier().getText();
        if(expr instanceof ExprNode){
            ExprNode exprNode = (ExprNode) expr;
            return getObjectFieldLikeExpr(exprNode,name,ctx);
        }else if(expr instanceof ClassReference){
            return getStaticFieldExpr((ClassReference)expr, name, ctx);
        }else{
            throw new UnknownError("unknown node:" + expr);
        }
    }

    @Override
    public UnaryExpr visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
        String op = ctx.getChild(0).getText();
        UnaryExpr ue = new UnaryExpr();
        ue.setExpr((ExprNode) visitExpression(ctx.expression()));
        ue.setOperation(op);
        mapAst(ue, ctx);
        return ue;
    }

    @Override
    public ElementExpr visitExprGetArrayElement(ExprGetArrayElementContext ctx) {
        ElementExpr ee = new ElementExpr();
        ee.setArrayExpr((ExprNode) visitExpression(ctx.expression(0)));
        ee.setIndex((ExprNode) visitExpression(ctx.expression(1)));
        mapAst(ee, ctx);
        return ee;
    }
    
    /**
     * expand the class name if could
     * @param id
     * @return 
     */
    private String expandClassName(String id){
        if (fullNames.containsKey(id)) {
            return fullNames.get(id);
        } else {
            List<String> paths = new ArrayList<>(importPaths.size()+1);
            paths.add(classPath);
            paths.addAll(importPaths);
            for (String p : paths) {
                String clsName = p + "." + id;
                ClassNode cls = astLoader.getAst(clsName);
                if (cls != null) {
                    return clsName;
                }
            }
        }
        return id;
    }
    
    private boolean isDefindedId(String id){
        if(isClassId(id)) return true;
        if(getNodeById(id,null)!=null) return true;
        return false;
    }
    
    private boolean isClassId(String name){
        String id = expandClassName(name);
        ClassNode targetClass = astLoader.getAst(id);
        return (targetClass!=null);
    }
    
    private AstNode requireNameDefined(String name,Token token){
        AstNode n = getNodeById(name, token);
        if(n==null){
            reportError(name + " is undefined!", token);
            return null;
        }
        return n;
    }

    @Nullable
    private AstNode getNodeById(@Nonnull String name,@Nullable Token token) {
        if(isClassId(name)){
            ClassReference clsRef = new ClassReference(requireAst(name,token));
            mapAst(clsRef, token);
            return clsRef;
        }
        if (vtb.exist(name)) {
            VarExpr ve = new VarExpr();
            LocalVarNode declStmt = vtb.get(name); //vars.indexOf(vo);
            ve.setVar(declStmt);
            if(token!=null) mapAst(ve, token);
            return ve;
        } else {
            //find parameters
            if (method != null && method.parameters != null) {
                for (ParameterNode p : method.parameters) {
                    if (p.name.equals(name)) {
                        VarExpr ve = new VarExpr(p);
                        if(token!=null) mapAst(ve, token);
                        return ve;
                    }
                }
            }
            if (classAst.fields != null) {
                for (FieldNode f : classAst.fields) {
                    if (f.name!=null && f.name.equals(name)) {
                        FieldExpr fe;
                        if(Modifier.isStatic(f.modifier)){
                            fe = new StaticFieldExpr(new ClassReference(classAst), f);
                        }else{
                            fe = new ObjectFieldExpr(new ThisExpr(Types.getClassType(classAst)), f);
                        }
                        if(token!=null) mapAst(fe, token);
                        return fe;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public ConstExpr visitLiteral(LiteralContext ctx) {
        ConstExpr ce = new ConstExpr();
        String t = ctx.getText();
        if (ctx.IntegerLiteral() != null) {
            ce.setConstType(Types.INT_TYPE);
            ce.setValue((Object) Integer.parseInt(t));
        } else if (ctx.FloatingPointLiteral() != null) {
            ce.setConstType(Types.FLOAT_TYPE);
            ce.setValue((Object) Float.parseFloat(t));
        } else if (ctx.BooleanLiteral() != null) {
            ce.setConstType(Types.BOOLEAN_TYPE);
            ce.setValue((Object) Boolean.parseBoolean(t));
        } else if (ctx.CharacterLiteral() != null) {
            ce.setConstType(Types.CHAR_TYPE);
            char[] chars = t.toCharArray();
            ce.setValue((Object) chars[1]);
        } else if (ctx.StringLiteral() != null) {
            ce.setConstType(Types.STRING_CLASS_TYPE);
            //TODO parse string
            ce.setValue(t.substring(1, t.length() - 1));
        } else {
            ce.setConstType(Types.NULL_TYPE);
        }
        mapAst(ce,ctx);
        return ce;
    }

    @Override
    public AstNode visitImportDecl(ImportDeclContext ctx) {
        String name = ctx.name.getText();
        String prefix = "";
        boolean relative = ctx.root == null || ctx.root.getText().length() == 0;
        if (relative && this.classPath.length() > 0) {
            prefix = this.classPath + ".";
        }
        if (ctx.path != null) {
            for (Token p : ctx.path) {
                prefix += p.getText() + ".";
            }
        }
        if (name.equals("*")) {
            this.importPaths.add(prefix.substring(0, prefix.length() - 1));
        } else {
            String key = name;
            if (ctx.alias != null) {
                key = ctx.alias.getText();
            }
            this.fullNames.put(key, prefix + name);
        }
        return null;
    }

    @Override
    public AstNode visitQualifiedName(QualifiedNameContext ctx) {
        //do nothing
        return null;
    }

    private int parseModifier(VarModifierContext modifier) {
        if (modifier == null) {
            return Modifier.PUBLIC;
        }
        int m = 0;
        int access = 0;
        for (ParseTree c : modifier.children) {
            String s = c.getText();
            if (s.equals("public")) {
                access = Modifier.PUBLIC;
            } else if (s.equals("protected")) {
                access = Modifier.PROTECTED;
            } else if (s.equals("private")) {
                access = Modifier.PRIVATE;
            } else if (s.equals("static")) {
                m += Modifier.STATIC;
            } else if (s.equals("final")) {
                m += Modifier.FINAL;
            }
        }
        if (access == 0) {
            access = Modifier.PUBLIC;
        }
        return m + access;
    }

    @Override
    public AstNode visitNewExpr(NewExprContext ctx) {
        ClassType clsType = requireClassType(ctx.Identifier().getSymbol());
        ExprNode[] params = visitAll(ctx.params).toArray(new ExprNode[0]);
        //InvocationExpr inv = getInvocationExpr(newExpr, "<init>", ctx.params,clsType.getClassNode(),ctx.Identifier().getSymbol());
        NewObjectExpr newExpr;
        try {
            newExpr = new NewObjectExpr(clsType,params);
        } catch (MethodNotFoundException ex) {
            reportError("construcotr not found", ctx.Identifier().getSymbol());
            return null;
        }
//        
//        newExpr.setConstructor(inv);
        mapAst(newExpr,ctx);
        return newExpr;
    }

    @Override
    public AstNode visitCastExpr(CastExprContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        Type toType = parseType(ctx.type());
        CastExpr ce = new CastExpr(toType,expr);
        mapAst(ce,ctx);
        return ce;
    }

    @Override
    public AstNode visitTryStat(TryStatContext ctx) {
        TryStmt tryStmt = new TryStmt();
        this.newVarStack();
        tryStmt.execStmt = visitStat(ctx.tryStmtList);
        this.popVarStack();
        if (ctx.catchTypes != null) {
            for (int i = 0; i < ctx.catchTypes.size(); i++) {
                String vName = ctx.catchVarNames.get(i).getText();
                String vType = ctx.catchTypes.get(i).getText();
                this.newVarStack();
                LocalVarNode vo = new LocalVarNode();
                vo.name = vName;
                vo.type = requireClassType(vType, ctx.catchTypes.get(i).start);
                Statement execStmt = visitStat(ctx.catchStmts.get(i));
                CatchBlock catchStmt = new CatchBlock(vo,execStmt); 
                this.popVarStack();
                tryStmt.catchStmts.add(catchStmt);
            }
        }
        if (ctx.finalStmtList != null) {
            this.newVarStack();
            tryStmt.finallyStmt = visitStat(ctx.finalStmtList);
            this.popVarStack();
        }
        mapAst(tryStmt,ctx);
        return tryStmt;
    }

    @Override
    public List<LocalVarNode> visitLocalVarDecl(LocalVarDeclContext ctx) {
        List<LocalVarNode> list = new LinkedList();
        for (VarDeclContext v : ctx.varDecl()) {
            LocalVarNode localVar = new LocalVarNode();
            varDecl(v, localVar);
            mapAst(localVar,ctx);
            list.add(localVar);
            vtb.put(localVar.name, localVar);
        }
        return list;
    }

    @Override
    public AstNode visitExprIdentifier(ExprIdentifierContext ctx) {
        String name = ctx.Identifier().getText();
        AstNode expr = this.getNodeById(name,ctx.Identifier().getSymbol());
        if (expr == null) {
            this.reportError(name + " is undefined!", ctx);
            return null;
        }
//        if(expr instanceof ClassReference){
//            reportError("not an expression", ctx);
//            return null;
//        }
        mapAst(expr,ctx);
        return expr;
    }

    @Override
    public AstNode visitExprLiteral(ExprLiteralContext ctx) {
        return visitLiteral(ctx.literal());
    }

    @Override
    public AstNode visitExprParen(ExprParenContext ctx) {
        return visitExpression(ctx.expression());
    }

    @Override
    public AstNode visitBlockStmt(BlockStmtContext ctx) {
        BlockStmt bs =new BlockStmt();
        if (ctx.stat() == null) {
            return bs;
        }
        for (StatContext s : ctx.stat()) {
            bs.statements.add(visitStat(s));
        }
        mapAst(bs,ctx);
        return bs;
    }

    @Override
    public AstNode visitVarModifier(VarModifierContext ctx) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AstNode visitExprSelfRef(ExprSelfRefContext ctx) {
        ThisExpr expr = new ThisExpr(Types.getClassType(classAst));
        mapAst(expr, ctx);
        return expr;
    }
    
    @Override
    public String toString(){
        return "CompilantUnit:" + className;
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
        id = expandClassName(id);
        try {
            return astLoader.loadAst(id);
        } catch (AstNotFoundException ex) {
            reportError("ast not found:" + id, token);
            return null;
        }
    }
    
    @Nullable
    private ClassNode getAst(String id){
        if(id==null || id.length()==0) return null;
        id =expandClassName(id);
        return astLoader.getAst(id);
    }

    @Nullable
    private Type parseSingleType(KalangParser.SingleTypeContext singleTypeContext){
        if(singleTypeContext.Identifier()!=null){
            return requireClassType(singleTypeContext.Identifier().getSymbol());
        }else{
            return Types.getPrimitiveType(singleTypeContext.getText());
        }
    }

    @Nullable
    private Type parseType(TypeContext typeContext) {
        if(typeContext.singleType()!=null){
            return parseSingleType(typeContext.singleType());
        }else{
            Type ct = parseType(typeContext.type());
            if(ct==null) return null;
            return Types.getArrayType(ct);
        }
    }

    @Override
    public Object visitSingleType(KalangParser.SingleTypeContext ctx) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object visitPrimitiveType(KalangParser.PrimitiveTypeContext ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IncrementExpr visitExprInc(KalangParser.ExprIncContext ctx) {
        return getIncrementExpr(ctx.expression(), ctx.op.getText(), false);
    }

    @Override
    public IncrementExpr visitExprIncPre(KalangParser.ExprIncPreContext ctx) {
        return getIncrementExpr(ctx.expression(), ctx.op.getText(), true);
    }
    
    public IncrementExpr getIncrementExpr(ExpressionContext expressionContext,String op,boolean isPrefix){
        ExprNode expr = visitExpression(expressionContext);
        if(!(expr instanceof AssignableExpr)){
            reportError("require assignable expression", expressionContext);
            return null;
        }
        boolean isDesc = op.equals("--");
        return new IncrementExpr((AssignableExpr) expr, isDesc, isPrefix);
    }

    private ExprNode checkBox(ExprNode expr1, Type fromType, Type toType,Token token) {
        ExprNode expr = BoxUtil.assign(expr1,fromType,toType);
        if(expr==null){
            reportError("unable to cast " + fromType + " to " + toType, token);
        }
        return expr;
    }
    
    protected ExprNode getObjectFieldLikeExpr(ExprNode expr,String fieldName,ParserRuleContext rule){
        ExprNode ret;
        Type type = expr.getType();
        if(!(type instanceof  ClassType)){
            reportError("unsupported type", rule);
            return null;
        }
        ClassType exprType = (ClassType) type;
        if ((exprType instanceof ArrayType)
                && fieldName.equals("length")) {
            ret = new ArrayLengthExpr(expr);
        } else {
            try {
                ret = ObjectFieldExpr.create(expr, fieldName);
            } catch (FieldNotFoundException ex) {
                ret = new UnknownFieldExpr(expr,exprType.getClassNode(),fieldName);
            }
        }
        mapAst(ret, rule);
        return ret;
    }
    
    protected ExprNode getStaticFieldExpr(ClassReference clazz,String fieldName,ParserRuleContext rule){
        ExprNode ret;
        try {
            ret = StaticFieldExpr.create(clazz,fieldName);
        } catch (FieldNotFoundException ex) {
            ret = new UnknownFieldExpr(clazz, clazz.getReferencedClassNode(), fieldName);
        }
        mapAst(ret, rule);
        return ret;
    }

    @Override
    public Object visitErrorousStat(KalangParser.ErrorousStatContext ctx) {
        reportSyntaxError("missing ';'", ctx, ctx.stop);
        return null;
    }

    @Override
    public Object visitErrorousMemberExpr(KalangParser.ErrorousMemberExprContext ctx) {
        reportSyntaxError("identifier excepted", ctx, ctx.stop);
        return null;
    }

}
