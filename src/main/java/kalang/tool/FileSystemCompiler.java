package kalang.tool;

import kalang.util.ClassNameUtil;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import kalang.ast.ClassNode;
import kalang.compiler.codegen.Ast2Class;
import kalang.compiler.codegen.Ast2Java;
import kalang.compiler.codegen.Ast2JavaStub;
import kalang.compiler.AstLoader;
import kalang.compiler.CodeGenerator;
import kalang.compiler.CompilationUnit;
import kalang.compiler.CompileContextProxy;
import kalang.compiler.CompileError;
import kalang.compiler.CompileErrorHandler;
import kalang.compiler.CompilePhase;
import kalang.compiler.DefaultCompileContext;
import kalang.compiler.JavaAstLoader;
import kalang.compiler.KalangCompiler;
import kalang.compiler.SourceLoader;
import org.apache.commons.io.FileUtils;
import kalang.compiler.CompileContext;

/**
 * The FileSystemCompiler compile sources from file system.
 * 
 * @author Kason Yang
 */
public class FileSystemCompiler extends KalangCompiler{

    private Map<String, File> sourceFiles = new HashMap<>();

    protected List<URL> classPaths = new LinkedList<>();
    
    @Nullable
    protected MultiClassLoader classLoader;
    
    protected  final List<File> sourcePaths = new LinkedList<>();
    
    @Deprecated
    public void addClassLoader(ClassLoader classLoader){
        getClassLoader().addClassLoader(classLoader);
    }
    
    public MultiClassLoader getClassLoader(){
        //TODO bug?
        if(classLoader == null){
            URLClassLoader pathClassLoader = new URLClassLoader(classPaths.toArray(new URL[classPaths.size()]));
            classLoader = new MultiClassLoader(pathClassLoader);
        }
        return classLoader;
    }
    
    private CodeGenerator codeGenerator;

    public FileSystemCompiler() {
        super();
        super.compileContext =  new CompileContextProxy(super.compileContext){
            
            @Override
            public AstLoader getAstLoader() {
                JavaAstLoader astLoader = new JavaAstLoader(getClassLoader());
                return astLoader;
            }

            @Override
            public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
                return new CodeGenerator(){
                    @Override
                    public void generate(ClassNode classNode) {
                        if(codeGenerator!=null){
                            codeGenerator.generate(classNode);
                        }
                    }
                    
                };
            }
        };
    }

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
    
    public void generateJavaStub(OutputManager om) {
        //TODO here has a bug.It will ignore class reference in method body
        super.compile(CompilePhase.PHASE_PARSING);
        HashMap<String, CompilationUnit> sourceAsts = getCompilationUnits();
        for(Map.Entry<String, CompilationUnit> a:sourceAsts.entrySet()){
            Ast2JavaStub a2js = new Ast2JavaStub();
            a2js.generate(a.getValue().getAst());
            String stubCode = a2js.getJavaStubCode();
            String className = (a.getValue().getAst().name);
            if(om==null){
                System.out.println(stubCode);
            }else{                
                try {
                    OutputStream os = om.createOutputStream(className);
                    //TODO should set encoding?
                    os.write(stubCode.getBytes());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
                
        }
    }   

    @Override
    public SourceLoader getSourceLoader() {
        return new FileSystemSourceLoader(sourcePaths.toArray(new File[sourcePaths.size()]),new String[]{"kl","kalang"});
    }
    
    public void addSourcePath(File path){
        sourcePaths.add(path);
    }

    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }

    public void setCodeGenerator(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }
    
    protected void handleIOException(IOException ex){
        ex.printStackTrace(System.err);
    }

}
