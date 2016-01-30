package kalang.compiler;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import kalang.antlr.KalangParser.ArgumentsContext;
import kalang.antlr.KalangParser.BlockStmtContext;
import kalang.antlr.KalangParser.BreakStatContext;
import kalang.antlr.KalangParser.CastExprContext;
import kalang.antlr.KalangParser.ClassBodyContext;
import kalang.antlr.KalangParser.CompiliantUnitContext;
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
import kalang.antlr.KalangParser.VarDeclsContext;
import kalang.antlr.KalangParser.VarModifierContext;
import kalang.antlr.KalangParser.WhileStatContext;
import kalang.antlr.KalangVisitor;
import kalang.core.VarTable;
import jast.ast.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

public class SourceParser extends AbstractParseTreeVisitor implements KalangVisitor {

    private static final String MAP_CLASS = "java.util.HashMap";
    
    static String DEFAULT_METHOD_TYPE = "java.lang.Object";
    static String DEFAULT_LIST_CLASS = "java.util.LinkedList";
    static String DEFAULT_VAR_TYPE;// = "java.lang.Object";

    //short name to full name
    private final Map<String, String> fullNames = new HashMap<String, String>();
    private final List<String> importPaths = new LinkedList<String>();
    ClassNode cls = new ClassNode();
    MethodNode method;
    private final BidiMap<AstNode, ParseTree> a2p = new DualHashBidiMap<AstNode, ParseTree>();

    private AstLoader astLoader;

    private ParseTree context;

    private TokenStream tokens;

    private final String className;
    private String classPath;

    TypeSystem typeSystem;
    private VarTable<String, VarDeclStmt> vtb;
    private KalangParser parser;
    
    private HashMap<Token,ParseTree> token2tree = new HashMap<>();
    
    private SemanticErrorHandler semanticErrorHandler = new SemanticErrorHandler() {
        @Override
        public void handleSemanticError(SemanticErrorException see) {
            System.err.println(see);
        }
    };
    
    private ParseTreeListener parseTreeListener = new ParseTreeListener() {
        
        Stack<Integer> treeStartToken = new Stack<Integer>();
        
        @Override
        public void visitTerminal(TerminalNode tn) {}

        @Override
        public void visitErrorNode(ErrorNode en) {}

        @Override
        public void enterEveryRule(ParserRuleContext prc) {
            treeStartToken.push(parser.getCurrentToken().getTokenIndex());
        }

        @Override
        public void exitEveryRule(ParserRuleContext prc) {
            int stopIndex = parser.getCurrentToken().getTokenIndex();
            int startIndex = treeStartToken.pop();
            for(int i=startIndex;i<=stopIndex;i++){
                Token tk = tokens.get(i);
                if(!token2tree.containsKey(tk)) token2tree.put(tk, prc);
            }
        }
            
    };

    public SemanticErrorHandler getSemanticErrorHandler() {
        return semanticErrorHandler;
    }

    public void setSemanticErrorHandler(SemanticErrorHandler semanticErrorHandler) {
        this.semanticErrorHandler = semanticErrorHandler;
    }
    
    public AstNode getAstNode(ParseTree tree){
        return a2p.getKey(tree);
    }
    
    public ParseTree getParseTree(AstNode node){
        return a2p.get(node);
    }
    
    public ParseTree getParseTreeByTokenIndex(int tokenIndex){
        Token t = tokens.get(tokenIndex);
        ParseTree tree = token2tree.get(t);
        return tree;
    }
  
    @Override
    public Object visitThrowStat(KalangParser.ThrowStatContext ctx) {
        ExprNode expr = (ExprNode) visit(ctx.expression());
        ThrowStmt ts = new ThrowStmt(expr);
        map(ts, ctx);
        return ts;
    }

    public static class Position {

        int offset;
        int length;
    }

    public static class ParseError extends RuntimeException {

        /**
         *
         */
        private static final long serialVersionUID = -4496606055942267965L;
        Position position;

        public ParseError(String msg, Position position) {
            super(msg);
            this.position = position;
        }

        public Position getPosition() {
            return position;
        }
    }
    
    public static SourceParser create(String clsName,String source){
        KalangLexer lexer = new KalangLexer(new ANTLRInputStream(source));
        TokenStream tokens = new CommonTokenStream(lexer);
        KalangParser p = new KalangParser(tokens);
        SourceParser sp = new SourceParser(clsName, p);
        p.setErrorHandler(new DefaultErrorStrategy() {

            @Override
            public void reportError(Parser recognizer, RecognitionException e) {
                RuleContext ctx = e.getCtx();
                if (ctx == null) {
                    Token tk = e.getOffendingToken();
                    sp.reportError("syntax error!", tk);
                } else {
                    sp.reportError("syntax error!", ctx);
                }
                super.reportError(recognizer, e);
            }
        });
        return sp;
    }

