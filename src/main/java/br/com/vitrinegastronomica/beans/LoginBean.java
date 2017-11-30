package br.com.vitrinegastronomica.beans;

import java.util.Date;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.vitrinegastronomica.daos.AdvertiserDao;
import br.com.vitrinegastronomica.models.Advertiser;
import br.com.vitrinegastronomica.utils.CookieHelper;
import br.com.vitrinegastronomica.utils.HashGenerator;

@Model
public class LoginBean {

	private Advertiser advertiser = new Advertiser();
	@Inject
	private AdvertiserDao dao;
	@Inject
	private FacesContext context;

	CookieHelper cookieHelper = new CookieHelper();

	public String login() {
		advertiser.setPassword(new HashGenerator().generateHash(advertiser.getPassword()));

		Advertiser a = dao.findByLogin(advertiser);

		System.out.println("ADVERTISER ===> " + a);

		if (a == null) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Login e/ou senha inválidos!", "Tente novamente."));
			return null;
		} else {
			HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
			session.setAttribute("advertiser", a);

			cookieHelper.setCookie("session", new HashGenerator().generateHash(a.getEmail() + new Date()), 12000);

			System.out.println("SESSION GERADA ==> " + session.getAttribute("advertiser"));
		}
		return "/index?faces-redirect=true";
	}

	public Advertiser getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

}
