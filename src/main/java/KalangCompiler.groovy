import jast.ast.AstNode
import jast.ast.ClassNode;
import kalang.antlr.KalangLexer
import kalang.antlr.KalangParser
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import compilier.AstLoader
import compilier.AstNotFoundException;
import compilier.TypeChecker

@groovy.transform.TypeChecked
class KalangCompiler extends AstLoader {

	HashMap<String,String> sources = [:]

	HashMap<String,ClassNode> classes = [:]
	
	HashMap<String,KalangTranslator> units = [:]
	
	AstLoader astLoader
	
	public KalangCompiler(AstLoader astLoader = null){
		this.astLoader = astLoader
	}
	
	ClassNode[] getCompiledClasses(){
		return (ClassNode[]) classes.values().toArray()
	}

	void addSource(String cls,String text){
		sources.put(cls,text)
	}

	void typeCheck(){
		def typeChecker = new TypeChecker(this)
		def cnames = this.classes.keySet();
		def cn
		try{
			for(def c in cnames){
				def cls = classes.get(c)
				cn = c
				typeChecker.check(cls)
			}
			println "type checked!"
			//System.err.println a2j.visit(cls);
		}catch(TypeChecker.TypeError e){
			def node = e.getNode()
			this.reportError(e.message,cn,node)
			//def t = parseTrees.get(node)
			//errorOn(e.message,t,tokens)
			//println e.message + ":error on ${node}"
		}
	}
	
	void reportError(String msg,String className,AstNode node){
		def unit = this.units.get(className)
		def loc = unit.getLocation(node)
		def src = sources.get(className)
		def ltext = src.substring(loc.offset,loc.offset + loc.length)
		System.err.print("${msg}:${ltext}")
	}
	
	void compile(){
		def keys = sources.keySet();
		for(def k in keys){
			def ast = findAst(k)
		}
		typeCheck()
	}

	private ClassNode compileClass(String className){
		def src = sources.get(className);
		def cunit = KalangTranslator.create(src);
		cunit.importPackage("java.lang")
		cunit.importPackage("java.util")
		def cls = cunit.getAst();
		this.classes.put(className,cls)
		try{
			cunit.compile(this)
			this.units.put(className,cunit)
		}catch(ParseError e){
			//TODO trow
		    throw e
			//errorOn(e.getMessage(),e.getTree(),tokens)
		}
		return cls
	}
	
	@Override
	protected ClassNode findAst(String className) throws AstNotFoundException {
		if(this.classes.containsKey(className)){
			return this.classes.get(className)
		}else if(this.sources.containsKey(className)){
			return compileClass(className);
		}else if(this.astLoader){
			return astLoader.findAst(className)
		}else{
			return null;
		}
	}
}
