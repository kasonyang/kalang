package kalang.compiler.compile.codegen.op;

import org.objectweb.asm.Opcodes;

/**
 * @author KasonYang
 */
public class MethodInsnOp extends OpBase {

    public String owner;
    public String name;
    public String descriptor;
    public boolean isInterface;

    public MethodInsnOp(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        this.opcode = opcode;
        this.owner = owner;
        this.name = name;
        this.descriptor = descriptor;
        this.isInterface = isInterface;
    }

    @Override
    public String[][] getIoTypes() {
        return getIoTypesByMethodDescriptor(descriptor, opcode == Opcodes.INVOKESTATIC ? null : owner);
    }

    @Override
    public String toString() {
        return String.format("%s %s.%s[%s]", OPC_DESC[opcode], owner, name, descriptor);
    }
}
