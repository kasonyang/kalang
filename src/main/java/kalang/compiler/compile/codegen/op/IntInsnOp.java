package kalang.compiler.compile.codegen.op;

import static org.objectweb.asm.Opcodes.NEWARRAY;

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
    public String[][] getIoTypes() {
        if (opcode == NEWARRAY) {
            return ioTypes(ST_INT, ST_ANY);
        }
        throw unsupportedOpcode(opcode);
    }

    @Override
    public String toString() {
        return OPC_DESC[opcode] + " " + operand;
    }
}
