package de.th.wildau.im14.was.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import de.th.wildau.im14.was.model.Article;
import de.th.wildau.im14.was.service.ArticleService;

@Named
public class DashboardHome extends AbstractHome{

	private static final long serialVersionUID = 2726192112244700720L;

	@Inject
	private ArticleService articleService;
	
	public List<Article> getArticle() {
		// FIXME return only articles from this user
		return this.articleService.findMyArticlesOrderedCreateDate();
	}
}
