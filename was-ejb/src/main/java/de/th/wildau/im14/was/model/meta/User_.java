package de.th.wildau.im14.was.model.meta;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import de.th.wildau.im14.was.model.Address;
import de.th.wildau.im14.was.model.Article;
import de.th.wildau.im14.was.model.Role;
import de.th.wildau.im14.was.model.User;

@StaticMetamodel(User.class)
public class User_ {

	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SetAttribute<User, Role> roles;
	public static volatile SingularAttribute<User, String> activiationKey;
	public static volatile SetAttribute<User, Article> articles;
	public static volatile SingularAttribute<User, Address> address;

}
