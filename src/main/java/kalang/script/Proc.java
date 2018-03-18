package kalang.script;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/**
 *
 * @author Kason Yang
 */
public class Proc {

    private final Process process;

    public Proc(Process process) throws IOException {
      this.process = process;
    }

    public OutputStream getOutputStream() {
        return process.getOutputStream();
    }

    public InputStream getInputStream() {
        return process.getInputStream();
    }

    public InputStream getErrorStream() {
        return process.getErrorStream();
    }

    public int waitFor() throws InterruptedException {
        return process.waitFor();
    }

    public boolean waitFor(long timeout, TimeUnit unit) throws InterruptedException {
        return process.waitFor(timeout, unit);
    }
    
    public boolean waitFor(long timeout) throws InterruptedException {
        return waitFor(timeout, TimeUnit.MILLISECONDS);
    }

    public int exitValue() {
        return process.exitValue();
    }
    
    public boolean exitsWith(int exitValue) {
        return process.exitValue() == exitValue;
    }

    public void destroy() {
        process.destroy();
    }

    public Process destroyForcibly() {
        return process.destroyForcibly();
    }

    public boolean isAlive() {
        return process.isAlive();
    }

    public String out() throws IOException {
        return inputStreamToString(process.getInputStream(), Charset.defaultCharset().name());
    }

    public String err() throws IOException {
        return inputStreamToString(process.getErrorStream(), Charset.defaultCharset().name());
    }

    private String inputStreamToString(InputStream is, String charset) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int rlen;
        while ((rlen = is.read(buffer)) > 0) {
            bos.write(buffer, 0, rlen);
        }
        return bos.toString(charset);
    }

}
