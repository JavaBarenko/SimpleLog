package barenko.util.log;

/**
 * Clona a instância para utilização de um novo log
 * 
 * @author Rafael Caetano Pinto
 */
public interface CloneableLog extends java.lang.Cloneable, Loggable {
    /**
     * Clona o objeto, permitindo alterar apenas o log.
     * 
     * @param log
     *            O novo log que será utilizado
     * @return um clone da instância
     */
    <T extends Object> T clone(final Log log);
}
