package kalang.compiler.profile;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Span {

    private String name;

    private long startTime;

    private long stopTime;

    private List<Span> childSpans = new LinkedList();

    private Map<String,Invocation> invocations = new HashMap<>();

    private Span parentSpan;

    public Span(String name,@Nullable Span parentSpan) {
        this.name = name;
        this.parentSpan = parentSpan;
    }

    public String getName() {
        return name;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
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

    public Invocation startInvocation(String name) {
        Invocation invocation = invocations.get(name);
        if (invocation==null) {
            invocation = new Invocation(name,this);
            invocations.put(name,invocation);
        }
        invocation.start();
        return invocation;
    }

    public void stopInvocation(Invocation invocation) {
        invocation.end();
    }

    public Invocation[] getInvocations() {
        return invocations.values().toArray(new Invocation[0]);
    }

}
