/**
 * 
 */
package cl.ejercicio.java.service;

import cl.ejercicio.java.dto.RequestDTO;
import cl.ejercicio.java.dto.UserDTO;
import cl.ejercicio.java.exception.EmailFormatException;
import cl.ejercicio.java.exception.EmailRegisterException;
import cl.ejercicio.java.exception.PasswordFormatException;

/**
 * @author alvaro maldonado
 *
 */
public interface UserService {
	public UserDTO ingresarUsuario(RequestDTO request)
			throws PasswordFormatException, EmailRegisterException, EmailFormatException;
}
