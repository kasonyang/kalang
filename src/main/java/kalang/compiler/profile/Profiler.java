package kalang.compiler.profile;

import javax.annotation.Nullable;

public class Profiler {

    private static Profiler instance = new Profiler();

    private Span rootSpan;

    private Span currentSpan;

    public static Profiler getInstance() {
        return instance;
    }

    public void startProfile() {
        rootSpan = new Span("root",null);
        rootSpan.setStartTime(System.currentTimeMillis());
        currentSpan = rootSpan;
    }

    public void stopProfile() {
        if (rootSpan!=null) endSpan(rootSpan);
    }

    public Span beginSpan(String name) {
        currentSpan = new Span(name,currentSpan);
        currentSpan.setStartTime(System.currentTimeMillis());
        return currentSpan;
    }

    public void endSpan(Span span) {
        span.setStopTime(System.currentTimeMillis());
        currentSpan = span.getParentSpan();
        if (currentSpan!=null) {
            currentSpan.addChildSpan(span);
        }
    }

    @Nullable
    public Invocation beginInvocation(String name) {
        if (currentSpan!=null) {
            return currentSpan.startInvocation(name);
        }
        return null;
    }

    public void endInvocation(@Nullable Invocation invocation) {
        if (currentSpan!=null && invocation!=null) {
            currentSpan.stopInvocation(invocation);
        }
    }

    @Nullable
    public Span getRootSpan() {
        return rootSpan;
    }

}
