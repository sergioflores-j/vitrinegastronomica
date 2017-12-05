package br.com.vitrinegastronomica.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
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
		if (adv != null) {
			return adv;
		} else {
			return null;
		}
	}

	public List<Product> getProducts() {
		Advertiser a = this.getAdvertiser();
		List<Product> result = dao.findByAdvertiserId(a);
		
		if (result.isEmpty()) {
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Você ainda não registrou nenhum produto!"));
			return null;
		}
		
		return result;
	}

}
