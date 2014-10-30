package de.th.wildau.im14.was.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@RequestScoped
public class HelloHome extends AbstractHome {

	private static final long serialVersionUID = -4422181711706897633L;

	private String ajax = "JSF ajax";
}
