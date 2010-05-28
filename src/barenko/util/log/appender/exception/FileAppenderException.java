package barenko.util.log.appender.exception;

import barenko.util.log.appender.FileAppender;

/**
 * Indica um problemas referente aos {@link FileAppender}'s.
 * 
 * @author Rafael Caetano Pinto
 */
public class FileAppenderException extends AppenderException {
    /**
     * Constr�i {@link FileAppenderException}.
     * 
     * @param cause
     *            {@link Throwable} da Exce��o original.
     */
    public FileAppenderException(final Throwable cause) {
	super(cause);
    }

    /**
     * Constr�i {@link FileAppenderException}.
     * 
     * @param message
     *            Mensagem personalizada da Exce��o.
     * @param cause
     *            {@link Throwable} da Exce��o original.
     */
    public FileAppenderException(final String message, final Throwable cause) {
	super(message, cause);
    }

    /**
     * Constr�i {@link FileAppenderException} passando a mensagem personalizada da Exce��o.<br>
     * Essa mensagem equivale � utiliza��o de <code>String.format(message, objects)</code>.<br>
     * 
     * @see String#format(String, Object...)
     * 
     * @param message
     *            Mensagem personalizada da Exce��o.
     * @param objects
     *            Par�metros da mensagem.
     */
    public FileAppenderException(final String message, final Object... objects) {
	super(String.format(message, objects));
    }
}
