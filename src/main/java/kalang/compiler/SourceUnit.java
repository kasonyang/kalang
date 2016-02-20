package kalang.compiler;

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
import kalang.ast.KeyExpr;
import kalang.ast.ConstExpr;
import kalang.ast.TryStmt;
import kalang.ast.ThrowStmt;
import kalang.ast.CatchStmt;
import kalang.ast.CastExpr;
import kalang.ast.BlockStmt;
import kalang.ast.BreakStmt;
import kalang.ast.UnaryExpr;
import kalang.ast.NewArrayExpr;
import kalang.ast.ClassExpr;
import kalang.ast.IfStmt;
import kalang.ast.FieldExpr;
import kalang.ast.ReturnStmt;
import kalang.ast.ParameterExpr;
import kalang.util.AstUtil;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
import kalang.antlr.KalangParser.ExprSelfOpContext;
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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.antlr.KalangParser.LocalVarDeclContext;
import kalang.ast.AssignableExpr;
import kalang.ast.FieldNode;
import kalang.ast.LocalVarNode;
import kalang.ast.NewObjectExpr;
import kalang.ast.ParameterNode;
import kalang.ast.VarDeclStmt;
import kalang.core.ClassType;
import kalang.core.Type;
import kalang.core.Types;
import kalang.util.OffsetRangeHelper;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 *  build ast from antlr parse tree
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class SourceUnit extends AbstractParseTreeVisitor implements KalangVisitor {
   
    static String DEFAULT_VAR_TYPE;// = "java.lang.Object";

    //short name to full name
    private final Map<String, String> fullNames = new HashMap<>();
    private final List<String> importPaths = new LinkedList<>();
    ClassNode classAst = new ClassNode();
    MethodNode method;
    //private final BidiMap<AstNode, ParserRuleContext> a2p = new DualHashBidiMap<>();

    private AstLoader astLoader;

    private ParserRuleContext context;

    private TokenStream tokenStream;

    private final String className;
    private String classPath;

    private VarTable<String, LocalVarNode> vtb;
    private KalangParser parser;
    
    private SourceParsingErrorHandler semanticErrorHandler = new SourceParsingErrorHandler() {
        @Override
        public void handleSemanticError(SourceParsingException see) {
            System.err.println(see);
        }
    };
    private final ClassType mapType;
    private ClassType stringType;
    private ClassType listType;
    
    public SourceParsingErrorHandler getSemanticErrorHandler() {
        return semanticErrorHandler;
    }

    public void setSemanticErrorHandler(SourceParsingErrorHandler semanticErrorHandler) {
        this.semanticErrorHandler = semanticErrorHandler;
    }
    
//    public AstNode getAstNode(ParseTree tree){
//        AstNode node = null;
//        while(node==null && tree!=null){
//            node = a2p.getKey(tree);
//            tree = tree.getParent();
//        }
//        return node;
//    }
    
    public ParserRuleContext getParseTree(){
        return context;
    }
    
//    public ParserRuleContext getParseTree(AstNode node){
//        return a2p.get(node);
//    }
  
    @Override
    public Object visitThrowStat(KalangParser.ThrowStatContext ctx) {
        ExprNode expr = (ExprNode) visit(ctx.expression());
        ThrowStmt ts = new ThrowStmt(expr);
        mapAst(ts, ctx);
        return ts;
    }

    String getClassName() {
        return className;
    }
    
    private ClassType requireClassType(Token token){
        return requireClassType(token.getText(),token);
    }
    
    private ClassType requireClassType(String id,Token token){
        ClassNode ast = requireAst(id, token);
        if(ast==null) return null;
        return Types.getClassType(ast);
    }

    public void compile(){
        compile(null);
    }
    
    public void compile(AstLoader astLoader) {
        if(astLoader==null){
            this.astLoader = new AstLoader();
        }else{
            this.astLoader = astLoader;
        }
        this.context = parser.compilantUnit();
        visit(context);
        //AstMetaParser metaParser = new AstAstMetaParser();
        if(AstUtil.getMethodsByName(classAst, "<init>").length<1){
            AstUtil.createEmptyConstructor(classAst);
        }
    }

    public SourceUnit(String className, KalangParser parser) {
        this.className = className;
        classAst.name = className;
        this.classPath = "";
        this.parser = parser;
        tokenStream = parser.getTokenStream();
        if (className.contains(".")) {
            classPath = className.substring(0, className.lastIndexOf('.'));
        }
        classAst = ClassNode.create();
            mapType = Types.MAP_IMPL_TYPE;
            stringType = Types.STRING_CLASS_TYPE;
            listType = Types.LIST_CLASS_TYPE;
    }

    @Override
    public Object visit(ParseTree tree) {
        if (tree == null) {
            System.err.println("visit null");
            return null;
        }
        return super.visit(tree);
    }

    public void importPackage(String packageName) {
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

//    public Map<AstNode, ParserRuleContext> getParseTreeMap() {
//        return this.a2p;
//    }

    public ClassNode getAst() {
        return this.classAst;
    }
    
    private void mapAst(AstNode node,ParserRuleContext tree){
         node.offset = OffsetRangeHelper.getOffsetRange(tree);
        //a2p.put(node,tree);
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
        vo.type = mapType;
        NewObjectExpr newExpr = new NewObjectExpr(mapType);
        vo.initExpr = newExpr;
        mse.stmts.add(vds);
        VarExpr ve = new VarExpr(vo);
        List<TerminalNode> ids = ctx.Identifier();
        for (int i = 0; i < ids.size(); i++) {
            ExpressionContext e = ctx.expression(i);
            ExprNode v = (ExprNode) visit(e);
            InvocationExpr iv = new InvocationExpr();
            iv.target = ve;
            iv.methodName = "put";
            ConstExpr k = new ConstExpr();
            k.type = stringType;// STRING_CLASS_NAME;
            k.value = ctx.Identifier(i).getText();
            iv.arguments.add(k);
            iv.arguments.add(v);
            ExprStmt es = new ExprStmt(iv);
            mse.stmts.add(es);
        }
        mse.reference = ve;
        mapAst(mse,ctx);
        //TODO set generic type
        return mse;
    }

    @Override
    public MultiStmtExpr visitListOrArray(KalangParser.ListOrArrayContext ctx) {
        MultiStmtExpr mse = MultiStmtExpr.create();
        LocalVarNode vo = new LocalVarNode();
        VarDeclStmt vds = new VarDeclStmt(vo);
        vo.type = listType;
        NewObjectExpr newExpr = new NewObjectExpr(listType);
        vo.initExpr = newExpr;
        mse.stmts.add(vds);
        //addCode(vds, ctx);
        VarExpr ve = new VarExpr(vo);
        for (ExpressionContext e : ctx.expression()) {
            InvocationExpr iv = new InvocationExpr();
            iv.target = ve;
            iv.methodName = "add";
            iv.arguments.add((ExprNode) visit(e));
            mse.stmts.add(new ExprStmt(iv));
        }
        mse.reference = ve;
        //TODO set generic type
        mapAst(mse,ctx);
        return mse;
    }

    @Override
    public AstNode visitExprNewArray(KalangParser.ExprNewArrayContext ctx) {
        NewArrayExpr nae = new NewArrayExpr();
        nae.size = (ExprNode) visit(ctx.expression());
        nae.type = parseSingleType(ctx.singleType());
        mapAst(nae, ctx);
        return nae;
    }

    @Override
    public AstNode visitExprQuestion(KalangParser.ExprQuestionContext ctx) {
        MultiStmtExpr mse = MultiStmtExpr.create();
        LocalVarNode vo = new LocalVarNode();
        VarDeclStmt vds = new VarDeclStmt(vo);
        mse.stmts.add(vds);
        //addCode(vds, ctx);
        VarExpr ve = new VarExpr(vo);
        IfStmt is = new IfStmt();
        is.conditionExpr = (ExprNode) visit(ctx.expression(0));
        is.trueBody = new ExprStmt(new AssignExpr(ve, (ExprNode) visit(ctx.expression(1))));
        is.falseBody = new ExprStmt(new AssignExpr(ve, (ExprNode) visit(ctx.expression(2))));
        mse.stmts.add(is);
        mse.reference = ve;
        //addCode(is, ctx);
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
        AssignableExpr to = assignExpr.to;
        ExprNode from = assignExpr.from;
        ExprNode cond = visitExpression(ctx.expression(1));
        Token op = ctx.op;
        if (op != null) {
            String opStr = op.getText();
            BinaryExpr be = new BinaryExpr(to, cond, opStr);
            cond = be;
        }
        AssignExpr as = new AssignExpr();
        as.from = from;
        as.to = to;
        IfStmt is = new IfStmt();
        is.conditionExpr = cond;
        is.trueBody = new ExprStmt(as);
        //addCode(is, ctx);
        mapAst(is,ctx);
        return is;
    }

    @Override
    public AstNode visitCompilantUnit(CompilantUnitContext ctx) {
        this.visitAll(ctx.importDecl());
        classAst.name = this.className;
        classAst.modifier = parseModifier(ctx.varModifier());
        String classType = ctx.classType.getText();
        if (classType.equals("interface")) {
            classAst.isInterface = true;
        }
        if (ctx.parentClass != null) {
            classAst.parent =  requireAst(ctx.parentClass);
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
        this.newVarStack();
        String name;
        Type type;
        int mdf = parseModifier(ctx.varModifier());
        if (ctx.prefix != null && ctx.prefix.getText().equals("constructor")) {
            type = Types.VOID_TYPE;
            name = "<init>";
            //mdf = mdf | Modifier.STATIC;
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
            method.body = visitStat(ctx.stat());
        }
        if (ctx.exceptionTypes != null) {
            for (Token et : ctx.exceptionTypes) {
                ClassType exType = requireClassType(et);
                if(exType!=null){
                    method.exceptionTypes.add(exType);
                }
            }
        }
        this.popVarStack();
        //cls.methods.add(method);
        mapAst(method, ctx);
        return method;
    }

    @Override
    public AstNode visitType(TypeContext ctx) {
        //do nothing
        return null;
    }

    public void visitAll(List<? extends ParserRuleContext> list) {
        for (ParserRuleContext i : list) {
            visit(i);
        }
    }

    @Override
    public AstNode visitIfStat(IfStatContext ctx) {
        IfStmt ifStmt = new IfStmt();
        ExprNode expr = visitExpression(ctx.expression());
        ifStmt.conditionExpr = expr;
        if (ctx.trueStmt != null) {
            ifStmt.trueBody = visitStat(ctx.trueStmt);
        }
        if (ctx.falseStmt != null) {
            ifStmt.falseBody = visitStat(ctx.falseStmt);
        }
        mapAst(ifStmt,ctx);
        return ifStmt;
    }

    private ExprNode visitExpression(ExpressionContext expression) {
        return (ExprNode) visit(expression);
    }

    @Override
    public Statement visitStat(StatContext ctx) {
        //visitChildren(ctx);
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
        List<VarDeclStmt> list = new LinkedList();
        //VarObject var = this.visitVarDecl(ctx.varDecl());
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
        Type returnType =null;
        if (type != null) {
            returnType = parseType(type);
        }
        ExprNode namedNode = this.getNodeByName(name);
        if (namedNode != null) {
            String msg = null;
            if (namedNode instanceof ClassExpr) {
                msg = "Can't use class name as variable name:" + name;
            } else if (namedNode instanceof ParameterExpr) {
                msg = "Variable was definded in parameters:" + name;
            } else if (namedNode instanceof VarExpr) {
                msg = "Variable was definded already:" + name;
            }
            if (msg != null) {
                reportError(msg, ctx);
            }
        }
        vds.name = name;
        vds.type = returnType;
        if (ctx.expression() != null) {
            vds.initExpr = (ExprNode) visit(ctx.expression());
        }
        mapAst(vds,ctx);
    }
    
    public void reportError(String msg, Token token) {
        SourceParsingException ex = new SourceParsingException(msg, OffsetRangeHelper.getOffsetRange(token), this);
        semanticErrorHandler.handleSemanticError(ex);
    }

    public void reportError(String msg,ParserRuleContext tree) {
        SourceParsingException ex = new SourceParsingException(msg, OffsetRangeHelper.getOffsetRange(tree), this);
        semanticErrorHandler.handleSemanticError(ex);
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
        //TODO fixme
        BlockStmt bs = BlockStmt.create();
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
            //addCode(new ExprStmt(expr), ctx);
            list.add(new ExprStmt(expr));
        }
        return list;
    }

    @Override
    public AstNode visitExprStat(ExprStatContext ctx) {
        AstNode expr = visitExpression(ctx.expression());
        ExprStmt es = new ExprStmt();
        es.expr = (ExprNode) expr;
        mapAst(es,ctx);
        return es;
    }

    @Override
    public InvocationExpr visitExprMemberInvocation(ExprMemberInvocationContext ctx) {
        String methodName;
        ExprNode target;
        if (ctx.key != null) {
            target = new KeyExpr(ctx.key.getText());
            methodName = "<init>";
        } else {
            methodName = ctx.Identifier().getText();
            target = null;
        }
        InvocationExpr ie = this.getInvocationExpr(
                target, methodName, ctx.params);
        mapAst(ie, ctx);
        return ie;
    }

    @Override
    public AssignExpr visitExprAssign(ExprAssignContext ctx) {
        String assignOp = ctx.getChild(1).getText();
        ExprNode to = visitExpression(ctx.expression(0));
        ExprNode from = visitExpression(ctx.expression(1));
        if (assignOp.length() > 1) {
            String op = assignOp.substring(0, assignOp.length() - 1);
            from = new BinaryExpr(to, from, op);
        }
        AssignExpr aexpr = new AssignExpr();
        mapAst(aexpr, ctx);
        aexpr.from = (ExprNode) from;
        if(to instanceof AssignableExpr){
            aexpr.to = (AssignableExpr) to;
        }else{
            reportError("unsupported assign statement",ctx);
        }
        return aexpr;
    }

    @Override
    public AstNode visitExprMidOp(ExprMidOpContext ctx) {
        String op = ctx.getChild(1).getText();
        BinaryExpr be = new BinaryExpr();
        be.expr1 = (ExprNode) visitExpression(ctx.expression(0));
        be.expr2 = (ExprNode) visitExpression(ctx.expression(1));
        be.operation = op;
        mapAst(be, ctx);
        return be;
    }

    private InvocationExpr getInvocationExpr(AstNode expr, String methodName, List<ExpressionContext> argumentsCtx) {
        InvocationExpr is = InvocationExpr.create();
        is.methodName = methodName;
        is.target = (ExprNode) expr;
        for(ExpressionContext arg:argumentsCtx){
            is.arguments.add(visitExpression(arg));
        }
        return is;
    }

    @Override
    public AstNode visitExprInvocation(ExprInvocationContext ctx) {
        InvocationExpr ei = this.getInvocationExpr(
                visitExpression(ctx.target), ctx.Identifier().getText(), ctx.params);
        mapAst(ei, ctx);
        return ei;
    }

    @Override
    public FieldExpr visitExprGetField(ExprGetFieldContext ctx) {
        AstNode expr = visitExpression(ctx.expression());
        String name = ctx.Identifier().getText();
        FieldExpr fe = new FieldExpr();
        fe.target = (ExprNode) expr;
        fe.fieldName = name;
        mapAst(fe, ctx);
        return fe;
    }

    @Override
    public AstNode visitExprSelfOp(ExprSelfOpContext ctx) {
        UnaryExpr ue = new UnaryExpr();
        ue.postOperation = ctx.getChild(1).getText();
        ue.expr = (ExprNode) visitExpression(ctx.expression());
        mapAst(ue, ctx);
        return ue;
    }

    @Override
    public UnaryExpr visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
        String op = ctx.getChild(0).getText();
        UnaryExpr ue = new UnaryExpr();
        ue.expr = (ExprNode) visitExpression(ctx.expression());
        ue.preOperation = op;
        mapAst(ue, ctx);
        return ue;
    }

    @Override
    public ElementExpr visitExprGetArrayElement(ExprGetArrayElementContext ctx) {
        ElementExpr ee = new ElementExpr();
        ee.arrayExpr = (ExprNode) visitExpression(ctx.expression(0));
        ee.index = (ExprNode) visitExpression(ctx.expression(1));
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

//    private String checkFullType(String name, ParserRuleContext tree) {
//        String fn = getFullClassName(name);
//        if (fn == null) {
//            this.reportError("Unknown class:" + name, tree);
//            return DEFAULT_VAR_TYPE;
//        }
//        return fn;
//    }

//    public String getFullClassName(String simpleName) {
//        String postfix = "";
//        if (simpleName.endsWith("[]")) {
//            simpleName = simpleName.substring(0, simpleName.length() - 2);
//            postfix = "[]";
//        }
//        if (fullNames.containsKey(simpleName)) {
//            return fullNames.get(simpleName) + postfix;
//        } else {
//            ClassNode classAst = astLoader.getAst(simpleName);
//            if(classAst!=null) return simpleName + postfix;
//            for (String p : this.importPaths) {
//                String clsName = p + "." + simpleName;
//                classAst = astLoader.getAst(clsName);
//                if (classAst != null) {
//                    return clsName + postfix;
//                }
//            }
//        }
//        return null;
//    }

    private ExprNode getNodeByName(String name) {
        if (vtb.exist(name)) {
            VarExpr ve = new VarExpr();
            LocalVarNode declStmt = vtb.get(name); //vars.indexOf(vo);
            ve.var = declStmt;
            return ve;
        } else {
            //find parameters
            if (method != null && method.parameters != null) {
                for (ParameterNode p : method.parameters) {
                    if (p.name.equals(name)) {
                        return new VarExpr(p);
                    }
                }
            }
            if (classAst.fields != null) {
                for (FieldNode f : classAst.fields) {
                    if (f.name!=null && f.name.equals(name)) {
                        FieldExpr fe = new FieldExpr();
                        fe.fieldName = name;
                        return fe;
                    }
                }
            }
            String id = expandClassName(name);
            ClassNode targetClass = astLoader.getAst(id);
            if (targetClass!=null) {
                return new ClassExpr(id);
            }
        }
        return null;
    }

    @Override
    public ConstExpr visitLiteral(LiteralContext ctx) {
        ConstExpr ce = new ConstExpr();
        String t = ctx.getText();
        if (ctx.IntegerLiteral() != null) {
            ce.type = Types.INT_TYPE;
            ce.value = Integer.parseInt(t);
        } else if (ctx.FloatingPointLiteral() != null) {
            ce.type = Types.FLOAT_TYPE;
            ce.value = Float.parseFloat(t);
        } else if (ctx.BooleanLiteral() != null) {
            ce.type = Types.BOOLEAN_TYPE;
            ce.value = Boolean.parseBoolean(t);
        } else if (ctx.CharacterLiteral() != null) {
            ce.type = Types.CHAR_TYPE;
            char[] chars = t.toCharArray();
            ce.value = chars[1];
        } else if (ctx.StringLiteral() != null) {
            ce.type = stringType;
            //TODO parse string
            ce.value = t.substring(1, t.length() - 1);
        } else {
            ce.type = Types.NULL_TYPE;
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

    public int parseModifier(VarModifierContext modifier) {
        //String[] mdfs = modifier.split(" ");
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

    public Integer getModifier(boolean isPrivated, boolean isProtected) {
        if (isPrivated) {
            return Modifier.PRIVATE;
        }
        if (isProtected) {
            return Modifier.PROTECTED;
        }
        return Modifier.PUBLIC;
    }

    @Override
    public AstNode visitNewExpr(NewExprContext ctx) {
        ClassType clsType = requireClassType(ctx.Identifier().getSymbol());
        NewObjectExpr newExpr = new NewObjectExpr(clsType);
        //visitAll(list);
        ExprNode[] ps = new ExprNode[ctx.params.size()];
        for(int i=0;i<ps.length;i++){
            ps[i] = visitExpression(ctx.params.get(i));
        }
        newExpr.arguments = ps;
        mapAst(newExpr,ctx);
        return newExpr;
    }

    @Override
    public AstNode visitCastExpr(CastExprContext ctx) {
        CastExpr ce = new CastExpr();
        ce.expr = visitExpression(ctx.expression());
        ce.type = parseType(ctx.type());
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
                CatchStmt catchStmt =CatchStmt.create();
                String vName = ctx.catchVarNames.get(i).getText();
                String vType = ctx.catchTypes.get(i).getText();
                this.newVarStack();
                LocalVarNode vo = new LocalVarNode();
                vo.name = vName;
                vo.type = requireClassType(vType, ctx.catchTypes.get(i).start);
                VarDeclStmt declStmt = new VarDeclStmt(vo);
                catchStmt.execStmt = visitStat(ctx.catchStmts.get(i));
                this.popVarStack();
                catchStmt.catchVarDecl = declStmt;
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
        ExprNode expr = this.getNodeByName(name);
        if (expr == null) {
            this.reportError(name + " is undefined!", ctx);
        }
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
        BlockStmt bs = BlockStmt.create();
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
        // do nothing
        return null;
    }

    @Override
    public AstNode visitExprSelfRef(ExprSelfRefContext ctx) {
        KeyExpr expr = new KeyExpr(ctx.ref.getText());
        mapAst(expr, ctx);
        return expr;
    }
    
    @Override
    public String toString(){
        return "CompilantUnit:" + className;
    }

    public AstLoader getAstLoader() {
        return astLoader;
    }

    public TokenStream getTokenStream() {
        return tokenStream;
    }

    public KalangParser getParser() {
        return parser;
    }
    
    private ClassNode requireAst(Token token){
        return requireAst(token.getText(),token);
    }

    /**
     * checks whether a class is available
     * @param id
     * @param token
     * @return 
     */
    private ClassNode requireAst(String id,Token token) {
        id = expandClassName(id);
        try {
            return astLoader.loadAst(id);
        } catch (AstNotFoundException ex) {
            reportError("ast not found:" + id, token);
            return null;
        }
    }
    
    private ClassNode getAst(String id){
        if(id==null || id.length()==0) return null;
        id =expandClassName(id);
        return astLoader.getAst(id);
    }

    private Type parseSingleType(KalangParser.SingleTypeContext singleTypeContext){
        if(singleTypeContext.Identifier()!=null){
            return requireClassType(singleTypeContext.Identifier().getSymbol());
        }else{
            return Types.getPrimitiveType(singleTypeContext.getText());
        }
    }
    
    private Type parseType(TypeContext typeContext) {
        if(typeContext.singleType()!=null){
            return parseSingleType(typeContext.singleType());
        }else{
            return Types.getArrayType(parseType(typeContext.type()));
        }
    }

    @Override
    public Object visitSingleType(KalangParser.SingleTypeContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimitiveType(KalangParser.PrimitiveTypeContext ctx) {
        //TODO support needed
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    

}
