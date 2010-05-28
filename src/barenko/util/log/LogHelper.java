package barenko.util.log;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class LogHelper {
    public static String NEW_LINE = "\n";

    /**
     * Retorna uma string de tamanho size com o conteúdo alinhado a esquerda
     * 
     * @param stringToPad
     *            String para ser alinhada
     * @param padder
     *            A string de preenchimento
     * @param size
     *            O tamanho total da string retornada
     * @return A stringToPad com o tamanho especificado e com os caracteres extras preenchidos com padder
     */
    public static String rightPad(final String stringToPad, final String padder, final int size) {
	if (padder.length() == 0) { return stringToPad; }
	final StringBuffer strb = new StringBuffer(stringToPad);
	final StringCharacterIterator sci = new StringCharacterIterator(padder);

	while (strb.length() < size) {
	    for (char ch = sci.first(); ch != CharacterIterator.DONE; ch = sci.next()) {
		if (strb.length() < size) {
		    strb.append(String.valueOf(ch));
		}
	    }
	}
	return strb.toString();
    }

    /**
     * Retorna uma string de tamanho size com o conteúdo alinhado a direita
     * 
     * @param stringToPad
     *            String para ser alinhada
     * @param padder
     *            A string de preenchimento
     * @param size
     *            O tamanho total da string retornada
     * @return A stringToPad com o tamanho especificado e com os caracteres extras preenchidos com padder
     */
    public static String leftPad(final String stringToPad, final String padder, final int size) {
	if (padder.length() == 0) { return stringToPad; }
	final StringBuffer strb = new StringBuffer(size);
	final StringCharacterIterator sci = new StringCharacterIterator(padder);

	while (strb.length() < (size - stringToPad.length())) {
	    for (char ch = sci.first(); ch != CharacterIterator.DONE; ch = sci.next()) {
		if (strb.length() < size - stringToPad.length()) {
		    strb.insert(strb.length(), String.valueOf(ch));
		}
	    }
	}
	return strb.append(stringToPad).toString();
    }

}
