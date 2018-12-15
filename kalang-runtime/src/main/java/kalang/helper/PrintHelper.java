package kalang.helper;

import java.util.Collection;

public class PrintHelper {

    public static void println(Object msg) {
        System.out.println(msg);
    }

    public static void printlns(Collection messages) {
        for (Object o : messages) {
            println(o);
        }
    }

    public static void printlns(Object[] messages) {
        for (Object o : messages) {
            println(o);
        }
    }

    public static void print(Object msg) {
        System.out.print(msg);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

}
