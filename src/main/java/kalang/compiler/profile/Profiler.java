package kalang.compiler.profile;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class Profiler {

    private static Profiler instance = new Profiler();

    private Span rootSpan;

    private Span currentSpan;

    public static Profiler getInstance() {
        return instance;
    }

    public void startProfile() {
        rootSpan = new Span("root",null);
        rootSpan.start();
        currentSpan = rootSpan;
    }

    public void stopProfile() {
        if (rootSpan!=null) endSpan(rootSpan);
    }

    public Span beginSpan(String name) {
        currentSpan = new Span(name,currentSpan);
        currentSpan.start();
        return currentSpan;
    }

    public void endSpan(Span span) {
        span.stop();
        currentSpan = span.getParentSpan();
        if (currentSpan!=null) {
            currentSpan.addChildSpan(span);
        }
    }

    public void spanRun(String name, Runnable runnable) {
        Span sp = beginSpan(name);
        try {
            runnable.run();
        } finally {
            endSpan(sp);
        }
    }

    public <T> T spanCall(String name, Supplier<T> callback) {
        Span sp = beginSpan(name);
        try {
            return callback.get();
        } finally {
            endSpan(sp);
        }
    }

    @Nullable
    public Span getRootSpan() {
        return rootSpan;
    }

}
