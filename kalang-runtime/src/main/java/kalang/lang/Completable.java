package kalang.lang;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KasonYang
 */
public class Completable<T> {

    public interface Resolver<V> {
        void resolve(V value);
        void reject(Throwable error);
    }

    public interface Executor<V> {
        void execute(Resolver<V> resolver);
    }

    public interface FailedHandler<R> {

        Completable<R> handleFailed(Throwable error) throws Throwable;

    }

    public interface CompletedHandler<R, V> {

        Completable<R> handleCompleted(V value) throws Throwable;

    }

    public interface SettledHandler<R, V> {

        Completable<R> handleSettled(Completable<V> completable) throws Throwable;

    }

    public interface FinallyHandler {
        void handleFinally() throws Throwable;
    }


    private final static int STATE_PENDING = 0;

    private final static int STATE_COMPLETED = 1;

    private final static int STATE_FAILED = 2;

    private int state = STATE_PENDING;

    private final TaskExecutor taskExecutor;

    private Queue<Runnable> tasks = new LinkedList<>();

    private T value;

    private Throwable error;

    public Completable(TaskExecutor taskExecutor, Executor<T> executor) {
        this.taskExecutor = taskExecutor;
        Resolver<T> resolver = new Resolver<T>() {
            @Override
            public void resolve(T value) {
                if (state != STATE_PENDING) {
                    return;
                }
                state = STATE_COMPLETED;
                Completable.this.value = value;
                submitTasks(tasks);
                tasks = null;
            }

            @Override
            public void reject(Throwable error) {
                if (state != STATE_PENDING) {
                    return;
                }
                state = STATE_FAILED;
                Completable.this.error = error;
                submitTasks(tasks);
                tasks = null;
            }
        };
        try {
            executor.execute(resolver);
        } catch (Throwable error) {
            resolver.reject(error);
        }
    }

    public Completable(Executor<T> executor) {
        this(getExecutorByThread(), executor);
    }

    public  <D> Completable<D> onSettled(SettledHandler<D, T> settledHandler) {
        return onCompleted(value -> settledHandler.handleSettled(this), error -> settledHandler.handleSettled(this));
    };

    public <D> Completable<D> onCompleted(CompletedHandler<D, T> completedHandler, FailedHandler<D> failedHandler) {
        return new Completable<D>(resolver -> {
            Runnable task = () -> {
                if (state == STATE_COMPLETED) {
                    try {
                        Completable<D> cResult = completedHandler.handleCompleted(value);
                        delegate(resolver, cResult);
                    } catch (Throwable ex) {
                        resolver.reject(ex);
                    }
                } else if (state == STATE_FAILED) {
                    try {
                        Completable<D> fResult = failedHandler.handleFailed(error);
                        delegate(resolver, fResult);
                    } catch (Throwable ex) {
                        resolver.reject(ex);
                    }
                }
            };
            if (state != STATE_PENDING) {
                submitTasks(new LinkedList<>(Collections.singleton(task)));
            } else {
                tasks.add(task);
            }
        });
    }

    public  <D> Completable<D> onCompleted(CompletedHandler<D, T> completedHandler) {
        return onCompleted(completedHandler, error -> {
            throw error;
        });
    }


    public Completable<T> onFailed(FailedHandler<T> failedHandler) {
        return onCompleted(Completable::resolve, failedHandler);
    }

    public Completable<T> onFinally(FinallyHandler finallyHandler) {
        return onSettled(self -> {
            finallyHandler.handleFinally();
            if (self.isFailed()) {
                return Completable.reject(self.getError());
            }
            return Completable.resolve(self.getValue());
        });
    }

    public T getValue() {
        if (state != STATE_COMPLETED) {
            throw new IllegalStateException("Not completed");
        }
        return value;
    }

    public Throwable getError() {
        if (state != STATE_FAILED) {
            throw new IllegalStateException("Not failed");
        }
        return error;
    }

    public boolean isCompleted() {
        return state == STATE_COMPLETED;
    }

    public boolean isFailed() {
        return state == STATE_FAILED;
    }

    public boolean isDone() {
        return state != STATE_PENDING;
    }


    public static <D> Completable<D> resolve(D value) {
        return new Completable<>(resolver -> {
            resolver.resolve(value);
        });
    }

    public static <D> Completable<D> reject(Throwable error) {
        return new Completable<>(resolver -> {
            resolver.reject(error);
        });
    }

    private void submitTasks(Queue<Runnable> tasks) {
        while (!tasks.isEmpty()) {
            Runnable cb = tasks.poll();
            taskExecutor.submitTask(cb);
        }
    }

    private static <D> void delegate(Resolver<D> resolver, Completable<D> completable) {
        completable.onSettled(r -> {
            if (r.isFailed()) {
                resolver.reject(r.getError());
            } else {
                resolver.resolve(r.getValue());
            }
            return null;
        });
    }

    private static TaskExecutor getExecutorByThread() {
        Thread thread = Thread.currentThread();
        if (!(thread instanceof TaskExecutor)) {
            throw new IllegalStateException("Deferred should be creating in the thread implemented CallbackExecutor");
        }
        return (TaskExecutor) thread;
    }

}
