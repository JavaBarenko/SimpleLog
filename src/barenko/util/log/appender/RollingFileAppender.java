package barenko.util.log.appender;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import barenko.util.log.LogEvent;
import barenko.util.log.appender.exception.AppenderException;
import barenko.util.log.appender.exception.FileAppenderException;
import barenko.util.log.layout.Layout;

public class RollingFileAppender implements FileAppender {

    private File logFile;
    private final Layout layout;
    private final FileAppenderConfig config;
    String filenameDate = null;
    PrintWriter output = null;
    private final FilenameFilter filter;
    private final boolean autoOverride;

    public RollingFileAppender(final Layout layout, final FileAppenderConfig config) throws FileAppenderException {
	this(layout, config, false);
    }

    public RollingFileAppender(final Layout layout, final FileAppenderConfig config, final boolean autoOverride) throws FileAppenderException {
	this.layout = layout;
	this.config = config;
	this.autoOverride = autoOverride;
	validLogPath();

	this.filter = new FilenameFilter() {
	    public boolean accept(@SuppressWarnings("unused") final File dir, final String name) {
		if (name.matches(String.format("%s.*?%s", config.getPrefix(), config.getSuffix()))) return true;
		return false;
	    }
	};

	prepareFileLog(createFileLog());
    }

    public File getFile() {
	return this.logFile;
    }

    private void validLogPath() throws FileAppenderException {
	final File path = this.config.getLogPath();
	if (path == null) throw new FileAppenderException("Configuration Log path not found");
	if (this.config.isAutoCreateFile()) path.mkdirs();
	else if (!path.exists()) throw new FileAppenderException("The \"%s\" folder not exists", path.getAbsolutePath());

	if (!path.isDirectory()) throw new FileAppenderException("The \"%s\" must be a folder", path.getAbsolutePath());
	if (!path.canRead()) throw new FileAppenderException("The \"%s\" folder cannot be read", path.getAbsolutePath());
	if (!path.canWrite()) throw new FileAppenderException("The \"%s\" folder cannot be write", path.getAbsolutePath());
    }

    public void close() throws AppenderException {
	if (this.output != null) this.output.close();
    }

    private void prepareFileLog(final File newLogFile) {

	PrintWriter newPrintWriter = null;
	try {
	    newPrintWriter = new PrintWriter(new FileOutputStream(newLogFile, !this.autoOverride));

	    this.logFile = newLogFile;
	    if (this.output != null) this.output.close();
	    this.output = newPrintWriter;
	    if (this.layout.getHeader() != null) this.output.println(this.layout.getHeader());
	} catch (final IOException e) {
	    e.printStackTrace();
	}

	try {
	    cleanExcedentLogs();
	} catch (final ParseException e) {
	    e.printStackTrace();
	}
    }

    private File createFileLog() {
	this.filenameDate = this.config.getFilenameDateFormat().format(new Date());

	final String filename = String.format("%s%s%s", this.config.getPrefix(), this.filenameDate, this.config.getSuffix());
	File newLogFile = new File(this.config.getLogPath(), filename);

	if (newLogFile.exists()) {
	    int lastIndex = 1;

	    for (final File file : this.config.getLogPath().listFiles(this.filter)) {
		try {
		    final int index = Integer.parseInt(file.getName().replaceFirst(this.config.getPrefix() + ".*?_(\\d+)" + this.config.getSuffix() + "$", "$1"));
		    lastIndex = lastIndex < index ? index : lastIndex;
		} catch (final NumberFormatException ignore) {}
	    }

	    newLogFile = new File(this.config.getLogPath(), newLogFile.getName().replaceFirst("(.*?)(" + this.config.getSuffix() + ")$", "$1_" + (lastIndex + 1) + "$2"));
	}
	return newLogFile;
    }

    private void cleanExcedentLogs() throws ParseException {
	final String pattern = this.config.getPrefix() + "(.*?)" + this.config.getSuffix();
	final Map<Long, File> candidates = new HashMap<Long, File>();
	for (final File file : this.config.getLogPath().listFiles(this.filter)) {
	    if (file.isFile()) {
		final long index = this.config.getFilenameDateFormat().parse(file.getName().replaceAll(pattern, "$1")).getTime();
		candidates.put(index, file);
	    }
	}

	if (candidates.size() <= this.config.getMaxBackups()) return;

	final List<Long> keys = new ArrayList<Long>(candidates.keySet());
	Collections.sort(keys);

	for (int i = 0; i < keys.size() && candidates.size() > this.config.getMaxBackups(); i++) {
	    final File file = candidates.remove(keys.get(i));
	    file.delete();
	}
    }

    public void write(final LogEvent logEvent) {
	final String currentLogMessage = this.layout.format(logEvent);

	if (!this.filenameDate.equalsIgnoreCase(this.config.getFilenameDateFormat().format(logEvent.getThrowabledAt()))) {
	    prepareFileLog(createFileLog());
	}

	if (this.logFile.length() + currentLogMessage.length() > this.config.getMaxLength()) {
	    prepareFileLog(createFileLog());
	}

	this.output.print(currentLogMessage);
	this.output.flush();
    }

    public boolean isAutoOverride() {
	return this.autoOverride;
    }

    public Layout getLayout() {
	return this.layout;
    }
}
