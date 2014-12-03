package de.th.wildau.im14.was.model.meta;

import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import de.th.wildau.im14.was.model.Article;
import de.th.wildau.im14.was.model.Comment;
import de.th.wildau.im14.was.model.User;

@StaticMetamodel(Comment.class)
public class Comment_ {

	public static volatile SingularAttribute<Comment, Long> id;
	public static volatile SingularAttribute<Comment, User> user;
	public static volatile SingularAttribute<Comment, Date> createDate;
	public static volatile SingularAttribute<Comment, String> content;
	public static volatile SetAttribute<Comment, Article> article;

}
