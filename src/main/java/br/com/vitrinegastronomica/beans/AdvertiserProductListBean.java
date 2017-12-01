package br.com.vitrinegastronomica.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.vitrinegastronomica.daos.ProductDao;
import br.com.vitrinegastronomica.models.Advertiser;
import br.com.vitrinegastronomica.models.Product;

@Model
public class AdvertiserProductListBean {
	@Inject
	private ProductDao dao;
	@Inject
	private FacesContext context;

	private Advertiser advertiser = new Advertiser();

	private List<Product> products = new ArrayList<>();

	public Advertiser getAdvertiser() {
		Advertiser adv = (Advertiser) context.getExternalContext().getSessionMap().get("advertiser");
		System.out.println("ADV:" + adv);

		if (adv != null) {
			return adv;
		} else {
			return null;
		}
	}

	public List<Product> getProducts() {
		Advertiser a = this.getAdvertiser();
		return dao.findByAdvertiserId(a);
	}

}
