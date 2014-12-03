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

@Stateless
public class UserService extends AbstractService<User> {

	private static final long serialVersionUID = 2597874045707147913L;

	@Inject
	private AddressService addressService;

	@Inject
	private MailService mailService;

	public String getSalt(final String email) {
		User u = getByEmail(email);
		if (u == null) {
			return null;
		}
		return u.getPasswordSalt();
	}

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
		user.setActiviationKey(RandomStringUtils.randomAlphanumeric(32));
		user.setAddress(address);
		this.addressService.create(address);
		super.create(user);
		this.mailService.send(user.getEmail(), "Account activation",
				generateRegMail(user, address));
	}

	private static String generateRegMail(final User user, final Address address) {
		StringBuilder sb = new StringBuilder("Hello ");
		sb.append(address.getFirstName()).append(",")
				.append(MailService.LINE_BREAK).append(MailService.LINE_BREAK);
		sb.append("please activate your account with the following link: ");
		// sb.append(ServletRequest.getServerName()).append(ServletRequest.getServerPoprt());
		sb.append("https://127.0.0.1:8443/was/activation.jsf?email=")
				.append(user.getEmail()).append("&key=")
				.append(user.getActiviationKey()).append(" ")
				.append(MailService.LINE_BREAK);
		sb.append(MailService.LINE_BREAK).append("Best regards")
				.append(MailService.LINE_BREAK).append("Your recruiter");
		return sb.toString();
	}

	public User findById(Long id) {
		return this.em.find(User.class, id);
	}

	public List<User> findAllOrderedByEmail() {
		// CriteriaBuilder cb = this.em.getCriteriaBuilder();
		// CriteriaQuery<User> criteria = cb.createQuery(User.class);
		// Root<User> user = criteria.from(User.class);
		// // TODO addFetches(user, "user.roles");
		// criteria.select(user).orderBy(cb.asc(user.get("email")));
		// return this.em.createQuery(criteria).getResultList();

		CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder
				.createQuery(User.class);
		Root<User> user = criteriaQuery.from(User.class);
		user.fetch("address");
		criteriaQuery.select(user);
		return this.em.createQuery(criteriaQuery).getResultList();
	}

	private User getByEmail(final String email) {
		CriteriaBuilder criteriaBuilder = this.em.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder
				.createQuery(User.class);
		Root<User> user = criteriaQuery.from(User.class);
		criteriaQuery.select(user).where(
				criteriaBuilder.equal(user.get("email"), email));
		return this.em.createQuery(criteriaQuery).getSingleResult();
	}

	public boolean activation(final String email, final String key) {
		User u = getByEmail(email);
		if (u == null) {
			return false;
		}
		if (!u.getActiviationKey().equals(key)) {
			return false;
		}
		u.setActiviationKey("");
		this.em.merge(u);
		return true;
	}
}
