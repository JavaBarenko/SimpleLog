package barenko.util.log.appender.exception;

public class AppenderException extends Exception {
    /**
     * Constr�i {@link AppenderException}.
     * 
     * @param cause
     *            {@link Throwable} da Exce��o original.
     */
    public AppenderException(final Throwable cause) {
	super(cause);
    }

    /**
     * Constr�i {@link AppenderException}.
     * 
     * @param message
     *            Mensagem personalizada da Exce��o.
     * @param cause
     *            {@link Throwable} da Exce��o original.
     */
    public AppenderException(final String message, final Throwable cause) {
	super(message, cause);
    }

    /**
     * Constr�i {@link AppenderException} passando a mensagem personalizada da Exce��o.<br>
     * Essa mensagem equivale � utiliza��o de <code>String.format(message, objects)</code>.<br>
     * 
     * @see String#format(String, Object...)
     * @param message
     *            Mensagem personalizada da Exce��o.
     * @param objects
     *            Par�metros da mensagem.
     */
    public AppenderException(final String message, final Object... objects) {
	super(String.format(message, objects));
    }
}
