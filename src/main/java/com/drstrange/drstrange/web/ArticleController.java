package com.drstrange.drstrange.web;

import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.services.base.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/article")
public class ArticleController {
  
  private final ArticleService articleService;
  
  @Autowired
  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

//  @GetMapping ("")
//  public String articlePage() {
//    return "upload";
//  }
  
  @GetMapping ("/upload")
  public String articleUpload(Model model) {
    model.addAttribute("title", "Article upload");
    model.addAttribute("article", new Article());
    return "article/upload";
  }
  
  @PostMapping ("/upload")
  public String articleSubmit(@ModelAttribute Article article) {
    articleService.addArticle(article.getTitle(), article.getTopic(), article.getUserId(), article.getText(), article.getImage());
    return "index";
  }
}
