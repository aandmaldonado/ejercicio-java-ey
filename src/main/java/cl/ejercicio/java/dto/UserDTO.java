/**
 * 
 */
package cl.ejercicio.java.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author alvaro maldonado
 *
 */
@Getter
@Setter
public class UserDTO {

	private String idUser;
	private Date created;
	private Date modified;
	private Date lastLogin;
	private String token;
	private boolean isActive;

}
