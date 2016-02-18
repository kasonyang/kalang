package kalang.ast;

import java.util.List;
import kalang.compiler.OffsetRange;
import kalang.core.*;

/**
 * The base class of any ast node
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public abstract class AstNode {
    
    public OffsetRange offset = OffsetRange.NONE;
    
    abstract public List<AstNode> getChildren();
    
}
