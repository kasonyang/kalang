package kalang.lang;

import kalang.annotation.Nullable;

/**
 *
 * @author Kason Yang
 */
public abstract class Script {

    public final static int SUCCESS = 0;

    private String[] arguments = new String[0];

    protected abstract void execute() throws Throwable;

    public int run() throws Throwable {
        try{
            execute();
        }catch(Throwable e) {
            handleException(e);
        }
        return SUCCESS;
    }

    public int run(@Nullable String[] arguments) throws Throwable {
        if (arguments != null) {
            this.arguments = arguments;
        }
        return run();
    }
    
    protected String[] arguments(){
        return this.arguments;
    }
    
    protected String argument(int index,@Nullable String defaultValue) {
        return arguments.length > index ? arguments[index] : defaultValue;
    }
    
    protected void handleException(Throwable e) throws Throwable{
        throw e;
    }

}
