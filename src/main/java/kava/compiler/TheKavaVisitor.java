package kava.compiler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kava.antlr.*;
import kava.antlr.KavaParser.*;
import kava.opcode.Constant;
import kava.opcode.Op;
import kava.opcode.op.*;
import kava.opcode.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author KasonYang
 */
public class TheKavaVisitor extends AbstractParseTreeVisitor<VarObject> implements KavaVisitor<VarObject> {

	static final String INT = "int",LONG="long",FLOAT="float",DOUBLE="double",BOOLEAN="boolean",BYTE="byte",CHAR="char";
	
	private ConstTable constTb = new ConstTable();
	private VarTable varTb = new VarTable();
	private ArrayList<Op> ops = new ArrayList();
	private ArrayList<Op> continueList = new ArrayList<Op>();
	private ArrayList<Op> breakList = new ArrayList<Op>();
	
	public ConstTable getConstTable(){
		return constTb;
	}
	
	/*
	private void assign(VarObject target,VarObject src){
		VarObject tmp;
		if(src.getType()!=target.getType()){
			tmp = this.castVar(src, target.getType());
		}else{
			tmp = src;
		}
		ops.add(new ASSIGN(target,tmp));
	}
	*/

	@Override
	public VarObject visitLiteral(LiteralContext ctx) {
		String valText = ctx.getText();
		TerminalNode tn = (TerminalNode) ctx.children.get(0);
		int type = Constant.NULL;
		Integer varType = 0;
		Object value = null;
        int typeInt = tn.getSymbol().getType();
		switch(typeInt){
		case KavaParser.IntegerLiteral:
			value=Integer.parseInt(valText);
			type = Constant.INT;
			varType = VarObject.INT;
			break;
		case KavaParser.FloatingPointLiteral:
			type = Constant.FLOAT;
			value = Float.parseFloat(valText);
			varType = VarObject.FLOAT;
			break;
		case KavaParser.CharacterLiteral:
			type = Constant.CHAR;
			value = valText.charAt(1);
			varType = VarObject.CHAR;
			break;
		case KavaParser.StringLiteral:
			type = Constant.STRING;
			varType = VarObject.STRING;
			//TODO decode needed
			value = valText;
			break;
		case KavaParser.NullLiteral:
			type = Constant.NULL;
			value = null;
			varType = VarObject.NULL;
			break;
		}
		Constant cst = new Constant(type);
		cst.setValue(value);
		Constant cstId = constTb.create(cst);
		VarObject result = varTb.createTmp(varType);
		ops.add(new LDC(result,cstId));
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
	
	private String getTypePrefix(Integer type){
		switch(type){
		case VarObject.INT:return "I";
		case VarObject.FLOAT:return "F";
		case VarObject.LONG:return "L";
		case VarObject.DOUBLE:return "D";
		default:return null;
		}
	}
	
	/*
	private OpType getCastOp(Integer type1,Integer type2){		
		String name=getTypePrefix(type1) + "2" + getTypePrefix(type2);
		return (OpType.valueOf(name.toUpperCase()));
	}
	*/
	/*
	private VarObject castVar(VarObject src,Integer destType){
		VarObject o1 = varTb.createTmp(destType);
		ops.add(new Op(this.getCastOp(src.getType(),destType),o1,src,null));
		return o1;
	}
	*/
	
	
	private VarObject getCmpResult(VarObject v1,VarObject v2){
		Integer retType;
		//if(v2.getType()!=retType) v2 = this.castVar(v2, retType);
		VarObject result = varTb.createTmp(VarObject.INT);
		ops.add(new CMP(result,v1,v2));
		return result;
	}
	
	private VarObject getCalculateResult(String opStr,VarObject v1,VarObject v2){
		//String vType= "";
		Integer vType;
		Op op;
		VarObject ret = varTb.createTmp(VarObject.AUTO);
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
		//ops.add(new Op(ot,ret,v1,v2));
		return ret;
	}
	
	//数学运算
	@Override
	public VarObject visitExprMidOp(ExprMidOpContext ctx) {
		VarObject attr1 =this.visit(ctx.expression(0));
		VarObject attr2 = this.visit(ctx.expression(1));
		String opStr = ctx.getChild(1).getText();
		VarObject ret = this.getCalculateResult(opStr, attr1,attr2);
		//op(opStr,vo1,vo2,ret);
		//at.setValue(ret);
		return ret;
	}
	
	@Override
	public VarObject visitExprAssign(ExprAssignContext ctx) {
		VarObject at1 = visit(ctx.expression(1));
		VarObject at0 = visit(ctx.expression(0));
		//this.assign(at0,at1);
		//String name = 
		ops.add(new ASSIGN(at0,at1));
		//VarObject attr = new Attr();
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
		//arObject attr = new Attr();
		String name = ctx.Identifier().getText();
    	//int idInt;
    	VarObject vo;
    	if(varTb.contains(name)){
    		vo = varTb.get(name);
    	}else{
    		throw new CompilerException(name + " is undefined");
    		//vo = varTb.create(name);
    	} 
    	//attr.setValue(idInt);
    	return vo;
	}

	/*
	@Override
	public VarObject visitExpressions(ExpressionsContext ctx) {
		if(ctx.expression() != null){
			for(ExpressionContext e:ctx.expression()){
				visit(e);
			}
		}
		return new Attr();
	}
	*/

	@Override
	public VarObject visitGenericInvocation(GenericInvocationContext ctx) {
		String invName = ctx.Identifier().getText();
		VarObject at = visit(ctx.arguments());
		//TODO repair
		/*
		int size = at.getValue();
		Constant cst = new Constant(Constant.STRING);
		cst.setValue(invName);
		int cstId = this.constTb.create(cst);
		int ret = varTb.create();
		ops.add(new INVOKE,ret,cstId,size));
		return new Attr(ret);
		*/
		return null;
	}

	@Override
	public VarObject visitArguments(ArgumentsContext ctx) {
		//TODO
		/*
		VarObject attr = new Attr();
		if(ctx.argumentList() != null){
			VarObject at = visit(ctx.argumentList());
			attr.setValue(at.getValue());
		}else{
			attr.setValue(0);
		}
		return attr;
		*/
		return null;
	}

	@Override
	public VarObject visitArgumentList(ArgumentListContext ctx) {
		//TODO
		/*
		int paramCount = 0;
		for(ExpressionContext e:ctx.expression()){
			VarObject at = visit(e);
			paramCount++;
			ops.add(new PARAM,at.getValue(),null,null));
		}
		VarObject attr= new Attr();
		attr.setValue(paramCount);
		return attr;
		*/
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
		//ops.add(new NOOP,null,null,null));
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
		//Op op = new IFFALSE,null,at,null);
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
		//Op opIfF = new IFFALSE,null,at,null);
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
		//ops.add(new IFTRUE,null,at,begin));
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public VarObject visitExprSelfOp(ExprSelfOpContext ctx) {
		VarObject at = visit(ctx.expression());
		VarObject result = varTb.createTmp(at.getType());
		ops.add(new ASSIGN(result,at));
		int incDelta = ctx.INC() != null ? 1 : -1;
		ops.add(new IINC(at,incDelta));
		return result;
	}
	@Override
	public VarObject visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
		VarObject at = visit(ctx.expression());
		VarObject result = varTb.createTmp(at.getType());
		VarObject tmpVar = varTb.createTmp(at.getType());
		switch(ctx.getChild(0).getText()){
		case "-":
			ops.add(new ICONST(tmpVar,0));
			ops.add(new SUB(result,tmpVar,at));
			//ops.add(new a)
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
		VarObject result = varTb.createTmp(VarObject.INT);
		//VarObject tmpVar = this.getCalculateResult("-", at,at2);
		VarObject tmpVar;
		if(at.getType()==at2.getType() && at.getType()==VarObject.INT){
			tmpVar = this.getCalculateResult("-", at, at2);
		}else{
			tmpVar = this.getCmpResult(at, at2);
		}
		//int tmpVar = varTb.createTmp(tmpType);
		//ops.add(new SUB",tmpVar,at,at2));
		IF opIFGoto = op;
				//new Op(type,null,tmpVar,null);
		op.v1 = tmpVar;
		ops.add(opIFGoto);
		ops.add(new ICONST(result,0));
		//ops.add(new ICONST,result,0,null));
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
		switch(stype){
		case INT:type = VarObject.INT;break;
		case FLOAT:type=VarObject.FLOAT;break;
		case LONG:type=VarObject.LONG;break;
		case DOUBLE:type=VarObject.DOUBLE;break;
		case BOOLEAN:type=VarObject.BOOLEAN;break;
		case BYTE:type = VarObject.BYTE;break;
		case CHAR:type=VarObject.CHAR;break;
		default:type=VarObject.REFERENCE;break;
		}
		VarObject var = varTb.create(name,type);
		if(ctx.expression()!=null){
			VarObject eRet = visit(ctx.expression());
			ops.add(new ASSIGN(var, eRet));
		}
		return null;
	}

}
