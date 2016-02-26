package kalang.compiler;

import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
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

    private final SourceUnit sourceUnit;

    private final SemanticAnalyzer semanticAnalyzer;

    @Nonnull
    private final ClassNode ast;
    private final AstLoader astLoader;
    private final Ast2Java a2j;
    private String javaCode = "";
    private final CommonTokenStream tokens;
    private byte[] classBytes;
    
    private int compilingPhase;
    private SourceParsingErrorHandler parsingErrorHandler;
    private AstSemanticErrorHandler semanticErrorHandler;

    public CompilationUnit(@Nonnull String className,@Nonnull String source,@Nonnull AstLoader astLoader) {
        tokens = TokenStreamFactory.createTokenStream(source);
        sourceUnit = SourceUnitFactory.createSourceUnit(className, tokens);
        sourceUnit.importPackage("java.lang");
        sourceUnit.importPackage("java.util");
        ast = sourceUnit.getAst();
        this.astLoader = astLoader;
        semanticAnalyzer = new SemanticAnalyzer(astLoader);
        a2j = new Ast2Java();
    }

    public CompilationUnit(@Nonnull String className,@Nonnull String source) {
        this(className, source, AstLoader.BASE_AST_LOADER);
    }
    
    private void doCompilePhase(int phase){
        if(phase==PHASE_INITIALIZE){
            
        }else if(phase==PHASE_PARSING){
            parseMeta(parsingErrorHandler);
        }else if(phase == PHASE_BUILDAST){
            parseBody(parsingErrorHandler);
        }else if(phase==PHASE_SEMANTIC){
            semanticAnalysis(semanticErrorHandler);
        }else if(phase == PHASE_CLASSGEN){
            generateJavaCode();
            generateClassBytes();
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

    protected void generateJavaCode() {
        javaCode = a2j.generate(ast);
    }
    
    protected void generateClassBytes(){
        Ast2Class a2c = new Ast2Class();
        a2c.generate(ast);
        classBytes = a2c.getClassBytes();
    }
    
    public byte [] getClassBytes(){
        return classBytes;
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
    public String getJavaCode() {
        return javaCode;
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
    
    

}
