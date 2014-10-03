package de.th.wildau.webapp.entities;

import de.th.wildau.webapp.enumeration.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends LabeldEntity {

	private String name;
	
	private String actvationkey;
	
	private String email;
	
	private String password;
	
	private UserRole role;

	@Override
	public String getLabel() {
		return this.name;
	}
	
}
