package br.com.vitrinegastronomica.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.vitrinegastronomica.models.User;
import br.com.vitrinegastronomica.utils.PersistenceUtils;

public class UserDao {

	public boolean find(User u) {
		EntityManager em = PersistenceUtils.getEntityManagerInstance();
		EntityTransaction tx = em.getTransaction();

		TypedQuery<User> query = em
				.createQuery("SELECT u FROM user u WHERE u.email = :pEmail AND u.password = :pPassword", User.class);
		query.setParameter("pEmail", u.getEmail());
		query.setParameter("pPassword", u.getPassword());

		try {
			User result = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		PersistenceUtils.close(em);
		return true;
	}

}
