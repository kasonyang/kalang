/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ParameterExpr extends ExprNode{
    
    public VarObject parameter;
    
    
    public ParameterExpr(){
        
    }
    
    
    public ParameterExpr(VarObject parameter){
        
        
            this.parameter = parameter;
        
    }
    
    
    public static ParameterExpr create(){
        ParameterExpr node = new ParameterExpr();
        
        return node;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }
    
    public String toString(){
        String str = "ParameterExpr{\r\n";
        
        if(parameter!=null){
            str += "  parameter:" + parameter.toString()+"\r\n";
        }
        
        return str+"}";
    }

    @Override
    public Type getType() {
        return parameter.type;
    }
}