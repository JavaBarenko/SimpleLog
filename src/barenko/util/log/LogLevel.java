package barenko.util.log;

/**
 * Representa��o dos poss�veis n�veis de Log.<br>
 * Os n�veis de log s�o cumulativos, ou seja: Um determinado n�vel habilita si mesmo e todos os outros n�veis com
 * valores MENORES que o dele.<br>
 * <br>
 * Exemplo:<br>
 * O n�vel {@link LogLevel#ERROR} habilita tamb�m os n�veis {@link LogLevel#FATAL} e {@link LogLevel#OFF}.
 * 
 * @author Rafael Caetano Pinto
 */
public enum LogLevel {
    /**
     * Desativa a exibi��o de logs
     */
    OFF(0x0,
	"Log desativado"),
    /**
     * Habilita apenas os logs fatais
     */
    FATAL(0x1,
	  "Apenas erros fatais (que obriguem a fechar ou n�o inicializar a aplica��o)"),
    /**
     * Habilita os logs de erro e fatais
     */
    ERROR(0x3,
	  "Erros normais, geralmente que disparam Exceptions"),
    /**
     * Habilita apenas os logs de aviso, de erro e fatais
     */
    WARNING(0x7,
	    "Avisos e alertas"),
    /**
     * Habilita apenas os logs de informa��o, de aviso, de erro e fatais
     */
    INFO(0xf,
	 "Informa��es gerais"),
    /**
     * Habilita apenas os logs de debug, de informa��o, de aviso, de erro e fatais
     */
    DEBUG(0x1f,
	  "Informa��es espec�ficas para debug"),
    /**
     * Habilita os logs de trace, de debug, de informa��o, de aviso, de erro e fatais
     */
    TRACE(0x3f,
	  "Informa��es detalhadas de debug"),
    /**
     * Habilita todos n�veia de logs
     */
    ALL(0xff,
	"Ativa todos os n�veis de log");
    private final int level;
    private final String description;

    private LogLevel(final int levelNumber, final String description) {
	this.level = levelNumber;
	this.description = description;
    }

    /**
     * Obt�m o c�digo equivalente ao n�vel
     * 
     * @return o c�digo do n�vel
     */
    public int getCode() {
	return this.level;
    }

    /**
     * Obt�m a descri��o do n�vel de log
     * 
     * @return A descri��o do n�vel de log
     */
    public String getDescription() {
	return this.description;
    }

    public boolean isLoggable(final LogLevel level) {
	return this.level >= level.level;
    }
}
