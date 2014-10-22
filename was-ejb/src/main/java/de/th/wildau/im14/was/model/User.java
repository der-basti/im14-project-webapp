package de.th.wildau.im14.was.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
@Getter
@Setter
public class User implements Serializable {

	private static final long serialVersionUID = -1103085759456125104L;

	@Id
	@Column(unique = true, length = 255)
	// @Size(max = 255)
	@Email
	private String email;

	@NotNull
	@NotEmpty
	@Size(min = 8, max = 255)
	private String password;

	// @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinTable(name = "user_group", joinColumns = { @JoinColumn(name =
	// "email", nullable = false) }, inverseJoinColumns = { @JoinColumn(name =
	// "groupName", nullable = false) })
	// private Set<Group> groups;
}
