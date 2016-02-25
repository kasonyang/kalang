package kalang.ast;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import kalang.compiler.OffsetRange;
import kalang.core.*;

/**
 * The base class of any ast node
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public abstract class AstNode {
    
    @Nonnull
    public OffsetRange offset = OffsetRange.NONE;
    
    public List<AstNode> getChildren(){
        return Collections.EMPTY_LIST;
    }
    
}
