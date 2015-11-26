package compilier

import jast.ast.ClassNode

class AstLoader {
	
	HashMap<String,ClassNode> asts = [:]
	
	public void add(ClassNode clazz){
		asts.put(clazz.name,clazz)
	}
	
	public ClassNode load(String className){
		def ast = asts.get(className)
		if(!ast){
			try{
				Class clz = Class.forName(className)
				ast = AstBuilder.build(clz)
			}catch(ClassNotFoundException e){
				ast = null;
			}
		}
		return ast
	}

}
