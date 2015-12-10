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
import kalang.antlr.KalangParser.ExprStatContext;
import kalang.antlr.KalangParser.ExprThisContext;
import kalang.antlr.KalangParser.ExpressionContext;
import kalang.antlr.KalangParser.ExpressionsContext;
import kalang.antlr.KalangParser.FieldDeclContext;
import kalang.antlr.KalangParser.ForStatContext;
import kalang.antlr.KalangParser.IfStatContext;
import kalang.antlr.KalangParser.IfStatSuffixContext;
import kalang.antlr.KalangParser.ImportDeclContext;
import kalang.antlr.KalangParser.LiteralContext;
import kalang.antlr.KalangParser.MethodDeclContext;
import kalang.antlr.KalangParser.NewExprContext;
import kalang.antlr.KalangParser.QualifiedNameContext;
import kalang.antlr.KalangParser.ReturnStatContext;
import kalang.antlr.KalangParser.StatContext;
import kalang.antlr.KalangParser.StatListContext;
import kalang.antlr.KalangParser.TryStatContext;
import kalang.antlr.KalangParser.TypeContext;
import kalang.antlr.KalangParser.VarDeclContext;
import kalang.antlr.KalangParser.VarDeclStatContext;
import kalang.antlr.KalangParser.VarDeclsContext;
import kalang.antlr.KalangParser.WhileStatContext;
import kalang.antlr.KalangVisitor;
import kalang.core.VarTable;
import jast.ast.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;


public class SourceParser extends AbstractParseTreeVisitor<ExprNode> implements KalangVisitor<ExprNode> {
    
    
    private static final String MAP_CLASS = "java.util.HashMap";
    private static final String FLOAT_CLASS = "float";

    private static final String INT_CLASS = "int";

    private static final String BOOLEAN_CLASS = "java.lang.Boolean";

    private static final String CHAR_CLASS = "java.lang.Character";

    private static final String STRING_CLASS = "java.lang.String";

    private static final String NULL_CLASS = "java.lang.NullObject";
	
    static String DEFAULT_METHOD_TYPE = "java.lang.Object";
    static String DEFAULT_LIST_CLASS = "java.util.LinkedList";
    static String DEFAULT_VAR_TYPE;// = "java.lang.Object";

    //short name to full name
    private final Map<String,String> fullNames = new HashMap<String, String>();
    private final List<String> importPaths = new LinkedList<String>();
    int varCounter = 0;
    ClassNode cls = new ClassNode();
    Stack<List<Statement>> codeStack = new Stack<List<Statement>>();
    List<ExprNode> arguments;
    MethodNode method;	
    private final Map<AstNode,ParseTree> a2p = new HashMap<AstNode, ParseTree>();
	
    private AstLoader astLoader;

    private final ParseTree context;

    private final CommonTokenStream tokens;
    
    private final String className;
	private String classPath;
	
	TypeSystem castSystem;
	private VarTable<String,VarDeclStmt> vtb;
	private List<VarObject> varCollector = new LinkedList();
	
    
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
	
    public void compile(AstLoader astLoader){
        this.astLoader = astLoader;
        this.castSystem = new TypeSystem(astLoader);
        visit(context);
    }
	
    public SourceParser(String className,String src){
        KalangLexer lexer = new KalangLexer(new ANTLRInputStream(src));
        tokens = new CommonTokenStream(lexer);
        KalangParser parser = new KalangParser(tokens);
        this.context = parser.compiliantUnit();
        this.className = className;
        this.classPath = "";
        if(className.contains(".")){
        	classPath = className.substring(0, className.lastIndexOf('.'));
        }
        cls = new ClassNode();
    }
	
    public void importPackage(String packageName){
        this.importPaths.add(packageName);
    }
	
    public Position getLocation(ParseTree tree){
        Position loc = new Position();
        Interval itv = tree.getSourceInterval();
        Token t = tokens.get(itv.a);
        Token tt = tokens.get(itv.b);
        loc.offset = t.getStartIndex();
        loc.length = tt.getStopIndex() - loc.offset + 1;
        return loc;
    }
	
