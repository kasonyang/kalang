package kalang.compiler.util;

import kalang.annotation.Nullable;
import kalang.compiler.core.ClassType;
import kalang.compiler.core.MethodDescriptor;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kason Yang
 */
public class LambdaUtil {

    @Nullable
    public static MethodDescriptor getFunctionalMethod(ClassType classType) {
        if (!ModifierUtil.isInterface(classType.getModifier())) {
            return null;
        }
        List<MethodDescriptor> mustImplMethods = new LinkedList<>();
        MethodDescriptor[] methods = classType.getMethodDescriptors(null, true, true);
        for(MethodDescriptor m:methods) {
            if (!ModifierUtil.isDefault(m.getModifier())) {
                mustImplMethods.add(m);
            }
        }
        if (mustImplMethods.size()!=1) {
            return null;
        }
        return mustImplMethods.get(0);
    }

}
