package br.com.vitrinegastronomica.view.beans;

import javax.faces.bean.ManagedBean;

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
 
}
