package de.th.wildau.im14.was.controller;

import java.security.Principal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean
@ViewScoped
public class AuthHome extends AbstractHome {

	private static final long serialVersionUID = -8167947893012155861L;

	private String email;

	private String password;

	public String authenticate() {
		if (!isAuthenticated()) {
			try {
				getRequest().login(email, password);
				addInfoMessage("authHomeSuccess");
				return "./my/dashboard.xhtml";
			} catch (final ServletException e) {
				addErrorMessage("authHomeFailed");
			}
		}
		return "" + isAuthenticated();
	}

	public String logout() throws ServletException {
		if (isAuthenticated()) {
			getRequest().logout();
		}

		// HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
		// .getExternalContext().getSession(false);
		// if (session != null) {
		// session.invalidate();
		// }

		addInfoMessage("authHomeSignout");

		// FacesContext.getCurrentInstance().getApplication()
		// .getNavigationHandler()
		// .handleNavigation(FacesContext.getCurrentInstance(), null, "/");

		// ExternalContext externalContext = FacesContext.getCurrentInstance()
		// .getExternalContext();
		// externalContext.invalidateSession();
		// String contextPath = externalContext.getRequestContextPath();
		// externalContext.redirect(contextPath);
		return getRootContext();
	}

	public boolean isAuthenticated() {
		return getRequest().getUserPrincipal() != null;
		// return this.principal != null;
	}

	public boolean isUserInRole(String role) {
		return getRequest().isUserInRole(role);
	}

	@Deprecated
	public Principal getPrincipal() {
		return getRequest().getUserPrincipal();
	}

	private HttpServletRequest getRequest() {
		Object request = FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return request instanceof HttpServletRequest ? (HttpServletRequest) request
				: null;
	}

}
