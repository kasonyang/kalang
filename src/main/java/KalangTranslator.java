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
import kalang.ast.*;
import kalang.ast.expr.*;
import kalang.ast.stmt.*;
import kalang.core.ArgumentObject;
import kalang.core.ClassObject;
import kalang.core.FieldObject;
import kalang.core.MethodObject;
import kalang.core.Modifier;
import kalang.core.VarObject;
import kalang.core.VarTable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;


public class KalangTranslator extends AbstractParseTreeVisitor<Expression> implements KalangVisitor<Expression> {

	List<Statement> codes = new LinkedList();
	
	VarTable vtb = new VarTable();
	
	ClassObject cls = null;
	
	MethodObject method = null;
	
	InvocationExpr invocating;
	
	public ClassObject getClassObject(){
		return cls;
	}
	
	private void doVisitVarDeclAndInit(VarDeclContext vd,VarInitContext vi){
		VarDeclStmt vds = new VarDeclStmt();
		VarExpr var = this.visitVarDecl(vd);
		vds.var=(var);
		if(vi!=null){
			Expression val = visit(vi);
			vds.initExpr = (val);
		}
		codes.add(vds);
	}
	
	@Override
	public Expression visitStart(StartContext ctx) {
		visit(ctx.compiliantUnit());
		return null;
	}

	@Override
	public Expression visitCompiliantUnit(CompiliantUnitContext ctx) {
		cls = new ClassObject();
		cls.setName(ctx.Identifier(0).getText());
		String modifier = "public";
		if(ctx.Modifier()!=null){
			modifier = ctx.Modifier().getText();
		}
		cls.setModifier(modifier);
		if(ctx.Identifier().size()>1){
			cls.setParentName(ctx.Identifier(1).getText());
		}
		visitClassBody(ctx.classBody());
		return null;
	}

	@Override
	public Expression visitClassBody(ClassBodyContext ctx) {
		this.visitFieldDeclList(ctx.fieldDeclList());
		this.visitMethodDeclList(ctx.methodDeclList());
		return null;
	}

	@Override
	public Expression visitFieldDeclList(FieldDeclListContext ctx) {
		for(FieldDeclContext fd:ctx.fieldDecl()){
			this.visitFieldDecl(fd);
		}
		return null;
	}

	@Override
	public Expression visitFieldDecl(FieldDeclContext ctx) {
		String type = ctx.type()==null?"Object":ctx.type().getText();
		FieldObject fo = new FieldObject();
		fo.setName(ctx.Identifier().getText());
		fo.setType(type);
		if(ctx.varInit()!=null){
			fo.setInitExpr(visit(ctx.varInit()));
		}
		String modifier = "public";
		if(ctx.Modifier()!=null){
			modifier = (ctx.Modifier().getText());
		}
		fo.setModifier(modifier);
		cls.fields.add(fo);
		//TODO visit setter and getter,modifier
		return null;
	}

