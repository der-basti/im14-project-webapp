package de.th.wildau.im14.was.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import de.th.wildau.im14.was.model.Article;
import de.th.wildau.im14.was.service.ArticleService;
import de.th.wildau.im14.was.tmp.ArticleLazyDataModel;

@Named
@ViewScoped
public class BrowseHome extends AbstractHome {

	private static final long serialVersionUID = 7132259624068004726L;

	@Getter
	private List<Article> articles;

	@Getter
	@Setter
	@Deprecated
	private LazyDataModel<Article> lazyModel;

	@Getter
	@Setter
	@Deprecated
	private Article selectedItem;

	@Inject
	private ArticleService articleService;

	public String navView() {
		Map<String, String> requestMap = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		return redirect("view.jsf?faces-redirect=true" + "&" + "item="
				+ (String) requestMap.get("item"));
	}

	@PostConstruct
	public void init() {
		this.articles = this.articleService.getAllArticles();
		this.lazyModel = new ArticleLazyDataModel(this.articles);
	}

	@Deprecated
	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Selected", "details: "
				+ ((Article) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
