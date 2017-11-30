package br.com.vitrinegastronomica.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.vitrinegastronomica.daos.ProductDao;
import br.com.vitrinegastronomica.models.Product;

@Model
public class ProductListBean {
	
	@Inject
	private ProductDao dao;
	
	private List<Product> products = new ArrayList<>();

	public List<Product> listAllProducts() {
		return dao.listAll();
	}

	public List<Product> getProducts() {
		this.products = dao.listAll();
		
		return products;
	}

}
