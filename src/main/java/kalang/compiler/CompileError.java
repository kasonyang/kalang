package kalang.compiler;

public class CompileError  extends RuntimeException  {
    /**
     * the position where the error occurs
     */
     public OffsetRange offset;
     /**
      * the class name that the error occurs from
      */
     public String className;
     public String source;
     /**
      * the error description 
      */
     public String description;
     public  CompileError(String description,String className,String src,OffsetRange offset) {
         super(description);
         this.description = description;
         this.offset = offset;
         this.className=className;
         this.source=src;
         
    }

    @Override
    public String toString() {
        return String.format("CompileError: %s(%d:%d):%s", className,offset.startLine,offset.startLineColumn,description);
    }
     
}
 