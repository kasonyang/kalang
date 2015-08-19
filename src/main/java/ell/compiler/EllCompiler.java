package ell.compiler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import ell.antlr.EllParser.ArgumentDeclContext;
import ell.antlr.EllParser.ArgumentDeclListContext;
import ell.antlr.EllParser.ArgumentListContext;
import ell.antlr.EllParser.ArgumentsContext;
import ell.antlr.EllParser.ArrayAssignContext;
import ell.antlr.EllParser.BreakStatContext;
import ell.antlr.EllParser.ClassBodyContext;
import ell.antlr.EllParser.CompiliantUnitContext;
import ell.antlr.EllParser.ContinueStatContext;
import ell.antlr.EllParser.DoWhileStatContext;
import ell.antlr.EllParser.DslChainStatContext;
import ell.antlr.EllParser.DslExpressionContext;
import ell.antlr.EllParser.DslParamContext;
import ell.antlr.EllParser.DslParamListContext;
import ell.antlr.EllParser.DslStatContext;
import ell.antlr.EllParser.DslStatListContext;
import ell.antlr.EllParser.DslVarDeclContext;
import ell.antlr.EllParser.DslVarNewContext;
import ell.antlr.EllParser.ExprAssignContext;
import ell.antlr.EllParser.ExprGetArrayElementContext;
import ell.antlr.EllParser.ExprGetFieldContext;
import ell.antlr.EllParser.ExprInvocationContext;
import ell.antlr.EllParser.ExprLogicCmpContext;
import ell.antlr.EllParser.ExprLogicContext;
import ell.antlr.EllParser.ExprMemberInvocationContext;
import ell.antlr.EllParser.ExprMidOpContext;
import ell.antlr.EllParser.ExprNotOpContext;
import ell.antlr.EllParser.ExprPrimayContext;
import ell.antlr.EllParser.ExprSelfOpContext;
import ell.antlr.EllParser.ExprSelfOpPreContext;
import ell.antlr.EllParser.ExprStatContext;
import ell.antlr.EllParser.ExpressionContext;
import ell.antlr.EllParser.ExpressionListContext;
import ell.antlr.EllParser.ForInitContext;
import ell.antlr.EllParser.ForStatContext;
import ell.antlr.EllParser.ForUpdateContext;
import ell.antlr.EllParser.IfStatContext;
import ell.antlr.EllParser.IfStatSuffixContext;
import ell.antlr.EllParser.LiteralContext;
import ell.antlr.EllParser.MethodDeclContext;
import ell.antlr.EllParser.MethodDeclListContext;
import ell.antlr.EllParser.OffsetContext;
import ell.antlr.EllParser.ParamNamedContext;
import ell.antlr.EllParser.ParamOrderedContext;
import ell.antlr.EllParser.PrimaryIdentifierContext;
import ell.antlr.EllParser.PrimaryLiteralContext;
import ell.antlr.EllParser.PrimayParenContext;
import ell.antlr.EllParser.ReturnStatContext;
import ell.antlr.EllParser.StartContext;
import ell.antlr.EllParser.StatContext;
import ell.antlr.EllParser.StatListContext;
import ell.antlr.EllParser.TypeContext;
import ell.antlr.EllParser.VarDeclContext;
import ell.antlr.EllParser.VarDeclStatContext;
import ell.antlr.EllParser.WhileStatContext;
import ell.antlr.EllVisitor;
import static java.lang.String.format;

public class EllCompiler extends AbstractParseTreeVisitor<String> implements EllVisitor<String> {

	
	private List<String> code = new ArrayList();
	private int tmpNameIdx = 0;
	
	public String getCode(){
		String code = "";
		for(String c:this.code){
			code += c+"\n";
		}
		return code;
	}
	
	private String vChild(ParserRuleContext ctx){
		if(ctx.children!=null){
			for(ParseTree c:ctx.children){
				visit(c);
			}
		}
		return null;
	}
	
	private String createTmpVar(){
		return String.format("t%s", this.tmpNameIdx++);
	}
	
