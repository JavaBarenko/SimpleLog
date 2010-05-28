package barenko.util.log;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import junit.framework.TestCase;
import barenko.util.log.appender.ConsoleAppender;
import barenko.util.log.layout.DateLayout;

public class LogTest extends TestCase {
    static String tracePattern = "(?s).*\\[.*?\\] TRACE  : Msg Trace: message.*";
    static String debugPattern = "(?s).*\\[.*?\\] DEBUG  : Msg Debug: message.*";
    static String infoPattern = "(?s).*\\[.*?\\] INFO   : Msg Info: message.*";
    static String warningPattern = "(?s).*\\[.*?\\] WARNING: Msg Warning: message.*";
    static String errorPattern = "(?s).*\\[.*?\\] ERROR  : Msg Error: message.*";
    static String fatalPattern = "(?s).*\\[.*?\\] FATAL  : Msg Fatal: message.*";

    public void testAllLogDateLayout() throws Throwable {
	ByteArrayOutputStream outputStream = null;
	Log log = null;
	try {
	    outputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStream));

	    final LogConfig logConf = new DefaultLogConfig(LogLevel.ALL, new ConsoleAppender(new DateLayout()));
	    log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.warning("Msg Warning: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    assertTrue(outputStream.toString().matches(tracePattern));
	    assertTrue(outputStream.toString().matches(debugPattern));
	    assertTrue(outputStream.toString().matches(infoPattern));
	    assertTrue(outputStream.toString().matches(warningPattern));
	    assertTrue(outputStream.toString().matches(errorPattern));
	    assertTrue(outputStream.toString().matches(fatalPattern));
	} finally {
	    if (outputStream != null) outputStream.close();
	    if (log != null) log.close();
	}
    }

    public void testTraceLogDateLayout() throws Throwable {
	ByteArrayOutputStream outputStream = null;
	Log log = null;
	try {
	    outputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStream));

	    final LogConfig logConf = new DefaultLogConfig(LogLevel.TRACE, new ConsoleAppender(new DateLayout()));
	    log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.warning("Msg Warning: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    assertTrue(outputStream.toString().matches(tracePattern));
	    assertTrue(outputStream.toString().matches(debugPattern));
	    assertTrue(outputStream.toString().matches(infoPattern));
	    assertTrue(outputStream.toString().matches(warningPattern));
	    assertTrue(outputStream.toString().matches(errorPattern));
	    assertTrue(outputStream.toString().matches(fatalPattern));
	} finally {
	    if (outputStream != null) outputStream.close();
	    if (log != null) log.close();
	}
    }

    public void testDebugLogDateLayout() throws Throwable {
	ByteArrayOutputStream outputStream = null;
	Log log = null;
	try {
	    outputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStream));

	    final LogConfig logConf = new DefaultLogConfig(LogLevel.DEBUG, new ConsoleAppender(new DateLayout()));
	    log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.warning("Msg Warning: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    assertFalse(outputStream.toString().matches(tracePattern));
	    assertTrue(outputStream.toString().matches(debugPattern));
	    assertTrue(outputStream.toString().matches(infoPattern));
	    assertTrue(outputStream.toString().matches(warningPattern));
	    assertTrue(outputStream.toString().matches(errorPattern));
	    assertTrue(outputStream.toString().matches(fatalPattern));
	} finally {
	    if (outputStream != null) outputStream.close();
	    if (log != null) log.close();

	}
    }

    public void testInfoLogDateLayout() throws Throwable {
	PrintWriter pw = null;
	ByteArrayOutputStream outputStream = null;
	try {
	    outputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStream));

	    pw = new PrintWriter(System.out);

	    final LogConfig logConf = new DefaultLogConfig(LogLevel.INFO, new ConsoleAppender(new DateLayout()));
	    final Log log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.warning("Msg Warning: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    assertFalse(outputStream.toString().matches(tracePattern));
	    assertFalse(outputStream.toString().matches(debugPattern));
	    assertTrue(outputStream.toString().matches(infoPattern));
	    assertTrue(outputStream.toString().matches(warningPattern));
	    assertTrue(outputStream.toString().matches(errorPattern));
	    assertTrue(outputStream.toString().matches(fatalPattern));
	} finally {
	    if (outputStream != null) outputStream.close();
	    if (pw != null) pw.close();
	}
    }

    public void testWarningLogDateLayout() throws Throwable {
	PrintWriter pw = null;
	ByteArrayOutputStream outputStream = null;
	try {
	    outputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStream));

	    pw = new PrintWriter(System.out);

	    final LogConfig logConf = new DefaultLogConfig(LogLevel.WARNING, new ConsoleAppender(new DateLayout()));
	    final Log log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.warning("Msg Warning: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    assertFalse(outputStream.toString().matches(tracePattern));
	    assertFalse(outputStream.toString().matches(debugPattern));
	    assertFalse(outputStream.toString().matches(infoPattern));
	    assertTrue(outputStream.toString().matches(warningPattern));
	    assertTrue(outputStream.toString().matches(errorPattern));
	    assertTrue(outputStream.toString().matches(fatalPattern));
	} finally {
	    if (outputStream != null) outputStream.close();
	    if (pw != null) pw.close();
	}
    }

    public void testErrorLogDateLayout() throws Throwable {
	ByteArrayOutputStream outputStream = null;
	Log log = null;
	try {
	    outputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStream));

	    final LogConfig logConf = new DefaultLogConfig(LogLevel.ERROR, new ConsoleAppender(new DateLayout()));
	    log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.warning("Msg Warning: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    assertFalse(outputStream.toString().matches(tracePattern));
	    assertFalse(outputStream.toString().matches(debugPattern));
	    assertFalse(outputStream.toString().matches(infoPattern));
	    assertFalse(outputStream.toString().matches(warningPattern));
	    assertTrue(outputStream.toString().matches(errorPattern));
	    assertTrue(outputStream.toString().matches(fatalPattern));
	} finally {
	    if (outputStream != null) outputStream.close();
	    if (log != null) log.close();
	}
    }

    public void testErrorWithThrowLogDateLayout() throws Throwable {
	ByteArrayOutputStream outputStream = null;
	Log log = null;
	try {
	    outputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStream));

	    final LogConfig logConf = new DefaultLogConfig(LogLevel.ALL, new ConsoleAppender(new DateLayout()));
	    log = new DefaultLog(logConf);

	    try {
		throw new FileNotFoundException("message");
	    } catch (final Exception e) {
		log.error(e, "Msg Error: %s", "message");
	    }

	    assertTrue(outputStream.toString().matches(errorPattern + "FileNotFoundException: message.*testErrorWithThrowLogDateLayout\\(LogTest.java:\\d+\\).*"));
	} finally {
	    if (outputStream != null) outputStream.close();
	    if (log != null) log.close();
	}
    }

    public void testFatalLogDateLayout() throws Throwable {
	ByteArrayOutputStream outputStream = null;
	Log log = null;
	try {
	    outputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStream));

	    final LogConfig logConf = new DefaultLogConfig(LogLevel.FATAL, new ConsoleAppender(new DateLayout()));
	    log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.warning("Msg Warning: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    assertFalse(outputStream.toString().matches(tracePattern));
	    assertFalse(outputStream.toString().matches(debugPattern));
	    assertFalse(outputStream.toString().matches(infoPattern));
	    assertFalse(outputStream.toString().matches(warningPattern));
	    assertFalse(outputStream.toString().matches(errorPattern));
	    assertTrue(outputStream.toString().matches(fatalPattern));
	} finally {
	    if (outputStream != null) outputStream.close();
	    if (log != null) log.close();
	}
    }

    public void testHeaderLogDateLayout() throws Throwable {
	ByteArrayOutputStream outputStream = null;
	Log log = null;
	try {
	    outputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStream));

	    final DateLayout layout = new DateLayout();
	    layout.setHeader("Header - Inicio do Log");
	    final LogConfig logConf = new DefaultLogConfig(LogLevel.FATAL, new ConsoleAppender(layout));
	    log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.warning("Msg Warning: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    assertTrue(outputStream.toString().matches("(?s)" + layout.getHeader() + ".*"));
	    assertFalse(outputStream.toString().matches(tracePattern));
	    assertFalse(outputStream.toString().matches(debugPattern));
	    assertFalse(outputStream.toString().matches(infoPattern));
	    assertFalse(outputStream.toString().matches(warningPattern));
	    assertFalse(outputStream.toString().matches(errorPattern));
	    assertTrue(outputStream.toString().matches(fatalPattern));
	} finally {
	    if (outputStream != null) outputStream.close();
	    if (log != null) log.close();

	}
    }

    public void testOffLogDateLayout() throws Throwable {
	ByteArrayOutputStream outputStream = null;
	Log log = null;
	try {
	    outputStream = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStream));

	    final LogConfig logConf = new DefaultLogConfig(LogLevel.OFF, new ConsoleAppender(new DateLayout()));
	    log = new DefaultLog(logConf);

	    log.trace("Msg Trace: %s", "message");
	    log.debug("Msg Debug: %s", "message");
	    log.info("Msg Info: %s", "message");
	    log.warning("Msg Warning: %s", "message");
	    log.error("Msg Error: %s", "message");
	    log.fatal("Msg Fatal: %s", "message");

	    assertFalse(outputStream.toString().matches(tracePattern));
	    assertFalse(outputStream.toString().matches(debugPattern));
	    assertFalse(outputStream.toString().matches(infoPattern));
	    assertFalse(outputStream.toString().matches(warningPattern));
	    assertFalse(outputStream.toString().matches(errorPattern));
	    assertFalse(outputStream.toString().matches(fatalPattern));
	} finally {
	    if (outputStream != null) outputStream.close();
	    if (log != null) log.close();
	}
    }

}
