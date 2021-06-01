/**
 * 
 */
package cl.ejercicio.java.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author alvaro maldonado
 *
 */
@Data
@Entity
@Table(name = "user")
public class UserModel {
	@Id
	@Column(name = "id_user")
	private String idUser;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "created")
	private Date created;

	@Column(name = "modified")
	private Date modified;

	@Column(name = "last_login")
	private Date lastLogin;

	@Column(name = "token",length = 400)
	private String token;

	@Column(name = "isactive")
	private Boolean isActive;

	@OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
	private List<PhoneModel> phones = new ArrayList<>();

}
