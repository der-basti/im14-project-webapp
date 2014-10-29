package de.th.wildau.im14.was.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = BaseEntity.DB_PREFIX + "user")
@Getter
@Setter
public class User extends BaseEntity {

	private static final long serialVersionUID = -1103085759456125104L;

	@Email
	@Length(max = 255)
	@Column(unique = true)
	private String email;

	@NotEmpty
	@Length(min = 8, max = 255)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Users_Roles", joinColumns = { @JoinColumn(name = "users_id") }, inverseJoinColumns = { @JoinColumn(name = "roles_id") })
	private Set<Role> roles;

	// @ManyToOne(optional = true, targetEntity = Role.class)
	// private Role group;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Comment> comments;

	@Override
	public String getLabel() {
		return this.email;
	}

}
