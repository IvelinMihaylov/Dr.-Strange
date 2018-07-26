package com.drstrange.drstrange.data;

import com.drstrange.drstrange.data.base.UserRepository;
import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserSqlRepository implements UserRepository {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Article.class)
                .buildSessionFactory();
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
    public List<User> listAll() {
        return null;
    }
}
