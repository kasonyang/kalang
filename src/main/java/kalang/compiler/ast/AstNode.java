package kalang.compiler.ast;

import kalang.compiler.compile.OffsetRange;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The base class of any ast node
 * 
 * @author Kason Yang 
 */
public abstract class AstNode {
    
    @Nonnull
    public OffsetRange offset = OffsetRange.NONE;
    
    public List<AstNode> getChildren(){
        return Collections.EMPTY_LIST;
    }
    
    protected void addChild(List<AstNode> list,@Nullable AstNode[] nodes){
        if(nodes==null) return;
        list.addAll(Arrays.asList(nodes));
    }
    
        protected void addChild(List<AstNode> list,@Nullable List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    protected void addChild(List<AstNode> list,@Nullable AstNode node){
        if(node!=null) list.add(node);
    }
    
}
