package kalang.io;

import kalang.lang.Completable;

import java.io.IOException;

/**
 * @author KasonYang
 */
public class AsyncChannelWriter implements AsyncWriter {

    private final AsyncWriteChannel writeChannel;

    private long position;

    private boolean isWriting;

    public AsyncChannelWriter(AsyncWriteChannel writeChannel) {
        this.writeChannel = writeChannel;
    }

    @Override
    public Completable<Integer> write(byte[] buffer, int offset, int length) {
        if (isWriting) {
            throw new IllegalStateException("previous write is not completed");
        }
        isWriting = true;
        return writeChannel.write(position, buffer, offset, length)
                .onCompleted(len -> {
                    position += len;
                    return Completable.resolve(len);
                })
                .onFinally(() -> isWriting = false);
    }

    @Override
    public void close() throws IOException {
        writeChannel.close();
    }

}
