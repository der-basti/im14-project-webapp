package de.th.wildau.was;

import javax.inject.Named;

@Named
public class HelloBean {

	private String name = "Java EE 7";
	
	public String getName() {
		return this.name;
	}
	
}
