package kalang.compiler;

public abstract class CompileError  extends RuntimeException  {
    /**
     * the position where the error occurs
     */
     protected OffsetRange offset;
     
     protected KalangSource source;
     
     /**
      * the error description 
      */
     protected String description;
     
     public  CompileError(String description,KalangSource source,OffsetRange offset) {
         super(description);
         this.description = description;
         this.offset = offset;
         this.source = source;
    }

    @Override
    public String toString() {
        return String.format("CompileError: %s(%d:%d):%s", source.getClassName(),offset.startLine,offset.startLineColumn,description);
    }

    public OffsetRange getOffset() {
        return offset;
    }

    public KalangSource getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }
    
}
 