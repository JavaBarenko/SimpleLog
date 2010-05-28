package barenko.util.log.appender.exception;

public class AppenderException extends Exception {
    /**
     * Constrói {@link AppenderException}.
     * 
     * @param cause
     *            {@link Throwable} da Exceção original.
     */
    public AppenderException(final Throwable cause) {
	super(cause);
    }

    /**
     * Constrói {@link AppenderException}.
     * 
     * @param message
     *            Mensagem personalizada da Exceção.
     * @param cause
     *            {@link Throwable} da Exceção original.
     */
    public AppenderException(final String message, final Throwable cause) {
	super(message, cause);
    }

    /**
     * Constrói {@link AppenderException} passando a mensagem personalizada da Exceção.<br>
     * Essa mensagem equivale à utilização de <code>String.format(message, objects)</code>.<br>
     * 
     * @see String#format(String, Object...)
     * @param message
     *            Mensagem personalizada da Exceção.
     * @param objects
     *            Parâmetros da mensagem.
     */
    public AppenderException(final String message, final Object... objects) {
	super(String.format(message, objects));
    }
}
