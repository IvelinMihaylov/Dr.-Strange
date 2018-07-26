package com.drstrange.drstrange.services.base;

import com.drstrange.drstrange.models.Article;

import java.util.List;

public interface ArticleService {
    Article findById(int id);
    Article findByName(String articleTitle);
    List<Article> filterBySequence(String sequence);
    List<Article> listAll();
}
