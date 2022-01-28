package kalang.compiler.compile.codegen.op;

import java.util.Arrays;

import static org.objectweb.asm.Opcodes.MULTIANEWARRAY;

/**
 * @author KasonYang
 */
public class MultiANewArrayInsnOp extends OpBase {

    public String descriptor;
    public int numDimensions;

    public MultiANewArrayInsnOp(String descriptor, int numDimensions) {
        this.opcode = MULTIANEWARRAY;
        this.descriptor = descriptor;
        this.numDimensions = numDimensions;
    }

    @Override
    public String[][] getIoTypes() {
        String[] inTypes = new String[numDimensions];
        Arrays.fill(inTypes, ST_INT);
        return ioTypes(inTypes, types(ST_ANY));
    }

    @Override
    public String toString() {
        return "MultiANewArray " + numDimensions;
    }
}
