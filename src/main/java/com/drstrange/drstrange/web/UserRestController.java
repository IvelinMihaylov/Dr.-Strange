package com.drstrange.drstrange.web;

import com.drstrange.drstrange.models.User;
import com.drstrange.drstrange.models.UserDetails;
import com.drstrange.drstrange.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping ("/api/user")
public class UserRestController {
    private UserService service;
    
    @Autowired
    public UserRestController(UserService service) {
        this.service = service;
    }
    
    @GetMapping ("/login")
    public String showLogin(Model model){
        model.addAttribute("/login");
        return "base-layout";
    }
    
    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }

        return "redirect:/";
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profilePage(Model model){
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        User user = this.service.loginValidation(principal.getEmail(),principal.getPassword());

        model.addAttribute("user", user);
        model.addAttribute("view", "/profil");

        return "base-layout";
    }
    
    @PostMapping ("registration/{firstname}/{lastname}/{email}/{password}/{nickname}")
    public void registration(@PathVariable ("firstname") String firstname,
                             @PathVariable ("lastname") String lastname,
                             @PathVariable ("email") String email,
                             @PathVariable ("password") String password,
                             @PathVariable ("nickname") String nickname){
        service.addUser(firstname,lastname,email,password,nickname);
    }
    @GetMapping ("byID/{id}")
    public User findById(@PathVariable ("id") String id) {
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
