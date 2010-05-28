package barenko.util.log;

import java.util.List;
import barenko.util.log.appender.Appender;
import barenko.util.log.appender.exception.AppenderException;

/**
 * Modelo de configura��o dos logs.<br>
 * Todas as configura��es passadas para o log durante sua cria��o � realizada por essa interface.
 * 
 * @author Rafael Caetano Pinto
 */
public interface LogConfig {
    /**
     * Configura o n�vel do Log
     * @param level
     *            O novo n�vel do log
     */
    void setLevel(final LogLevel level);

    /**
     * Obt�m o nivel atual do log
     * @return o nivel atual do log
     */
    LogLevel getLevel();

    /**
     * Obt�m todos os {@link Appender}'s configurados para o n�vel atual do log
     * 
     * @return Os appenders do nivel atual de log
     */
    List<Appender> getCurrentAppenders();

    /**
     * Obt�m todos os {@link Appender}'s configurados para o n�vel especificado de log
     * 
     * @return Os appenders do nivel especificado de log
     */
    List<Appender> getAppenders(final LogLevel level);

    /**
     * Configura os appenders que ser�o utilizados em determinado n�vel de log. <br>
     * Caso n�o sejam configurados, ser�o utilizados os appenders padr�es (configurados durante a instancia��o do log.
     * 
     * @param level
     *            O n�vel de log que ter� seus appenders configurados
     * @param appenders
     *            Os appenders que ser�o utilizados quando o n�vel espepecificado estiver sendo utilizado
     * @throws AppenderException
     *             Se ocorrer algum erro durante o fechamento dos antigos appenders (se houver).
     */
    void setAppenders(final LogLevel level, List<Appender> appenders) throws AppenderException;

    /**
     * Configura os appenders que ser�o utilizados em determinado n�vel de log. <br>
     * Caso n�o sejam configurados, ser�o utilizados os appenders padr�es (configurados durante a instancia��o do log.
     * 
     * @param level
     *            O n�vel de log que ter� seus appenders configurados
     * @param appenders
     *            Os appenders que ser�o utilizados quando o n�vel espepecificado estiver sendo utilizado
     * @throws AppenderException
     *             Se ocorrer algum erro durante o fechamento dos antigos appenders (se houver).
     */
    void setAppenders(final LogLevel level, final Appender... appenders) throws AppenderException;

    /**
     * Configura um cabe�alho comum para todos os layouts de todos os appenders do log
     * 
     * @param header
     *            o novo cabe�alho
     */
    void setHeader(String header);
}
