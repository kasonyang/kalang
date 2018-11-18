package kalang.compiler.script;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 *
 * @author Kason Yang
 */
public class Output {

    private final InputStream inputStream;

    private final Charset DEFAULT_CHARSET = Charset.defaultCharset();

    public Output(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String string(String charset) throws IOException {
        return IOUtils.toString(inputStream, charset);
    }

    public String string() throws IOException {
        return IOUtils.toString(inputStream, DEFAULT_CHARSET);
    }

}
