package barenko.util.log;

import java.util.List;
import barenko.util.log.appender.Appender;
import barenko.util.log.appender.exception.AppenderException;

/**
 * Representa��o da estrutura de log
 * 
 * @author Rafael Caetano Pinto
 */
public interface Log {
    /**
     * Obt�m a lista de Appenders que est�o sendo usados atualmente no log
     * 
     * @return a lista atual de Appenders
     */
    List<Appender> getCurrentAppenders();

    /**
     * Configura o n�vel de log atual
     * 
     * @param level
     *            o novo n�vel de log
     */
    void setLevel(LogLevel level);

    /**
     * Fecha todos os appenders utilizados pelo log
     * 
     * @throws AppenderException
     *             Se ocorrer algum erro durante o encerramento de algum appender
     */
    void close() throws AppenderException;

    /**
     * Indica se o n�vel de log ativo � o {@link LogLevel#FATAL}
     * 
     * @return true se o n�vel for fatal, false caso contr�rio
     */
    boolean isFatalEnabled();

    /**
     * Indica se o n�vel de log ativo � o {@link LogLevel#ERROR}
     * 
     * @return true se o n�vel for error, false caso contr�rio
     */
    boolean isErrorEnabled();

    /**
     * Indica se o n�vel de log ativo � o {@link LogLevel#WARNING}
     * 
     * @return true se o n�vel for warning, false caso contr�rio
     */
    boolean isWarningEnabled();

    /**
     * Indica se o n�vel de log ativo � o {@link LogLevel#INFO}
     * 
     * @return true se o n�vel for info, false caso contr�rio
     */
    boolean isInfoEnabled();

    /**
     * Indica se o n�vel de log ativo � o {@link LogLevel#DEBUG}
     * 
     * @return true se o n�vel for debug, false caso contr�rio
     */
    boolean isDebugEnabled();

    /**
     * Indica se o n�vel de log ativo � o {@link LogLevel#TRACE}
     * 
     * @return true se o n�vel for trace, false caso contr�rio
     */
    boolean isTraceEnabled();

    /*
     * (non-Javadoc)
     * @see cas.log.LogConfig#getLevel()
     */
    LogLevel getLevel();

    /**
     * Loga a exce��o no n�vel de log {@link LogLevel#FATAL}
     * 
     * @param throwable
     *            A exce��o
     * @param objects
     *            Os objetos utilizados com message.
     */
    void fatal(Throwable throwable);

    /**
     * Loga a exce��o no n�vel de log {@link LogLevel#ERROR}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void error(Throwable throwable);

    /**
     * Loga a exce��o no n�vel de log {@link LogLevel#WARNING}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void warning(Throwable throwable);

    /**
     * Loga a exce��o no n�vel de log {@link LogLevel#INFO}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void info(Throwable throwable);

    /**
     * Loga a exce��o no n�vel de log {@link LogLevel#DEBUG}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void debug(Throwable throwable);

    /**
     * Loga a exce��o no n�vel de log {@link LogLevel#TRACE}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void trace(Throwable throwable);

    /**
     * Loga a exce��o com a mensagem no n�vel de log {@link LogLevel#FATAL}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void fatal(Throwable throwable, String message, Object... objects);

    /**
     * Loga a exce��o com a mensagem no n�vel de log {@link LogLevel#ERROR}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void error(Throwable throwable, String message, Object... objects);

    /**
     * Loga a exce��o com a mensagem no n�vel de log {@link LogLevel#WARNING}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void warning(Throwable throwable, String message, Object... objects);

    /**
     * Loga a exce��o com a mensagem no n�vel de log {@link LogLevel#INFO}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void info(Throwable throwable, String message, Object... objects);

    /**
     * Loga a exce��o com a mensagem no n�vel de log {@link LogLevel#DEBUG}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void debug(Throwable throwable, String message, Object... objects);

    /**
     * Loga a exce��o com a mensagem no n�vel de log {@link LogLevel#TRACE}
     * 
     * @param throwable
     *            A exce��o
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void trace(Throwable throwable, String message, Object... objects);

    /**
     * Loga a mensagem no n�vel de log {@link LogLevel#FATAL}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void fatal(String message, Object... objects);

    /**
     * Loga a mensagem no n�vel de log {@link LogLevel#ERROR}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void error(String message, Object... objects);

    /**
     * Loga a mensagem no n�vel de log {@link LogLevel#WARNING}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void warning(String message, Object... objects);

    /**
     * Loga a mensagem no n�vel de log {@link LogLevel#INFO}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void info(String message, Object... objects);

    /**
     * Loga a mensagem no n�vel de log {@link LogLevel#DEBUG}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void debug(String message, Object... objects);

    /**
     * Loga a mensagem no n�vel de log {@link LogLevel#TRACE}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void trace(String message, Object... objects);

    /**
     * Loga a mensagem no n�vel de log especificado
     * 
     * @param level
     *            O n�vel de log que o evento ser� vinculado
     * @param throwable
     *            A exce��o do evento
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void log(final LogLevel level, final Throwable throwable, final String message, final Object... objects);
}
