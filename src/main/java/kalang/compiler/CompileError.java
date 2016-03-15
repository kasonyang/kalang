package kalang.compiler;

public abstract class CompileError  extends RuntimeException  {
    /**
     * the position where the error occurs
     */
     protected OffsetRange offset;
     
     protected CompilationUnit compilationUnit;
     
     /**
      * the error description 
      */
     protected String description;
     
     public  CompileError(String description,CompilationUnit source,OffsetRange offset) {
         super(description);
         this.description = description;
         this.offset = offset;
         this.compilationUnit = source;
    }

    @Override
    public String toString() {
        return String.format("CompileError: %s(%d:%d):%s", compilationUnit.getSource().getClassName(),offset.startLine,offset.startLineColumn,description);
    }

    public OffsetRange getOffset() {
        return offset;
    }

    public CompilationUnit getCompilationUnit() {
        return compilationUnit;
    }

    public String getDescription() {
        return description;
    }
    
}
 