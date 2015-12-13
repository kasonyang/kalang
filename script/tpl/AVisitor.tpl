package {{package}};
import java.util.*;
public abstract class {{name}}<T> implements {{interface}}<T>{
    {{#each nodes}}
    abstract public T visit{{this}}({{this}} node);
    {{/each}}
    public T visit(AstNode node){
        {{#each nodes}}
        if(node instanceof {{this}}){
            return visit{{this}}(({{this}})node);
        }
        {{/each}}
        return null;
    }
    
    public List<T> visitAll(List<?  extends AstNode> nodes){
        if(nodes==null) return null;
        List<T> result = new LinkedList();
        for(AstNode n:nodes){
            result.add(visit(n));
        }
        return result;
    }
    
    public Map<AstNode,T> visitChildren(AstNode node){
        Map<AstNode,T> result = new HashMap();
        List<AstNode> children = node.getChildren();
        for(AstNode c:children){
            result.put(c,visit(c));
        }
        return result;
    }
}