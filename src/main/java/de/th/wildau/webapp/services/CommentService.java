package de.th.wildau.webapp.services;

import de.th.wildau.webapp.entities.Comment;
import de.th.wildau.webapp.enumeration.UserRole;

public class CommentService extends AbstractCrud<Comment>{

	@Override
	protected Comment create(Comment type) {
		
		if (type.getUser().getRole() != UserRole.ADMIN) {
			System.out.println("asdjhgdfkjs");
		}
		return super.create(type);
	}
}
