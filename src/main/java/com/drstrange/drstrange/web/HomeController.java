package com.drstrange.drstrange.web;

import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.services.base.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
  
  private final ArticleService articleService;
  
  @Autowired
  public HomeController(ArticleService articleService){
    this.articleService = articleService;
  }
  @GetMapping ("/")
  public String indexHandler(Model model){
    model.addAttribute("title", "Dr. Strange News");
    model.addAttribute("article", articleService.listAllArticle());
    
    return "index";
  }
}