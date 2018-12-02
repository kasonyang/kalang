package kalang.compiler.util;

import kalang.compiler.ast.AnnotationNode;

public class AnnotationUtil {

    public static boolean has(AnnotationNode[] annotations,String annotationTypeName) {
        for(AnnotationNode a:annotations) {
            if (annotationTypeName.equals(a.getAnnotationType().name)) {
                return true;
            }
        }
        return false;
    }

}
