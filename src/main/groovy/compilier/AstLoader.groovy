package compilier

import jast.ast.ClassNode

class AstLoader {
	
	HashMap<String,ClassNode> asts = [:]
	
	private AstLoader parent
	
	AstLoader(AstLoader astLoader = null){
		parent = astLoader
	}
	
	public void add(ClassNode clazz){
		asts.put(clazz.name,clazz)
	}
	
	protected ClassNode findAst(String className) throws AstNotFoundException{
		def ast = asts.get(className)
		if(!ast){
			if(parent){
				return parent.findAst(className)
			}else{
				throw new AstNotFoundException(className)
			}
		}
		return ast
	}
	
	public ClassNode loadAst(String className){
		return findAst(className)
	}
	
	public ClassNode getAst(String className){
		try{
			return findAst(className)
		}catch(AstNotFoundException e){
			return null;
		}
	}

}
