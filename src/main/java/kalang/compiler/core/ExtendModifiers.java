package kalang.compiler.core;

/**
 * @author KasonYang
 */
public class ExtendModifiers {

    public static final int GENERATOR = 1;

    public static final int ASYNC = 2;

    public static final int REF = 1 << 2;

    public static boolean isGenerator(int extendModifier) {
        return (GENERATOR & extendModifier) != 0;
    }

    public static boolean isAsync(int extendModifier) {
        return (ASYNC & extendModifier) != 0;
    }

    public static boolean isRef(int extendModifier) {
        return (REF & extendModifier) != 0;
    }

}
