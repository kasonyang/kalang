package kalang.coroutine.impl;

import kalang.lang.Generator;

/**
 * @author KasonYang
 */
public class GeneratorImpl<T> implements Generator<T> {

    private ExecuteContext context;

    private NextExecutor executor;

    private GeneratorImpl(ExecuteContext context, NextExecutor executor) {
        this.executor = executor;
        this.context = context;
    }

    public static <D> GeneratorImpl<D> create(ExecuteContext context, NextExecutor executor) {
        return new GeneratorImpl<>(context, executor);
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

}
