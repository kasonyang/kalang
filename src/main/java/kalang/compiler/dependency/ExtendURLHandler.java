package kalang.compiler.dependency;

import org.apache.ivy.util.CopyProgressListener;
import org.apache.ivy.util.url.BasicURLHandler;
import org.apache.ivy.util.url.URLHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class ExtendURLHandler extends BasicURLHandler {

    private Map<URL,URL> resolvedFinalUrlMap = new HashMap<>();

    public ExtendURLHandler() {
        setRequestMethod(URLHandler.REQUEST_METHOD_GET);
    }

    @Override
    public URLInfo getURLInfo(URL url, int timeout) {
        URLInfo urlInfo = super.getURLInfo(url, timeout);
        if (!urlInfo.isReachable()) {
            URL finalUrl = this.getFinalURL(url);
            if (!finalUrl.equals(url)) {
                urlInfo = super.getURLInfo(finalUrl);
            }
        }
        return urlInfo;
    }

    @Override
    public InputStream openStream(URL url) throws IOException {
        URL finalUrl = getFinalURL(url);
        return super.openStream(finalUrl);
    }

    @Override
    public void download(URL src, File dest, CopyProgressListener l) throws IOException {
        URL finalUrl = getFinalURL(src);
        super.download(finalUrl, dest, l);
    }

    private URL getFinalURL(URL url) {
        URL resolvedUrl = resolvedFinalUrlMap.get(url);
        if (resolvedUrl != null) {
            return resolvedUrl;
        }
        URL finalUrl = this.doGetFinalURL(url);
        resolvedFinalUrlMap.put(url, finalUrl);
        return finalUrl;
    }

    private URL doGetFinalURL(URL url) {
        try {
            URLConnection conn = url.openConnection();
            try {
                if (!(conn instanceof HttpURLConnection)) {
                    return url;
                }
                HttpURLConnection httpConn = (HttpURLConnection) conn;
                //httpConn.setRequestMethod("HEAD");
                int respCode = httpConn.getResponseCode();
                if (respCode != 301 && respCode != 302) {
                    return url;
                }
                String location = httpConn.getHeaderField("Location");
                if (location == null || location.isEmpty()) {
                    return url;
                }
                return doGetFinalURL(new URL(location));
            } finally {
                disconnect(conn);
            }

        } catch (IOException ex) {
            return url;
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
