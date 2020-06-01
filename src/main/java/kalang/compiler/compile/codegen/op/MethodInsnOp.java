package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class MethodInsnOp extends OpBase {

    public String owner;
    public String name;
    public String descriptor;
    public boolean isInterface;

    public MethodInsnOp(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        this.opcode = opcode;
        this.owner = owner;
        this.name = name;
        this.descriptor = descriptor;
        this.isInterface = isInterface;
    }
}
