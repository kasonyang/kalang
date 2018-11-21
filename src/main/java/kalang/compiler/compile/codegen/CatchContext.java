package kalang.compiler.compile.codegen;

import kalang.compiler.ast.Statement;
import org.objectweb.asm.Label;

import java.util.LinkedList;
import java.util.List;

public class CatchContext {

    private final Label startLabel,stopLabel;

    private final Statement finallyStatement;

    private final List<Label> excludeLabels = new LinkedList<>();

    public CatchContext(Label startLabel, Label stopLabel, Statement finallyStatement) {
        this.startLabel = startLabel;
        this.stopLabel = stopLabel;
        this.finallyStatement = finallyStatement;
    }

    public void addExclude(Label startLabel, Label stopLabel) {
        excludeLabels.add(startLabel);
        excludeLabels.add(stopLabel);
    }

    public Label[] getCatchLabels() {
        int size = excludeLabels.size();
        Label[] labels = new Label[size+2];
        for(int i=1;i<labels.length-1;i++) {
            labels[i] = excludeLabels.get(i-1);
        }
        labels[0] = startLabel;
        labels[labels.length-1] = stopLabel;
        return labels;
    }

    public Statement getFinallyStatement() {
        return finallyStatement;
    }

}
