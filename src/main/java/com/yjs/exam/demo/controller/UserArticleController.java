package com.yjs.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjs.exam.demo.service.ArticleService;
import com.yjs.exam.demo.vo.Article;

@Controller
public class UserArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/user/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		Article article = articleService.writeArticle(title, body);
		return article;
	}

	@RequestMapping("/user/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
	}

	@RequestMapping("/user/article/getArticle")
	@ResponseBody
	public Object getArticleAction(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물이 존재하지 않습니다.";
		}

		return article;
	}

	@RequestMapping("/user/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물이 존재하지 않습니다.";
		}

		articleService.deleteArticle(id);

		return id + "번 게시물이 삭제되었습니다.";
	}

	@RequestMapping("/user/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물이 존재하지 않습니다.";
		}

		articleService.modifyArticle(id, title, body);

		return id + "번 게시물이 수정되었습니다.";
	}
}