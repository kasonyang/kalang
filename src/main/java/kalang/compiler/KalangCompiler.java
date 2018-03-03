package kalang.compiler;

import java.io.PrintStream;
import kalang.AstNotFoundException;
import kalang.ast.ClassNode;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import static kalang.compiler.CompilePhase.*;
import kalang.compiler.codegen.Ast2Java;
import kalang.util.AntlrErrorString;
import kalang.util.LexerFactory;
import kalang.util.OffsetRangeHelper;
import kalang.util.TokenStreamFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
/**
 * The core compiler
 * 
 * @author Kason Yang
 */
public class KalangCompiler extends AstLoader implements CompileContext{
        
    private int compileTargetPhase = PHASE_ALL;

    private HashMap<String, CompilationUnit> compilationUnits = new HashMap<>();

    @Nonnull
    private final HashMap<String, KalangSource> sources = new HashMap();
    
    private int compilingPhase;
    
    protected DiagnosisHandler diagnosisHandler = StandardDiagnosisHandler.INSTANCE;
    
    protected AstLoader astLoader;
    
    protected Configuration configuration = new Configuration();

    public KalangCompiler() {
        this(new JavaAstLoader());
    }

    public KalangCompiler(AstLoader astLoader) {
        this.astLoader = astLoader;
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
    
    public void setCompileTargetPhase(int targetPhase){
        compileTargetPhase = targetPhase;
    }

    public int getCompileTargetPhase() {
        return compileTargetPhase;
    }
    
    public void compile(int targetPhase){
        while(compilingPhase<targetPhase && compilingPhase < this.compileTargetPhase){
            compilingPhase++;
            for(CompilationUnit unit:compilationUnits.values()){
                unit.compile(compilingPhase);
            }
        }
    }

    /**
     * compile all sources
     */
    public void compile() {
        compile(compileTargetPhase);
    }
    
    private ClassNode findInnerClass(ClassNode topClass,String className){
        for(ClassNode c:topClass.classes){
            if(className.equals(c.name)) return c;
            ClassNode ic = findInnerClass(c,className);
            if(ic!=null) return ic;
        }
        return null;
    }

    @Override
    protected ClassNode findAst(@Nonnull String className) throws AstNotFoundException {
        String[] classNameInfo = className.split("\\$",2);
        String topClassName = classNameInfo[0];
        if (compilationUnits.containsKey(topClassName)) {
            CompilationUnit compilationUnit = compilationUnits.get(topClassName);
            ClassNode clazz = compilationUnit.getAst();
            if(classNameInfo.length==1){
                return clazz;
            }else{
                ClassNode c = findInnerClass(clazz, className);
                if(c!=null) return c;
            }
        }
        SourceLoader sourceLoader = getSourceLoader();
        if (sourceLoader != null) {
            KalangSource source = sourceLoader.loadSource(className);
            if (source != null) {
                return createCompilationUnit(source).getAst();
            }
        }
        return AstLoader.BASE_AST_LOADER.findAst(className);
    }

    @Nonnull
    public HashMap<String, KalangSource> getSources() {
        return sources;
    }

    @Nonnull
    public HashMap<String, CompilationUnit> getCompilationUnits() {
        return compilationUnits;
    }
    
    @Nullable
    public CompilationUnit getCompilationUnit(@Nonnull String className){
        return compilationUnits.get(className);
    }
    
    protected CompilationUnit newCompilationUnit(KalangSource source){
        return new CompilationUnit(source,this);
    }

    private CompilationUnit createCompilationUnit(KalangSource source) {
        CompilationUnit unit = newCompilationUnit(source);
        compilationUnits.put(source.getClassName(), unit);
        unit.compile(compilingPhase);
        return unit;
    }

    public int getCurrentCompilePhase() {
        return compilingPhase;
    }

    @Override
    public KalangLexer createLexer(CompilationUnit compilationUnit, String source) {
        return LexerFactory.createLexer(source);
    }

    @Override
    public CommonTokenStream createTokenStream(CompilationUnit compilationUnit, KalangLexer lexer) {
        return TokenStreamFactory.createTokenStream(lexer);
    }

    @Override
    public KalangParser createParser(CompilationUnit compilationUnit, CommonTokenStream tokenStream) {
        KalangParser parser = new KalangParser(tokenStream);
        parser.setErrorHandler(new DefaultErrorStrategy(){
            @Override
            public void reportError(Parser recognizer, RecognitionException e) {
                String msg = AntlrErrorString.exceptionString(recognizer, e);
                Diagnosis diagnosis = new Diagnosis(
                        compilationUnit.getCompileContext()
                        , Diagnosis.Kind.ERROR
                        , OffsetRangeHelper.getOffsetRange(e.getOffendingToken())
                        , msg
                        , compilationUnit.getSource()
                );
                diagnosisHandler.handleDiagnosis(diagnosis);
            }
            
        });
        return parser;
    }

    @Override
    public AstBuilder createAstBuilder(CompilationUnit compilationUnit, KalangParser parser) {
        return new AstBuilder(compilationUnit, parser);
    }

    @Override
    public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
        return new Ast2Java();
    }

    @Override
    public SemanticAnalyzer createSemanticAnalyzer(CompilationUnit compilationUnit, AstLoader astLoader) {
        return new SemanticAnalyzer(compilationUnit, astLoader);
    }

    @Override
    public AstLoader getAstLoader() {
        return this;
    }

    @Override
    public SourceLoader getSourceLoader() {
        return new SourceLoader() {
            @Override
            public KalangSource loadSource(String className) {
                return null;
            }
        };
    }

    @Override
    public DiagnosisHandler getDiagnosisHandler() {
        return this.diagnosisHandler;
    }

    public void setDiagnosisHandler(DiagnosisHandler diagnosisHandler) {
        this.diagnosisHandler = diagnosisHandler;
    }

    @Override
    public void stopCompile(int stopPhase) {
        setCompileTargetPhase(stopPhase);
    }

    @Override
    public int getCompilingPhase() {
        return this.compilingPhase;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

}
