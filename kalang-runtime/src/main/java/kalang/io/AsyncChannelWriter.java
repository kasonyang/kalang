package kalang.io;

import kalang.lang.Completable;
import kalang.lang.Deferred;

import java.io.IOException;

/**
 * @author KasonYang
 */
public class AsyncChannelWriter implements AsyncWriter {

    private final AsyncWriteChannel writeChannel;

    private long position;

    private Deferred<Integer> currentDef;

    public AsyncChannelWriter(AsyncWriteChannel writeChannel) {
        this.writeChannel = writeChannel;
    }

    @Override
    public Completable<Integer> write(byte[] buffer, int offset, int length) {
        if (currentDef != null) {
            throw new IllegalStateException("previous write is not completed");
        }
        Deferred<Integer> def = currentDef = new Deferred<>();
        Completable<Integer> result = writeChannel.write(position, buffer, offset, length);
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
        writeChannel.close();
    }

}
