package kalang.tool;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.java.MemoryCompiler;
import kalang.java.MemoryFileManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Kason Yang <im@kasonyang.com>
 */
public class JointFileSystemCompiler extends FileSystemCompiler{
    
    final List<File> javaFiles = new LinkedList();
    

    @Override
    public void addSourceDir(File sourceDir) throws IOException {
        Collection<File> files = FileUtils.listFiles(sourceDir, new String[]{"java"}, true);
        if(files!=null){
            javaFiles.addAll(files);
        }
        super.addSourceDir(sourceDir);
    }

    @Override
    public void addSource(File srcDir, File file) throws IOException {
        if(file.getName().endsWith(".java")){
            javaFiles.add(file);
        }else{
            super.addSource(srcDir, file);
        }
    }

    @Override
    public void compile() {
        MemoryOutputManager om = new MemoryOutputManager();
        generateJavaStub(om);
        MemoryCompiler javaCompiler = new MemoryCompiler();
        for(File f:javaFiles){
            javaCompiler.addSourceFromFile(f);
        }
        String[] stubNames = om.getClassNames();
        for(String n:stubNames){
            String code = new String(om.getBytes(n));
            javaCompiler.addSourceFromString(n, code);
        }
        if(!javaCompiler.compile()){
            javaCompiler.printDiagnostic();
            return;
        }
        Map<String, byte[]> bytes = javaCompiler.getFileManager().getBytes();
        OutputManager outManager = getOutputManager();
        if(bytes!=null && outManager!=null){
            for(Map.Entry<String, byte[]> e:bytes.entrySet()){
                OutputStream os;
                try {
                    os = outManager.createOutputStream(e.getKey());
                    os.write(e.getValue());
                    os.close();
                } catch (IOException ex) {
                    //TODO handle ex
                    throw new RuntimeException(ex);
                }
            }
        }
        classLoader.addClassLoader(javaCompiler);
        super.compile();
    }
    
    

}
