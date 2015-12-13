package kalang.compiler;

import jast.ast.CastExpr;
import jast.ast.ClassExpr;
import jast.ast.ClassNode;
import jast.ast.ExprNode;
import jast.ast.InvocationExpr;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

@groovy.transform.TypeChecked
class TypeSystem {
	
	public static final String FLOAT_CLASS = "java.lang.Float";
	public static final String DOUBLE_CLASS = "java.lang.Double";

	public static final String INT_CLASS = "java.lang.Integer";
	public static final String LONG_CLASS = "java.lang.Long";

	public static final String BOOLEAN_CLASS = "java.lang.Boolean";

	public static final String CHAR_CLASS = "java.lang.Character";

	public static final String STRING_CLASS = "java.lang.String";


	public static final String VOID_CLASS = "java.lang.Void";
	
	public static final String SHORT_CLASS = "java.lang.Short";
	
	public static final String BYTE_CLASS = "java.lang.Byte";
	
	public static final String ROOT_CLASS = "java.lang.Object";
			
	private BidiMap<String,String> primitive2class;
	
	private String[] numberClass = new String[]{INT_CLASS,LONG_CLASS,FLOAT_CLASS,DOUBLE_CLASS};
	
	private String[] numberPrimitive =new String[]{"int","long","float","double"};

	AstLoader astLoader;
	
	TypeSystem(AstLoader astLoader){
		BidiMap<String,String> m = primitive2class = new TreeBidiMap();
		m.put("int"    , INT_CLASS       );
		m.put("long"   , LONG_CLASS      );
		m.put("float"  , FLOAT_CLASS     );
		m.put("double" , DOUBLE_CLASS    );
		m.put("char"   , CHAR_CLASS      );
		m.put("boolean", BOOLEAN_CLASS   );
		m.put("void"   , VOID_CLASS      );
		m.put("short"  , SHORT_CLASS     );
		m.put("byte"   , BYTE_CLASS      );
		m.put("null"   , "null"          );//TODO does null has class type?
		this.astLoader = astLoader;
	}
	
	boolean isPrimitiveType(String type){
		if(type.endsWith("[]")) type = type.substring(0,type.length()-2);
		return primitive2class.containsKey(type);
	}
	
	String classifyType(String from){
		String ret = primitive2class.get(from);
		if(ret==null) return from;
		return ret;
	}

	boolean hasPrimitiveType(String type){
		return this.primitive2class.containsValue(type);
	}
	
	String getPrimitiveType(String type){
		String k = primitive2class.getKey(type);
		if(k==null) return type;
		return k;
	}
	
	String[] getPrimitiveTypes(){
		return (String[]) primitive2class.values().toArray();
	}
	
	private boolean primitiveCastable(String from,String to){
		to = classifyType(to);
		from = classifyType(from);
		if(from==to) return true;
		HashMap<String,List> baseMap = new HashMap();
		baseMap.put(INT_CLASS ,Arrays.asList(new String[]{LONG_CLASS, FLOAT_CLASS, DOUBLE_CLASS}));
		baseMap.put(LONG_CLASS  ,Arrays.asList(new String[]{FLOAT_CLASS, DOUBLE_CLASS}));
		baseMap.put(FLOAT_CLASS ,Arrays.asList(new String[]{DOUBLE_CLASS}));
		baseMap.put(DOUBLE_CLASS  , new LinkedList());
		if(baseMap.containsKey(from)){
			return baseMap.get(from).contains(to);
		}
		return false;
	}

	/*boolean castable(List<String> from,List<String> to){
		if(from.size()!=to.size())  return false
		for(int i=0;i<from.size();i++){
			def f = from.get(i)
			def t = to.get(i)
			if(!castable(f,t)){
				return false
			}
		}
		return true
	}*/
	
	boolean isNumberPrimitive(String type){
		return Arrays.asList(this.numberPrimitive).contains(type);
	}

	boolean isNumberClass(String type){
		return Arrays.asList(this.numberClass).contains(type);
	}
	
