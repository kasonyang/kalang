package kalang.coroutine;

import kalang.lang.AsyncTaskExecutor;
import kalang.lang.Completable;

/**
 * @author KasonYang
 */
public class AsyncHelper {

    public static <T> Completable<T> submit(ExecuteContext context, NextExecutor executor, String name) {
        Thread thread = Thread.currentThread();
        if (!(thread instanceof AsyncTaskExecutor)) {
            throw new IllegalStateException("async methods is allow to invoke in the thread implemented AsyncTaskExecutor");
        }
        AsyncTaskExecutor at = (AsyncTaskExecutor) thread;
        GeneratorImpl<Completable<T>> generator = GeneratorImpl.create(context, executor, name);
        return at.submitAsyncTask(generator);
    }


}
