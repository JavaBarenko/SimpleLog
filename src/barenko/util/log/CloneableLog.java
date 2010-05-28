package barenko.util.log;

/**
 * Clona a inst�ncia para utiliza��o de um novo log
 * 
 * @author Rafael Caetano Pinto
 */
public interface CloneableLog extends java.lang.Cloneable, Loggable {
    /**
     * Clona o objeto, permitindo alterar apenas o log.
     * 
     * @param log
     *            O novo log que ser� utilizado
     * @return um clone da inst�ncia
     */
    <T extends Object> T clone(final Log log);
}
