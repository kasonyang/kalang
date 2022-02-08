package kalang.coroutine;

import kalang.lang.AsyncExecuteThread;
import kalang.lang.Completable;

/**
 * @author KasonYang
 */
public class AsyncHelper {

    public static <T> Completable<T> submit(ExecuteContext context, NextExecutor executor, String name) {
        Thread thread = Thread.currentThread();
        if (!(thread instanceof AsyncExecuteThread)) {
            throw new IllegalStateException("async methods is allow to invoke in AsyncExecuteThread only");
        }
        AsyncExecuteThread at = (AsyncExecuteThread) thread;
        GeneratorImpl<Completable<T>> generator = GeneratorImpl.create(context, executor, name);
        return at.submitAsyncTask(generator);
    }


}
