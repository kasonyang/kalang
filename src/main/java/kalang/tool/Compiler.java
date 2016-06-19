package kalang.tool;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.KalangClassLoader;
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

    static {
        OPTIONS = new Options();
        OPTIONS.addOption("h", false, "show this help message");
        OPTIONS.addOption("cp", true, "compile classpath");
        OPTIONS.addOption("s", true, "source directory");
        OPTIONS.addOption("o", true, "output directory");
        OPTIONS.addOption("f",true,"output format");
        OPTIONS.addOption("run", true, "run the class with special name");
        //OPTIONS.addOption("t",true,"set the output type,should be one of class,java");
    }

    public static void printUsage() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(APP_NAME, OPTIONS);
    }

    public static void main(String[] args) throws ParseException, IOException {
        DefaultParser parser = new DefaultParser();
        CommandLine cli = parser.parse(OPTIONS, args);
        if (args.length == 0 || cli.hasOption("h")) {
            printUsage();
            return;
        }
        if(cli.hasOption("run")){
            run(cli);
            return;
        }else{
            JointFileSystemCompiler fsc = new JointFileSystemCompiler();
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
            fsc.compile();
        }
    }
    
    private static File[] parseClassPath(CommandLine cli){
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
    
    public static void run(CommandLine cli){
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
            return;
        }
        Method mm;
        try {
            mm = clazz.getMethod("main",Class.forName("[Ljava.lang.String;"));
        } catch (NoSuchMethodException ex) {
            System.err.println("main method not found!");
            return;
        } catch (SecurityException | ClassNotFoundException ex) {
            Logger.getLogger(Compiler.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        if(!Modifier.isStatic(mm.getModifiers())){
            System.out.println("main method is not static");
            return;
        }
        try {
            mm.invoke(null,new Object[]{cli.getArgs()});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

}
