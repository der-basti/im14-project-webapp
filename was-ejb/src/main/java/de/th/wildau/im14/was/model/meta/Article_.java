package de.th.wildau.im14.was.model.meta;

import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import de.th.wildau.im14.was.model.Article;
import de.th.wildau.im14.was.model.Comment;
import de.th.wildau.im14.was.model.User;

@StaticMetamodel(Article.class)
public class Article_ {

	public static volatile SingularAttribute<Article, Long> id;
	public static volatile SingularAttribute<Article, User> user;
	public static volatile SingularAttribute<Article, Date> createDate;
	public static volatile SingularAttribute<Article, String> title;
	public static volatile SingularAttribute<Article, String> content;
	public static volatile SetAttribute<Article, Comment> comments;

}
