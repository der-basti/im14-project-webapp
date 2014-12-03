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

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = BaseEntity.DB_PREFIX + "user")
public class User extends BaseEntity<User> {

	private static final long serialVersionUID = -1103085759456125104L;

	private final String SALT = "";

	@Email
	@Length(max = 255)
	@Column(unique = true)
	private String email;

	@NotEmpty
	@Length(min = 8, max = 255)
	// @Getter(value = AccessLevel.NONE)
	private String password;

	// FIXME see below - setPassword() method
	// https://docs.jboss.org/author/display/WFLY8/Security+Realms
	// https://developer.jboss.org/thread/43874?start=0&tstart=0
	// https://stackoverflow.com/questions/16598322/jboss-salted-databaseserverloginmodule-on-as-7-1
	// https://developer.jboss.org/wiki/JBossAS7SecuringPasswords
	// http://blog.eisele.net/2012/07/glassfish-jdbc-security-with-salted.html
	@NotEmpty
	@Length(min = 20, max = 20)
	private String passwordSalt;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Users_Roles", joinColumns = { @JoinColumn(name = "users_id") }, inverseJoinColumns = { @JoinColumn(name = "roles_id") })
	private Set<Role> roles;

	@Length(max = 32)
	private String activiationKey;

	@OneToMany(mappedBy = "user")
	private List<Article> articles;

	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	private Address address;

	// FIXME handle SALT on backing bean
	// public void setPassword(final String password) {
	// this.password = SALT + password;
	// }

	@Override
	public String getLabel() {
		return this.email;
	}

}
