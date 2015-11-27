package compilier

import jast.ast.AbstractAstVisitor
import jast.ast.AssignExpr;
import jast.ast.AstNode
import jast.ast.AstVisitor
import jast.ast.BinaryExpr;
import jast.ast.CastExpr;
import jast.ast.ClassExpr;
import jast.ast.ClassNode
import jast.ast.ConstExpr;
import jast.ast.ElementExpr;
import jast.ast.FieldExpr;
import jast.ast.InvocationExpr;
import jast.ast.MethodNode
import jast.ast.NewExpr;
import jast.ast.ParameterExpr;
import jast.ast.ParameterNode;
import jast.ast.UnaryExpr;
import jast.ast.VarDeclStmt;
import jast.ast.VarExpr;
import kalang.core.FieldObject
import kalang.core.VarObject
@groovy.transform.TypeChecked
class TypeChecker extends AstVisitor<String> {

	private static final String FLOAT_CLASS = "java.lang.Float";
	private static final String DOUBLE_CLASS = "java.lang.Double";

	private static final String INT_CLASS = "java.lang.Integer";
	private static final String LONG_CLASS = "java.lang.Long";

	private static final String BOOLEAN_CLASS = "java.lang.Boolean";

	private static final String CHAR_CLASS = "java.lang.Character";

	private static final String STRING_CLASS = "java.lang.String";

	private static final String NULL_CLASS = "java.lang.NullObject";

	private static final String DEFAULT_CLASS = "java.lang.Object";


	@Override
	public String visitCastExpr(CastExpr node) {
		node.type
	}

	static class TypeError extends Exception{
		AstNode node

		public TypeError(String msg,AstNode node){
			super(msg)
			this.node = node
		}
	}

	HashMap<AstNode,String> types = [:]
	//HashMap<AstNode,VarObject> vars
	HashMap<String,String> fieldTypes

	AstLoader astLoader

	ClassNode clazz

	TypeChecker(AstLoader astLoader){
		this.astLoader = astLoader
	}

	private void fail(String str,AstNode node){
		throw new TypeError(str,node);
	}

	public void check(ClassNode clz){
		this.fieldTypes = [:]
		for(def f in clz.fields){
			this.fieldTypes.put(f.name,f.type)
		}
		this.clazz = clz
		visit(clazz)
	}

	private void checkCastable(String from,String to,AstNode node){
		if(!castable(from,to)){
			fail("can not cast type:${from} => ${to}",node)
		}
	}

	@Override
	public String visitAssignExpr(AssignExpr node) {
		String ft = visit(node.from);
		String tt = visit(node.to);
		checkCastable(ft,tt,node);
		return tt
	}

	static private String getClassType(String from){
		if(from=="int") from=INT_CLASS
		if(from=="long") from = LONG_CLASS
		if(from=="float") from = FLOAT_CLASS
		if(from=="double") from = DOUBLE_CLASS
		return from
	}

	static private String getPrimaryType(String type){
		if(type==INT_CLASS) return "int"
		if(type==LONG_CLASS) return "long"
		if(type==FLOAT_CLASS) return "float"
		if(type==DOUBLE_CLASS) return "double"
		return type
	}

	private String getMathType(String t1,String t2,String op){
		def pt1 = getPrimaryType(t1)
		def pt2 = getPrimaryType(t2)
		def ret = MathType.getType(pt1,pt2,op)
		return getClassType(ret)
	}

	static private boolean isNumber(String type){
		def numTypes = [INT_CLASS, LONG_CLASS, FLOAT_CLASS, DOUBLE_CLASS]
		return numTypes.contains(type)
	}

	static private boolean isBoolean(String type){
		return type ==BOOLEAN_CLASS
	}

	static String getHigherType(String type1,String type2){
		if(type1==DOUBLE_CLASS || type2==DOUBLE_CLASS) return DOUBLE_CLASS
		if(type1==FLOAT_CLASS || type2 ==FLOAT_CLASS) return FLOAT_CLASS
		if(type1==LONG_CLASS || type2==LONG_CLASS) return LONG_CLASS
		return INT_CLASS
	}


