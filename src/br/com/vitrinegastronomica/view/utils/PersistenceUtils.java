package br.com.vitrinegastronomica.view.utils;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
public class PersistenceUtils {
	private static EntityManagerFactory emf;
	
	 private PersistenceUtils() {
		 super();
	 }
	 
	 public static EntityManager getEntityManager() {
		 if (emf == null) {
			 emf = Persistence.createEntityManagerFactory("vitrinegastronomicaPU");
		 }
			  return emf.createEntityManager();
	 }
	 
	 public static void closeEntityManager(EntityManager em){
		if(em != null){
			em.close();
		}
	}	 
}
