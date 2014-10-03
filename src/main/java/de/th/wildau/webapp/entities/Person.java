package de.th.wildau.webapp.entities;

import de.th.wildau.webapp.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

/**
 * This entity describe general cv informations of a person.
 * 
 * @author Sebastian Nemak
 */
@Getter
@Setter
public class Person extends LabeldEntity {

	private Gender gender;
	
	private String title;
	
	private String firstname;

	private String lastname;

	@Override
	public String getLabel() {
		// TODO gender
		return this.firstname + " " + this.lastname;
	}

}
