package kalang.compiler.util;

import kalang.compiler.ast.ClassNode;
import kalang.compiler.ast.MethodNode;
import kalang.compiler.core.ClassType;
import kalang.compiler.core.ObjectType;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

/**
 * @author KasonYang
 */
public class GeneratorUtil {

    public static Type getGeneratorResultType(MethodNode method) {
        return getGeneratorResultType(method.getType());
    }

    public static Type getGeneratorResultType(Type methodReturnType) {
        assert methodReturnType instanceof ObjectType;
        ClassType methodType = (ClassType) methodReturnType;
        ClassNode cn = methodType.getClassNode();
        assert cn == Types.getGeneratorClassType().getClassNode();
        Type[] typeArgs = methodType.getTypeArguments();
        assert typeArgs.length == 1;
        return typeArgs[0];
    }

}
