package de.th.wildau.im14.was.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import lombok.Getter;
import lombok.Setter;
import de.th.wildau.im14.was.service.UserService;

@Getter
@Setter
@ManagedBean
@RequestScoped
public class SigninHome extends AbstractHome {

	private static final long serialVersionUID = -8167947893012155861L;

	private String email;

	private String password;

	@Inject
	private UserService userService;
	
	public String authenticate() {
		if (!this.may.isAuthenticated()) {
			try {
				final String salt = this.userService.getSalt(this.email);
				getRequest().login(this.email, this.password + salt);
				addInfoMessage("authHomeSuccess");
				return redirect("my/dashboard.jsf");
			} catch (final ServletException e) {
				addErrorMessage("authHomeFailed");
			}
		}
		return "";
	}

	public String logout() throws ServletException {
		if (this.may.isAuthenticated()) {
			getRequest().logout();
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			addInfoMessage("authHomeSignout");
		}
		return redirectToRoot();
	}

}
