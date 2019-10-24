/*

*/
package kalang.compiler.ast;

import java.util.Collections;
import java.util.List;

public class BreakStmt extends Statement{

    @Override
    public String toString() {
        return "break";
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.emptyList();
    }

}