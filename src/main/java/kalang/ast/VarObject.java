package kalang.ast;
import java.util.*;
import kalang.core.*;
public abstract class VarObject extends AstNode{
    
    public int modifier;
    
    public Type type;
    
    public String name;
    
    protected VarObject(int modifier,Type type,String name){
            this.modifier = modifier;
            this.type = type;
            this.name = name;
    }
    
    public Type getType(){
        if(type!=null) return type;
        return Types.getRootType();
    }
}