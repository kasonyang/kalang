package compilier

import java.util.List;

import jast.ast.*

@groovy.transform.TypeChecked
class AstParser {
	
	AstLoader astLoader
	
	CastSystem castSystem
	
	public AstParser(AstLoader astLoader){
		this.astLoader = astLoader
		this.castSystem = new CastSystem(astLoader)
	}
	
	static String methodToString(String name,List<String> types){
		String typeStr = types.join(",")
		"${name}(${typeStr})"
	}
	
	static String methodToString(MethodNode node){
		methodToString(node.name,getParameterTypes(node))
	}
	
	FieldNode getField(ClassNode ast,String name){
		for(def f in ast.fields){
			if(f.name==name) return f
		}
		return null;
	}
	
	MethodNode getMethod(ClassNode ast,String name,List<String> types){
		def methods = ast.methods
		for(def m in methods){
			if(m.name!=name) continue
			def ps = m.parameters
			def mtypes = []
			for(def p in ps){
				mtypes.add(p.type)
			}
			if(castSystem.castable(types,mtypes)){
				return m
			}
		}
		return null
	}
	
	static List<String> getParameterTypes(MethodNode mn){
		List<String> types = []
		for(ParameterNode p in mn.parameters){
			types.add(p.type);
		}
		return types
	}
	
	List<MethodNode> getUnimplementedMethod(ClassNode theClass,ClassNode theInterface){
		List<MethodNode> list = []
		for(MethodNode m in theInterface.methods){
			String name = m.name;
			List<String> types = getParameterTypes(m);
			if(!getMethod(theClass,name,types)){
				list.add(m);
			}
		}
		return list;
	}

}
