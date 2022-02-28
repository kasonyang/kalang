package kalang.compiler.compile.codegen.op;

import kalang.compiler.ast.VarObject;

import java.util.LinkedHashMap;

/**
 * @author KasonYang
 */
public class YieldOp extends OpBase {

    private int contextVarId;

    private int nextVarId;

    private LinkedHashMap<VarObject, Integer> vars;

    private LabelOp label = new LabelOp();

    public YieldOp(int contextVarId, LinkedHashMap<VarObject, Integer> vars, int nextVarId) {
        this.opcode = TEMP_OP_YIELD;
        this.contextVarId = contextVarId;
        this.nextVarId = nextVarId;
        this.vars = vars;
    }

    public int getContextVarId() {
        return contextVarId;
    }

    public int getNextVarId() {
        return nextVarId;
    }

    public LinkedHashMap<VarObject, Integer> getVars() {
        return vars;
    }

    @Override
    public String[][] getIoTypes() {
        return noTypes();
    }

    public LabelOp getLabel() {
        return label;
    }

}
