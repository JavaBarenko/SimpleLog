package barenko.util.log;

import java.util.List;
import barenko.util.log.appender.Appender;
import barenko.util.log.appender.exception.AppenderException;

/**
 * Modelo de configuração dos logs.<br>
 * Todas as configurações passadas para o log durante sua criação é realizada por essa interface.
 * 
 * @author Rafael Caetano Pinto
 */
public interface LogConfig {
    /**
     * Configura o nível do Log
     * @param level
     *            O novo nível do log
     */
    void setLevel(final LogLevel level);

    /**
     * Obtém o nivel atual do log
     * @return o nivel atual do log
     */
    LogLevel getLevel();

    /**
     * Obtém todos os {@link Appender}'s configurados para o nível atual do log
     * 
     * @return Os appenders do nivel atual de log
     */
    List<Appender> getCurrentAppenders();

    /**
     * Obtém todos os {@link Appender}'s configurados para o nível especificado de log
     * 
     * @return Os appenders do nivel especificado de log
     */
    List<Appender> getAppenders(final LogLevel level);

    /**
     * Configura os appenders que serão utilizados em determinado nível de log. <br>
     * Caso não sejam configurados, serão utilizados os appenders padrões (configurados durante a instanciação do log.
     * 
     * @param level
     *            O nível de log que terá seus appenders configurados
     * @param appenders
     *            Os appenders que serão utilizados quando o nível espepecificado estiver sendo utilizado
     * @throws AppenderException
     *             Se ocorrer algum erro durante o fechamento dos antigos appenders (se houver).
     */
    void setAppenders(final LogLevel level, List<Appender> appenders) throws AppenderException;

    /**
     * Configura os appenders que serão utilizados em determinado nível de log. <br>
     * Caso não sejam configurados, serão utilizados os appenders padrões (configurados durante a instanciação do log.
     * 
     * @param level
     *            O nível de log que terá seus appenders configurados
     * @param appenders
     *            Os appenders que serão utilizados quando o nível espepecificado estiver sendo utilizado
     * @throws AppenderException
     *             Se ocorrer algum erro durante o fechamento dos antigos appenders (se houver).
     */
    void setAppenders(final LogLevel level, final Appender... appenders) throws AppenderException;

    /**
     * Configura um cabeçalho comum para todos os layouts de todos os appenders do log
     * 
     * @param header
     *            o novo cabeçalho
     */
    void setHeader(String header);
}
