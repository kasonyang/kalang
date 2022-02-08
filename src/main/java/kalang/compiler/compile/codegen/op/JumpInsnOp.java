package kalang.compiler.compile.codegen.op;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author KasonYang
 */
public class JumpInsnOp extends OpBase {

    public LabelOp label;

    public JumpInsnOp(int opcode, LabelOp label) {
        this.opcode = opcode;
        this.label = label;
    }

    @Override
    public String[][] getIoTypes() {
        switch (opcode) {
            case IFEQ:
            case IFNE:
            case IFLT:
            case IFGE:
            case IFGT:
            case IFLE:
                return inTypes(ST_INT);
            case IF_ICMPEQ:
            case IF_ICMPNE:
            case IF_ICMPLT:
            case IF_ICMPGE:
            case IF_ICMPGT:
            case IF_ICMPLE:
                return inTypes(ST_INT, ST_INT);
            case IF_ACMPEQ:
            case IF_ACMPNE:
                return inTypes(ST_ANY, ST_ANY);
            case IFNULL:
            case IFNONNULL:
                return inTypes(ST_ANY);
            case GOTO:
                return noTypes();
            default:
                throw unsupportedOpcode(opcode);
        }
    }

    @Override
    public String toString() {
        return OPC_DESC[opcode] + " " + label;
    }
}
