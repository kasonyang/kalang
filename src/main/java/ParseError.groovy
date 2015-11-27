import org.antlr.v4.runtime.tree.ParseTree


class ParseError extends RuntimeException {
	int start;
	int end;
	public ParseError(String msg,int start,int end){
		super(msg)
		this.start = start
		this.end = end
	}
}
