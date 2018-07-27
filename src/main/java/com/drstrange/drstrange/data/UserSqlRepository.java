package com.drstrange.drstrange.data;

import com.drstrange.drstrange.data.base.UserRepository;
import com.drstrange.drstrange.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserSqlRepository implements UserRepository {
    private static SessionFactory sessionFactory;

    @Autowired
    public UserSqlRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Session session = sessionFactory.openSession())  {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public User loginValidation(String userName, String passWord) {
        List users = new ArrayList();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            //language=HQL
            users = session.createNativeQuery("select u.id from user as u where u.userName=:userName AND u.passWord=:passWord", User.class)
                    .setParameter("userName", userName)
                    .setParameter("passWord", passWord)
                    .list();

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (users.size()<1){
            return null;
        }
        else {
            return (User) users.get(0);
        }
    }

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            users = session.createQuery("from User", User.class).list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }
}
