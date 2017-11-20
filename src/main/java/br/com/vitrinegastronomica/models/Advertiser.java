package br.com.vitrinegastronomica.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Advertiser {

	/* Basic Info */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String imgPath;
	@Lob
	@NotBlank
	@Length(min = 8)
	private String description;
	/* Login Info */
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	/* Contato */
	@NotBlank
	@Length(min = 10)
	private String tel1;
	@Length(min = 10)
	private String tel2;
	/* Endereço */
	@NotBlank
	private String country;
	@NotBlank
	private String state;
	@NotBlank
	private String city;
	@NotBlank
	private String neighborhood;
	@NotBlank
	private String Street;
	@NotBlank
	private Long number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Advertiser [id=" + id + ", name=" + name + ", imgPath=" + imgPath + ", description=" + description
				+ ", email=" + email + ", password=" + password + ", tel1=" + tel1 + ", tel2=" + tel2 + ", country="
				+ country + ", state=" + state + ", city=" + city + ", neighborhood=" + neighborhood + ", Street="
				+ Street + ", number=" + number + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Advertiser other = (Advertiser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
