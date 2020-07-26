
package kalang.compiler.compile.util;
import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.compile.*;
import kalang.compiler.compile.codegen.Ast2JavaStub;
import kalang.compiler.compile.semantic.DefaultSemanticAnalyzer;
import kalang.compiler.compile.semantic.AstBuilder;
import kalang.compiler.util.LexerFactory;
import kalang.compiler.util.TokenStreamFactory;
import org.antlr.v4.runtime.CommonTokenStream;
/**
 *
 * @author Kason Yang
 */
public class DefaultCompileContext implements CompileContext {

    @Override
    public KalangLexer createLexer(CompilationUnit compilationUnit, String source) {
        return LexerFactory.createLexer(source);
    }

    @Override
    public KalangParser createParser(CompilationUnit compilationUnit, KalangLexer lexer) {
        CommonTokenStream tokenStream = TokenStreamFactory.createTokenStream(lexer);
        return new KalangParser(tokenStream);
    }

    @Override
    public AstBuilder createAstBuilder(CompilationUnit compilationUnit, KalangParser parser) {
        return new AstBuilder(compilationUnit, parser);
    }

    @Override
    public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
        return new Ast2JavaStub(compilationUnit);
    }

    @Override
    public SemanticAnalyzer createSemanticAnalyzer(CompilationUnit compilationUnit) {
        return new DefaultSemanticAnalyzer(compilationUnit);
    }

    @Override
    public AstLoader getAstLoader() {
        return AstLoader.BASE_AST_LOADER;
    }

    @Override
    public SourceLoader getSourceLoader() {
        return className -> null;
    }

    @Override
    public DiagnosisHandler getDiagnosisHandler() {
        return StandardDiagnosisHandler.INSTANCE;
    }

    @Override
    public void stopCompile(String stopPhaseId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CompilePhase getCompilingPhase() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Configuration getConfiguration() {
        return new Configuration();
    }


}
