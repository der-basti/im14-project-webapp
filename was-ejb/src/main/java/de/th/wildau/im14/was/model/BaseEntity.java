package de.th.wildau.im14.was.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -4045686726442186942L;
	
	protected static final String DB_PREFIX = "was_";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	public abstract String getLabel();
	
	@Override
	public String toString() {
		return getLabel();
	}
}
