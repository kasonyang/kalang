package kalang.lang;

import kalang.coroutine.AsyncRunner;

import java.util.function.Consumer;

/**
 * @author KasonYang
 */
public class AsyncThread extends Thread implements AsyncTaskExecutor, TaskExecutor {

    private final AsyncRunner asyncRunner = new AsyncRunner();

    @Override
    public <T> Completable<T> submitAsyncTask(Generator<Completable<T>> task) {
        return asyncRunner.submitAsyncTask(task);
    }

    @Override
    public void submitTask(Runnable runnable) {
        asyncRunner.submitTask(runnable);
    }

    @Override
    public void run() {
        asyncRunner.run();
    }

    public static AsyncThread create() {
        AsyncThread thread = new AsyncThread();
        thread.start();
        return thread;
    }

    public static AsyncThread create(Consumer<AsyncThread> consumer) {
        AsyncThread thread = new AsyncThread();
        thread.submitAsyncTask(new Generator<Completable<Void>>() {

            private boolean isDone = false;

            @Override
            public Completable<Void> next() {
                isDone = true;
                return new Completable<>(thread, callback -> {
                    try {
                        consumer.accept(thread);
                        callback.resolve(null);
                    } catch (Throwable ex) {
                        callback.reject(ex);
                    }
                });
            }

            @Override
            public boolean isDone() {
                return isDone;
            }
        });
        thread.start();
        return thread;
    }

}
