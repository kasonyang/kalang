package kalang.compiler

import java.util.List;

@groovy.transform.TypeChecked
class CastSystem {
	
	private static final String FLOAT_CLASS = "java.lang.Float";
	private static final String DOUBLE_CLASS = "java.lang.Double";

	private static final String INT_CLASS = "java.lang.Integer";
	private static final String LONG_CLASS = "java.lang.Long";

	private static final String BOOLEAN_CLASS = "java.lang.Boolean";

	private static final String CHAR_CLASS = "java.lang.Character";

	private static final String STRING_CLASS = "java.lang.String";

	private static final String NULL_CLASS = "java.lang.NullObject";

	private static final String DEFAULT_CLASS = "java.lang.Object";
		
	AstLoader astLoader
	
	public CastSystem(AstLoader astLoader){
		this.astLoader = astLoader
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
	
	private  boolean castable(String from,String to){
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
	
}