    public void compile(AstLoader astLoader) {
        this.astLoader = astLoader;
        this.typeSystem = new TypeSystem(astLoader);
        parser.addParseListener(parseTreeListener);
        this.context = parser.compiliantUnit();
        visit(context);
        parser.removeParseListener(parseTreeListener);
    }

    public SourceParser(String className, KalangParser parser) {
        this.className = className;
        this.classPath = "";
        this.parser = parser;
        tokens = parser.getTokenStream();
        if (className.contains(".")) {
            classPath = className.substring(0, className.lastIndexOf('.'));
        }
        cls = ClassNode.create();
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

    public Position getLocation(Token token) {
        return getLocation(token, token);
    }

    public Position getLocation(Token token, Token token2) {
        Position loc = new Position();
        loc.offset = token.getStartIndex();
        loc.length = token2.getStopIndex() - loc.offset + 1;
        return loc;
    }

    public Position getLocation(ParseTree tree) {
        Interval itv = tree.getSourceInterval();
        int a = itv.a;
        int b = itv.b;
        if (a > b) {
            b = a;
        }
        Token t = tokens.get(a);
        Token tt = tokens.get(b);
        return getLocation(t, tt);
    }

    public Position getLocation(AstNode node) {
        ParseTree tree = this.a2p.get(node);
        if (tree != null) {
            return getLocation(tree);
        }
        return null;
    }

    void newVarStack() {
        if (vtb != null) {
            vtb = new VarTable<String, VarDeclStmt>(vtb);
        } else {
            vtb = new VarTable<String, VarDeclStmt>();
        }
    }

    void popVarStack() {
        vtb = vtb.getParent();
    }

    public Map<AstNode, ParseTree> getParseTreeMap() {
        return this.a2p;
    }

    public ClassNode getAst() {
        return this.cls;
    }
    
    private void map(AstNode node,ParseTree tree){
        a2p.put(node,tree);
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
        VarObject vo = new VarObject();
        VarDeclStmt vds = new VarDeclStmt(vo);
        vo.type = MAP_CLASS;
        NewExpr initExpr = new NewExpr();
        initExpr.type = vo.type;
        vo.initExpr = initExpr;
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
            k.type = this.typeSystem.getStringClass();// STRING_CLASS;
            k.value = ctx.Identifier(i).getText();
            iv.arguments.add(k);
            iv.arguments.add(v);
            ExprStmt es = new ExprStmt(iv);
            mse.stmts.add(es);
        }
        mse.reference = ve;
        map(mse,ctx);
        //TODO set generic type
        return mse;
    }

    @Override
    public MultiStmtExpr visitListOrArray(KalangParser.ListOrArrayContext ctx) {
        MultiStmtExpr mse = MultiStmtExpr.create();
        String clsName = DEFAULT_LIST_CLASS;
        VarObject vo = new VarObject();
        VarDeclStmt vds = new VarDeclStmt(vo);
        vo.type = clsName;
        NewExpr initExpr = new NewExpr();
        initExpr.type = vo.type;
        vo.initExpr = initExpr;
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
        map(mse,ctx);
        return mse;
    }

    @Override
    public AstNode visitExprNewArray(KalangParser.ExprNewArrayContext ctx) {
        NewArrayExpr nae = new NewArrayExpr();
        nae.size = (ExprNode) visit(ctx.expression());
        nae.type = checkFullType(ctx.noArrayType().getText(), ctx);
        a2p.put(nae, ctx);
        return nae;
    }

    @Override
    public AstNode visitNoArrayType(KalangParser.NoArrayTypeContext ctx) {
        //do nothing
        return null;
    }

    @Override
    public AstNode visitExprQuestion(KalangParser.ExprQuestionContext ctx) {
        MultiStmtExpr mse = MultiStmtExpr.create();
        VarObject vo = new VarObject();
        VarDeclStmt vds = new VarDeclStmt(vo);
        mse.stmts.add(vds);
        //addCode(vds, ctx);
        VarExpr ve = new VarExpr(vo);
        IfStmt is = new IfStmt();
        is.conditionExpr = (ExprNode) visit(ctx.expression(0));
        is.trueBody = new ExprStmt(new AssignExpr(ve, (ExprNode) visit(ctx.expression(1))));
        is.falseBody = new ExprStmt(new AssignExpr(ve, (ExprNode) visit(ctx.expression(2))));
        mse.reference = ve;
        //addCode(is, ctx);
        a2p.put(ve, ctx);
        return mse;
    }

