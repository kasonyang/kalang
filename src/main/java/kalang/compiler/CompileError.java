package kalang.compiler;

public class CompileError  extends java.lang.RuntimeException  {
    /**
     * the position where the error occurs
     */
     public OffsetRange offset;
     /**
      * the class name that the error occurs from
      */
     public java.lang.String className;
     public java.lang.String source;
     /**
      * the error description 
      */
     public String description;
     public  CompileError(java.lang.String description,java.lang.String className,java.lang.String src,OffsetRange offset) {
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
 