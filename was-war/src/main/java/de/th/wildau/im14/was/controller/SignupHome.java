package de.th.wildau.im14.was.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import com.google.common.base.Charsets;
import com.google.common.collect.Sets;
import com.google.common.hash.Hashing;

import de.th.wildau.im14.was.model.User;
import de.th.wildau.im14.was.service.UserService;

@Named
@SessionScoped
public class SignupHome extends AbstractHome {

	private static final long serialVersionUID = 307975560723117461L;

	@Inject
	private UserService userService;

	@Getter
	private List<SelectItem> selectItems;

	@Getter
	@Setter
	private boolean user; // company

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private String passwordConfirm;

	@PostConstruct
	public void init() {
		this.user = true;
		this.selectItems = new ArrayList<>();
		this.selectItems.add(new SelectItem(true, "User"));
		this.selectItems.add(new SelectItem(false, "Company"));
	}

	@Deprecated
	public void validatePassword(final FacesContext context,
			final UIComponent toValidate, Object value) {
		String confirm = (String) value;
		UIInput passComp = (UIInput) toValidate.getAttributes().get(
				"passwordConfirm");
		String password = (String) passComp.getValue();
		if (!password.equals(confirm)) {
			addErrorMessage("Password and Confirm Password should match");
		}
	}

	public String signup() {
		if (!this.password.equals(this.passwordConfirm)) {
			addErrorMessage("signupMsgNotEquals");
			return "";
		}

		User newUser = new User();
		newUser.setEmail(this.email);
		newUser.setPassword(Base64.getEncoder().encodeToString(
				Hashing.sha256().hashString(this.password, Charsets.UTF_8)
						.asBytes()));
		// FIXME new user have all
		newUser.setRoles(Sets.newHashSet(this.userService.getRoles()));

		this.userService.create(newUser);
		// FIXME add msg
		reset();
		// return redirect("index.jsf");
		return "";
	}

	private void reset() {
		this.email = "";
		this.password = "";
	}
}
