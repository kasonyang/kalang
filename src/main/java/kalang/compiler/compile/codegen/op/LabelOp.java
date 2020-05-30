package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class LabelOp extends OpBase {

    private static int labelIdCounter = 1;

    private int id;

    public LabelOp() {
        this.id = labelIdCounter ++;
    }

    @Override
    public String toString() {
        return "Label_" + id;
    }
}
