package kalang.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    
    private static ClassNode getClassNode(String name,@Nullable ObjectType superType,@Nullable ObjectType[] interfaces){
        return AstUtil.createClassNodeWithInterfaces(name,superType,interfaces);
    }

    public GenericType(String name,ObjectType superType,@Nullable ObjectType[] interfaces,NullableKind nullable) {
        super(getClassNode(name,superType,interfaces),nullable);
        Objects.requireNonNull(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
