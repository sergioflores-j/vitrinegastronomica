package br.com.vitrinegastronomica.view.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.FlowEvent;

import br.com.vitrinegastronomica.view.dao.AdvertiserDao;
import br.com.vitrinegastronomica.view.entities.Advertiser;

@ManagedBean
public class AdvertiserView {
	@Inject
	private static AdvertiserDao dao;
	private long id;
	private String name;
	private String img;
	private String description;
	private String email;
	private String password;
	private String country;
	private String state;
	private String city;
	private String tel1;
	private String tel2;

	public static AdvertiserDao getDao() {
		return dao;
	}

	public static void setDao(AdvertiserDao dao) {
		AdvertiserView.dao = dao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public void save() {
		Advertiser ad = new Advertiser();
		
		ad.setName(this.name);
		ad.setDescription(this.description);
		ad.setEmail(this.email);
		ad.setPassword(this.password);
		ad.setCountry(this.country);
		ad.setState(this.state);
		ad.setCity(this.city);
		ad.setTel1(this.tel1);
		ad.setTel2(this.tel2);
		
		dao.save(ad);
		
	}
}
