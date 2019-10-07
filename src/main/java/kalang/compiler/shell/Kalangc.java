package kalang.compiler.shell;

import kalang.compiler.compile.StandardDiagnosisHandler;
import kalang.compiler.tool.FileSystemCompiler;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Kason Yang
 */
public class Kalangc extends ShellBase {

    public final static String APP_NAME = "kalangc";

    public final static String SYNTAX = "kalangc";

    public static void main(String[] args) {
        System.exit(new Kalangc().run(args));
    }

    @Override
    protected int execute(CommandLine cli) {
        FileSystemCompiler fsc = new FileSystemCompiler();
        StandardDiagnosisHandler diagnosisHandler = StandardDiagnosisHandler.INSTANCE;
        fsc.setDiagnosisHandler(diagnosisHandler);
        fsc.setClassLoader(this.createClassLoader(cli));
        fsc.setConfiguration(this.createConfiguration(cli));
        if (cli.hasOption("sourcepath")) {
            String srcPath = cli.getOptionValue("sourcepath");
            fsc.addSourcePath(new File(srcPath));
        }
        fsc.setOutputDir(new File(cli.getOptionValue("output-dir", ".")));
        File currentDir = new File(".");
        fsc.addSourcePath(currentDir);
        String[] srcs = cli.getArgs();
        for (String s : srcs) {
            File srcFile = new File(s);
            if (srcFile.isDirectory()) {
                try {
                    fsc.addSourceDir(srcFile);
                } catch (IOException ex) {//TODO handle ex
                    System.err.println(ex.getMessage());
                    return Constant.ERR_IO_EXCEPTION;
                }
            } else {
                fsc.addSource(currentDir, srcFile);
            }
        }
        try {
            fsc.compile();
            return diagnosisHandler.hasError() 
                    ? Constant.ERR_COMPILE_ERROR 
                    : Constant.SUCCESS ;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return Constant.ERR_IO_EXCEPTION;
        }
    }

    public Kalangc() {
        super(APP_NAME, SYNTAX, createOptions());
    }

    private static Options createOptions() {
        Options ops = new Options();
        ops.addOption("o", "output-dir", true, "output directory");
        //ops.addOption("f", "format", true, "output format");
        return ops;
    }

}
