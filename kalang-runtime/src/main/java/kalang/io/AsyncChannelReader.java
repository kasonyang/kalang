package kalang.io;

import kalang.lang.Completable;

import java.io.IOException;

/**
 * @author KasonYang
 */
public class AsyncChannelReader implements AsyncReader {

    private final AsyncReadChannel readChannel;

    private long position;

    private boolean isReading;

    public AsyncChannelReader(AsyncReadChannel readChannel) {
        this.readChannel = readChannel;
    }

    @Override
    public Completable<Integer> read(byte[] buffer, int offset, int length) {
        if (isReading) {
            throw new IllegalStateException("previous read is not completed");
        }
        isReading = true;
        return readChannel.read(position, buffer, offset, length)
                .onCompleted(len -> {
                    position += length;
                    return Completable.resolve(len);
                }).onFinally(() -> isReading = false);
    }

    @Override
    public void close() throws IOException {
        readChannel.close();
    }

}
