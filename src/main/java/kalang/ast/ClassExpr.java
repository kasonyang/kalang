/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ClassExpr extends ExprNode{
    
    public ClassNode clazz;
    
    public ClassExpr(ClassNode clazz){
            this.clazz = clazz;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }

    @Override
    public Type getType() {
        return Types.getClassType(clazz);
    }
    
}