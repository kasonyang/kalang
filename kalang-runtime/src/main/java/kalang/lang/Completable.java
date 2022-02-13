package kalang.lang;

import java.util.function.Consumer;

/**
 * @author KasonYang
 */
public interface Completable<T> {

    void onCompleted(Consumer<T> handler);

    void onFailed(Consumer<Throwable> handler);

    void onDone(Runnable handler);

    default void onDone(Consumer<T> completedHandler, Consumer<Throwable> failedHandler) {
        this.onCompleted(completedHandler);
        this.onFailed(failedHandler);
    }

    T getValue();

    Throwable getError();

    boolean isCompleted();

    boolean isFailed();

    boolean isDone();

}
