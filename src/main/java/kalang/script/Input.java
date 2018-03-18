package kalang.script;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Kason Yang
 */
public class Input {

    private final OutputStream outputStream;

    private final Charset DEFAULT_CHARSET = Charset.defaultCharset();

    public Input(OutputStream os) {
        this.outputStream = os;
    }

    public Input put(String data) throws IOException {
        return put(data, DEFAULT_CHARSET.name());
    }

    public Input put(String data, String charset) throws IOException {
        outputStream.write(data.getBytes(charset));
        return this;
    }

    public Input put(File file) throws IOException {
        IOUtils.copy(new FileInputStream(file), outputStream);
        return this;
    }

    public void close() throws IOException {
        this.outputStream.close();
    }

}
