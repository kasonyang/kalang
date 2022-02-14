package kalang.coroutine;

import kalang.annotation.Nullable;
import kalang.lang.*;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author KasonYang
 */
public class AsyncRunner<T> implements TaskExecutor {

    private final Queue<Task<T>> queue = new ConcurrentLinkedDeque<>();

    public void run() {
        for (;;) {
            while (!queue.isEmpty()) {
                Task<T> task = queue.poll();
                if (task.runnable != null) {
                    processRunnable(task);
                } else {
                    processAsyncTask(task);
                }
            }
            synchronized (queue) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public Completable<T> submitAsyncTask(Generator<Completable<T>> generator) {
        return new Completable<>(this, resolver -> {
            Task<T> task = new Task<>();
            task.resolver = resolver;
            task.generator = generator;
            appendQueue(task);
        });
    }

    @Override
    public void submitTask(Runnable runnable) {
        Task<T> task = new Task<>();
        task.runnable = runnable;
        appendQueue(task);
    }

    private void processAsyncTask(Task<T> task) {
        Generator<Completable<T>> g = task.generator;
        Completable.Resolver<T> resolver = task.resolver;
        try {
            g.next().onSettled((result) -> {
                if (g.isDone()) {
                    if (result.isCompleted()) {
                        resolver.resolve(result.getValue());
                    } else {
                        resolver.reject(result.getError());
                    }
                } else {
                    appendQueue(task);
                }
                return null;
            });
        } catch (Throwable ex) {
            resolver.reject(ex);
        }
    }

    private void processRunnable(Task<T> task) {
        try {
            task.runnable.run();
        } catch (Throwable ex) {
            System.err.print("Uncaught Exception ");
            ex.printStackTrace();
        }
    }

    private void appendQueue(Task<T> task) {
        queue.add(task);
        synchronized (queue) {
            queue.notifyAll();
        }
    }

    private static class Task<T> {
        @Nullable Runnable runnable;
        @Nullable Generator<Completable<T>> generator;
        @Nullable
        Completable.Resolver<T> resolver;
    }

}
