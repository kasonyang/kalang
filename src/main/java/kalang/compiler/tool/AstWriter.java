package kalang.compiler.tool;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.CodeGenerator;
import kalang.compiler.util.AstOutputUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kason Yang
 */
public class AstWriter implements CodeGenerator{

    OutputManager outputManager;

    public AstWriter(OutputManager outputManager) {
        this.outputManager = outputManager;
    }
    
    @Override
    public void generate(ClassNode classNode) {
        String str = AstOutputUtil.toString(classNode);
        try {
            try (OutputStream os = outputManager.createOutputStream(classNode.name)) {
                os.write(str.getBytes());
            }
        } catch (IOException ex) {
            Logger.getLogger(AstWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
