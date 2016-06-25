package kalang.util;

import javax.annotation.Nullable;
import kalang.ast.ClassNode;
import kalang.core.ObjectType;
import kalang.core.MethodDescriptor;

/**
 *
 * @author Kason Yang
 */
public class ClassTypeUtil {
    
    @Nullable
    public static MethodDescriptor getMethodDescriptor(ObjectType clazzType,String declarationKey,ClassNode caller,boolean includeSuperType,boolean includeInterface){
        MethodDescriptor[] mds = clazzType.getMethodDescriptors(caller, includeSuperType,includeInterface);
        for(MethodDescriptor m:mds){
            if(m.getDeclarationKey().equals(declarationKey)) return m;
        }
        return null;
    }
    
    @Nullable
    public static MethodDescriptor getMethodDescriptor(ObjectType[] clazzType,String declarationKey,ClassNode caller,boolean includeSuperType,boolean includeInterface){
        for(ObjectType c:clazzType){
            MethodDescriptor m = getMethodDescriptor(c, declarationKey, caller, includeSuperType,includeInterface);
            if(m!=null) return m;
        }
        return null;
    }
    

}
