package kalang.compiler.compile;

import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.semantic.AstBuilder;
import kalang.compiler.compile.semantic.MalformedAstException;
import kalang.compiler.compile.util.DiagnosisReporter;
import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;
import kalang.helper.PrintHelper;
import kalang.mixin.*;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static kalang.compiler.compile.CompilePhase.*;

/**
 *
 * @author Kason Yang 
 */
public class CompilationUnit {

    private final KalangLexer lexer;
    private final KalangParser parser;
    private final AstBuilder astBuilder;
    
    private int compilingPhase;
    
    private final KalangSource source;
    
    private final CompileContext context;

    private final TypeNameResolver typeNameResolver = new TypeNameResolver();

    public Map<String,ClassNode> staticImportMembers = new HashMap<>();

    public List<ClassNode> staticImportPaths = new LinkedList<>();

    public Map<String,ClassNode> importedMixinMethods = new HashMap<>();

    public List<ClassNode> importedMixinPaths = new LinkedList<>();

    public CompilationUnit(@Nonnull KalangSource source,CompileContext context) {
        this.source = source;
        this.context = context;
        lexer = context.createLexer(this,source.getText());
        parser = context.createParser(this,lexer);
        astBuilder = context.createAstBuilder(this,parser);
        //TODO astBuilder.getAstLoader() != context.getAstLoader?
        AstLoader astLoader = context.getAstLoader();
        //should move to configuration?
        astBuilder.importPackage("java.lang");
        astBuilder.importPackage("java.util");
        astBuilder.importPackage("java.net");
        astBuilder.importPackage("java.io");
        astBuilder.importPackage("java.nio");
        astBuilder.importPackage("kalang.io");
        astBuilder.importPackage("kalang.util");
        astBuilder.importPackage("kalang.lang");
        astBuilder.importStaticMember(astLoader.loadAst(PrintHelper.class.getName()),null);
        astBuilder.importMixinMethod(astLoader.loadAst(CollectionMixin.class.getName()),null);
        astBuilder.importMixinMethod(astLoader.loadAst(StringMixin.class.getName()),null);
        astBuilder.importMixinMethod(astLoader.loadAst(IOMixin.class.getName()),null);
        astBuilder.importMixinMethod(astLoader.loadAst(DigestMixin.class.getName()),null);
        astBuilder.importMixinMethod(astLoader.loadAst(DataMixin.class.getName()),null);
        astBuilder.importMixinMethod(astLoader.loadAst(ObjectMixin.class.getName()), null);
        astBuilder.importMixinMethod(astLoader.loadAst(PropertiesMixin.class.getName()), null);
        compile(PHASE_INITIALIZE);
    }
    
    protected void doCompilePhase(int phase){
        DiagnosisReporter dnReporter = new DiagnosisReporter(this);
        if(phase == PHASE_INITIALIZE){
            parse(AstBuilder.PARSING_PHASE_INIT);
        }else if(phase == PHASE_PARSING){
            parse(AstBuilder.PARSING_PHASE_META);
        }else if(phase == PHASE_BUILDAST) {
            parse(AstBuilder.PARSING_PHASE_ALL);
        }else if(phase == PHASE_SEMANTIC) {
            SemanticAnalyzer smtAnalyzer = context.createSemanticAnalyzer(this);
            if (smtAnalyzer == null) {
                throw new IllegalArgumentException("SemanticAnalyzer is missing");
            }
            smtAnalyzer.semanticAnalyze();
        }else if(phase == PHASE_CLASSGEN){
            CodeGenerator codeGenerator = context.createCodeGenerator(this);
            if(codeGenerator == null){
                throw new IllegalStateException("CodeGenerator is missing");
            }
            try {
                codeGenerator.generateCode();
            } catch (MalformedAstException ex) {
                dnReporter.report(Diagnosis.Kind.ERROR, ex.getMessage(), ex.getMalformedNode().offset);
            }
        }
    }
    
    public void compile(int targetPhase){
        while(compilingPhase<targetPhase){
            compilingPhase++;
            Span span = Profiler.getInstance().beginSpan("compilationPhase@" + compilingPhase);
            doCompilePhase(compilingPhase);
            Profiler.getInstance().endSpan(span);
        }
    }

    protected void parse(int targetParsingPhase) {
        astBuilder.compile(targetParsingPhase,context.getAstLoader());
    }

    @Nonnull
    public ClassNode getAst() {
        return astBuilder.getAst();
    }

    @Nonnull
    public AstBuilder getAstBuilder() {
        return astBuilder;
    }

    public KalangLexer getLexer() {
        return lexer;
    }

    public KalangParser getParser() {
        return parser;
    }

    public KalangSource getSource() {
        return source;
    }

    public CompileContext getCompileContext() {
        return context;
    }

    public TypeNameResolver getTypeNameResolver() {
        return typeNameResolver;
    }

}
