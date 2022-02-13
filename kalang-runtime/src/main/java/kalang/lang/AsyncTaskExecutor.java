package kalang.lang;

/**
 * @author KasonYang
 */
public interface AsyncTaskExecutor {

    <T> Completable<T> submitAsyncTask(Generator<Completable<T>> task);

}
