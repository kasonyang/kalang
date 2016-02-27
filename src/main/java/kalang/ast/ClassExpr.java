/*
Don't modify!This file is generated automately.
*/
package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ClassExpr extends ExprNode{
    
    protected ClassNode clazz;
    
    public ClassExpr(ClassNode clazz){
            this.clazz = clazz;
    }
    
    public List<AstNode> getChildren(){
        List<AstNode> ls = new LinkedList();
        
        return ls;
    }

    @Override
    public Type getType() {
        return Types.getClassType(getClazz());
    }

    /**
     * @return the clazz
     */
    public ClassNode getClazz() {
        return clazz;
    }

    /**
     * @param clazz the clazz to set
     */
    public void setClazz(ClassNode clazz) {
        Objects.requireNonNull(clazz);
        this.clazz = clazz;
    }
    
}