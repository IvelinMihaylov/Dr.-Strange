package com.drstrange.drstrange.services;

import com.drstrange.drstrange.data.base.ArticleRepository;
import com.drstrange.drstrange.data.base.UserRepository;
import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.services.base.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository repository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository repository) {
        this.repository = repository;
    }

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
