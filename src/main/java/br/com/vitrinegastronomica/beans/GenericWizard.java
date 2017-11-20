package br.com.vitrinegastronomica.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
 
@ManagedBean
@ViewScoped
public class GenericWizard implements Serializable {
    private boolean skip;
    
    public GenericWizard(String classToInject){
    	
    }
    
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }

	public void save(){        
        FacesMessage msg = new FacesMessage("Sucesso ao realizar cadastro", "Bem vindo: ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void redirect(){
		try {
        	FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}