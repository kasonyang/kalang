package kalang.compiler.tool;

import kalang.compiler.compile.ClassNodeLoader;
import kalang.compiler.compile.CodeGenerator;
import kalang.compiler.compile.CompilationUnit;
import kalang.compiler.compile.codegen.Ast2Class;

/**
 *
 * @author Kason Yang
 */
public class ClassWriter implements CodeGenerator{

    private OutputManager outputManager;

    private ClassNodeLoader classNodeLoader;

    private CompilationUnit compilationUnit;

    public ClassWriter(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }

    public ClassWriter(OutputManager outputManager, ClassNodeLoader classNodeLoader, CompilationUnit compilationUnit) {
        this.outputManager = outputManager;
        this.classNodeLoader = classNodeLoader;
        this.compilationUnit = compilationUnit;
    }

    @Override
    public void generateCode() {
        if (outputManager != null) {
            Ast2Class ast2class = new Ast2Class(outputManager, classNodeLoader, compilationUnit);
            ast2class.generateCode();
        }
    }
    
}
