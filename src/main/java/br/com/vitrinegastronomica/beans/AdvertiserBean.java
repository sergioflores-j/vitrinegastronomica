package br.com.vitrinegastronomica.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.Session;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.vitrinegastronomica.daos.AdvertiserDao;
import br.com.vitrinegastronomica.infra.FileSaver;
import br.com.vitrinegastronomica.models.Advertiser;
import br.com.vitrinegastronomica.utils.HashGenerator;

@Model
public class AdvertiserBean {
	@Inject
	private AdvertiserDao dao;
	@Inject
	private FacesContext context;
	private Advertiser advertiser = new Advertiser();
	private Part logo;
	
	@Transactional
	public String save() throws IOException {
		System.out.println("LOGO ==> " + logo);
		System.out.println("Advertiser ==> " + advertiser);

		advertiser.setPassword(new HashGenerator().generateHash(advertiser.getPassword()));

		/**
		 * PEGA UMA INSTANCIA DO FILE SAVER E SETA O CAMINHO QUE ELE RETORNA
		 * PARA O imgPath (logo ou foto de perfil do usuário)
		 */
		FileSaver fileSaver = new FileSaver();
		/*
		 * OBS: NÃO IRÁ CRIAR CASO NÃO EXISTA A PASTA DEFINIDA NO SERVIDOR,
		 * JUNÇÃO ENTRE O "SERVER_PATH" E O relativePath
		 */
		advertiser.setImgPath(fileSaver.write(logo, "advertisers"));

		System.out.println("ADVERTISER PARA SALVAR ==> " + advertiser);

		dao.save(advertiser);

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Sucesso ao realizar o seu cadastro! ",
				advertiser.getName() + " para continuar, efetue o login."));

		return "/index?faces-redirect=true";

	}
	
	public String logout() {
		context.getExternalContext().invalidateSession();
		System.out.println("CASTOUAQUI");
		return "/index?faces-redirect=true";
	}

	public Advertiser getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

	public Part getLogo() {
		return logo;
	}

	public void setLogo(Part logo) {
		this.logo = logo;
	}
	
	
	
	public Advertiser testeList(){
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		Advertiser adv = (Advertiser) session.getAttribute("advertiser");
		Advertiser obj = new Advertiser();
		
		if((session != null) && (adv != null)){
			obj = (Advertiser) dao.findById(adv);
			
		}else{
			System.out.println("DEU MERDA CAROLINA, DEU MERDA");
		}
		
		return obj;
		
	}
	
	public String nameo(){
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		Advertiser adv = (Advertiser) session.getAttribute("advertiser");
		
		System.out.println("SESSIONNN"  + session.getAttribute("advertiser") );
		
		System.out.println("ADV" + adv );
		
		return adv.getName();
		
		
	}
}
