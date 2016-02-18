package kalang.compiler;

import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.ast.ClassNode;
import kalang.util.SourceUnitFactory;
import kalang.util.TokenStreamFactory;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class CompilationUnit {

    private final SourceUnit sourceUnit;

    private  SemanticAnalyzer semanticAnalyzer;

    private final ClassNode ast;
    private final AstLoader astLoader;
    private Ast2Java a2j;
    private String javaCode;
    private CommonTokenStream tokens;

    public CompilationUnit(String className, String source, AstLoader astLoader) {
        tokens = TokenStreamFactory.createTokenStream(source);
        sourceUnit = SourceUnitFactory.createSourceUnit(className, tokens);
        sourceUnit.importPackage("java.lang");
        sourceUnit.importPackage("java.util");
        ast = sourceUnit.getAst();
        this.astLoader = astLoader;
        semanticAnalyzer = new SemanticAnalyzer(astLoader);
    }

    public CompilationUnit(String className, String source) {
        this(className, source, AstLoader.BASE_AST_LOADER);
    }

    public void parse(SourceParsingErrorHandler semanticErrorHandler) {
        sourceUnit.setSemanticErrorHandler(semanticErrorHandler);
        sourceUnit.compile(astLoader);
    }

    public void semanticAnalysis(AstSemanticErrorHandler handler) {
        semanticAnalyzer.setAstSemanticErrorHandler(handler);
        semanticAnalyzer.check(ast);
    }

    public void generateJavaCode() {
        a2j = new Ast2Java();
        javaCode = a2j.generate(ast);
    }

    public ClassNode getAst() {
        return ast;
    }

    public SourceUnit getSourceUnit() {
        return sourceUnit;
    }

    public SemanticAnalyzer getSemanticAnalyzer() {
        return semanticAnalyzer;
    }

    public AstLoader getAstLoader() {
        return astLoader;
    }

    public String getJavaCode() {
        return javaCode;
    }

    public CommonTokenStream getTokenStream() {
        return tokens;
    }

}
