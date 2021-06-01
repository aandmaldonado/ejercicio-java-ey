/**
 * 
 */
package cl.ejercicio.java.util;

/**
 * @author alvaro maldonado
 *
 */
public class Constants {
//	PATTERN
	public static final String PATTERN_EMAIL = "^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$";
	public static final String PATTERN_PASSWORD = "^([A-Z]{1})+(.*[a-z])+([0-9]{2})$";

//	MENSAJES
	public static final String ERR_CORREO_REG = "El correo ya esta registrado";
	public static final String ERR_FORMATO_CORREO = "El correo no cumple formato correcto. (aaaaaaa@dominio.cl)";
	public static final String ERR_FORMATO_PASSWORD = "La clave no cumple formato correcto. (Una Mayuscula, letras minusculas y dos numeros)";
	public static final String INGRESO_OK = "Usuario ingresado correctamente";

}
