package kalang.compiler.profile;

import java.io.OutputStream;
import java.io.PrintStream;

public class SpanFormatter {

    private String indent;

    public void format(Span span, OutputStream os) {
        format(span,new PrintStream(os));
    }

    public void format(Span span,PrintStream ps) {
        indent = "";
        doFormat(span,ps);
    }

    private void doFormat(Span span, PrintStream ps) {
        ps.println(String.format("%s%s[%dms]",indent,span.getName(),span.getElapsedNanoTime()/1000_000));
        Span[] childSpans = span.getChildSpans();
        indent += "  ";
        int printOffset = 0;
        while(printOffset < childSpans.length) {
            printOffset = printSpans(ps, childSpans, printOffset);
        }
        indent = indent.substring(2);
    }

    private int printSpans(PrintStream ps, Span[] spans, int start) {
        Span sp = spans[start];
        if (sp.getChildSpans().length > 0) {
            doFormat(sp, ps);
            return start + 1;
        }
        int offset = start;
        String name = sp.getName();
        long elapsedNanoTime = 0;
        int invokeTimes = 0;
        do {
            elapsedNanoTime += spans[offset].getElapsedNanoTime();
            invokeTimes++;
            offset++;
        } while (
                offset < spans.length
                        && name.equals(spans[offset].getName())
                        && spans[offset].getChildSpans().length == 0
        );
        ps.println(String.format("%s%d %s[%dms]",indent,invokeTimes, name, elapsedNanoTime / 1000_000));
        return offset;
    }

}
