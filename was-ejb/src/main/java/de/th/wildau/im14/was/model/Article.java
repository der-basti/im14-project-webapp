package de.th.wildau.im14.was.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
@Table(name = BaseEntity.DB_PREFIX + "article")
public class Article extends BaseEntity {

	private static final long serialVersionUID = -7006976022319133504L;

	@NotNull
	@OneToOne
	private User user;

	@Past
	@NotNull
	private Date createDate;

	@NotEmpty
	@Length(min = 1, max = 1023)
	private String content;

	@OneToMany(targetEntity = Comment.class, mappedBy = "article", fetch = FetchType.EAGER)
	private List<Comment> comments;

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
