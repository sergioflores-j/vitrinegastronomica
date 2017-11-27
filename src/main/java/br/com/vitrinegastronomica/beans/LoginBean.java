package br.com.vitrinegastronomica.beans;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.vitrinegastronomica.daos.AdvertiserDao;
import br.com.vitrinegastronomica.models.Advertiser;
import br.com.vitrinegastronomica.utils.HashGenerator;

@Model
public class LoginBean {

	private Advertiser advertiser = new Advertiser();
	@Inject
	private AdvertiserDao dao;
	@Inject
	private FacesContext context;

	public String login() {
		advertiser.setPassword(new HashGenerator().generateHash(advertiser.getPassword()));
		
		Advertiser a = dao.findByLogin(advertiser);
		
		System.out.println("ADVERTISER ===> " + a);
		
		if (a == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Login e/ou senha inválidos!", "Tente novamente."));
			advertiser = new Advertiser();
			return null;
		} else {
			context.getExternalContext().getSessionMap().put("advertiser", advertiser);
			return "/advertiser/profile?faces-redirect=true";
		}
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index?faces-redirect=true";
	}

	public Advertiser getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

}
