package de.th.wildau.im14.was.model;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class PaymentAbstract extends BaseEntity {

	private static final long serialVersionUID = -8840052361539991123L;

	@ManyToOne
	private User user;
}