	@Override
	public Expression visitSetter(SetterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visitGetter(GetterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visitMethodDeclList(MethodDeclListContext ctx) {
		for(MethodDeclContext md:ctx.methodDecl()){
			visit(md);
		}
		return null;
	}

	@Override
	public Expression visitMethodDecl(MethodDeclContext ctx) {
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
		this.method = new MethodObject(name,type,mdf,isStatic);
		this.codes = method.statements;
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
	public Expression visitType(TypeContext ctx) {
		//do nothing
		return null;
	}

	@Override
	public Expression visitArgumentDeclList(ArgumentDeclListContext ctx) {
		for(ArgumentDeclContext ad:ctx.argumentDecl()){
			visit(ad);
		}
		return null;
	}

	@Override
	public Expression visitArgumentDecl(ArgumentDeclContext ctx) {
		String name = ctx.Identifier().getText();
		String type = "Object";
		if(ctx.type()!=null){
			type = ctx.type().getText();
		}
		ArgumentObject ao = new ArgumentObject();
		ao.type = type;
		ao.name = name;
		this.method.arguments.add(ao);
		return null;
	}

	@Override
	public Expression visitStatList(StatListContext ctx) {
		for(StatContext s:ctx.stat()){
			visit(s);
		}
		return null;
	}

	@Override
	public Expression visitIfStat(IfStatContext ctx) {
		IfStmt ifStmt = new IfStmt();
		Expression expr = visit(ctx.expression());
		ifStmt.testExpr = expr;
		List<Statement> oldCodes = codes;
		codes = ifStmt.trueStmt.statements;
		visit(ctx.statList());
		codes = ifStmt.falseStmt.statements;
		visit(ctx.ifStatSuffix());
		codes = oldCodes;
		return null;
	}

	@Override
	public Expression visitIfStatSuffix(IfStatSuffixContext ctx) {
		visit(ctx.statList());
		return null;
	}

	@Override
	public Expression visitStat(StatContext ctx) {
		visitAll(ctx);
		return null;
	}

	private void visitAll(ParserRuleContext ctx) {
		for(ParseTree c:ctx.children){
			visit(c);
		}
	}

	@Override
	public Expression visitReturnStat(ReturnStatContext ctx) {
		Expression expr = visit(ctx.expression());
		ReturnStmt rs = new ReturnStmt();
		rs.expr = expr;
		codes.add(rs);
		return null;
	}

	@Override
	public Expression visitVarDeclStat(VarDeclStatContext ctx) {
		this.doVisitVarDeclAndInit(ctx.varDecl(), ctx.varInit());		
		return null;
	}

	@Override
	public VarExpr visitVarDecl(VarDeclContext ctx) {
		String name = ctx.Identifier().getText();
		String type = "Object";
		if(ctx.type()!=null){
			type = ctx.type().getText();
		}
		boolean isReadOnly = ctx.getChild(0).getText() == "val";
		VarObject vo = new VarObject(name,type,isReadOnly);
		vtb.put(name, vo);
		VarExpr ve = new VarExpr();
		ve.varName = vo.getName();
		ve.type = type;
		return ve;
	}

	@Override
	public Expression visitVarInit(VarInitContext ctx) {
		Expression vo = visit(ctx.expression());
		return vo;
	}

	@Override
	public Expression visitBreakStat(BreakStatContext ctx) {
		BreakStmt bs = new BreakStmt();
		codes.add(bs);
		return null;
	}

	@Override
	public Expression visitContinueStat(ContinueStatContext ctx) {
		ContinueStmt cs = new ContinueStmt();
		codes.add(cs);
		return null;
	}

	@Override
	public Expression visitWhileStat(WhileStatContext ctx) {
		WhileStmt ws = new WhileStmt();
		Expression expr = visit(ctx.expression());
		ws.testExpr = expr;
		this.codes = ws.body.statements;
		visit(ctx.statList());
		return null;
	}

	@Override
	public Expression visitDoWhileStat(DoWhileStatContext ctx) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Expression visitForStat(ForStatContext ctx) {
		LoopStmt ls = new LoopStmt();
		VarTable oVtb = this.vtb;
		vtb = ls.varTable;
		visit(ctx.forInit());
		
		Expression texpr = visit(ctx.expression());
		ls.prefixTestExpr = texpr;
		List<Statement> oCodes = this.codes;
		codes = ls.loopBlock.statements;
		visit(ctx.statList());
		visit(ctx.forUpdate());
		codes = oCodes;
		vtb = oVtb;
		codes.add(ls);
		return null;
	}

	@Override
	public Expression visitForInit(ForInitContext ctx) {
		visitAll(ctx);
		return null;
	}

	@Override
	public Expression visitForUpdate(ForUpdateContext ctx) {
		visitAll(ctx);
		return null;
	}

	@Override
	public Expression visitExpressions(ExpressionsContext ctx) {
		for(ExpressionContext e:ctx.expression()){
			Expression expr = visit(e);
			codes.add(new ExprStmt(expr));
		}
		return null;
	}

	@Override
	public Expression visitExprStat(ExprStatContext ctx) {
		Expression expr = visit(ctx.expression());
		ExprStmt es = new ExprStmt();
		es.expr = expr;
		codes.add(es);
		return null;
	}

	@Override
	public Expression visitExprPrimay(ExprPrimayContext ctx) {
		return visit(ctx.primary());
	}

	@Override
	public Expression visitExprMemberInvocation(ExprMemberInvocationContext ctx) {
		VarExpr expr = new VarExpr();
		expr.varName = "this";
		return this.getInvocationExpr(
				expr
				, ctx.Identifier().getText()
				,ctx.arguments());
	}

	@Override
	public Expression visitExprAssign(ExprAssignContext ctx) {
		//String varName = ctx.Identifier().getText();
		//VarObject vo = this.ensureVar(varName);
		Expression to = visit(ctx.expression(0));
		Expression from = visit(ctx.expression(1));
		//VarExpr ve = new VarExpr();
		//ve.type = vo.getType();
		//ve.varName = vo.getName();
		AssignExpr aexpr = new AssignExpr();
		aexpr.from = from;
		aexpr.to = to;
		return aexpr;
	}

	@Override
	public Expression visitExprMidOp(ExprMidOpContext ctx) {
		String op = ctx.getChild(1).getText();
		BinaryExpr be = new BinaryExpr();
		be.expr1 = visit(ctx.expression(0));
		be.expr2 = visit(ctx.expression(1));
		be.operation = op;
		return be;
	}
	
	private Expression getInvocationExpr(Expression expr,String methodName,ArgumentsContext arguments){
		InvocationExpr is = new InvocationExpr();
		InvocationExpr oldInv = this.invocating;
		is.invocationMethod =methodName;
		is.invocationTarget = expr;
		this.invocating = is;
		visit(arguments);
		this.invocating = oldInv;
		return is;
	}

	@Override
	public Expression visitExprInvocation(ExprInvocationContext ctx) {
		return this.getInvocationExpr(
				visit(ctx.expression())
				, ctx.Identifier().getText()
				, ctx.arguments());
	}

	@Override
	public Expression visitExprNotOp(ExprNotOpContext ctx) {
		return new UnaryExpr(visit(ctx.expression()),ctx.getChild(0).getText(),true);
	}

	@Override
	public Expression visitExprGetField(ExprGetFieldContext ctx) {
		Expression expr = visit(ctx.expression());
		String name = ctx.Identifier().getText();
		FieldExpr fe = new FieldExpr();
		fe.target = expr;
		fe.fieldName = name;
		return fe;
	}

	@Override
	public Expression visitExprLogicCmp(ExprLogicCmpContext ctx) {
		return new BinaryExpr(visit(ctx.expression(0)),visit(ctx.expression(1)),ctx.getChild(1).getText());
	}

	@Override
	public Expression visitExprSelfOp(ExprSelfOpContext ctx) {
		UnaryExpr ue = new UnaryExpr();
		ue.operation = ctx.getChild(1).getText();
		ue.target = visit(ctx.expression());
		return ue;
	}

	@Override
	public Expression visitExprLogic(ExprLogicContext ctx) {
		return new BinaryExpr(
				visit(ctx.expression(0))
				,visit(ctx.expression(1))
				,ctx.getChild(1).getText()
				);
	}

	@Override
	public Expression visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
		String op = ctx.getChild(0).getText();
		return new UnaryExpr(visit(ctx.expression()),op,true);
	}

	@Override
	public Expression visitExprGetArrayElement(ExprGetArrayElementContext ctx) {
		ElementExpr ee = new ElementExpr();
		ee.target = visit(ctx.expression(0));
		ee.key = visit(ctx.expression(1));
		return ee;
	}

	@Override
	public Expression visitPrimayParen(PrimayParenContext ctx) {
		return visit(ctx.expression());
	}

	@Override
	public Expression visitPrimaryLiteral(PrimaryLiteralContext ctx) {
		return new ConstExpr(ctx.literal().getText());
	}

	@Override
	public Expression visitPrimaryIdentifier(PrimaryIdentifierContext ctx) {
		VarExpr ve = new VarExpr();
		String name = ctx.Identifier().getText();
		ensureVar(name);
		VarObject vo = vtb.get(name);
		ve.varName = name;
		ve.type = vo.getType();
		return ve;
	}

	private VarObject ensureVar(String varName) {
		VarObject vo = this.vtb.get(varName);
		if(vo==null){
			throw new RuntimeException("Undefined var:" + varName);
		}
		return vo;
	}

	@Override
	public Expression visitLiteral(LiteralContext ctx) {
		//do nothing
		return null;
	}

	@Override
	public Expression visitArguments(ArgumentsContext ctx) {
		for(ExpressionContext e:ctx.expression()){
			Expression expr = visit(e);
			this.invocating.invocationArguments.add(expr);
		}
		return null;
	}

}
