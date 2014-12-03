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

import org.apache.commons.lang3.RandomStringUtils;

import lombok.Getter;
import lombok.Setter;

import com.google.common.base.Charsets;
import com.google.common.collect.Sets;
import com.google.common.hash.Hashing;

import de.th.wildau.im14.was.model.Address;
import de.th.wildau.im14.was.model.Role;
import de.th.wildau.im14.was.model.RoleType;
import de.th.wildau.im14.was.model.User;
import de.th.wildau.im14.was.service.UserService;

@Named
@SessionScoped
public class SignupHome extends AbstractHome {

	private static final long serialVersionUID = 307975560723117461L;

	@Inject
	private UserService userService;

	@Getter
	private List<SelectItem> userSi;

	@Getter
	@Setter
	private boolean userType;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	// TODO validate
	private String password;

	@Getter
	@Setter
	private String passwordConfirm;

	@Getter
	@Setter
	private User user;

	@Getter
	@Setter
	private Address address;

	@PostConstruct
	public void init() {
		this.userType = true;
		this.userSi = new ArrayList<>();
		this.userSi.add(new SelectItem(true, "User"));
		this.userSi.add(new SelectItem(false, "Company"));
		this.user = new User();
		this.address = new Address();
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
		this.user.setEmail(this.email);
		this.user.setPasswordSalt(RandomStringUtils.randomAlphanumeric(20));
		this.user.setPassword(Base64.getEncoder().encodeToString(
				Hashing.sha256()
						.hashString(
								this.password + this.user.getPasswordSalt(),
								Charsets.UTF_8).asBytes()));
		List<Role> roles = this.userService.getRole(RoleType.USER);
		if (!this.userType) {
			roles = this.userService.getRole(RoleType.COMPANY);
		}
		this.user.setRoles(Sets.newHashSet(roles));
		this.userService.create(this.user, this.address);
		addInfoMessage("accountActivateEmailSend");
		reset();
		return redirectToRoot();
	}

	private void reset() {
		this.user = new User();
		this.address = new Address();
		this.userType = true;
		this.email = "";
		this.password = "";
		this.passwordConfirm = "";
	}
}
