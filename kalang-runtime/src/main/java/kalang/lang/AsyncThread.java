package kalang.lang;

import kalang.coroutine.AsyncRunner;

/**
 * @author KasonYang
 */
public class AsyncThread extends Thread implements AsyncTaskExecutor, CallbackExecutor {

    private final AsyncRunner asyncRunner = new AsyncRunner();

    private final boolean keepAlive;

    public AsyncThread(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public AsyncThread() {
        this(true);
    }

    @Override
    public <T> Completable<T> submitAsyncTask(Generator<Completable<T>> task) {
        Completable<T> result = asyncRunner.submitTask(task);
        notifyAsyncRunner();
        return result;
    }

    @Override
    public void submitCallback(Runnable callback) {
        asyncRunner.submitCallback(callback);
        notifyAsyncRunner();
    }

    @Override
    public void run() {
        for (;; ) {
            asyncRunner.run();
            if (!keepAlive) {
                return;
            }
            try {
                synchronized (asyncRunner) {
                    asyncRunner.wait();
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static AsyncThread run(Runnable runnable) {
        AsyncThread thread = new AsyncThread(false);
        thread.submitAsyncTask(new Generator<Completable<Void>>() {

            private boolean isDone = false;

            @Override
            public Completable<Void> next() {
                isDone = true;
                Deferred<Void> d = new Deferred<>(thread);
                try {
                    runnable.run();
                    d.complete(null);
                } catch (Throwable ex) {
                    d.fail(ex);
                }
                return d.completable();
            }

            @Override
            public boolean isDone() {
                return isDone;
            }
        });
        thread.start();
        return thread;
    }

    private void notifyAsyncRunner() {
        synchronized (asyncRunner) {
            asyncRunner.notify();
        }
    }

}
