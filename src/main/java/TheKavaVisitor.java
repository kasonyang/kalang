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
import com.kasonyang.kava.antlr.KavaParser.DoWhileStatContext;
import com.kasonyang.kava.antlr.KavaParser.ExprInvocationContext;
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
		Long varId = varTb.create(vo);
		Long constId = constTb.create(value);
		ops.add(new Op(OpType.LCONST,varId,constId,-1));
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
		long vo1 = attr1.getValue();
		long vo2 = attr2.getValue();
		VarObject voR = new VarObject();
		voR.setType("mixed");
		long ret = varTb.create(voR);
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
		ops.add(new Op(OpType.ASSIGN,at0.getValue(),at1.getValue(),-1));
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
    	long idInt;
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
		long size = at.getValue();
		VarObject vo = new VarObject();
		vo.setValue(invName);
		long invId = varTb.create(vo);
		long ret = varTb.create();
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
			ops.add(new Op(OpType.PARAM,at.getValue(),-1,-1));
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
			return visit(ctx.statList());
		}
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
		Op op = new Op(OpType.IFFALSE,-1,at.getValue(),-1);
		ops.add(op);
		visit(ctx.statList());
		Long goVal = (long) ops.size();
		if(ctx.ifStatSuffix()!=null){
			goVal+=1;
			Op trueGoOp = new Op(OpType.GOTO,-1,-1,-1);
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
		Long begin = (long) ops.size();
		Attr at = visit(ctx.expression());
		Op opIfF = new Op(OpType.IFFALSE,-1,at.getValue(),-1);
		ops.add(opIfF);
		visit(ctx.statList());
		Op opGoto = new Op(OpType.GOTO,-1,begin,-1);
		ops.add(opGoto);
		opIfF.v2 = ops.size();
		return null;
	}

	@Override
	public Attr visitDoWhileStat(DoWhileStatContext ctx) {
		Long begin = (long) ops.size();
		visit(ctx.statList());
		Attr at = visit(ctx.expression());
		ops.add(new Op(OpType.IFTRUE,-1,at.getValue(),begin));
		return null;
	}

	@Override
	public Attr visitForStat(ForStatContext ctx) {
		if(ctx.forInit()!=null) visit(ctx.forInit());
		Long begin = (long) ops.size();
		Attr exAt = visit(ctx.expression());
		Op opIfF = new Op(OpType.IFFALSE,-1,exAt.getValue(),-1);
		ops.add(opIfF);
		visit(ctx.statList());
		visit(ctx.forUpdate());
		ops.add(new Op(OpType.GOTO,-1,begin,-1));
		opIfF.v2 = ops.size();
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

}
