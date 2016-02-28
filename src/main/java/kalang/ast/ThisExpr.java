package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ThisExpr extends ExprNode{
    
    private final ClassType classType;
    
    public ThisExpr(ClassType classType){
            this.classType = classType;
    }

    @Override
    public Type getType() {
        return classType;
    }
    
}