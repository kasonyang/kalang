package kalang.ast;

import java.util.Arrays;
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
    
    protected void addChild(List<AstNode> list, AstNode[] nodes){
        if(nodes==null) return;
        list.addAll(Arrays.asList(nodes));
    }
    
        protected void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    protected void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
}
