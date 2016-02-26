/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ConstExpr extends ExprNode{
    
    public Object value;
    
    public Type constType;
    
    
    public ConstExpr(){
        
    }
    
    
    public ConstExpr(Object value,Type type){
        
        
            this.value = value;
        
            this.constType = type;
        
    }
    
    
    public static ConstExpr create(){
        ConstExpr node = new ConstExpr();
        
        return node;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }
    
    public String toString(){
        String str = "ConstExpr{\r\n";
        
        if(value!=null){
            str += "  value:" + value.toString()+"\r\n";
        }
        
        if(constType!=null){
            str += "  type:" + constType.toString()+"\r\n";
        }
        
        return str+"}";
    }

    @Override
    public Type getType() {
        return constType;
    }
}