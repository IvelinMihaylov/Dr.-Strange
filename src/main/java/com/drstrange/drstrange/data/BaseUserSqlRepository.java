package com.drstrange.drstrange.data;

import com.drstrange.drstrange.data.base.UserRepository;
import com.drstrange.drstrange.models.User;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseUserSqlRepository implements UserRepository {
  private static SessionFactory factory;
  
  @Autowired
  public BaseUserSqlRepository(SessionFactory factory) {
    this.factory = factory;
  }
  
  @Override
  public User findById(int id) {
    User user = null;
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 user = session.get(User.class, id);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
    return user;
  }
  
  @Override
  public List<User> findByName(String name) {
    List<User> users = null;
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 users = (List<User>) (session.createSQLQuery("SELECT * FROM user WHERE firstName = '" + name + "';")).getResultList().get(0);
	 session.getTransaction().commit();
    } catch (SessionException ex) {
	 System.out.println(ex.getMessage());
    }
    return users;
  }
  
  @Override
  public User loginValidation(String email, String password) {
    List<User> users = null;
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 users = (session.createSQLQuery("SELECT * FROM user WHERE email = '" + email + "' AND password = '" + password + "';")).list();
	 session.getTransaction().commit();
    } catch (SessionException ex) {
	 System.out.println(ex.getMessage());
    }
//    if(users.size()>0){     AND password = '" + password + "'"
//	 System.out.println(users.get(0));
//    System.out.println(users.get(0).getFirstname() +" "+ users.get(0).getLastname());}
//    else
//	 System.out.println("no match");
    return users.get(0);
  }
  
  @Override
  public void addUser(String firstname, String lastname, String email, String password, String nickname) {
    User user = new User(firstname, lastname, email, password, nickname);
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.save(user);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }

//    @Override
//    public List<User> listAll() {
//        List<User> users = new ArrayList<>();
//        try (Session session = factory.openSession()) {
//            session.beginTransaction();
//            users = session.createQuery("from User", User.class).list();
//            session.getTransaction().commit();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return users;
//    }


}
