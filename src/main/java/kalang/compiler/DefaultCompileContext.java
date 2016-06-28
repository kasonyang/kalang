
package kalang.compiler;
import kalang.compiler.codegen.Ast2Java;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import kalang.util.LexerFactory;
import kalang.util.TokenStreamFactory;
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
        return new Ast2Java();
    }

    @Override
    public SemanticAnalyzer createSemanticAnalyzer(CompilationUnit compilationUnit, AstLoader astLoader) {
        return new SemanticAnalyzer(compilationUnit, astLoader);
    }

    @Override
    public AstLoader getAstLoader() {
        return AstLoader.BASE_AST_LOADER;
    }

    @Override
    public SourceLoader getSourceLoader() {
        return new SourceLoader() {
            @Override
            public KalangSource loadSource(String className) {
                return null;
            }
        };
    }

    @Override
    public CompileErrorHandler getCompileErrorHandler() {
        return StandardCompileHandler.INSTANCE;
    }

}