    @Override
    public AstNode visitPostIfStmt(KalangParser.PostIfStmtContext ctx) {
        ExprNode leftExpr = visitExpression(ctx.expression(0));
        if (!(leftExpr instanceof AssignExpr)) {
            this.reportError("AssignExpr required", ctx);
        }
        AssignExpr assignExpr = (AssignExpr) leftExpr;
        ExprNode to = assignExpr.to;
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
        map(is,ctx);
        return is;
    }

    @Override
    public AstNode visitCompiliantUnit(CompiliantUnitContext ctx) {
        this.visitAll(ctx.importDecl());
        cls.name = this.className;
        cls.modifier = parseModifier(ctx.varModifier());
        String classType = ctx.classType.getText();
        if (classType.equals("interface")) {
            cls.isInterface = true;
        }
        if (ctx.parentClass != null) {
            cls.parentName = this.checkFullType(ctx.parentClass.getText(), ctx);
        }
        if (ctx.interfaces != null && ctx.interfaces.size() > 0) {
            for (Token itf : ctx.interfaces) {
                cls.interfaces.add(checkFullType(itf.getText(), ctx));
            }
        }
        visitClassBody(ctx.classBody());
        a2p.put(cls, ctx);
        return null;
    }

    @Override
    public AstNode visitClassBody(ClassBodyContext ctx) {
        this.newVarStack();
        this.visitChildren(ctx);
        this.popVarStack();
        a2p.put(cls, ctx);
        return null;
    }

    @Override
    public List<VarObject> visitFieldDecl(FieldDeclContext ctx) {
        List<VarObject> list = visitVarDecls(ctx.varDecls());
        int mdf = this.parseModifier(ctx.varModifier());
        if(cls.fields==null){
        	cls.fields = new LinkedList();
        }
        for (VarObject v : list) {
            v.modifier = mdf;
            cls.fields.add(v);
        }
        return list;
    }

    @Override
    public AstNode visitMethodDecl(MethodDeclContext ctx) {
        method = MethodNode.create();
        this.newVarStack();
        String name;
        String type;
        if (ctx.prefix != null && ctx.prefix.getText().equals("constructor")) {
            type = "void";
            name = "<init>";
        } else {
            if (ctx.type() == null) {
                type = "void";
            } else {
                type = checkFullType(ctx.type().getText(), ctx);
            }
            name = ctx.name.getText();
        }
        int mdf = parseModifier(ctx.varModifier());
        method.modifier = mdf;
        method.type = type;
        method.name = name;
        if (ctx.varDecls() != null) {
            List<VarObject> vars = visitVarDecls(ctx.varDecls());
            method.parameters.addAll(vars);
        }
        if (ctx.stat() != null) {
            method.body = visitStat(ctx.stat());
        }
        if (ctx.exceptionTypes != null) {
            for (Token et : ctx.exceptionTypes) {
                String eFullType = this.checkFullType(et.getText(), ctx);
                method.exceptionTypes.add(eFullType);
            }
        }
        this.popVarStack();
        cls.methods.add(method);
        a2p.put(method, ctx);
        return method;
    }

    @Override
    public AstNode visitType(TypeContext ctx) {
        //do nothing
        return null;
    }

