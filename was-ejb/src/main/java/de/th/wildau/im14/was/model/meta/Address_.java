package de.th.wildau.im14.was.model.meta;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import de.th.wildau.im14.was.model.Address;

@StaticMetamodel(Address.class)
public class Address_ {

	public static volatile SingularAttribute<Address, Long> id;
	public static volatile SingularAttribute<Address, String> title;
	public static volatile SingularAttribute<Address, String> firstName;
	public static volatile SingularAttribute<Address, String> lastName;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, String> streetNumber;
	public static volatile SingularAttribute<Address, String> plz;
	public static volatile SingularAttribute<Address, String> city;

}
