package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class MultiANewArrayInsnOp extends OpBase {

    public String descriptor;
    public int numDimensions;

    public MultiANewArrayInsnOp(String descriptor, int numDimensions) {
        this.descriptor = descriptor;
        this.numDimensions = numDimensions;
    }

    @Override
    public String toString() {
        return "MultiANewArray " + numDimensions;
    }
}
