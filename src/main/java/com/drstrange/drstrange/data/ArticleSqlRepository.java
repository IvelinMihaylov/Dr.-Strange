package com.drstrange.drstrange.data;

import com.drstrange.drstrange.data.base.ArticleRepository;
import com.drstrange.drstrange.models.Article;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Repository
public class ArticleSqlRepository implements ArticleRepository {
  private static SessionFactory factory;
  
  @Autowired
  public ArticleSqlRepository(SessionFactory factory) {
    this.factory = factory;
  }

//  @Override
//  public Article findById(int id) {
//    Article article = null;
//    try (Session session = factory.openSession()) {
//	 session.beginTransaction();
//	 article = session.get(Article.class, id);
//	 session.getTransaction().commit();
//    } catch (SessionException ex) {
//	 System.out.println(ex.getMessage());
//    }
//    return article;
//  }
  
  @Override
  public List<Article> findByName(String articleTitle) {
    List<Article> articles = new ArrayList<>();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 List<Object[]> query = (session.createSQLQuery("SELECT * FROM Article WHERE title = '" + articleTitle + "'")).list();
	 for(Object[] entity : query) {
	   Article article = new Article();
	   article.setId(Integer.parseInt(entity[0].toString()));
	   article.setTitle(entity[1].toString());
	   article.setTopic(entity[2].toString());
	   article.setUserId(Integer.parseInt(entity[3].toString()));
	   article.setText(entity[4].toString());
	   article.setImage(entity[5].toString());
	   articles.add(article);
	 }
	 session.getTransaction().commit();
    } catch (SessionException ex) {
	 System.out.println(ex.getMessage());
    }
    return articles;
  }
  
  @Override
  public List<Article> findByAuthor(int authorID) {
    List<Article> articles = null;
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 List<Object[]> query = (session.createSQLQuery("SELECT * FROM Article WHERE userID = '" + authorID + "'")).list();
	 for(Object[] entity : query) {
	   Article article = new Article();
	   article.setId(Integer.parseInt(entity[0].toString()));
	   article.setTitle(entity[1].toString());
	   article.setTopic(entity[2].toString());
	   article.setUserId(Integer.parseInt(entity[3].toString()));
	   article.setText(entity[4].toString());
	   article.setImage(entity[5].toString());
	   articles.add(article);
	 }
	 session.getTransaction().commit();
    } catch (SessionException ex) {
	 System.out.println(ex.getMessage());
    }
    return articles;
  }
  
  @Override
  public List<Article> filterBySequence(String sequence) {
    List<Article> articles = null;
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 List<Object[]> query = (session.createSQLQuery("SELECT * FROM Article WHERE topic = '" + sequence + "'")).list();
	 for(Object[] entity : query) {
	   Article article = new Article();
	   article.setId(Integer.parseInt(entity[0].toString()));
	   article.setTitle(entity[1].toString());
	   article.setTopic(entity[2].toString());
	   article.setUserId(Integer.parseInt(entity[3].toString()));
	   article.setText(entity[4].toString());
	   article.setImage(entity[5].toString());
	   articles.add(article);
	 }
	 session.getTransaction().commit();
    } catch (SessionException ex) {
	 System.out.println(ex.getMessage());
    }
    return articles;
  }
  
  @Override
  public List<Article> listAllArticle() {
    List<Article> articles = new ArrayList<>();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 List<Object[]> query = session.createSQLQuery("SELECT * FROM Article").list();
	 
	 for(Object[] entity : query) {
	   Article article = new Article();
	   article.setId(Integer.parseInt(entity[0].toString()));
	   article.setTitle(entity[1].toString());
	   article.setTopic(entity[2].toString());
	   article.setUserId(Integer.parseInt(entity[3].toString()));
	   article.setText(entity[4].toString());
	   article.setImage(entity[5].toString());
	   articles.add(article);
	 }
	 session.getTransaction().commit();
    } catch (Exception e) {
	 System.out.println(e.getMessage());
    }
    
    return articles;
  }
  
  
  @Override
  public void addArticle(String title, String topic, int userId, String text, String image) {
    Article article = new Article(title, topic, userId, text, image);
    
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.save(article);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
  
  @Override
  public void deleteArticle(int id) {
    Article article = null;
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 article = session.get(Article.class, id);
	 session.delete(article);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
  
  @Override
  public void updateArticle(int id, String title, String topic, int userId, String text, String image) {
    Article article = new Article(title, topic, userId, text, image);
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.update(article);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
}
