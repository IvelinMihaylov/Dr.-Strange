package com.drstrange.drstrange.data;

import com.drstrange.drstrange.data.base.ArticleRepository;
import com.drstrange.drstrange.models.Article;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleSqlRepository implements ArticleRepository {
  private SessionFactory factory;

//    @Autowired
//    public ArticleSqlRepository(SessionFactory factory){
//        this.factory = factory;
//    }
  
  @Override
  public Article findById(int id) {
    Article article = null;
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 article = session.get(Article.class, id);
	 session.getTransaction().commit();
    } catch (SessionException ex) {
	 System.out.println(ex.getMessage());
    }
    return article;
  }
  
  @Override
  public List<Article> findByName(String articleTitle) {
    List<Article> article = null;
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 article = (session.createSQLQuery("SELECT * FROM Article WHERE title = '" + articleTitle + "'")).list();
	 session.getTransaction().commit();
    } catch (SessionException ex) {
	 System.out.println(ex.getMessage());
    }
    return article;
  }
  
  @Override
  public List<Article> filterBySequence(String sequence) {
    List<Article> articles = null;
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 articles = (session.createSQLQuery("SELECT * FROM Article WHERE topic = '" + sequence + "'")).list();
	 session.getTransaction().commit();
    } catch (SessionException ex) {
	 System.out.println(ex.getMessage());
    }
    return articles;
  }
  
  @Override
  public List<Article> listAll() {
    List<Article> articles = new ArrayList<>();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 articles = session.createQuery("FROM Article").list();
	 session.getTransaction().commit();
    } catch (Exception e) {
	 System.out.println(e.getMessage());
    }
    return articles;
  }
}
