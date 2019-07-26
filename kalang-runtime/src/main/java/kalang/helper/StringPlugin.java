package kalang.helper;

import kalang.annotation.PluginMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

public class StringPlugin {

    @PluginMethod
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

}
