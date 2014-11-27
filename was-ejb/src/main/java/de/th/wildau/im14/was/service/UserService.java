package de.th.wildau.im14.was.service;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.RandomStringUtils;

import de.th.wildau.im14.was.model.Address;
import de.th.wildau.im14.was.model.Role;
import de.th.wildau.im14.was.model.RoleType;
import de.th.wildau.im14.was.model.User;
import de.th.wildau.im14.was.model.meta.User_;

@Stateless
public class UserService extends AbstractService<User> {

	private static final long serialVersionUID = 2597874045707147913L;

	@Inject
	private AddressService addressService;

	public List<Role> getRoles() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Role> criteria = cb.createQuery(Role.class);
		Root<Role> role = criteria.from(Role.class);
		criteria.select(role).orderBy(cb.asc(role.get("name")));
		return this.em.createQuery(criteria).getResultList();
	}

	public List<Role> getRole(final RoleType roleType) {
		for (Role role : getRoles()) {
			if (role.getName().name().equalsIgnoreCase(roleType.name())) {
				return Arrays.asList(role);
			}
		}
		return null;
	}

	public void create(final User user, final Address address) {
		user.setAddress(address);
		user.setActiviationKey(RandomStringUtils.randomAlphanumeric(24));
		// TODO send mail
		create(user);
		this.addressService.create(address);
	}

	public User findById(Long id) {
		return this.em.find(User.class, id);
	}

	public List<User> findAllOrderedByEmail() {
//		CriteriaBuilder cb = this.em.getCriteriaBuilder();
//		CriteriaQuery<User> criteria = cb.createQuery(User.class);
//		Root<User> user = criteria.from(User.class);
//		// TODO addFetches(user, "user.roles");
//		criteria.select(user).orderBy(cb.asc(user.get("email")));
//		return this.em.createQuery(criteria).getResultList();
		
		CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> user = criteriaQuery.from(User.class);
		System.out.println(User_.address);
		String name = "address";
		user.fetch(name);
		criteriaQuery.select(user);
		return this.em.createQuery(criteriaQuery).getResultList();
	}
}
