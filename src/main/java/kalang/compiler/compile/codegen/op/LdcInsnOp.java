package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class LdcInsnOp extends OpBase {

    public Object value;

    public LdcInsnOp(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LDC " + value;
    }
}
