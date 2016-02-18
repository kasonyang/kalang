/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class VarExpr extends AssignableExpr{
    
    public VarObject var;
    
    
    public VarExpr(){
        
    }
    
    
    public VarExpr(VarObject var){
        
        
            this.var = var;
        
    }
    
    
    public static VarExpr create(){
        VarExpr node = new VarExpr();
        
        return node;
    }
    
    private void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    private void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }
    
    public String toString(){
        String str = "VarExpr{\r\n";
        
        if(var!=null){
            str += "  var:" + var.toString()+"\r\n";
        }
        
        return str+"}";
    }
}