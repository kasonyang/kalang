package kalang.core
@groovy.transform.CompileStatic
class ClassNode {
	String name
	String modifier
	public final List<MethodObject> methods = []
	String parentName
	public final List<FieldObject> fields = []
	String toString(){
		String mstr= ""
		for(def m in methods){
			mstr += m.toString() + "\n"
		}
		String header = "${modifier} class ${name}"
		if(parentName){
			header += " extends ${parentName}"
		}
		String fs = fields.join("\n")
		return """\
${header}{
${fs}
${mstr}
}
"""
	}
}
