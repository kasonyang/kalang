package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class FieldInsnOp extends OpBase {
    public int opcode;
    public String owner;
    public String name;
    public String descriptor;

    public FieldInsnOp(int opcode, String owner, String name, String descriptor) {
        this.opcode = opcode;
        this.owner = owner;
        this.name = name;
        this.descriptor = descriptor;
    }

    @Override
    public String toString() {
        return String.format("%s %s.%s", OPC_DESC[opcode], owner, name);
    }
}
