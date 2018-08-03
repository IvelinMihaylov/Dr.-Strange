package com.drstrange.drstrange.web;

import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.models.User;
import com.drstrange.drstrange.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    
    @GetMapping("login/{email}/{password}")
    public List<User> logging(@PathVariable("email") String email,
    @PathVariable("password") String password){
     return service.loginValidation(email,password);
    }
    @PostMapping("registration/{firstname}/{lastname}/{email}/{password}/{nickname}")
    public void registration(@PathVariable("firstname") String firstname,
                             @PathVariable("lastname") String lastname,
                             @PathVariable("email") String email,
                             @PathVariable("password") String password,
                             @PathVariable("nickname") String nickname){
        service.addUser(firstname,lastname,email,password,nickname);
    }
    @GetMapping("byID/{id}")
    public User findById(@PathVariable("id") String id) {
        return service.findById(Integer.parseInt(id));
    }

    @GetMapping ("byName/{name}")
    public List<User> findByName(@PathVariable ("name") String name) {
        return service.findByName(name);
    }

//    @GetMapping ("/all")
//    public List<User> getAll() {
//        return service.listAll();
//    }



}
