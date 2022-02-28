package kalang.io;

import kalang.lang.Completable;

import java.io.IOException;

/**
 * @author KasonYang
 */
public class AsyncChannelWriter extends AsyncWriter {

    private final AsyncWriteChannel writeChannel;

    private long position;

    public AsyncChannelWriter(AsyncWriteChannel writeChannel) {
        this.writeChannel = writeChannel;
    }

    @Override
    protected Completable<Integer> handleWrite(byte[] buffer, int offset, int length) {
        return writeChannel.write(position, buffer, offset, length)
                .onCompleted(len -> {
                    position += len;
                    return Completable.resolve(len);
                });
    }

    @Override
    public Completable<Void> close() {
        try {
            writeChannel.close();
            return Completable.resolve(null);
        } catch (IOException e) {
            return Completable.reject(e);
        }
    }
}
