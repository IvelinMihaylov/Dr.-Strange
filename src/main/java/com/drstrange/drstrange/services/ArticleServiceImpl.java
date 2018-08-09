package com.drstrange.drstrange.services;

import com.drstrange.drstrange.data.base.ArticleRepository;
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

//    @Override
//    public Article findById(int id) {
//        return null;
//    }
  
  @Override
  public List<Article> findByName(String articleTitle) {
    return repository.findByName(articleTitle);
  }
  
  @Override
  public List<Article> filterBySequence(String sequence) {
    return repository.filterBySequence(sequence);
  }
  
  @Override
  public List<Article> listAllArticle() {
    return repository.listAllArticle();
  }
  
  @Override
  public List<Article> findByAuthor(int authorID) {
    return repository.findByAuthor(authorID);
  }
  
  @Override
  public void addArticle(String title, String topic, int userId, String text, String image) {
    repository.addArticle(title, topic, userId, text, image);
  }
  
  @Override
  public void deleteArticle(int id) {
    repository.deleteArticle(id);
  }
  
  @Override
  public void updateArticle(int id, String title, String topic, int userId, String text, String image) {
    repository.updateArticle(id,title,topic,userId,text,image);
  }
}
