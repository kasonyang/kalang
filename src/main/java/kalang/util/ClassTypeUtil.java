package kalang.util;

import javax.annotation.Nullable;
import kalang.ast.ClassNode;
import kalang.core.ClassType;
import kalang.core.MethodDescriptor;

/**
 *
 * @author Kason Yang
 */
public class ClassTypeUtil {
    
    @Nullable
    public static MethodDescriptor getMethodDescriptor(ClassType clazzType,String declarationKey,ClassNode caller,boolean recursive){
        MethodDescriptor[] mds = clazzType.getMethodDescriptors(caller, recursive);
        for(MethodDescriptor m:mds){
            if(m.getDeclarationKey().equals(declarationKey)) return m;
        }
        return null;
    }
    
    @Nullable
    public static MethodDescriptor getMethodDescriptor(ClassType[] clazzType,String declarationKey,ClassNode caller,boolean recursive){
        for(ClassType c:clazzType){
            MethodDescriptor m = getMethodDescriptor(c, declarationKey, caller, recursive);
            if(m!=null) return m;
        }
        return null;
    }
    

}
