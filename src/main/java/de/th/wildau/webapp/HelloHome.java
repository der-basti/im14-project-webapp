package de.th.wildau.webapp;

import javax.inject.Named;

import lombok.Getter;

/**
 * Sample bean, which provide the project name.
 * 
 * @author Sebastian Nemak
 */
@Named
@Getter
public class HelloHome {

	private final String projectName = "im14-project-webapp";
}
