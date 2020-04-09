package kalang.compiler.compile.semantic;

import kalang.compiler.MalformedAstException;
import kalang.compiler.compile.*;
import kalang.compiler.compile.analyzer.AssignmentAnalyzer;
import kalang.compiler.compile.analyzer.MethodDeclarationAnalyzer;

/**
 * @author KasonYang
 */
public class DefaultSemanticAnalyzer implements SemanticAnalyzer {

    @Override
    public void semanticAnalyze(CompilationUnit compilationUnit) {
        DiagnosisReporter dnReporter = new DiagnosisReporter(compilationUnit);
        new MethodDeclarationAnalyzer().analyze(compilationUnit);
        new AssignmentAnalyzer().analyze(compilationUnit);
        try {
            new AstVerifier().visit(compilationUnit.getAst());
        } catch (MalformedAstException ex) {
            dnReporter.report(Diagnosis.Kind.ERROR, ex.getMessage(), ex.getMalformedNode().offset);
        }
    }

}
