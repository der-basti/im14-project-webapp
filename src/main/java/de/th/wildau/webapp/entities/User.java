package de.th.wildau.webapp.entities;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import de.th.wildau.webapp.enumeration.UserRole;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class User extends LabeledEntity {

	@NonNull
	@Size(min = 3, max = 100)
	private String name;

	private String actvationkey;

	@NonNull
	@Email
	private String email;

	@NonNull
	private String password;

	@NonNull
	private UserRole role;

	@Override
	public String getLabel() {
		return this.name;
	}

}
