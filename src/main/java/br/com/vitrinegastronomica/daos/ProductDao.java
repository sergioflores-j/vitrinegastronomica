package br.com.vitrinegastronomica.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.vitrinegastronomica.models.Advertiser;
import br.com.vitrinegastronomica.models.Product;

public class ProductDao {

	@PersistenceContext
	private EntityManager em;

	public List<Product> listAll() {
		String jpql = "select distinct(p) from Product p join fetch p.category";
		return em.createQuery(jpql, Product.class).getResultList();
	}
	
	public List<Product> findByAdvertiserId(Advertiser a){
		TypedQuery<Product> query = em.createQuery(
				"SELECT distinct(p) FROM Product p JOIN FETCH p.category WHERE advertiser_id = :aId", Product.class);
		query.setParameter("aId", a.getId());
		
		List<Product> result = query.getResultList();
		
		return result;
	}

	public void save(Product product) {
		em.persist(product);
	}
}
