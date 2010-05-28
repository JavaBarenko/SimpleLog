package barenko.util.log;

import java.util.List;
import barenko.util.log.appender.Appender;
import barenko.util.log.appender.exception.AppenderException;

/**
 * Representação da estrutura de log
 * 
 * @author Rafael Caetano Pinto
 */
public interface Log {
    /**
     * Obtém a lista de Appenders que estão sendo usados atualmente no log
     * 
     * @return a lista atual de Appenders
     */
    List<Appender> getCurrentAppenders();

    /**
     * Configura o nível de log atual
     * 
     * @param level
     *            o novo nível de log
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
     * Indica se o nível de log ativo é o {@link LogLevel#FATAL}
     * 
     * @return true se o nível for fatal, false caso contrário
     */
    boolean isFatalEnabled();

    /**
     * Indica se o nível de log ativo é o {@link LogLevel#ERROR}
     * 
     * @return true se o nível for error, false caso contrário
     */
    boolean isErrorEnabled();

    /**
     * Indica se o nível de log ativo é o {@link LogLevel#WARNING}
     * 
     * @return true se o nível for warning, false caso contrário
     */
    boolean isWarningEnabled();

    /**
     * Indica se o nível de log ativo é o {@link LogLevel#INFO}
     * 
     * @return true se o nível for info, false caso contrário
     */
    boolean isInfoEnabled();

    /**
     * Indica se o nível de log ativo é o {@link LogLevel#DEBUG}
     * 
     * @return true se o nível for debug, false caso contrário
     */
    boolean isDebugEnabled();

    /**
     * Indica se o nível de log ativo é o {@link LogLevel#TRACE}
     * 
     * @return true se o nível for trace, false caso contrário
     */
    boolean isTraceEnabled();

    /*
     * (non-Javadoc)
     * @see cas.log.LogConfig#getLevel()
     */
    LogLevel getLevel();

    /**
     * Loga a exceção no nível de log {@link LogLevel#FATAL}
     * 
     * @param throwable
     *            A exceção
     * @param objects
     *            Os objetos utilizados com message.
     */
    void fatal(Throwable throwable);

    /**
     * Loga a exceção no nível de log {@link LogLevel#ERROR}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void error(Throwable throwable);

    /**
     * Loga a exceção no nível de log {@link LogLevel#WARNING}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void warning(Throwable throwable);

    /**
     * Loga a exceção no nível de log {@link LogLevel#INFO}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void info(Throwable throwable);

    /**
     * Loga a exceção no nível de log {@link LogLevel#DEBUG}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void debug(Throwable throwable);

    /**
     * Loga a exceção no nível de log {@link LogLevel#TRACE}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void trace(Throwable throwable);

    /**
     * Loga a exceção com a mensagem no nível de log {@link LogLevel#FATAL}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void fatal(Throwable throwable, String message, Object... objects);

    /**
     * Loga a exceção com a mensagem no nível de log {@link LogLevel#ERROR}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void error(Throwable throwable, String message, Object... objects);

    /**
     * Loga a exceção com a mensagem no nível de log {@link LogLevel#WARNING}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void warning(Throwable throwable, String message, Object... objects);

    /**
     * Loga a exceção com a mensagem no nível de log {@link LogLevel#INFO}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void info(Throwable throwable, String message, Object... objects);

    /**
     * Loga a exceção com a mensagem no nível de log {@link LogLevel#DEBUG}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void debug(Throwable throwable, String message, Object... objects);

    /**
     * Loga a exceção com a mensagem no nível de log {@link LogLevel#TRACE}
     * 
     * @param throwable
     *            A exceção
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void trace(Throwable throwable, String message, Object... objects);

    /**
     * Loga a mensagem no nível de log {@link LogLevel#FATAL}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void fatal(String message, Object... objects);

    /**
     * Loga a mensagem no nível de log {@link LogLevel#ERROR}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void error(String message, Object... objects);

    /**
     * Loga a mensagem no nível de log {@link LogLevel#WARNING}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void warning(String message, Object... objects);

    /**
     * Loga a mensagem no nível de log {@link LogLevel#INFO}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void info(String message, Object... objects);

    /**
     * Loga a mensagem no nível de log {@link LogLevel#DEBUG}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void debug(String message, Object... objects);

    /**
     * Loga a mensagem no nível de log {@link LogLevel#TRACE}
     * 
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void trace(String message, Object... objects);

    /**
     * Loga a mensagem no nível de log especificado
     * 
     * @param level
     *            O nível de log que o evento será vinculado
     * @param throwable
     *            A exceção do evento
     * @param message
     *            Uma String formatada, utilizando {@link String#format}
     * @param objects
     *            Os objetos utilizados com message.
     */
    void log(final LogLevel level, final Throwable throwable, final String message, final Object... objects);
}
