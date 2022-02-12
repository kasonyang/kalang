package kalang.io;

import kalang.lang.Completable;
import kalang.lang.Deferred;

import java.io.Closeable;

/**
 * @author KasonYang
 */
public interface AsyncWriteChannel extends Closeable {

    /**
     * Write bytes
     *
     * @param position the position to begin write
     * @param buffer   the bytes that will be written
     * @return Completable
     */
    default Completable<Integer> write(long position, byte[] buffer) {
        return write(position, buffer, 0, buffer.length);
    }

    /**
     * Write bytes
     *
     * @param position the position to begin write
     * @param buffer   the bytes that will be written
     * @param offset   the offset of buffer
     * @param length   the length of buffer
     * @return Completable
     */
    Completable<Integer> write(long position, byte[] buffer, int offset, int length);

    default Completable<Void> writeFully(int position, byte[] buffer) {
        return writeFully(position, buffer, 0, buffer.length);
    }

    default Completable<Void> writeFully(long position, byte[] buffer, int offset, int length) {
        Deferred<Void> def = new Deferred<>();
        Completable<Integer> writeResult = write(position, buffer, offset, length);
        writeResult.onCompleted(result -> {
            if (result == length) {
                def.complete(null);
            } else {
                def.delegate(writeFully(position + result, buffer, offset + result, length - result));
            }
        });
        writeResult.onFailed(def::fail);
        return def.completable();
    }

}
