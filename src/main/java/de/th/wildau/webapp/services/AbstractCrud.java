package de.th.wildau.webapp.services;

/**
 * 
 * @author Sebastian Nemak
 *
 */
public abstract class AbstractCrud<T> {

	// private EntityManager em;

	protected T get(long id) {

		return null;
	}

	protected T create(T type) {
//		this.em.create(type);
		return type;
	}

	protected T merge(T type) {

		return type;
	}

	protected boolean delete(T type) {
		
		return false;
	}
}
