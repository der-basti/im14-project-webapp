package de.th.wildau.im14.was.tmp;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@Deprecated
@FacesValidator("confirmValidator")
public class ConfirmValidator implements Validator {

	@Override
	public void validate(final FacesContext context,
			final UIComponent component, final Object value)
			throws ValidatorException {
		final String password = (String) value;
		final String confirm = (String) component.getAttributes().get(
				"confirm");

		if (password == null || confirm == null) {
			// Just ignore and let required="true" do its job.
			return;
		}

		if (!password.equals(confirm)) {
			throw new ValidatorException(new FacesMessage(
					"Input are not equal."));
		}
	}

}
