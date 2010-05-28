package barenko.util.log;

/**
 * Representa as classes capazes de configurar o pr�prio log externamente.
 * 
 * @author Rafael Caetano Pinto
 */
public interface Loggable {
    /**
     * Configura o log que ser� utilizado
     * 
     * @param log
     */
    void setLog(Log log);

    /**
     * Obt�m o log utilizado
     * 
     * @return o log
     */
    Log getLog();
}
