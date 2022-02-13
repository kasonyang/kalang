package kalang.lang;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author KasonYang
 */
public class Deferred<T> {

    private final static int STATE_PENDING = 0;

    private final static int STATE_COMPLETED = 1;

    private final static int STATE_FAILED = 2;

    private int state = STATE_PENDING;

    private final CallbackExecutor callbackExecutor;

    private List<Consumer<T>> completeHandlers = new LinkedList<>();

    private List<Consumer<Throwable>> exceptionHandlers = new LinkedList<>();

    private List<Runnable> doneHandlers = new LinkedList<>();

    private T value;

    private Throwable error;

    public Deferred() {
        this.callbackExecutor = getExecutorByThread();
    }

    public Deferred(CallbackExecutor callbackExecutor) {
        this.callbackExecutor = callbackExecutor;
    }

    public void complete(T value) {
        if (state != STATE_PENDING) {
            return;
        }
        state = STATE_COMPLETED;
        this.value = value;
        notifyCompleted(completeHandlers);
        notifyDone(doneHandlers);
        completeHandlers = null;
        doneHandlers = null;
    }

    public void fail(Throwable ex) {
        if (state != STATE_PENDING) {
            return;
        }
        state = STATE_FAILED;
        error = ex;
        notifyFailed(exceptionHandlers);
        notifyDone(doneHandlers);
        exceptionHandlers = null;
        doneHandlers = null;
    }

    public Completable<T> completable() {
        return new Completable<T>() {
            @Override
            public void onCompleted(Consumer<T> handler) {
                if (state == STATE_PENDING) {
                    completeHandlers.add(handler);
                } else if (state == STATE_COMPLETED) {
                    notifyCompleted(Collections.singletonList(handler));
                }
            }

            @Override
            public void onFailed(Consumer<Throwable> handler) {
                if (state == STATE_PENDING) {
                    exceptionHandlers.add(handler);
                } else if (state == STATE_FAILED) {
                    notifyFailed(Collections.singletonList(handler));
                }
            }

            @Override
            public void onDone(Runnable handler) {
                if (state == STATE_PENDING) {
                    doneHandlers.add(handler);
                } else {
                    notifyDone(Collections.singletonList(handler));
                }
            }

            @Override
            public T getValue() {
                if (state != STATE_COMPLETED) {
                    throw new IllegalStateException("Not completed");
                }
                return value;
            }

            @Override
            public Throwable getError() {
                if (state != STATE_FAILED) {
                    throw new IllegalStateException("Not failed");
                }
                return error;
            }

            @Override
            public boolean isCompleted() {
                return state == STATE_COMPLETED;
            }

            @Override
            public boolean isFailed() {
                return state == STATE_FAILED;
            }

            @Override
            public boolean isDone() {
                return state != STATE_PENDING;
            }
        };
    }

    public static <D> Completable<D> completedOf(D value) {
        return completedOf(value, getExecutorByThread());
    }


    public static <D> Completable<D> completedOf(D value, CallbackExecutor callbackExecutor) {
        Deferred<D> d = new Deferred<>(callbackExecutor);
        d.complete(value);
        return d.completable();
    }

    public static <D> Completable<D> failedOf(Throwable error) {
        return failedOf(error);
    }

    public static <D> Completable<D> failedOf(Throwable error, CallbackExecutor callbackExecutor) {
        Deferred<D> d = new Deferred<>(callbackExecutor);
        d.fail(error);
        return d.completable();
    }

    public void delegate(Completable<T> target) {
        target.onCompleted(this::complete);
        target.onFailed(this::fail);
    }

    private void notifyCompleted(List<Consumer<T>> handlers) {
        final T v = value;
        for (Consumer<T> h : handlers) {
            callbackExecutor.submitCallback(() -> h.accept(v));
        }
    }

    private void notifyFailed(List<Consumer<Throwable>> handlers) {
        Throwable e = error;
        for (Consumer<Throwable> h : handlers) {
            callbackExecutor.submitCallback(() -> h.accept(e));
        }
    }

    private void notifyDone(List<Runnable> handlers) {
        for (Runnable h : handlers) {
            callbackExecutor.submitCallback(h);
        }
    }

    private static CallbackExecutor getExecutorByThread() {
        Thread thread = Thread.currentThread();
        if (!(thread instanceof CallbackExecutor)) {
            throw new IllegalStateException("Deferred should be creating in the thread implemented CallbackExecutor");
        }
        return (CallbackExecutor) thread;
    }

}
