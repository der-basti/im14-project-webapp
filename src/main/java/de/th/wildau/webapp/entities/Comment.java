package de.th.wildau.webapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * General commet entity.
 * 
 * @author Sebastian Nemak
 */
@Getter
@Setter
public class Comment extends LabeldEntity {

	@NonNull
	private User user;

	@NonNull
	private Date created;

	@Size(min=1, max=255)
	private String comment;

	@Override
	public String getLabel() {
		StringBuilder sb = new StringBuilder(this.user.getName());
		sb.append(" ").append(this.created);
		sb.append(" ").append(this.comment);
		return sb.toString();
	}
}
