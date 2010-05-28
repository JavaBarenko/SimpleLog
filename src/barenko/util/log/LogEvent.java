package barenko.util.log;

import java.util.Date;

/**
 * Representa um evento de Log <br>
 * Classe utilizada internamente pelo controle de log
 * 
 * @author Rafael Caetano Pinto
 */
public class LogEvent {
    private static int LEVELS_TO_IGNORE = 7;
    private String className;
    private String filename;
    private Integer line;
    private String methodName;
    private final String threadName;
    private final Throwable throwable;
    private StackTraceElement[] stackTrace;
    private final String message;
    private final Date date;
    private final LogLevel level;

    public LogEvent(final LogLevel level, final Throwable throwable, final String message) {
	this.level = level;
	this.date = new Date();
	this.throwable = throwable;
	this.message = message;
	this.threadName = Thread.currentThread().getName();
    }

    private void loadStackTrace() {
	if (this.throwable == null) {
	    final StackTraceElement[] realStackTrace = Thread.currentThread().getStackTrace();
	    this.stackTrace = new StackTraceElement[realStackTrace.length - LEVELS_TO_IGNORE];
	    for (int i = LEVELS_TO_IGNORE; i < realStackTrace.length; i++) {
		this.stackTrace[i - LEVELS_TO_IGNORE] = realStackTrace[i];
	    }
	} else {
	    this.stackTrace = this.throwable.getStackTrace();
	}

	final StackTraceElement ste = this.stackTrace[0];

	this.className = ste.getClassName();
	this.filename = ste.getFileName();
	this.line = ste.getLineNumber();
	this.methodName = ste.getMethodName();
    }

    /**
     * Obt�m o momento em que o evento foi disparado
     * 
     * @return o momento do lan�amento do evento
     */
    public final Date getThrowabledAt() {
	return this.date;
    }

    /**
     * Obt�m o pacote e a classe de onde o evento foi disparado
     * 
     * @return o nome completo da classe
     */
    public final String getClassName() {
	if (this.className == null) loadStackTrace();
	return this.className;
    }

    /**
     * Obt�m o nome do arquivo de onde o evento foi disparado
     * 
     * @return o nome do arquivo
     */
    public final String getFilename() {
	if (this.filename == null) loadStackTrace();
	return this.filename;
    }

    /**
     * Obt�m a linha de onde o evento foi disparado
     * 
     * @return o n�mero da linha
     */
    public final Integer getLine() {
	if (this.line == null) loadStackTrace();
	return this.line;
    }

    /**
     * Obt�m o nome do m�todo de onde o evento foi disparado
     * 
     * @return o nome do m�todo
     */
    public final String getMethodName() {
	if (this.methodName == null) loadStackTrace();
	return this.methodName;
    }

    /**
     * Obt�m a Exce��o do evento
     * 
     * @return A Exce��o, se houver.
     */
    public final Throwable getThrowable() {
	return this.throwable;
    }

    /**
     * Obt�m a pilha do evento
     * 
     * @return a pilha do evento
     */
    public final StackTraceElement[] getStackTrace() {
	if (this.stackTrace == null) loadStackTrace();
	return this.stackTrace;
    }

    /**
     * Obt�m a mensagem indicativa do evento do log
     * 
     * @return a mensagem do evento do log
     */
    public final String getMessage() {
	return this.message == null ? "" : this.message;
    }

    /**
     * Obt�m o nivel do evento do log
     * 
     * @return o nivel do evento do log
     */
    public final LogLevel getLevel() {
	return this.level;
    }

    /**
     * Obt�m o nome da thread que estava executando o c�digo que gerou o evento no log
     * 
     * @return o nome da thread corrente
     */
    public final String getThreadName() {
	return this.threadName;
    }
}
