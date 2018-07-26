package com.drstrange.drstrange.services.base;

import com.drstrange.drstrange.models.User;

import java.util.List;

public interface UserService {
    User findById(int id);

    User findByName(String userName);

    List<User> listAll();
}
