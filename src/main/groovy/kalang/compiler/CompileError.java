package kalang.compiler;

public class CompileError  extends java.lang.RuntimeException  {
     public int start=0;
     public int stop=0;
     public java.lang.String className;
     public java.lang.String source;
     public String description;
     public  CompileError(java.lang.String description,java.lang.String className,java.lang.String src,int start,int stop) {
         super(description);
         this.description = description;
         this.start=start;
         this.stop=stop;
         this.className=className;
         this.source=src;
         
    }
     public java.lang.String getErrorSource() {
         if((this.stop<0)) return null;
         if((this.start<0)) return null;
         if((this.stop<this.start)) return null;
         return this.source.substring(this.start,this.stop);
         
    }

    @Override
    public String toString() {
        return "CompileError{" + "start=" + start + ", stop=" + stop + ", className=" + className + ", description=" + description + '}';
    }
     
}
 