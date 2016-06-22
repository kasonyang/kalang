package kalang.ast;
import java.util.*;
import kalang.core.*;
public class ThisExpr extends ExprNode{
    
    private final ObjectType classType;
    
    public ThisExpr(ObjectType classType){
            this.classType = classType;
    }

    @Override
    public Type getType() {
        return classType;
    }
    
}