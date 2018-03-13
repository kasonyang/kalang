package kalang.script;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.annotation.Nullable;
import kalang.lang.Script;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Kason Yang
 */
public abstract class ShellScript extends Script {

    public final static String DEFAULT_ENCODING = "utf8";

    protected String readText(String file, String encoding) throws IOException {
        return FileUtils.readFileToString(new File(file), encoding);
    }

    protected String readText(String file) throws IOException {
        return readText(file, DEFAULT_ENCODING);
    }

    protected void writeText(String file, String data, String encoding) throws IOException {
        FileUtils.writeStringToFile(new File(file), data, encoding);
    }

    protected void writeText(String file, String data) throws IOException {
        writeText(file, data, DEFAULT_ENCODING);
    }

    protected int randomInt(int min, int max) {
        //TODO here never return max
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    
    protected int randomInt() {
        return new Random().nextInt();
    }
    
    protected void deleteDirectory(String file) throws IOException {
        FileUtils.deleteDirectory(new File(file));
    }
    
    protected void deleteFile(String file) throws IOException{
        FileUtils.forceDelete(new File(file));
    }
    
    protected boolean exists(String file) {
        return new File(file).exists();
    }
    
    protected String baseName(String filename) {
        return FilenameUtils.getBaseName(filename);
    }
    
    protected String extension(String filename){
        return FilenameUtils.getExtension(filename);
    }
    
    protected void copyFile(String src,String dest) throws IOException{
        FileUtils.copyFile(new File(src), new File(dest));
    }
    
    protected void copyDirectory(String src,String dest) throws IOException {
        FileUtils.copyDirectory(new File(src), new File(dest));
    }
    
    protected void moveFile(String src,String dest) throws IOException{
        FileUtils.moveFile(new File(src), new File(dest));
    }
    
    protected void moveDirectory(String src,String desc) throws IOException{
        FileUtils.moveDirectory(new File(src), new File(desc));
    }
    
    protected String path(String[] parts){
        if (parts.length==0){
            throw new IllegalArgumentException("empty array");
        }
        File file = new File(parts[0]);
        for(int i=1;i<parts.length;i++) {
            file = new File(file,parts[i]);
        }
        return file.getPath();
    }
    
    protected int exec(String[] arguments) throws IOException{
        return exec(arguments,null);
    }

    protected int exec(String[] arguments,@Nullable String workingDirectory) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(arguments);
        pb.inheritIO();
        if (workingDirectory!=null && !workingDirectory.isEmpty()) {
            pb.directory(new File(workingDirectory));
        }
        Process p = pb.start();
        try {
            p.waitFor();
        } catch (InterruptedException ex) {

        }
        return p.exitValue();
    }
    
    protected String execOut(String[] arguments) throws InterruptedException, IOException {
        return execOut(arguments, null, 0);
    }

    protected String execOut(String[] arguments, @Nullable String workingDirectory) throws InterruptedException, IOException {
        return execOut(arguments, workingDirectory, 0);
    }

    protected String execOut(String[] arguments, @Nullable String workingDirectory, int expectingExitValue) throws InterruptedException, IOException {
        if(arguments == null || arguments.length==0){
            throw new IllegalArgumentException("empty array");
        }
        String command = arguments[0];
        File dir = workingDirectory == null ? null : new File(workingDirectory);
        Process p = Runtime.getRuntime().exec(arguments, null, dir);
        try {
            p.waitFor();
        } catch (InterruptedException ex) {
            throw ex;
        }
        int returnValue = p.exitValue();
        if (returnValue != expectingExitValue) {
            String err = String.format("%s exit with a unexpected value %d , expected %d", command, returnValue, expectingExitValue);
            throw new IOException(err);
        }
        InputStream is = p.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int rlen;
        while ((rlen = is.read(buffer)) > 0) {
            bos.write(buffer, 0, rlen);
        }
        return bos.toString();//TODO using default encoding?
    }

    protected int exec(String command) throws IOException {
        String[] arguments = command.split(" ");//TODO fix quotes
        return exec(arguments);
    }
    
    protected Properties loadProperties(String file) throws FileNotFoundException, IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(file));
        return props;
    }
    
    protected String now(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
