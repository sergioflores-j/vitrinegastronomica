package br.com.vitrinegastronomica.beans;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;

import org.primefaces.event.FlowEvent;

import br.com.vitrinegastronomica.infra.FileSaver;
import br.com.vitrinegastronomica.models.Advertiser;

@ManagedBean
@ViewScoped
public class AdvertiserWizard {

	private Advertiser advertiser = new Advertiser();

	private boolean skip;
	private Part logo;
	
	public void save() throws IOException, NoSuchAlgorithmException {
		System.out.println("ESTE É O USUÁRIO ===>" + advertiser);
		System.out.println("ESTE É O ARQUIVO ===>" + logo);

//		AdvertiserBean advertiserBean = new AdvertiserBean(advertiser, logo);

//		advertiserBean.save(advertiserBean.getAdvertiser(), advertiserBean.getLogo());
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public Part getLogo() {
		return logo;
	}

	public void setLogo(Part logo) {
		this.logo = logo;
		FileSaver fileSaver = new FileSaver();
		/*
		 * OBS: NÃO IRÁ CRIAR CASO NÃO EXISTA A PASTA DEFINIDA NO
		 * SERVIDOR, JUNÇÃO ENTRE O "SERVER_PATH" E O relativePath
		 */
		advertiser.setImgPath(fileSaver.write(logo, "advertisers"));
	}

	public Advertiser getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

}
