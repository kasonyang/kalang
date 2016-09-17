
package kalang.ast;

import kalang.core.VarTable;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public interface ScopeBlock {
    
    public LocalVarNode[] getScopeVars();

}
