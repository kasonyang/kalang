package kalang.io;

import kalang.lang.Completable;

import java.io.IOException;

/**
 * @author KasonYang
 */
public class AsyncChannelReader extends AsyncReader {

    private final AsyncReadChannel readChannel;

    private long position;

    public AsyncChannelReader(AsyncReadChannel readChannel) {
        this.readChannel = readChannel;
    }

    @Override
    protected Completable<Integer> handleRead(byte[] buffer, int offset, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("positive length is required");
        }
        return readChannel.read(position, buffer, offset, length)
                .onCompleted(len -> {
                    position += length;
                    return Completable.resolve(len);
                });
    }


    @Override
    public Completable<Void> close() {
        try {
            readChannel.close();
            return Completable.resolve(null);
        } catch (IOException e) {
            return Completable.reject(e);
        }
    }

}
