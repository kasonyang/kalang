package kalang.compiler.compile.codegen.op;

import static org.objectweb.asm.Opcodes.IINC;

/**
 * @author KasonYang
 */
public class IincOp extends OpBase {

    public int varId;

    public int increment;

    public IincOp(int varId, int increment) {
        this.opcode = IINC;
        this.varId = varId;
        this.increment = increment;
    }

    @Override
    public String toString() {
        return OPC_DESC[opcode] + " " + varId + "," + increment;
    }
}
