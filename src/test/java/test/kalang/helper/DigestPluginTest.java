package test.kalang.helper;

import kalang.mixin.DigestMixin;
import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class DigestPluginTest {

    @Test
    public void testDigest() throws NoSuchAlgorithmException {
        Assert.assertEquals("098f6bcd4621d373cade4e832627b4f6", DigestMixin.md5Hex("test"));
        Assert.assertEquals("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", DigestMixin.sha1Hex("test"));
        Assert.assertEquals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", DigestMixin.sha256Hex("test"));
        Assert.assertEquals("ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff", DigestMixin.sha512Hex("test"));
    }

}
