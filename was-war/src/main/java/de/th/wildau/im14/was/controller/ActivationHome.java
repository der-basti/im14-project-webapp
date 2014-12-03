package de.th.wildau.im14.was.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import de.th.wildau.im14.was.service.UserService;

@Named
@ViewScoped
public class ActivationHome extends AbstractHome {

	private static final long serialVersionUID = 1359760271587169839L;

	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String key;
	
	@Inject
	private UserService userService;

	public void init() {
		if (this.userService.activation(getParam("email"), getParam("key"))) {
			log.info("user doesn't exist");
			// FIXME msg
		}
		// TODO call count - bute force
		addInfoMessage("accountActivated");
	}
}
