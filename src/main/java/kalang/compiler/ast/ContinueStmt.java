/*

*/
package kalang.compiler.ast;

import java.util.Collections;
import java.util.List;

public class ContinueStmt extends Statement{

    @Override
    public String toString() {
        return "continue";
    }

    @Override
    public List<AstNode> getChildren() {
        return Collections.emptyList();
    }

}