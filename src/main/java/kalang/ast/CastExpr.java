/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class CastExpr extends ExprNode{
    
    public Type toType;
    
    public ExprNode expr;
    
    
    public CastExpr(){
        
    }
    
    
    public CastExpr(Type type,ExprNode expr){
        
        
            this.toType = type;
        
            this.expr = expr;
        
    }
    
    
    public static CastExpr create(){
        CastExpr node = new CastExpr();
        
        return node;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        addChild(ls,expr);
        
        return ls;
    }
    
    public String toString(){
        String str = "CastExpr{\r\n";
        
        if(toType!=null){
            str += "  type:" + toType.toString()+"\r\n";
        }
        
        if(expr!=null){
            str += "  expr:" + expr.toString()+"\r\n";
        }
        
        return str+"}";
    }

    @Override
    public Type getType() {
        return toType;
    }
}