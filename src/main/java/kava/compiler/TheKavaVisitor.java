package kava.compiler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kava.antlr.*;
import kava.antlr.KavaParser.ArrayAssignContext;
import kava.antlr.KavaParser.ExprGetArrayElementContext;
import kava.antlr.KavaParser.ExprLogicContext;
import kava.antlr.KavaParser.OffsetContext;
import kava.antlr.KavaParser.*;
import kava.opcode.Constant;
import kava.opcode.Op;
import kava.opcode.VarObject;
import kava.opcode.op.*;
import kava.opcode.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author KasonYang<im@kasonyang.com>
 */
public class TheKavaVisitor extends AbstractParseTreeVisitor<VarObject> implements KavaVisitor<VarObject> {

	//static final String INT = "int",LONG="long",FLOAT="float",DOUBLE="double",BOOLEAN="boolean",BYTE="byte",CHAR="char";
	
	private ConstTable constTb = new ConstTable();
	private VarTable varTb = new VarTable();
	private ArrayList<Op> ops = new ArrayList();
	private ArrayList<Op> continueList = new ArrayList<Op>();
	private ArrayList<Op> breakList = new ArrayList<Op>();
	
	public ConstTable getConstTable(){
		return constTb;
	}
	
	@Override
	public VarObject visitLiteral(LiteralContext ctx) {
		String valText = ctx.getText();
		TerminalNode tn = (TerminalNode) ctx.children.get(0);
		Object value = null;
		String cls = "";
        int typeInt = tn.getSymbol().getType();
		switch(typeInt){
		case KavaParser.IntegerLiteral:
			value=Integer.parseInt(valText);
			cls = "int";
			break;
		case KavaParser.FloatingPointLiteral:
			value = Float.parseFloat(valText);
			cls = "float";
			break;
		case KavaParser.CharacterLiteral:
			value = valText.charAt(1);
			cls="char";
			break;
		case KavaParser.StringLiteral:
			//TODO escape needed
			value = valText;
			cls = "String";
			break;
		case KavaParser.NullLiteral:
			value = null;
			cls = "null";
			break;
		}
		Constant cst = constTb.createConst();
		cst.setValue(value);
		cst.setClassName(cls);
		VarObject result = varTb.createTmp();
		ops.add(new LDC(result,cst));
		return result;
	}
	
	public VarTable getVarTable(){
		return this.varTb;
	}
	
	public List<Op> getOpcodes(){
		return this.ops;
	}
	
	
	@Override
	public VarObject visitExprPrimay(ExprPrimayContext ctx) {
		return visit(ctx.primary());
	}	
	
	private VarObject getCmpResult(VarObject v1,VarObject v2){
		VarObject result = varTb.createTmp();
		ops.add(new CMP(result,v1,v2));
		return result;
	}
	
	private VarObject getCalculateResult(String opStr,VarObject v1,VarObject v2){
		Op op;
		VarObject ret = varTb.createTmp();
		switch(opStr){
		case "+":
			op = new ADD(ret,v1,v2);
			break;
		case "-":
			op = new SUB(ret,v1,v2);
			break;
		case "*":
			op = new MUL(ret,v1,v2);
			break;
		case "/":
			op = new DIV(ret,v1,v2);
			break;
		case "%":
			op = new MOD(ret,v1,v2);
			break;
			default:
				throw new CompilerException("无法识别的运算符！");
		}
		ops.add(op);
		return ret;
	}
	
	//数学运算
	@Override
	public VarObject visitExprMidOp(ExprMidOpContext ctx) {
		VarObject attr1 =this.visit(ctx.expression(0));
		VarObject attr2 = this.visit(ctx.expression(1));
		String opStr = ctx.getChild(1).getText();
		VarObject ret = this.getCalculateResult(opStr, attr1,attr2);
		return ret;
	}
	
	@Override
	public VarObject visitExprAssign(ExprAssignContext ctx) {
		VarObject at1 = visit(ctx.expression());
		VarObject at0 = varTb.get(ctx.Identifier().getText());
		ops.add(new ASSIGN(at0,at1));
		return at0;
	}
	
	@Override
	public VarObject visitPrimayParen(PrimayParenContext ctx) {
		return visit(ctx.expression());
	}
	@Override
	public VarObject visitPrimaryLiteral(PrimaryLiteralContext ctx) {
		return visit(ctx.literal());
	}
	@Override
	public VarObject visitPrimaryIdentifier(PrimaryIdentifierContext ctx) {
		String name = ctx.Identifier().getText();
    	VarObject vo;
    	if(varTb.contains(name)){
    		vo = varTb.get(name);
    	}else{
    		throw new CompilerException(name + " is undefined");
    	} 
    	return vo;
	}

