package kalang.lang;

@Deprecated
public class DefaultStaticMembers {

    public static void println(Object msg) {
        System.out.println(msg);
    }

    public static void print(Object msg) {
        System.out.print(msg);
    }

    public static void printf(String format,Object... args) {
        System.out.printf(format,args);
    }

}
