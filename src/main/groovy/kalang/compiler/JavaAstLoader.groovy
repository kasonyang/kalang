package kalang.compiler

import jast.ast.*;
import java.lang.reflect.Constructor
import java.lang.reflect.Executable
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier
@groovy.transform.TypeChecked
class JavaAstLoader extends AstLoader {
	
	static String ROOT_CLASS = "java.lang.Object"
	
	static ClassNode buildFromClass(Class clz){
		def cn = ClassNode.create();
		cn.name = clz.name
		cn.parentName = clz.superclass?.name
		if(!cn.parentName && cn.name!=ROOT_CLASS){
			cn.parentName = ROOT_CLASS
		}
		List<Executable> methods = []
		methods.addAll(clz.methods)
		methods.addAll(clz.constructors)
		for(def m in methods){
			def methodNode = MethodNode.create();
			for(def p in m.parameters){
				def param = new VarObject();
				param.name = p.name
				param.type = p.type.name
				methodNode.parameters.add(param)
			}
			if(m instanceof Method){
				methodNode.type = ((Method)m).returnType.name
				methodNode.name = m.name
				methodNode.modifier = m.modifiers
			}else if(m instanceof Constructor){
				methodNode.name = "<init>"
				methodNode.type = clz.name
				methodNode.modifier = m.modifiers | Modifier.STATIC
			}
			cn.methods.add(methodNode)
			methodNode.body = null;
			for(def e in m.exceptionTypes){
				methodNode.exceptionTypes.add(e.name)
			}
		}
		for(Field f in clz.fields){
			def fn = new VarObject()
			fn.name = f.name
			fn.type = f.type.name
			fn.modifier = f.modifiers
			cn.fields.add(fn)
		}
		return cn
	}
	
	@Override
	protected ClassNode findAst(String className) throws AstNotFoundException {
		try{
			return super.findAst(className);
		}catch(AstNotFoundException e){
			try{
				Class clz = Class.forName(className)
				return buildFromClass(clz)
			}catch(ClassNotFoundException ex){
				throw e
			}
		}
	}

}
