package compilier;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import kalang.antlr.KalangParser.ArgumentDeclContext;
import kalang.antlr.KalangParser.ArgumentDeclListContext;
import kalang.antlr.KalangParser.ArgumentsContext;
import kalang.antlr.KalangParser.BreakStatContext;
import kalang.antlr.KalangParser.CastExprContext;
import kalang.antlr.KalangParser.ClassBodyContext;
import kalang.antlr.KalangParser.CompiliantUnitContext;
import kalang.antlr.KalangParser.ContinueStatContext;
import kalang.antlr.KalangParser.DoWhileStatContext;
import kalang.antlr.KalangParser.ExprAssignContext;
import kalang.antlr.KalangParser.ExprGetArrayElementContext;
import kalang.antlr.KalangParser.ExprGetFieldContext;
import kalang.antlr.KalangParser.ExprInvocationContext;
import kalang.antlr.KalangParser.ExprMemberInvocationContext;
import kalang.antlr.KalangParser.ExprMidOpContext;
import kalang.antlr.KalangParser.ExprPrimayContext;
import kalang.antlr.KalangParser.ExprSelfOpContext;
import kalang.antlr.KalangParser.ExprSelfOpPreContext;
import kalang.antlr.KalangParser.ExprStatContext;
import kalang.antlr.KalangParser.ExpressionContext;
import kalang.antlr.KalangParser.ExpressionsContext;
import kalang.antlr.KalangParser.FieldDeclContext;
import kalang.antlr.KalangParser.FieldDeclListContext;
import kalang.antlr.KalangParser.ForInitContext;
import kalang.antlr.KalangParser.ForStatContext;
import kalang.antlr.KalangParser.ForUpdateContext;
import kalang.antlr.KalangParser.GetterContext;
import kalang.antlr.KalangParser.IfStatContext;
import kalang.antlr.KalangParser.IfStatSuffixContext;
import kalang.antlr.KalangParser.ImportDeclContext;
import kalang.antlr.KalangParser.ImportDeclListContext;
import kalang.antlr.KalangParser.ImportPathContext;
import kalang.antlr.KalangParser.LiteralContext;
import kalang.antlr.KalangParser.MethodDeclContext;
import kalang.antlr.KalangParser.MethodDeclListContext;
import kalang.antlr.KalangParser.NewExprContext;
import kalang.antlr.KalangParser.PrimaryIdentifierContext;
import kalang.antlr.KalangParser.PrimaryLiteralContext;
import kalang.antlr.KalangParser.PrimayParenContext;
import kalang.antlr.KalangParser.QualifiedNameContext;
import kalang.antlr.KalangParser.ReturnStatContext;
import kalang.antlr.KalangParser.SetterContext;
import kalang.antlr.KalangParser.StatContext;
import kalang.antlr.KalangParser.StatListContext;
import kalang.antlr.KalangParser.TypeContext;
import kalang.antlr.KalangParser.VarDeclContext;
import kalang.antlr.KalangParser.VarDeclStatContext;
import kalang.antlr.KalangParser.VarInitContext;
import kalang.antlr.KalangParser.WhileStatContext;
import kalang.antlr.KalangVisitor;
import kalang.core.VarObject;
import kalang.core.VarTable;
import jast.ast.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;


public class SourceParser extends AbstractParseTreeVisitor<ExprNode> implements KalangVisitor<ExprNode> {

    public static class Position{
        int offset;
        int length;
    }
	
    public static class ParseError extends RuntimeException{
        Position position;
        public ParseError(String msg,Position position){
            super(msg);
            this.position = position;
        }
        public Position getPosition() {
            return position;
        }
    }
	
    private static final String FLOAT_CLASS = "java.lang.Float";

    private static final String INT_CLASS = "java.lang.Integer";

    private static final String BOOLEAN_CLASS = "java.lang.Boolean";

    private static final String CHAR_CLASS = "java.lang.Character";

    private static final String STRING_CLASS = "java.lang.String";

