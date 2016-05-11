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
import kalang.compiler.Ast2JavaStub;
import kalang.compiler.AstLoader;
import kalang.compiler.CodeGenerator;
import kalang.compiler.CompilationUnit;
import kalang.compiler.CompileConfiguration;
import kalang.compiler.CompileConfigurationProxy;
import kalang.compiler.CompileError;
import kalang.compiler.CompileErrorHandler;
import kalang.compiler.CompilePhase;
import kalang.compiler.DefaultCompileConfiguration;
import kalang.compiler.JavaAstLoader;
import kalang.compiler.KalangCompiler;
import org.apache.commons.io.FileUtils;

/**
 * The FileSystemCompiler compile sources from file system.
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class FileSystemCompiler extends KalangCompiler implements CompileErrorHandler,CodeGenerator{

    private Map<String, File> sourceFiles = new HashMap<>();

    private List<URL> classPaths = new LinkedList<>();
    
    private OutputManager outputManager;

    public FileSystemCompiler() {
        this(new DefaultCompileConfiguration());
    }

    public FileSystemCompiler(CompileConfiguration config) {
        super();
        super.configuration =  new CompileConfigurationProxy(config){
            @Override
            public AstLoader getAstLoader() {
                URLClassLoader urlClassLoader = new URLClassLoader(classPaths.toArray(new URL[0]));
                JavaAstLoader astLoader = new JavaAstLoader(urlClassLoader);
                return astLoader;
            }

            @Override
            public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
                return codeGenerator;
            }
            
        };
        super.compileErrorHandler = this;
    }
    
    private CodeGenerator codeGenerator = this;

    public void addSource(File srcDir, File file) throws IOException {
        String className = ClassNameUtil.getClassName(srcDir, file);
        sourceFiles.put(className, file);
        super.addSource(className, FileUtils.readFileToString(file),file.getName());
    }

    public void addSourceDir(File sourceDir) throws IOException {
        Collection<File> files = FileUtils.listFiles(sourceDir, new String[]{"kl"}, true);
        for (File f : files) {
            addSource(sourceDir , f);
        }
    }

    public void addClassPath(File path) {
        try {
            classPaths.add(path.toURI().toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(FileSystemCompiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void compile() {
        super.compile();
    }

    @Override
    public void handleCompileError(CompileError error) {
        String cname = error.getCompilationUnit().getSource().getClassName();
        File fn = sourceFiles.get(cname);
        System.err.println(fn + ":" + error);
        setCompileTargetPhase(getCurrentCompilePhase());
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
        if (outputManager != null) {
            try {
                OutputStream os = outputManager.createOutputStream(cls);
                //os.write(generateJavaCode(classNode).getBytes());
                os.write(generateClassBytes(classNode));
            } catch (IOException ex) {
                //TODO handle ex
                Logger.getLogger(FileSystemCompiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    public void setCodeGenerator(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }
    
    public void generateJavaStub(File outputDir) {
        int oldPhase = getCompileTargetPhase();
        setCompileTargetPhase(CompilePhase.PHASE_BUILDAST);
        super.compile();
        HashMap<String, CompilationUnit> sourceAsts = getAllCompilationUnit();
        for(Map.Entry<String, CompilationUnit> a:sourceAsts.entrySet()){
            Ast2JavaStub a2js = new Ast2JavaStub();
            a2js.generate(a.getValue().getAst());
            String stubCode = a2js.getJavaStubCode();
            String path = ClassNameUtil.getRelativePathOfClass(a.getValue().getAst().name, "java");
            if(outputDir==null){
                System.out.println(stubCode);
            }else{
                File of = new File(outputDir,path);
                try {
                    FileUtils.writeStringToFile(of, stubCode,false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
                
        }
        setCompileTargetPhase(oldPhase);
    }

    public OutputManager getOutputManager() {
        return outputManager;
    }

    public void setOutputManager(OutputManager outputManager) {
        this.outputManager = outputManager;
    }

}
