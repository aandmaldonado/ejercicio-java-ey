package cl.ejercicio.java.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserPrincipal {

	private Long idUsuario;
	private String dscEmail;
	private String fullName;
	private String password;

}
