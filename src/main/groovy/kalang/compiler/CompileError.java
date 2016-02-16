package kalang.compiler;

public class CompileError  extends java.lang.RuntimeException  {
     public OffsetRange offset;
     public java.lang.String className;
     public java.lang.String source;
     public String description;
     public  CompileError(java.lang.String description,java.lang.String className,java.lang.String src,OffsetRange offset) {
         super(description);
         this.description = description;
         this.offset = offset;
         this.className=className;
         this.source=src;
         
    }
     public java.lang.String getErrorSource() {
         throw new UnsupportedOperationException();         
    }

    @Override
    public String toString() {
        return String.format("CompileError: %s(%d:%d):%s", className,offset.startLine,offset.startLineColumn,description);
    }
     
}
 