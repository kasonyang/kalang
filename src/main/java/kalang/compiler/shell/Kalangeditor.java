package kalang.compiler.shell;

import kalang.compiler.compile.Configuration;
import kalang.compiler.gui.Editor;
import kalang.compiler.tool.KalangShell;
import kalang.compiler.util.ClassExecutor;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Kason Yang
 */
public class Kalangeditor extends ShellBase {

    private CommandLine cli;

    private static final String APP_NAME = "kalangeditor";

    private static final String SYNTAX = "kalangeditor [options]";

    public static void main(String[] args) {
        new Kalangeditor().run(args);
    }

    @Override
    protected int execute(CommandLine cli) {
        this.cli = cli;
        Editor.main(this);
        return Constant.SUCCESS;
    }

    public Kalangeditor() {
        super(APP_NAME, SYNTAX, new Options());
    }

    public void eval(String className,String code) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ClassLoader classLoader = this.createClassLoader(cli);
        Configuration config = this.createConfiguration(cli);
        KalangOption shellOption = loadKalangOption(cli, new StringReader(code), null);
        KalangShell kalangshell = this.createKalangShell(config, classLoader, shellOption);
        Class<?> clazz = kalangshell.parse(className, code, className + ".kls");
        ClassExecutor.executeMain(clazz,new String[0]);
    }

}
