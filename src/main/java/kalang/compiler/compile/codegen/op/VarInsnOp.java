package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class VarInsnOp extends OpBase {

    public int var;

    public VarInsnOp(int opcode, int var) {
        this.opcode = opcode;
        this.var = var;
    }

    @Override
    public String toString() {
        return OPC_DESC[opcode] + " " + var;
    }
}
