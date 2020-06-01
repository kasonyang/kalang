package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class IntInsnOp extends OpBase {

    public int operand;

    public IntInsnOp(int opcode, int operand) {
        this.opcode = opcode;
        this.operand = operand;
    }

    @Override
    public String toString() {
        return OPC_DESC[opcode] + " " + operand;
    }
}
