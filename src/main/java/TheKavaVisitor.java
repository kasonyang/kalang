import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kasonyang.kava.model.Attr;
import com.kasonyang.kava.model.VarObject;
import com.kasonyang.kava.runtime.ConstTable;
import com.kasonyang.kava.runtime.VarTable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.kasonyang.kava.antlr.*;
import com.kasonyang.kava.antlr.KavaParser.ArgumentListContext;
import com.kasonyang.kava.antlr.KavaParser.ArgumentsContext;
import com.kasonyang.kava.antlr.KavaParser.BreakStatContext;
import com.kasonyang.kava.antlr.KavaParser.ContinueStatContext;
import com.kasonyang.kava.antlr.KavaParser.DoWhileStatContext;
import com.kasonyang.kava.antlr.KavaParser.ExprInvocationContext;
//import com.kasonyang.kava.antlr.KavaParser.ExprLogicEqCmpContext;
//import com.kasonyang.kava.antlr.KavaParser.ExprLogicLgCmpContext;
import com.kasonyang.kava.antlr.KavaParser.ExprNotOpContext;
import com.kasonyang.kava.antlr.KavaParser.ExprSelfOpContext;
import com.kasonyang.kava.antlr.KavaParser.ExprSelfOpPreContext;
import com.kasonyang.kava.antlr.KavaParser.ExprStatContext;
import com.kasonyang.kava.antlr.KavaParser.ExpressionContext;
import com.kasonyang.kava.antlr.KavaParser.ExpressionListContext;
import com.kasonyang.kava.antlr.KavaParser.ForInitContext;
import com.kasonyang.kava.antlr.KavaParser.ForStatContext;
import com.kasonyang.kava.antlr.KavaParser.ForUpdateContext;
//import com.kasonyang.kava.antlr.KavaParser.ExpressionListContext;
//import com.kasonyang.kava.antlr.KavaParser.ExpressionsContext;
import com.kasonyang.kava.antlr.KavaParser.GenericInvocationContext;
import com.kasonyang.kava.antlr.KavaParser.IfStatContext;
import com.kasonyang.kava.antlr.KavaParser.IfStatSuffixContext;
import com.kasonyang.kava.antlr.KavaParser.StartContext;
import com.kasonyang.kava.antlr.KavaParser.StatContext;
import com.kasonyang.kava.antlr.KavaParser.StatListContext;
import com.kasonyang.kava.antlr.KavaParser.WhileStatContext;
import com.kasonyang.kava.antlr.KavaParser.*;
import com.kasonyang.kava.ast.opcode.*;
/**
 *
 * @author KasonYang
 */
public class TheKavaVisitor extends AbstractParseTreeVisitor<Attr> implements KavaVisitor<Attr> {

	private ConstTable constTb = new ConstTable();
	private VarTable varTb = new VarTable();
	private String code = "";
	private ArrayList<Op> ops = new ArrayList();
	private int paramCounter = 0;
	private ArrayList<Op> continueList = new ArrayList<Op>();
	private ArrayList<Op> breakList = new ArrayList<Op>();
	
	public ConstTable getConstTable(){
		return constTb;
	}
	public void op(String op,Object v1,Object v2,Object vr){
		code += op + " @" + v1 + " @" + v2 + "->@" + vr + "\n";
	}

	@Override
	public Attr visitLiteral(LiteralContext ctx) {
		Attr attr = new Attr();
		//VarObject var = new VarObject();
		//attr.setLvalue("");
		//attr.setRvalue(ctx.getText());
		String valText = ctx.getText();
		VarObject vo = new VarObject();
		//vo.setValue(val);
		//attr.setType('const');
        TerminalNode tn = (TerminalNode) ctx.children.get(0);
		String type = "";
		Object value = null;
        int typeInt = tn.getSymbol().getType();
		switch(typeInt){
		case KavaParser.IntegerLiteral:
			type = "int";
			value=Integer.parseInt(valText);
			break;
		case KavaParser.FloatingPointLiteral:
			type = "float";
			value = Float.parseFloat(valText);
			break;
		case KavaParser.CharacterLiteral:
			type = "char";
			value = valText.charAt(1);
			break;
		case KavaParser.StringLiteral:
			type = "String";
			//TODO decode needed
			value = valText;
			break;
		case KavaParser.NullLiteral:
			type = "null";
			value = null;
			break;
		}
		vo.setType(type);
		Integer varId = varTb.create(vo);
		//Integer constId = constTb.create(value);
		ops.add(new Op(OpType.ICONST,varId,(Integer)value,null));
		attr.setValue(varId);
		//attr.setType("const");
		//var.setIsConst(true);
		return attr;
	}

