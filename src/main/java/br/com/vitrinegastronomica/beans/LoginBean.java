package br.com.vitrinegastronomica.beans;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import br.com.vitrinegastronomica.daos.AdvertiserDao;
import br.com.vitrinegastronomica.models.Advertiser;

@Model
public class LoginBean {

	@Inject
	private AdvertiserDao dao;
	@Inject
	private FacesContext context;

	private Advertiser advertiser = new Advertiser();

	public String login(ActionEvent event) {
		boolean exists = dao.findByLogin(advertiser);
		if (exists) {
			System.out.println("EXISTE =)");

			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Você logou com sucesso!"));

			return "/index?faces-redirect=true";
		}

		System.out.println("NÃO EXISTE =)");
		return null;
		// RequestContext context = RequestContext.getCurrentInstance();
		// FacesMessage message = null;
		// boolean loggedIn = false;
		//
		// if (email != null && email.equals("admin") && password != null &&
		// password.equals("admin")) {
		// loggedIn = true;
		// message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo!",
		// email);
		// } else {
		// loggedIn = false;
		// message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! Seu
		// email e/ou senha estão inválidos, digite novamente!", "");
		// }
		//
		// FacesContext.getCurrentInstance().addMessage(null, message);
		// context.addCallbackParam("loggedIn", loggedIn);

		// System.out.println("CONTEXT ===> " + context);
	}

	public Advertiser getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

}
