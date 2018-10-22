package kalang.type;

/**
 *
 * @author Kason Yang
 */
public interface Function1<R, P> extends Function {

    R call(P arg);

}