	public String getCode(){
		return this.code;
	}
	
	public VarTable getVarTable(){
		return this.varTb;
	}
	
	public List<Op> getOpcodes(){
		return this.ops;
	}
	
	private OpType getOpTypeByString(String str){
		HashMap<String,OpType> opt = new HashMap();
		opt.put("+",OpType.ADD);
		opt.put("-",OpType.SUB);
		opt.put("*",OpType.MUL);
		opt.put("/",OpType.DIV);
		opt.put("%",OpType.MOD);
		//opt.put("++", value);
		return opt.get(str);
	}
	
	@Override
	public Attr visitExprPrimay(ExprPrimayContext ctx) {
		return visit(ctx.primary());
	}
	@Override
	public Attr visitExprMidOp(ExprMidOpContext ctx) {
		Attr at = new Attr();
		Attr attr1 =this.visit(ctx.expression(0));
		Attr attr2 = this.visit(ctx.expression(1));
		int vo1 = attr1.getValue();
		int vo2 = attr2.getValue();
		VarObject voR = new VarObject();
		voR.setType("mixed");
		int ret = varTb.create(voR);
		String opStr = ctx.getChild(1).getText();
		OpType ot = this.getOpTypeByString(opStr);
		ops.add(new Op(ot,ret,vo1,vo2));
		//op(opStr,vo1,vo2,ret);
		at.setValue(ret);
		return at;
	}
	@Override
	public Attr visitExprAssign(ExprAssignContext ctx) {
		Attr at1 = visit(ctx.expression(1));
		Attr at0 = visit(ctx.expression(0));
		ops.add(new Op(OpType.ASSIGN,at0.getValue(),at1.getValue(),null));
		Attr attr = new Attr();
		attr.setValue(at0.getValue());
		return attr;
	}
	
	@Override
	public Attr visitPrimayParen(PrimayParenContext ctx) {
		return visit(ctx.expression());
	}
	@Override
	public Attr visitPrimaryLiteral(PrimaryLiteralContext ctx) {
		return visit(ctx.literal());
	}
	@Override
	public Attr visitPrimaryIdentifier(PrimaryIdentifierContext ctx) {
		Attr attr = new Attr();
		String name = ctx.Identifier().getText();
    	int idInt;
    	if(varTb.contains(name)){
    		idInt = varTb.getId(name);
    	}else{
    		idInt = varTb.create(name);
    	} 
    	attr.setValue(idInt);
    	return attr;
	}

	/*
	@Override
	public Attr visitExpressions(ExpressionsContext ctx) {
		if(ctx.expression() != null){
			for(ExpressionContext e:ctx.expression()){
				visit(e);
			}
		}
		return new Attr();
	}
	*/

	@Override
	public Attr visitGenericInvocation(GenericInvocationContext ctx) {
		String invName = ctx.Identifier().getText();
		Attr at = visit(ctx.arguments());
		int size = at.getValue();
		VarObject vo = new VarObject();
		vo.setValue(invName);
		int invId = varTb.create(vo);
		int ret = varTb.create();
		ops.add(new Op(OpType.INVOKE,ret,invId,size));
		return new Attr(ret);
	}

	@Override
	public Attr visitArguments(ArgumentsContext ctx) {
		Attr attr = new Attr();
		if(ctx.argumentList() != null){
			Attr at = visit(ctx.argumentList());
			attr.setValue(at.getValue());
		}else{
			attr.setValue(0);
		}
		return attr;
	}

	@Override
	public Attr visitArgumentList(ArgumentListContext ctx) {
		int paramCount = 0;
		for(ExpressionContext e:ctx.expression()){
			Attr at = visit(e);
			paramCount++;
			ops.add(new Op(OpType.PARAM,at.getValue(),null,null));
		}
		Attr attr= new Attr();
		attr.setValue(paramCount);
		return attr;
	}

	@Override
	public Attr visitExprInvocation(ExprInvocationContext ctx) {
		return visit(ctx.genericInvocation());
	}

	@Override
	public Attr visitStart(StartContext ctx) {
		if(ctx.statList() != null){
			visit(ctx.statList());
		}
		ops.add(new Op(OpType.NOOP,null,null,null));
		return null;
	}

	@Override
	public Attr visitStatList(StatListContext ctx) {
		if(ctx.stat()!=null){
			for(StatContext s:ctx.stat()){
				visit(s);
			}
		}
		return null;
	}

