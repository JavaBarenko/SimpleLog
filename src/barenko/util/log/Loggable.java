package barenko.util.log;

/**
 * Representa as classes capazes de configurar o próprio log externamente.
 * 
 * @author Rafael Caetano Pinto
 */
public interface Loggable {
    /**
     * Configura o log que será utilizado
     * 
     * @param log
     */
    void setLog(Log log);

    /**
     * Obtém o log utilizado
     * 
     * @return o log
     */
    Log getLog();
}
