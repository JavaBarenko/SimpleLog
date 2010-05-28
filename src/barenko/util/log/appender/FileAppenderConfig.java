package barenko.util.log.appender;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FileAppenderConfig {
    private boolean autoCreateFile = false;
    private File logPath;
    private int maxBackups = Integer.MAX_VALUE;
    private int maxLength = Integer.MAX_VALUE;
    private String prefix = "log_";
    private String suffix = ".log";
    private DateFormat filenameDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public final File getLogPath() {
	return this.logPath;
    }

    public final void setLogPath(final File logPath) {
	this.logPath = logPath;
    }

    public final int getMaxBackups() {
	return this.maxBackups;
    }

    public final void setMaxBackups(final int maxBackups) {
	this.maxBackups = maxBackups;
    }

    public final int getMaxLength() {
	return this.maxLength;
    }

    public final void setMaxLength(final int maxLength) {
	this.maxLength = maxLength;
    }

    public final String getPrefix() {
	return this.prefix;
    }

    public final void setPrefix(final String prefix) {
	this.prefix = prefix;
    }

    public final String getSuffix() {
	return this.suffix;
    }

    public final void setSuffix(final String suffix) {
	this.suffix = suffix;
    }

    public final DateFormat getFilenameDateFormat() {
	return this.filenameDateFormat;
    }

    public final void setFilenameDateFormat(final DateFormat dateFormat) {
	this.filenameDateFormat = dateFormat;
    }

    public final boolean isAutoCreateFile() {
	return this.autoCreateFile;
    }

    public final void setAutoCreateFile(final boolean autoCreateFile) {
	this.autoCreateFile = autoCreateFile;
    }

}
