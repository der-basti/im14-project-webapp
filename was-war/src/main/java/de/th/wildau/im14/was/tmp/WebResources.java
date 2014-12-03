package de.th.wildau.im14.was.tmp;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * This class uses CDI to alias Java EE resources, such as the persistence
 * context, to CDI beans
 * 
 * <p>
 * Example injection on a managed bean field:
 * </p>
 * 
 * <pre>
 * &#064;Inject
 * private EntityManager em;
 * </pre>
 */
public class WebResources {

	@Produces
	@RequestScoped
	public FacesContext produceFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public static String generateHash(final String password) {
		return Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
	}

}
