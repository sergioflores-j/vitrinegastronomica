package br.com.vitrinegastronomica.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.vitrinegastronomica.models.Advertiser;

public class AdvertiserDao {

	@PersistenceContext
	private EntityManager em;

	public List<Advertiser> listAll() {
		return em.createQuery("select u from Advertiser u", Advertiser.class).getResultList();
	}

	public Advertiser findByLogin(Advertiser a) {
		TypedQuery<Advertiser> query = em.createQuery(
				"SELECT u FROM Advertiser u WHERE u.email = :pEmail AND u.password = :pPassword", Advertiser.class);
		query.setParameter("pEmail", a.getEmail());
		query.setParameter("pPassword", a.getPassword());

		try {
			Advertiser result = query.getSingleResult();

			System.out.println("O USUÁRIO ENCONTRADO É " + result);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public void save(Advertiser advertiser) {
		em.persist(advertiser);
	}
	
	public List<Advertiser> findById(Advertiser a){
		System.err.println("LIST DAO");
		
		TypedQuery<Advertiser> query = em.createQuery("SELECT a FROM Advertiser a WHERE a.id = 1" , Advertiser.class);
		//query.setParameter("pId", a.getId());
		
		try{
			List<Advertiser> list = query.getResultList();
			
			System.out.println("ENCONTROUUUUU: " + list.get(0).getName());
			System.out.println("ENCONTROUUUUU222: " + list);
			return list;
			
		}catch(Exception e){
			e.printStackTrace();
			
			System.out.println("ERROOOOOOOO ");
			return null;
		}
	}
	
	public Advertiser findId(long id){
		return em.find(Advertiser.class, id);
	}
	
	
}