    public void visitAll(List<? extends ParseTree> list) {
        for (ParseTree i : list) {
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
        map(ifStmt,ctx);
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
        map(rs,ctx);
        return rs;
    }

    @Override
    public VarDeclStmt visitVarDeclStat(VarDeclStatContext ctx) {
        //List<VarDeclStmt> list = new LinkedList();
        VarObject var = this.visitVarDecl(ctx.varDecl());
        VarDeclStmt vds = new VarDeclStmt(var);
        vtb.put(var.name, vds);
        map(vds,ctx);
        return vds;
    }

    @Override
    public VarObject visitVarDecl(VarDeclContext ctx) {
        String name = ctx.name.getText();
        String type = DEFAULT_VAR_TYPE;
        if (ctx.varType != null) {
            type = ctx.varType.getText();
        } else if (ctx.type() != null) {
            type = ctx.type().getText();
        }
        if (type != null) {
            type = checkFullType(type, ctx);
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
        VarObject vds = new VarObject();
        vds.name = name;
        vds.type = type;
        if (ctx.expression() != null) {
            vds.initExpr = (ExprNode) visit(ctx.expression());
        }
        map(vds,ctx);
        return vds;
    }

    private void reportError(String msg, Token token,ParseTree tree) {
        SemanticErrorException see = new SemanticErrorException(msg, token,tree);
        semanticErrorHandler.handleSemanticError(see);
//        ParseError error = new ParseError(msg, this.getLocation(token));
//        System.err.println(error.getMessage());
    }

    private void reportError(String string, ParseTree tree) {
        int a = tree.getSourceInterval().a;
        reportError(string, tokens.get(a),tree);
    }
    
    private void reportError(String string, Token token) {
        reportError(string, token,token2tree.get(token));
    }

    @Override
    public AstNode visitBreakStat(BreakStatContext ctx) {
        BreakStmt bs = new BreakStmt();
        map(bs,ctx);
        return bs;
    }

    @Override
    public AstNode visitContinueStat(ContinueStatContext ctx) {
        ContinueStmt cs = new ContinueStmt();
        map(cs,ctx);
        return cs;
    }

    @Override
    public AstNode visitWhileStat(WhileStatContext ctx) {
        LoopStmt ws = new LoopStmt();
        ws.preConditionExpr = visitExpression(ctx.expression());
        if (ctx.stat() != null) {
            ws.loopBody = visitStat(ctx.stat());
        }
        map(ws,ctx);
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
        map(ls,ctx);
        return ls;
    }

    @Override
    public AstNode visitForStat(ForStatContext ctx) {
        this.newVarStack();
        LoopStmt ls = LoopStmt.create();
        List<VarObject> vars = visitVarDecls(ctx.varDecls());
        for(VarObject v:vars){
        	VarDeclStmt vds = new VarDeclStmt(v);
        	vtb.put(v.name, vds);
            ls.initStmts.add(vds);
        }
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
        map(ls,ctx);
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
        map(es,ctx);
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
                target, methodName, ctx.arguments());
        a2p.put(ie, ctx);
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
        aexpr.from = (ExprNode) from;
        aexpr.to = (ExprNode) to;
        a2p.put(aexpr, ctx);
        return aexpr;
    }

    @Override
    public AstNode visitExprMidOp(ExprMidOpContext ctx) {
        String op = ctx.getChild(1).getText();
        BinaryExpr be = new BinaryExpr();
        be.expr1 = (ExprNode) visitExpression(ctx.expression(0));
        be.expr2 = (ExprNode) visitExpression(ctx.expression(1));
        be.operation = op;
        a2p.put(be, ctx);
        return be;
    }

    private InvocationExpr getInvocationExpr(AstNode expr, String methodName, ArgumentsContext argumentsCtx) {
        InvocationExpr is = new InvocationExpr();
        is.methodName = methodName;
        is.target = (ExprNode) expr;
        is.arguments = visitArguments(argumentsCtx);
        return is;
    }

    @Override
    public AstNode visitExprInvocation(ExprInvocationContext ctx) {
        InvocationExpr ei = this.getInvocationExpr(
                visitExpression(ctx.expression()), ctx.Identifier().getText(), ctx.arguments());
        a2p.put(ei, ctx);
        return ei;
    }

    @Override
    public AstNode visitExprGetField(ExprGetFieldContext ctx) {
        AstNode expr = visitExpression(ctx.expression());
        String name = ctx.Identifier().getText();
        FieldExpr fe = new FieldExpr();
        fe.target = (ExprNode) expr;
        fe.fieldName = name;
        a2p.put(fe, ctx);
        return fe;
    }

    @Override
    public AstNode visitExprSelfOp(ExprSelfOpContext ctx) {
        UnaryExpr ue = new UnaryExpr();
        ue.postOperation = ctx.getChild(1).getText();
        ue.expr = (ExprNode) visitExpression(ctx.expression());
        a2p.put(ue, ctx);
        return ue;
    }

    @Override
    public UnaryExpr visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
        String op = ctx.getChild(0).getText();
        UnaryExpr ue = new UnaryExpr();
        ue.expr = (ExprNode) visitExpression(ctx.expression());
        ue.preOperation = op;
        a2p.put(ue, ctx);
        return ue;
    }

