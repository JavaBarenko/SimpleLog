package barenko.util.log.appender;

import barenko.util.log.LogEvent;
import barenko.util.log.appender.exception.AppenderException;
import barenko.util.log.layout.Layout;

public interface Appender {
    void close() throws AppenderException;

    void write(LogEvent logEvent);

    Layout getLayout();
}
