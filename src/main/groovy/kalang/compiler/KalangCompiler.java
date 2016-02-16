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
import kalang.util.SourceUnitFactory;
import kalang.util.TokenStreamFactory;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

//import SourceUnit.OffsetRange
public class KalangCompiler extends AstLoader {

    private HashMap<String, CompilationUnit> compilationUnits = new HashMap<>();

    private HashMap<String, String> sources = new HashMap();

    private List<String> parseTasks = new LinkedList<>();

    private AstLoader astLoader;

    private SourceLoader sourceLoader;

    private AstSemanticErrorReporter semanticErrorReporter;

    private AstSemanticErrorHandler astSemanticErrorHandler = new AstSemanticErrorHandler() {
        @Override
        public void handleAstSemanticError(AstSemanticError error) {
            reportAstNodeError(error.getDescription(), error.classNode.name, error.node);
        }
    };
    private SourceParsingErrorHandler semanticErrorHandler = new SourceParsingErrorHandler() {
        @Override
        public void handleSemanticError(SourceParsingException see) {
            SourceUnit parser = see.getSourceUnit();
            OffsetRange offsetRange = see.getOffset();
            reportError(see.getDescription(), parser.getClassName(), offsetRange);
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

    public KalangCompiler(SourceLoader sourceLoader, AstLoader astLoader) {
        this.astLoader = astLoader;
        this.sourceLoader = sourceLoader;
    }

    public KalangCompiler(SourceLoader sourceLoader) {
        this.sourceLoader = sourceLoader;
    }

    public KalangCompiler(AstLoader astLoader) {
        this.astLoader = astLoader;
    }

//    public ClassNode[] getCompiledClasses() {
//        return asts.values().toArray(new ClassNode[0]);
//    }
    public void addSource(String cls, String text) {
        sources.put(cls, text);
    }

    protected void init() {
        Set<String> ks = sources.keySet();
        for (String k : ks) {
            String src = sources.get(k);
            createCompilationUnit(k, src);
        }
    }

    protected void parse() {
        while (parseTasks.size() > 0) {
            String k = parseTasks.get(0);
            CompilationUnit cunit = compilationUnits.get(k);
            cunit.parse(semanticErrorHandler);
        }
    }

    public AstSemanticErrorHandler getAstSemanticErrorHandler() {
        return astSemanticErrorHandler;
    }

    public void setAstSemanticErrorHandler(AstSemanticErrorHandler astSemanticErrorHandler) {
        this.astSemanticErrorHandler = astSemanticErrorHandler;
    }

    protected void semanticAnalysis() {
        for (CompilationUnit cunit : compilationUnits.values()) {
            cunit.semanticAnalysis(astSemanticErrorHandler);
        }
    }

    protected void codeGen() {
        for (CompilationUnit cunit : compilationUnits.values()) {
            cunit.generateJavaCode();
        }
    }

    public void reportError(String msg, String className, OffsetRange loc) {
        String src = sources.get(className);
        CompileError ce = new CompileError(msg, className, src, loc);
        compileErrorHandlerrrorHandler.handleCompileError(ce);
    }

    public void reportAstNodeError(String msg, String className, AstNode node) {
        reportError(msg, className, node.offset);
    }

    public void compile() {
        init();
        parse();
        semanticAnalysis();
        codeGen();
    }

    @Override
    protected ClassNode findAst(String className) throws AstNotFoundException {
        if (compilationUnits.containsKey(className)) {
            return compilationUnits.get(className).getAst();
        }
        if (this.sourceLoader != null) {
            String source = sourceLoader.loadSource(className);
            if (source != null) {
                return createCompilationUnit(className, source).getAst();
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

    public HashMap<String, CompilationUnit> getAllCompilationUnit() {
        return compilationUnits;
    }
    
    public CompilationUnit getCompilationUnit(String className){
        return compilationUnits.get(className);
    }

    public SourceParsingErrorHandler getSemanticErrorHandler() {
        return semanticErrorHandler;
    }

    public void setSemanticErrorHandler(SourceParsingErrorHandler semanticErrorHandler) {
        this.semanticErrorHandler = semanticErrorHandler;
    }

    public CompileErrorHandler getCompileErrorHandlerrrorHandler() {
        return compileErrorHandlerrrorHandler;
    }

    public void setCompileErrorHandlerrrorHandler(CompileErrorHandler compileErrorHandlerrrorHandler) {
        this.compileErrorHandlerrrorHandler = compileErrorHandlerrrorHandler;
    }

    private CompilationUnit createCompilationUnit(String className, String src) {
        CompilationUnit unit = new CompilationUnit(className, src,this);
        compilationUnits.put(className, unit);
        this.parseTasks.add(className);
        return unit;
    }

    public AstLoader getAstLoader() {
        return astLoader;
    }

    public SourceLoader getSourceLoader() {
        return sourceLoader;
    }

}