	boolean isNumber(String type){
		return this.isNumberPrimitive(type)||this.isNumberClass(type);
	}

	boolean isBoolean(String type){
		return type == BOOLEAN_CLASS || type == "boolean";
	}

	String getHigherType(String type1,String type2){
		if(type1==DOUBLE_CLASS || type2==DOUBLE_CLASS) return DOUBLE_CLASS;
		if(type1==FLOAT_CLASS || type2 ==FLOAT_CLASS) return FLOAT_CLASS;
		if(type1==LONG_CLASS || type2==LONG_CLASS) return LONG_CLASS;
		return INT_CLASS;
	}
	
	boolean isSubclass(String type,String subclassType) throws AstNotFoundException{
		if(isPrimitiveType(type)) return false;
		ClassNode fromAst = astLoader.loadAst(type);
		while(fromAst!=null){
			String parent = fromAst.parentName;
			if(parent==null) return false;
			if(parent==subclassType) return true;
			fromAst = astLoader.loadAst(parent);
		}
		return false;
	}
	
	ExprNode cast(ExprNode expr,String fromType,String toType) throws AstNotFoundException{
		int t = this.getCastMethod(fromType,toType);
		if(t == CAST_NOTHING){
			return this.castNothing(expr, fromType, toType);
		}else if(t==this.CAST_OBJECT_TO_PRIMITIVE){
			return this.castObject2Primitive(expr, fromType, toType);
		}else if(t==this.CAST_PRIMITIVE){
			return this.castPrimitive(expr, fromType, toType);
		}else if(t==this.CAST_PRIMITIVE_TO_OBJECT){
			return this.castPrimitive2Object(expr, fromType, toType);
		}else{
			throw new RuntimeException("unknown cast type");
		}
	}
	
	boolean castable(String fromType,String toType) throws AstNotFoundException{
		return getCastMethod(fromType,toType)>0;
	}
	
	private int getCastMethod(String fromType,String toType) throws AstNotFoundException{
		if(fromType==toType) return this.CAST_NOTHING;
		if(isPrimitiveType(fromType)){
			if(isPrimitiveType(toType)){
				if(this.primitiveCastable(fromType,toType)){
					return this.CAST_PRIMITIVE;
				}
			}else{
				if(toType==ROOT_CLASS) return this.CAST_PRIMITIVE_TO_OBJECT;
				if(fromType=="null") return this.CAST_NOTHING;
				String toPriType = getPrimitiveType(toType);
				if(toPriType == fromType){
					return this.CAST_PRIMITIVE_TO_OBJECT;
				}
			}
		}else{
			if(isPrimitiveType(toType)){
				String fromPrimitive = getPrimitiveType(fromType);
				if(fromPrimitive==toType){
					return this.CAST_OBJECT_TO_PRIMITIVE;
				}
			}else{
				if(isSubclass(fromType,toType)) return this.CAST_NOTHING;
			}
		}
		return -1;
	}
	
	final int CAST_PRIMITIVE = 1,
			CAST_PRIMITIVE_TO_OBJECT = 2,
			CAST_OBJECT_TO_PRIMITIVE = 3,
			CAST_NOTHING = 4;
	
	private ExprNode castPrimitive(ExprNode expr,String fromType,String toType){
		return new CastExpr(toType,expr);
	}
	
	private ExprNode castPrimitive2Object(ExprNode expr,String fromType,String toType){
		String classType = this.classifyType(fromType);
		return new InvocationExpr(new ClassExpr(classType),"valueOf",Arrays.asList(new ExprNode[]{expr}));
	}
	
	private ExprNode castObject2Primitive(ExprNode expr,String fromType,String toType){
            InvocationExpr inv = new InvocationExpr();
            inv.target = expr;
            inv.methodName = toType + "Value";
            return inv;
	}
	
	private ExprNode castNothing(ExprNode expr,String fromType,String toType){
		return expr;
	}
	
}
