package com.drstrange.drstrange.data.base;

import com.drstrange.drstrange.models.User;

import java.io.Serializable;
import java.util.List;

public interface UserRepository extends Serializable {
    
    User findById(int id);
    List<User> findByName(String name);
    User loginValidation(String email, String password);
    void addUser(String firstname, String lastname, String email, String password, String nickname);

//    List<User> listAll();
}
