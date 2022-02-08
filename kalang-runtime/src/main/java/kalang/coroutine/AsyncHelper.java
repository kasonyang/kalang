package kalang.coroutine;

import kalang.lang.AsyncExecuteThread;
import kalang.lang.Completable;

/**
 * @author KasonYang
 */
public class AsyncHelper {

    public static <T> Completable<T> submit(ExecuteContext context, NextExecutor executor) {
        Thread thread = Thread.currentThread();
        if (!(thread instanceof AsyncExecuteThread)) {
            throw new IllegalStateException("async methods is allow to invoke in AsyncExecuteThread only");
        }
        AsyncExecuteThread at = (AsyncExecuteThread) thread;
        GeneratorImpl<Completable<T>> generator = GeneratorImpl.create(context, executor);
        return at.submitAsyncTask(generator);
    }


}
