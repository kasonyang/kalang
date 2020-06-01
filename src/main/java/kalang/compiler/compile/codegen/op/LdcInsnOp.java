package kalang.compiler.compile.codegen.op;

import static org.objectweb.asm.Opcodes.LDC;

/**
 * @author KasonYang
 */
public class LdcInsnOp extends OpBase {

    public Object value;

    public LdcInsnOp(Object value) {
        this.opcode = LDC;
        this.value = value;
    }

    @Override
    public String toString() {
        return "LDC " + value;
    }
}
