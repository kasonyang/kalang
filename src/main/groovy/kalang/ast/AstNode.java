package kalang.ast;

import java.util.List;
import kalang.core.*;

public abstract class AstNode {
    
    public int startOffset = -1;
    
    public int stopOffset = -1;
    
    public int startLine = -1;
    
    public int startLineColumn = -1;
    
    public int stopLine = -1;
    
    public int stopLineColumn = -1;

    abstract public List<AstNode> getChildren();
    
}
