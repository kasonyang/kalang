import java.util.LinkedList;
import java.util.List;

import kalang.antlr.KalangParser.ArgumentDeclContext;
import kalang.antlr.KalangParser.ArgumentDeclListContext;
import kalang.antlr.KalangParser.ArgumentsContext;
import kalang.antlr.KalangParser.BreakStatContext;
import kalang.antlr.KalangParser.ClassBodyContext;
import kalang.antlr.KalangParser.CompiliantUnitContext;
import kalang.antlr.KalangParser.ContinueStatContext;
import kalang.antlr.KalangParser.DoWhileStatContext;
import kalang.antlr.KalangParser.ExprAssignContext;
import kalang.antlr.KalangParser.ExprGetArrayElementContext;
import kalang.antlr.KalangParser.ExprGetFieldContext;
import kalang.antlr.KalangParser.ExprInvocationContext;
import kalang.antlr.KalangParser.ExprLogicCmpContext;
import kalang.antlr.KalangParser.ExprLogicContext;
import kalang.antlr.KalangParser.ExprMemberInvocationContext;
import kalang.antlr.KalangParser.ExprMidOpContext;
import kalang.antlr.KalangParser.ExprNotOpContext;
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
import kalang.antlr.KalangParser.LiteralContext;
import kalang.antlr.KalangParser.MethodDeclContext;
import kalang.antlr.KalangParser.MethodDeclListContext;
import kalang.antlr.KalangParser.PrimaryIdentifierContext;
import kalang.antlr.KalangParser.PrimaryLiteralContext;
import kalang.antlr.KalangParser.PrimayParenContext;
import kalang.antlr.KalangParser.ReturnStatContext;
import kalang.antlr.KalangParser.SetterContext;
import kalang.antlr.KalangParser.StartContext;
import kalang.antlr.KalangParser.StatContext;
import kalang.antlr.KalangParser.StatListContext;
import kalang.antlr.KalangParser.TypeContext;
import kalang.antlr.KalangParser.VarDeclContext;
import kalang.antlr.KalangParser.VarDeclStatContext;
import kalang.antlr.KalangParser.VarInitContext;
import kalang.antlr.KalangParser.WhileStatContext;
import kalang.antlr.KalangVisitor;
import jast.ast.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;


public class KalangTranslator extends AbstractParseTreeVisitor<Object> implements KalangVisitor<Object> {

	
	private VarDeclStmt doVisitVarDeclAndInit(VarDeclContext vd,VarInitContext vi){
		VarDeclStmt vds = this.visitVarDecl(vd);
		if(vi!=null){
			AstNode val = visitVarInit(vi);
			vds.initExpr = (ExprNode) (val);
		}
		return vds;
	}
	
	@Override
	public ClassNode visitStart(StartContext ctx) {
		return visitCompiliantUnit(ctx.compiliantUnit());
	}

	@Override
	public ClassNode visitCompiliantUnit(CompiliantUnitContext ctx) {
		ClassNode cls = visitClassBody(ctx.classBody());
		
		cls.name=(ctx.Identifier(0).getText());
		String modifier = "public";
		if(ctx.Modifier()!=null){
			modifier = ctx.Modifier().getText();
		}
		cls.modifier=(modifier);
		if(ctx.Identifier().size()>1){
			cls.parentName=(ctx.Identifier(1).getText());
		}
		return cls;
	}

	@Override
	public ClassNode visitClassBody(ClassBodyContext ctx) {
		ClassNode cls = new ClassNode();
		cls.fields = this.visitFieldDeclList(ctx.fieldDeclList());
		cls.methods = this.visitMethodDeclList(ctx.methodDeclList());
		return cls;
	}

	@Override
	public List visitFieldDeclList(FieldDeclListContext ctx) {
		List list = new LinkedList();
		for(FieldDeclContext fd:ctx.fieldDecl()){
			list.add(this.visitFieldDecl(fd));
		}
		return list;
	}

