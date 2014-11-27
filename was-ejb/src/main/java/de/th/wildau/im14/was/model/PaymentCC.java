package de.th.wildau.im14.was.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = BaseEntity.DB_PREFIX + "paymentcc")
public class PaymentCC extends PaymentAbstract {

	private static final long serialVersionUID = -2260660952348935786L;

	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentCCType cCardType;

	@NotBlank
	@Length(min = 1, max = 30)
	@Pattern(regexp = "[0-9]{13,16}")
	private String number;

	@NotBlank
	@Length(min = 3, max = 255)
	private String name;

	@NotEmpty
	@Pattern(regexp = "[0-9]{2}")
	private String exparationDateMonth;

	@NotEmpty
	@Pattern(regexp = "[0-9]{4}")
	private String exparationDateYear;

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
