package barenko.util.log.layout;

import barenko.util.log.LogEvent;

public interface Layout {
    String getHeader();

    void setHeader(String header);

    String format(LogEvent logEvent);
}
