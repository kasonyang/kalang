package kalang.type;

/**
 *
 * @author Kason Yang
 */
public interface Function5<R, P1, P2, P3, P4, P5> extends Function {

    R call(P1 arg1, P2 arg2, P3 arg3, P4 arg4, P5 arg5);

}
