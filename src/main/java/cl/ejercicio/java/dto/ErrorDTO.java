/**
 * 
 */
package cl.ejercicio.java.dto;

import lombok.Setter;

import lombok.Getter;

/**
 * @author alvaro maldonado
 *
 */
@Getter
@Setter
public class ErrorDTO {
	private String mensaje;

	public ErrorDTO(String mensaje) {
		this.mensaje = mensaje;
	}
}
