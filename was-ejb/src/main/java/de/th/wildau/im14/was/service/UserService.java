package de.th.wildau.im14.was.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.th.wildau.im14.was.model.User;

@Stateless
public class UserService extends AbstractService<User> {

	public User findById(Long id) {
		return this.em.find(User.class, id);
	}

	public List<User> findAllOrderedByEmail() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> user = criteria.from(User.class);
		criteria.select(user).orderBy(cb.asc(user.get("email")));
		return this.em.createQuery(criteria).getResultList();
	}
}
