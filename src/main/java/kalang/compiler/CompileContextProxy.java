
package kalang.compiler;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import org.antlr.v4.runtime.CommonTokenStream;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class CompileContextProxy implements CompileContext{
    
    private CompileContext config;

    public CompileContextProxy(CompileContext config) {
        this.config = config;
    }

    @Override
    public KalangLexer createLexer(CompilationUnit compilationUnit, String source) {
        return config.createLexer(compilationUnit, source);
    }

    @Override
    public CommonTokenStream createTokenStream(CompilationUnit compilationUnit, KalangLexer lexer) {
        return config.createTokenStream(compilationUnit, lexer);
    }

    @Override
    public KalangParser createParser(CompilationUnit compilationUnit, CommonTokenStream tokenStream) {
        return config.createParser(compilationUnit, tokenStream);
    }

    @Override
    public AstBuilder createAstBuilder(CompilationUnit compilationUnit, KalangParser parser) {
        return config.createAstBuilder(compilationUnit, parser);
    }

    @Override
    public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
        return config.createCodeGenerator(compilationUnit);
    }

    @Override
    public SemanticAnalyzer createSemanticAnalyzer(CompilationUnit compilationUnit, AstLoader astLoader) {
        return config.createSemanticAnalyzer(compilationUnit, astLoader);
    }

    @Override
    public AstLoader getAstLoader() {
        return config.getAstLoader();
    }

    @Override
    public SourceLoader getSourceLoader() {
        return config.getSourceLoader();
    }

    @Override
    public DiagnosisHandler getDiagnosisHandler() {
        return config.getDiagnosisHandler();
    }


    
}
