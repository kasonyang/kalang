
package kalang.compiler.compile;
import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.compile.codegen.Ast2JavaStub;
import kalang.compiler.compile.semantic.DefaultSemanticAnalyzer;
import kalang.compiler.util.LexerFactory;
import kalang.compiler.util.TokenStreamFactory;
import org.antlr.v4.runtime.CommonTokenStream;
/**
 *
 * @author Kason Yang
 */
public class DefaultCompileContext implements CompileContext{

    @Override
    public KalangLexer createLexer(CompilationUnit compilationUnit, String source) {
        return LexerFactory.createLexer(source);
    }

    @Override
    public CommonTokenStream createTokenStream(CompilationUnit compilationUnit, KalangLexer lexer) {
        return TokenStreamFactory.createTokenStream(lexer);
    }

    @Override
    public KalangParser createParser(CompilationUnit compilationUnit, CommonTokenStream tokenStream) {
        return new KalangParser(tokenStream);
    }

    @Override
    public AstBuilder createAstBuilder(CompilationUnit compilationUnit, KalangParser parser) {
        return new AstBuilder(compilationUnit, parser);
    }

    @Override
    public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
        return new Ast2JavaStub();
    }

    @Override
    public SemanticAnalyzer createSemanticAnalyzer(CompilationUnit compilationUnit, AstLoader astLoader) {
        return new DefaultSemanticAnalyzer();
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
    public void stopCompile(int stopPhase) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCompilingPhase() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Configuration getConfiguration() {
        return new Configuration();
    }


}
