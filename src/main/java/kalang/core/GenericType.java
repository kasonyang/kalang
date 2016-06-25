package kalang.core;

import java.util.Objects;
import javax.annotation.Nullable;
import kalang.ast.ClassNode;
import kalang.util.AstUtil;

/**
 *
 * @author Kason Yang
 */
public class GenericType extends ObjectType{
    
    protected String name;
    
    protected ObjectType[] upperBounds;
    
    private static ClassNode getClassNode(String name,@Nullable ObjectType[] upperBounds){
        if(upperBounds==null){
            upperBounds=new ObjectType[0];
        }
        if(upperBounds.length==0){
            return Types.getRootType().getClassNode();
        }else if(upperBounds.length==1){
            return upperBounds[0].getClassNode();
        }else{
            return AstUtil.createClassNodeWithInterfaces(name,upperBounds);
        }
    }

    public GenericType(String name,@Nullable ObjectType[] upperBounds,NullableKind nullable) {
        super(getClassNode(name,upperBounds),nullable);
        Objects.requireNonNull(name);
        this.name = name;
        this.upperBounds = upperBounds==null?new ObjectType[]{Types.getRootType()} : upperBounds;
    }

    @Override
    public String getName() {
        return name;
    }

    public ObjectType[] getUpperBounds() {
        return upperBounds;
    }

}
