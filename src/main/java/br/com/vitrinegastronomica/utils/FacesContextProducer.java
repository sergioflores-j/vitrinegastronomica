package br.com.vitrinegastronomica.utils;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextProducer {

	// Ensina o CDI a criar um FacesContext
	@RequestScoped
	@Produces
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}