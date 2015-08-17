package kava.compiler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import jdk.nashorn.internal.codegen.types.Type;
import kava.antlr.*;
import kava.antlr.KavaParser.ArrayAssignContext;
import kava.antlr.KavaParser.DslChainStatContext;
import kava.antlr.KavaParser.DslExpressionContext;
//import kava.antlr.KavaParser.DslExpressionContext;
import kava.antlr.KavaParser.DslParamContext;
import kava.antlr.KavaParser.DslStatContext;
import kava.antlr.KavaParser.DslStatListContext;
import kava.antlr.KavaParser.DslVarDeclContext;
import kava.antlr.KavaParser.DslVarNewContext;
import kava.antlr.KavaParser.ExprGetArrayElementContext;
import kava.antlr.KavaParser.ExprGetFieldContext;
import kava.antlr.KavaParser.ExprLogicContext;
import kava.antlr.KavaParser.ExpressionContext;
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
	private HashMap<String,String> importedClassNames = new HashMap();
	private int paramCount = 0;
	
	public TheKavaVisitor(){
		super();
		//TODO init imported classes
		this.importedClassNames.put("System", "java/lang/System");
	}
	
	private boolean isClass(String name){
		return this.importedClassNames.containsKey(name);
	}
	
	private boolean isVar(String name){
		return varTb.contains(name);
	}

	private String getFullClassName(String id){
		return this.importedClassNames.get(id);
	}
	
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
    	VarObject vo = null;
    	if(varTb.contains(name)){
    		vo = varTb.get(name);
    	}else{
    		//throw new CompilerException(name + " is undefined");
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
		if(ctx.argumentList()!=null){
			this.visitArgumentList(ctx.argumentList());
		}
		return null;
	}

	@Override
	public VarObject visitArgumentList(ArgumentListContext ctx) {
		ArrayList<VarObject> list = new ArrayList();
		for(ExpressionContext e:ctx.expression()){
			VarObject v = visit(e);
			list.add(v);
		}
		for(VarObject i:list){
			addParam(i);
		}
		return null;
	}

	
	@Override
	public VarObject visitExprInvocation(ExprInvocationContext ctx) {
		int preParamCount = paramCount;
		paramCount = 0;
		String eText = ctx.expression().getText();
		String invName = ctx.Identifier().getText();
		VarObject ret = varTb.createTmp();
		if(this.isClass(eText)){
			String className = this.getFullClassName(eText);
			String methodName = this.getClassAttribute(className, invName);
			visit(ctx.arguments());
			Constant m = constTb.createConst(methodName);
			ops.add(new INVOKE_STATIC(ret,m,paramCount));
		}else{
			VarObject var = visit(ctx.expression());
			//String methodName = this.getClassAttribute(invName);
			addParam(var);
			Constant m = constTb.createConst(invName);
			visit(ctx.arguments());
			ops.add(new INVOKE_DYNAMIC(ret,m,paramCount));
		}
		paramCount = preParamCount;
		return ret;
	}

	@Override
	public VarObject visitStart(StartContext ctx) {
		if(ctx.dslStatList() != null){
			visit(ctx.dslStatList());
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

	@Override
	public VarObject visitDslStatList(DslStatListContext ctx) {
		if(ctx.dslStat()!=null){
			for(DslStatContext s:ctx.dslStat()){
				visit(s);
			}
		}
		return null;
	}

	@Override
	public VarObject visitDslStat(DslStatContext ctx) {
		VarObject v = visit(ctx.dslExpr());
		//TODO create object
		//VarObject id = visit(ctx.Identifier())
		return null;
	}

	@Override
	public VarObject visitDslVarDecl(DslVarDeclContext ctx) {
		VarObject ret = new VarObject();
		//TODO ret.className = ctx.getText();
		return ret;
	}

	@Override
	public VarObject visitDslVarNew(DslVarNewContext ctx) {
		VarObject ret = new VarObject();
		//TODO create var
		return null;
	}


	private void addParam(VarObject v){
		ops.add(new PARAM(v));
		paramCount++;
	}
	
	@Override
	public VarObject visitDslChainStat(DslChainStatContext ctx) {
		List<TerminalNode> ids = ctx.Identifier();
		Iterator<TerminalNode> iter = ids.iterator();
		Iterator<DslParamContext> piter = ctx.dslParam().iterator();
		VarObject obj = null;
		while(iter.hasNext()){
			int preParamCount = paramCount;
			paramCount = 0;
			Constant methodCst = constTb.createConst(iter.next().toString());
			DslParamContext param = piter.next();
			if(obj==null){
				obj = varTb.createTmp();
				ops.add(new NEW(obj,methodCst));
				addParam(obj);
				visit(param);
				//Constant init = constTb.createConst("<init>");
				//ops.add(new INVOKE_SPECIAL(varTb.createTmp(),init,paramCount));
			}else{
				addParam(obj);
				visit(param);
				ops.add(new INVOKE_VIRTUAL(varTb.createTmp(),methodCst,paramCount));
			}
			paramCount = preParamCount;
		}
		int prePCount = paramCount;
		VarObject ret = varTb.createTmp();
		addParam(obj);
		//TODO repare end method
		ops.add(new INVOKE_VIRTUAL(ret,constTb.createConst("end"),paramCount));
		paramCount = prePCount;
		return ret;
	}

	@Override
	public VarObject visitDslParam(DslParamContext ctx) {
		for(ExpressionContext e:ctx.expression()){
			VarObject ev = visit(e);
			addParam(ev);
		}
		return null;
	}
	
	private String getClassAttribute(String fullClsName,String attrName){
		return fullClsName + "." + attrName;
	}
	
	@Override
	public VarObject visitExprGetField(ExprGetFieldContext ctx) {
		String eText = ctx.expression().getText();
		String fieldName = ctx.Identifier().getText();
		VarObject ret = varTb.createTmp();
		if(isClass(eText)){
			String cName = this.getFullClassName(eText);
			Constant m = constTb.createConst(this.getClassAttribute(cName, fieldName));
			ops.add(new GET_STATIC(ret,m));
		}else if(isVar(eText)){
			VarObject instance = varTb.get(eText);
			String fName = this.getClassAttribute(instance.className,fieldName);
			Constant f = constTb.createConst(fName);
			ops.add(new GET_FIELD(ret,instance,f));
		}
		return ret;
	}

	@Override
	public VarObject visitDslExpression(DslExpressionContext ctx) {
		visit(ctx.expression());
		// TODO Auto-generated method stub
		return null;
	}
}
