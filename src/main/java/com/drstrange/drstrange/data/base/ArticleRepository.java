package com.drstrange.drstrange.data.base;

import com.drstrange.drstrange.models.Article;

import java.io.Serializable;
import java.util.List;

public interface ArticleRepository extends Serializable {
    //    Article findById(int id);
    List<Article> findByName(String articleTitle);
    List<Article> filterBySequence(String sequence);
    List<Article> listAllArticle();
    List<Article> findByAuthor(int authorID);
    void addArticle(String title, String topic, int userId, String text, String image);
    void deleteArticle(int id);
    void updateArticle(int id, String title, String topic, int userId, String text, String image);
}
