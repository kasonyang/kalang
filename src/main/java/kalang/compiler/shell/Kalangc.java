package kalang.compiler.shell;

import kalang.compiler.compile.util.StandardDiagnosisHandler;
import kalang.compiler.tool.FileSystemCompiler;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

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
        try {
            return doExecute(cli);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return Constant.ERR_IO_EXCEPTION;
        }
    }

    protected int doExecute(CommandLine cli) throws IOException {
        File currentDir = new File(".");
        FileSystemCompiler fsc = new FileSystemCompiler();
        StandardDiagnosisHandler diagnosisHandler = new StandardDiagnosisHandler();
        fsc.setDiagnosisHandler(diagnosisHandler);
        fsc.setClassLoader(this.createClassLoader(cli));
        fsc.setConfiguration(this.createConfiguration(cli));
        KalangOption kalangOption = loadKalangOption(cli, new StringReader(""), currentDir);
        for (URL cp : kalangOption.getClassPaths()) {
            fsc.addClassPath(cp);
        }
        for (File sp :kalangOption.getSourcePaths()) {
            fsc.addSourcePath(sp);
        }
        if (cli.hasOption("sourcepath")) {
            String srcPath = cli.getOptionValue("sourcepath");
            fsc.addSourcePath(new File(srcPath));
        }
        fsc.setOutputDir(new File(cli.getOptionValue("output-dir", ".")));
        fsc.addSourcePath(currentDir);
        String[] srcs = cli.getArgs();
        for (String s : srcs) {
            File srcFile = new File(s);
            if (srcFile.isDirectory()) {
                fsc.addSourceDir(srcFile);
            } else {
                fsc.addSource(currentDir, srcFile);
            }
        }
        fsc.compile();
        return diagnosisHandler.hasError() ? Constant.ERR_COMPILE_ERROR : Constant.SUCCESS ;
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
