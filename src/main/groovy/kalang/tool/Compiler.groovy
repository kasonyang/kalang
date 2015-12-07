package kalang.tool;
import kalang.compiler.*
import jast.ast.*
import kalang.antlr.KalangLexer
import kalang.antlr.KalangParser
import kalang.core.VarTable
import kava.antlr.*

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

class Compiler {
	
	static void printUsage(){
		println '''\
kac src dest
'''
	}
	
    static void main(String[] args) {
		def srcDir = "."
		def outDir = "."
		if(args.length==1){
			srcDir = outDir = args[0]
		}else if(args.length>=2){
			srcDir = args[0]
			outDir = args[1]
		}
		def src =new File(srcDir)
		def dest =new File(outDir)
		if(!src.exists()){
			throw new RuntimeException("source directory not exist!")
		}
		if(!dest.exists()){
			dest.mkdirs()
		}
		compile(src,dest)
    }
    
    static List<File> getFiles(File dir){
        def list = []
        def files = dir.listFiles();
        for(File f in files){
            if(f.isDirectory()){
                list.addAll(getFiles(f))
            }else{
                list.add(f);
            }
        }
        return list;
    }
	
	static void compile(String className,String src,File outDir=null){
		compile([className],[src],outDir)
	}
	
	static void compile(List<String> className,List<String> srcList,File outDir=null){
		def astLoader = new JavaAstLoader();
        def cpl = new KalangCompiler(astLoader);
		assert className.size() == srcList.size()
		int size = srcList.size();
		for(int i=0;i<size;i++){
			cpl.addSource(className.get(i),srcList.get(i));
		}
		try{
            cpl.compile()
			def javaCodes = cpl.getJavaCodes();
			for(def cls in javaCodes.keySet()){
				def code = javaCodes.get(cls)
				if(outDir){
					def fname = cls.replace(".","/") + ".java";
					def destFile = new File(outDir,fname)
					destFile.withWriter{ w ->
						w.write(code)
					}
				}else{
					println code
				}
			}
        }catch(CompileError e){
            def src = e.getSource();
            def ltext = src.substring(e.offset,e.offset + e.length)
            String errMsg =  e.message + " on ${ltext}"
			throw new Exception(errMsg)
        }
	}
    
    static void compile(File srcDir,File outDir) {
		def srcs = getFiles(srcDir);
        def abSrcPath = srcDir.getAbsolutePath()
		def classNames = []
		def srces = []
        for(File s in srcs){
            def fname = s.getAbsolutePath();
            if(!fname.endsWith(".kl")) continue;
            def clsName = fname.substring(abSrcPath.length()+1,fname.length()-3).replace(File.separator,".");
            def txt = s.readLines().join("\r\n");
            classNames.add(clsName)
			srces.add(txt);
        }
        compile(classNames,srces,outDir)
    }
}