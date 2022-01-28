package kalang.compiler.compile.codegen.op;

import org.objectweb.asm.Handle;

import static org.objectweb.asm.Opcodes.INVOKEDYNAMIC;

/**
 * @author KasonYang
 */
public class InvokeDynamicInsnOp extends OpBase {

    public String name;
    public String descriptor;
    public Handle bootstrapMethodHandle;
    public Object[] bootstrapMethodArguments;

    public InvokeDynamicInsnOp(String name, String descriptor, Handle bootstrapMethodHandle, Object[] bootstrapMethodArguments) {
        this.opcode = INVOKEDYNAMIC;
        this.name = name;
        this.descriptor = descriptor;
        this.bootstrapMethodHandle = bootstrapMethodHandle;
        this.bootstrapMethodArguments = bootstrapMethodArguments;
    }

    @Override
    public String[][] getIoTypes() {
        return getIoTypesByMethodDescriptor(descriptor, null);
    }
}
