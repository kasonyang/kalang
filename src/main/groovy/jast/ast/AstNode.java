package jast.ast;

import java.util.List;

public abstract class AstNode {
	abstract public List<AstNode> getChildren();
}