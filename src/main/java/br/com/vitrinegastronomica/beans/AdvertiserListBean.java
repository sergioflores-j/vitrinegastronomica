package br.com.vitrinegastronomica.beans;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.vitrinegastronomica.daos.AdvertiserDao;
import br.com.vitrinegastronomica.models.Advertiser;

@Model
public class AdvertiserListBean {
	@Inject
	private AdvertiserDao dao;
	@Inject
	private FacesContext context;
	private Advertiser advertiser = new Advertiser();
	
	public Advertiser getAdvertiser(){
		System.out.println("CHAMADA METODO LISTBEAN");
		
		Advertiser adv =  (Advertiser) context.getExternalContext().getSessionMap().get("advertiser");
		System.out.println("ADV:" + adv);
		
		if(adv != null) {
			return adv;
		} else {
			return null;
		}
	}
	
	public Advertiser findById(){
		Advertiser a = this.getAdvertiser();
		return dao.findById(a);
	}
	
}
