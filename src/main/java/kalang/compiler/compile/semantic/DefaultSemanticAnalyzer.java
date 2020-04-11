package kalang.compiler.compile.semantic;

import kalang.compiler.compile.MalformedAstException;
import kalang.compiler.compile.*;
import kalang.compiler.compile.semantic.analyzer.AssignmentAnalyzer;
import kalang.compiler.compile.semantic.analyzer.MethodDeclarationAnalyzer;
import kalang.compiler.compile.util.DiagnosisReporter;

/**
 * @author KasonYang
 */
public class DefaultSemanticAnalyzer implements SemanticAnalyzer {

    private CompilationUnit compilationUnit;

    public DefaultSemanticAnalyzer(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }

    @Override
    public void semanticAnalyze() {
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
