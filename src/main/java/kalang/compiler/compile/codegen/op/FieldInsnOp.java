package kalang.compiler.compile.codegen.op;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author KasonYang
 */
public class FieldInsnOp extends OpBase {

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
    public String[][] getIoTypes() {
        switch (opcode) {
            case GETFIELD:
                return ioTypes(owner, descriptor);
            case GETSTATIC:
                return outTypes(descriptor);
            case PUTFIELD:
                return inTypes(owner, descriptor);
            case PUTSTATIC:
                return inTypes(descriptor);
            default:
                throw unsupportedOpcode(opcode);
        }

    }

    @Override
    public String toString() {
        return String.format("%s %s.%s", OPC_DESC[opcode], owner, name);
    }
}
