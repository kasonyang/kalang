package kalang.lang;

/**
 * @author KasonYang
 */
public interface AsyncExecuteThread {

    <T> Completable<T> submitAsyncTask(Generator<Completable<T>> task);

}
