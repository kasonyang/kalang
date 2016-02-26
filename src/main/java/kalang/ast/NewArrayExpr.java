/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class NewArrayExpr extends ExprNode{
    
    public Type componentType;
    
    public ExprNode size;
    
    
    public NewArrayExpr(){
        
    }
    
    
    public NewArrayExpr(Type type,ExprNode size){
        
        
            this.componentType = type;
        
            this.size = size;
        
    }
    
    
    public static NewArrayExpr create(){
        NewArrayExpr node = new NewArrayExpr();
        
        return node;
    }
    
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }
    
    public String toString(){
        String str = "NewArrayExpr{\r\n";
        
        if(componentType!=null){
            str += "  type:" + componentType.toString()+"\r\n";
        }
        
        if(size!=null){
            str += "  size:" + size.toString()+"\r\n";
        }
        
        return str+"}";
    }

    @Override
    public Type getType() {
        return Types.getArrayType(componentType);
    }
}