package de.th.wildau.webapp.entities;

import javax.validation.constraints.Size;

import de.th.wildau.webapp.enumeration.Gender;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * This entity describe general cv informations of a person.
 * 
 * @author Sebastian Nemak
 */
@Getter
@Setter
public class Person extends LabeledEntity {

	@NonNull
	private Gender gender;
	
	@Size(min=1, max=63)
	private String title;
	
	@NonNull
	@Size(min=1, max=255)
	private String firstname;

	@NonNull
	@Size(min=1, max=255)
	private String lastname;

	@Override
	public String getLabel() {
		// TODO gender
		return this.firstname + " " + this.lastname;
	}

}
