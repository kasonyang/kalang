package kalang.compiler.compile.codegen.op;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author KasonYang
 */
public class LabelOp extends OpBase {

    private static int labelIdCounter = 1;

    private int id;

    private List<LabelOp> successors = new LinkedList<>();

    private List<LabelOp> predecessors = new LinkedList<>();

    public LabelOp() {
        this.id = labelIdCounter ++;
    }

    @Override
    public String[][] getIoTypes() {
        return noTypes();
    }

    @Override
    public String toString() {
        return "Label_" + id;
    }

    public void addSuccessor(LabelOp successor) {
        successors.add(successor);
        successor.predecessors.add(this);
    }

    public Collection<LabelOp> getSuccessors() {
        return successors;
    }

    public Collection<LabelOp> getPredecessors() {
        return predecessors;
    }

}