	@Override
	public String visitDslStatList(DslStatListContext ctx) {
		vChild(ctx);
		return null;
	}

	@Override
	public String visitDslStat(DslStatContext ctx) {
		String id = ctx.Identifier().getText();
		String value = visit(ctx.dslExpr());
		code.add(id+"="+value + ";");
		return null;
	}

	@Override
	public String visitDslVarDecl(DslVarDeclContext ctx) {
		String type = ctx.Identifier().getText();
		
		//code.add(type + " " + )
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitDslVarNew(DslVarNewContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitDslExpression(DslExpressionContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitDslChainStat(DslChainStatContext ctx) {
		Iterator<TerminalNode> iter = ctx.Identifier().iterator();
		Iterator<DslParamListContext> piter = ctx.dslParamList().iterator();
		String objName = null;
		while(iter.hasNext()){
			String md = iter.next().toString();
			DslParamListContext p = piter.next();
			String pCode = visit(p);
			if(objName == null){
				objName = this.createTmpVar();
				code.add(String.format("%s %s = new %s();",md,objName,md));
				code.add(String.format("%s.beginStatement(%s);",objName,pCode));
			}else{
				code.add(String.format("%s.%s(%s);",objName,md,pCode));
			}
		}
		String tmpName = this.createTmpVar();
		code.add(format("%s=%s.endStatement();",tmpName,objName));
		return tmpName;
	}

	@Override
	public String visitDslParam(DslParamContext ctx) {
		String id = ctx.Identifier().getText();
		//code.add(e);
		//TODO
		return null;
	}

	@Override
	public String visitStart(StartContext ctx) {
		visit(ctx.getChild(0));
		return null;
	}

	@Override
	public String visitCompiliantUnit(CompiliantUnitContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitClassBody(ClassBodyContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitMethodDeclList(MethodDeclListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitMethodDecl(MethodDeclContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitType(TypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitArgumentDeclList(ArgumentDeclListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitArgumentDecl(ArgumentDeclContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitStatList(StatListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitIfStat(IfStatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitIfStatSuffix(IfStatSuffixContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitStat(StatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitReturnStat(ReturnStatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitVarDeclStat(VarDeclStatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitVarDecl(VarDeclContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitBreakStat(BreakStatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitContinueStat(ContinueStatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitWhileStat(WhileStatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitDoWhileStat(DoWhileStatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitForStat(ForStatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitForInit(ForInitContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitForUpdate(ForUpdateContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExpressionList(ExpressionListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprStat(ExprStatContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprPrimay(ExprPrimayContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitArrayAssign(ArrayAssignContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprMemberInvocation(ExprMemberInvocationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprAssign(ExprAssignContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprMidOp(ExprMidOpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprInvocation(ExprInvocationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprNotOp(ExprNotOpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprGetField(ExprGetFieldContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprLogicCmp(ExprLogicCmpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprSelfOp(ExprSelfOpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprLogic(ExprLogicContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExprGetArrayElement(ExprGetArrayElementContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitOffset(OffsetContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPrimayParen(PrimayParenContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPrimaryLiteral(PrimaryLiteralContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPrimaryIdentifier(PrimaryIdentifierContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitLiteral(LiteralContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitArguments(ArgumentsContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitArgumentList(ArgumentListContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitParamNamed(ParamNamedContext ctx) {
		String code = "";
		String var = this.createTmpVar();
		code += String.format("HashMap %s=new HashMap();", var);
		Iterator<TerminalNode> iter = ctx.Identifier().iterator();
		Iterator<ExpressionContext> eIter = ctx.expression().iterator();
		while(iter.hasNext()){
			String key = iter.next().toString();
			String val = eIter.next().getText();
			code += String.format("%s.put(\"%s\",%s);",var,key,val);
		}
		this.code.add(code);
		return var;
	}

	@Override
	public String visitParamOrdered(ParamOrderedContext ctx) {
		return ctx.getText();
	}

}
