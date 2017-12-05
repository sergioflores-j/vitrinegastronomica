package br.com.vitrinegastronomica.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.vitrinegastronomica.daos.ProductDao;
import br.com.vitrinegastronomica.models.Product;

@Model
public class ProductDetailBean {

	@Inject
	private ProductDao dao;

	private Product product;

	private Long id;

	public void loadDetail() {
		this.setProduct(dao.findById(id));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