    public Position getLocation(AstNode node){
        ParseTree tree = this.a2p.get(node);
        if(tree!=null){
        	return getLocation(tree);
        }
        return null;
    }
    
    private void startBlock(){
    	this.codeStack.add(new LinkedList<Statement>());
    }
    
    private List<Statement> endBlock(){
    	return this.codeStack.pop();
    }
    
    private BlockStmt endBlockAsStmt(){
    	return new BlockStmt(endBlock());
    }
    
    void newVarStack(){
		if(vtb!=null){
			vtb = new VarTable<String,VarDeclStmt>(vtb);
		}else{
			vtb = new VarTable<String,VarDeclStmt>();
		}
	}
	
	void popVarStack(){
		vtb = vtb.getParent();
	}
	
    public Map<AstNode,ParseTree> getParseTreeMap(){
        return this.a2p;
    }
	
    public ClassNode getAst(){
        return this.cls;
    }

    private void addCode(Statement node,ParseTree tree){
    	codeStack.peek().add(node);
        a2p.put(node, tree);
    }
    
    @Override
    public ExprNode visitMapExpr(KalangParser.MapExprContext ctx) {
        return visit(ctx.map());
    }

    @Override
    public ExprNode visitListOrArrayExpr(KalangParser.ListOrArrayExprContext ctx) {
        return visit(ctx.listOrArray());
    }

    @Override
    public ExprNode visitMap(KalangParser.MapContext ctx) {
        VarObject vo = new VarObject();
        VarDeclStmt vds = new VarDeclStmt(vo);
        vo.type = MAP_CLASS;
        vo.initExpr = new NewExpr(vo.type);
        addCode(vds,ctx);
        VarExpr ve = new VarExpr(vo);
        List ids = ctx.Identifier();
        for(int i=0;i<ids.size();i++){
            ExpressionContext e = ctx.expression(i);
            ExprNode v = visit(e);
            InvocationExpr iv = new InvocationExpr(ve,"put");
            ConstExpr k = new ConstExpr();
            k.type = STRING_CLASS;
            k.value = ctx.Identifier(i).getText();
            iv.arguments.add(k);
            iv.arguments.add(v);
            ExprStmt es = new ExprStmt(iv);
            addCode(es,ctx);
        }
        //TODO set generic type
        return ve;
    }

    @Override
    public ExprNode visitListOrArray(KalangParser.ListOrArrayContext ctx) {
        String clsName = DEFAULT_LIST_CLASS;
        VarObject vo = new VarObject();
        VarDeclStmt vds = new VarDeclStmt(vo);
        vo.type = clsName;
        vo.initExpr = new NewExpr(vo.type);
        addCode(vds,ctx);
        VarExpr ve = new VarExpr(vo);
        for(ExpressionContext e:ctx.expression()){
            InvocationExpr iv = new InvocationExpr(ve,"add");
            iv.arguments.add(visit(e));
            addCode(new ExprStmt(iv),ctx);
        }
        //TODO set generic type
        return ve;
    }

    @Override
    public ExprNode visitExprNewArray(KalangParser.ExprNewArrayContext ctx) {
        NewArrayExpr nae = new NewArrayExpr();
        nae.size = visit(ctx.expression());
        nae.type = ctx.noArrayType().getText();
        a2p.put(nae, ctx);
        return nae;
    }

    @Override
    public ExprNode visitNoArrayType(KalangParser.NoArrayTypeContext ctx) {
        //do nothing
        return null;
    }

    @Override
    public ExprNode visitExprQuestion(KalangParser.ExprQuestionContext ctx) {
        VarObject vo = new VarObject();
        VarDeclStmt vds = new VarDeclStmt(vo);
        addCode(vds,ctx);
        VarExpr ve = new VarExpr(vo);
        IfStmt is = new IfStmt();
        is.conditionExpr = visit(ctx.expression(0));
        is.trueBody =new ExprStmt(new AssignExpr(ve,visit(ctx.expression(1))));
        is.falseBody = new ExprStmt(new AssignExpr(ve,visit(ctx.expression(2))));
        addCode(is,ctx);
        a2p.put(ve, ctx);
        return ve;
    }

