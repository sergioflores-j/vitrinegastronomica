package br.com.vitrinegastronomica.view.dao;

import javax.annotation.ManagedBean;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.vitrinegastronomica.view.entities.Advertiser;
import br.com.vitrinegastronomica.view.utils.PersistenceUtils;

@ManagedBean
public class AdvertiserDao {
	private static AdvertiserDao dao;
	 private EntityManager em;
	 
	 public static AdvertiserDao getInstance(){
		 if(dao == null){
			 dao = new AdvertiserDao();
		 }
		 
		 return dao;
	 }
	 
	 private AdvertiserDao(){
		 em = PersistenceUtils.getEntityManager();
	 }
	 
	 public void save(Advertiser a){
		 try{
			 em.getTransaction().begin();
			 	em.persist(a);
			 em.getTransaction().commit();
		 }catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	 }
	 
}
