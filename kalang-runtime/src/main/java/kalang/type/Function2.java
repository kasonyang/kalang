package kalang.type;

/**
 *
 * @author Kason Yang
 */
public interface Function2<R, P1, P2> extends Function {

    R call(P1 arg1, P2 arg2);

}
