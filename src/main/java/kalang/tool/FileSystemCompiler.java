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
import kalang.compiler.CompileErrorHandler;
import kalang.compiler.JavaAstLoader;
import kalang.compiler.KalangCompiler;
import org.apache.commons.io.FileUtils;

/**
 * The FileSystemCompiler compile sources from file system.
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class FileSystemCompiler implements CompileErrorHandler{

    private Map<String, File> sourceFiles = new HashMap<>();

    private List<URL> classPaths = new LinkedList<>();

    private File outputDir;
    private KalangCompiler kalangCompiler;

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
        kalangCompiler = new KalangCompiler(astLoader);
        kalangCompiler.setCompileErrrorHandler(this);
        for (String srcName : sourceFiles.keySet()) {
            File f = sourceFiles.get(srcName);
            kalangCompiler.addSource(srcName, FileUtils.readFileToString(f));
        }
        kalangCompiler.compile();
        HashMap<String, CompilationUnit> units = kalangCompiler.getAllCompilationUnit();
        for (String cls : units.keySet()) {
            String code = units.get(cls).getJavaCode();
            byte[] bs = units.get(cls).getClassBytes();
            if (outputDir != null) {
                String fname = cls.replace(".", "/");// + ".java";
                File destFile = new File(outputDir, fname + ".java");
                File classDest = new File(outputDir,fname + ".class");
                FileUtils.write(destFile, code);
                FileUtils.writeByteArrayToFile(classDest, bs);
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

    @Override
    public void handleCompileError(CompileError error) {
        String cname = error.className;
        File fn = sourceFiles.get(cname);
        System.err.println(fn + ":" + error);
        kalangCompiler.setCompileTargetPhase(kalangCompiler.getCurrentCompilePhase());
    }

    public KalangCompiler getKalangCompiler() {
        return kalangCompiler;
    }

}
