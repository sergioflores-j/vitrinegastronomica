package br.com.vitrinegastronomica.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

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
	@Length(max = 50)
	private String description;
	/* Login Info */
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	/* Contato */
	@NotBlank
	@Length(min = 10, max = 17)
	private String phoneC;
	private String phoneT;
	/* Endere�o */
	@NotBlank
	private String country;
	@NotBlank
	private String state;
	@NotBlank
	private String city;
	private String neighborhood;
	private String street;
	@OneToMany(mappedBy = "advertiser", targetEntity = Product.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> products;

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

	public String getPhoneC() {
		return phoneC;
	}

	public void setPhoneC(String phoneC) {
		this.phoneC = phoneC;
	}

	public String getPhoneT() {
		return phoneT;
	}

	public void setPhoneT(String phoneT) {
		this.phoneT = phoneT;
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
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Advertiser [id=" + id + ", name=" + name + ", imgPath=" + imgPath + ", description=" + description
				+ ", email=" + email + ", password=" + password + ", phoneC=" + phoneC + ", phoneT=" + phoneT
				+ ", country=" + country + ", state=" + state + ", city=" + city + ", neighborhood=" + neighborhood
				+ ", street=" + street + "]";
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
