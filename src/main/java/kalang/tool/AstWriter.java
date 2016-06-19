package kalang.tool;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.ast.ClassNode;
import kalang.compiler.CodeGenerator;
import kalang.util.AstOutputUtil;

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
