package kalang.io;

import kalang.lang.Completable;

/**
 * @author KasonYang
 */
public interface AsyncCloseable {

    Completable<Void> close();

}
