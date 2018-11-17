package kalang.lang;

import kalang.annotation.Nullable;

/**
 *
 * @author Kason Yang
 */
public abstract class Script {

    public final static int SUCCESS = 0;

    private String[] arguments = new String[0];

    protected abstract int execute() throws Throwable;

    public int run() throws Throwable {
        try{
            return execute();
        }catch(Throwable e) {
            return handleException(e);
        }
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
    
    protected int handleException(Throwable e) throws Throwable{
        throw e;
    }

    protected void println(Object msg) {
        System.out.println(msg);
    }

    protected void print(Object msg) {
        System.out.print(msg);
    }

    protected void printf(String format,Object... args) {
        System.out.printf(format,args);
    }

}
