
package kalang.compiler.compile;
import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import org.antlr.v4.runtime.CommonTokenStream;
/**
 *
 * @author Kason Yang 
 */
public interface CompileContext {
    
    KalangLexer createLexer(CompilationUnit compilationUnit,String source);
    
    CommonTokenStream createTokenStream(CompilationUnit compilationUnit,KalangLexer lexer);
    
    KalangParser createParser(CompilationUnit compilationUnit,CommonTokenStream tokenStream);
    
    AstBuilder createAstBuilder(CompilationUnit compilationUnit,KalangParser parser);
    
    CodeGenerator createCodeGenerator(CompilationUnit compilationUnit);

    SemanticAnalyzer createSemanticAnalyzer(CompilationUnit compilationUnit, AstLoader astLoader);
    
    AstLoader getAstLoader();

    public SourceLoader getSourceLoader();
    
    public DiagnosisHandler getDiagnosisHandler();
    
    void stopCompile(int stopPhase);
    
    int getCompilingPhase();
    
    Configuration getConfiguration();

}