	@Override
	public VarObject visitGenericInvocation(GenericInvocationContext ctx) {
		String invName = ctx.Identifier().getText();
		VarObject at = visit(ctx.arguments());
		//TODO invoke unimplemented
		return null;
	}

	@Override
	public VarObject visitArguments(ArgumentsContext ctx) {
		//TODO visitArguments implemented
		return null;
	}

	@Override
	public VarObject visitArgumentList(ArgumentListContext ctx) {
		//TODO visitArgList umplemented
		return null;
	}

	@Override
	public VarObject visitExprInvocation(ExprInvocationContext ctx) {
		return visit(ctx.genericInvocation());
	}

	@Override
	public VarObject visitStart(StartContext ctx) {
		if(ctx.statList() != null){
			visit(ctx.statList());
		}
		ops.add(new NOOP());
		return null;
	}

	@Override
	public VarObject visitStatList(StatListContext ctx) {
		if(ctx.stat()!=null){
			for(StatContext s:ctx.stat()){
				visit(s);
			}
		}
		return null;
	}

	@Override
	public VarObject visitIfStat(IfStatContext ctx) {
		VarObject at = visit(ctx.expression());
		IFFALSE op = new IFFALSE(at,null);
		ops.add(op);
		visit(ctx.statList());
		Integer goVal = (int) ops.size();
		if(ctx.ifStatSuffix()!=null){
			goVal+=1;
			GOTO trueGoOp = new GOTO(null);
			ops.add(trueGoOp);
			visit(ctx.ifStatSuffix());
			trueGoOp.v1 = ops.size();
		}
		op.v2 = goVal;
		return null;
	}

	@Override
	public VarObject visitStat(StatContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public VarObject visitExprStat(ExprStatContext ctx) {
		visit(ctx.expression());
		return null;
	}

	@Override
	public VarObject visitIfStatSuffix(IfStatSuffixContext ctx) {
		visit(ctx.statList());
		return null;
	}

	@Override
	public VarObject visitWhileStat(WhileStatContext ctx) {
		ArrayList<Op> bList,cList;
		bList = this.breakList;
		cList = this.continueList;
		
		Integer begin = (int) ops.size();
		VarObject at = visit(ctx.expression());
		IFFALSE opIfF = new IFFALSE(at,0);
		ops.add(opIfF);
		visit(ctx.statList());
		GOTO opGoto = new GOTO(begin);
		ops.add(opGoto);
		Integer end;
		opIfF.v2 = end=ops.size();
		
		setGoto(bList,end);
		setGoto(cList,begin);
		this.breakList = bList;
		this.continueList = cList;
		return null;
	}

	@Override
	public VarObject visitDoWhileStat(DoWhileStatContext ctx) {
		ArrayList<Op> clist,blist;
		clist = this.continueList;
		blist = this.breakList;
		
		Integer begin = (int) ops.size();
		visit(ctx.statList());
		VarObject at = visit(ctx.expression());
		ops.add(new IFTRUE(at,begin));
		Integer end = ops.size();
		
		setGoto(clist,begin);
		setGoto(blist,end);
		this.continueList = clist;
		this.breakList = blist;
		return null;
	}

	private void setGoto(ArrayList<Op> list,Integer position){
		for(Op o:list){
			((GOTO)o).v1 = position;
		}
	}
	
	@Override
	public VarObject visitForStat(ForStatContext ctx) {
		ArrayList<Op> bList,cList;
		bList= this.breakList;
		cList = this.continueList;
		
		if(ctx.forInit()!=null) visit(ctx.forInit());
		Integer begin = (int) ops.size();
		VarObject exAt = visit(ctx.expression());
		IFFALSE opIfF = new IFFALSE(exAt,null);
		ops.add(opIfF);
		visit(ctx.statList());
		visit(ctx.forUpdate());
		ops.add(new GOTO(begin));
		Integer end; 
		opIfF.v2 = end = ops.size();
		
		setGoto(bList,end);
		setGoto(cList,begin);
		this.breakList = bList;
		this.continueList = cList;
		return null;
	}

	@Override
	public VarObject visitForInit(ForInitContext ctx) {
		visit(ctx.getChild(0));
		return null;
	}

	@Override
	public VarObject visitForUpdate(ForUpdateContext ctx) {
		visit(ctx.expressionList());
		return null;
	}

	@Override
	public VarObject visitExpressionList(ExpressionListContext ctx) {
		for(ExpressionContext e:ctx.expression()){
			visit(e);
		}
		return null;
	}
	@Override
	public VarObject visitExprNotOp(ExprNotOpContext ctx) {
		VarObject ve = visit(ctx.expression());
		VarObject ret = varTb.createTmp();
		ops.add(new LOGIC_NOT(ret,ve));
		return ret;
	}
	@Override
	public VarObject visitExprSelfOp(ExprSelfOpContext ctx) {
		VarObject at = visit(ctx.expression());
		VarObject result = varTb.createTmp();
		ops.add(new ASSIGN(result,at));
		int incDelta = ctx.INC() != null ? 1 : -1;
		ops.add(new IINC(at,incDelta));
		return result;
	}
	@Override
	public VarObject visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
		VarObject at = visit(ctx.expression());
		VarObject result = varTb.createTmp();
		VarObject tmpVar = varTb.createTmp();
		switch(ctx.getChild(0).getText()){
		case "-":
			ops.add(new ICONST(tmpVar,0));
			ops.add(new SUB(result,tmpVar,at));
			break;
		case "--":
			ops.add(new IINC(at,-1));
			ops.add(new ASSIGN(result,at));
			break;
		case "++":
			ops.add(new IINC(at,1));
			ops.add(new ASSIGN(result,at));
			break;
		case "+":
			ops.add(new ASSIGN(result,at));
			break;
		default:
			throw new RuntimeException("未识别的操作符！");
		}
		return result;
	}
	
