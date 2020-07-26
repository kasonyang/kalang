
package kalang.compiler.compile;
import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.antlr.KalangParser;
import kalang.compiler.compile.semantic.AstBuilder;

/**
 *
 * @author Kason Yang 
 */
public interface CompileContext {
    
    KalangLexer createLexer(CompilationUnit compilationUnit,String source);
    
    KalangParser createParser(CompilationUnit compilationUnit,KalangLexer lexer);
    
    AstBuilder createAstBuilder(CompilationUnit compilationUnit, KalangParser parser);

    SemanticAnalyzer createSemanticAnalyzer(CompilationUnit compilationUnit);

    CodeGenerator createCodeGenerator(CompilationUnit compilationUnit);
    
    AstLoader getAstLoader();

    SourceLoader getSourceLoader();
    
    DiagnosisHandler getDiagnosisHandler();
    
    void stopCompile(String stopPhaseId);
    
    CompilePhase getCompilingPhase();
    
    Configuration getConfiguration();

}
