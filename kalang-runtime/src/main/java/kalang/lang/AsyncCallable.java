package kalang.lang;

/**
 * @author KasonYang
 */
public interface AsyncCallable<T> {

    Completable<T> call();

}
