package com.drstrange.drstrange.data.base;

import com.drstrange.drstrange.models.Article;

import java.util.List;

public interface ArticleRepository {
//    Article findById(int id);
    List<Article> findByName(String articleTitle);
    List<Article> filterBySequence(String sequence);
    List<Article> listAllArticle();
    List<Article> findByAuthor(int authorID);
    void addArticle(String title, String topic , int userId, String text, byte[] image);
    void deleteArticle(int id);
    void updateArticle(int id, String title, String topic , int userId, String text, byte[] image);
}
