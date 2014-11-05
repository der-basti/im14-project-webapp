package de.th.wildau.im14.was.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Entity
@Table(name = BaseEntity.DB_PREFIX + "role")
@ToString
public class Role extends BaseEntity {

	private static final long serialVersionUID = 6773222561593077128L;

	@Column(unique = true, nullable = false, updatable = false, length = 63)
	@Length(min = 1, max = 63)
	private String name;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private Set<User> users;

	@Override
	public String getLabel() {
		return this.name;
	}
}
