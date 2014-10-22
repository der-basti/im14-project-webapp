package de.th.wildau.im14.was.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import de.th.wildau.im14.was.model.Users;
import de.th.wildau.im14.was.service.UserService;

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
	private Users user;

	private List<Users> users;

	public List<Users> getUsers() {
		this.users = this.userService.findAllOrderedByEmail();
		return this.users;
	}

	private String generateHash(final String password) {
		return Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
	}

	public void register() {
		try {
			this.user.setPassword(generateHash(this.user.getPassword()));
			this.userService.create(this.user);
			this.facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Registered!",
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
		this.user = new Users();
	}
}
