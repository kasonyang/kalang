package kalang.lang;

/**
 * @author KasonYang
 */
public interface AsyncRunnable {

    Completable<Void> run();

}
