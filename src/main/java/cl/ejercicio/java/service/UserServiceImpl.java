/**
 * 
 */
package cl.ejercicio.java.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import cl.ejercicio.java.dto.PhoneDTO;
import cl.ejercicio.java.dto.RequestDTO;
import cl.ejercicio.java.dto.UserDTO;
import cl.ejercicio.java.exception.EmailFormatException;
import cl.ejercicio.java.exception.EmailRegisterException;
import cl.ejercicio.java.exception.PasswordFormatException;
import cl.ejercicio.java.jwt.GenerateTokenJwt;
import cl.ejercicio.java.model.PhoneModel;
import cl.ejercicio.java.model.UserModel;
import cl.ejercicio.java.repository.PhoneRepository;
import cl.ejercicio.java.repository.UserRepository;
import cl.ejercicio.java.util.Constants;
import cl.ejercicio.java.util.ValidationUtil;

/**
 * @author alvaro maldonado
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PhoneRepository phoneRepository;

	@Autowired
	public GenerateTokenJwt generateTokenJwt;

	@Override
	public UserDTO ingresarUsuario(RequestDTO request)
			throws PasswordFormatException, EmailRegisterException, EmailFormatException {
		String correo = request.getEmail();
		if (!correo.isEmpty() && ValidationUtil.validaEmail(correo)) {
			UserModel user = userRepository.findByEmail(correo);
			if (null == user) {
				String pass = request.getPassword();
				if (!pass.isEmpty() && ValidationUtil.validaPassword(pass)) {
					user = getUser(request);
					userRepository.save(user);
					if (null != request.getPhones() && !request.getPhones().isEmpty()) {
						List<PhoneModel> phones = getPhones(request, user);
						phoneRepository.saveAll(phones);
					}
					UserDTO userDTO = getUserDTO(user);
					return userDTO;
				} else {
					throw new PasswordFormatException(Constants.ERR_FORMATO_PASSWORD);
				}
			} else {
				throw new EmailRegisterException(Constants.ERR_CORREO_REG);
			}
		} else {
			throw new EmailFormatException(Constants.ERR_FORMATO_CORREO);
		}
	}

	private UserModel getUser(RequestDTO request) {
		UserModel user = new UserModel();
		user.setIdUser(UUID.randomUUID().toString());
		user.setCreated(new Date());
		user.setEmail(request.getEmail());
		user.setIsActive(Boolean.TRUE);
		user.setLastLogin(new Date());
		user.setModified(new Date());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setToken(generateTokenJwt.generateToken(user));
		return user;
	}

	private List<PhoneModel> getPhones(RequestDTO request, UserModel user) {
		List<PhoneModel> phones = new ArrayList<PhoneModel>();
		for (PhoneDTO phone : request.getPhones()) {
			PhoneModel phoneModel = new PhoneModel();
			phoneModel.setCityCode(phone.getCityCode());
			phoneModel.setCountryCode(phone.getCountryCode());
			phoneModel.setNumber(phone.getNumber());
			phoneModel.setUserModel(user);
			phones.add(phoneModel);
		}
		return phones;
	}

	private UserDTO getUserDTO(UserModel user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setIdUser(user.getIdUser());
		userDTO.setActive(user.getIsActive());
		userDTO.setToken(user.getToken());
		userDTO.setCreated(user.getCreated());
		userDTO.setLastLogin(user.getLastLogin());
		userDTO.setModified(user.getModified());
		return userDTO;
	}
}
