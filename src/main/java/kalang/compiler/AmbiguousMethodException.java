
package kalang.compiler;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class AmbiguousMethodException extends Exception{

    public AmbiguousMethodException(String message) {
        super(message);
    }

    public AmbiguousMethodException() {
    }

}
