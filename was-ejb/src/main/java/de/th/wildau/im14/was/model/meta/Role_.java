package de.th.wildau.im14.was.model.meta;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import de.th.wildau.im14.was.model.Role;
import de.th.wildau.im14.was.model.User;

@StaticMetamodel(Role.class)
public class Role_ {

	public static volatile SingularAttribute<Role, Long> id;
	public static volatile SingularAttribute<Role, String> name; // RoleType
	public static volatile SetAttribute<Role, User> users;

}
