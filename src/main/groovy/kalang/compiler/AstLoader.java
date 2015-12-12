package kalang.compiler;

import java.util.HashMap;

import jast.ast.ClassNode;

class AstLoader {
	
	HashMap<String,ClassNode> asts = new HashMap();
	
	private AstLoader parent;
	
	public AstLoader(){
		
	}
	
	public AstLoader(AstLoader astLoader){
		parent = astLoader;
	}
	
	public void add(ClassNode clazz){
		asts.put(clazz.name,clazz);
	}
	
	protected ClassNode findAst(String className) throws AstNotFoundException{
		ClassNode ast = asts.get(className);
		if(ast==null){
			if(parent!=null){
				return parent.findAst(className);
			}else{
				throw new AstNotFoundException(className);
			}
		}
		return ast;
	}
	
	public ClassNode loadAst(String className) throws AstNotFoundException{
		return findAst(className);
	}
	
	public ClassNode getAst(String className){
		try{
			return findAst(className);
		}catch(AstNotFoundException e){
			return null;
		}
	}

}
