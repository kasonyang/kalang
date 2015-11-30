import compilier.*
import jast.ast.*
import kalang.antlr.KalangLexer
import kalang.antlr.KalangParser
import kalang.core.VarObject
import kalang.core.VarTable
import kava.antlr.*

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

class Application {
    static void main(args) {
        def astLoader = new JavaAstLoader();
        def cpl = new KalangCompiler(astLoader);
        def srcs = new File("TestScript/src").listFiles();
        for(File s in srcs){
            def clsName = s.getName()
            def txt = s.readLines().join("\r\n");
            cpl.addSource(clsName,txt)
        }
        try{
            cpl.compile();	
        }catch(CompileError e){
            def src = e.getSource();
            def ltext = src.substring(e.offset,e.offset + e.length +1)
            System.err.println e.message + " on ${ltext}"
        }
        ////println names
        //println cls;
    }
}