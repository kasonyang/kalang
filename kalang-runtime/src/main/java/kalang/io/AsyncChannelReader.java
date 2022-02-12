package kalang.io;

import kalang.lang.Completable;
import kalang.lang.Deferred;

import java.io.IOException;

/**
 * @author KasonYang
 */
public class AsyncChannelReader implements AsyncReader {

    private final AsyncReadChannel readChannel;

    private long position;

    private Deferred<Integer> currentDef;

    public AsyncChannelReader(AsyncReadChannel readChannel) {
        this.readChannel = readChannel;
    }

    @Override
    public Completable<Integer> read(byte[] buffer, int offset, int length) {
        if (currentDef != null) {
            throw new IllegalStateException("previous read is not completed");
        }
        Deferred<Integer> def = currentDef = new Deferred<>();
        Completable<Integer> result = readChannel.read(position, buffer, offset, length);
        result.onCompleted(len -> {
            position += len;
            def.complete(len);
        });
        result.onFailed(def::fail);
        result.onDone(() -> currentDef = null);
        return def.completable();
    }

    @Override
    public void close() throws IOException {
        readChannel.close();
    }

}
