package kalang.lang;

/**
 * @author KasonYang
 */
public interface Generator<R> {

    R next();

    boolean isDone();

}
