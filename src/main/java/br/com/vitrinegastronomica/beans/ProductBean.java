package br.com.vitrinegastronomica.beans;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.vitrinegastronomica.daos.CategoryDao;
import br.com.vitrinegastronomica.daos.ProductDao;
import br.com.vitrinegastronomica.infra.FileSaver;
import br.com.vitrinegastronomica.models.Advertiser;
import br.com.vitrinegastronomica.models.Category;
import br.com.vitrinegastronomica.models.Product;

@Model
public class ProductBean {
	@Inject
	private ProductDao dao;

	@Inject
	private CategoryDao categoryDao;
	@Inject
	private FacesContext context;

	private Product product = new Product();

	private Advertiser advertiser = new Advertiser();

	private List<Category> categories;

	private Part thumbnail;

	@Transactional
	public String save() throws IOException {

		FileSaver fileSaver = new FileSaver();
		product.setImgPath(fileSaver.write(thumbnail, "products"));
		product.setCreated_at(Calendar.getInstance());
		product.setAdvertiser(this.getAdvertiser());
		System.out.println("PRODUCT PARA SALVAR ==> " + product);

		dao.save(product);

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Sucesso ao realizar o cadastro do produto " + product.getTitle()));

		return "/advertiser/productsList?faces-redirect=true";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Part getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Part thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<Category> getCategories() {
		return categoryDao.listAll();
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Advertiser getAdvertiser() {
		Advertiser a = (Advertiser) context.getExternalContext().getSessionMap().get("advertiser");
		return a;
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

}
