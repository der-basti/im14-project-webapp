package de.th.wildau.im14.was.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = BaseEntity.DB_PREFIX + "user")
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

	// @Getter(value = AccessLevel.NONE)
	// @Length(min = 24, max = 24)
	private String activiationKey;

	@OneToMany(mappedBy = "user")
	private List<Article> articles;

	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	private Address address;

	@Override
	public String getLabel() {
		return this.email;
	}

}
