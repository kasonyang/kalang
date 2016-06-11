
package kalang.core;
import java.util.HashMap;
import java.util.Map;
import kalang.ast.ClassNode;
/**
 *
 * @author Kason Yang
 */
public class ParameterizedType extends ClassType {
    
    Type[] parameterTypes;
    
    public ParameterizedType(ClassType clazz,Type... parameterTypes ) {
        super(clazz.getClassNode());
        this.parameterTypes = parameterTypes;
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

}
