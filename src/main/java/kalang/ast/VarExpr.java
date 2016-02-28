/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class VarExpr extends AssignableExpr{
    
    protected VarObject var;
    
    
    public VarExpr(){
        
    }
    
    
    public VarExpr(VarObject var){
        
        
            this.var = var;
        
    }
    
    
    public static VarExpr create(){
        VarExpr node = new VarExpr();
        
        return node;
    }
    
    protected void addChild(List<AstNode> list,List nodes){
        if(nodes!=null) list.addAll(nodes);
    }
    
    protected void addChild(List<AstNode> list,AstNode node){
        if(node!=null) list.add(node);
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }
    
    public String toString(){
        String str = "VarExpr{\r\n";
        
        if(getVar()!=null){
            str += "  var:" + getVar().toString()+"\r\n";
        }
        
        return str+"}";
    }

    @Override
    public Type getType() {
        return getVar().getType();
    }

    /**
     * @return the var
     */
    public VarObject getVar() {
        return var;
    }

    /**
     * @param var the var to set
     */
    public void setVar(VarObject var) {
        Objects.requireNonNull(var);
        this.var = var;
    }
}