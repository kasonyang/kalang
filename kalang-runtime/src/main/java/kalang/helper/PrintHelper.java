package kalang.helper;

import java.util.Arrays;
import java.util.Collection;

/**
 * print methods
 */
public class PrintHelper {

    public static void println(Object msg) {
        System.out.println(msg);
    }

    public static void println(boolean[] msg) {
        println(Arrays.toString(msg));
    }

    public static void println(long[] msg) {
        println(Arrays.toString(msg));
    }


    public static void println(byte[] msg) {
        println(Arrays.toString(msg));
    }

    public static void println(char[] msg) {
        println(Arrays.toString(msg));
    }

    public static void println(int[] msg) {
        println(Arrays.toString(msg));
    }

    public static void println(short[] msg) {
        println(Arrays.toString(msg));
    }

    public static void println(float[] msg) {
        println(Arrays.toString(msg));
    }

    public static void println(double[] msg) {
        println(Arrays.toString(msg));
    }

    public static void println(Object[] msg) {
        println(Arrays.deepToString(msg));
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

    public static void print(boolean[] msg) {
        System.out.print(Arrays.toString(msg));
    }

    public static void print(byte[] msg) {
        System.out.print(Arrays.toString(msg));
    }

    public static void print(short[] msg) {
        System.out.print(Arrays.toString(msg));
    }

    public static void print(int[] msg) {
        System.out.print(Arrays.toString(msg));
    }

    public static void print(long[] msg) {
        System.out.print(Arrays.toString(msg));
    }

    public static void print(float[] msg) {
        System.out.print(Arrays.toString(msg));
    }

    public static void print(double[] msg) {
        System.out.print(Arrays.toString(msg));
    }

    public static void print(Object[] msg) {
        System.out.print(Arrays.deepToString(msg));
    }


    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

}
