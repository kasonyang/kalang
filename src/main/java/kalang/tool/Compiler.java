package kalang.tool;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kalang.KalangClassLoader;
import kalang.Script;
import kalang.compiler.Configuration;
import kalang.compiler.Diagnosis;
import kalang.compiler.DiagnosisHandler;
import kalang.compiler.StandardDiagnosisHandler;
import kalang.util.ClassNameUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Kason Yang 
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
        OPTIONS.addOption(null,"script-base",true,"script base class");
        OPTIONS.addOption("l","lib-path",true,"library path");
        OPTIONS.addOption("v","verbose",false,"show verbose information");
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
        boolean verbose = cli.hasOption("verbose");
        if(cli.hasOption("gui")){
            String baseScriptClass = cli.getOptionValue("script-base", "");
            Configuration config = new Configuration();
            if(!baseScriptClass.isEmpty()){
                config.setScriptBaseClass(baseScriptClass);
            }
            kalang.gui.Editor.main(config,createClassLoader(cli,verbose));
            return true;
        }else if(cli.hasOption("run")){
            return run(cli);
        }else{
            JointFileSystemCompiler fsc = new JointFileSystemCompiler();
            DiagnosisHandler oldHandler = fsc.getDiagnosisHandler();
            fsc.setDiagnosisHandler(new DiagnosisHandler() {
                @Override
                public void handleDiagnosis(Diagnosis diagnosis) {
                    oldHandler.handleDiagnosis(diagnosis);
                    if(diagnosis.getKind().isError()) Compiler.this.hasError = true;
                }
            });
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
        KalangClassLoader kcl = new KalangClassLoader(new File[0],null,null);
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
    
    private ClassLoader createClassLoader(CommandLine cli,boolean verbose) {
        List<URL> urls = new LinkedList();
        String[] libPaths = cli.getOptionValue("lib-path", "").split(";");
        for (String l : libPaths) {
            if(l.isEmpty()) continue;
            File ld = new File(l);
            if(!ld.isDirectory()) continue;
            Collection<File> jars = FileUtils.listFiles(ld, new String[]{"jar"}, false);
            for(File j:jars){
                try{
                    urls.add(j.toURI().toURL());
                } catch (MalformedURLException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        }
        File[] cps = parseClassPath(cli);
        for (int i = 0; i < cps.length; i++) {
            try {
                urls.add(cps[i].toURI().toURL());
            } catch (MalformedURLException ex) {
                ex.printStackTrace(System.err);
            }
        }
        if(verbose){
            for(URL u:urls){
                System.out.println("Add class path:" + u);
            }
        }
        return new URLClassLoader(urls.toArray(new URL[urls.size()]));
    }

}
