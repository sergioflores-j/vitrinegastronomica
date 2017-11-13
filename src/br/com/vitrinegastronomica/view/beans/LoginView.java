package br.com.vitrinegastronomica.view.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import br.com.vitrinegastronomica.daos.UserDao;
import br.com.vitrinegastronomica.models.User;

@ManagedBean
public class LoginView{
	private User user = new User();

	public User getUser() {
		return user;
	}

	public String login(ActionEvent event) {
		System.out.println("User " + this.user.getEmail());
		
		boolean exists = new UserDao().find(this.user);
		if (exists) {
			System.out.println("EXISTE =)");
			return "";
		}
		
		System.out.println("NÃO EXISTE =)");
		return null;
//		RequestContext context = RequestContext.getCurrentInstance();
//		FacesMessage message = null;
//		boolean loggedIn = false;
//
//		if (email != null && email.equals("admin") && password != null && password.equals("admin")) {
//			loggedIn = true;
//			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo!", email);
//		} else {
//			loggedIn = false;
//			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! Seu email e/ou senha estão inválidos, digite novamente!", "");
//		}
//
//		FacesContext.getCurrentInstance().addMessage(null, message);
//		context.addCallbackParam("loggedIn", loggedIn);
		
//		System.out.println("CONTEXT ===> " + context);
	}

}
