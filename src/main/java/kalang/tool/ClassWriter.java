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
        String cls = classNode.name;
        if (outputManager != null) {
            try {
                OutputStream os = outputManager.createOutputStream(cls);
                os.write(generateClassBytes(classNode));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
    private byte[] generateClassBytes(ClassNode clazz){
        Ast2Class ast2Class = new Ast2Class();
        ast2Class.generate(clazz);
        return ast2Class.getClassBytes();
    }

}
