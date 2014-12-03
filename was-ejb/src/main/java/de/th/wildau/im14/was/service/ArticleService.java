package de.th.wildau.im14.was.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.th.wildau.im14.was.model.Article;
import de.th.wildau.im14.was.model.User;

@PermitAll
@Stateless
public class ArticleService extends AbstractService<Article> {

	private static final long serialVersionUID = -9026009999465076888L;

	@RolesAllowed({ "USER", "COMPANY" })
	public List<Article> findMyArticlesOrderedCreateDate() {
		User u = getCurrentUser();
		if (u == null) {
			return new ArrayList<Article>();
		}

		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Article> criteria = cb.createQuery(Article.class);
		Root<Article> article = criteria.from(Article.class);

		criteria.select(article)
				.where(cb.equal(article.get("user"), u.getId()));
		criteria.orderBy(cb.asc(article.get("createDate")));

		return this.em.createQuery(criteria).getResultList();
	}

	public List<Article> getAllArticles() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Article> criteria = cb.createQuery(Article.class);
		Root<Article> article = criteria.from(Article.class);
		
		// article.fetch(Article_.user);
		criteria.select(article);
		criteria.orderBy(cb.asc(article.get("createDate")));
		
		return this.em.createQuery(criteria).getResultList();
	}

	public Article getArticle(final Long id) {
		if (id == null) {
			return null;
		}
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Article> criteria = cb.createQuery(Article.class);
		Root<Article> article = criteria.from(Article.class);

		criteria.select(article).where(cb.equal(article.get("id"), id));
		return this.em.createQuery(criteria).getSingleResult();
	}
}
