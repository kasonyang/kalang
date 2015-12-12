package kalang.compiler;
import jast.ast.AstNode;
import jast.ast.ClassNode;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

//import SourceParser.Position

@groovy.transform.TypeChecked
public class KalangCompiler extends AstLoader {

    HashMap<String,String> sources = new HashMap();

    HashMap<String,ClassNode> asts = new HashMap();
	
    HashMap<String,SourceParser> units = new HashMap();
	
	HashMap<String,String> javaCodes = new HashMap();
	
    AstLoader astLoader;
	
	AstError astError;
	
	ErrorHandler typeErrorHanlder;
	
	private ErrorHandler _errorHandler;
	
	
	private List<CompileError> errors;
	
	class ErrorHandlerProxy implements ErrorHandler{

		@Override
		public void error(ClassNode clazz,AstNode node, String errMsg, int errorCode) {
			if(typeErrorHanlder!=null){
				typeErrorHanlder.error(clazz,node,errMsg,errorCode);
			}
			if(errors==null){
				errors = new LinkedList();
			}
			String clsName = clazz.name;
			reportError(errMsg,clsName,node);
		}
	}
	
        public KalangCompiler(){
    }
    public KalangCompiler(AstLoader astLoader){
        this.astLoader = astLoader;
    }
	
	public List<CompileError> getErrors(){
		return errors;
	}
	
    public ClassNode[] getCompiledClasses(){
        return asts.values().toArray(new ClassNode[0]);
    }

    public void addSource(String cls,String text){
        sources.put(cls,text);
    }
	
    protected void init(){
        Set<String> ks = sources.keySet();
        for(String k : ks){
            String src = sources.get(k);
            SourceParser cunit = new SourceParser(k,src);
            cunit.importPackage("java.lang");
            cunit.importPackage("java.util");
            ClassNode cls = cunit.getAst();
            this.asts.put(k,cls);
            this.units.put(k,cunit);
        }
    }
	
    protected void buildAst(){
        Set<String> ks = this.units.keySet();
        for(String k : ks){
            SourceParser cunit = units.get(k);
            try{
                cunit.compile(this);
            }catch(SourceParser.ParseError e){
                SourceParser.Position loc = e.getPosition();
                this.reportError(e.getMessage(),k,loc);
            }
        }
    }

    protected void typeCheck(){
        TypeChecker typeChecker = new TypeChecker(this);
		typeChecker.setErrorHandler(new ErrorHandlerProxy());
        Set<String> cnames = this.asts.keySet();
        String cn;
        for(String c : cnames){
            ClassNode cls = asts.get(c);
            cn = c;
            typeChecker.check(cls);
        }
    }
	
    protected void codeGen(){
        Collection<ClassNode> cls = this.asts.values();
        for(ClassNode c : cls){
            Ast2Java a2j = new Ast2Java();
            String source = a2j.generate(c);
			this.javaCodes.put(c.name,source);
        }
    }

    protected void reportError(String msg,String className){
        reportError(msg,className,sources.get(className),0,0);
    }
    
    protected void reportError(String msg,String className,String src,int start,int stop){
         CompileError ce = new CompileError(msg,className,src,start,stop);
		if(errors==null) errors = new LinkedList();
		errors.add(ce);
    }
    protected void reportError(String msg,String className,SourceParser.Position loc){
        String src = sources.get(className);
		int offset = loc.offset;
		int len = loc.length;
                reportError(msg,className,src,offset,offset + len);
    }
	
    protected void reportError(String msg,String className,AstNode node){
        SourceParser unit = this.units.get(className);
        SourceParser.Position loc = unit.getLocation(node);
		if(loc!=null){
			reportError(msg,className,loc);
		}else{
			reportError(msg,className);
		}
    }
	
	public boolean hasError(){
		return errors!=null;
	}
	
	public void compile(){
		this.errors = null;
        init();
        if(!hasError()) buildAst();
        if(!hasError()) typeCheck();
        if(!hasError()) codeGen();
    }
	
    @Override
    protected ClassNode findAst(String className) throws AstNotFoundException {
        if(this.asts.containsKey(className)){
            return this.asts.get(className);
        }else if(this.astLoader!=null){
            return astLoader.findAst(className);
        }else{
            return null;
        }
    }
	public HashMap<String, String> getSources() {
		return sources;
	}
	public HashMap<String, SourceParser> getUnits() {
		return units;
	}
	public HashMap<String, String> getJavaCodes() {
		return javaCodes;
	}
	public void setTypeErrorHanlder(ErrorHandler typeErrorHanlder) {
		this.typeErrorHanlder = typeErrorHanlder;
	}
    
}
