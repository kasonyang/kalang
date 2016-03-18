package kalang.compiler;

import kalang.ast.AstNode;
import kalang.ast.ClassNode;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import static kalang.compiler.CompilePhase.*;
/**
 * The core compiler
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class KalangCompiler extends AstLoader {
        
    private int compileTargetPhase = PHASE_ALL;

    private HashMap<String, CompilationUnit> compilationUnits = new HashMap<>();

    @Nonnull
    private final HashMap<String, KalangSource> sources = new HashMap();
    
    private int compilingPhase;

    @Nonnull
    private AstLoader astLoader = AstLoader.BASE_AST_LOADER;
    
    private KalangCompiler myself = this;

    @Nullable
    private SourceLoader sourceLoader;
    
    private final CompileConfiguration configuration;
    
    @Nonnull
    private CompileErrorHandler compileErrorHandler = (e) -> {
        reportError(e);
        compileTargetPhase = compilingPhase;
     };

    public KalangCompiler() {
        this(new DefaultCompileConfiguration());
    }

    public KalangCompiler(@Nonnull CompileConfiguration configuration) {
        this.configuration = configuration;
        this.astLoader = configuration.getAstLoader();
        this.sourceLoader = configuration.getSourceLoader();
    }

    /**
     * add source,which will be compiled
     * 
     * @param className the name of class
     * @param source the source of class
     */
    public void addSource(String className, String source) {
        KalangSource src = new KalangSource(className, source);
        sources.put(className, src);
        compilationUnits.put(className, createCompilationUnit(src));
    }

    @Nonnull
    

    protected void semanticAnalysis() {
        for (CompilationUnit cunit : compilationUnits.values()) {
            cunit.semanticAnalysis(compileErrorHandler);
        }
    }

    public void reportError(CompileError error) {
        compileErrorHandler.handleCompileError(error);
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
    }

    @Override
    protected ClassNode findAst(@Nonnull String className) throws AstNotFoundException {
        if (compilationUnits.containsKey(className)) {
            return compilationUnits.get(className).getAst();
        }
        if (this.sourceLoader != null) {
            String source = sourceLoader.loadSource(className);
            if (source != null) {
                return createCompilationUnit(new KalangSource(className, source)).getAst();
            }
        }
        return astLoader.findAst(className);
    }

    @Nonnull
    public HashMap<String, KalangSource> getSources() {
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
    public CompileErrorHandler getCompileErrrorHandler() {
        return compileErrorHandler;
    }

    public void setCompileErrorHandler(@Nonnull CompileErrorHandler compileErrrorHandler) {
        this.compileErrorHandler = compileErrrorHandler;
    }
    
    protected CompilationUnit newCompilationUnit(KalangSource source){
        AstLoader that = this;
        return new CompilationUnit(source,new CompileConfigurationProxy(configuration){
            @Override
            public AstLoader getAstLoader() {
                return that;
            }
            
        });
    }

    private CompilationUnit createCompilationUnit(KalangSource source) {
        CompilationUnit unit = newCompilationUnit(source);
        compilationUnits.put(source.getClassName(), unit);
        unit.setErrorHandler(compileErrorHandler);
        //unit.setCodeGenerator(codeGenerator);
        unit.compile(compilingPhase);
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

    public int getCurrentCompilePhase() {
        return compilingPhase;
    }

}
