package kalang.lang;

import java.util.function.Consumer;

/**
 * @author KasonYang
 */
public interface Completable<T> {

    void completed(Consumer<T> handler);

    void failed(Consumer<Throwable> handler);

    void done(Runnable handler);

    T getValue();

    Throwable getError();

    boolean isCompleted();

    boolean isFailed();

    boolean isDone();

}
