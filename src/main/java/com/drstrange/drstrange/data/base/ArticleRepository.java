package com.drstrange.drstrange.data.base;

import com.drstrange.drstrange.models.Article;

import java.util.List;

public interface ArticleRepository {
    Article findById(int id);
    List<Article> findByName(String articleTitle);
    List<Article> filterBySequence(String sequence);
    List<Article> listAll();
}
