package barenko.util.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import junit.framework.TestCase;
import barenko.util.log.appender.FileAppender;
import barenko.util.log.appender.FileAppenderConfig;
import barenko.util.log.appender.RollingFileAppender;
import barenko.util.log.layout.DateLayout;

public class RollingFileAppenderLogTest extends TestCase {
    static String tracePattern = "(?s).*\\[.*?\\] TRACE  : Msg Trace: message.*";
    static String debugPattern = "(?s).*\\[.*?\\] DEBUG  : Msg Debug: message.*";
    static String infoPattern = "(?s).*\\[.*?\\] INFO   : Msg Info: message.*";
    static String errorPattern = "(?s).*\\[.*?\\] ERROR  : Msg Error: message.*";
    static String fatalPattern = "(?s).*\\[.*?\\] FATAL  : Msg Fatal: message.*";

    public void testAllLogDateLayout() throws Throwable {
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	BufferedReader br = null;
	Log log = null;
	FileAppender appender = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.ALL, new RollingFileAppender(new DateLayout(), config));
	    log = new DefaultLog(logConf);

	    appender = (FileAppender) log.getCurrentAppenders().get(0);

	    br = new BufferedReader(new FileReader(appender.getFile()));
	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    final StringBuilder sb = new StringBuilder();
	    String buffer = null;
	    while ((buffer = br.readLine()) != null) {
		sb.append(buffer).append(LogHelper.NEW_LINE);
	    }

	    buffer = sb.toString();

