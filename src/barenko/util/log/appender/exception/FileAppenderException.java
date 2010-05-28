package barenko.util.log.appender.exception;

import barenko.util.log.appender.FileAppender;

/**
 * Indica um problemas referente aos {@link FileAppender}'s.
 * 
 * @author Rafael Caetano Pinto
 */
public class FileAppenderException extends AppenderException {
    /**
     * Constrói {@link FileAppenderException}.
     * 
     * @param cause
     *            {@link Throwable} da Exceção original.
     */
    public FileAppenderException(final Throwable cause) {
	super(cause);
    }

    /**
     * Constrói {@link FileAppenderException}.
     * 
     * @param message
     *            Mensagem personalizada da Exceção.
     * @param cause
     *            {@link Throwable} da Exceção original.
     */
    public FileAppenderException(final String message, final Throwable cause) {
	super(message, cause);
    }

    /**
     * Constrói {@link FileAppenderException} passando a mensagem personalizada da Exceção.<br>
     * Essa mensagem equivale à utilização de <code>String.format(message, objects)</code>.<br>
     * 
     * @see String#format(String, Object...)
     * 
     * @param message
     *            Mensagem personalizada da Exceção.
     * @param objects
     *            Parâmetros da mensagem.
     */
    public FileAppenderException(final String message, final Object... objects) {
	super(String.format(message, objects));
    }
}
