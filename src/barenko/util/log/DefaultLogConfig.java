package barenko.util.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import barenko.util.log.appender.Appender;
import barenko.util.log.appender.ConsoleAppender;
import barenko.util.log.appender.exception.AppenderException;
import barenko.util.log.layout.DateLayout;

/**
 * Agregador de configuração do {@link DefaultLog}.
 * 
 * @author Rafael Caetano Pinto
 */
public class DefaultLogConfig implements LogConfig {

    private static final LogLevel DEFAULT_LOG_LEVEL = LogLevel.INFO;

    private static LogConfig defaultLogConfig = new DefaultLogConfig(DEFAULT_LOG_LEVEL, new ConsoleAppender(new DateLayout()));

    public static LogConfig getDefault() {
	return defaultLogConfig;
    }

    public static void setDefaultLogConfig(final LogLevel level, final Appender... defaultAppenders) {
	defaultLogConfig = new DefaultLogConfig(level, defaultAppenders);
    }

    private final Map<LogLevel, List<Appender>> appenders = new HashMap<LogLevel, List<Appender>>();
    private final List<Appender> defaultAppenders = new ArrayList<Appender>();

    private LogLevel level;

    public DefaultLogConfig() {}

    public DefaultLogConfig(final List<Appender> defaultAppenders) {
	this(DEFAULT_LOG_LEVEL, defaultAppenders);
    }

    public DefaultLogConfig(final Appender... defaultAppenders) {
	this(DEFAULT_LOG_LEVEL, new ArrayList<Appender>(Arrays.asList(defaultAppenders)));
    }

    public DefaultLogConfig(final LogLevel level, final Appender... defaultAppenders) {
	this(level, new ArrayList<Appender>(Arrays.asList(defaultAppenders)));
    }

    public DefaultLogConfig(final LogLevel level, final List<Appender> defaultAppenders) {
	this.level = level;
	this.defaultAppenders.addAll(defaultAppenders);
    }

    /*
     * (non-Javadoc)
     * @see cas.log.LogConfig#setAppenders(cas.log.appender.Appender)
     */
    public void setAppenders(final LogLevel level, final Appender... levelAppenders) throws AppenderException {
	for (final Appender appender : this.appenders.get(level)) {
	    appender.close();
	}
	this.appenders.put(level, new ArrayList<Appender>(Arrays.asList(levelAppenders)));
    }

    /*
     * (non-Javadoc)
     * @see cas.log.LogConfig#setLevel(cas.log.LogLevel)
     */
    public void setLevel(final LogLevel level) {
	this.level = level;
    }

    /*
     * (non-Javadoc)
     * @see cas.log.LogConfig#getLevel()
     */
    public LogLevel getLevel() {
	return this.level;
    }

    /*
     * (non-Javadoc)
     * @see cas.log.LogConfig#getAppenders()
     */
    public final List<Appender> getCurrentAppenders() {
	return Collections.unmodifiableList(getAppenders(this.level));
    }

    public List<Appender> getAppenders(final LogLevel level) {
	final List<Appender> appenders = this.appenders.get(level);
	return appenders == null ? this.defaultAppenders : appenders;
    }

    /*
     * (non-Javadoc)
     * @see cas.log.LogConfig#setAppenders(java.util.List)
     */
    public final void setAppenders(final LogLevel level, final List<Appender> appenders) throws AppenderException {
	for (final Appender appender : this.appenders.get(level)) {
	    appender.close();
	}
	this.appenders.put(level, appenders);
    }

    /*
     * (non-Javadoc)
     * @see cas.log.LogConfig#setHeader(java.lang.String)
     */
    public final void setHeader(final String header) {
	for (final List<Appender> appenderList : this.appenders.values()) {
	    for (final Appender appender : appenderList) {
		appender.getLayout().setHeader(header);
	    }
	}
	for (final Appender appender : this.defaultAppenders) {
	    appender.getLayout().setHeader(header);
	}
    }
}
