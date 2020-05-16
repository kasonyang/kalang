package kalang.mixin;

import kalang.annotation.MixinMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMixin {

    @MixinMethod
    public static String[] lines(String str) {
        List<String> list = new LinkedList<>();
        BufferedReader r = new BufferedReader(new StringReader(str));
        try {
            String ln;
            while ((ln = r.readLine()) != null) {
                list.add(ln);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return list.toArray(new String[0]);
    }

    @MixinMethod
    public static String searchFirst(String str, Pattern pattern) {
        String[] result = search(str, pattern, 1);
        return result.length == 0 ? null : result[0];
    }

    @MixinMethod
    public static String searchFirst(String str, String regexp) {
        return searchFirst(str,  Pattern.compile(regexp));
    }

    @MixinMethod
    public static String[] search(String str, Pattern pattern, int limit) {
        List<String> result = new LinkedList<>();
        Matcher matcher = pattern.matcher(str);
        for(;;) {
            if (limit > 0 && result.size() >= limit) {
                break;
            }
            if (!matcher.find()) {
                break;
            }
            result.add(str.substring(matcher.start(), matcher.end()));
        }
        return result.toArray(new String[0]);
    }

    @MixinMethod
    public static String[] search(String str, String regexp, int limit) {
        return search(str, Pattern.compile(regexp), limit);
    }

    @MixinMethod
    public static String[] search(String str, Pattern pattern) {
        return search(str, pattern, 0);
    }

    @MixinMethod
    public static String[] search(String str, String regexp) {
        return search(str, regexp, 0);
    }
}
