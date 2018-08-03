package com.drstrange.drstrange.web;


import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.services.base.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    private ArticleService service;

    @Autowired
    public ArticleController(ArticleService service) {
        this.service = service;
    }

//    @GetMapping("/{id}")
//    public Article findById(@PathVariable("id") String id) {
//        return service.findById(Integer.parseInt(id));
//    }

    @GetMapping ("/{name}")
    public List<Article> findByName(@PathVariable ("name") String name) {
        return service.findByName(name);
    }

    @GetMapping ("/all")
    public List<Article> getAllArticle() {
        return service.listAllArticle();
    }

    @GetMapping ("/filterBySequence/{filter}")
    public List<Article> filterBySequence(@PathVariable ("filter") String filter) {
        return service.filterBySequence(filter);
    }
    @GetMapping ("/findByAuthor/{authorID}")
    public List<Article> filterBySequence(@PathVariable ("authodID") int author) {
        return service.findByAuthor(author);
    }
    @PostMapping ("/addArticle/{title}/{topic}/{text}/{image}/{userID}")
    public void addArticle(@PathVariable("title") String title,
                           @PathVariable("topic") String topic,
                           @PathVariable("text") String text,
                           @PathVariable("image") byte[] image,
                           @PathVariable("userID") String userId){
        service.addArticle(title,topic,Integer.parseInt(userId),text,image);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteArticle(@PathVariable("id") String id){
        service.deleteArticle(Integer.parseInt(id));
    }
    
    @PostMapping ("/updateArticle/{id}{title}/{topic}/{text}/{image}/{userID}")
    public void addArticle(@PathVariable("id") int id,
                           @PathVariable("title") String title,
                           @PathVariable("topic") String topic,
                           @PathVariable("text") String text,
                           @PathVariable("image") byte[] image,
                           @PathVariable("userID") String userId){
        service.updateArticle(id,title,topic,Integer.parseInt(userId),text,image);
    }
}
