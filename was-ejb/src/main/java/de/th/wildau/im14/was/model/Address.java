package de.th.wildau.im14.was.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = BaseEntity.DB_PREFIX + "address")
public class Address extends BaseEntity<Address> {

	private static final long serialVersionUID = -8198571879418446195L;

	@Size(max = 31)
	private String title;
	
	@NotEmpty
	@Size(min = 1, max = 63)
	private String firstName;
	
	@NotEmpty
	@Size(min = 1, max = 63)
	private String lastName;
	
	@NotEmpty
	@Size(min = 2, max = 255)
	private String street;

	@NotEmpty
	@Pattern(regexp = "[0-9]{1,4}")
	private String streetNumber;

	@NotEmpty
	@Length(min = 2, max = 8)
	private String plz;

	@NotEmpty
	@Length(min = 3, max = 255)
	private String city;

	@Override
	public String getLabel() {
		StringBuilder sb = new StringBuilder();
		if (this.street != null)
			sb.append(this.street);
		if (this.streetNumber != null)
			sb.append(" ").append(this.streetNumber);
		if (this.plz != null)
			sb.append("; ").append(this.plz);
		if (this.city != null)
			sb.append(" ").append(this.city);
		return sb.toString();
	}

}
