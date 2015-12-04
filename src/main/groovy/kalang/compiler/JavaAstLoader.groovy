package kalang.compiler

import jast.ast.*;
import java.lang.reflect.Field
@groovy.transform.TypeChecked
class JavaAstLoader extends AstLoader {
	
	static ClassNode buildFromClass(Class clz){
		def cn = ClassNode.create();
		cn.name = clz.name
		cn.parentName = clz.superclass?.name
		for(def m in clz.methods){
			def methodNode = MethodNode.create();
			methodNode.name = m.name
			for(def p in m.parameters){
				def param = new ParameterNode();
				param.name = p.name
				param.type = p.type.name
				methodNode.parameters.add(param)
			}
			methodNode.type = m.returnType.name
			methodNode.modifier = m.modifiers
			cn.methods.add(methodNode)
			methodNode.body = null;
			for(def e in m.exceptionTypes){
				methodNode.exceptionTypes.add(e.name)
			}
		}
		for(Field f in clz.fields){
			def fn = new FieldNode()
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
