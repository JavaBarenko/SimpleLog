package barenko.util.log.layout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import barenko.util.log.LogEvent;
import barenko.util.log.LogHelper;

public class DateLayout implements Layout {
    private String header = "[Logged At              ] Level  : Log Message";
    private final DateFormat dateFormat;

    public DateLayout() {
	this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }

    public DateLayout(final DateFormat dateFormat) {
	this.dateFormat = dateFormat;
    }

    public String format(final LogEvent logEvent) {

	final String formatDate = formatDate(logEvent.getThrowabledAt());
	final String message = logEvent.getMessage();
	final String throwMessage = getThrowMessage(logEvent);

	return String.format("[%s] %s: %s%s%s", formatDate, LogHelper.rightPad(logEvent.getLevel().name(), " ", 7), message, LogHelper.NEW_LINE, throwMessage);
    }

    private String getThrowMessage(final LogEvent logEvent) {
	final Throwable throwable = logEvent.getThrowable();

	if (throwable == null) return "";

	final int sum = formatDate(logEvent.getThrowabledAt()).length() + 12;
	String space = LogHelper.leftPad(" ", " ", sum);

	final StringBuilder sb = new StringBuilder();

	final String throwableClassName = throwable.getClass().getName();
	sb.append(space).append(throwableClassName);
	sb.append(": ");
	sb.append(throwable.getMessage());

	space = LogHelper.leftPad(" ", " ", sum + throwableClassName.length() + 2);
	for (final StackTraceElement ste : logEvent.getStackTrace()) {
	    sb.append(LogHelper.NEW_LINE).append(space).append(ste.toString());
	}
	sb.append(LogHelper.NEW_LINE);
	return sb.toString();
    }

    private String formatDate(final Date date) {
	return this.dateFormat.format(date);
    }

    public String getHeader() {
	return this.header;
    }

    public void setHeader(final String header) {
	this.header = header;
    }

}
