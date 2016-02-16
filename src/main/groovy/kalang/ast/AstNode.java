package kalang.ast;

import java.util.List;
import kalang.compiler.OffsetRange;
import kalang.core.*;

public abstract class AstNode {
    
    public OffsetRange offset = OffsetRange.NONE;
    
    abstract public List<AstNode> getChildren();
    
}
