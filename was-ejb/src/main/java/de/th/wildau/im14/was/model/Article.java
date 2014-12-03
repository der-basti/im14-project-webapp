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

@Entity
@Table(name = BaseEntity.DB_PREFIX + "article")
@Getter
@Setter
public class Article extends BaseEntity<Article> {

	private static final long serialVersionUID = -7006976022319133504L;

	@NotNull
	@OneToOne
	private User user;

	@Past
	@NotNull
	private Date createDate;

	@NotEmpty
	@Length(min = 1, max = 127)
	private String title;

	@NotEmpty
	@Length(min = 1, max = 1023)
	private String content;

	@OneToMany(targetEntity = Comment.class, mappedBy = "article", fetch = FetchType.EAGER)
	private List<Comment> comments;

	@Override
	public String getLabel() {
		StringBuilder sb = new StringBuilder(this.createDate.toString());
		sb.append(LABEL_SEPARATOR).append(this.user.getEmail());
		sb.append(LABEL_SEPARATOR).append(this.content);
		return sb.toString();
	}

	@Override
	public int compareTo(Article item) {
		// compare createDate
		int diff = this.createDate.compareTo(item.getCreateDate());
		if (diff != 0) {
			return diff;
		}
		// createDate are equals compare content
		return this.content.compareToIgnoreCase(item.getContent());
	}

}
