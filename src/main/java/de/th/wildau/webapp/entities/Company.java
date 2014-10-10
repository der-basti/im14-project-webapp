package de.th.wildau.webapp.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company extends LabeledEntity{

	private String name;
	
	// address
	
	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
