package kalang.util;

import java.util.Objects;
import kalang.ast.AstNode;

/**
 *
 * @author Kason Yang
 */
public class AstOutputUtil {
    
    static final String INDENT = "    ";
    
    static final String LINE_DELIMITER = "\r\n";
    
    public static String toString(AstNode node){
        if(node==null) return "null";
        String nodeStr = node.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(nodeStr).append(":");
        for(AstNode c:node.getChildren()){
            sb.append(LINE_DELIMITER);
            String cStr = toString(c);
            sb.append(StringUtil.indentLines(cStr, INDENT,LINE_DELIMITER));
        }
        return sb.toString();
    }

}
