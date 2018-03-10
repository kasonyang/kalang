package kalang.lang;

import kalang.annotation.Nullable;

/**
 *
 * @author Kason Yang
 */
public abstract class Script {

    public final static int SUCCESS = 0;

    private String[] arguments = new String[0];

    protected abstract void execute();

    public int run() {
        execute();
        return SUCCESS;
    }

    public int run(@Nullable String[] arguments) {
        if (arguments != null) {
            this.arguments = arguments;
        }
        return run();
    }
    
    protected String[] arguments(){
        return this.arguments;
    }

}
