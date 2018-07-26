package com.drstrange.drstrange.config;

import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.models.User;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
   public SessionFactory createFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Article.class)
                .buildSessionFactory();
    }
}
