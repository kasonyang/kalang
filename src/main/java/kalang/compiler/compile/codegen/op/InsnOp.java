package kalang.compiler.compile.codegen.op;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author KasonYang
 */
public class InsnOp extends OpBase {

    public InsnOp(int code) {
        this.opcode = code;
    }

    @Override
    public String[][] getIoTypes() {
        switch (opcode) {
            case NOP:
            case RETURN:
                return noTypes();
            case ACONST_NULL:
            case DUP:
            case DUP2:
                return outTypes(ST_ANY);
            case ICONST_M1:
            case ICONST_0:
            case ICONST_1:
            case ICONST_2:
            case ICONST_3:
            case ICONST_4:
            case ICONST_5:
                return outTypes(ST_INT);
            case LCONST_0:
            case LCONST_1:
                return outTypes(ST_LONG);
            case FCONST_0:
            case FCONST_1:
            case FCONST_2:
                return outTypes(ST_FLOAT);
            case DCONST_0:
            case DCONST_1:
                return outTypes(ST_DOUBLE);
            case IALOAD:
                return ioTypes(types("[I", ST_INT), types(ST_INT));
            case BALOAD:
                return ioTypes(types("[B", ST_INT), types(ST_BYTE));
            case CALOAD:
                return ioTypes(types("[C", ST_INT), types(ST_CHAR));
            case SALOAD:
                return ioTypes(types("[S", ST_INT), types(ST_SHORT));
            case LALOAD:
                return ioTypes(types("[J", ST_INT), types(ST_LONG));
            case FALOAD:
                return ioTypes(types("[F", ST_INT), types(ST_FLOAT));
            case DALOAD:
                return ioTypes(types("[D", ST_INT), types(ST_DOUBLE));
            case AALOAD:
                return ioTypes(types("[a", ST_INT), types(ST_ELEMENT));
            case LASTORE:
                return inTypes("[J", ST_INT, ST_LONG);
            case FASTORE:
                return inTypes("[F", ST_INT, ST_FLOAT);
            case DASTORE:
                return inTypes("[D", ST_INT, ST_DOUBLE);
            case AASTORE:
                return inTypes("[a", ST_INT, ST_ANY);
            case IASTORE:
                return inTypes("[I", ST_INT, ST_INT);
            case BASTORE:
                return inTypes("[B", ST_INT, ST_BYTE);
            case CASTORE:
                return inTypes("[C", ST_INT, ST_CHAR);
            case SASTORE:
                return inTypes("[S", ST_INT, ST_SHORT);
            case POP:
            case POP2:
            case ATHROW:
            case ARETURN:
                return inTypes(ST_ANY);
            case IADD:
            case ISUB:
            case IMUL:
            case IDIV:
            case IREM:
            case ISHL:
            case ISHR:
            case IUSHR:
            case IAND:
            case IOR:
            case IXOR:
                return ioTypes(types(ST_INT, ST_INT), types(ST_INT));
            case LADD:
            case LSUB:
            case LMUL:
            case LDIV:
            case LREM:
            case LAND:
            case LOR:
            case LXOR:
                return ioTypes(types(ST_LONG, ST_LONG), types(ST_LONG));
            case FADD:
            case FSUB:
            case FMUL:
            case FDIV:
            case FREM:
                return ioTypes(types(ST_FLOAT, ST_FLOAT), types(ST_FLOAT));

            case FNEG:
                return ioTypes(types(ST_FLOAT), types(ST_FLOAT));
            case DADD:
            case DSUB:
            case DMUL:
            case DDIV:
            case DREM:
                return ioTypes(types(ST_DOUBLE, ST_DOUBLE), types(ST_DOUBLE));
            case INEG:
                return ioTypes(ST_INT, ST_INT);
            case LNEG:
                return ioTypes(ST_LONG, ST_LONG);
            case DNEG:
                return ioTypes(types(ST_DOUBLE), types(ST_DOUBLE));
            case LSHL:
            case LSHR:
            case LUSHR:
                return ioTypes(types(ST_LONG, ST_INT), types(ST_LONG));
            case I2L:
                return ioTypes(ST_INT, ST_LONG);
            case I2F:
                return ioTypes(ST_INT, ST_FLOAT);
            case I2D:
                return ioTypes(ST_INT, ST_DOUBLE);
            case I2B:
            case I2C:
            case I2S:
                return ioTypes(ST_INT, ST_INT);
            case L2I:
                return ioTypes(ST_LONG, ST_INT);
            case L2F:
                return ioTypes(ST_LONG, ST_FLOAT);
            case L2D:
                return ioTypes(ST_LONG, ST_DOUBLE);
            case F2I:
                return ioTypes(ST_FLOAT, ST_INT);
            case F2L:
                return ioTypes(ST_FLOAT, ST_LONG);
            case F2D:
                return ioTypes(ST_FLOAT, ST_DOUBLE);
            case D2I:
                return ioTypes(ST_DOUBLE, ST_INT);
            case D2L:
                return ioTypes(ST_DOUBLE, ST_LONG);
            case D2F:
                return ioTypes(ST_DOUBLE, ST_FLOAT);
            case LCMP:
                return ioTypes(types(ST_LONG, ST_LONG), types(ST_INT));
            case FCMPL:
            case FCMPG:
                return ioTypes(types(ST_FLOAT, ST_FLOAT), types(ST_INT));
            case DCMPL:
            case DCMPG:
                return ioTypes(types(ST_DOUBLE, ST_DOUBLE), types(ST_INT));
            case IRETURN:
                return inTypes(ST_INT);
            case LRETURN:
                return inTypes(ST_LONG);
            case FRETURN:
                return inTypes(ST_FLOAT);
            case DRETURN:
                return inTypes(ST_DOUBLE);
            case ARRAYLENGTH:
                return ioTypes(types("[a"), types(ST_INT));
            case SWAP:
            case MONITORENTER:
            case MONITOREXIT:
            default:
                throw new IllegalStateException("unsupported opcode:" + opcode);
        }
    }

    @Override
    public String toString() {
        return OPC_DESC[opcode];
    }
}
