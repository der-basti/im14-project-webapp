package de.th.wildau.im14.was.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.th.wildau.im14.was.model.Users;

@Stateless
public class UserService extends AbstractService<Users> {

	public Users findById(Long id) {
		return this.em.find(Users.class, id);
	}

	public List<Users> findAllOrderedByEmail() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Users> criteria = cb.createQuery(Users.class);
		Root<Users> user = criteria.from(Users.class);
		criteria.select(user).orderBy(cb.asc(user.get("email")));
		return this.em.createQuery(criteria).getResultList();
	}
}
