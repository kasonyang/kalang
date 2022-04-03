package test.kalang.runtime;

import kalang.mixin.DigestMixin;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author KasonYang
 */
public class DigesterTest {

    @Test
    public void testDigest() {
        String input = "test";
        Assert.assertEquals("098f6bcd4621d373cade4e832627b4f6", digestStr(input, "md5"));
        Assert.assertEquals("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", digestStr(input, "sha-1"));
        Assert.assertEquals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", digestStr(input, "sha-256"));
        Assert.assertEquals("ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff", digestStr(input, "sha-512"));
    }

    @Test
    public void testFileDigest() throws IOException {
        Assert.assertEquals(DigestUtils.md5Hex(createFileInput()), DigestMixin.digestBy(createFileInput(), "md5").asHex());
        Assert.assertEquals(DigestUtils.sha1Hex(createFileInput()), DigestMixin.digestBy(createFileInput(), "sha-1").asHex());
        Assert.assertEquals(DigestUtils.sha256Hex(createFileInput()), DigestMixin.digestBy(createFileInput(), "sha-256").asHex());
        Assert.assertEquals(DigestUtils.sha512Hex(createFileInput()), DigestMixin.digestBy(createFileInput(), "sha-512").asHex());

    }

    private static InputStream createFileInput() throws FileNotFoundException {
        return new FileInputStream("../gradle/wrapper/gradle-wrapper.jar");
    }

    private static String digestStr(String input, String algorithm) {
        return DigestMixin.digestBy(input, algorithm).asHex();
    }

}
