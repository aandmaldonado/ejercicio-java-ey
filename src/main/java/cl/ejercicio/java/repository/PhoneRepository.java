/**
 * 
 */
package cl.ejercicio.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.ejercicio.java.model.PhoneModel;

/**
 * @author Administrador
 *
 */
@Repository
public interface PhoneRepository extends JpaRepository<PhoneModel, Long> {

}
