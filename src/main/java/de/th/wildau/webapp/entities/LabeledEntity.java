package de.th.wildau.webapp.entities;

/**
 * 
 * @author Sebastian Nemak
 */
public abstract class LabeledEntity extends BaseEntity {

	/**
	 * Abstract entity bean label.
	 * 
	 * @return String label of the entity
	 */
	public abstract String getLabel();
}
