package kalang.tool;

import kalang.util.ClassNameUtil;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.ast.ClassNode;
import kalang.compiler.Ast2Class;
import kalang.compiler.Ast2Java;
import kalang.compiler.AstLoader;
import kalang.compiler.CodeGenerator;
import kalang.compiler.CompilationUnit;
import kalang.compiler.CompileError;
import kalang.compiler.CompileErrorHandler;
import kalang.compiler.DefaultCompileConfiguration;
import kalang.compiler.JavaAstLoader;
import kalang.compiler.KalangCompiler;
import org.apache.commons.io.FileUtils;

/**
 * The FileSystemCompiler compile sources from file system.
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class FileSystemCompiler implements CompileErrorHandler,CodeGenerator{

    private Map<String, File> sourceFiles = new HashMap<>();

    private List<URL> classPaths = new LinkedList<>();

    private File outputDir;
    private KalangCompiler kalangCompiler;
    
    private CodeGenerator codeGenerator = this;

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
        kalangCompiler = new KalangCompiler(new DefaultCompileConfiguration(){
            @Override
            public AstLoader getAstLoader() {
                return astLoader;
            }

            @Override
            public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
                return codeGenerator;
            }
            
        });
        kalangCompiler.setCompileErrorHandler(this);
        //kalangCompiler.setCodeGenerator(codeGenerator);
        for (String srcName : sourceFiles.keySet()) {
            File f = sourceFiles.get(srcName);
            kalangCompiler.addSource(srcName, FileUtils.readFileToString(f));
        }
        kalangCompiler.compile();
    }

    public File getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(File outputDir) {
        this.outputDir = outputDir;
    }

    @Override
    public void handleCompileError(CompileError error) {
        String cname = error.getCompilationUnit().getSource().getClassName();
        File fn = sourceFiles.get(cname);
        System.err.println(fn + ":" + error);
        kalangCompiler.setCompileTargetPhase(kalangCompiler.getCurrentCompilePhase());
    }

    public KalangCompiler getKalangCompiler() {
        return kalangCompiler;
    }
    
    private String generateJavaCode(ClassNode classNode){
        Ast2Java ast2Java = new Ast2Java();
        ast2Java.generate(classNode);
        return ast2Java.getCode();
    }
    
    private byte[] generateClassBytes(ClassNode clazz){
        Ast2Class ast2Class = new Ast2Class();
        ast2Class.generate(clazz);
        return ast2Class.getClassBytes();
    }

    @Override
    public void generate(ClassNode classNode) {
        String cls = classNode.name;
        if (outputDir != null) {
                String fname = cls.replace(".", "/");// + ".java";
                File destFile = new File(outputDir, fname + ".java");
                File classDest = new File(outputDir,fname + ".class");
                try{
                    FileUtils.write(destFile,generateJavaCode(classNode));
                    FileUtils.writeByteArrayToFile(classDest,generateClassBytes(classNode));
                }catch(IOException ex){
                    //TODO report io exception
                    System.err.println(ex.getMessage());
                }
            } else {
                System.out.println(generateJavaCode(classNode));
            }
    }

    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    public void setCodeGenerator(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }
    
    

}
