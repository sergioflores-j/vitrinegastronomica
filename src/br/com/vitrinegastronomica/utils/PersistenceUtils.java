package br.com.vitrinegastronomica.utils;

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

	public static EntityManager getEntityManagerInstance() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("vitrinegastronomicaPU");
		}
		return emf.createEntityManager();
	}
	
	public static void close(EntityManager em) {
		if (em != null) {
			em.close();
		}
	}
}