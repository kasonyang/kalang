
package kalang.compiler.compile;
import kalang.compiler.ast.ClassNode;
/**
 *
 * @author Kason Yang 
 */
public interface CodeGenerator {
    
    void generate(ClassNode classNode);
    
}
