package kalang.compiler.compile.codegen.op;

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
    public String toString() {
        return OPC_DESC[opcode] + " " + type;
    }
}
