package kalang.compiler.compile.semantic;

import kalang.compiler.compile.OffsetRange;

/**
 * @author KasonYang
 */
public class NodeException extends RuntimeException {

    private OffsetRange offsetRange;

    public NodeException(String message, OffsetRange offsetRange) {
        super(message);
        this.offsetRange = offsetRange;
    }

    public OffsetRange getOffsetRange() {
        return offsetRange;
    }

}
