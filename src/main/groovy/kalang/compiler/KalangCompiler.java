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
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

//import SourceParser.Position
public class KalangCompiler extends AstLoader {

    HashMap<String, String> sources = new HashMap();

    HashMap<String, ClassNode> asts = new HashMap();

    HashMap<String, SourceParser> units = new HashMap();

    HashMap<String, String> javaCodes = new HashMap();
    
    HashMap<String, TypeChecker> typeCheckers = new HashMap<>();

    AstLoader astLoader;

    AstSemanticReporter astError;

    private AstSemanticErrorHandler astSemanticErrorHandler = new AstSemanticErrorHandler() {
        @Override
        public void handleAstSemanticError(AstSemanticError error) {
            reportError(error.getMsg(),error.classNode.name,error.node);
        }
    };
    private SemanticErrorHandler semanticErrorHandler = new SemanticErrorHandler() {
        @Override
        public void handleSemanticError(SemanticErrorException see) {
            Token token = see.getToken();
            ParseTree tree = see.getTree();
            SourceParser parser = see.getSourceParser();
            SourceParser.Position loc = parser.getLocation(token);
            reportError(see.getMessage(),parser.getAst().name , loc);
            //TODO 
            //reportError(see.getMessage(),, loc);
            System.err.println(see.toString());
        }
    };
    private CompileErrorHandler compileErrorHandlerrrorHandler = new CompileErrorHandler() {
        @Override
        public void handleCompileError(CompileError error) {
            System.err.println(error.toString());
        }
    };

    public KalangCompiler() {
    }

    public KalangCompiler(AstLoader astLoader) {
        this.astLoader = astLoader;
    }

    public ClassNode[] getCompiledClasses() {
        return asts.values().toArray(new ClassNode[0]);
    }

    public void addSource(String cls, String text) {
        sources.put(cls, text);
    }

    protected void init() {
        units.clear();
        typeCheckers.clear();
        asts.clear();
        javaCodes.clear();
        Set<String> ks = sources.keySet();
        for (String k : ks) {
            String src = sources.get(k);
            SourceParser cunit = SourceParser.create(k, src);
            cunit.setSemanticErrorHandler(semanticErrorHandler);
            //SourceParser cunit = new SourceParser(k,p);
            cunit.importPackage("java.lang");
            cunit.importPackage("java.util");
            ClassNode cls = cunit.getAst();
            this.asts.put(k, cls);
            this.units.put(k, cunit);
        }
    }

    protected void buildAst() {
        Set<String> ks = this.units.keySet();
        for (String k : ks) {
            SourceParser cunit = units.get(k);
            cunit.compile(this);
        }
    }

    public AstSemanticErrorHandler getAstSemanticErrorHandler() {
        return astSemanticErrorHandler;
    }

    public void setAstSemanticErrorHandler(AstSemanticErrorHandler astSemanticErrorHandler) {
        this.astSemanticErrorHandler = astSemanticErrorHandler;
    }
    
    

    protected void typeCheck() {
        Set<String> cnames = this.asts.keySet();
        for (String c : cnames) {
            TypeChecker typeChecker = new TypeChecker(this);
            typeChecker.setAstSemanticErrorHandler(astSemanticErrorHandler);
            typeCheckers.put(c, typeChecker);
            ClassNode cls = asts.get(c);
            typeChecker.check(cls);
        }
    }

    protected void codeGen() {
        Collection<ClassNode> cls = this.asts.values();
        for (ClassNode c : cls) {
            Ast2Java a2j = new Ast2Java();
            String source = a2j.generate(c);
            this.javaCodes.put(c.name, source);
        }
    }

    protected void reportError(String msg, String className) {
        reportError(msg, className, sources.get(className), 0, 0);
    }

    protected void reportError(String msg, String className, String src, int start, int stop) {
        CompileError ce = new CompileError(msg, className, src, start, stop);
        compileErrorHandlerrrorHandler.handleCompileError(ce);
    }

    protected void reportError(String msg, String className, SourceParser.Position loc) {
        String src = sources.get(className);
        int offset = loc.offset;
        int len = loc.length;
        reportError(msg, className, src, offset, offset + len);
    }

    protected void reportError(String msg, String className, AstNode node) {
        SourceParser unit = this.units.get(className);
        SourceParser.Position loc = unit.getLocation(node);
        if (loc != null) {
            reportError(msg, className, loc);
        } else {
            reportError(msg, className);
        }
    }


    public void compile() {
        init();
        buildAst();
        typeCheck();
        codeGen();
    }

    @Override
    protected ClassNode findAst(String className) throws AstNotFoundException {
        if (this.asts.containsKey(className)) {
            return this.asts.get(className);
        } else if (this.astLoader != null) {
            return astLoader.findAst(className);
        } else {
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

    public SemanticErrorHandler getSemanticErrorHandler() {
        return semanticErrorHandler;
    }

    public void setSemanticErrorHandler(SemanticErrorHandler semanticErrorHandler) {
        this.semanticErrorHandler = semanticErrorHandler;
    }

    public CompileErrorHandler getCompileErrorHandlerrrorHandler() {
        return compileErrorHandlerrrorHandler;
    }

    public void setCompileErrorHandlerrrorHandler(CompileErrorHandler compileErrorHandlerrrorHandler) {
        this.compileErrorHandlerrrorHandler = compileErrorHandlerrrorHandler;
    }
    
    public TypeChecker getTypeChecker(String className){
        return typeCheckers.get(className);
    }
    
    public SourceParser getParser(String clsName){
        return units.get(clsName);
    }
    
    public ClassNode getClassNode(String clsName){
        return asts.get(clsName);
    }

}
