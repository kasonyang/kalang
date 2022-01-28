package kalang.coroutine;

import kalang.lang.Completable;
import kalang.lang.Generator;

/**
 * @author KasonYang
 */
public interface AsyncExecuteThread {

    <T> Completable<T> submitAsyncTask(Generator<Completable<T>> task);

}
