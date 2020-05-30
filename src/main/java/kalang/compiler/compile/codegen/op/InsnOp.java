package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class InsnOp extends OpBase {

    public int opcode;

    public InsnOp(int code) {
        this.opcode = code;
    }

    @Override
    public String toString() {
        return OPC_DESC[opcode];
    }
}
