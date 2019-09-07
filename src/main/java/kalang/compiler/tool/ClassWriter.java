package kalang.compiler.tool;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.AstLoader;
import kalang.compiler.compile.CodeGenerator;
import kalang.compiler.compile.codegen.Ast2Class;

/**
 *
 * @author Kason Yang
 */
public class ClassWriter implements CodeGenerator{

    private OutputManager outputManager;

    private AstLoader astLoader;

    public ClassWriter(OutputManager outputManager, AstLoader astLoader) {
        this.outputManager = outputManager;
        this.astLoader = astLoader;
    }

    @Override
    public void generate(ClassNode classNode) {
        if (outputManager != null) {
            Ast2Class ast2class = new Ast2Class(outputManager, astLoader);
            ast2class.generate(classNode);
        }
    }
    
}
