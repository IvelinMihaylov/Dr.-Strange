package com.drstrange.drstrange.data;

import com.drstrange.drstrange.data.base.ArticleRepository;
import com.drstrange.drstrange.models.Article;

import java.util.List;

public class ArticleSqlRepository implements ArticleRepository {
    @Override
    public Article findById(int id) {
        return null;
    }

    @Override
    public Article findByName(String articleTitle) {
        return null;
    }

    @Override
    public List<Article> filterBySequence(String sequence) {
        return null;
    }

    @Override
    public List<Article> listAll() {
        return null;
    }
}
