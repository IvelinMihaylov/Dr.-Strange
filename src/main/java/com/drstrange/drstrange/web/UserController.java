package com.drstrange.drstrange.web;

import com.drstrange.drstrange.models.User;
import com.drstrange.drstrange.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id) {
        return service.findById(Integer.parseInt(id));
    }

    @GetMapping ("/{name}")
    public User findByName(@PathVariable ("name") String name) {
        return service.findByName(name);
    }

    @GetMapping ("/all")
    public List<User> getAll() {
        return service.listAll();
    }


}
