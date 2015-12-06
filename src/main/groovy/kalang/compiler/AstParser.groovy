package kalang.compiler

import java.util.List;

import jast.ast.*

@groovy.transform.TypeChecked
class AstParser {
	
	AstLoader astLoader
	
	TypeSystem castSystem
	
	public AstParser(AstLoader astLoader){
		this.astLoader = astLoader
		this.castSystem = new TypeSystem(astLoader)
	}
	
	static String methodToString(String name,List<String> types,String className=null){
		String typeStr = types.join(",")
		String str = "${name}(${typeStr})"
		if(className){
			str = "${className}#${str}"
		}
		return str
	}
	
	static String methodToString(MethodNode node,String className=null){
		methodToString(node.name,getParameterTypes(node),className)
	}
	
	FieldNode getField(ClassNode ast,String name){
		for(def f in ast.fields){
			if(f.name==name) return f
		}
		return null;
	}
	
	/*MethodNode getMethod(ClassNode ast,String name,String[] types){
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
	}*/
	
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
			String[] types = getParameterTypes(m);
			MethodNode[] methods = this.getMethodsByName(theClass,name)
			if(!this.matchMethodsByType(methods,types)){
				list.add(m)
			}
		}
		return list;
	}
	
	MethodNode[] getMethodsByName(ClassNode cls,String methodName){
		def methods = []
		for(m in cls.methods){
			if(m.name==methodName){
				methods.add(m)
			}
		}
		return (MethodNode[]) methods.toArray()
	}

	boolean matchType(String from,String target,boolean matchSubclass=false,boolean autoCast=false){
		if(from==target) return true
		if(matchSubclass && castSystem.isSubclass(from,target)) return true;
		if(autoCast && this.castSystem.castable(from,target)) return true
		return false;
	}
	
	boolean matchTypes(String[] from,String[] target,boolean matchSubclass=false,boolean autoCast=false){
		if(from.length!=target.length) return false;
		for(int i=0;i<from.length;i++){
			String f = from[i]
			String t = target[i]
			if(!matchType(f,t,matchSubclass,autoCast)) return false
		}
		return true
	}
	
	MethodNode[] matchMethodsByType(MethodNode[] methods,String[] types,boolean matchSubclass=false,boolean autoCast=false){
		List<MethodNode> list = []
		for(m in methods){
			String[] mTypes = getParameterTypes(m).toArray()
			if(matchTypes(types,mTypes,matchSubclass,autoCast)){
				list.add(m)
			}
		}
		return (MethodNode[]) list.toArray()
	}
}
