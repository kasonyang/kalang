package kalang.compiler.compile.codegen.op;


import static org.objectweb.asm.Opcodes.*;

/**
 * @author KasonYang
 */
public class TypeInsnOp extends OpBase {
    public String type;
    public TypeInsnOp(int opcode, String type) {
        this.opcode = opcode;
        this.type = type;
    }

    @Override
    public String[][] getIoTypes() {
        switch (opcode) {
            case CHECKCAST:
                return ioTypes(ST_ANY, "L" + type + ";");
            case NEW:
                return outTypes("L" + type + ";");
            case INSTANCEOF:
                return ioTypes(type, ST_INT);
            case ANEWARRAY:
                return ioTypes(ST_INT, "L" + type + ";");
            default:
                throw unsupportedOpcode(opcode);
        }
    }

    @Override
    public String toString() {
        return OPC_DESC[opcode] + " " + type;
    }
}
