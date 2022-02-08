package kalang.coroutine;

import kalang.lang.Completable;
import kalang.lang.Deferred;
import kalang.lang.Generator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author KasonYang
 */
public class AsyncRunner<T> {

    private final Queue<Task<T>> readyQueue = new ConcurrentLinkedDeque<>();

    private final List<Task<T>> tasks = new LinkedList<>();

    public void run() {
        while (!tasks.isEmpty()) {
            while (!readyQueue.isEmpty()) {
                Task<T> task = readyQueue.poll();
                Generator<Completable<T>> g = task.generator;
                Deferred<T> d = task.deferred;
                try {
                    Completable<T> result = g.next();
                    result.onDone(() -> {
                        if (g.isDone()) {
                            removeTask(task);
                            if (result.isCompleted()) {
                                d.complete(result.getValue());
                            } else {
                                d.fail(result.getError());
                            }
                        } else {
                            addReady(task);
                        }
                    });
                } catch (Throwable ex) {
                    removeTask(task);
                    d.fail(ex);
                }
            }
            if (!tasks.isEmpty()) {
                synchronized (readyQueue) {
                    try {
                        readyQueue.wait();
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                }
            }
        }

    }

    public Completable<T> submit(Generator<Completable<T>> generator) {
        Deferred<T> deferred = new Deferred<>();
        Task<T> task = new Task<>();
        task.deferred = deferred;
        task.generator = generator;
        addTask(task);
        addReady(task);
        return deferred.completable();
    }

    private void addTask(Task<T> task) {
        synchronized (tasks) {
            tasks.add(task);
        }
    }

    private synchronized void removeTask(Task<T> task) {
        synchronized (tasks) {
            tasks.remove(task);
        }
    }

    private void addReady(Task<T> task) {
        readyQueue.add(task);
        synchronized (readyQueue) {
            readyQueue.notifyAll();
        }
    }

    private static class Task<T> {
        Generator<Completable<T>> generator;
        Deferred<T> deferred;
    }

}
