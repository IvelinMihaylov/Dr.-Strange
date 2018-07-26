package com.drstrange.drstrange.services;

import com.drstrange.drstrange.data.base.UserRepository;
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