	@Override
	public VarObject visitExprLogicCmp(ExprLogicCmpContext ctx) {
		VarObject at = visit(ctx.expression(0));
		VarObject at2 = visit(ctx.expression(1));
		IF op;
		switch(ctx.getChild(1).getText()){
		case ">":op = new IFGT(null,null);break;
		case "<":op = new IFLT(null,null);break;
		case ">=":op = new IFGE(null,null);break;
		case "<=":op = new IFLE(null,null);break;
		case "==":op = new IFEQ(null,null);break;
		case "!=":op = new IFNE(null,null);break;
		default:throw new RuntimeException("Wrong op");
		}
		VarObject result = varTb.createTmp();
		VarObject tmpVar;
		tmpVar = this.getCmpResult(at, at2);
		IF opIFGoto = op;
		op.v1 = tmpVar;
		ops.add(opIFGoto);
		ops.add(new ICONST(result,0));
		GOTO opGoto = new GOTO(null);
		
		ops.add(opGoto);
		opIFGoto.v2 = ops.size();
		ops.add(new ICONST(result,1));
		opGoto.v1 = ops.size();
		return result;
	}
	@Override
	public VarObject visitBreakStat(BreakStatContext ctx) {
		Op op;
		ops.add(op = new GOTO(null));
		breakList.add(op);
		return null;
	}
	@Override
	public VarObject visitContinueStat(ContinueStatContext ctx) {
		GOTO op = new GOTO(null);
		ops.add(op);
		continueList.add(op);
		return null;
	}
	@Override
	public VarObject visitVarDeclStat(VarDeclStatContext ctx) {
		return visit(ctx.varDecl());
	}
	@Override
	public VarObject visitVarDecl(VarDeclContext ctx) {
		String name = ctx.Identifier().getText();
		String stype = ctx.getChild(0).getText();
		Integer type;
		Integer asize = 0;
		boolean isArray = ctx.IntegerLiteral()!=null;
		if(isArray){
			
			asize = Integer.parseInt(ctx.IntegerLiteral().getText());
		}
		VarObject var = varTb.create(name);
		var.className = stype;
		Constant arrType = new Constant();
		arrType.setValue(stype);
		if(isArray){
			ops.add(new ANEW(var,arrType,asize));
			var.className += "[]";
		}
		if(ctx.expression()!=null){
			VarObject eRet = visit(ctx.expression());
			ops.add(new ASSIGN(var, eRet));
		}
		return null;
	}

	@Override
	public VarObject visitExprGetArrayElement(ExprGetArrayElementContext ctx) {
		VarObject e = visit(ctx.expression());
		visit(ctx.offset());
		VarObject ret = varTb.createTmp();
		ops.add(new AGET(ret, e));
		return ret;
	}

	@Override
	public VarObject visitOffset(OffsetContext ctx) {
		VarObject e = visit(ctx.expression());
		AOFFSET offset = new AOFFSET(e);
		ops.add(offset);
		return null;
	}

	@Override
	public VarObject visitArrayAssign(ArrayAssignContext ctx) {
		VarObject ret = varTb.createTmp();
		VarObject e = visit(ctx.expression());
		ops.add(new ASSIGN(ret,e));
		String id = ctx.Identifier().getText();
		VarObject arrVar = varTb.get(id);
		visit(ctx.offset());
		ops.add(new APUT(arrVar,e));
		return ret;
	}

	@Override
	public VarObject visitExprLogic(ExprLogicContext ctx) {
		VarObject ve = visit(ctx.expression(0));
		VarObject ve2 = visit(ctx.expression(1));
		VarObject ret = varTb.createTmp();
		if(ctx.AND()!=null){
			ops.add(new LOGIC_AND(ret,ve,ve2));
		}else if(ctx.OR()!=null){
			ops.add(new LOGIC_OR(ret,ve,ve2));
		}
		return ret;
	}
}
