/**
 * 
 */
package cl.ejercicio.java.jwt;

import java.util.HashMap;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;
import cl.ejercicio.java.model.UserModel;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

/**
 * @author alvaro maldonado
 *
 */
@Slf4j
@Component
public class GenerateTokenJwt {
	public String generateToken(UserModel user) {
		try {
			SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
			SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

			HashMap<String, Object> header = new HashMap<String, Object>();
			header.put("alg", signatureAlgorithm.toString());
			header.put("typ", "JWT");

			JwtBuilder tokenJWT = Jwts.builder().setHeader(header).setId("1").claim("idUser", user.getIdUser())
					.claim("name", user.getName()).claim("email", user.getEmail()).signWith(key);

			String tokenJWTString = tokenJWT.compact();
			log.info("token: {}", tokenJWTString);

			return tokenJWTString;
		} catch (Exception e) {
			log.error("Error al crear token JWT: ", e);
			return null;
		}
	}
}