    @Override
    public ElementExpr visitExprGetArrayElement(ExprGetArrayElementContext ctx) {
        ElementExpr ee = new ElementExpr();
        ee.target = (ExprNode) visitExpression(ctx.expression(0));
        ee.key = (ExprNode) visitExpression(ctx.expression(1));
        a2p.put(ee, ctx);
        return ee;
    }

    private String checkFullType(String name, ParseTree tree) {
        if (this.typeSystem.isPrimitiveType(name)) {
            return name;
        }
        String fn = getFullClassName(name);
        if (fn == null) {
            this.reportError("Unknown class:" + name, tree);
            return DEFAULT_VAR_TYPE;
        }
        return fn;
    }

    private String getFullClassName(String name) {
        String postfix = "";
        if (name.endsWith("[]")) {
            name = name.substring(0, name.length() - 2);
            postfix = "[]";
        }
        if (fullNames.containsKey(name)) {
            return fullNames.get(name) + postfix;
        } else {
            for (String p : this.importPaths) {
                String clsName = p + "." + name;
                ClassNode cls = astLoader.getAst(clsName);
                if (cls != null) {
                    return clsName + postfix;
                }
            }
        }
        return null;
    }

    private ExprNode getNodeByName(String name) {
        if (vtb.exist(name)) {
            VarExpr ve = new VarExpr();
            VarDeclStmt declStmt = (VarDeclStmt) vtb.get(name); //vars.indexOf(vo);
            ve.var = declStmt.var;
            return ve;
        } else {
            //find parameters
            if (method != null && method.parameters != null) {
                for (VarObject p : method.parameters) {
                    if (p.name.equals(name)) {
                        return new VarExpr(p);
                    }
                }
            }
            if (cls.fields != null) {
                for (VarObject f : cls.fields) {
                    if (f.name.equals(name)) {
                        FieldExpr fe = new FieldExpr();
                        fe.fieldName = name;
                        return fe;
                    }
                }
            }
            String clsName = this.getFullClassName(name);
            if (clsName != null) {
                return new ClassExpr(clsName);
            }
        }
        return null;
    }

    @Override
    public ConstExpr visitLiteral(LiteralContext ctx) {
        ConstExpr ce = new ConstExpr();
        String t = ctx.getText();
        if (ctx.IntegerLiteral() != null) {
            ce.type = typeSystem.getIntPrimitiveType();
            ce.value = Integer.parseInt(t);
        } else if (ctx.FloatingPointLiteral() != null) {
            ce.type = typeSystem.getFloatPrimitiveType();
            ce.value = Float.parseFloat(t);
        } else if (ctx.BooleanLiteral() != null) {
            ce.type = typeSystem.getBooleanPrimitiveType();
            ce.value = Boolean.parseBoolean(t);
        } else if (ctx.CharacterLiteral() != null) {
            ce.type = typeSystem.getCharPrimitiveType();
            char[] chars = t.toCharArray();
            ce.value = chars[1];
        } else if (ctx.StringLiteral() != null) {
            ce.type = typeSystem.getStringClass();
            //TODO parse string
            ce.value = t.substring(1, t.length() - 1);
        } else {
            ce.type = typeSystem.getNullPrimitiveType();
        }
        map(ce,ctx);
        return ce;
    }

    @Override
    public List<ExprNode> visitArguments(ArgumentsContext ctx) {
        LinkedList<ExprNode> arguments = new LinkedList();
        for (ExpressionContext e : ctx.expression()) {
            ExprNode expr = visitExpression(e);
            arguments.add(expr);
        }
        return arguments;
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
        String type = ctx.Identifier().getText();
        ClassExpr expr = new ClassExpr();
        expr.name = checkFullType(type, ctx);
        InvocationExpr inv = this.getInvocationExpr(expr, "<init>", ctx.arguments());
        map(inv,ctx);
        return inv;
    }

    @Override
    public AstNode visitCastExpr(CastExprContext ctx) {
        CastExpr ce = new CastExpr();
        ce.expr = visitExpression(ctx.expression());
        ce.type = ctx.type().getText();
        map(ce,ctx);
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
                VarObject vo = new VarObject();
                vo.name = vName;
                vo.type = vType;
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
        map(tryStmt,ctx);
        return tryStmt;
    }

    @Override
    public List<VarObject> visitVarDecls(VarDeclsContext ctx) {
        List<VarObject> list = new LinkedList();
        for (VarDeclContext v : ctx.varDecl()) {
            list.add(visitVarDecl(v));
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
        map(expr,ctx);
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
        map(bs,ctx);
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
        a2p.put(expr, ctx);
        return expr;
    }

}
