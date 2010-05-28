package barenko.util.log;

/**
 * Representação dos possíveis níveis de Log.<br>
 * Os níveis de log são cumulativos, ou seja: Um determinado nível habilita si mesmo e todos os outros níveis com
 * valores MENORES que o dele.<br>
 * <br>
 * Exemplo:<br>
 * O nível {@link LogLevel#ERROR} habilita também os níveis {@link LogLevel#FATAL} e {@link LogLevel#OFF}.
 * 
 * @author Rafael Caetano Pinto
 */
public enum LogLevel {
    /**
     * Desativa a exibição de logs
     */
    OFF(0x0,
	"Log desativado"),
    /**
     * Habilita apenas os logs fatais
     */
    FATAL(0x1,
	  "Apenas erros fatais (que obriguem a fechar ou não inicializar a aplicação)"),
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
     * Habilita apenas os logs de informação, de aviso, de erro e fatais
     */
    INFO(0xf,
	 "Informações gerais"),
    /**
     * Habilita apenas os logs de debug, de informação, de aviso, de erro e fatais
     */
    DEBUG(0x1f,
	  "Informações específicas para debug"),
    /**
     * Habilita os logs de trace, de debug, de informação, de aviso, de erro e fatais
     */
    TRACE(0x3f,
	  "Informações detalhadas de debug"),
    /**
     * Habilita todos níveia de logs
     */
    ALL(0xff,
	"Ativa todos os níveis de log");
    private final int level;
    private final String description;

    private LogLevel(final int levelNumber, final String description) {
	this.level = levelNumber;
	this.description = description;
    }

    /**
     * Obtém o código equivalente ao nível
     * 
     * @return o código do nível
     */
    public int getCode() {
	return this.level;
    }

    /**
     * Obtém a descrição do nível de log
     * 
     * @return A descrição do nível de log
     */
    public String getDescription() {
	return this.description;
    }

    public boolean isLoggable(final LogLevel level) {
	return this.level >= level.level;
    }
}
