package de.th.wildau.webapp.entities;

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
	// FIXME @Id
	// FIXME @GeneratedValue
	private long id;
}
