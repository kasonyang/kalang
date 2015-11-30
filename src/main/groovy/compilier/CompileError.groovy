package compilier

class CompileError  extends RuntimeException{
	
    int offset = 0;
	
    int length = 0;
    
    String className
    
    String source
	
    public CompileError(String msg,String className,String src,int offset = 0,int length = 0){
        super(msg)
        this.offset = offset
        this.length = length
        this.className = className
        this.source = src
    }
}