    @Override
    public ExprNode visitPostIfStmt(KalangParser.PostIfStmtContext ctx) {
        ExprNode leftExpr = visitExpression(ctx.expression(0));
        if(!(leftExpr instanceof AssignExpr)){
            this.reportError("AssignExpr required", ctx);
        }
        AssignExpr assignExpr = (AssignExpr) leftExpr;
        ExprNode to = assignExpr.to;
        ExprNode from = assignExpr.from;
        ExprNode cond = visitExpression(ctx.expression(1));
        Token op = ctx.op;
        if(op!=null){
            String opStr = op.getText();
            BinaryExpr be = new BinaryExpr(to,cond,opStr);
            cond = be;
        }
        AssignExpr as = new AssignExpr();
        as.from = from;as.to = to;
        IfStmt is = new IfStmt();
        is.conditionExpr = cond;
        is.trueBody = new ExprStmt(as);
        addCode(is,ctx);
        
        return null;
    }

    @Override
    public ExprNode visitCompiliantUnit(CompiliantUnitContext ctx) {
    	this.visitAll(ctx.importDecl());
        visitClassBody(ctx.classBody());
        cls.name= this.className;
        //cls.modifier=getModifier(ctx.BANG()!=null,ctx.QUESTION()!=null);
        cls.modifier = parseModifier(ctx.VarModifier());
        String classType = ctx.classType.getText();
        if(classType.equals("interface")) cls.isInterface = true;
        if(ctx.parentClass!=null) 
            cls.parentName=(ctx.parentClass.getText());
        if(ctx.interfaces!=null && ctx.interfaces.size()>0){
            for(Token itf:ctx.interfaces){
                cls.interfaces.add(itf.getText());
            }
        }
        return null;
    }

    @Override
    public ExprNode visitClassBody(ClassBodyContext ctx) {
        this.newVarStack();
        this.visitChildren(ctx);
        return null;
    }

    @Override
    public ExprNode visitFieldDecl(FieldDeclContext ctx) {
        visit(ctx.varDecls());
        int mdf = this.parseModifier(ctx.VarModifier());
        for(VarObject v:varCollector){
        	v.modifier = mdf;
        }
        cls.fields.addAll(varCollector);
        varCollector.clear();
        return null;
    }

    private int parseModifier(TerminalNode varModifier) {
		if(varModifier==null) return Modifier.PUBLIC;
		return parseModifier(varModifier.getText());
	}


    @Override
    public ExprNode visitMethodDecl(MethodDeclContext ctx) {
        this.newVarStack();
        String name;
        String type;
        if(ctx.prefix!=null && ctx.prefix.getText().equals("constructor")){
        	type = "void";
        	name = "<init>";
        }else{
        	if(ctx.type()==null){
        		type = "void";
        	}else{
        		type = ctx.type().getText();
        	}
        	name = ctx.name.getText();
        }
        int mdf = parseModifier(ctx.VarModifier());
        method = new MethodNode(mdf,type,name);
        if(ctx.varDecls()!=null) visit(ctx.varDecls());
        method.parameters.addAll(varCollector);
        varCollector.clear();
        if(ctx.statList()!=null){        	
        	startBlock();
        	visitStatList(ctx.statList());
        	method.body = new BlockStmt(endBlock());
        }
        if(ctx.exceptionTypes!=null){
        	for(Token et:ctx.exceptionTypes){
        		String eFullType = this.getFullClassName(et.getText());
        		method.exceptionTypes.add(eFullType);
        	}
        }
        this.popVarStack();
        cls.methods.add(method);
        return null;
    }

    @Override
    public ExprNode visitType(TypeContext ctx) {
        //do nothing
        return null;
    }
    
