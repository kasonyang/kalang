package kalang.compiler.compile;

import kalang.compiler.AstNotFoundException;
import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.util.AntlrErrorString;
import kalang.compiler.util.LexerFactory;
import kalang.compiler.util.OffsetRangeHelper;
import kalang.compiler.util.TokenStreamFactory;
import org.antlr.v4.runtime.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;

import static kalang.compiler.compile.CompilePhase.PHASE_ALL;

/**
 * The core compile
 *
 * @author Kason Yang
 */
public abstract class KalangCompiler extends AstLoader implements CompileContext {

    private int compileTargetPhase = PHASE_ALL;

    private HashMap<String, CompilationUnit> compilationUnits = new HashMap<>();

    @Nonnull
    private final HashMap<String, KalangSource> sources = new HashMap();

    private int compilingPhase;

    private DiagnosisHandler diagnosisHandler = StandardDiagnosisHandler.INSTANCE;

    private Configuration configuration = new Configuration();

    private SourceLoader sourceLoader = new SourceLoader() {
        @Override
        public KalangSource loadSource(String className) {
            return null;
        }
    };

    public KalangCompiler() {
        this(new JavaAstLoader());
    }

    public KalangCompiler(AstLoader astLoader) {
        super(astLoader);
    }

    /**
     * add source,which will be compiled
     *
     * @param className the name of class
     * @param source the source of class
     * @param fileName the file name of source
     */
    public void addSource(String className, String source, String fileName) {
        KalangSource src = new KalangSource(className, source, fileName);
        addSource(src);
    }

    public void addSource(KalangSource source) {
        String className = source.getClassName();
        sources.put(className, source);
        compilationUnits.put(className, createCompilationUnit(source));
    }

    public void setCompileTargetPhase(int targetPhase) {
        compileTargetPhase = targetPhase;
    }

    public int getCompileTargetPhase() {
        return compileTargetPhase;
    }

    public void compile(int targetPhase) {
        while (compilingPhase < targetPhase && compilingPhase < this.compileTargetPhase) {
            compilingPhase++;
            for (CompilationUnit unit : compilationUnits.values()) {
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

    private ClassNode findInnerClass(ClassNode topClass, String className) {
        for (ClassNode c : topClass.classes) {
            if (className.equals(c.name)) {
                return c;
            }
            ClassNode ic = findInnerClass(c, className);
            if (ic != null) {
                return ic;
            }
        }
        return null;
    }

    @Override
    protected ClassNode findAst(@Nonnull String className) throws AstNotFoundException {
        String[] classNameInfo = className.split("\\$", 2);
        String topClassName = classNameInfo[0];
        if (compilationUnits.containsKey(topClassName)) {
            CompilationUnit compilationUnit = compilationUnits.get(topClassName);
            ClassNode clazz = compilationUnit.getAst();
            if (classNameInfo.length == 1) {
                return clazz;
            } else {
                ClassNode c = findInnerClass(clazz, className);
                if (c != null) {
                    return c;
                }
            }
        }
        SourceLoader srcLoader = getSourceLoader();
        if (srcLoader != null) {
            KalangSource source = srcLoader.loadSource(className);
            if (source != null) {
                return createCompilationUnit(source).getAst();
            }
        }
        return super.findAst(className);
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
    public CompilationUnit getCompilationUnit(@Nonnull String className) {
        return compilationUnits.get(className);
    }

    protected CompilationUnit newCompilationUnit(KalangSource source) {
        return new CompilationUnit(source, this);
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
        KalangLexer lexer = LexerFactory.createLexer(source);
        lexer.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                Diagnosis diagnosis = new Diagnosis(
                        compilationUnit.getCompileContext()
                        , Diagnosis.Kind.ERROR
                        , OffsetRange.NONE //TODO fix offset range
                        , "line " + line + ":" + charPositionInLine + " " + msg
                        , compilationUnit.getSource()
                );
                diagnosisHandler.handleDiagnosis(diagnosis);
            }
        });
        return lexer;
    }

    @Override
    public CommonTokenStream createTokenStream(CompilationUnit compilationUnit, KalangLexer lexer) {
        return TokenStreamFactory.createTokenStream(lexer);
    }

    @Override
    public KalangParser createParser(CompilationUnit compilationUnit, CommonTokenStream tokenStream) {
        KalangParser parser = new KalangParser(tokenStream);
        parser.setErrorHandler(new DefaultErrorStrategy() {
            @Override
            public void reportError(Parser recognizer, RecognitionException e) {
                String msg = AntlrErrorString.exceptionString(recognizer, e);
                Diagnosis diagnosis = new Diagnosis(
                        compilationUnit.getCompileContext(),
                         Diagnosis.Kind.ERROR,
                         OffsetRangeHelper.getOffsetRange(e.getOffendingToken()),
                         msg,
                         compilationUnit.getSource()
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
    public SemanticAnalyzer createSemanticAnalyzer(CompilationUnit compilationUnit, AstLoader astLoader) {
        return new SemanticAnalyzer(compilationUnit, astLoader);
    }

    @Override
    public final AstLoader getAstLoader() {
        return this;
    }

    @Override
    public SourceLoader getSourceLoader() {
        return this.sourceLoader;
    }

    public void setSourceLoader(SourceLoader sourceLoader) {
        this.sourceLoader = sourceLoader;
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