    private static final String NULL_CLASS = "java.lang.NullObject";
	
    //short name to full name
    private Map<String,String> fullNames = new HashMap();
    private List<String> importPaths = new LinkedList();
    //VarTable vtb = new VarTable();
    Stack<VarTable> vtbs = new Stack();
    List<VarObject> vars = new LinkedList();
    HashMap<VarObject,VarDeclStmt> varDeclStmts = new HashMap();
    List<String> fields = new LinkedList();
    HashMap<String,ParameterNode> parameters;
    ClassNode cls = new ClassNode();
    List<Statement> codes;
    List<ExprNode> arguments;
    //ClassNode classNode;
    MethodNode method;
	
    String defaultType;// = "java.lang.Object";
    static String DEFAULT_METHOD_TYPE = "java.lang.Object";
	
    private Map<AstNode,ParseTree> a2p = new HashMap();
	
    private AstLoader astLoader;

    private ParseTree context;

    private CommonTokenStream tokens;
    
    private String className;
	
    public void compile(AstLoader astLoader){
        this.astLoader = astLoader;
        visit(context);
    }
	
    public SourceParser(String className,String src){
        KalangLexer lexer = new KalangLexer(new ANTLRInputStream(src));
        tokens = new CommonTokenStream(lexer);
        KalangParser parser = new KalangParser(tokens);
        this.context = parser.compiliantUnit();
        this.className = className;
        cls = new ClassNode();
    }
	
    public void importPackage(String packageName){
        this.importPaths.add(packageName);
    }
	
    public Position getLocation(ParseTree tree){
        Position loc = new Position();
        Interval itv = tree.getSourceInterval();
        Token t = tokens.get(itv.a);
        loc.offset = t.getStartIndex();
        loc.length = t.getStopIndex() - loc.offset;
        return loc;
    }
	
    public Position getLocation(AstNode node){
        ParseTree tree = this.a2p.get(node);
        return getLocation(tree);
    }
	
    private VarTable getVarTable(){
        return vtbs.peek();
    }
	
    public Map<AstNode,ParseTree> getParseTreeMap(){
        return this.a2p;
    }
	
    private void pushVarTable(){
        VarTable vtb;
        if(vtbs.size()>0){
            vtb = new VarTable(getVarTable());
        }else{
            vtb = new VarTable();
        }
		
        vtbs.push(vtb);
    }
	
    private void popVarTable(){
        vtbs.pop();
    }
	
    public ClassNode getAst(){
        return this.cls;
    }

    @Override
    public ExprNode visitCompiliantUnit(CompiliantUnitContext ctx) {
        //List<ImportNode> imports = 
        this.visitImportDeclList(ctx.importDeclList());
        visitClassBody(ctx.classBody());
        //cls.imports = imports;
        cls.name= this.className;
        cls.modifier=getModifier(ctx.Modifier());
		
        if(ctx.Identifier()!=null){
            cls.parentName=(ctx.Identifier().getText());
        }
        return null;
    }

    @Override
    public ExprNode visitClassBody(ClassBodyContext ctx) {
        this.pushVarTable();
        this.visitFieldDeclList(ctx.fieldDeclList());
        this.visitMethodDeclList(ctx.methodDeclList());
        a2p.put(cls,ctx);
        return null;
    }

    @Override
    public ExprNode visitFieldDeclList(FieldDeclListContext ctx) {
        cls.fields = new LinkedList();
        for(FieldDeclContext fd:ctx.fieldDecl()){
            this.visitFieldDecl(fd);
        }
        return null;
    }

    @Override
    public ExprNode visitFieldDecl(FieldDeclContext ctx) {
        String type = ctx.type()==null?defaultType:ctx.type().getText();
        FieldNode fo = new FieldNode();
        fo.name=(ctx.Identifier().getText());
        fo.type=(type);
        if(ctx.varInit()!=null){
            fo.initExpr =  (visitVarInit(ctx.varInit()));
        }
            fo.modifier = getModifier(ctx.Modifier());
        fields.add(fo.name);
        cls.fields.add(fo);
        //TODO visit setter and getter
        return null;
    }

