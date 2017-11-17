package br.com.vitrinegastronomica.view.beans;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Delayed;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

import com.sun.mail.iap.Response;
 
@ManagedBean
@ViewScoped
public class Wizard implements Serializable {
	private AdvertiserView advertiser = new AdvertiserView();
	private ProductView product = new ProductView();
    private boolean skip;
    
    public AdvertiserView getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(AdvertiserView advertiser) {
		this.advertiser = advertiser;
	}

	public ProductView getProduct() {
		return product;
	}

	public void setProduct(ProductView product) {
		this.product = product;
	}

	public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }

	public void saveAdvertiser(){
		System.out.println("XXXXXXXXXXXXXXXXXX Save wizard XXXXXXXXXXXXXXXXXXXXXX");
        advertiser.save();
        LoginView log = new LoginView();
        log.setEmail(advertiser.getEmail());
        log.setPassword(advertiser.getPassword());
    }
	
	public void saveProduct(){
		product.save();
		redirect();
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