package kalang.compiler.compile.codegen.op;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author KasonYang
 */
public class VarInsnOp extends OpBase {

    public int var;

    public VarInsnOp(int opcode, int var) {
        this.opcode = opcode;
        this.var = var;
    }

    @Override
    public String[][] getIoTypes() {
        switch (opcode) {
            case ILOAD:
                return outTypes(ST_INT);
            case LLOAD:
                return outTypes(ST_LONG);
            case FLOAD:
                return outTypes(ST_FLOAT);
            case DLOAD:
                return outTypes(ST_DOUBLE);
            case ALOAD:
                return outTypes(ST_ANY);
            case ISTORE:
                return inTypes(ST_INT);
            case LSTORE:
                return inTypes(ST_LONG);
            case FSTORE:
                return inTypes(ST_FLOAT);
            case DSTORE:
                return inTypes(ST_DOUBLE);
            case ASTORE:
                return inTypes(ST_ANY);
            default:
                throw unsupportedOpcode(opcode);
        }
    }

    @Override
    public String toString() {
        return OPC_DESC[opcode] + " " + var;
    }
}
