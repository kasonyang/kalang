package kalang.shell;

import kalang.compiler.Configuration;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

/**
 *
 * @author Kason Yang
 */
public class Kalangeditor extends ShellBase {

    private static final String APP_NAME = "kalangeditor";

    private static final String SYNTAX = "kalangeditor [options]";

    public static void main(String[] args) {
        new Kalangeditor().run(args);
    }

    @Override
    protected int execute(CommandLine cli) {
        Configuration config = this.createConfiguration(cli);
        ClassLoader classLoader = this.createClassLoader(cli);
        kalang.gui.Editor.main(config, classLoader);
        return Constant.SUCCESS;
    }

    public Kalangeditor() {
        super(APP_NAME, SYNTAX, new Options());
    }

}
