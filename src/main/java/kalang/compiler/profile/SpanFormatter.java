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
        ps.println(String.format("%s%s[%dms]",indent,span.getName(),span.getStopTime()-span.getStartTime()));
        Span[] childSpans = span.getChildSpans();
        indent += "  ";
        for(Invocation invocation:span.getInvocations()) {
            ps.println(String.format("%s%d %s[%dms]",indent,invocation.getCount(),invocation.getName(),invocation.getTotalTime()));
        }
        for(Span c:childSpans) {
            doFormat(c,ps);
        }
        indent = indent.substring(2);
    }

}
