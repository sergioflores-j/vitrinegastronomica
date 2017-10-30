package br.com.vitrinegastronomica.view.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean
public class LoginView {

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login(ActionEvent event) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;

		if (email != null && email.equals("admin") && password != null && password.equals("admin")) {
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo!", email);
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! Seu email e/ou senha estão inválidos, digite novamente!", "");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", loggedIn);
	}

}
