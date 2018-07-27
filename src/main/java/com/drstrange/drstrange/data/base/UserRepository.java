package com.drstrange.drstrange.data.base;

import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.models.User;

import java.util.List;

public interface UserRepository {
    User findById(int id);
    User loginValidation(String userName, String passWord);
    List<User> listAll();
    void addArticle(String title, String topic , int userId, String text, byte[] image);
    void deleteArticle(int id);
}
