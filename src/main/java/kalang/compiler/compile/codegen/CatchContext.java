package kalang.compiler.compile.codegen;

import kalang.compiler.compile.codegen.op.LabelOp;

import java.util.LinkedList;
import java.util.List;

public class CatchContext {

    private final LabelOp startLabel,stopLabel;

    private final List<LabelOp> excludeLabels = new LinkedList<>();

    public CatchContext(LabelOp startLabel, LabelOp stopLabel) {
        this.startLabel = startLabel;
        this.stopLabel = stopLabel;
    }

    public void addExclude(LabelOp startLabel, LabelOp stopLabel) {
        excludeLabels.add(startLabel);
        excludeLabels.add(stopLabel);
    }

    public LabelOp[] getCatchLabels() {
        int size = excludeLabels.size();
        LabelOp[] labels = new LabelOp[size+2];
        for(int i=1;i<labels.length-1;i++) {
            labels[i] = excludeLabels.get(i-1);
        }
        labels[0] = startLabel;
        labels[labels.length-1] = stopLabel;
        return labels;
    }

}
