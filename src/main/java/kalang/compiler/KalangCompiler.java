package kalang.compiler;

import kalang.AstNotFoundException;
import kalang.ast.AstNode;
import kalang.ast.ClassNode;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import static kalang.compiler.CompilePhase.*;
import org.antlr.v4.runtime.CommonTokenStream;
/**
 * The core compiler
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class KalangCompiler extends AstLoader implements CompileConfiguration{
        
    private int compileTargetPhase = PHASE_ALL;

    private HashMap<String, CompilationUnit> compilationUnits = new HashMap<>();

    @Nonnull
    private final HashMap<String, KalangSource> sources = new HashMap();
    
    protected CompileConfiguration configuration = new DefaultCompileConfiguration();
    
    private int compilingPhase;

    //@Nonnull
    //private AstLoader astLoader = AstLoader.BASE_AST_LOADER;
    
    private KalangCompiler myself = this;

    //@Nullable
    //private SourceLoader sourceLoader;
    
    //protected CompileConfiguration configuration;
    
    @Nonnull
    protected CompileErrorHandler compileErrorHandler = (e) -> {
        System.err.println(e.toString());
        compileTargetPhase = compilingPhase;
     };

    public KalangCompiler() {
    }

    /**
     * add source,which will be compiled
     * 
     * @param className the name of class
     * @param source the source of class
     * @param fileName the file name of source
     */
    public void addSource(String className, String source,String fileName) {
        KalangSource src = new KalangSource(className, source,fileName);
        addSource(src);
    }
    public void addSource(KalangSource source){
        String className = source.getClassName();
        sources.put(className, source);
        compilationUnits.put(className, createCompilationUnit(source));
    }

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
        SourceLoader sourceLoader = getSourceLoader();
        if (sourceLoader != null) {
            KalangSource source = sourceLoader.loadSource(className);
            if (source != null) {
                return createCompilationUnit(source).getAst();
            }
        }
        return getAstLoader().findAst(className);
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
        return new CompilationUnit(source,new CompileConfigurationProxy(this){
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

    public int getCurrentCompilePhase() {
        return compilingPhase;
    }

    @Override
    public KalangLexer createLexer(CompilationUnit compilationUnit, String source) {
        return configuration.createLexer(compilationUnit, source);
    }

    @Override
    public CommonTokenStream createTokenStream(CompilationUnit compilationUnit, KalangLexer lexer) {
        return configuration.createTokenStream(compilationUnit, lexer);
    }

    @Override
    public KalangParser createParser(CompilationUnit compilationUnit, CommonTokenStream tokenStream) {
        return configuration.createParser(compilationUnit, tokenStream);
    }

    @Override
    public AstBuilder createAstBuilder(CompilationUnit compilationUnit, KalangParser parser) {
        return configuration.createAstBuilder(compilationUnit, parser);
    }

    @Override
    public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
        return configuration.createCodeGenerator(compilationUnit);
    }

    @Override
    public SemanticAnalyzer createSemanticAnalyzer(CompilationUnit compilationUnit, AstLoader astLoader) {
        return configuration.createSemanticAnalyzer(compilationUnit, astLoader);
    }

    @Override
    public AstLoader getAstLoader() {
        return configuration.getAstLoader();
    }

    @Override
    public SourceLoader getSourceLoader() {
        return configuration.getSourceLoader();
    }

}
