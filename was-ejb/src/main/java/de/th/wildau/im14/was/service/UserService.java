package de.th.wildau.im14.was.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.th.wildau.im14.was.model.Role;
import de.th.wildau.im14.was.model.User;

@Stateless
public class UserService extends AbstractService<User> {

	private static final long serialVersionUID = 2597874045707147913L;

	public List<Role> getRoles() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Role> criteria = cb.createQuery(Role.class);
		Root<Role> role = criteria.from(Role.class);
		criteria.select(role).orderBy(cb.asc(role.get("name")));
		return this.em.createQuery(criteria).getResultList();
	}
	
	public User findById(Long id) {
		return this.em.find(User.class, id);
	}

	public List<User> findAllOrderedByEmail() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> user = criteria.from(User.class);

		//addFetches(user, "groups_id");

		criteria.select(user).orderBy(cb.asc(user.get("email")));
		return this.em.createQuery(criteria).getResultList();
	}
}
