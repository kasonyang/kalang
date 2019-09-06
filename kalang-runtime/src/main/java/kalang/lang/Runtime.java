package kalang.lang;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Runtime {

    private static Version version;

    public static URL getRuntimeClassPath() {
        return Runtime.class.getProtectionDomain().getCodeSource().getLocation();
    }

    public static synchronized Version getVersion() {
        if (version == null) {
            Properties prop = new Properties();
            InputStream is = Runtime.class.getResourceAsStream("runtime.properties");
            if (is != null) {
                try {
                    prop.load(is);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            String[] versionParts = prop.getProperty("version", "").split("\\.");
            int major = versionParts.length>0 ? Integer.parseInt(versionParts[0]) : 0;
            int minor = versionParts.length>1 ? Integer.parseInt(versionParts[1]) : 0;
            int maintenance = versionParts.length>2 ? Integer.parseInt(versionParts[2]) : 0;
            version = new Version(major,minor,maintenance);
        }
        return version;
    }

    public static class Version {

        private final int major;
        private final int minor;
        private final int maintenance;

        public Version(int major, int minor, int maintenance) {
            this.major = major;
            this.minor = minor;
            this.maintenance = maintenance;
        }

        public int getMajor() {
            return major;
        }

        public int getMinor() {
            return minor;
        }

        public int getMaintenance() {
            return maintenance;
        }

        @Override
        public String toString() {
            return String.format("%d.%d.%d",major,minor,maintenance);
        }
    }

}
