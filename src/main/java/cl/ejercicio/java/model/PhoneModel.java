/**
 * 
 */
package cl.ejercicio.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author alvaro maldonado
 *
 */
@Entity
@Table(name = "phone")
public class PhoneModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_phone")
	private Long idPhone;

	@Column(name = "number")
	private String number;

	@Column(name = "cityCode")
	private String cityCode;

	@Column(name = "countryCode")
	private String countryCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	private UserModel userModel;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public Long getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(Long idPhone) {
		this.idPhone = idPhone;
	}

}
