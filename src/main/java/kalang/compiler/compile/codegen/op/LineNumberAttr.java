package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class LineNumberAttr extends Attribute {

    public int lineNum;
    public LabelOp label;

    public LineNumberAttr(int lineNum, LabelOp label) {
        this.lineNum = lineNum;
        this.label = label;
    }
}
