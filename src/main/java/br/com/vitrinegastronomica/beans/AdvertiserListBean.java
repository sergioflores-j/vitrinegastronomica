package br.com.vitrinegastronomica.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import br.com.vitrinegastronomica.daos.AdvertiserDao;
import br.com.vitrinegastronomica.models.Advertiser;

@Model
public class AdvertiserListBean {
	@Inject
	private AdvertiserDao dao;
	@Inject
	private FacesContext context;
	private List<Advertiser> advertiser = new ArrayList<>();
	
	public List<Advertiser> getAdvertiser(){
		System.out.println("CHAMADA METODO LISTBEAN");
		
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		Advertiser adv = (Advertiser) session.getAttribute("advertiser");
		System.out.println("ADV:" + adv);
		
		this.advertiser = dao.findById(adv);
		
		if((session != null) && (adv != null)){
			advertiser = dao.findById(adv);
			
			System.out.println("ADVERTISER: " + advertiser);
			
		}else{
			System.out.println("DEU MERDA CAROLINA, DEU MERDA");
		}
		
		return advertiser;
		
	}
	
	public Advertiser testeList(){
		HttpSession session = (HttpSession) context.getExternalContext().getSessionMap();
		Advertiser adv =  (Advertiser) session.getAttribute("advertiser");
		Advertiser adve = new Advertiser();
		
		if((session != null) && (adv != null)){
			adve = dao.findById(adv).get(0);
			
		}else{
			System.out.println("DEU MERDA CAROLINA, DEU MERDA");
		}
		
		return adve;
		
	}
	
	public Advertiser buscar(){
		return dao.findId(1);
	}
	
}
