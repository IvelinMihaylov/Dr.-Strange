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

    @PostMapping("/addArticle/{title}/{topic}/{text}/{image}/{userID}")
    public void addArticle(@PathVariable("title") String title,
                           @PathVariable("title") String topic,
                           @PathVariable("title") String text,
                           @PathVariable("title") String image,
                           @PathVariable("title") String userId){
        service.addArticle(title,topic,Integer.parseInt(userId),text,null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArticle(@PathVariable("id") String id){
        service.deleteArticle(Integer.parseInt(id));
    }

}
