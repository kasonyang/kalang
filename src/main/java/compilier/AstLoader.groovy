package compilier

import jast.ast.ClassNode

class AstLoader {
	
	HashMap<String,ClassNode> asts = [:]
	
	public void add(ClassNode clazz){
		asts.put(clazz.name,clazz)
	}
	
	public ClassNode load(String className) throws AstNotFoundException{
		def ast = asts.get(className)
		if(!ast){
			try{
				Class clz = Class.forName(className)
				ast = AstBuilder.build(clz)
			}catch(ClassNotFoundException e){
				throw new AstNotFoundException(className)
			}
		}
		return ast
	}
	
	public ClassNode getAst(String clsName){
		try{
			return load(clsName)
		}catch(AstNotFoundException e){
			return null;
		}
	}

}
