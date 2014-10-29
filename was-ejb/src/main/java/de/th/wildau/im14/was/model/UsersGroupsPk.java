package de.th.wildau.im14.was.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;

// FIXME https://www.youtube.com/watch?v=MKH-zpt8LAs

@EqualsAndHashCode
public class UsersGroupsPk implements Serializable {

	private static final long serialVersionUID = -7207039289110481317L;

//	@ManyToOne
//	@JoinColumn(name = "matrix_user", referencedColumnName = "id")
//	private Users user;
//
//	@ManyToOne
//	@JoinColumn(name = "matrix_group", referencedColumnName = "id")
//	private Groups group;
}
