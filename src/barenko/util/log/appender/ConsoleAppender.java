package barenko.util.log.appender;

import barenko.util.log.LogEvent;
import barenko.util.log.layout.Layout;

public class ConsoleAppender implements Appender {

    private final Layout layout;

    public ConsoleAppender(final Layout layout) {
	this.layout = layout;
	if (layout.getHeader() != null) System.out.println(this.layout.getHeader());
    }

    public void close() {}

    public void write(final LogEvent logEvent) {
	System.out.print(this.layout.format(logEvent));
    }

    public Layout getLayout() {
	return this.layout;
    }
}
