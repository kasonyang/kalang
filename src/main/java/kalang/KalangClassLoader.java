
package kalang;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.compiler.CompilationUnit;
import kalang.compiler.KalangCompiler;
import kalang.tool.FileSystemCompiler;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class KalangClassLoader extends ClassLoader{

    private final FileSystemCompiler compiler;
    
    private boolean initialized = false;

    public KalangClassLoader(File sourceDir) {
        compiler = new FileSystemCompiler();
        compiler.addSourceDir(sourceDir);
    }
    
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if(!initialized){
            try {
                compiler.compile();
            } catch (IOException ex) {
                Logger.getLogger(KalangClassLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        KalangCompiler kc = compiler.getKalangCompiler();
        CompilationUnit unit = kc.getCompilationUnit(name);
        if(unit!=null){
            byte[] bs = unit.getClassBytes();
            return defineClass(name, bs, 0, bs.length);
        }
        return super.findClass(name);
    }

    public void setOutputDir(File dir){
        compiler.setOutputDir(dir);
    }
    
}