	@Override
	public FieldNode visitFieldDecl(FieldDeclContext ctx) {
		String type = ctx.type()==null?"Object":ctx.type().getText();
		FieldNode fo = new FieldNode();
		fo.name=(ctx.Identifier().getText());
		fo.type=(type);
		if(ctx.varInit()!=null){
			fo.initExpr =  (visitVarInit(ctx.varInit()));
		}
		String modifier = "public";
		if(ctx.Modifier()!=null){
			modifier = (ctx.Modifier().getText());
		}
		fo.modifier =(modifier);
		//TODO visit setter and getter
		return fo;
	}

	@Override
	public AstNode visitSetter(SetterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AstNode visitGetter(GetterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List visitMethodDeclList(MethodDeclListContext ctx) {
		LinkedList list = new LinkedList();
		for(MethodDeclContext md:ctx.methodDecl()){
			list.add(visitMethodDecl(md));
		}
		return list;
	}

	@Override
	public MethodNode visitMethodDecl(MethodDeclContext ctx) {
		String name = ctx.Identifier().getText();
		String type = ctx.type()==null ? "Object" :ctx.type().getText();
		String mdf = "public";
		if(ctx.Modifier()!=null){
			mdf = ctx.Modifier().getText();
		}
		boolean isStatic = false;
		if(ctx.STATIC()!=null){
			isStatic = true;
		}
		MethodNode method = new MethodNode(mdf,type,name,isStatic);
		BlockStmt body = new BlockStmt();
		method.body = body;
		if(ctx.argumentDeclList()!=null){
			method.parameters = visitArgumentDeclList(ctx.argumentDeclList());
		}
		body.statements = visitStatList(ctx.statList());
		return method;
	}

	@Override
	public AstNode visitType(TypeContext ctx) {
		//do nothing
		return null;
	}

	@Override
	public List visitArgumentDeclList(ArgumentDeclListContext ctx) {
		List list = new LinkedList();
		for(ArgumentDeclContext ad:ctx.argumentDecl()){
			list.add(visitArgumentDecl(ad));
		}
		return list;
	}

	@Override
	public ParameterNode visitArgumentDecl(ArgumentDeclContext ctx) {
		String name = ctx.Identifier().getText();
		String type = "Object";
		if(ctx.type()!=null){
			type = ctx.type().getText();
		}
		ParameterNode ao = new ParameterNode();
		ao.type = type;
		ao.name = name;
		return ao;
	}

	@Override
	public List visitStatList(StatListContext ctx) {
		List list = new LinkedList();
		for(StatContext s:ctx.stat()){
			list.add(visitStat(s));
		}
		return list;
	}

	
	@Override
	public AstNode visitIfStat(IfStatContext ctx) {
		IfStmt ifStmt = new IfStmt();
		BlockStmt trueBody = new BlockStmt();
		BlockStmt falseBody = new BlockStmt();
		ifStmt.trueBody = trueBody;
		ifStmt.falseBody = falseBody;
		ExprNode expr = visitExpression(ctx.expression());
		ifStmt.conditionExpr = expr;
		trueBody.statements = visitStatList(ctx.statList());
		falseBody.statements = visitIfStatSuffix(ctx.ifStatSuffix());
		return ifStmt;
	}

	private ExprNode visitExpression(ExpressionContext expression) {
		return (ExprNode) visit(expression);
	}

	@Override
	public List visitIfStatSuffix(IfStatSuffixContext ctx) {
		LinkedList list = new LinkedList();
		list.add(visitStatList(ctx.statList()));
		return list;
	}

	@Override
	public Statement visitStat(StatContext ctx) {
		return (Statement) visit(ctx.getChild(0));
	}

	private void visitAll(ParserRuleContext ctx) {
		for(ParseTree c:ctx.children){
			visit(c);
		}
	}

	@Override
	public ReturnStmt visitReturnStat(ReturnStatContext ctx) {
		ExprNode expr = visitExpression(ctx.expression());
		ReturnStmt rs = new ReturnStmt();
		rs.expr = expr;
		return rs;
	}

	@Override
	public AstNode visitVarDeclStat(VarDeclStatContext ctx) {
		return this.doVisitVarDeclAndInit(ctx.varDecl(), ctx.varInit());		
	}

	@Override
	public VarDeclStmt visitVarDecl(VarDeclContext ctx) {
		String name = ctx.Identifier().getText();
		String type = "Object";
		if(ctx.type()!=null){
			type = ctx.type().getText();
		}
		boolean isReadOnly = ctx.getChild(0).getText() == "val";
		//TODO readonly
		NameExpr ve = new NameExpr();
		ve.name = name;
		VarDeclStmt vds = new VarDeclStmt();
		vds.varName = name;
		vds.type = type;
		return vds;
	}

	@Override
	public ExprNode visitVarInit(VarInitContext ctx) {
		ExprNode vo = visitExpression(ctx.expression());
		return vo;
	}

	@Override
	public AstNode visitBreakStat(BreakStatContext ctx) {
		BreakStmt bs = new BreakStmt();
		return bs;
	}

	@Override
	public AstNode visitContinueStat(ContinueStatContext ctx) {
		ContinueStmt cs = new ContinueStmt();
		return cs;
	}

	@Override
	public AstNode visitWhileStat(WhileStatContext ctx) {
		WhileStmt ws = new WhileStmt();
		BlockStmt body = new BlockStmt();
		ws.body = body;
		AstNode expr = visitExpression(ctx.expression());
		ws.conditionExpr = (ExprNode) expr;
		body.statements = visitStatList(ctx.statList());
		return null;
	}

	@Override
	public AstNode visitDoWhileStat(DoWhileStatContext ctx) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoopStmt visitForStat(ForStatContext ctx) {
		LoopStmt ls = new LoopStmt();
		BlockStmt body = new BlockStmt();
		ls.loopBody = body;
		ls.initStmts = visitForInit(ctx.forInit());
		AstNode texpr = visitExpression(ctx.expression());
		ls.preConditionExpr = (ExprNode) texpr;
		body.statements = visitStatList(ctx.statList());
		body.statements.addAll(visitForUpdate(ctx.forUpdate()));
		return ls;
	}

	@Override
	public List visitForInit(ForInitContext ctx) {
		List list = new LinkedList();
		VarDeclStmt vs = this.doVisitVarDeclAndInit(ctx.varDecl(), ctx.varInit());
		list.add(vs);
		return list;
	}

	@Override
	public List visitForUpdate(ForUpdateContext ctx) {
		return visitExpressions(ctx.expressions());
	}

	@Override
	public List visitExpressions(ExpressionsContext ctx) {
		List list = new LinkedList();
		for(ExpressionContext e:ctx.expression()){
			AstNode expr = visitExpression(e);
			list.add(new ExprStmt((ExprNode) expr));
		}
		return list;
	}

	@Override
	public ExprStmt visitExprStat(ExprStatContext ctx) {
		AstNode expr = visitExpression(ctx.expression());
		ExprStmt es = new ExprStmt();
		es.expr = (ExprNode) expr;
		return es;
	}

	@Override
	public AstNode visitExprPrimay(ExprPrimayContext ctx) {
		return (AstNode) visit(ctx.primary());
	}

	@Override
	public AstNode visitExprMemberInvocation(ExprMemberInvocationContext ctx) {
		NameExpr expr = new NameExpr();
		expr.name = "this";
		return this.getInvocationExpr(
				expr
				, ctx.Identifier().getText()
				,ctx.arguments());
	}

	@Override
	public AstNode visitExprAssign(ExprAssignContext ctx) {
		AstNode to = visitExpression(ctx.expression(0));
		AstNode from = visitExpression(ctx.expression(1));
		AssignExpr aexpr = new AssignExpr();
		aexpr.from = (ExprNode) from;
		aexpr.to = (ExprNode) to;
		return aexpr;
	}

	@Override
	public AstNode visitExprMidOp(ExprMidOpContext ctx) {
		String op = ctx.getChild(1).getText();
		BinaryExpr be = new BinaryExpr();
		be.expr1 = (ExprNode) visitExpression(ctx.expression(0));
		be.expr2 = (ExprNode) visitExpression(ctx.expression(1));
		be.operation = op;
		return be;
	}
	
	private AstNode getInvocationExpr(AstNode expr,String methodName,ArgumentsContext arguments){
		InvocationExpr is = new InvocationExpr();
		is.methodName =methodName;
		is.target = (ExprNode) expr;
		is.arguments = visitArguments(arguments);
		return is;
	}

	@Override
	public AstNode visitExprInvocation(ExprInvocationContext ctx) {
		return this.getInvocationExpr(
				visitExpression(ctx.expression())
				, ctx.Identifier().getText()
				, ctx.arguments());
	}

	@Override
	public AstNode visitExprNotOp(ExprNotOpContext ctx) {
		UnaryExpr ue = new UnaryExpr();
		ue.expr = (ExprNode) visitExpression(ctx.expression());
		ue.preOperation = ctx.getChild(0).getText();
		return ue;
	}

	@Override
	public AstNode visitExprGetField(ExprGetFieldContext ctx) {
		AstNode expr = visitExpression(ctx.expression());
		String name = ctx.Identifier().getText();
		FieldExpr fe = new FieldExpr();
		fe.target = (ExprNode) expr;
		fe.fieldName = name;
		return fe;
	}

	@Override
	public AstNode visitExprLogicCmp(ExprLogicCmpContext ctx) {
		BinaryExpr be = new BinaryExpr();
		be.expr1 = (ExprNode) visitExpression(ctx.expression(0));
		be.expr2 = (ExprNode) visitExpression(ctx.expression(1));
		be.operation = ctx.getChild(1).getText();
		return be;
	}

	@Override
	public AstNode visitExprSelfOp(ExprSelfOpContext ctx) {
		UnaryExpr ue = new UnaryExpr();
		ue.postOperation = ctx.getChild(1).getText();
		ue.expr = (ExprNode) visitExpression(ctx.expression());
		return ue;
	}

	@Override
	public AstNode visitExprLogic(ExprLogicContext ctx) {
		BinaryExpr be = new BinaryExpr();
		be.expr1 = (ExprNode) visitExpression(ctx.expression(0));
		be.expr2 = (ExprNode) visitExpression(ctx.expression(1));
		be.operation = ctx.getChild(1).getText();
		return be;
	}

	@Override
	public UnaryExpr visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
		String op = ctx.getChild(0).getText();
		UnaryExpr ue = new UnaryExpr();
		ue.expr = (ExprNode) visitExpression(ctx.expression());
		ue.preOperation = op;
		return ue;
	}

	@Override
	public ElementExpr visitExprGetArrayElement(ExprGetArrayElementContext ctx) {
		ElementExpr ee = new ElementExpr();
		ee.target = (ExprNode) visitExpression(ctx.expression(0));
		ee.key = (ExprNode) visitExpression(ctx.expression(1));
		return ee;
	}

	@Override
	public ExprNode visitPrimayParen(PrimayParenContext ctx) {
		return visitExpression(ctx.expression());
	}

	@Override
	public ConstExpr visitPrimaryLiteral(PrimaryLiteralContext ctx) {
		return new ConstExpr(ctx.literal().getText());
	}

	@Override
	public AstNode visitPrimaryIdentifier(PrimaryIdentifierContext ctx) {
		NameExpr ve = new NameExpr();
		String name = ctx.Identifier().getText();
		ve.name = name;
		return ve;
	}

	@Override
	public AstNode visitLiteral(LiteralContext ctx) {
		//do nothing
		return null;
	}

	@Override
	public List<ExprNode> visitArguments(ArgumentsContext ctx) {
		LinkedList<ExprNode> list = new LinkedList();
		for(ExpressionContext e:ctx.expression()){
			ExprNode expr = visitExpression(e);
			list.add(expr);
		}
		return list;
	}

}
