package kalang.compiler.compile;

import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.semantic.AstBuilder;
import kalang.compiler.compile.semantic.DefaultSemanticAnalyzer;
import kalang.compiler.compile.util.StandardDiagnosisHandler;
import kalang.compiler.core.ObjectType;
import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;
import kalang.compiler.util.AntlrErrorString;
import kalang.compiler.util.LexerFactory;
import kalang.compiler.util.OffsetRangeHelper;
import kalang.compiler.util.TokenStreamFactory;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

/**
 * The core compiler
 *
 * @author Kason Yang
 */
public abstract class KalangCompiler implements CompileContext, ClassNodeLoader {

    private final CompilePhaseManager compilePhaseManager = new CompilePhaseManager();

    /**
     * key is className
     */
    private final Map<String, CompilationUnitController> compilationUnitCtrlMap =
            new HashMap<>();

    @Nonnull
    private final List<KalangSource> sources = new LinkedList<>();

    private DiagnosisHandler diagnosisHandler = new StandardDiagnosisHandler();

    private final Configuration configuration;

    private SourceLoader sourceLoader = className -> null;
    private CompilePhase compileTargetPhase;
    private CompilePhase compilingPhase;
    private Set<String> notFoundAstSet = new HashSet<>();

    public KalangCompiler() {
        this(new Configuration());
    }

    public KalangCompiler(Configuration configuration) {
        this.configuration = configuration;
        initCompilePhases();
    }

    /**
     * add source,which will be compiled
     *
     * @param className the name of class
     * @param source the source of class
     * @param fileName the file name of source
     * @param script <code>true</code> if the source is a script
     */
    public void addSource(String className, String source, String fileName, boolean script) {
        KalangSource src = new KalangSource(className, source, fileName, script);
        addSource(src);
    }

    public void addSource(String className, String source, String fileName) {
        KalangSource src = new KalangSource(className, source, fileName, fileName != null && fileName.endsWith(".kls"));
        addSource(src);
    }

    public void addSource(KalangSource source) {
        String className = source.getClassName();
        sources.add(source);
        compilationUnitCtrlMap.put(className, createCompilationUnitController(source));
    }

    public void setCompileTargetPhase(String targetPhase) {
        compileTargetPhase = compilePhaseManager.getPhase(targetPhase);
    }

    public String getCompileTargetPhase() {
        return compileTargetPhase.getId();
    }

