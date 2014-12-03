package de.th.wildau.im14.was.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import de.th.wildau.im14.was.model.Role;
import de.th.wildau.im14.was.service.UserService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@RequestScoped
public class Home extends AbstractHome {

	private static final long serialVersionUID = -4422181711706897633L;

	private String ajax = "magic JSF ajax ... change text";
	
	@Inject
	private UserService userService;

	public String printRoles(Collection<Role> roles) {
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
}
