package kalang.compiler.profile;

public class Invocation {

    private final String name;

    private long totalTime;

    private long startTime;

    private int count;

    private final Span span;

    public Invocation(String name,Span span) {
        this.name = name;
        this.span = span;
    }

    public String getName() {
        return name;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        if (startTime<=0) {
            throw new IllegalStateException("invocation is not started");
        }
        count ++;
        totalTime += (System.currentTimeMillis()-startTime);
        startTime = 0;
    }

    public Span getSpan() {
        return span;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public int getCount() {
        return count;
    }

}
