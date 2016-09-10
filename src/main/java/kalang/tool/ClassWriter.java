package kalang.tool;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.ast.ClassNode;
import kalang.compiler.CodeGenerator;
import kalang.compiler.codegen.Ast2Class;

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
