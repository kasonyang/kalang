/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class KeyExpr extends ExprNode{
    
    public String key;
    private final Type classType;
    
    public KeyExpr(String key,Type classType){
            this.key = key;
            this.classType = classType;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }
    
    public String toString(){
        String str = "KeyExpr{\r\n";
        
        if(key!=null){
            str += "  key:" + key.toString()+"\r\n";
        }
        
        return str+"}";
    }

    @Override
    public Type getType() {
        return classType;
    }
    
}