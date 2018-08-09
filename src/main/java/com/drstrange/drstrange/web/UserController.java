package com.drstrange.drstrange.web;

import com.drstrange.drstrange.models.User;
import com.drstrange.drstrange.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/user")
public class UserController {
  
  private final UserService userService;
  
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }
  
  @GetMapping ("/upload")
  public String articleUpload(Model model) {
    model.addAttribute("title", "User upload");
    model.addAttribute("user", new User());
    return "user/upload";
  }
  
  @PostMapping ("/upload")
  public String articleSubmit(@ModelAttribute User user) {
    userService.addUser(user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(), user.getNickname());
    return "index";
  }
  
}
