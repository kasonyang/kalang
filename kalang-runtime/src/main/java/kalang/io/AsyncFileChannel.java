package kalang.io;

import kalang.lang.Completable;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.OpenOption;

/**
 * @author KasonYang
 */
public class AsyncFileChannel implements Closeable, AsyncReadChannel, AsyncWriteChannel {


    private final AsynchronousFileChannel fileChannel;

    public AsyncFileChannel(File file, OpenOption... options) throws IOException {
        fileChannel = AsynchronousFileChannel.open(file.toPath(), options);
    }

    @Override
    public Completable<Integer> read(long position, byte[] buffer, int offset, int length) {
        return new Completable<>(callback -> {
            fileChannel.read(ByteBuffer.wrap(buffer, offset, length), position, null, new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    callback.resolve(result);
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    callback.reject(exc);
                }
            });
        });
    }

    @Override
    public Completable<Integer> write(long position, byte[] buffer, int offset, int length) {
        return new Completable<>(callback -> {
            fileChannel.write(ByteBuffer.wrap(buffer, offset, length), position, null, new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    callback.resolve(result);
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    callback.reject(exc);
                }
            });
        });
    }

    @Override
    public void close() throws IOException {
        fileChannel.close();
    }

}
