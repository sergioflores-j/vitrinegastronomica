package br.com.vitrinegastronomica.view.beans;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@Named
public class CategoryView {
	private long id;
	private String title;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
