package de.th.wildau.im14.was.controller;

import java.util.Map;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.th.wildau.im14.was.model.Article;
import de.th.wildau.im14.was.service.ArticleService;

@Named
@RequestScoped
public class BrowseViewHome extends AbstractHome {

	private static final long serialVersionUID = 8249729209502499133L;

	@Inject
	private ArticleService articleService;

	private Long getItemId() {
		Map<String, String> requestMap = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String id = (String) requestMap.get("item");
		this.log.info("article id: " + id);
		return Long.valueOf(id);
	}

	public Article getArticle() {
		return this.articleService.getArticle(getItemId());
	}
}
