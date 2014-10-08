package de.th.wildau.webapp.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * General entity bean.
 * 
 * @author Sebastian Nemak
 */
@Getter
@Setter
public class BaseEntity {

	/** general primary key */
	@Id
	@GeneratedValue
	private long id;
}
