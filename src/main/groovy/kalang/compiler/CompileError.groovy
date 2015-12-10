package kalang.compiler

class CompileError  extends RuntimeException{
	
    int start = 0;
	
    int stop = 0;
    
    String className
    
    String source
	
    public CompileError(String msg,String className,String src,int start = 0,int stop = 0){
        super(msg)
        this.start = start
        this.stop = stop
        this.className = className
        this.source = src
    }
	
	public String getErrorSource(){
		return source.substring(start,stop)
	}

	@Override
	public String toString() {
		this.getMessage() + " on " + getErrorSource()
	}
	
	
	
}