
package kalang;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.ast.ClassNode;
import kalang.compiler.Ast2Class;
import kalang.compiler.CodeGenerator;
import kalang.compiler.CompilationUnit;
import kalang.compiler.KalangCompiler;
import kalang.tool.FileSystemCompiler;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class KalangClassLoader extends ClassLoader implements CodeGenerator{

    private final FileSystemCompiler compiler;
    
    private boolean initialized = false;
    
    private final HashMap<String,Class> loadedClasses = new HashMap<>();

    public KalangClassLoader(File sourceDir) {
        compiler = new FileSystemCompiler();
        try {
            compiler.addSourceDir(sourceDir);
        } catch (IOException ex) {
            Logger.getLogger(KalangClassLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if(!initialized){
            compiler.setCodeGenerator(this);
            compiler.compile();
        }
        if(loadedClasses.containsKey(name)){
            return loadedClasses.get(name);
        }
        return super.findClass(name);
    }

    public void setOutputDir(File dir){
        compiler.setOutputDir(dir);
    }

    @Override
    public void generate(ClassNode classNode) {
        Ast2Class ast2Class = new Ast2Class();
        ast2Class.generate(classNode);
        byte[] bs = ast2Class.getClassBytes();
        String name = classNode.name;
        Class<?> clazz = defineClass(name, bs,0,bs.length);
        loadedClasses.put(name, clazz);
    }
    
}
