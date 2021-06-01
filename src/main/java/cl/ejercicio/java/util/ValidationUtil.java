/**
 * 
 */
package cl.ejercicio.java.util;

/**
 * @author alvaro maldonado
 *
 */
public class ValidationUtil {
	/**
	 * El correo debe seguir una expresion regular para validar que formato sea el
	 * correcto. (aaaaaaa@dominio.cl)
	 * 
	 * @param correo Email a validar
	 * @return
	 */
	public static Boolean validaEmail(String correo) {
		return correo.matches(Constants.PATTERN_EMAIL);
	}

	/**
	 * La clave debe seguir una expresion regular para validar que formato sea el
	 * correcto. (Una Mayuscula, letras minusculas, y dos numeros)
	 * 
	 * @param clave Password a validar
	 * @return
	 */
	public static Boolean validaPassword(String clave) {
		return clave.matches(Constants.PATTERN_PASSWORD);
	}
}