    public void compile(CompilePhase targetPhase) {
        compilingPhase = compilePhaseManager.getStartPhase();
        while (compilingPhase.isBefore(targetPhase) && compilingPhase.isBefore(this.compileTargetPhase)) {
            compilingPhase = compilingPhase.nextPhase();
            Span span = Profiler.getInstance().beginSpan("compilePhase@" + compilingPhase);
            Set<CompilationUnitController> cUnitCtrlSets = new HashSet<>();
            // compilationUnits may be updated when compiling
            while (cUnitCtrlSets.size() < compilationUnitCtrlMap.size()) {
                HashSet<CompilationUnitController> currentUnitCtrlSet = new HashSet<>(
                        compilationUnitCtrlMap.values()
                );
                for (CompilationUnitController unitCtrl: currentUnitCtrlSet) {
                    if (!cUnitCtrlSets.add(unitCtrl)) {
                        continue;
                    }
                    compileUnitToPhase(unitCtrl, compilingPhase);
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

    public void removeCompilationUnitController(String className) {
        compilationUnitCtrlMap.remove(className);
    }

    @Nullable
    protected CompilationUnitController loadCompilationUnitController(String className) {
        CompilationUnitController cUnitCtrl = compilationUnitCtrlMap.get(className);
        if (cUnitCtrl != null) {
            return cUnitCtrl;
        }
        SourceLoader srcLoader = getSourceLoader();
        if (srcLoader != null) {
            KalangSource source = srcLoader.loadSource(className);
            if (source != null) {
                return createCompilationUnitController(source);
            }
        }
        return null;
    }

    private ClassNode findInnerClass(ClassNode topClass, String className) {
        for (ClassNode c : topClass.classes) {
            if (className.equals(c.getName())) {
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
    public Map<String, CompilationUnit> getCompilationUnits() {
        Map<String, CompilationUnit> result = new HashMap<>();
        for (Map.Entry<String, CompilationUnitController> e : compilationUnitCtrlMap.entrySet()) {
            result.put(e.getKey(), e.getValue().getCompilationUnit());
        }
        return result;
    }

    @Nullable
    public CompilationUnit getCompilationUnit(@Nonnull String className) {
        CompilationUnitController controller = compilationUnitCtrlMap.get(className);
        return controller == null ? null : controller.getCompilationUnit();
    }

    @Override
    public ClassNode getClassNode(String className) {
        Profiler profiler = Profiler.getInstance();
        Span span = profiler.beginSpan(KalangCompiler.class.getName() + ":getClassNode");
        try{
            return doGetClassNode(className);
        }finally {
            profiler.endSpan(span);
        }
    }

    protected ClassNode doGetClassNode(String className) {
        if (notFoundAstSet.contains(className)) {
            return null;
        }
        String[] classNameInfo = className.split("\\$", 2);
        String topClassName = classNameInfo[0];
        CompilationUnitController cUnitCtrl = loadCompilationUnitController(topClassName);
        if (cUnitCtrl != null) {
            ClassNode clazz = cUnitCtrl.getCompilationUnit().getAst();
            if (classNameInfo.length == 1) {
                return clazz;
            } else {
                ClassNode c = findInnerClass(clazz, className);
                if (c != null) {
                    return c;
                }
            }
        }
        ClassNode cn = configuration.getClassNodeLoader().getClassNode(className);
        if (cn != null) {
            return cn;
        }
        notFoundAstSet.add(className);
        return null;
    }

    protected void initCompilePhases() {
        compilePhaseManager.registerPhase(StandardCompilePhases.PARSE_DECLARATION, u ->
            u.getAstBuilder().parseMemberDeclaration(getClassNodeLoader())
        );
        compilePhaseManager.registerPhase(StandardCompilePhases.BUILD_DEFAULT_MEMBERS, u ->
            u.getAstBuilder().buildDefaultMembers()
        );
        compilePhaseManager.registerPhase(StandardCompilePhases.PARSE_BODY, u ->
            u.getAstBuilder().parseMemberBody(getClassNodeLoader())
        );
        compilePhaseManager.registerPhase(StandardCompilePhases.ANALYZE_SEMANTIC, CompilationUnit::analyzeSemantic);
        compilePhaseManager.registerPhase(StandardCompilePhases.GENERATE_CODE, CompilationUnit::generateClass);
        compilingPhase = compilePhaseManager.getStartPhase();
        compileTargetPhase = compilePhaseManager.getLastPhase();
    }

    protected CompilationUnit newCompilationUnit(KalangSource source) {
        return new CompilationUnit(source, this);
    }

    protected CompilationUnitController createCompilationUnitController(KalangSource source) {
        CompilationUnit unit = newCompilationUnit(source);
        CompilationUnitController controller = new CompilationUnitController(unit, compilePhaseManager.getStartPhase());
        compilationUnitCtrlMap.put(source.getClassName(), controller);
        controller.compileToPhase(compilingPhase);
        return controller;
    }

    public CompilePhase getCurrentCompilePhase() {
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
                OffsetRange offset = OffsetRangeHelper.getOffsetRange(e.getOffendingToken());
                reportSyntaxError(compilationUnit, recognizer, msg, offset);
            }

            @Override
            protected void reportUnwantedToken(Parser recognizer) {
                if (inErrorRecoveryMode(recognizer)) {
                    return;
                }
                beginErrorCondition(recognizer);
                Token t = recognizer.getCurrentToken();
                String tokenName = getTokenErrorDisplay(t);
                String msg = "extraneous input " + tokenName;
                recognizer.notifyErrorListeners(t, msg, null);
            }
            protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
                String msg = "mismatched input "+getTokenErrorDisplay(e.getOffendingToken());
                recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
            }
        });
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener(){
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                OffsetRange offset = OffsetRangeHelper.getOffsetRange((Token) offendingSymbol);
                reportSyntaxError(compilationUnit, (Parser) recognizer, msg, offset);
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
    public final ClassNodeLoader getClassNodeLoader() {
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
    public void stopCompile(String stopPhaseId) {
        setCompileTargetPhase(stopPhaseId);
    }

    @Override
    public CompilePhase getCompilingPhase() {
        return this.compilingPhase;
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    protected CompilePhaseManager getCompilePhaseManager() {
        return compilePhaseManager;
    }

    protected void reportSyntaxError(CompilationUnit compilationUnit, Parser recognizer, String msg, OffsetRange offsetRange) {
        Diagnosis diagnosis = new Diagnosis(
                compilationUnit.getCompileContext(),
                Diagnosis.Kind.ERROR,
                offsetRange,
                msg,
                compilationUnit.getSource()
        );
        diagnosisHandler.handleDiagnosis(diagnosis);
    }

    private void compileUnitToPhase(CompilationUnitController unit, CompilePhase targetPhase) {
        ObjectType unitSuperType = unit.getCompilationUnit().getAst().getSuperType();
        String unitSuperClsName = unitSuperType == null ? null : unitSuperType.getName();
        CompilationUnitController superUnitCtrl = unitSuperClsName == null ? null : compilationUnitCtrlMap.get(unitSuperClsName);
        //compile super unit first because subclass may depend on super type
        if (superUnitCtrl != null) {
            compileUnitToPhase(superUnitCtrl, targetPhase);
        }
        unit.compileToPhase(targetPhase);
    }

}
