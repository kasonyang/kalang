package kalang.tool;

import kalang.util.ClassNameUtil;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.compiler.CompilationUnit;
import kalang.compiler.CompileError;
import kalang.compiler.JavaAstLoader;
import kalang.compiler.KalangCompiler;
import org.apache.commons.io.FileUtils;

/**
 * The FileSystemCompiler compile sources from file system.
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class FileSystemCompiler {

    private Map<String, File> sourceFiles = new HashMap<>();

    private List<URL> classPaths = new LinkedList<>();

    private File outputDir;

    public void addSource(String className, File file) {
        sourceFiles.put(className, file);
    }

    public void addSourceDir(File sourceDir) {
        Collection<File> files = FileUtils.listFiles(sourceDir, new String[]{"kl"}, true);
        for (File f : files) {
            String clsName = ClassNameUtil.getClassName(sourceDir, f);
            addSource(clsName, f);
        }
    }

    public void addClassPath(File path) {
        try {
            classPaths.add(path.toURI().toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(FileSystemCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void compile() throws IOException {
        URLClassLoader urlClassLoader = new URLClassLoader(classPaths.toArray(new URL[0]));
        JavaAstLoader astLoader = new JavaAstLoader(urlClassLoader);
        KalangCompiler cpl = new KalangCompiler(astLoader);
        for (String srcName : sourceFiles.keySet()) {
            File f = sourceFiles.get(srcName);
            cpl.addSource(srcName, FileUtils.readFileToString(f));
        }
        cpl.setCompileErrorHandlerrrorHandler((CompileError error) -> {
            String cname = error.className;
            File fn = sourceFiles.get(cname);
            System.err.println(fn + ":" + error);
        });
        cpl.compile();
        HashMap<String, CompilationUnit> units = cpl.getAllCompilationUnit();
        for (String cls : units.keySet()) {
            String code = units.get(cls).getJavaCode();
            if (outputDir != null) {
                String fname = cls.replace(".", "/") + ".java";
                File destFile = new File(outputDir, fname);
                FileUtils.write(destFile, code);
            } else {
                System.out.println(code);
            }
        }
    }

    public File getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(File outputDir) {
        this.outputDir = outputDir;
    }

}
