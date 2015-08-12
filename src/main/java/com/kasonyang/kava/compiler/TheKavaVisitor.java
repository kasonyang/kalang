package com.kasonyang.kava.compiler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kava.opcode.Constant;
import kava.opcode.VarObject;

import com.kasonyang.kava.model.Attr;
import com.kasonyang.kava.runtime.ConstTable;
import com.kasonyang.kava.runtime.VarTable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.kasonyang.kava.antlr.*;
import com.kasonyang.kava.antlr.KavaParser.*;
import com.kasonyang.kava.ast.opcode.*;
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
	/**
	 * 
	 * @param name
	 * @param ret
	 * @param v1
	 * @param v2
	 * @return
	 */
	private Op autoOp(String name,Integer ret,Integer v1,Integer v2){
		String pre = getTypePrefix(varTb.get(v1).getType());
		String opname = pre + name;
		return new Op(OpType.valueOf(opname.toUpperCase()),ret,v1,v2);
	}
	
	private void assign(VarObject target,VarObject src){
		VarObject tmp;
		if(src.getType()!=target.getType()){
			tmp = this.castVar(src, target.getType());
		}else{
			tmp = src;
		}
		ops.add(autoOp("ASSIGN",target.getId(),tmp.getId(),null));
	}

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
		int cstId = constTb.create(cst);
		VarObject result = varTb.createTmp(varType);
		ops.add(new Op(OpType.LDC,result.getId(),cstId,null));
		return result;
	}
	
	public VarTable getVarTable(){
		return this.varTb;
	}
	
	public List<Op> getOpcodes(){
		return this.ops;
	}
	
	private OpType getOpTypeByString(String str,Integer type){
		HashMap<String,String> opt = new HashMap();
		opt.put("+","ADD");
		opt.put("-","SUB");
		opt.put("*","MUL");
		opt.put("/","DIV");
		opt.put("%","MOD");
		//opt.put("++", value);
		String opName = getTypePrefix(type) + opt.get(str);
		return OpType.valueOf(opName.toUpperCase());
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
	
	private OpType getCastOp(Integer type1,Integer type2){		
		String name=getTypePrefix(type1) + "2" + getTypePrefix(type2);
		return (OpType.valueOf(name.toUpperCase()));
	}
	
	private VarObject castVar(VarObject src,Integer destType){
		VarObject o1 = varTb.createTmp(destType);
		ops.add(new Op(this.getCastOp(src.getType(),destType),o1.getId(),src.getId(),null));
		return o1;
	}
	
	
	private VarObject getCmpResult(VarObject v1,VarObject v2){
		Integer retType;
		if(v1.getType() == v2.getType()){
			retType = v1.getType();
		}else{
			retType = VarObject.DOUBLE;
		}
		if(v1.getType()!=retType){
			v1 = this.castVar(v1, retType);
		}
		if(v2.getType()!=retType) v2 = this.castVar(v2, retType);
		VarObject result = varTb.createTmp(VarObject.INT);
		ops.add(autoOp("CMP",result.getId(),v1.getId(),v2.getId()));
		return result;
	}
	
	private VarObject getCalculateResult(String op,VarObject v1,VarObject v2){
		//String vType= "";
		Integer vType;
		switch(op){
		case "%":
			vType = VarObject.INT;
			break;
		case "+":
		case "-":
		case "*":
			if(v1.getType() == VarObject.INT && v2.getType() == VarObject.INT){
				vType = VarObject.INT;
			}else{
				vType = VarObject.DOUBLE;
			}
			break;
		case "/":
			vType = VarObject.DOUBLE;
			break;
		default:
			throw new CompilerException("unable to calculate!");
		}
		if(v1.getType() != vType){
			v1 = this.castVar(v1, vType);
		}
		if(v2.getType() != vType){
			v2 = this.castVar(v2, vType);
		}
		VarObject ret = varTb.createTmp(vType);
		OpType ot = this.getOpTypeByString(op,vType);
		ops.add(new Op(ot,ret.getId(),v1.getId(),v2.getId()));
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
		this.assign(at0,at1);
		//String name = 
		//ops.add(new Op(OpType.IASSIGN,at0.getId(),at1.getId(),null));
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
		int ret = varTb.create().getId();
		ops.add(new Op(OpType.INVOKE,ret,cstId,size));
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
			ops.add(new Op(OpType.PARAM,at.getValue(),null,null));
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
		ops.add(new Op(OpType.NOOP,null,null,null));
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
		Op op = new Op(OpType.IFFALSE,null,at.getId(),null);
		ops.add(op);
		visit(ctx.statList());
		Integer goVal = (int) ops.size();
		if(ctx.ifStatSuffix()!=null){
			goVal+=1;
			Op trueGoOp = new Op(OpType.GOTO,null,null,null);
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
		Op opIfF = new Op(OpType.IFFALSE,null,at.getId(),null);
		ops.add(opIfF);
		visit(ctx.statList());
		Op opGoto = new Op(OpType.GOTO,null,begin,null);
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
		ops.add(new Op(OpType.IFTRUE,null,at.getId(),begin));
		Integer end = ops.size();
		
		setGoto(clist,begin);
		setGoto(blist,end);
		this.continueList = clist;
		this.breakList = blist;
		return null;
	}

	private void setGoto(ArrayList<Op> list,Integer position){
		for(Op o:list){
			o.v1 = position;
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
		Op opIfF = new Op(OpType.IFFALSE,null,exAt.getId(),null);
		ops.add(opIfF);
		visit(ctx.statList());
		visit(ctx.forUpdate());
		ops.add(new Op(OpType.GOTO,null,begin,null));
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
		ops.add(autoOp("ASSIGN",result.getId(),at.getId(),null));
		int incDelta = ctx.INC() != null ? 1 : -1;
		ops.add(new Op(OpType.IINC,null,at.getId(),incDelta));
		return result;
	}
	@Override
	public VarObject visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
		VarObject at = visit(ctx.expression());
		VarObject result = varTb.createTmp(at.getType());
		int tmpVar = varTb.createTmp(at.getType()).getId();
		switch(ctx.getChild(0).getText()){
		case "-":
			ops.add(new Op(OpType.ICONST,tmpVar,0,null));
			ops.add(autoOp("SUB",result.getId(),tmpVar,at.getId()));
			//ops.add(new Op(OpType.a)
			break;
		case "--":
			ops.add(new Op(OpType.IINC,null,at.getId(),-1));
			ops.add(autoOp("ASSIGN",result.getId(),at.getId(),null));
			break;
		case "++":
			ops.add(new Op(OpType.IINC,null,at.getId(),1));
			ops.add(autoOp("ASSIGN",result.getId(),at.getId(),null));
			break;
		case "+":
			ops.add(autoOp("ASSIGN",result.getId(),at.getId(),null));
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
		OpType type;
		switch(ctx.getChild(1).getText()){
		case ">":type = OpType.IFGT;break;
		case "<":type = OpType.IFLT;break;
		case ">=":type = OpType.IFGE;break;
		case "<=":type = OpType.IFLE;break;
		case "==":type = OpType.IFEQ;break;
		case "!=":type = OpType.IFNE;break;
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
		//int tmpVar = varTb.createTmp(tmpType).getId();
		//ops.add(autoOp("SUB",tmpVar,at.getId(),at2.getId()));
		Op opIFGoto = new Op(type,null,tmpVar.getId(),null);
		ops.add(opIFGoto);
		ops.add(new Op(OpType.ICONST,result.getId(),0,null));
		Op opGoto = new Op(OpType.GOTO,null,null,null);
		ops.add(opGoto);
		opIFGoto.v2 = ops.size();
		ops.add(new Op(OpType.ICONST,result.getId(),1,null));
		opGoto.v1 = ops.size();
		return result;
	}
	@Override
	public VarObject visitBreakStat(BreakStatContext ctx) {
		Op op;
		ops.add(op = new Op(OpType.GOTO,null,null,null));
		breakList.add(op);
		return null;
	}
	@Override
	public VarObject visitContinueStat(ContinueStatContext ctx) {
		Op op;
		ops.add(op = new Op(OpType.GOTO,null,null,null));
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
			this.assign(var, eRet);
		}
		return null;
	}

}
