package test.kalang.runtime;

import kalang.coroutine.AsyncRunner;
import kalang.lang.Completable;
import kalang.lang.Deferred;
import kalang.lang.Generator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author KasonYang
 */
public class AsyncRunnerTest {

    @Test(timeout = 1000)
    public void test() throws InterruptedException {
        AsyncRunner<Integer> runner = new AsyncRunner<>();
        TestGenerator testGenerator = new TestGenerator();
        Completable<Integer> result = runner.submit(testGenerator);
        result.onCompleted(value -> {
            Assert.assertEquals(6, testGenerator.i);
            Assert.assertEquals(5, (int) value);
        });
        result.onFailed(e -> Assert.fail());
        runner.run();
    }

    private static class TestGenerator implements Generator<Completable<Integer>> {

        public int i = 0;

        @Override
        public Completable<Integer> next() {
            Deferred<Integer> d = new Deferred<>();
            d.complete(i++);
            return d.completable();
        }

        @Override
        public boolean isDone() {
            return i == 6;
        }
    }

}