	@Override
	public Attr visitIfStat(IfStatContext ctx) {
		Attr at = visit(ctx.expression());
		Op op = new Op(OpType.IFFALSE,null,at.getValue(),null);
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
	public Attr visitStat(StatContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Attr visitExprStat(ExprStatContext ctx) {
		visit(ctx.expression());
		return null;
	}

	@Override
	public Attr visitIfStatSuffix(IfStatSuffixContext ctx) {
		visit(ctx.statList());
		return null;
	}

	@Override
	public Attr visitWhileStat(WhileStatContext ctx) {
		ArrayList<Op> bList,cList;
		bList = this.breakList;
		cList = this.continueList;
		
		Integer begin = (int) ops.size();
		Attr at = visit(ctx.expression());
		Op opIfF = new Op(OpType.IFFALSE,null,at.getValue(),null);
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
	public Attr visitDoWhileStat(DoWhileStatContext ctx) {
		ArrayList<Op> clist,blist;
		clist = this.continueList;
		blist = this.breakList;
		
		Integer begin = (int) ops.size();
		visit(ctx.statList());
		Attr at = visit(ctx.expression());
		ops.add(new Op(OpType.IFTRUE,null,at.getValue(),begin));
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
	public Attr visitForStat(ForStatContext ctx) {
		ArrayList<Op> bList,cList;
		bList= this.breakList;
		cList = this.continueList;
		
		if(ctx.forInit()!=null) visit(ctx.forInit());
		Integer begin = (int) ops.size();
		Attr exAt = visit(ctx.expression());
		Op opIfF = new Op(OpType.IFFALSE,null,exAt.getValue(),null);
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
	public Attr visitForInit(ForInitContext ctx) {
		visit(ctx.expressionList());
		return null;
	}

	@Override
	public Attr visitForUpdate(ForUpdateContext ctx) {
		visit(ctx.expressionList());
		return null;
	}

	@Override
	public Attr visitExpressionList(ExpressionListContext ctx) {
		for(ExpressionContext e:ctx.expression()){
			visit(e);
		}
		return null;
	}
	@Override
	public Attr visitExprNotOp(ExprNotOpContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Attr visitExprSelfOp(ExprSelfOpContext ctx) {
		Attr at = visit(ctx.expression());
		VarObject vo = new VarObject();
		int result = varTb.create(vo);
		ops.add(new Op(OpType.ASSIGN,result,at.getValue(),null));
		int incDelta = ctx.INC() != null ? 1 : -1;
		ops.add(new Op(OpType.IINC,null,at.getValue(),incDelta));
		return new Attr(result);
	}
	@Override
	public Attr visitExprSelfOpPre(ExprSelfOpPreContext ctx) {
		Attr at = visit(ctx.expression());
		int result = varTb.create();
		int tmpVar = varTb.create();
		switch(ctx.getChild(0).getText()){
		case "-":
			ops.add(new Op(OpType.ICONST,tmpVar,0,null));
			ops.add(new Op(OpType.SUB,result,tmpVar,at.getValue()));
			//ops.add(new Op(OpType.a)
			break;
		case "--":
			ops.add(new Op(OpType.IINC,null,at.getValue(),-1));
			ops.add(new Op(OpType.ASSIGN,result,at.getValue(),null));
			break;
		case "++":
			ops.add(new Op(OpType.IINC,null,at.getValue(),1));
			ops.add(new Op(OpType.ASSIGN,result,at.getValue(),null));
			break;
		case "+":
			ops.add(new Op(OpType.ASSIGN,result,at.getValue(),null));
			break;
		default:
			throw new RuntimeException("未识别的操作符！");
		}
		return new Attr(result);
	}
	
	@Override
	public Attr visitExprLogicCmp(ExprLogicCmpContext ctx) {
		Attr at = visit(ctx.expression(0));
		Attr at2 = visit(ctx.expression(1));
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
		int result = varTb.create();
		int tmpVar = varTb.create();
		ops.add(new Op(OpType.SUB,tmpVar,at.getValue(),at2.getValue()));
		Op opIFGoto = new Op(type,null,tmpVar,null);
		ops.add(opIFGoto);
		ops.add(new Op(OpType.ICONST,result,0,null));
		Op opGoto = new Op(OpType.GOTO,null,null,null);
		ops.add(opGoto);
		opIFGoto.v2 = ops.size();
		ops.add(new Op(OpType.ICONST,result,1,null));
		opGoto.v1 = ops.size();
		return new Attr(result);
	}
	@Override
	public Attr visitBreakStat(BreakStatContext ctx) {
		Op op;
		ops.add(op = new Op(OpType.GOTO,null,null,null));
		breakList.add(op);
		return null;
	}
	@Override
	public Attr visitContinueStat(ContinueStatContext ctx) {
		Op op;
		ops.add(op = new Op(OpType.GOTO,null,null,null));
		continueList.add(op);
		return null;
	}

}
