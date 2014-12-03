package de.th.wildau.im14.was.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@MappedSuperclass
@EqualsAndHashCode
public abstract class BaseEntity<T extends BaseEntity<?>> implements Serializable,
		Comparable<T> {

	private static final long serialVersionUID = -4045686726442186942L;

	protected static final String DB_PREFIX = "was_";

	protected static final String LABEL_SEPARATOR = "; ";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;

	public abstract String getLabel();

	@Override
	public String toString() {
		return "[" + this.id + "] " + getLabel();
	}

	@Override
	public int compareTo(T item) {
		return this.id.compareTo(item.getId());
	}
}
