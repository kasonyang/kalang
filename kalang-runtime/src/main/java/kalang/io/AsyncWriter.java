package kalang.io;

import kalang.lang.Completable;

import java.io.Closeable;

/**
 * @author KasonYang
 */
public interface AsyncWriter extends Closeable {

    /**
     * Write bytes
     *
     * @param buffer the bytes that will be written
     * @return Completable
     */
    default Completable<Integer> write(byte[] buffer) {
        return write(buffer, 0, buffer.length);
    }

    /**
     * Write bytes
     *
     * @param buffer the bytes that will be written
     * @param offset the offset of buffer
     * @param length the length of buffer
     * @return Completable
     */
    Completable<Integer> write(byte[] buffer, int offset, int length);

    default Completable<Void> writeFully(byte[] buffer) {
        return writeFully(buffer, 0, buffer.length);
    }

    default Completable<Void> writeFully(byte[] buffer, int offset, int length) {
        return write(buffer, offset, length).onCompleted(result -> {
            if (result == length) {
                return Completable.resolve(null);
            } else {
                return writeFully(buffer, offset + result, length - result);
            }
        });
    }

}
