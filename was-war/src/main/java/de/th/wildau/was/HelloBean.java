package de.th.wildau.was;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
public class HelloBean {

	private String name = "Basti";
	
	public String getName() {
		return this.name;
	}
	
}
