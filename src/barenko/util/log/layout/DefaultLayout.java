package barenko.util.log.layout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import barenko.util.log.LogEvent;
import barenko.util.log.LogHelper;

public class DefaultLayout implements Layout {
    private String header = "Logged At               [Level  ] [Thread Name                        ] Log Message";
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DefaultLayout() {}

    public String format(final LogEvent logEvent) {
	final String formatDate = formatDate(logEvent.getThrowabledAt());
	final String errorLevel = LogHelper.rightPad(logEvent.getLevel().name(), " ", 7).substring(0, 7);
	final String threadName = LogHelper.rightPad(logEvent.getThreadName(), " ", 35).substring(0, 35);
	final String message = logEvent.getMessage();
	final String throwMessage = getThrowMessage(logEvent);

	return String.format("%s [%s] [%s] %s%s%s", formatDate, errorLevel, threadName, message, LogHelper.NEW_LINE, throwMessage);
    }

    private String formatDate(final Date date) {
	return this.dateFormat.format(date);
    }

    private String getThrowMessage(final LogEvent logEvent) {
	final Throwable throwable = logEvent.getThrowable();

	if (throwable == null) return "";

	final int sum = formatDate(logEvent.getThrowabledAt()).length() + 9;
	String space = LogHelper.leftPad(" ", " ", sum);

	final StringBuilder sb = new StringBuilder();

	final String throwableClassName = throwable.getClass().getName();
	sb.append(space).append(throwableClassName);
	sb.append(": ");
	sb.append(throwable.getMessage());

	space = LogHelper.leftPad(" ", " ", sum + 2);
	for (final StackTraceElement ste : logEvent.getStackTrace()) {
	    sb.append(LogHelper.NEW_LINE).append(space).append(ste.toString());
	}
	sb.append(LogHelper.NEW_LINE);
	return sb.toString();
    }

    public String getHeader() {
	return this.header;
    }

    public void setHeader(final String header) {
	this.header = header;
    }

}
