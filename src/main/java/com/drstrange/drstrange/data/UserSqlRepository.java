package com.drstrange.drstrange.data;

import com.drstrange.drstrange.data.base.UserRepository;
import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
        return null;
    }

    @Override
    public User findByName(String userName) {
        return null;
    }

    @Override
    public List<User> listAll()
    {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession())  {
            session.beginTransaction();
            users = session.createQuery("from user", User.class).list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }
}
