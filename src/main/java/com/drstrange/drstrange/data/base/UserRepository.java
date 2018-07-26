package com.drstrange.drstrange.data.base;

import com.drstrange.drstrange.models.User;

import java.util.List;

public interface UserRepository {
    User findById(int id);
    User findByName(String userName);
    List<User> listAll();
}
