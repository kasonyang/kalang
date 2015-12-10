package kalang.compiler
import jast.ast.AstNode
import jast.ast.ClassNode;
import kalang.antlr.KalangLexer
import kalang.antlr.KalangParser

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream

//import SourceParser.Position

@groovy.transform.TypeChecked
class KalangCompiler extends AstLoader {

    HashMap<String,String> sources = [:]

    HashMap<String,ClassNode> asts = [:]
	
    HashMap<String,SourceParser> units = [:]
	
	HashMap<String,String> javaCodes = [:]
	
    AstLoader astLoader
	
	AstError astError
	
	ErrorHandler typeErrorHanlder;
	
	private ErrorHandler _errorHandler
	
	private boolean hasError = false;
	
	class ErrorHandlerProxy implements ErrorHandler{

		@Override
		public void error(AstNode node, String errMsg, int errorCode) {
			if(typeErrorHanlder){
				typeErrorHanlder.error(node,errMsg,errorCode)
			}
			hasError = true
		}
		
	}
	
    public KalangCompiler(AstLoader astLoader = null){
        this.astLoader = astLoader
    }
	
    ClassNode[] getCompiledClasses(){
        return (ClassNode[]) asts.values().toArray()
    }

    void addSource(String cls,String text){
        sources.put(cls,text)
    }
	
    protected void init(){
        def ks = sources.keySet()
        for(k in ks){
            def src = sources.get(k);
            def cunit =new SourceParser(k,src);
            cunit.importPackage("java.lang")
            cunit.importPackage("java.util")
            def cls = cunit.getAst();
            this.asts.put(k,cls)
            this.units.put(k,cunit)
        }
    }
	
    protected void buildAst(){
        def ks = this.units.keySet();
        for(k in ks){
            def cunit = units.get(k)
            try{
                cunit.compile(this)
            }catch(SourceParser.ParseError e){
                def loc = e.getPosition();
                this.reportError(e.message,k,loc)
            }
        }
    }

    protected void typeCheck(){
        def typeChecker = new TypeChecker(this)
		typeChecker.setErrorHandler(new ErrorHandlerProxy())
        def cnames = this.asts.keySet();
        def cn
        for(def c in cnames){
            def cls = asts.get(c)
            cn = c
            typeChecker.check(cls)
        }
    }
	
    protected void codeGen(){
        def cls = this.asts.values()
        for(c in cls){
            def a2j = new Ast2Java();
            def source = a2j.generate(c);
			this.javaCodes.put(c.name,source)
        }
    }
	
    protected void reportError(String msg,String className,SourceParser.Position loc=null){
        def src = sources.get(className)
		int offset = loc?.offset ?: 0
		int len = loc?.length   ?: 0
        throw new CompileError(msg,className,src,offset,len)
    }
	
    protected void reportError(String msg,String className,AstNode node){
        def unit = this.units.get(className)
		def loc = unit.getLocation(node)
		if(loc){
			reportError(msg,className,loc)
		}else{
			reportError(msg,className)
		}
    }
	
    void compile(){
        init();
        if(!hasError) buildAst()
        if(!hasError) typeCheck()
        if(!hasError) codeGen()
    }
	
    @Override
    protected ClassNode findAst(String className) throws AstNotFoundException {
        if(this.asts.containsKey(className)){
            return this.asts.get(className)
        }else if(this.astLoader){
            return astLoader.findAst(className)
        }else{
            return null;
        }
    }
}
