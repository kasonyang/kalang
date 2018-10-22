package kalang.type;

/**
 *
 * @author Kason Yang
 */
public interface Function3<R, P1, P2, P3> extends Function {

    R call(P1 arg1, P2 arg2, P3 arg3);

}
