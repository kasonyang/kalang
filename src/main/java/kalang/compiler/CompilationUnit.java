package kalang.compiler;

import javax.annotation.Nonnull;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import kalang.ast.ClassNode;
import org.antlr.v4.runtime.CommonTokenStream;
import static kalang.compiler.CompilePhase.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class CompilationUnit {

    private final KalangLexer lexer;
    private final KalangParser parser;
    private final AstBuilder astBuilder;
    
    private final SemanticAnalyzer semanticAnalyzer;
    
    @Nonnull
    private final ClassNode ast;
    
    private final CommonTokenStream tokens;
    
    private int compilingPhase;
    
    private final KalangSource source;
    
    private final CompileContext context;

    public CompilationUnit(@Nonnull KalangSource source,CompileContext context) {
        this.source = source;
        this.context = context;
        lexer = context.createLexer(this,source.getText());
        tokens = context.createTokenStream(this,lexer);
        parser = context.createParser(this,tokens);
        astBuilder = context.createAstBuilder(this,parser);
        //should move to configuration?
        astBuilder.importPackage("java.lang");
        astBuilder.importPackage("java.util");
        astBuilder.importPackage("java.net");
        astBuilder.importPackage("java.io");
        astBuilder.importPackage("java.nio");
        astBuilder.importPackage("kalang.io");
        ast = astBuilder.getAst();        
        semanticAnalyzer = context.createSemanticAnalyzer(this,context.getAstLoader());
    }
    
    protected void doCompilePhase(int phase){
        if(phase==PHASE_INITIALIZE){
            
        }else if(phase==PHASE_PARSING){
            parseMeta(context.getCompileErrorHandler());
        }else if(phase == PHASE_BUILDAST){
            parseBody(context.getCompileErrorHandler());
        }else if(phase==PHASE_SEMANTIC){
            semanticAnalysis(context.getCompileErrorHandler());
        }else if(phase == PHASE_CLASSGEN){
            CodeGenerator codeGenerator = context.createCodeGenerator(this);
            if(codeGenerator==null){
                throw new IllegalStateException("CodeGenerator is missing");
            }
            codeGenerator.generate(ast);
        }
    }
    
    public void compile(int targetPhase){
        while(compilingPhase<targetPhase){
            compilingPhase++;
            doCompilePhase(compilingPhase);
        }
    }
    
    protected void parseMeta(CompileErrorHandler semanticErrorHandler){
        parse(semanticErrorHandler, AstBuilder.PARSING_PHASE_META);
    }
    
    public void parseBody(CompileErrorHandler semanticErrorHandler){
        parse(semanticErrorHandler, AstBuilder.PARSING_PHASE_ALL);
    }

    protected void parse(CompileErrorHandler semanticErrorHandler, int targetParsingPhase) {
        astBuilder.setErrorHandler(semanticErrorHandler);
        astBuilder.compile(targetParsingPhase,context.getAstLoader());
    }

    protected void semanticAnalysis(CompileErrorHandler handler) {
        semanticAnalyzer.setAstSemanticErrorHandler(handler);
        semanticAnalyzer.check(ast);
    }

    @Nonnull
    public ClassNode getAst() {
        return ast;
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

}
