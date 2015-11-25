package compilier

import jast.ast.*
@groovy.transform.TypeChecked
class AstBuilder {
	static ClassNode build(Class clz){
		def cn = ClassNode.create();
		cn.name = clz.name
		cn.parentName = clz.superclass.name
		for(def m in clz.methods){
			def methodNode = MethodNode.create();
			methodNode.name = m.name
			for(def p in m.parameters){
				def param = new VarDeclStmt();
				param.varName = p.name
				param.type = p.type.name
				methodNode.parameters.add(param)
			}
			methodNode.type = m.returnType.name
			methodNode.modifier = m.modifiers
			cn.methods.add(methodNode)
			methodNode.body = null;
		}
		return cn
	}
}
