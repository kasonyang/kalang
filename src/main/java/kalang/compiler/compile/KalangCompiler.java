package kalang.compiler.compile;

import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.util.StandardDiagnosisHandler;
import kalang.compiler.compile.semantic.DefaultSemanticAnalyzer;
import kalang.compiler.compile.semantic.AstBuilder;
import kalang.compiler.profile.Invocation;
import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;
import kalang.compiler.util.AntlrErrorString;
import kalang.compiler.util.LexerFactory;
import kalang.compiler.util.OffsetRangeHelper;
import kalang.compiler.util.TokenStreamFactory;
import org.antlr.v4.runtime.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

import static kalang.compiler.compile.CompilePhase.PHASE_ALL;

/**
 * The core compiler
 *
 * @author Kason Yang
 */
public abstract class KalangCompiler implements CompileContext {

    private int compileTargetPhase = PHASE_ALL;

    private HashMap<String, CompilationUnit> compilationUnits = new HashMap<>();

    @Nonnull
    private final List<KalangSource> sources = new LinkedList<>();

    private int compilingPhase;

    private DiagnosisHandler diagnosisHandler = StandardDiagnosisHandler.INSTANCE;

    private final Configuration configuration;

    private final AstLoader astLoader;

    private SourceLoader sourceLoader = className -> null;

    public KalangCompiler() {
        this(new Configuration());
    }

    public KalangCompiler(Configuration configuration) {
        this.configuration = configuration;
        this.astLoader = new AstLoader(configuration.getAstLoader()){

            private Set<String> notFoundAstSet = new HashSet<>();

            @Override
            protected ClassNode findAst(@Nonnull String className) throws AstNotFoundException {
                Profiler profiler = Profiler.getInstance();
                Invocation invocation = profiler.beginInvocation(KalangCompiler.class.getName() + ":findAst");
                try{
                    return doFindAst(className);
                }finally {
                    profiler.endInvocation(invocation);
                }
            }

            protected ClassNode doFindAst(@Nonnull String className) throws AstNotFoundException {
                if (notFoundAstSet.contains(className)) {
                    throw new AstNotFoundException(className);
                }
                String[] classNameInfo = className.split("\\$", 2);
                String topClassName = classNameInfo[0];
                CompilationUnit compilationUnit = compilationUnits.get(topClassName);
                if (compilationUnit != null) {
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
                notFoundAstSet.add(className);
                throw new AstNotFoundException(className);
            }
        };
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
        sources.add(source);
        compilationUnits.put(className, createCompilationUnit(source));
    }

    public void setCompileTargetPhase(int targetPhase) {
        compileTargetPhase = targetPhase;
    }

    public int getCompileTargetPhase() {
        return compileTargetPhase;
    }

    public void compile(int targetPhase) {
        compilingPhase = CompilePhase.PHASE_INITIALIZE;
        while (compilingPhase < targetPhase && compilingPhase < this.compileTargetPhase) {
            compilingPhase++;
            Span span = Profiler.getInstance().beginSpan("compilePhase@" + compilingPhase);
            Set<CompilationUnit> compiledUnits = new HashSet<>();
            // compilationUnits may be updated when compiling
            while (compiledUnits.size() < compilationUnits.size()) {
                HashSet<CompilationUnit> currentUnitSet = new HashSet<>(compilationUnits.values());
                for (CompilationUnit unit: currentUnitSet) {
                    if (!compiledUnits.add(unit)) {
                        continue;
                    }
                    unit.compile(compilingPhase);
                }
            }
            Profiler.getInstance().endSpan(span);
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

    @Nonnull
    public KalangSource[] getSources() {
        return sources.toArray(new KalangSource[0]);
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
    public KalangParser createParser(CompilationUnit compilationUnit, KalangLexer lexer) {
        CommonTokenStream tokenStream = TokenStreamFactory.createTokenStream(lexer);
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
    public SemanticAnalyzer createSemanticAnalyzer(CompilationUnit compilationUnit) {
        return new DefaultSemanticAnalyzer(compilationUnit);
    }

    @Override
    public final AstLoader getAstLoader() {
        return this.astLoader;
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

}
