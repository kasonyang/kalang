package kalang.coroutine;

import kalang.lang.Generator;

import java.util.Objects;

/**
 * @author KasonYang
 */
public class GeneratorImpl<T> implements Generator<T> {

    private String name;

    private ExecuteContext context;

    private NextExecutor executor;

    private GeneratorImpl(ExecuteContext context, NextExecutor executor, String name) {
        this.executor = executor;
        this.context = context;
        this.name = name;
    }

    public static <D> GeneratorImpl<D> create(ExecuteContext context, NextExecutor executor, String name) {
        return new GeneratorImpl<>(context, executor, name);
    }

    @Override
    public T next() {
        executor.executeNext(context);
        return (T) context.result;
    }

    @Override
    public boolean isDone() {
        return context.isDone;
    }

    @Override
    public String toString() {
        return Objects.toString(name);
    }
}
