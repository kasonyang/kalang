package kalang.tool;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.KalangClassLoader;
import kalang.compiler.Diagnosis;
import kalang.compiler.StandardDiagnosisHandler;
import kalang.util.ClassNameUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class Compiler {

    private final static String APP_NAME = "kalang";

    private final static Options OPTIONS;
    
    private boolean hasError = false;

    static {
        OPTIONS = new Options();
        OPTIONS.addOption("h", false, "show this help message");
        OPTIONS.addOption("cp", true, "compile classpath");
        OPTIONS.addOption("s", true, "source directory");
        OPTIONS.addOption("o", true, "output directory");
        OPTIONS.addOption("f",true,"output format");
        OPTIONS.addOption("run", true, "run the class with special name");
        OPTIONS.addOption("gui",false,"start a buildin gui");
        //OPTIONS.addOption("t",true,"set the output type,should be one of class,java");
    }

    public static void printUsage() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(APP_NAME, OPTIONS);
    }
    
    public static void main(String[] args) throws ParseException, IOException {
        Compiler cper = new Compiler();
        cper.compile(args);
    }

    public boolean compile(String[] args) throws ParseException, IOException {
        DefaultParser parser = new DefaultParser();
        CommandLine cli = parser.parse(OPTIONS, args);
        if (args.length == 0 || cli.hasOption("h")) {
            printUsage();
            return false;
        }
        if(cli.hasOption("gui")){
            kalang.gui.Editor.main(args);
            return true;
        }else if(cli.hasOption("run")){
            return run(cli);
        }else{
            JointFileSystemCompiler fsc = new JointFileSystemCompiler(){
                @Override
                protected void reportDiagnosis(Diagnosis dn) {
                    if(dn.getKind().isError()){
                        Compiler.this.hasError = true;
                    }
                    super.reportDiagnosis(dn);
                }
            };
            File[] cps = parseClassPath(cli);
            if(cps!=null){
                for (File cp : cps) {
                        fsc.addClassPath(cp);
                }
            }
            String outPath = ".";
            if (cli.hasOption("s")) {
                String srcPath = cli.getOptionValue("s");
                fsc.addKalangAndJavaSourceDir(new File(srcPath));
            }
            if (cli.hasOption("o")) {
                outPath = cli.getOptionValue("o");
            }
            String outputFormat = "class";
            if(cli.hasOption("f")){
                outputFormat = cli.getOptionValue("f");
            }
            FileSystemOutputManager outputManager = new FileSystemOutputManager(new File(outPath), outputFormat);
            switch(outputFormat){
                case "class":
                    fsc.setJavaOutputManager(outputManager);
                    fsc.setCodeGenerator(new ClassWriter(outputManager));
                    break;
                case "ast":
                    fsc.setCodeGenerator(new AstWriter(outputManager));
                    break;
                default:
                    throw new UnsupportedOperationException("unknown format:" + outputFormat);
            }
            File currentDir = new File(".");
            fsc.addJavaSourcePath(currentDir);
            fsc.addSourcePath(currentDir);
            String[] srcs = cli.getArgs();
            for(String s:srcs){
                File srcFile = new File(s);
                if(srcFile.isDirectory()){
                    fsc.addKalangAndJavaSourceDir(srcFile);
                }else{
                    //TODO here should be currenDir?
                    fsc.addKalangOrJavaSource(currentDir , srcFile);
                }
            }
            hasError = false;
            fsc.compile();
            return !hasError;
        }
    }
    
    private File[] parseClassPath(CommandLine cli){
        if (cli.hasOption("cp")) {
            String[] cps = cli.getOptionValue("cp").split(";");
            File[] file = new File[cps.length];
            for (int i=0;i<cps.length;i++) {
                file[i] = new File(cps[i]);
            }
            return file;
        }
        return new File[0];
    }
    
    public boolean run(CommandLine cli){
        String clsName = cli.getOptionValue("run");
        KalangClassLoader kcl = new KalangClassLoader();
        kcl.addClassPath(new File("."));
        File[] cps = parseClassPath(cli);
        if(cps!=null){
            for(File c:cps){
                kcl.addClassPath(c);
            }
        }
        Class<?> clazz;
        try {
             clazz = kcl.loadClass(clsName);
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found!");
            return false;
        }
        Method mm;
        try {
            mm = clazz.getMethod("main",Class.forName("[Ljava.lang.String;"));
        } catch (NoSuchMethodException ex) {
            System.err.println("main method not found!");
            return false;
        } catch (SecurityException | ClassNotFoundException ex) {
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        if(!Modifier.isStatic(mm.getModifiers())){
            System.out.println("main method is not static");
            return false;
        }
        try {
            mm.invoke(null,new Object[]{cli.getArgs()});
            return true;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
