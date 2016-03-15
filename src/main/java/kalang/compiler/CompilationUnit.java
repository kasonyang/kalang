package kalang.compiler;

import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import kalang.ast.ClassNode;
import kalang.util.AstBuilderFactory;
import kalang.util.TokenStreamFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import static kalang.compiler.CompilePhase.*;
import kalang.util.LexerFactory;
import org.antlr.v4.runtime.TokenStream;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class CompilationUnit {

    private KalangLexer lexer;
    private KalangParser parser;
    private AstBuilder astBuilder;
    
    private SemanticAnalyzer semanticAnalyzer;
    
    private CodeGenerator codeGenerator;
    
    @Nonnull
    private ClassNode ast;
    private AstLoader astLoader;
    private CommonTokenStream tokens;
    
    private int compilingPhase;
    
    private CompileErrorHandler errorHandler;
    private KalangSource source;

    public CompilationUnit(@Nonnull KalangSource source,@Nonnull AstLoader astLoader) {
        this.astLoader = astLoader;
        init(source);
    }
    
    private void init(KalangSource source){
        this.source = source;
        lexer = createLexer(source.getText());
        tokens = createTokenStream(lexer);
        parser = createParser(tokens);
        astBuilder = createAstBuilder(this, tokens);
        astBuilder.importPackage("java.lang");
        astBuilder.importPackage("java.util");
        ast = astBuilder.getAst();        
        semanticAnalyzer = new SemanticAnalyzer(this,astLoader);
    }
    
    protected CommonTokenStream createTokenStream(KalangLexer lexer){
        return TokenStreamFactory.createTokenStream(lexer);
    }
    
    protected AstBuilder createAstBuilder(CompilationUnit source , CommonTokenStream tokens){
        return AstBuilderFactory.createAstBuilder(source, tokens);
    }
    
    protected void doCompilePhase(int phase){
        if(phase==PHASE_INITIALIZE){
            
        }else if(phase==PHASE_PARSING){
            parseMeta(errorHandler);
        }else if(phase == PHASE_BUILDAST){
            parseBody(errorHandler);
        }else if(phase==PHASE_SEMANTIC){
            semanticAnalysis(errorHandler);
        }else if(phase == PHASE_CLASSGEN){
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
        astBuilder.compile(targetParsingPhase,astLoader);
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
    public AstLoader getAstLoader() {
        return astLoader;
    }

    @Nonnull
    public CommonTokenStream getTokenStream() {
        return tokens;
    }

    public CompileErrorHandler getErrorHandler() {
        return errorHandler;
    }

    public void setErrorHandler(CompileErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    public void setCodeGenerator(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    protected KalangLexer createLexer(String source) {
        return LexerFactory.createLexer(source);
    }

    protected KalangParser createParser(TokenStream tokenStream) {
        return new KalangParser(tokenStream);
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
