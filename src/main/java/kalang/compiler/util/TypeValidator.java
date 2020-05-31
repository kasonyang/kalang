package kalang.compiler.util;

import kalang.compiler.ast.ExprNode;
import kalang.compiler.compile.OffsetRange;
import kalang.compiler.compile.semantic.NodeException;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;

/**
 * @author KasonYang
 */
public class TypeValidator {

    public static void requireNonVoidType(ExprNode expr) {
        Type type = expr.getType();
        if (Types.VOID_TYPE.equals(type)) {
            throw new NodeException("non-void type expected", expr.offset);
        }
    }

    public static <T> T requireType(Type type, Class<T> typeClass,String errMsg, OffsetRange offset) {
        if (typeClass.isAssignableFrom(type.getClass())) {
            return (T) type;
        } else {
            throw new NodeException(errMsg, offset);
        }
    }

}
