package kalang;

/**
 *
 * @author Kason Yang
 */
public abstract class Script {

    public final static int SUCCESS = 0;

    protected abstract void execute();

    public int run() {
        execute();
        return SUCCESS;
    }

}
