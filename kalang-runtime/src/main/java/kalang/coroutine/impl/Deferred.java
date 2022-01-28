package kalang.coroutine.impl;

import kalang.lang.Completable;

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

    private List<Consumer<T>> completeHandlers = new LinkedList<>();

    private List<Consumer<Throwable>> exceptionHandlers = new LinkedList<>();

    private List<Runnable> doneHandlers = new LinkedList<>();

    private T value;

    private Throwable error;

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
            public void completed(Consumer<T> handler) {
                if (state == STATE_PENDING) {
                    completeHandlers.add(handler);
                } else if (state == STATE_COMPLETED) {
                    notifyCompleted(Collections.singletonList(handler));
                }
            }

            @Override
            public void failed(Consumer<Throwable> handler) {
                if (state == STATE_PENDING) {
                    exceptionHandlers.add(handler);
                } else if (state == STATE_FAILED) {
                    notifyFailed(Collections.singletonList(handler));
                }
            }

            @Override
            public void done(Runnable handler) {
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

    public static <D> Completable<D> completed(D value) {
        Deferred<D> d = new Deferred<>();
        d.complete(value);
        return d.completable();
    }

    private void notifyCompleted(List<Consumer<T>> handlers) {
        for (Consumer<T> h : handlers) {
            h.accept(value);
        }
    }

    private void notifyFailed(List<Consumer<Throwable>> handlers) {
        for (Consumer<Throwable> h : handlers) {
            h.accept(error);
        }
    }

    private void notifyDone(List<Runnable> handlers) {
        for (Runnable h : handlers) {
            h.run();
        }
    }

}
