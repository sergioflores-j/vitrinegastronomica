package br.com.vitrinegastronomica.beans;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import org.primefaces.event.FlowEvent;

import br.com.vitrinegastronomica.daos.AdvertiserDao;
import br.com.vitrinegastronomica.infra.FileSaver;
import br.com.vitrinegastronomica.models.Advertiser;

@Model
public class AdvertiserBean {
	@Inject
	private AdvertiserDao dao;
	@Inject
	private FacesContext context;
	
	public String image(){
		return "images/VG2.png";
	}
	
	
	
	@Transactional
	public String save(Advertiser advertiser, Part logo) throws NoSuchAlgorithmException, IOException {
		
		/**
		 * Pega a instancia do MD5 HASH
//		 */
//		MessageDigest m = MessageDigest.getInstance("MD5");
//		m.update(advertiser.getPassword().getBytes(), 0, advertiser.getPassword().length());
//		/*
//		 * SETA A SENHA PARA UM HASHCODE MD5
//		 */
//		advertiser.setPassword(new BigInteger(1, m.digest()).toString(16));

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

		/* SALVA NO BANCO */
		try {
			dao.save(advertiser);

			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Sucesso ao realizar cadastro",
					advertiser.getName() + " para continuar, efetue o login."));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Falha ao cadastrar, tente novamente mais tarde!"));
			throw new RuntimeException(e);
		}

		return "/index?faces-redirect=true";
	}

}
