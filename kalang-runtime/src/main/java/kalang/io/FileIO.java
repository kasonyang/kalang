package kalang.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kason Yang
 */
public class FileIO {
    
    public final static Charset DEFAULT_CHARSET = Charset.forName("utf-8");
    
    public static String readText(File file) throws IOException{
        return readText(file,DEFAULT_CHARSET);
    }
    
    public static String readText(File file,String charset) throws IOException{
        return readText(file, Charset.forName(charset));
    }
    
    public static String readText(File file, Charset charset) throws IOException{
        StringBuilder buffer;
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file),charset)) {
            buffer = new StringBuilder();
            char[] buf = new char[4096];
            int rlen;
            while((rlen=reader.read(buf))>0){
                buffer.append(buf,0,rlen);
            }
        }
        return buffer.toString();
    }
    
    public static String readText(String file,Charset charset) throws IOException{
        return readText(new File(file),charset);
    }
    
    public static String readText(String file,String charset) throws IOException{
        return readText(new File(file),charset);
    }
    
    public static String readText(String file) throws IOException{
        return readText(new File(file));
    }
    
    public static String[] readLines(File file,Charset charset) throws IOException{
        List<String> lines = new LinkedList();
        String text = readText(file,charset);
        BufferedReader bfReader = new BufferedReader(new StringReader(text));
        String line;
        while((line=bfReader.readLine())!=null){
            lines.add(line);
        }
        return lines.toArray(new String[lines.size()]);
    }
    
    
    public static String[] readLines(File file,String charset) throws IOException{
        return readLines(file, Charset.forName(charset));
    }
    
    public static String[] readLines(File file) throws IOException{
        return readLines(file,DEFAULT_CHARSET);
    }
    
    public static String[] readLines(String file,Charset charset) throws IOException{
        return readLines(new File(file),charset);
    }
    
    public static String[] readLines(String file,String charset) throws IOException{
        return readLines(new File(file),Charset.forName(charset));
    }
    
    public static String[] readLines(String file) throws IOException{
        return readLines(new File(file),DEFAULT_CHARSET);
    }
    
    public static void writeText(OutputStream out,String text,Charset charset) throws IOException{
        try (OutputStreamWriter writer = new OutputStreamWriter(out, charset)) {
            writer.write(text);
        }
    }
    
    public static void writeText(OutputStream out,String text,String charset) throws IOException{
        writeText(out, text, Charset.forName(charset));
    }
    
    public static void writeText(OutputStream out,String text) throws IOException{
        writeText(out, text,DEFAULT_CHARSET);
    }
    
    public static void writeText(File out,String text,Charset charset) throws IOException{
        try (FileOutputStream fos = new FileOutputStream(out)) {
            writeText(fos, text, charset);
        }
    }
    
    public static void writeText(File out,String text,String charset) throws IOException{
        writeText(out, text, Charset.forName(charset));
    }
    
    public static void writeText(File out,String text) throws IOException{
        writeText(out, text,DEFAULT_CHARSET);
    }

}
