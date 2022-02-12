package kalang.io;

import kalang.lang.Completable;
import kalang.lang.Deferred;

import java.io.Closeable;
import java.io.EOFException;

/**
 * @author KasonYang
 */
public interface AsyncReader extends Closeable {


    /**
     * @param buffer   the buffer for read
     * @return the bytes transferred into buffer
     */
    default Completable<Integer> read(byte[] buffer) {
        return read(buffer, 0, buffer.length);
    }


    /**
     * @param buffer   the buffer for read
     * @param offset   the offset of buffer
     * @param length   then length of buffer
     * @return the bytes transferred into buffer
     */
    Completable<Integer> read(byte[] buffer, int offset, int length);

    default Completable<Void> readFully(byte[] buffer) {
        return readFully(buffer, 0, buffer.length);
    }

    default Completable<Void> readFully(byte[] buffer, int offset, int length) {
        Deferred<Void> def = new Deferred<>();
        Completable<Integer> readResult = read(buffer, offset, length);
        readResult.onCompleted(result -> {
            if (result == length) {
                def.complete(null);
            } else if (result == -1) {
                def.fail(new EOFException(""));
            } else {
                def.delegate(readFully(buffer, offset + result, length - result));
            }
        });
        readResult.onFailed(def::fail);
        return def.completable();
    }

}
