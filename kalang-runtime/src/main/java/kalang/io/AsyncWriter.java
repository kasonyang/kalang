package kalang.io;

import kalang.lang.Completable;

/**
 * @author KasonYang
 */
public abstract class AsyncWriter implements AsyncCloseable {

    private boolean isWriting;

    /**
     * Write bytes
     *
     * @param buffer the bytes that will be written
     * @return Completable
     */
    public Completable<Integer> write(byte[] buffer) {
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
    public Completable<Integer> write(byte[] buffer, int offset, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("positive length is required");
        }
        if (isWriting) {
            throw new IllegalArgumentException("previous write is not completed");
        }
        isWriting = true;
        return handleWrite(buffer, offset, length).onCompleted(n -> {
            if (n <= 0) {
                throw new IndexOutOfBoundsException(String.valueOf(n));
            }
            return Completable.resolve(n);
        }).onFinally(() -> isWriting = false);
    }

    public Completable<Void> writeFully(byte[] buffer) {
        return writeFully(buffer, 0, buffer.length);
    }

    public Completable<Void> writeFully(byte[] buffer, int offset, int length) {
        return write(buffer, offset, length).onCompleted(result -> {
            if (result == length) {
                return Completable.resolve(null);
            } else {
                return writeFully(buffer, offset + result, length - result);
            }
        });
    }

    protected abstract Completable<Integer> handleWrite(byte[] buffer, int offset, int length);

}
