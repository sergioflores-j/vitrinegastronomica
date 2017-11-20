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

	public boolean findByLogin(Advertiser a) {
		TypedQuery<Advertiser> query = em.createQuery(
				"SELECT u FROM Advertiser u WHERE u.email = :pEmail AND u.password = :pPassword", Advertiser.class);
		query.setParameter("pEmail", a.getEmail());
		query.setParameter("pPassword", a.getPassword());

		try {
			Advertiser result = query.getSingleResult();

			System.out.println("O USU�RIO ENCONTRADO � " + result);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
