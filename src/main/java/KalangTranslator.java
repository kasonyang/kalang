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
/*
import kalang.core.ParameterNode;
import kalang.core.ClassNode;
import kalang.core.FieldNode;
import kalang.core.MethodNode;
*/
//import kalang.core.Modifier;
//import kalang.core.VarObject;
//import kalang.core.VarTable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;


public class KalangTranslator extends AbstractParseTreeVisitor<AstNode> implements KalangVisitor<AstNode> {

	List<Statement> codes = new LinkedList();
	
	ClassNode cls = null;
	
	MethodNode method = null;
	
	InvocationExpr invocating;
	
	public ClassNode getClassObject(){
		return cls;
	}
	
	private void doVisitVarDeclAndInit(VarDeclContext vd,VarInitContext vi){
		VarDeclStmt vds = this.visitVarDecl(vd);
		if(vi!=null){
			AstNode val = visit(vi);
			vds.initExpr = (ExprNode) (val);
		}
	}
	
	@Override
	public AstNode visitStart(StartContext ctx) {
		visit(ctx.compiliantUnit());
		return null;
	}

	@Override
	public AstNode visitCompiliantUnit(CompiliantUnitContext ctx) {
		cls = new ClassNode();
		cls.fields = new LinkedList();
		cls.methods = new LinkedList();
		cls.name=(ctx.Identifier(0).getText());
		String modifier = "public";
		if(ctx.Modifier()!=null){
			modifier = ctx.Modifier().getText();
		}
		cls.modifier=(modifier);
		if(ctx.Identifier().size()>1){
			cls.parentName=(ctx.Identifier(1).getText());
		}
		visitClassBody(ctx.classBody());
		return null;
	}

	@Override
	public AstNode visitClassBody(ClassBodyContext ctx) {
		this.visitFieldDeclList(ctx.fieldDeclList());
		this.visitMethodDeclList(ctx.methodDeclList());
		return null;
	}

	@Override
	public AstNode visitFieldDeclList(FieldDeclListContext ctx) {
		for(FieldDeclContext fd:ctx.fieldDecl()){
			this.visitFieldDecl(fd);
		}
		return null;
	}

