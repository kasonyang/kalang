package kalang.compiler.profile;

import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;

public class Span {

    private String name;

    private long startTime;

    private long stopTime;

    private List<Span> childSpans = new LinkedList<>();

    private Span parentSpan;

    public Span(String name,@Nullable Span parentSpan) {
        this.name = name;
        this.parentSpan = parentSpan;
    }

    public String getName() {
        return name;
    }

    public void addChildSpan(Span span) {
        childSpans.add(span);
    }

    public Span[] getChildSpans() {
        return childSpans.toArray(new Span[0]);
    }

    @Nullable
    public Span getParentSpan() {
        return parentSpan;
    }

    public void start() {
        this.startTime = System.nanoTime();
    }

    public void stop() {
        this.stopTime = System.nanoTime();
    }

    public long getElapsedNanoTime() {
        return stopTime - startTime;
    }

}
