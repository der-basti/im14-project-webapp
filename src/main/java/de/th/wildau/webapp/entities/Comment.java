package de.th.wildau.webapp.entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * General commet entity.
 * 
 * @author Sebastian Nemak
 */
@Getter
@Setter
public class Comment extends LabeldEntity {

	private User user;

	private Date created;

	private String comment;

	@Override
	public String getLabel() {
		StringBuilder sb = new StringBuilder(this.user.getName());
		sb.append(" ").append(this.created);
		sb.append(" ").append(this.comment);
		return sb.toString();
	}
}
