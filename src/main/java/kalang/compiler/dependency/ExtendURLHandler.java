package kalang.compiler.dependency;

import kalang.mixin.IOMixin;
import org.apache.ivy.util.CopyProgressListener;
import org.apache.ivy.util.Message;
import org.apache.ivy.util.url.BasicURLHandler;
import org.apache.ivy.util.url.URLHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ExtendURLHandler extends BasicURLHandler {

    public ExtendURLHandler() {
        setRequestMethod(URLHandler.REQUEST_METHOD_GET);
    }

    @Override
    public URLInfo getURLInfo(URL url, int timeout) {
        URLConnection con = null;
        try {
            url = normalizeToURL(url);
            boolean useHead = getRequestMethod() == URLHandler.REQUEST_METHOD_HEAD;
            con = getURLConnection(url, useHead);
            if (con instanceof HttpURLConnection) {
                HttpURLConnection httpCon = (HttpURLConnection) con;
                int responseCode = httpCon.getResponseCode();
                if (responseCode == 200 || (useHead && responseCode == 204)) {
                    String bodyCharset = getCharSetFromContentType(con.getContentType());
                    return new URLInfo(true, httpCon.getContentLength(), con.getLastModified(), bodyCharset){};
                }
            } else {
                int contentLength = con.getContentLength();
                if (contentLength <= 0) {
                    return UNAVAILABLE;
                } else {
                    String bodyCharset = getCharSetFromContentType(con.getContentType());
                    return new URLInfo(true, contentLength, con.getLastModified(), bodyCharset){};
                }
            }
        } catch (IOException e) {
            Message.error("Server access error at url " + url, e);
        } finally {
            disconnect(con);
        }
        return UNAVAILABLE;
    }

    @Override
    public InputStream openStream(URL url) throws IOException {
        return getURLConnection(url, false).getInputStream();
    }

    @Override
    public void download(URL src, File dest, CopyProgressListener l) throws IOException {
        try (InputStream is = openStream(src)) {
            IOMixin.writeFrom(new FileOutputStream(dest), is);
        }
    }

    private URLConnection getURLConnection(URL url, boolean useHead) throws IOException {
        URLConnection con = url.openConnection();
        if (!(con instanceof HttpURLConnection)) {
            return con;
        }
        HttpURLConnection httpCon = (HttpURLConnection) con;
        httpCon.setRequestProperty("User-Agent", getUserAgent());
        if (useHead) {
            httpCon.setRequestMethod("HEAD");
        }
        int status = httpCon.getResponseCode();
        if (status != 301 && status != 302){
            return con;
        }
        String location = httpCon.getHeaderField("Location");
        if (location == null || location.isEmpty()) {
            return con;
        }
        try {
            return getURLConnection(new URL(location), useHead);
        } finally {
            disconnect(con);
        }
    }

    private void disconnect(URLConnection con) {
        if (con instanceof HttpURLConnection) {
            ((HttpURLConnection) con).disconnect();
        } else if (con != null) {
            try {
                con.getInputStream().close();
            } catch (IOException e) {
                // ignored
            }
        }
    }

}
