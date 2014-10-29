package de.th.wildau.im14.was.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class SignupHome extends AbstractHome {

	private static final long serialVersionUID = 307975560723117461L;

	@Getter
	private List<SelectItem> selectItems;

	@Getter
	@Setter
	private boolean user;
	
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

	public void validatePassword(final FacesContext context, final UIComponent toValidate,
			Object value) {
		String confirm = (String) value;
		UIInput passComp = (UIInput) toValidate.getAttributes().get(
				"passwordConfirm");
		String password = (String) passComp.getValue();
		if (!password.equals(confirm)) {
			addErrorMessage("Password and Confirm Password should match");
		}
	}

	public String signup() {

		return "/index.jsp";
	}

}
