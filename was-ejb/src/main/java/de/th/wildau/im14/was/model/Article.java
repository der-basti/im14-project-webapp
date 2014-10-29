package de.th.wildau.im14.was.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = BaseEntity.DB_PREFIX + "article")
@Getter
@Setter
public class Article extends BaseEntity {

	private static final long serialVersionUID = -7006976022319133504L;

	@NotNull
	private User user;

	@OneToOne(targetEntity = Comment.class, optional = true)
	private List<Comment> comments;

	@Past
	@NotNull
	private Date createDate;

	@NotEmpty
	@Length(min = 1, max = 1023)
	private String content;

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
