package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class LineNumber {

    public int lineNum;
    public LabelOp label;

    public LineNumber(int lineNum, LabelOp label) {
        this.lineNum = lineNum;
        this.label = label;
    }
}
