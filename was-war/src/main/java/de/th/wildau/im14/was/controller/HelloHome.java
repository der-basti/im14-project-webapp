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

	private String ajax = "JSF ajax";

	private String hello = "Personalvermittlung";

}
