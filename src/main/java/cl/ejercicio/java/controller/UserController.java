/**
 * 
 */
package cl.ejercicio.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.ejercicio.java.dto.ErrorDTO;
import cl.ejercicio.java.dto.RequestDTO;
import cl.ejercicio.java.dto.UserDTO;
import cl.ejercicio.java.exception.EmailFormatException;
import cl.ejercicio.java.exception.EmailRegisterException;
import cl.ejercicio.java.exception.PasswordFormatException;
import cl.ejercicio.java.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author alvaro maldonado
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/registro")
	public ResponseEntity<?> ingresarUsuario(@RequestBody RequestDTO request) {
		UserDTO response;
		try {
			response = service.ingresarUsuario(request);
			if (response == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (PasswordFormatException | EmailRegisterException | EmailFormatException e) {
			log.error("Error al registrar usuario: ", e);
			return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
}
