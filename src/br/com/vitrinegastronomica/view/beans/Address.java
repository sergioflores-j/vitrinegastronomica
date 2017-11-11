package br.com.vitrinegastronomica.view.beans;

import javax.annotation.ManagedBean;

@ManagedBean
public class Address {
	private long id;
	private String country;
	private String state;
	private String city;
	private String neighborhood;
	private String Street;
	private long num;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getcountry() {
		return country;
	}
	public void setcountry(String country) {
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
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	} 
}
