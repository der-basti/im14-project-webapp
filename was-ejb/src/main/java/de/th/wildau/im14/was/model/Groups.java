package de.th.wildau.im14.was.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Groups implements Serializable {

	private static final long serialVersionUID = 6773222561593077128L;

	@Id
	@Column(unique = true, nullable = false, length = 63)
	@Size(min = 1, max = 63)
	private String name;

	// @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groupName")
	// private Set<User> users;
}
