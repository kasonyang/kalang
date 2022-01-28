package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class YieldOp extends OpBase {

    private int contextVarId;

    private int nextVarId;

    private LabelOp label = new LabelOp();

    public YieldOp(int contextVarId, int nextVarId) {
        this.opcode = TEMP_OP_YIELD;
        this.contextVarId = contextVarId;
        this.nextVarId = nextVarId;
    }

    public int getContextVarId() {
        return contextVarId;
    }

    public int getNextVarId() {
        return nextVarId;
    }

    @Override
    public String[][] getIoTypes() {
        return noTypes();
    }

    public LabelOp getLabel() {
        return label;
    }

}
