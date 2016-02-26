package kalang.compiler;

import kalang.ast.AstNode;
import kalang.ast.ClassNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import static kalang.compiler.CompilePhase.*;
//import SourceUnit.OffsetRange
public class KalangCompiler extends AstLoader {
        
    private int compileTargetPhase = PHASE_ALL;

    private HashMap<String, CompilationUnit> compilationUnits = new HashMap<>();

    @Nonnull
    private final HashMap<String, String> sources = new HashMap();

    @Nonnull
    private final List<CompilationUnit> parseTasks = new LinkedList<>();

    @Nonnull
    private AstLoader astLoader = AstLoader.BASE_AST_LOADER;

    @Nullable
    private SourceLoader sourceLoader;

    @Nonnull
    private AstSemanticErrorHandler astSemanticErrorHandler = new AstSemanticErrorHandler() {
        @Override
        public void handleAstSemanticError(AstSemanticError error) {
            reportAstNodeError(error.getDescription(), error.classNode.name, error.node);
            compileTargetPhase = PHASE_SEMANTIC;
        }
    };
    
    @Nonnull
    private SourceParsingErrorHandler semanticErrorHandler = new SourceParsingErrorHandler() {
        @Override
        public void handleSemanticError(SourceParsingException see) {
            SourceUnit parser = see.getSourceUnit();
            OffsetRange offsetRange = see.getOffset();
            reportError(see.getDescription(), parser.getClassName(), offsetRange);
            compileTargetPhase = PHASE_PARSING;
        }
    };
    
    @Nonnull
    private CompileErrorHandler compileErrrorHandler = new CompileErrorHandler() {
        @Override
        public void handleCompileError(CompileError error) {
            System.err.println(error.toString());
        }
    };
    private int compilingPhase;

    public KalangCompiler() {
    }

    public KalangCompiler(@Nonnull AstLoader astLoader,@Nonnull SourceLoader sourceLoader) {
        this.astLoader = astLoader;
        this.sourceLoader = sourceLoader;
    }

    public KalangCompiler(@Nonnull SourceLoader sourceLoader, @Nonnull AstLoader astLoader) {
        this.astLoader = astLoader;
        this.sourceLoader = sourceLoader;
    }

    public KalangCompiler(@Nonnull SourceLoader sourceLoader) {
        this.sourceLoader = sourceLoader;
    }

    public KalangCompiler(@Nonnull AstLoader astLoader) {
        this.astLoader = astLoader;
    }

    /**
     * add source,which will be compiled
     * 
     * @param className the name of class
     * @param source the source of class
     */
    public void addSource(String className, String source) {
        sources.put(className, source);
        compilationUnits.put(className, createCompilationUnit(className, source));
    }

    @Nonnull
    public AstSemanticErrorHandler getAstSemanticErrorHandler() {
        return astSemanticErrorHandler;
    }

    public void setAstSemanticErrorHandler(@Nonnull AstSemanticErrorHandler astSemanticErrorHandler) {
        this.astSemanticErrorHandler = astSemanticErrorHandler;
    }

    protected void semanticAnalysis() {
        for (CompilationUnit cunit : compilationUnits.values()) {
            cunit.semanticAnalysis(astSemanticErrorHandler);
        }
    }

    public void reportError(String msg, String className, OffsetRange loc) {
        String src = sources.get(className);
        CompileError ce = new CompileError(msg, className, src, loc);
        compileErrrorHandler.handleCompileError(ce);
    }

    public void reportAstNodeError(String msg, String className, AstNode node) {
        reportError(msg, className, node.offset);
    }
    
    public void setCompileTargetPhase(int targetPhase){
        compileTargetPhase = targetPhase;
    }

    public int getCompileTargetPhase() {
        return compileTargetPhase;
    }

    /**
     * compile all sources
     */
    public void compile() {
        while(compilingPhase<compileTargetPhase){
            compilingPhase++;
            for(CompilationUnit unit:compilationUnits.values()){
                unit.compile(compilingPhase);
            }
        }
//        while(parseTasks.size()>0){
//            CompilationUnit cunit = parseTasks.get(0);
//            cunit.compile(compileTargetPhase);
//        }
//        if(compileTargetPhase>=PHASE_INITIALIZE) init();
//        if(compileTargetPhase>=PHASE_PARSING) parsing();
//        if(compileTargetPhase>=PHASE_BUILDAST) buildAst();
//        if(compileTargetPhase>=PHASE_SEMANTIC) semanticAnalysis();
//        if(compileTargetPhase>=PHASE_CLASSGEN) codeGen();
    }

    @Override
    protected ClassNode findAst(@Nonnull String className) throws AstNotFoundException {
        if (compilationUnits.containsKey(className)) {
            return compilationUnits.get(className).getAst();
        }
        if (this.sourceLoader != null) {
            String source = sourceLoader.loadSource(className);
            if (source != null) {
                return createCompilationUnit(className, source).getAst();
            }
        }
        return astLoader.findAst(className);
    }

    @Nonnull
    public HashMap<String, String> getSources() {
        return sources;
    }

    @Nonnull
    public HashMap<String, CompilationUnit> getAllCompilationUnit() {
        return compilationUnits;
    }
    
    @Nullable
    public CompilationUnit getCompilationUnit(@Nonnull String className){
        return compilationUnits.get(className);
    }
    
    @Nonnull
    public SourceParsingErrorHandler getSemanticErrorHandler() {
        return semanticErrorHandler;
    }

    public void setSemanticErrorHandler(@Nonnull SourceParsingErrorHandler semanticErrorHandler) {
        this.semanticErrorHandler = semanticErrorHandler;
    }

    @Nonnull
    public CompileErrorHandler getCompileErrrorHandler() {
        return compileErrrorHandler;
    }

    public void setCompileErrrorHandler(@Nonnull CompileErrorHandler compileErrrorHandler) {
        this.compileErrrorHandler = compileErrrorHandler;
    }

    private CompilationUnit createCompilationUnit(String className, String src) {
        CompilationUnit unit = new CompilationUnit(className, src,this);
        unit.setParsingErrorHandler(semanticErrorHandler);
        unit.setSemanticErrorHandler(astSemanticErrorHandler);
        unit.compile(compilingPhase);
        //unit.parseMeta(semanticErrorHandler);
        compilationUnits.put(className, unit);
        this.parseTasks.add(unit);
        return unit;
    }

    @Nonnull
    public AstLoader getAstLoader() {
        return astLoader;
    }

    @Nullable
    public SourceLoader getSourceLoader() {
        return sourceLoader;
    }

}
