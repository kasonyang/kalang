
package kalang.core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kalang.ast.ClassNode;
import kalang.util.TypeUtil;
/**
 *
 * @author Kason Yang
 */
public class ParameterizedType extends ClassType {
    
    Type[] parameterTypes;
    private final ClassType rawType;
    
    public ParameterizedType(ClassType rawType,Type... parameterTypes ) {
        //TODO may be bug
        super(rawType.getClassNode(),rawType.getSuperType());
        this.rawType = rawType;
        this.parameterTypes = parameterTypes;
        superType =(ClassType) TypeUtil.getActualType(this, superType);
       //TODO check parameterTypes.length
    }

    public Type[] getParameterTypes() {
        return parameterTypes;
    }
    
    public Map<GenericType,Type> getParameterTypesMap(){
        ClassNode clz = getClassNode();
        GenericType[] gts = clz.getGenericTypes();
        Map<GenericType,Type> ret = new HashMap();
        for(int i=0;i<gts.length;i++){
            ret.put(gts[i], parameterTypes[i]);
        }
        return ret;
    }

    public ClassType getRawType() {
        return rawType;
    }

    @Override
    public String getDeclarationKey() {
        return rawType.getDeclarationKey();
    }

    @Override
    public String getName() {
        List<String> paramTypes = new ArrayList(parameterTypes.length);
        for(Type t:parameterTypes){
            paramTypes.add(t.getName());
        }
        return rawType.getName() + "<" + String.join(",",paramTypes) + ">";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParameterizedType other = (ParameterizedType) obj;
        if (!Arrays.deepEquals(this.parameterTypes, other.parameterTypes)) {
            return false;
        }
        if (!Objects.equals(this.rawType, other.rawType)) {
            return false;
        }
        return true;
    }
    
    

}
