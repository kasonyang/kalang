package kava.compiler4j

class JavaType {
	
	private static Map primitiveDesc = [
		'boolean':'Z',
		'char':'C',
		'byte':'B',
		'short':'S',
		'int':'I',
		'float':'F',
		'long':'J',
		'double':'D',
		'void':'V'
		]
	
	static boolean isPrimitive(String type){
		return primitiveDesc.containsKey(type)
	}
	
	/**
	 * 
	 * @param clsName interal class name
	 * @return
	 */
	static String getDescriptor(String clsName){
		def prefix = "";
		def desc = "";
		while(clsName.endsWith("[]")){
			clsName -= "[]"
			prefix += "["
		}
		if(isPrimitive(clsName)){
			desc = primitiveDesc.get(clsName)
		}else{
			desc = "L${clsName};"
		}
		return prefix + desc;
	}
	
	static String getMethodDescriptor(String returnType,List<String> types){
		String desc="";
		for(int i=0;i<types.size();i++){
			desc += getDescriptor(types[i])
		}
		desc = "(${desc})" + getDescriptor(returnType)
		return desc
	}
}
