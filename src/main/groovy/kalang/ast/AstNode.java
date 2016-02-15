package kalang.ast;

import java.util.List;
import kalang.core.*;

public abstract class AstNode {
	abstract public List<AstNode> getChildren();
}