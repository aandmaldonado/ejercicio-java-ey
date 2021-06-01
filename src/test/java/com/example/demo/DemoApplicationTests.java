package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import cl.ejercicio.java.controller.UserController;
import cl.ejercicio.java.dto.RequestDTO;
import cl.ejercicio.java.dto.UserDTO;
import cl.ejercicio.java.exception.EmailFormatException;
import cl.ejercicio.java.exception.EmailRegisterException;
import cl.ejercicio.java.exception.PasswordFormatException;
import cl.ejercicio.java.jwt.GenerateTokenJwt;
import cl.ejercicio.java.model.UserModel;
import cl.ejercicio.java.service.UserService;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
class DemoApplicationTests {
	@InjectMocks
	private UserController controller;

	@Mock
	private UserService userMock;

	@Mock
	public GenerateTokenJwt tokenMock;

	@Test
	public void contextLoads() throws PasswordFormatException, EmailRegisterException, EmailFormatException {
		log.info("Validamos servicio de registro usuario");
		ResponseEntity<?> response;

		RequestDTO req = new RequestDTO();
		req.setName("alvaro maldonado");
		req.setEmail("alvaro.maldonado1988@gmail.com");
		req.setPassword("Amp200488");
		req.setPhones(new ArrayList<>());

		UserDTO userDTO = new UserDTO();
		userDTO.setIdUser(UUID.randomUUID().toString());
		userDTO.setActive(Boolean.TRUE);

		UserModel user = new UserModel();
		user.setIdUser(userDTO.getIdUser());
		user.setIsActive(userDTO.isActive());

		when(userMock.ingresarUsuario(req)).thenReturn(userDTO);
		when(tokenMock.generateToken(user)).thenReturn("ueyegdyueu");

		response = controller.ingresarUsuario(req);

		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		log.info("Fin test");
	}

}
