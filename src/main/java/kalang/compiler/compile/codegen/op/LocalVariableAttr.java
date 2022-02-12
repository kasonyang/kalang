package kalang.compiler.compile.codegen.op;

/**
 * @author KasonYang
 */
public class LocalVariableAttr extends Attribute {
    public String name;
    public String descriptor;
    public String signature;
    public LabelOp start;
    public LabelOp end;
    public int index;

    public LocalVariableAttr(String name, String descriptor, String signature, LabelOp start, LabelOp end, int index) {
        this.name = name;
        this.descriptor = descriptor;
        this.signature = signature;
        this.start = start;
        this.end = end;
        this.index = index;
    }
}