	@Override
	public AstNode visitFieldDecl(FieldDeclContext ctx) {
		String type = ctx.type()==null?"Object":ctx.type().getText();
		FieldNode fo = new FieldNode();
		fo.name=(ctx.Identifier().getText());
		fo.type=(type);
		if(ctx.varInit()!=null){
			fo.initExpr = (ExprNode) (visit(ctx.varInit()));
		}
		String modifier = "public";
		if(ctx.Modifier()!=null){
			modifier = (ctx.Modifier().getText());
		}
		fo.modifier =(modifier);
		cls.fields.add(fo);
		//TODO visit setter and getter
		return null;
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
	public AstNode visitMethodDeclList(MethodDeclListContext ctx) {
		for(MethodDeclContext md:ctx.methodDecl()){
			visit(md);
		}
		return null;
	}

	@Override
	public AstNode visitMethodDecl(MethodDeclContext ctx) {
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
		this.method = new MethodNode(mdf,type,name,isStatic);
		BlockStmt body = new BlockStmt();
		method.body = body;
		method.parameters = new LinkedList();
		this.codes = body.statements;
		if(ctx.argumentDeclList()!=null){
			visit(ctx.argumentDeclList());
		}
		visit(ctx.statList());
		this.cls.methods.add(method);
		method = null;
		codes=null;
		return null;
	}

	@Override
	public AstNode visitType(TypeContext ctx) {
		//do nothing
		return null;
	}

	@Override
	public AstNode visitArgumentDeclList(ArgumentDeclListContext ctx) {
		for(ArgumentDeclContext ad:ctx.argumentDecl()){
			visit(ad);
		}
		return null;
	}

	@Override
	public AstNode visitArgumentDecl(ArgumentDeclContext ctx) {
		String name = ctx.Identifier().getText();
		String type = "Object";
		if(ctx.type()!=null){
			type = ctx.type().getText();
		}
		ParameterNode ao = new ParameterNode();
		ao.type = type;
		ao.name = name;
		this.method.parameters.add(ao);
		return null;
	}

	@Override
	public AstNode visitStatList(StatListContext ctx) {
		for(StatContext s:ctx.stat()){
			visit(s);
		}
		return null;
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
		List<Statement> oldCodes = codes;
		codes = trueBody.statements;
		visit(ctx.statList());
		codes = falseBody.statements;
		visit(ctx.ifStatSuffix());
		codes = oldCodes;
		return null;
	}

	private ExprNode visitExpression(ExpressionContext expression) {
		return (ExprNode) visit(expression);
	}

	@Override
	public AstNode visitIfStatSuffix(IfStatSuffixContext ctx) {
		visit(ctx.statList());
		return null;
	}

	@Override
	public AstNode visitStat(StatContext ctx) {
		visitAll(ctx);
		return null;
	}

	private void visitAll(ParserRuleContext ctx) {
		for(ParseTree c:ctx.children){
			visit(c);
		}
	}

	@Override
	public AstNode visitReturnStat(ReturnStatContext ctx) {
		ExprNode expr = visitExpression(ctx.expression());
		ReturnStmt rs = new ReturnStmt();
		rs.expr = expr;
		codes.add(rs);
		return null;
	}

	@Override
	public AstNode visitVarDeclStat(VarDeclStatContext ctx) {
		this.doVisitVarDeclAndInit(ctx.varDecl(), ctx.varInit());		
		return null;
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
		codes.add(vds);
		return vds;
	}

	@Override
	public AstNode visitVarInit(VarInitContext ctx) {
		AstNode vo = visit(ctx.expression());
		return vo;
	}

	@Override
	public AstNode visitBreakStat(BreakStatContext ctx) {
		BreakStmt bs = new BreakStmt();
		codes.add(bs);
		return null;
	}

	@Override
	public AstNode visitContinueStat(ContinueStatContext ctx) {
		ContinueStmt cs = new ContinueStmt();
		codes.add(cs);
		return null;
	}

	@Override
	public AstNode visitWhileStat(WhileStatContext ctx) {
		WhileStmt ws = new WhileStmt();
		BlockStmt body = new BlockStmt();
		ws.body = body;
		AstNode expr = visit(ctx.expression());
		ws.conditionExpr = (ExprNode) expr;
		this.codes = body.statements;
		visit(ctx.statList());
		return null;
	}

	@Override
	public AstNode visitDoWhileStat(DoWhileStatContext ctx) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AstNode visitForStat(ForStatContext ctx) {
		LoopStmt ls = new LoopStmt();
		BlockStmt body = new BlockStmt();
		ls.loopBody = body;
		//VarTable oVtb = this.vtb;
		//VarTable forVtb = new VarTable(oVtb);
		//vtb = ls.varTable;
		List<Statement> oCodes = codes;
		codes = ls.initStmts;
		visitForInit(ctx.forInit());
		AstNode texpr = visit(ctx.expression());
		ls.preConditionExpr = (ExprNode) texpr;
		//List<Statement> oCodes = this.codes;
		codes = body.statements;
		visit(ctx.statList());
		visit(ctx.forUpdate());
		codes = oCodes;
		//vtb = oVtb;
		codes.add(ls);
		return null;
	}

	@Override
	public AstNode visitForInit(ForInitContext ctx) {
		this.doVisitVarDeclAndInit(ctx.varDecl(), ctx.varInit());
		//visitAll(ctx);
		return null;
	}

	@Override
	public AstNode visitForUpdate(ForUpdateContext ctx) {
		visitAll(ctx);
		return null;
	}

	@Override
	public AstNode visitExpressions(ExpressionsContext ctx) {
		for(ExpressionContext e:ctx.expression()){
			AstNode expr = visit(e);
			codes.add(new ExprStmt((ExprNode) expr));
		}
		return null;
	}

	@Override
	public AstNode visitExprStat(ExprStatContext ctx) {
		AstNode expr = visit(ctx.expression());
		ExprStmt es = new ExprStmt();
		es.expr = (ExprNode) expr;
		codes.add(es);
		return null;
	}

	@Override
	public AstNode visitExprPrimay(ExprPrimayContext ctx) {
		return visit(ctx.primary());
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
		//String varName = ctx.Identifier().getText();
		//VarObject vo = this.ensureVar(varName);
		AstNode to = visit(ctx.expression(0));
		AstNode from = visit(ctx.expression(1));
		//NameExpr ve = new NameExpr();
		//ve.type = vo.getType();
		//ve.varName = vo.getName();
		AssignExpr aexpr = new AssignExpr();
		aexpr.from = (ExprNode) from;
		aexpr.to = (ExprNode) to;
		return aexpr;
	}

	@Override
	public AstNode visitExprMidOp(ExprMidOpContext ctx) {
		String op = ctx.getChild(1).getText();
		BinaryExpr be = new BinaryExpr();
		be.expr1 = (ExprNode) visit(ctx.expression(0));
		be.expr2 = (ExprNode) visit(ctx.expression(1));
		be.operation = op;
		return be;
	}
	
	private AstNode getInvocationExpr(AstNode expr,String methodName,ArgumentsContext arguments){
		InvocationExpr is = new InvocationExpr();
		is.arguments = new LinkedList();
		InvocationExpr oldInv = this.invocating;
		is.methodName =methodName;
		is.target = (ExprNode) expr;
		this.invocating = is;
		visit(arguments);
		this.invocating = oldInv;
		return is;
	}

	@Override
	public AstNode visitExprInvocation(ExprInvocationContext ctx) {
		return this.getInvocationExpr(
				visit(ctx.expression())
				, ctx.Identifier().getText()
				, ctx.arguments());
	}

	@Override
	public AstNode visitExprNotOp(ExprNotOpContext ctx) {
		UnaryExpr ue = new UnaryExpr();
		ue.expr = (ExprNode) visit(ctx.expression());
		ue.preOperation = ctx.getChild(0).getText();
		return ue;
	}

	@Override
	public AstNode visitExprGetField(ExprGetFieldContext ctx) {
		AstNode expr = visit(ctx.expression());
		String name = ctx.Identifier().getText();
		FieldExpr fe = new FieldExpr();
		fe.target = (ExprNode) expr;
		fe.fieldName = name;
		return fe;
	}

	@Override
	public AstNode visitExprLogicCmp(ExprLogicCmpContext ctx) {
		BinaryExpr be = new BinaryExpr();
		be.expr1 = (ExprNode) visit(ctx.expression(0));
		be.expr2 = (ExprNode) visit(ctx.expression(1));
		be.operation = ctx.getChild(1).getText();
		return be;
	}

	@Override
	public AstNode visitExprSelfOp(ExprSelfOpContext ctx) {
		UnaryExpr ue = new UnaryExpr();
		ue.postOperation = ctx.getChild(1).getText();
		ue.expr = (ExprNode) visit(ctx.expression());
		return ue;
	}

	@Override
	public AstNode visitExprLogic(ExprLogicContext ctx) {
		BinaryExpr be = new BinaryExpr();
		be.expr1 = (ExprNode) visit(ctx.expression(0));
		be.expr2 = (ExprNode) visit(ctx.expression(1));
		be.operation = ctx.getChild(1).getText();
		return be;
	}

	@Override
	public AstNode visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
		String op = ctx.getChild(0).getText();
		UnaryExpr ue = new UnaryExpr();
		ue.expr = (ExprNode) visit(ctx.expression());
		ue.preOperation = op;
		return ue;
	}

	@Override
	public AstNode visitExprGetArrayElement(ExprGetArrayElementContext ctx) {
		ElementExpr ee = new ElementExpr();
		ee.target = (ExprNode) visit(ctx.expression(0));
		ee.key = (ExprNode) visit(ctx.expression(1));
		return ee;
	}

	@Override
	public AstNode visitPrimayParen(PrimayParenContext ctx) {
		return visit(ctx.expression());
	}

	@Override
	public AstNode visitPrimaryLiteral(PrimaryLiteralContext ctx) {
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
	public AstNode visitArguments(ArgumentsContext ctx) {
		for(ExpressionContext e:ctx.expression()){
			AstNode expr = visit(e);
			this.invocating.arguments.add((ExprNode) expr);
		}
		return null;
	}

}
