package kalang.compiler;

import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import kalang.ast.ClassNode;
import kalang.util.SourceUnitFactory;
import kalang.util.TokenStreamFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import static kalang.compiler.CompilePhase.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class CompilationUnit {

    private SourceUnit sourceUnit;

    private SemanticAnalyzer semanticAnalyzer;
    
    @Nonnull
    private ClassNode ast;
    private AstLoader astLoader;
    private CommonTokenStream tokens;
    
    private int compilingPhase;
    private SourceParsingErrorHandler parsingErrorHandler;
    private AstSemanticErrorHandler semanticErrorHandler;
    private CodeGenerator codeGenerator;

    public CompilationUnit(@Nonnull String className,@Nonnull String source,@Nonnull AstLoader astLoader) {
        this.astLoader = astLoader;
        init(className,source);
    }
    
    private void init(String className, String source){
        tokens =createTokenStream(source);
        sourceUnit = createSourceUnit(className, tokens);
        sourceUnit.importPackage("java.lang");
        sourceUnit.importPackage("java.util");
        ast = sourceUnit.getAst();        
        semanticAnalyzer = new SemanticAnalyzer(astLoader);
    }

    public CompilationUnit(@Nonnull String className,@Nonnull String source,CompileConfiguration configuration) {
        this(className, source, AstLoader.BASE_AST_LOADER);
    }
    
    protected CommonTokenStream createTokenStream(String source){
        return TokenStreamFactory.createTokenStream(source);
    }
    
    protected SourceUnit createSourceUnit(String className,CommonTokenStream tokens){
        return SourceUnitFactory.createSourceUnit(className, tokens);
    }
    
    protected void doCompilePhase(int phase){
        if(phase==PHASE_INITIALIZE){
            
        }else if(phase==PHASE_PARSING){
            parseMeta(parsingErrorHandler);
        }else if(phase == PHASE_BUILDAST){
            parseBody(parsingErrorHandler);
        }else if(phase==PHASE_SEMANTIC){
            semanticAnalysis(semanticErrorHandler);
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
    
    protected void parseMeta(SourceParsingErrorHandler semanticErrorHandler){
        parse(semanticErrorHandler, SourceUnit.PARSING_PHASE_META);
    }
    
    public void parseBody(SourceParsingErrorHandler semanticErrorHandler){
        parse(semanticErrorHandler, SourceUnit.PARSING_PHASE_ALL);
    }

    protected void parse(SourceParsingErrorHandler semanticErrorHandler, int targetParsingPhase) {
        sourceUnit.setSemanticErrorHandler(semanticErrorHandler);
        sourceUnit.compile(targetParsingPhase,astLoader);
    }

    protected void semanticAnalysis(AstSemanticErrorHandler handler) {
        semanticAnalyzer.setAstSemanticErrorHandler(handler);
        semanticAnalyzer.check(ast);
    }

    @Nonnull
    public ClassNode getAst() {
        return ast;
    }

    @Nonnull
    public SourceUnit getSourceUnit() {
        return sourceUnit;
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

    public void setParsingErrorHandler(SourceParsingErrorHandler parsingErrorHandler) {
        this.parsingErrorHandler = parsingErrorHandler;
    }

    public void setSemanticErrorHandler(AstSemanticErrorHandler semanticErrorHandler) {
        this.semanticErrorHandler = semanticErrorHandler;
    }

    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    public void setCodeGenerator(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

}
