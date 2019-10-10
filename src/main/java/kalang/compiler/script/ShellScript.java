package kalang.compiler.script;

import kalang.lang.Script;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.annotation.Nullable;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 *
 * @author Kason Yang
 */
@Deprecated
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
    
    protected void appendText(String file, String data, String encoding) throws IOException {
        FileUtils.writeStringToFile(new File(file), data, encoding, true);
    }

    protected void appendText(String file, String data) throws IOException {
        appendText(file, data, DEFAULT_ENCODING);
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
    
    protected void mkdirs(String directory) throws IOException{
        FileUtils.forceMkdir(new File(directory));
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
    
    protected int exec(String[] arguments) throws IOException, InterruptedException{
        return exec(arguments,null,"","","");
    }

    protected int exec(
            String[] arguments
            ,@Nullable String workingDirectory
            ,@Nullable String input
            ,@Nullable String output
            ,@Nullable String errOutput
    ) throws IOException, InterruptedException {
      Proc p = start(arguments,workingDirectory,input,output,errOutput);
      p.waitFor();
      return p.exitValue();
    }
    
    protected Proc start(String[] command) throws IOException {
        return start(command, null,null,null,null);
    }
    
    protected Proc start(
            String[] arguments
            ,@Nullable String workingDir
            ,@Nullable String input
            ,@Nullable String output
            ,@Nullable String errOutput
    ) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(arguments);
        if (input != null) {
            if (input.isEmpty()){
                pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
            } else {
                pb.redirectInput(new File(input));
            }   
        }
        if (output != null) {
            if (output.isEmpty()){
                pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            } else {
                pb.redirectOutput(this.getFileRedirectForOutput(output));
            }            
        }
        if (errOutput != null) {
            if (errOutput.isEmpty()) {
                pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            } else {
                pb.redirectError(this.getFileRedirectForOutput(errOutput));
            }   
        }
        if (workingDir!=null && !workingDir.isEmpty()) {
            pb.directory(new File(workingDir));
        }
        return new Proc(pb.start());
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

    @Deprecated
    protected int exec(String command) throws IOException, InterruptedException {
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
    
    protected String today() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    protected void exit(int status){
        System.exit(status);
    }
    
    private ProcessBuilder.Redirect getFileRedirectForOutput(String redirectFile){
        if (redirectFile.startsWith(">>")){
            return ProcessBuilder.Redirect.appendTo(new File(redirectFile.substring(2)));
        } else if (redirectFile.startsWith(">")){
            return ProcessBuilder.Redirect.to(new File(redirectFile.substring(1)));
        } else {
            return ProcessBuilder.Redirect.appendTo(new File(redirectFile));
        }
    }

}
