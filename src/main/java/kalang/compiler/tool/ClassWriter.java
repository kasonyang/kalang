package kalang.compiler.tool;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.CodeGenerator;
import kalang.compiler.compile.codegen.Ast2Class;

/**
 *
 * @author Kason Yang
 */
public class ClassWriter implements CodeGenerator{

    private OutputManager outputManager;

    public ClassWriter(OutputManager outputManager) {
        this.outputManager = outputManager;
    }

    @Override
    public void generate(ClassNode classNode) {
        if (outputManager != null) {
            Ast2Class ast2class = new Ast2Class(outputManager);
            ast2class.generate(classNode);
        }
    }
    
}
