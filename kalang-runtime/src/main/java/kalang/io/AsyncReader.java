package kalang.io;

import kalang.lang.Completable;

import java.io.EOFException;
import java.nio.BufferOverflowException;

/**
 * @author KasonYang
 */
public abstract class AsyncReader implements AsyncCloseable {

    interface StopReadPredicate {
        boolean shouldStopRead(int newReceive, int totalReceive);
    }

    private boolean isReading = false;


    /**
     * @param buffer   the buffer for read
     * @return the bytes transferred into buffer
     */
    public Completable<Integer> read(byte[] buffer) {
        return read(buffer, 0, buffer.length);
    }


    /**
     * @param buffer   the buffer for read
     * @param offset   the offset of buffer
     * @param length   then length of buffer
     * @return the bytes transferred into buffer
     */
    public Completable<Integer> read(byte[] buffer, int offset, int length) {
        if (isReading) {
            throw new IllegalArgumentException("previous read is not completed");
        }
        isReading = true;
        return handleRead(buffer, offset, length).onFinally(() -> isReading = false);
    }

    public Completable<Void> readFully(byte[] buffer) {
        return readFully(buffer, 0, buffer.length);
    }

    public Completable<Void> readFully(byte[] buffer, int offset, int length) {
        return read(buffer, offset, length).onCompleted(result -> {
            if (result == length) {
                return Completable.resolve(null);
            } else if (result == -1) {
                throw new EOFException("");
            } else {
                return readFully(buffer, offset + result, length - result);
            }
        });
    }

    public Completable<Integer> readUntil(byte[] buffer, StopReadPredicate predicate) {
        return readUntil(buffer, 0, buffer.length, predicate);
    }

    public Completable<Integer> readUntil(byte[] buffer, int offset, int length, StopReadPredicate predicate) {
        return new Completable<>(new Completable.Executor<Integer>() {
            private int receiveSize = 0;

            @Override
            public void execute(Completable.Resolver<Integer> resolver) {
                read(buffer, offset + receiveSize, length - receiveSize).onCompleted(len -> {
                    if (len == -1) {
                        throw new EOFException();
                    }
                    receiveSize += len;
                    if (predicate.shouldStopRead(len, receiveSize)) {
                        resolver.resolve(receiveSize);
                    } else if (receiveSize == length) {
                        resolver.reject(new BufferOverflowException());
                    } else {
                        this.execute(resolver);
                    }
                }).onFailed(resolver::reject);
            }
        });
    }

    protected abstract  Completable<Integer> handleRead(byte[] buffer, int offset, int length);

}
