package kalang.dependency;

import org.apache.ivy.util.AbstractMessageLogger;

public class NoMessageLogger extends AbstractMessageLogger {
    @Override
    protected void doProgress() {

    }

    @Override
    protected void doEndProgress(String msg) {

    }

    @Override
    public void log(String msg, int level) {

    }

    @Override
    public void rawlog(String msg, int level) {

    }
}
