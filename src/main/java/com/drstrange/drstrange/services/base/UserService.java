package com.drstrange.drstrange.services.base;

import com.drstrange.drstrange.models.User;

import java.util.List;

public interface UserService {
    
    User findById(int id);
    
    List<User> findByName(String userName);
    
    List<User> loginValidation(String email, String password);
    
    void addUser(String firstname, String lastname, String email, String password, String nickname);
//    List<User> listAll();


}
