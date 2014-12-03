package de.th.wildau.im14.was.controller;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.th.wildau.im14.was.model.Article;
import de.th.wildau.im14.was.service.ArticleService;

@Named
@ViewScoped
public class DashboardHome extends AbstractHome {

	private static final long serialVersionUID = 2726192112244700720L;

	@Inject
	private ArticleService articleService;

	public List<Article> getArticle() {
		return this.articleService.findMyArticlesOrderedCreateDate();
	}
}
