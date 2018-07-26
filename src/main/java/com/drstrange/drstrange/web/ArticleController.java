package com.drstrange.drstrange.web;


import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.services.base.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    private ArticleService service;

    @Autowired
    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Article findById(@PathVariable("id") String id) {
        return service.findById(Integer.parseInt(id));
    }

    @GetMapping ("/{name}")
    public Article findByName(@PathVariable ("name") String name) {
        return service.findByName(name);
    }

    @GetMapping ("/all")
    public List<Article> getAll() {
        return service.listAll();
    }

    @GetMapping ("/filterBySequence/{filter}")
    public List<Article> filterBySequence(@PathVariable ("filter") String filter) {
        return service.filterBySequence(filter);
    }

}
