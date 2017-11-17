package br.com.vitrinegastronomica.view.beans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class ProductView {
	private long id;
	private String title;
	private String img;
	private String description;
	private long price;
	@Inject
	private CategoryView category;
	
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public CategoryView getCategory() {
		return category;
	}
	public void setCategory(CategoryView category) {
		this.category = category;
	}
	
	public void save(){
		ProductView p = new ProductView();
		
		p.setTitle(this.title);
		p.setDescription(this.description);
		p.setPrice(this.price);
		
		
	}
	
}
