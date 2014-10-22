package de.th.wildau.im14.was.service;

import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class AbstractService<T> {

	@Inject
	protected Logger log;

	@Inject
	protected EntityManager em;

	@Inject
	protected Event<T> eventSrc;

	// public T find(Object primaryKey) {
	// return this.em.find(T.class, primaryKey);
	// }

	// public List<T> findAll() {
	// CriteriaBuilder cb = this.em.getCriteriaBuilder();
	// CriteriaQuery<T> criteria = cb.createQuery(T.class);
	// Root<T> types = criteria.from(T.class);
	// criteria.select(types);// .orderBy(cb.asc(member.get("name")));
	// return this.em.createQuery(criteria).getResultList();
	// }

	public void delete(final T entity) {
		this.log.info("delete: " + entity);
		this.em.remove(entity);
		this.eventSrc.fire(entity);
	}

	public T update(final T entity) {
		this.log.info("update: " + entity);
		T result = this.em.merge(entity);
		this.eventSrc.fire(entity);
		return result;
	}

	public void create(final T entity) {
		this.log.info("create: " + entity);
		this.em.persist(entity);
		this.eventSrc.fire(entity);
	}
}
