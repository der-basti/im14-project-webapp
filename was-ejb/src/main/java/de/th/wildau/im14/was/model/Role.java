package de.th.wildau.im14.was.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = BaseEntity.DB_PREFIX + "role")
@ToString
public class Role extends BaseEntity {

	private static final long serialVersionUID = 6773222561593077128L;

	@Column(unique = true, nullable = false, length = 63)
	@Enumerated(EnumType.STRING)
	private RoleType name;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private Set<User> users;

	@Override
	public String getLabel() {
		return this.name.name();
	}
}
