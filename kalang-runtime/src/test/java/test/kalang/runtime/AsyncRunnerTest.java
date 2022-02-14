package test.kalang.runtime;

import kalang.lang.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author KasonYang
 */
public class AsyncRunnerTest {

    @Test(timeout = 1000)
    public void test() throws InterruptedException {
        Ref<Boolean> obj = new Ref<>(false);
        AsyncThread.run((asyncThread) -> {
            TestGenerator testGenerator = new TestGenerator();
            asyncThread.submitAsyncTask(testGenerator).onCompleted(value -> {
                Assert.assertEquals(6, testGenerator.i);
                Assert.assertEquals(5, (int) value);
                obj.set(true);
                asyncThread.interrupt();
                return null;
            }, error -> {
                obj.set(false);
                asyncThread.interrupt();
                return null;
            });
        }).join();
        Assert.assertTrue(obj.get());
    }

    private static class TestGenerator implements Generator<Completable<Integer>> {

        public int i = 0;

        @Override
        public Completable<Integer> next() {
            return Completable.resolve(i++);
        }

        @Override
        public boolean isDone() {
            return i == 6;
        }
    }

}
