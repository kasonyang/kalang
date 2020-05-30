package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class JumpInsnOp extends OpBase {

    public int opcode;

    public LabelOp label;

    public JumpInsnOp(int opcode, LabelOp label) {
        this.opcode = opcode;
        this.label = label;
    }

    @Override
    public String toString() {
        return OPC_DESC[opcode] + " " + label;
    }
}
