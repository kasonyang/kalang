package kalang.mixin;

import kalang.annotation.MixinMethod;
import kalang.io.*;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;
import java.util.function.Consumer;

public class IOMixin {

    @MixinMethod
    public static byte[] readToBytes(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        readTo(is, bos);
        return bos.toByteArray();
    }

    @MixinMethod
    public static byte[] readToBytes(File file) throws IOException {
        long fileLen = file.length();
        if (fileLen > Integer.MAX_VALUE) {
            throw new OutOfMemoryError("file is too large");
        }
        try (InputStream isr = new FileInputStream(file)) {
            int len = (int) fileLen;
            byte[] data = new byte[len];
            isr.read(data);
            return data;
        }
    }

    @MixinMethod
    public static String readToString(InputStream is, String charset) throws IOException {
        return new String(readToBytes(is), charset);
    }

    @MixinMethod
    public static String readToString(File file, String charset) throws IOException {
        return new String(readToBytes(file), charset);
    }

    @MixinMethod
    public static String readToString(File file) throws IOException {
        return readToString(file, Charset.defaultCharset().name());
    }

    @MixinMethod
    public static void write(File file, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
        }
    }

    @MixinMethod
    public static void append(File file, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(data);
        }
    }

    @MixinMethod
    public static void readTo(InputStream is, OutputStream os) throws IOException {
        byte[] bs = new byte[4096];
        int len;
        while ((len = is.read(bs)) > 0) {
            os.write(bs, 0, len);
        }
    }

    @MixinMethod
    public static void readTo(InputStream is, File destFile, boolean append) throws IOException {
        try (FileOutputStream os = new FileOutputStream(destFile, append)) {
            readTo(is, os);
        }
    }

    @MixinMethod
    public static void readTo(InputStream is, File destFile) throws IOException {
        readTo(is, destFile,false);
    }

    @MixinMethod
    public static void writeFrom(OutputStream os, InputStream is) throws IOException {
        readTo(is, os);
    }

    @MixinMethod
    public static void writeFrom(OutputStream os, File file) throws IOException {
        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(file))) {
            writeFrom(os, is);
        }
    }

    @MixinMethod
    public static AsyncReadChannel newAsyncReadChannel(File file) throws IOException {
        return new AsyncFileChannel(file, StandardOpenOption.READ);
    }

    @MixinMethod
    public static AsyncReader newAsyncReader(File file) throws IOException {
        return new AsyncChannelReader(newAsyncReadChannel(file));
    }

    @MixinMethod
    public static AsyncWriteChannel newAsyncWriteChannel(File file, boolean append) throws IOException {
        if (append) {
            return new AsyncFileChannel(file, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        } else {
            return new AsyncFileChannel(file, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }
    }

    @MixinMethod
    public static AsyncWriter newAsyncWriter(File file, boolean append) throws IOException {
        return new AsyncChannelWriter(newAsyncWriteChannel(file, append));
    }

    @MixinMethod
    public static void withLock(File file, Consumer<FileLock> fileLockConsumer) throws IOException {
        doWithLock(file, false, true, fileLockConsumer);
    }

    @MixinMethod
    public static boolean tryWithLock(File file, Consumer<FileLock> fileLockConsumer) throws IOException {
        return doWithLock(file, false, false, fileLockConsumer);
    }

    @MixinMethod
    public static void withSharedLock(File file, Consumer<FileLock> fileLockConsumer) throws IOException {
        doWithLock(file, true, true, fileLockConsumer);
    }

    @MixinMethod
    public static boolean tryWithSharedLock(File file, Consumer<FileLock> fileLockConsumer) throws IOException {
        return doWithLock(file, true, false, fileLockConsumer);
    }

    private static boolean doWithLock(File file,boolean shared, boolean wait,Consumer<FileLock> fileLockConsumer) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            try (FileChannel chn = fos.getChannel()) {
                FileLock lock;
                if (wait) {
                    lock = chn.lock(0, Long.MAX_VALUE, shared);
                } else {
                    lock = chn.tryLock(0, Long.MAX_VALUE, shared);
                }
                if (lock != null) {
                    fileLockConsumer.accept(lock);
                    lock.release();
                    return true;
                }
                return false;
            }
        }
    }
    
}