    @Override
    public ExprNode visitSetter(SetterContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExprNode visitGetter(GetterContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExprNode visitMethodDeclList(MethodDeclListContext ctx) {
        cls.methods = new LinkedList();
        for(MethodDeclContext md:ctx.methodDecl()){
            visitMethodDecl(md);
        }
        return null;
    }

    @Override
    public ExprNode visitMethodDecl(MethodDeclContext ctx) {
        this.pushVarTable();
        this.parameters = new HashMap();
        String name = ctx.Identifier().getText();
        String type = ctx.type()==null ? DEFAULT_METHOD_TYPE :ctx.type().getText();
        int mdf = 0;
            mdf = getModifier(ctx.Modifier());
        boolean isStatic = false;
        if(ctx.STATIC()!=null){
            isStatic = true;
        }
        method = new MethodNode(mdf,type,name,isStatic);
        BlockStmt body = new BlockStmt();
        method.body = body;
        if(ctx.argumentDeclList()!=null){
            visitArgumentDeclList(ctx.argumentDeclList());
        }
        codes = body.statements = new LinkedList();
        visitStatList(ctx.statList());
        this.popVarTable();
        this.parameters = null;
        a2p.put(method,ctx);
        cls.methods.add(method);
        return null;
    }

    @Override
    public ExprNode visitType(TypeContext ctx) {
        //do nothing
        return null;
    }

    @Override
    public ExprNode visitArgumentDeclList(ArgumentDeclListContext ctx) {
        method.parameters = new LinkedList();
        for(ArgumentDeclContext ad:ctx.argumentDecl()){
            visitArgumentDecl(ad);
        }
        return null;
    }

    @Override
    public ExprNode visitArgumentDecl(ArgumentDeclContext ctx) {
        String name = ctx.Identifier().getText();
        String type = defaultType;
        if(ctx.type()!=null){
            type = ctx.type().getText();
        }
        /*VarObject vo = new VarObject();
        this.getVarTable().put(name, vo);
        this.vars.add(vo);
        vo.setName(name);
        vo.setType(type);
        vo.setId(vars.indexOf(vo));*/
		
        ParameterNode pn = new ParameterNode();
        pn.name = name;
        pn.type = type;
        this.parameters.put(name,pn);
        a2p.put(pn,ctx);
        method.parameters.add(pn);
        return null;
    }

    @Override
    public ExprNode visitStatList(StatListContext ctx) {
        for(StatContext s:ctx.stat()){
            visitStat(s);
        }
        return null;
    }

	
    @Override
    public ExprNode visitIfStat(IfStatContext ctx) {
        List oCodes = codes;
        IfStmt ifStmt = new IfStmt();
        BlockStmt trueBody = new BlockStmt();
        BlockStmt falseBody = new BlockStmt();
        ifStmt.trueBody = trueBody;
        ifStmt.falseBody = falseBody;
        ExprNode expr = visitExpression(ctx.expression());
        ifStmt.conditionExpr = expr;
        codes = trueBody.statements = new LinkedList();
        visitStatList(ctx.statList());
        codes = falseBody.statements = new LinkedList();
        visitIfStatSuffix(ctx.ifStatSuffix());
        a2p.put(ifStmt,ctx);
        codes = oCodes;
        codes.add(ifStmt);
        return null;
    }

    private ExprNode visitExpression(ExpressionContext expression) {
        return (ExprNode) visit(expression);
    }

    @Override
    public ExprNode visitIfStatSuffix(IfStatSuffixContext ctx) {
        visitStatList(ctx.statList());
        return null;
    }

    @Override
    public ExprNode visitStat(StatContext ctx) {
        visit(ctx.getChild(0));
        return null;
    }

    /*private void visitAll(ParserRuleContext ctx) {
    for(ParseTree c:ctx.children){
    visit(c);
    }
    }*/

    @Override
    public ExprNode visitReturnStat(ReturnStatContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        ReturnStmt rs = new ReturnStmt();
        rs.expr = expr;
        a2p.put(rs,ctx);
        codes.add(rs);
        return null;
    }

    @Override
    public ExprNode visitVarDeclStat(VarDeclStatContext ctx) {
        this.visitVarDecl(ctx.varDecl());
        return null;
    }

    @Override
    public ExprNode visitVarDecl(VarDeclContext ctx) {
        String name = ctx.Identifier().getText();
        String type = defaultType;
        if(ctx.type()!=null){
            type = ctx.type().getText();
        }
        boolean isReadOnly = ctx.getChild(0).getText() == "val";
        //TODO readonly
        VarTable vtb = this.getVarTable();
        if(this.getNodeByName(name)!=null){
            reportError("defined duplicatedly:" + name,ctx.Identifier());
        }
        VarDeclStmt vds = new VarDeclStmt();
        VarObject vo = new VarObject();
        vo.setName(name);
        vo.setType(type);
        vars.add(vo);
        this.varDeclStmts.put(vo, vds);
        vtb.put(name, vo);
        Integer vid = vars.indexOf(vo);
        /*
        NameExpr ve = new NameExpr();
        ve.name = name;*/
		
        vds.varName = name;
        vds.type = type;
        vds.varId = vid;
        if(ctx.varInit()!=null){
            vds.initExpr = visit(ctx.varInit());
        }
        a2p.put(vds,ctx);
        codes.add(vds);
        return null;
    }

    private void reportError(String string, ParseTree tree) {
        throw new ParseError(string,this.getLocation(tree));
    }

    @Override
    public ExprNode visitVarInit(VarInitContext ctx) {
        ExprNode vo = visitExpression(ctx.expression());
        return vo;
    }

    @Override
    public ExprNode visitBreakStat(BreakStatContext ctx) {
        BreakStmt bs = new BreakStmt();
        a2p.put(bs,ctx);
        codes.add(bs);
        return null;
    }

    @Override
    public ExprNode visitContinueStat(ContinueStatContext ctx) {
        ContinueStmt cs = new ContinueStmt();
        a2p.put(cs,ctx);
        codes.add(cs);
        return null;
    }

    @Override
    public ExprNode visitWhileStat(WhileStatContext ctx) {
        //WhileStmt ws = new WhileStmt();
        List oCodes = codes;
        LoopStmt ws = new LoopStmt();
        BlockStmt body = new BlockStmt();
        ws.loopBody = body;
        AstNode expr = visitExpression(ctx.expression());
        ws.preConditionExpr = (ExprNode) expr;
        codes = body.statements = new LinkedList();
        visitStatList(ctx.statList());
        a2p.put(ws,ctx);
        codes = oCodes;
        codes.add(ws);
        return null;
    }

    @Override
    public ExprNode visitDoWhileStat(DoWhileStatContext ctx) {
		
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ExprNode visitForStat(ForStatContext ctx) {
        List oCodes = codes;
        this.pushVarTable();
        LoopStmt ls = new LoopStmt();
        BlockStmt body = new BlockStmt();
        ls.loopBody = body;
        codes = ls.initStmts =new LinkedList();
        visitForInit(ctx.forInit());
        AstNode texpr = visitExpression(ctx.expression());
        ls.preConditionExpr = (ExprNode) texpr;
        codes = body.statements = new LinkedList();
        visitStatList(ctx.statList());
        visitForUpdate(ctx.forUpdate());
        this.popVarTable();
        a2p.put(ls,ctx);
        codes = oCodes;
        return null;
    }

    @Override
    public ExprNode visitForInit(ForInitContext ctx) {
        visit(ctx.varDecl());
        return null;
    }

    @Override
    public ExprNode visitForUpdate(ForUpdateContext ctx) {
        visitExpressions(ctx.expressions());
        return null;
    }

    @Override
    public ExprNode visitExpressions(ExpressionsContext ctx) {
        for(ExpressionContext e:ctx.expression()){
            ExprNode expr = visitExpression(e);
            codes.add(new ExprStmt(expr));
        }
        return null;
    }

    @Override
    public ExprNode visitExprStat(ExprStatContext ctx) {
        AstNode expr = visitExpression(ctx.expression());
        ExprStmt es = new ExprStmt();
        es.expr = (ExprNode) expr;
        a2p.put(es,ctx);
        codes.add(es);
        return null;
    }

    @Override
    public ExprNode visitExprPrimay(ExprPrimayContext ctx) {
        return (ExprNode) visit(ctx.primary());
    }

    @Override
    public InvocationExpr visitExprMemberInvocation(ExprMemberInvocationContext ctx) {
        InvocationExpr ie = this.getInvocationExpr(
            null
            , ctx.Identifier().getText()
            ,ctx.arguments());
        a2p.put(ie,ctx);
        return ie;
    }

    @Override
    public AssignExpr visitExprAssign(ExprAssignContext ctx) {
        AstNode to = visitExpression(ctx.expression(0));
        AstNode from = visitExpression(ctx.expression(1));
        AssignExpr aexpr = new AssignExpr();
        aexpr.from = (ExprNode) from;
        aexpr.to = (ExprNode) to;
        a2p.put(aexpr, ctx);
        return aexpr;
    }

    @Override
    public ExprNode visitExprMidOp(ExprMidOpContext ctx) {
        String op = ctx.getChild(1).getText();
        BinaryExpr be = new BinaryExpr();
        be.expr1 = (ExprNode) visitExpression(ctx.expression(0));
        be.expr2 = (ExprNode) visitExpression(ctx.expression(1));
        be.operation = op;
        a2p.put(be, ctx);
        return be;
    }
	
    private InvocationExpr getInvocationExpr(AstNode expr,String methodName,ArgumentsContext argumentsCtx){
        InvocationExpr is = new InvocationExpr();
        is.methodName =methodName;
        is.target = (ExprNode) expr;
        arguments = is.arguments = new LinkedList();
        visitArguments(argumentsCtx);
        return is;
    }

    @Override
    public ExprNode visitExprInvocation(ExprInvocationContext ctx) {
        InvocationExpr ei = this.getInvocationExpr(
            visitExpression(ctx.expression())
            , ctx.Identifier().getText()
            , ctx.arguments());
        a2p.put(ei, ctx);
        return ei;
    }

    @Override
    public ExprNode visitExprGetField(ExprGetFieldContext ctx) {
        AstNode expr = visitExpression(ctx.expression());
        String name = ctx.Identifier().getText();
        FieldExpr fe = new FieldExpr();
        fe.target = (ExprNode) expr;
        fe.fieldName = name;
        a2p.put(fe, ctx);
        return fe;
    }

    @Override
    public ExprNode visitExprSelfOp(ExprSelfOpContext ctx) {
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

    @Override
    public ExprNode visitPrimayParen(PrimayParenContext ctx) {
        return visitExpression(ctx.expression());
    }

    @Override
    public ConstExpr visitPrimaryLiteral(PrimaryLiteralContext ctx) {
        return visitLiteral(ctx.literal());
    }

    @Override
    public ExprNode visitPrimaryIdentifier(PrimaryIdentifierContext ctx) {
        String name = ctx.Identifier().getText();
        return getNodeByName(name);
    }
	
    private String checkFullClassName(String name,ParseTree tree){
        String fn = getFullClassName(name);
        if(fn==null){
            this.reportError("Unknown class:"+name,tree);
        }
        return fn;
    }
	
    private String getFullClassName(String name){
        if(fullNames.containsKey(name)){
            return fullNames.get(name);
        }else{
            for(String p:this.importPaths){
                String clsName = p + "." + name;
                ClassNode cls = astLoader.getAst(clsName);
                if(cls!=null){
                    return clsName;
                }
            }
        }
        return null;
    }

    private ExprNode getNodeByName(String name) {
        VarTable vtb = this.getVarTable();
        if(vtb.exist(name)){
            VarExpr ve = new VarExpr();
            VarObject vo = vtb.get(name);
            Integer vid = vars.indexOf(vo);
            ve.varId = vid;
            ve.declStmt = this.varDeclStmts.get(vo);
            return ve;
        }else if(fields.contains(name)){
            FieldExpr fe = new FieldExpr();
            fe.fieldName = name;
            return fe;
        }else if(parameters.containsKey(name)){
            return new ParameterExpr(parameters.get(name));
        }else{
            String clsName = this.getFullClassName(name);
            if(clsName!=null){
                return new ClassExpr(clsName);
            }
        }
        return null;
    }

    @Override
    public ConstExpr visitLiteral(LiteralContext ctx) {
        ConstExpr ce = new ConstExpr();
        String t = ctx.getText();
        //TODO parse value
        ce.value = t;
        if(ctx.IntegerLiteral()!=null){
            ce.type = INT_CLASS;
        }else if(ctx.FloatingPointLiteral()!=null){
            ce.type = FLOAT_CLASS;
        }else if(ctx.BooleanLiteral()!=null){
            ce.type = BOOLEAN_CLASS;
        }else if(ctx.CharacterLiteral()!=null){
            ce.type = CHAR_CLASS;
        }else if(ctx.StringLiteral()!=null){
            ce.type = STRING_CLASS;
        }else{
            ce.type = NULL_CLASS;
        }
        a2p.put(ce, ctx);
        return ce;
    }

    @Override
    public ExprNode visitArguments(ArgumentsContext ctx) {
        for(ExpressionContext e:ctx.expression()){
            ExprNode expr = visitExpression(e);
            arguments.add(expr);
        }
        return null;
    }
	
    private List doVisitAll(List list){
        List retList = new LinkedList();
        for(Object i:list){
            retList.add(visit((ParseTree) i));
        }
        return retList;
    }

    @Override
    public ExprNode visitImportDeclList(ImportDeclListContext ctx) {
        doVisitAll(ctx.importDecl());
        return null;
    }

    @Override
    public ExprNode visitImportDecl(ImportDeclContext ctx) {
        String name = ctx.importPath().getText();
        if(name.endsWith(".*")){
            this.importPaths.add(name.substring(0, name.length()-2));
        }else{
            String[] namePs = name.split("\\.");
            this.fullNames.put(namePs[namePs.length-1], name);
        }
        return null;
    }

    @Override
    public ExprNode visitQualifiedName(QualifiedNameContext ctx) {
        //do nothing
        return null;
    }

    @Override
    public ExprNode visitImportPath(ImportPathContext ctx) {
        //do nothing
        return null;
    }

    public Integer getModifier(TerminalNode ctx) {
        if(ctx==null) return Modifier.PUBLIC;
        int m = 0;
        String[] mdfs = ctx.getText().split(" ");
        for(String text:mdfs){
            switch(text){
            case "!":
                m += Modifier.PRIVATE;break;
            case "?":
                m += Modifier.PROTECTED;break;
            default:
                System.err.println("Unknown modifier" + text);
            }
        }
        return m;
    }

    @Override
    public NewExpr visitNewExpr(NewExprContext ctx) {
        String type =  ctx.Identifier().getText();
        NewExpr newExpr = new NewExpr();
        newExpr.type = checkFullClassName(type,ctx);
        arguments = newExpr.arguments = new LinkedList();
        this.visitArguments(ctx.arguments());
        a2p.put(newExpr, ctx);
        return newExpr;
    }

    @Override
    public ExprNode visitCastExpr(CastExprContext ctx) {
        CastExpr ce = new CastExpr();
        ce.expr = visitExpression(ctx.expression());
        ce.type = ctx.type().getText();
        a2p.put(ce, ctx);
        return ce;
    }

}
