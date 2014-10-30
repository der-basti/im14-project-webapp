package de.th.wildau.im14.was.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import de.th.wildau.im14.was.model.Role;
import de.th.wildau.im14.was.model.User;
import de.th.wildau.im14.was.service.UserService;

@Deprecated
@Named
@RequestScoped
public class UserHome implements Serializable {

	private static final long serialVersionUID = -3387583640692765077L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private UserService userService;

	@Getter
	@Setter
	private User user;

	private static String generateHash(final String password) {
		return Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
	}

	public List<User> getUsers() {
		return this.userService.findAllOrderedByEmail();
	}

	public String printRoles(Set<Role> roles) {
		StringBuilder sb = new StringBuilder();
		if (roles != null) {
			// Joiner.on(", ").appendTo();
			for (Iterator<Role> ite = roles.iterator(); ite.hasNext();) {
				sb.append(ite.next().getName());
				if (ite.hasNext()) {
					sb.append(", ");
				}
			}
		}
		return sb.toString();
	}

	public List<SelectItem> getRolesSelectItems() {
		List<SelectItem> items = new ArrayList<>();
		for (Role role : this.userService.getRoles()) {
			items.add(new SelectItem(role.getId(), role.getLabel()
					.toLowerCase()));
		}
		return items;
	}

	@Deprecated
	public void register() {
		try {
			this.user.setPassword(generateHash(this.user.getPassword()));
			this.userService.create(this.user);
			this.facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Registered",
					"Registration successful"));
			initNewUser();
		} catch (final Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					errorMessage, "Registration Unsuccessful");
			this.facesContext.addMessage(null, m);
		}
	}

	private String getRootErrorMessage(final Exception e) {
		String errorMessage = "Registration failed. See server log for more information";
		if (e == null) {
			return errorMessage;
		}

		Throwable t = e;
		while (t != null) {
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		return errorMessage;
	}

	@PostConstruct
	public void initNewUser() {
		this.user = new User();
	}
}
