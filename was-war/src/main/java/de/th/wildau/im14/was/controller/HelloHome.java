package de.th.wildau.im14.was.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Getter
@Setter
public class HelloHome {

	private String name = "JEE";

	private String hello = "Personalvermittlung";

}
