package br.com.vitrinegastronomica.daos;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDao<T> implements Dao<T> {

	private final Class<T> entity;

	@PersistenceContext
	protected static EntityManager em;

	@SuppressWarnings("unchecked")
	public GenericDao(Class<T> entity) {
		this.entity = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void save(T t) {
		em.persist(t);
	}

	public void delete(T t) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			// em.remove(em.getReference(this.entity, t.getId()));
			em.remove(em.merge(t));
			tx.commit();
		} catch (Exception e) {
			em.clear();
			tx.rollback();
			throw e;
		}
		this.resetConnection();
	}

	public void update(T t) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(t);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
		this.resetConnection();
	}

	public List<T> listAll() {
		Query query = em.createQuery("select t from " + entity.getName() + " t ");
		List<T> list = query.getResultList();
		return list;
	}

	public List<T> listAllWPagination(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(entity);
		query.select(query.from(entity));

		List<T> list = em.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();

		em.close();
		return list;
	}

	public T findById(Long id) {
		return (T) em.find(entity, id);
	}

	public void resetConnection() {
		em.close();
	}

}
