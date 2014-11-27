package de.th.wildau.im14.was.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = BaseEntity.DB_PREFIX + "comment")
public class Comment extends BaseEntity {

	private static final long serialVersionUID = -3911349965530652599L;

	@OneToOne
	private User user;

	@Past
	@NotNull
	private Date createDate;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 250)
	private String content;

	@ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER)
	private Article article;

	@Override
	public String getLabel() {
		StringBuilder sb = new StringBuilder();
		if (this.user != null) {
			sb.append(this.user.getEmail()).append(" : ");
		}
		sb.append(this.content);
		return sb.toString();
	}
}