	@Override
	public String visitBinaryExpr(BinaryExpr node) {
		String t1 = getClassType(visit(node.expr1).toString())
		String t2 = getClassType(visit(node.expr2).toString())
		String op = node.operation
		String t;
		switch(op){
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
				if(!isNumber(t1)||!isNumber(t2)){
					fail("number required!",node);
				}
				t = getMathType(t1,t2,op);
				break;
			case ">=":
			case "<=":
			case "==":
			case ">":
			case "<":
				if(!isNumber(t1)||!isNumber(t2)){
					fail("number required!",node)
				}
				t = BOOLEAN_CLASS
				break;
			case "&&":
			case "||":
				if(!isBoolean(t1)||!isBoolean(t2)){
					fail("Boolean type required!",node)
				}
				t = BOOLEAN_CLASS
				break;
			case "&":
			case "|":
			case "^":
				if(!isNumber(t1)||!isNumber(t2)){
					fail("number required!",node)
				}
				t = getHigherType(t1,t2)
				break;
			default:
				throw new TypeError("unsupport operation:${op}",node);
		}
		return t;
	}

	@Override
	public String visitConstExpr(ConstExpr node) {
		return getClassType(node.type)
	}

	@Override
	public String visitElementExpr(ElementExpr node) {
		String type = visit(node.target)
		if(!type.endsWith("[]")){
			fail("Array type required",node)
		}
		return type.substring(0,type.length()-2)
	}

	@Override
	public String visitFieldExpr(FieldExpr node) {
		return this.fieldTypes.get(node.fieldName)
	}

	@Override
	public String visitInvocationExpr(InvocationExpr node) {
		List types = visit(node.arguments);
		String target = node.target?visit(node.target):this.clazz.name;
		String methodName = node.methodName;
		ClassNode ast = astLoader.getAst(target);
		if(ast==null){
			fail("no class:"+target ,node)
		}
		MethodNode method = ensureHasMethod(ast,methodName,types)
		if(method==null){
			def ps = types.join(",")
			String mdesc = "${ast.name}.${methodName}(${ps})"
			fail("no method:${mdesc}",node);
		}
		return method.type
	}



	private boolean castable(String from,String to){
		to = getClassType(to)
		from = getClassType(from)
		if(from==to) return true
		HashMap<String,List> baseMap = [:]
		baseMap.put(INT_CLASS , [LONG_CLASS, FLOAT_CLASS, DOUBLE_CLASS])
		baseMap.put(LONG_CLASS  , [FLOAT_CLASS, DOUBLE_CLASS])
		baseMap.put(FLOAT_CLASS  , [DOUBLE_CLASS])
		baseMap.put(DOUBLE_CLASS  , [])
		if(baseMap.containsKey(from)){
			return baseMap.get(from).contains(to)
		}
		def fromAst = astLoader.loadAst(from)
		while(fromAst){
			def parent = fromAst.parentName
			if(!parent) return false;
			if(parent==to) return true;
			fromAst = astLoader.loadAst(parent)
		}
		return false;
	}

	private boolean castable(List<String> from,List<String> to){
		if(from.size()!=to.size())  return false
		for(int i=0;i<from.size();i++){
			def f = from.get(i)
			def t = to.get(i)
			if(!castable(f,t)){
				return false
			}
		}
		return true
	}

	private MethodNode ensureHasMethod(ClassNode ast,String name,List types){
		def methods = ast.methods
		for(def m in methods){
			if(m.name!=name) continue
				def ps = m.parameters
			def mtypes = []
			for(def p in ps){
				mtypes.add(p.type)
			}
			if(this.castable(types,mtypes)){
				return m
			}
		}
		return null
	}

	@Override
	public String visitParameterExpr(ParameterExpr node) {
		node.parameter.type
	}

	@Override
	public String visitUnaryExpr(UnaryExpr node) {
		def preOp = node.preOperation
		String et = visit(node.expr)
		if(preOp=="!"){
			if(!isBoolean(et)){
				fail("boolean required!",node)
			}
		}
		return et;
	}

	@Override
	public String visitVarExpr(VarExpr node) {
		node.declStmt.type
	}

	@Override
	public String visitClassExpr(ClassExpr node) {
		return node.name
	}

	@Override
	public String visitNewExpr(NewExpr node) {
		return node.type
	}

	@Override
	public String visitVarDeclStmt(VarDeclStmt node) {
		//Type infer
		if(node.type==null){
			if(node.initExpr){
				node.type = visit(node.initExpr)
			}else{
				node.type = DEFAULT_CLASS
			}
		}
	}

}
