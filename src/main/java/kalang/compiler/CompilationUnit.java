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

    public void parse(SourceParsingErrorHandler semanticErrorHandler) {
        sourceUnit.setSemanticErrorHandler(semanticErrorHandler);
        sourceUnit.compile(astLoader);
    }

    public void semanticAnalysis(AstSemanticErrorHandler handler) {
        semanticAnalyzer.setAstSemanticErrorHandler(handler);
        semanticAnalyzer.check(ast);
    }

    @Nonnull
    public void generateJavaCode() {
        javaCode = a2j.generate(ast);
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

}
