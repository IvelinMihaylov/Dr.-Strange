package com.drstrange.drstrange.services;

import com.drstrange.drstrange.data.base.UserRepository;
import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.models.User;
import com.drstrange.drstrange.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private UserRepository repository;
  
  @Autowired
  public UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }
  
  
  @Override
  public User findById(int id) {
    return repository.findById(id);
  }
  
  @Override
  public List<User> findByName(String userName) {
    return repository.findByName(userName);
  }
  
  @Override
  public List<User> loginValidation(String email, String password) {
    return repository.loginValidation(email, password);
  }
  
  @Override
  public void addUser(String firstname, String lastname, String email, String password, String nickname) {
    repository.addUser(firstname, lastname, email, password, nickname);
  }

//    @Override
//    public List<User> listAll() {
//        return repository.listAll();
//    }


}
