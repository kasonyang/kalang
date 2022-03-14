package kalang.lang;

import kalang.coroutine.AsyncRunner;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

/**
 * @author KasonYang
 */
public class AsyncThread extends Thread implements AsyncTaskExecutor, TaskExecutor {

    private final AsyncRunner asyncRunner = new AsyncRunner();

    private final static Timer TIMER = new Timer();

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

    public static <T> T execute(AsyncCallable<T> supplier) throws Throwable {
        Ref<T> value = new Ref<>();
        Ref<Throwable> errorRef = new Ref<>();
        create(asyncThread -> {
            supplier.call().onCompleted(value::set, errorRef::set).onFinally(asyncThread::interrupt);
        }).join();
        if (errorRef.get() != null) {
            throw errorRef.get();
        }
        return value.get();
    }

    public static Completable<Void> delay(long millis) {
        return new Completable<>(resolver -> {
            TIMER.schedule(new TimerTask() {
                @Override
                public void run() {
                    currentAsyncThread().submitTask(() -> {
                        resolver.resolve(null);
                    });
                }
            }, millis);
        });
    }

    private static AsyncThread currentAsyncThread() {
        Thread thread = Thread.currentThread();
        if (!(thread instanceof AsyncThread)) {
            throw new IllegalStateException("current thread is not an async thread");
        }
        return (AsyncThread) thread;
    }

}
