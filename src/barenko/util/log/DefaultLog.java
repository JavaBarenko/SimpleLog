package barenko.util.log;

import java.util.List;
import barenko.util.log.appender.Appender;
import barenko.util.log.appender.exception.AppenderException;

/**
 * Uma implementação padrão do log. <br>
 * Útil para a maioria das aplicações.
 * 
 * @author Rafael Caetano Pinto
 */
public class DefaultLog implements Log {

    private final LogConfig config;

    public DefaultLog() {
	this.config = DefaultLogConfig.getDefault();
    }

    public DefaultLog(final LogConfig config) {
	this.config = config;
    }

    public void close() throws AppenderException {
	for (final Appender appender : this.config.getCurrentAppenders()) {
	    appender.close();
	}
    }

    public void log(final LogLevel level, final Throwable throwable, final String message, final Object... objects) {
	if (isLevelEnabled(level)) {
	    final LogEvent logEvent = new LogEvent(level, throwable, message == null ? null : String.format(message, objects));
	    for (final Appender appender : this.config.getCurrentAppenders()) {
		appender.write(logEvent);
	    }
	}
    }

    public void debug(final Throwable throwable, final String message, final Object... objects) {
	log(LogLevel.DEBUG, throwable, message, objects);
    }

    public void debug(final String message, final Object... objects) {
	log(LogLevel.DEBUG, null, message, objects);
    }

    public void warning(final Throwable throwable, final String message, final Object... objects) {
	log(LogLevel.WARNING, throwable, message, objects);
    }

    public void warning(final String message, final Object... objects) {
	log(LogLevel.WARNING, null, message, objects);
    }

    public void error(final Throwable throwable, final String message, final Object... objects) {
	log(LogLevel.ERROR, throwable, message, objects);
    }

    public void error(final String message, final Object... objects) {
	log(LogLevel.ERROR, null, message, objects);
    }

    public void fatal(final Throwable throwable, final String message, final Object... objects) {
	log(LogLevel.FATAL, throwable, message, objects);
    }

    public void fatal(final String message, final Object... objects) {
	log(LogLevel.FATAL, null, message, objects);
    }

    public LogLevel getLevel() {
	return this.config.getLevel();
    }

    public void info(final Throwable throwable, final String message, final Object... objects) {
	log(LogLevel.INFO, throwable, message, objects);
    }

    public void info(final String message, final Object... objects) {
	log(LogLevel.INFO, null, message, objects);
    }

    public boolean isDebugEnabled() {
	return isLevelEnabled(LogLevel.DEBUG);
    }

    public boolean isErrorEnabled() {
	return isLevelEnabled(LogLevel.ERROR);
    }

    public boolean isWarningEnabled() {
	return isLevelEnabled(LogLevel.WARNING);
    }

    public boolean isFatalEnabled() {
	return isLevelEnabled(LogLevel.FATAL);
    }

    public boolean isInfoEnabled() {
	return isLevelEnabled(LogLevel.INFO);
    }

    public boolean isTraceEnabled() {
	return isLevelEnabled(LogLevel.TRACE);
    }

    private boolean isLevelEnabled(final LogLevel level) {
	return this.config.getLevel().isLoggable(level);
    }

    public void trace(final Throwable throwable, final String message, final Object... objects) {
	log(LogLevel.TRACE, throwable, message, objects);
    }

    public void trace(final String message, final Object... objects) {
	log(LogLevel.TRACE, null, message, objects);
    }

    public void setLevel(final LogLevel level) {
	this.config.setLevel(level);
    }

    public List<Appender> getCurrentAppenders() {
	return this.config.getCurrentAppenders();
    }

    public void debug(final Throwable throwable) {
	debug(throwable, null);
    }

    public void error(final Throwable throwable) {
	error(throwable, null);
    }

    public void fatal(final Throwable throwable) {
	fatal(throwable, null);
    }

    public void info(final Throwable throwable) {
	info(throwable, null);
    }

    public void trace(final Throwable throwable) {
	trace(throwable, null);
    }

    public void warning(final Throwable throwable) {
	warning(throwable, null);
    }
}
