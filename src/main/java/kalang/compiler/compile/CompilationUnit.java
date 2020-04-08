package kalang.compiler.compile;

import kalang.compiler.MalformedAstException;
import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.analyzer.AssignmentAnalyzer;
import kalang.compiler.compile.analyzer.MethodDeclarationAnalyzer;
import kalang.compiler.profile.Profiler;
import kalang.compiler.profile.Span;
import kalang.helper.*;
import kalang.mixin.*;
import org.antlr.v4.runtime.CommonTokenStream;

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
    
    private final SemanticAnalyzer semanticAnalyzer;
    
    private final CommonTokenStream tokens;
    
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
        tokens = context.createTokenStream(this,lexer);
        parser = context.createParser(this,tokens);
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
        semanticAnalyzer = context.createSemanticAnalyzer(this,astLoader);
        compile(PHASE_INITIALIZE);
    }
    
    protected void doCompilePhase(int phase){
        if(phase==PHASE_INITIALIZE){
            parseInit(context.getDiagnosisHandler());
        }else if(phase==PHASE_PARSING){
            parseMeta(context.getDiagnosisHandler());
        }else if(phase == PHASE_BUILDAST) {
            parseBody(context.getDiagnosisHandler());
        }else if(phase == PHASE_SEMANTIC) {
            new MethodDeclarationAnalyzer().analyze(this, getAst());
            new AssignmentAnalyzer().analyze(this);
            AstVerifier astVerifier = new AstVerifier();
            try {
                astVerifier.visit(getAst());
            } catch (MalformedAstException ex) {
                this.astBuilder.handleSyntaxError(ex.getMessage(), ex.getMalformedNode().offset);
            }
        }else if(phase == PHASE_CLASSGEN){
            CodeGenerator codeGenerator = context.createCodeGenerator(this);
            if(codeGenerator==null){
                throw new IllegalStateException("CodeGenerator is missing");
            }
            try {
                codeGenerator.generate(this.getAst());
            } catch (MalformedAstException ex) {
                this.astBuilder.handleSyntaxError(ex.getMessage(), ex.getMalformedNode().offset);
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
    
    protected void parseInit(DiagnosisHandler semanticErrorHandler){
        parse(semanticErrorHandler,AstBuilder.PARSING_PHASE_INIT);
    }
    
    protected void parseMeta(DiagnosisHandler semanticErrorHandler){
        parse(semanticErrorHandler, AstBuilder.PARSING_PHASE_META);
    }
    
    public void parseBody(DiagnosisHandler semanticErrorHandler){
        parse(semanticErrorHandler, AstBuilder.PARSING_PHASE_ALL);
    }

    protected void parse(DiagnosisHandler semanticErrorHandler, int targetParsingPhase) {
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

    @Nonnull
    public SemanticAnalyzer getSemanticAnalyzer() {
        return semanticAnalyzer;
    }

    @Nonnull
    public CommonTokenStream getTokenStream() {
        return tokens;
    }

    public KalangLexer getLexer() {
        return lexer;
    }

    public KalangParser getParser() {
        return parser;
    }

    public CommonTokenStream getTokens() {
        return tokens;
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
