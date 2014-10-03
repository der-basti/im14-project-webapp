package de.th.wildau.webapp.enumeration;

/**
 * Describe the possible user roles in the web app.
 * 
 * @author Sebastian Nemak
 */
public enum UserRole {

	/** can manage the hole web app */
	ADMIN

	/** represent a company, which insert vacancies */
	, COMPANY

	/** a tipcal user, which can add a cv */
	, USER;

}
