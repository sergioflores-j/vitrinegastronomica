package br.com.vitrinegastronomica.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vitrinegastronomica.models.Category;


public class CategoryDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Category> listAll(){
		return em.createQuery("select c from Category c", Category.class).getResultList();
	}

}
