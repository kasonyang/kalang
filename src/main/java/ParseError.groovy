import org.antlr.v4.runtime.tree.ParseTree


class ParseError extends RuntimeException {
	ParseTree tree;
	public ParseError(String msg,ParseTree tree){
		super(msg)
		this.tree = tree
	}
}