	    assertTrue(buffer.matches(tracePattern));
	    assertTrue(buffer.matches(debugPattern));
	    assertTrue(buffer.matches(infoPattern));
	    assertTrue(buffer.matches(errorPattern));
	    assertTrue(buffer.matches(fatalPattern));

	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (br != null) br.close();
	    if (log != null) log.close();
	    if (appender != null) appender.getFile().delete();
	}
    }

    public void testTraceLogDateLayout() throws Throwable {
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	BufferedReader br = null;
	Log log = null;
	FileAppender appender = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.TRACE, new RollingFileAppender(new DateLayout(), config));
	    log = new DefaultLog(logConf);

	    appender = (FileAppender) log.getCurrentAppenders().get(0);
	    br = new BufferedReader(new FileReader(appender.getFile()));
	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    final StringBuilder sb = new StringBuilder();
	    String buffer = null;
	    while ((buffer = br.readLine()) != null) {
		sb.append(buffer).append(LogHelper.NEW_LINE);
	    }

	    buffer = sb.toString();

	    assertTrue(buffer.matches(tracePattern));
	    assertTrue(buffer.matches(debugPattern));
	    assertTrue(buffer.matches(infoPattern));
	    assertTrue(buffer.matches(errorPattern));
	    assertTrue(buffer.matches(fatalPattern));

	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (br != null) br.close();
	    if (log != null) log.close();
	    if (appender != null) appender.getFile().delete();
	}
    }

    public void testDebugLogDateLayout() throws Throwable {
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	BufferedReader br = null;
	Log log = null;
	FileAppender appender = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.DEBUG, new RollingFileAppender(new DateLayout(), config));
	    log = new DefaultLog(logConf);

	    appender = (FileAppender) log.getCurrentAppenders().get(0);
	    br = new BufferedReader(new FileReader(appender.getFile()));
	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    final StringBuilder sb = new StringBuilder();
	    String buffer = null;
	    while ((buffer = br.readLine()) != null) {
		sb.append(buffer).append(LogHelper.NEW_LINE);
	    }

	    buffer = sb.toString();

	    assertFalse(buffer.matches(tracePattern));
	    assertTrue(buffer.matches(debugPattern));
	    assertTrue(buffer.matches(infoPattern));
	    assertTrue(buffer.matches(errorPattern));
	    assertTrue(buffer.matches(fatalPattern));

	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (br != null) br.close();
	    if (log != null) log.close();
	    if (appender != null) appender.getFile().delete();
	}
    }

    public void testInfoLogDateLayout() throws Throwable {
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	BufferedReader br = null;
	Log log = null;
	FileAppender appender = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.INFO, new RollingFileAppender(new DateLayout(), config));
	    log = new DefaultLog(logConf);

	    appender = (FileAppender) log.getCurrentAppenders().get(0);
	    br = new BufferedReader(new FileReader(appender.getFile()));
	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    final StringBuilder sb = new StringBuilder();
	    String buffer = null;
	    while ((buffer = br.readLine()) != null) {
		sb.append(buffer).append(LogHelper.NEW_LINE);
	    }

	    buffer = sb.toString();

	    assertFalse(buffer.matches(tracePattern));
	    assertFalse(buffer.matches(debugPattern));
	    assertTrue(buffer.matches(infoPattern));
	    assertTrue(buffer.matches(errorPattern));
	    assertTrue(buffer.matches(fatalPattern));

	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (br != null) br.close();
	    if (log != null) log.close();
	    if (appender != null) appender.getFile().delete();
	}
    }

    public void testErrorLogDateLayout() throws Throwable {
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	BufferedReader br = null;
	Log log = null;
	FileAppender appender = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.ERROR, new RollingFileAppender(new DateLayout(), config));
	    log = new DefaultLog(logConf);

	    appender = (FileAppender) log.getCurrentAppenders().get(0);
	    br = new BufferedReader(new FileReader(appender.getFile()));
	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    final StringBuilder sb = new StringBuilder();
	    String buffer = null;
	    while ((buffer = br.readLine()) != null) {
		sb.append(buffer).append(LogHelper.NEW_LINE);
	    }

	    buffer = sb.toString();

	    assertFalse(buffer.matches(tracePattern));
	    assertFalse(buffer.matches(debugPattern));
	    assertFalse(buffer.matches(infoPattern));
	    assertTrue(buffer.matches(errorPattern));
	    assertTrue(buffer.matches(fatalPattern));

	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (br != null) br.close();
	    if (log != null) log.close();
	    if (appender != null) appender.getFile().delete();
	}
    }

    public void testErrorWithThrowLogDateLayout() throws Throwable {
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	BufferedReader br = null;
	Log log = null;
	FileAppender appender = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.ERROR, new RollingFileAppender(new DateLayout(), config));
	    log = new DefaultLog(logConf);

	    appender = (FileAppender) log.getCurrentAppenders().get(0);
	    br = new BufferedReader(new FileReader(appender.getFile()));

	    try {
		throw new FileNotFoundException("message");
	    } catch (final Exception e) {
		log.error(e, "Msg Error: %s", "message");
	    }

	    final StringBuilder sb = new StringBuilder();
	    String buffer = null;
	    while ((buffer = br.readLine()) != null) {
		sb.append(buffer).append(LogHelper.NEW_LINE);
	    }

	    buffer = sb.toString();
	    assertTrue(buffer.matches(errorPattern));

	    assertTrue(buffer.matches(errorPattern + "FileNotFoundException: message.*testErrorWithThrowLogDateLayout\\(RollingFileAppenderLogTest.java:\\d+\\).*"));

	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (br != null) br.close();
	    if (log != null) log.close();
	    if (appender != null) appender.getFile().delete();
	}
    }

    public void testFatalLogDateLayout() throws Throwable {
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	BufferedReader br = null;
	Log log = null;
	FileAppender appender = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.FATAL, new RollingFileAppender(new DateLayout(), config));
	    log = new DefaultLog(logConf);

	    appender = (FileAppender) log.getCurrentAppenders().get(0);
	    br = new BufferedReader(new FileReader(appender.getFile()));
	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    final StringBuilder sb = new StringBuilder();
	    String buffer = null;
	    while ((buffer = br.readLine()) != null) {
		sb.append(buffer).append(LogHelper.NEW_LINE);
	    }

	    buffer = sb.toString();

	    assertFalse(buffer.matches(tracePattern));
	    assertFalse(buffer.matches(debugPattern));
	    assertFalse(buffer.matches(infoPattern));
	    assertFalse(buffer.matches(errorPattern));
	    assertTrue(buffer.matches(fatalPattern));

	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (br != null) br.close();
	    if (log != null) log.close();
	    if (appender != null) appender.getFile().delete();
	}
    }

    public void testOffLogDateLayout() throws Throwable {
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	BufferedReader br = null;
	Log log = null;
	FileAppender appender = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.OFF, new RollingFileAppender(new DateLayout(), config));
	    log = new DefaultLog(logConf);

	    appender = (FileAppender) log.getCurrentAppenders().get(0);
	    br = new BufferedReader(new FileReader(appender.getFile()));
	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    final StringBuilder sb = new StringBuilder();
	    String buffer = null;
	    while ((buffer = br.readLine()) != null) {
		sb.append(buffer).append(LogHelper.NEW_LINE);
	    }

	    buffer = sb.toString();

	    assertFalse(buffer.matches(tracePattern));
	    assertFalse(buffer.matches(debugPattern));
	    assertFalse(buffer.matches(infoPattern));
	    assertFalse(buffer.matches(errorPattern));
	    assertFalse(buffer.matches(fatalPattern));

	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (br != null) br.close();
	    if (log != null) log.close();
	    if (appender != null) appender.getFile().delete();
	}
    }

    public void testCleanExcedentFiles() throws Throwable {
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	Log log = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    config.setFilenameDateFormat(new SimpleDateFormat("HHmmss.SSS"));
	    config.setPrefix("ZZZ_");
	    config.setMaxBackups(3);
	    final RollingFileAppender rollingFileAppender = new RollingFileAppender(new DateLayout(new SimpleDateFormat("HH:mm:ss.SSS")), config);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.ALL, rollingFileAppender);
	    log = new DefaultLog(logConf);

	    Thread.sleep(900);
	    log.trace("Msg Trace: %s", "message");
	    Thread.sleep(900);
	    log.debug("Msg Debug: %s", "message");
	    Thread.sleep(900);
	    log.info("Msg Info: %s", "message");
	    Thread.sleep(900);
	    log.error("Msg Error: %s", "message");
	    Thread.sleep(900);
	    log.fatal("Msg Fatal: %s", "message");

	    assertEquals(3, logPath.listFiles(new FilenameFilter() {
		public boolean accept(@SuppressWarnings("unused") final File dir, final String name) {
		    if (name.matches("ZZZ_\\d{6}\\.\\d{3}\\.log")) return true;
		    return false;
		}
	    }).length);

	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (log != null) log.close();
	}
    }

    public void testMaxLength() throws Throwable {
	final int MAX_SIZE = 250;
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	Log log = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    config.setFilenameDateFormat(new SimpleDateFormat("DD"));
	    config.setPrefix("XXX_");
	    config.setMaxLength(MAX_SIZE);
	    final RollingFileAppender rollingFileAppender = new RollingFileAppender(new DateLayout(new SimpleDateFormat("HH:mm:ss.SSS")), config);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.ALL, rollingFileAppender);
	    log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");
	    try {
		throw new FileNotFoundException("message");
	    } catch (final Exception e) {
		log.error(e, "Msg Error: %s", "message");
	    }

	    final File[] files = logPath.listFiles(new FilenameFilter() {
		public boolean accept(@SuppressWarnings("unused") final File dir, final String name) {
		    if (name.matches("XXX_\\d{2}\\.log")) return true;
		    return false;
		}
	    });

	    for (final File file : files) {
		assertTrue("Tamanho maior que o máximo permitido", file.length() <= MAX_SIZE);
	    }
	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (log != null) log.close();
	}
    }

    public void testMaxLengthAndCleanExcedentFiles() throws Throwable {
	final int MAX_SIZE = 150;
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	Log log = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    config.setFilenameDateFormat(new SimpleDateFormat("DD"));
	    config.setPrefix("YYY_");
	    config.setMaxLength(MAX_SIZE);
	    config.setMaxBackups(3);
	    final RollingFileAppender rollingFileAppender = new RollingFileAppender(new DateLayout(new SimpleDateFormat("HH:mm:ss.SSS")), config);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.ALL, rollingFileAppender);
	    log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    try {
		throw new FileNotFoundException("message");
	    } catch (final Exception e) {
		log.error(e, "Msg Error: %s", "message");
	    }
	    log.debug("Msg Debug: %s", "message");
	    try {
		throw new FileNotFoundException("message");
	    } catch (final Exception e) {
		log.error(e, "Msg Error: %s", "message");
	    }
	    log.info("Msg Info: %s", "message");
	    try {
		throw new FileNotFoundException("message");
	    } catch (final Exception e) {
		log.error(e, "Msg Error: %s", "message");
	    }
	    log.error("Msg Error: %s", "message");
	    try {
		throw new FileNotFoundException("message");
	    } catch (final Exception e) {
		log.error(e, "Msg Error: %s", "message");
	    }
	    log.fatal("Msg Fatal: %s", "message");
	    try {
		throw new FileNotFoundException("message");
	    } catch (final Exception e) {
		log.error(e, "Msg Error: %s", "message");
	    }

	    final File[] files = logPath.listFiles(new FilenameFilter() {
		public boolean accept(@SuppressWarnings("unused") final File dir, final String name) {
		    if (name.matches("YYY_\\d{2}\\.log")) return true;
		    return false;
		}
	    });

	    for (final File file : files) {
		assertTrue("Tamanho maior que o máximo permitido", file.length() <= MAX_SIZE);
	    }
	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (log != null) log.close();
	}
    }

    public void testChangedHeaderLogDateLayout() throws Throwable {
	final int MAX_SIZE = 150;
	final File logPath = new File(System.getProperty("java.io.tmpdir"));
	Log log = null;
	try {
	    final FileAppenderConfig config = new FileAppenderConfig();
	    config.setLogPath(logPath);
	    config.setFilenameDateFormat(new SimpleDateFormat("DD"));
	    config.setPrefix("KKK_");
	    config.setMaxLength(MAX_SIZE);
	    config.setMaxBackups(3);
	    final RollingFileAppender rollingFileAppender = new RollingFileAppender(new DateLayout(new SimpleDateFormat("HH:mm:ss.SSS")), config);
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.ALL, rollingFileAppender);
	    log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    logConf.setHeader("Header - Um novo cabeçalho");
	    try {
		throw new FileNotFoundException("message");
	    } catch (final Exception e) {
		log.error(e, "Msg Error: %s", "message");
	    }

	    final File[] files = logPath.listFiles(new FilenameFilter() {
		public boolean accept(@SuppressWarnings("unused") final File dir, final String name) {
		    if (name.matches("KKK_\\d{2}\\.log")) return true;
		    return false;
		}
	    });

	    for (int i = 0; i < files.length; i++) {
		BufferedReader br = null;
		try {
		    br = new BufferedReader(new FileReader(files[i]));
		    final StringBuilder sb = new StringBuilder();
		    String buffer = null;
		    while ((buffer = br.readLine()) != null) {
			sb.append(buffer).append(LogHelper.NEW_LINE);
		    }

		    buffer = sb.toString();

		    if (i == 0) assertTrue(buffer.matches(tracePattern));
		    else assertTrue(buffer.matches("(?s)Header - Um novo cabeçalho.*"));
		} finally {
		    if (br != null) br.close();
		}

	    }
	    deleteFiles(logPath, config.getPrefix(), config.getSuffix());
	} finally {
	    if (log != null) log.close();
	}
    }

    private void deleteFiles(final File path, final String prefix, final String suffix) {
	final File[] files = path.listFiles(new FilenameFilter() {
	    public boolean accept(@SuppressWarnings("unused") final File dir, final String name) {
		if (name.matches(prefix + "(.*?)" + suffix)) return true;
		return false;
	    }
	});

	for (final File file : files) {
	    if (!file.delete()) file.deleteOnExit();
	}
    }
}
