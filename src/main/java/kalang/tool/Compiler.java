package kalang.tool;

import java.io.File;
import java.io.IOException;
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
    }

    public static void printUsage() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(APP_NAME, OPTIONS);
    }

    public static void main(String[] args) throws ParseException {
        DefaultParser parser = new DefaultParser();
        CommandLine cli = parser.parse(OPTIONS, args);
        if (args.length == 0 || cli.hasOption("h")) {
            printUsage();
            return;
        }
        FileSystemCompiler fsc = new FileSystemCompiler();
        if (cli.hasOption("cp")) {
            String cps = cli.getOptionValue("cp");
            for (String cp : cps.split(";")) {
                File cpFile = new File(cp);
                if (cpFile.exists()) {
                    fsc.addClassPath(new File(cp));
                }
            }
        }
        String outPath = ".";
        if (cli.hasOption("s")) {
            String srcPath = cli.getOptionValue("s");
            fsc.addSourceDir(new File(srcPath));
        }
        if (cli.hasOption("o")) {
            outPath = cli.getOptionValue("o");
        }
        fsc.setOutputDir(new File(outPath));
        File currentDir = new File(".");
        String[] srcs = cli.getArgs();
        for(String s:srcs){
            File srcFile = new File(s);
            if(srcFile.isDirectory()){
                fsc.addSourceDir(srcFile);
            }else{
                String clsName = ClassNameUtil.getClassName(currentDir,srcFile);
                fsc.addSource(clsName , srcFile);
            }
        }
        try {
            fsc.compile();
        } catch (IOException ex) {
            System.err.println("IO Error:" + ex.getMessage());
        }
    }

}
