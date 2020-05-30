package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class TryCatchBlock {

    public LabelOp start;

    public LabelOp end;

    public LabelOp handler;

    public String type;

    public TryCatchBlock(LabelOp start, LabelOp end, LabelOp handler, String type) {
        this.start = start;
        this.end = end;
        this.handler = handler;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Catch %s [%s %s) %s", type, start, end, handler);
    }
}
