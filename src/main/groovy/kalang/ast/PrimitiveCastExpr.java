/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class PrimitiveCastExpr extends ExprNode{
    
    public PrimitiveType fromType;
    
    public PrimitiveType toType;
    
    public ExprNode expr;
    
    
    public PrimitiveCastExpr(){
        
    }
    
    
    public PrimitiveCastExpr(PrimitiveType fromType,PrimitiveType toType,ExprNode expr){
        
        
            this.fromType = fromType;
        
            this.toType = toType;
        
            this.expr = expr;
        
    }
    
    
    public static PrimitiveCastExpr create(){
        PrimitiveCastExpr node = new PrimitiveCastExpr();
        
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
        
        addChild(ls,expr);
        
        return ls;
    }
    
    public String toString(){
        String str = "PrimitiveCastExpr{\r\n";
        
        if(fromType!=null){
            str += "  fromType:" + fromType.toString()+"\r\n";
        }
        
        if(toType!=null){
            str += "  toType:" + toType.toString()+"\r\n";
        }
        
        if(expr!=null){
            str += "  expr:" + expr.toString()+"\r\n";
        }
        
        return str+"}";
    }
}