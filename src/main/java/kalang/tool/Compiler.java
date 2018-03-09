package kalang.tool;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kalang.lang.Script;
import kalang.compiler.Configuration;
import kalang.compiler.Diagnosis;
import kalang.compiler.DiagnosisHandler;
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
    
    public final static String 
            CMD_RUN = "run",
            CMD_GUI = "gui",
            CMD_COMPILE = "compile";

    private boolean hasError = false;

    public static void printUsage(String syntax,Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(syntax, options);
    }

    public void compile(String cmd, String[] args,String syntax,Options options) {
        options.addOption("h","help",false,"show this help message");
        options.addOption("v","verbose",false,"show verbose information");
        options.addOption(null,"script-base",true,"specify default script base class");
        options.addOption("l","lib-path",true,"library path");
        options.addOption("cp", true, "compile classpath");
        options.addOption("s", true, "source directory");
        
        DefaultParser parser = new DefaultParser();
        CommandLine cli;
        try{
            cli = parser.parse(options, args);
        } catch (ParseException ex) {
            ex.printStackTrace(System.err);
            return;
        }
        if (cli.hasOption("help")){
            printUsage(syntax, options);
            return;
        }
        
        boolean verbose = cli.hasOption("verbose");
        String baseScriptClass = cli.getOptionValue("script-base", "");
        Configuration config = new Configuration();
        if(!baseScriptClass.isEmpty()){
            config.setScriptBaseClass(baseScriptClass);
        }
        ClassLoader classLoader = createClassLoader(cli,verbose);
        if(CMD_GUI.equals(cmd)){
            kalang.gui.Editor.main(config,classLoader);
        }else if(CMD_RUN.equals(cmd)){
            run(cli,config,classLoader);
        }else if(CMD_COMPILE.equals(cmd)){
            //TODO use classLoader and config
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
                try {
                    fsc.addKalangAndJavaSourceDir(new File(srcPath));
                } catch (IOException ex) {
                    //TODO show exception message
                }
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
                    try {
                        fsc.addKalangAndJavaSourceDir(srcFile);
                    } catch (IOException ex) {
                        //TODO show exception message
                    }
                }else{
                    try {
                        //TODO here should be currenDir?
                        fsc.addKalangOrJavaSource(currentDir , srcFile);
                    } catch (IOException ex) {
                        //TODO show exception message
                    }
                }
            }
            hasError = false;
            fsc.compile();
        }else{
            throw new IllegalArgumentException("unknown command:" + cmd);
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
    
    public boolean run(CommandLine cli,Configuration config,ClassLoader classLoader){
        String[] args = cli.getArgs();
        if(args.length==0){
            return false;
        }
        File file = new File(args[0]);
        KalangShell sh = new KalangShell(config, classLoader);
        try {
            Script script = sh.parseScript(file);
            script.run();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        return true;
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
