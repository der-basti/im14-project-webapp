package de.th.wildau.im14.was.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = BaseEntity.DB_PREFIX + "paymentbc")
public class PaymentBC extends PaymentAbstract {

	private static final long serialVersionUID = 2791988698704556872L;

	@NotBlank
	private String name;

	@NotBlank
	private String blz;

	@NotBlank
	private String kto;

	@NotBlank
	private String bankName;

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
