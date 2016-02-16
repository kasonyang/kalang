package kalang.compiler;

import kalang.ast.AstNode;
import kalang.ast.ClassNode;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import kalang.util.OffsetRangeHelper;
import kalang.util.CompilantUnitFactory;
import kalang.util.TokenStreamFactory;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

//import CompilantUnit.OffsetRange
public class KalangCompiler extends AstLoader {

    HashMap<String, String> sources = new HashMap();
    
    HashMap<String, CommonTokenStream> tokenStreams = new HashMap<>();

    HashMap<String, ClassNode> asts = new HashMap();

    HashMap<String, CompilantUnit> units = new HashMap();
    
    List<String> parseTasks = new LinkedList<>();

    HashMap<String, String> javaCodes = new HashMap();
    
    HashMap<String, SemanticAnalyzer> semanticAnalyzers = new HashMap<>();

    AstLoader astLoader;
    
    SourceLoader sourceLoader;

    AstSemanticErrorReporter semanticErrorReporter;

    private AstSemanticErrorHandler astSemanticErrorHandler = new AstSemanticErrorHandler() {
        @Override
        public void handleAstSemanticError(AstSemanticError error) {
            reportAstNodeError(error.getDescription(),error.classNode.name,error.node);
        }
    };
    private SemanticErrorHandler semanticErrorHandler = new SemanticErrorHandler() {
        @Override
        public void handleSemanticError(SourceParsingException see) {
            CompilantUnit parser = see.getCompilantUnit();
            OffsetRange offsetRange = see.getOffset();
            reportError(see.getDescription(), parser.getClassName(),offsetRange);
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

    public KalangCompiler(AstLoader astLoader, SourceLoader sourceLoader) {
        this.astLoader = astLoader;
        this.sourceLoader = sourceLoader;
    }
    
    public KalangCompiler(SourceLoader sourceLoader,AstLoader astLoader) {
        this.astLoader = astLoader;
        this.sourceLoader = sourceLoader;
    }

    public KalangCompiler(SourceLoader sourceLoader) {
        this.sourceLoader = sourceLoader;
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
        semanticAnalyzers.clear();
        asts.clear();
        javaCodes.clear();
        Set<String> ks = sources.keySet();
        for (String k : ks) {
            String src = sources.get(k);
            createAst(k,src);
        }
    }

    protected void buildAst() {
        while(parseTasks.size()>0){
            String k = parseTasks.get(0);
            CompilantUnit cunit = units.get(k);
            cunit.compile(this);
            parseTasks.remove(k);
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
            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer(this);
            semanticAnalyzer.setAstSemanticErrorHandler(astSemanticErrorHandler);
            semanticAnalyzers.put(c, semanticAnalyzer);
            ClassNode cls = asts.get(c);
            semanticAnalyzer.check(cls);
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

    public void reportError(String msg, String className, OffsetRange loc) {
        String src = sources.get(className);
        CompileError ce = new CompileError(msg, className, src,loc);
        compileErrorHandlerrrorHandler.handleCompileError(ce);
    }

    public void reportAstNodeError(String msg, String className, AstNode node) {
        reportError(msg, className,node.offset);
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
        }
        if(this.sourceLoader!=null){
            String source = sourceLoader.loadSource(className);
            if(source!=null){
                return createAst(className,source);
            }
        }
        if (this.astLoader != null) {
            return astLoader.findAst(className);
        } else {
            return null;
        }
    }

    public HashMap<String, String> getSources() {
        return sources;
    }

    public HashMap<String, CompilantUnit> getAllUnit() {
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
    
    public SemanticAnalyzer getSemanticAnalyzer(String className){
        return semanticAnalyzers.get(className);
    }
    
    public CompilantUnit getCompilantUnit(String clsName){
        return units.get(clsName);
    }
    
    public ClassNode getClassNode(String clsName){
        return asts.get(clsName);
    }

    private ClassNode createAst(String className,String src) {
        CommonTokenStream tokens = TokenStreamFactory.createTokenStream(src);
        tokenStreams.put(className, tokens);
        CompilantUnit cunit = CompilantUnitFactory.createCompilantUnit(className, tokens);
            cunit.setSemanticErrorHandler(semanticErrorHandler);
            //SourceParser cunit = new CompilantUnit(k,p);
            cunit.importPackage("java.lang");
            cunit.importPackage("java.util");
            ClassNode cls = cunit.getAst();
            this.parseTasks.add(className);
            this.asts.put(className, cls);
            this.units.put(className, cunit);
            return cls;
    }
    
    public CommonTokenStream getTokenStream(String clsName){
        return tokenStreams.get(clsName);
    }
    
    public HashMap<String, CommonTokenStream> getTokenStream(){
        return tokenStreams;
    }

}
