package kalang.java;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import kalang.util.ClassNameUtil;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class MemoryCompiler extends ClassLoader{
    
    protected final List<JavaFileObject> sources = new LinkedList<>();
    
    protected MemoryFileManager fileManager;
    private DiagnosticCollector<JavaFileObject> diagnosticCollector;
    
    public void addSourceFromFile(File file){
        SimpleJavaFileObject s = new SimpleJavaFileObject(URI.create(file.getName()),SimpleJavaFileObject.Kind.SOURCE){             
            @Override
            public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
                String str = "";
                Reader r = new FileReader(file);
                BufferedReader br = new BufferedReader(r);
                String line;
                while((line=br.readLine())!=null){
                    str += line + "\r\n";
                }
                return str;
            }
        };
        sources.add(s);
    }
    
    public void addSourceFromString(String className,String content){
        SimpleJavaFileObject s = new SimpleJavaFileObject(URI.create(className.replace(".", "/") + ".java"),JavaFileObject.Kind.SOURCE){
            @Override
            public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
                return content;
            }
        };
        sources.add(s);
    }

    public  boolean compile() {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //TODO maybe null
        diagnosticCollector = new DiagnosticCollector();
        List<JavaFileObject> jfiles = new LinkedList<>();
        for (JavaFileObject sf : sources) {
            jfiles.add(sf);
        }
        //String[] options = new String[2];
        //options[0] = "-d";
        //options[1] = outputPath;//String.format("\"%s\"", outputPath);
        StandardJavaFileManager sfm = compiler.getStandardFileManager(null, null, null);
        fileManager = new MemoryFileManager((sfm));
        CompilationTask task = compiler.getTask(null, fileManager, diagnosticCollector, null, null, jfiles);
        return task.call();
    }

    public MemoryFileManager getFileManager() {
        return fileManager;
    }

    public DiagnosticCollector<JavaFileObject> getDiagnosticCollector() {
        return diagnosticCollector;
    }
    
    public void printDiagnostic(){
        if(diagnosticCollector!=null){
            for (Diagnostic<? extends JavaFileObject> diagnostic : diagnosticCollector.getDiagnostics()) {
                System.out.println(diagnostic.getCode());
                System.out.println(diagnostic.getKind());
                System.out.println(diagnostic.getPosition());
                System.out.println(diagnostic.getStartPosition());
                System.out.println(diagnostic.getEndPosition());
                System.out.println(diagnostic.getSource());
                System.out.println(diagnostic.getMessage(null));
            }
        }
    }
    
    public void writeClassesToFile(File outputDir) throws IOException{
        if(fileManager!=null){
            for(Map.Entry<String, byte[]> e:fileManager.getBytes().entrySet()){
                String clsName = e.getKey();
                byte[] data = e.getValue();
                String relativePath = ClassNameUtil.getRelativePathOfClass(clsName, "class");
                File of = new File(outputDir,relativePath);
                FileUtils.writeByteArrayToFile(of, data, false);
            }
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if(fileManager!=null){
            Map<String, byte[]> bs = fileManager.getBytes();
            if(bs!=null){
                byte[] data = bs.get(name);
                if(data!=null){
                    return defineClass(name, data,0,data.length);
                }
            }
        }
        //TODO set classLoader
        return super.findClass(name);
    }
    
    
    
}