    public void visitAll(List<? extends ParseTree> list){
    	for(ParseTree i:list) visit(i);
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
        IfStmt ifStmt = new IfStmt();
        BlockStmt trueBody = new BlockStmt();
        BlockStmt falseBody = new BlockStmt();
        ifStmt.trueBody = trueBody;
        ifStmt.falseBody = falseBody;
        ExprNode expr = visitExpression(ctx.expression());
        ifStmt.conditionExpr = expr;
        startBlock();
        visitStatList(ctx.statList());
        trueBody.statements = endBlock();
        startBlock();
        visitIfStatSuffix(ctx.ifStatSuffix());
        falseBody.statements = endBlock();
        addCode(ifStmt,ctx);
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

    @Override
    public ExprNode visitReturnStat(ReturnStatContext ctx) {
        ExprNode expr = visitExpression(ctx.expression());
        ReturnStmt rs = new ReturnStmt();
        rs.expr = expr;
        
        addCode(rs,ctx);
        return null;
    }

    @Override
    public ExprNode visitVarDeclStat(VarDeclStatContext ctx) {
    	this.visitVarDecl(ctx.varDecl());
    	for(VarObject v:this.varCollector){
    		VarDeclStmt vds = new VarDeclStmt(v);
    		addCode(vds,ctx);
    		vtb.put(v.name,vds);
    	}
    	this.varCollector.clear();
        return null;
    }

    @Override
    public ExprNode visitVarDecl(VarDeclContext ctx) {
        String name = ctx.name.getText();
        String type = DEFAULT_VAR_TYPE;
        if(ctx.varType!=null){
            type = ctx.varType.getText();    
        }else if(ctx.type()!=null){
        	type = ctx.type().getText();
        }
        if(type!=null) type = checkFullType(type,ctx);
        ExprNode namedNode = this.getNodeByName(name);
        if(namedNode!=null){
        	String msg = null;
        	if(namedNode instanceof ClassExpr){
        		msg = "Can't use class name as variable name:" + name;
        	}else if(namedNode instanceof ParameterExpr){
        		msg = "Variable was definded in parameters:" + name;
        	}else if(namedNode instanceof VarExpr){
        		msg = "Variable was definded already:" + name;
        	}
        	if(msg!=null) reportError(msg,ctx);
        }
        VarObject vds = new VarObject();
        vds.name = name;
        vds.type = type;
        if(ctx.expression()!=null){
            vds.initExpr = visit(ctx.expression());
        }
        this.varCollector.add(vds);
        return null;
    }

    private void reportError(String string, ParseTree tree) {
        throw new ParseError(string,this.getLocation(tree));
    }

    @Override
    public ExprNode visitBreakStat(BreakStatContext ctx) {
        BreakStmt bs = new BreakStmt();
        
        addCode(bs,ctx);
        return null;
    }

    @Override
    public ExprNode visitContinueStat(ContinueStatContext ctx) {
        ContinueStmt cs = new ContinueStmt();
        
        addCode(cs,ctx);
        return null;
    }

    @Override
    public ExprNode visitWhileStat(WhileStatContext ctx) {
        //WhileStmt ws = new WhileStmt();
        LoopStmt ws = new LoopStmt();
        BlockStmt body = new BlockStmt();
        ws.loopBody = body;
        AstNode expr = visitExpression(ctx.expression());
        ws.preConditionExpr = (ExprNode) expr;
        startBlock();
        visitStatList(ctx.statList());
        body.statements = endBlock();        
        addCode(ws,ctx);
        return null;
    }

    @Override
    public ExprNode visitDoWhileStat(DoWhileStatContext ctx) {
        BlockStmt bs = new BlockStmt();
        startBlock();
        visit(ctx.statList());
        bs.statements = endBlock();
        ExprNode cond = visit(ctx.expression());
        LoopStmt ls =new LoopStmt();
        ls.loopBody  = bs;
        ls.postConditionExpr = cond;
        addCode(ls,ctx);
        return null;
    }

    @Override
    public ExprNode visitForStat(ForStatContext ctx) {
        this.newVarStack();
        LoopStmt ls = new LoopStmt();
        visit(ctx.varDecls());
        for(VarObject v:this.varCollector){
        	VarDeclStmt vds = new VarDeclStmt(v);
        	ls.initStmts.add(vds);
        	vtb.put(v.name, vds);
        }
        this.varCollector.clear();
        AstNode texpr = visitExpression(ctx.expression());
        ls.preConditionExpr = (ExprNode) texpr;
        startBlock();
        visitStatList(ctx.statList());
        visit(ctx.expressions());
        ls.loopBody = endBlockAsStmt();
        this.popVarStack();
        addCode(ls,ctx);
        return null;
    }

    @Override
    public ExprNode visitExpressions(ExpressionsContext ctx) {
        for(ExpressionContext e:ctx.expression()){
            ExprNode expr = visitExpression(e);
            addCode(new ExprStmt(expr),ctx);
        }
        return null;
    }

    @Override
    public ExprNode visitExprStat(ExprStatContext ctx) {
        AstNode expr = visitExpression(ctx.expression());
        ExprStmt es = new ExprStmt();
        es.expr = (ExprNode) expr;
        
        addCode(es,ctx);
        return null;
    }

    @Override
    public InvocationExpr visitExprMemberInvocation(ExprMemberInvocationContext ctx) {
        InvocationExpr ie = this.getInvocationExpr(
            null
            , ctx.Identifier().getText()
            ,ctx.arguments());
        a2p.put(ie, ctx);
        return ie;
    }

    @Override
    public AssignExpr visitExprAssign(ExprAssignContext ctx) {
        String assignOp = ctx.getChild(1).getText();
        ExprNode to = visitExpression(ctx.expression(0));
        ExprNode from  = visitExpression(ctx.expression(1));
        if(assignOp.length()>1){
            String op = assignOp.substring(0,assignOp.length()-1);
            from = new BinaryExpr(to,from,op);
        }       
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
        arguments = is.arguments;
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
	
    private String checkFullType(String name,ParseTree tree){
    	if(this.castSystem.isPrimitiveType(name)) return name;
        String fn = getFullClassName(name);
        if(fn==null){
            this.reportError("Unknown class:"+name,tree);
        }
        return fn;
    }
	
    private String getFullClassName(String name){
    	String postfix = "";
    	if(name.endsWith("[]")){
    		name = name.substring(0, name.length()-2);
    		postfix = "[]";
    	}
        if(fullNames.containsKey(name)){
            return fullNames.get(name) + postfix;
        }else{
            for(String p:this.importPaths){
                String clsName = p + "." + name;
                ClassNode cls = astLoader.getAst(clsName);
                if(cls!=null){
                    return clsName + postfix;
                }
            }
        }
        return null;
    }

    private ExprNode getNodeByName(String name) {
        if(vtb.exist(name)){
            VarExpr ve = new VarExpr();
            VarDeclStmt declStmt = (VarDeclStmt) vtb.get(name); //vars.indexOf(vo);
            ve.var = declStmt.var;
            return ve;
        }else{
            //find parameters
            if(method!=null && method.parameters!=null){
                for(VarObject p:method.parameters){
                    if(p.name.equals(name)) return new VarExpr(p);
                }
            }
            if(cls.fields!=null){
                for(VarObject f:cls.fields){
                    if(f.name.equals(name)){
                        FieldExpr fe = new FieldExpr();
                        fe.fieldName = name;
                        return fe;
                    }
                }
            }
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
        if(ctx.IntegerLiteral()!=null){
            ce.type = INT_CLASS;
            ce.value = Integer.parseInt(t);
        }else if(ctx.FloatingPointLiteral()!=null){
            ce.type = FLOAT_CLASS;
            ce.value = Float.parseFloat(t);
        }else if(ctx.BooleanLiteral()!=null){
            ce.type = BOOLEAN_CLASS;
            ce.value = Boolean.parseBoolean(t);
        }else if(ctx.CharacterLiteral()!=null){
            ce.type = CHAR_CLASS;
            char[] chars = t.toCharArray();
            ce.value = chars[1];
        }else if(ctx.StringLiteral()!=null){
            ce.type = STRING_CLASS;
            //TODO parse string
            ce.value = t.substring(1,t.length()-1);
        }else{
            ce.type = NULL_CLASS;
        }
        
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

    @Override
    public ExprNode visitImportDecl(ImportDeclContext ctx) {
        String name = ctx.name.getText();
        String prefix = "";
        boolean relative = ctx.root==null || ctx.root.getText().length()==0;
        if(relative && this.classPath.length()>0){
        	prefix = this.classPath + ".";
        }
        if(ctx.path!=null)
        	for(Token p:ctx.path) prefix += p.getText()+".";
        if(name.equals("*")){
        	this.importPaths.add(prefix.substring(0,prefix.length()-1));
        }else{
        	String key = name;
        	if(ctx.alias!=null) key = ctx.alias.getText();
        	this.fullNames.put(key, prefix + name);
        }
        return null;
    }

    @Override
    public ExprNode visitQualifiedName(QualifiedNameContext ctx) {
        //do nothing
        return null;
    }
    
    public int parseModifier(String modifier){
    	String[] mdfs = modifier.split(" ");
    	int m = 0;
    	int access = 0;
    	for(String s:mdfs){
    		if(s=="public"){
    			access = Modifier.PUBLIC;
    		}else if (s=="protected"){
    			access = Modifier.PROTECTED;
    		}else if(s=="private"){
    			access = Modifier.PRIVATE;
    		}else if(s=="static"){
    			m+= Modifier.STATIC;
    		}else if(s=="final"){
    			m+= Modifier.FINAL;
    		}
    	}
    	if(access==0) access = Modifier.PUBLIC;
    	return m + access;
    }

    public Integer getModifier(boolean isPrivated,boolean isProtected) {
        if(isPrivated) return Modifier.PRIVATE;
        if(isProtected) return Modifier.PROTECTED;
        return Modifier.PUBLIC;
    }

    @Override
    public ExprNode visitNewExpr(NewExprContext ctx) {
    	String type =  ctx.Identifier().getText();
    	ClassExpr expr = new ClassExpr();
    	expr.name = checkFullType(type,ctx);        
    	return this.getInvocationExpr(expr, "<init>",ctx.arguments());
    }

    @Override
    public ExprNode visitCastExpr(CastExprContext ctx) {
        CastExpr ce = new CastExpr();
        ce.expr = visitExpression(ctx.expression());
        ce.type = ctx.type().getText();
        
        return ce;
    }

	@Override
	public ExprNode visitTryStat(TryStatContext ctx) {
		TryStmt tryStmt = new TryStmt();
		startBlock();
		visit(ctx.tryStmtList);
		tryStmt.execStmt = endBlockAsStmt();
		if(ctx.catchTypes!=null){
			for(int i=0;i<ctx.catchTypes.size();i++){
				startBlock();
				String vName = ctx.catchVarNames.get(i).getText();
				String vType = ctx.catchTypes.get(i).getText();
				this.newVarStack();
				VarObject vo = new VarObject();
				vo.name = vName;
				vo.type = vType;
				VarDeclStmt declStmt = new VarDeclStmt(vo);
				visit(ctx.catchStmts.get(i));
				this.popVarStack();
				CatchStmt catchStmt = new CatchStmt();
				catchStmt.catchVarDecl = declStmt;
				catchStmt.execStmt =  endBlockAsStmt();
				tryStmt.catchStmts.add(catchStmt);
			}
		}
		if(ctx.finalStmtList!=null){
			this.newVarStack();
			BlockStmt finalBody = new BlockStmt();
			startBlock();
			visit(ctx.finalStmtList);
			this.popVarStack();
			finalBody.statements = endBlock();
			tryStmt.finallyStmt = finalBody;
		}
		this.addCode(tryStmt, ctx);
		return null;
	}

	@Override
	public ExprNode visitVarDecls(VarDeclsContext ctx) {
		for(VarDeclContext v:ctx.varDecl()) visit(v);
		return null;
	}

	@Override
	public ExprNode visitExprIdentifier(ExprIdentifierContext ctx) {
		String name = ctx.Identifier().getText();
		ExprNode expr = this.getNodeByName(name);
		if(expr==null){
			this.reportError(name + " is undefined!", ctx);
		}
		return expr;
	}

	@Override
	public ExprNode visitExprLiteral(ExprLiteralContext ctx) {
		return visit(ctx.literal());
	}

	@Override
	public ExprNode visitExprParen(ExprParenContext ctx) {
		return visit(ctx.expression());
	}

	@Override
	public ExprNode visitExprThis(ExprThisContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
