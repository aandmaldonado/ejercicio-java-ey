/**
 * 
 */
package cl.ejercicio.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.ejercicio.java.model.UserModel;

/**
 * @author alvaro maldonado
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	UserModel findByEmail(String email);
}
