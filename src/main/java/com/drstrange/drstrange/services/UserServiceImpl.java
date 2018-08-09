package com.drstrange.drstrange.services;

import com.drstrange.drstrange.data.base.UserRepository;
import com.drstrange.drstrange.models.User;
import com.drstrange.drstrange.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository repository;

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
    public User loginValidation(String email, String password) {
        return repository.loginValidation(email, password);
    }

    @Override
    public void addUser(String firstname, String lastname, String email, String password, String nickname) {
        repository.addUser(firstname, lastname, email, password, nickname);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.loginValidation(email, "%");
        if (user == null) {
            throw new UsernameNotFoundException("Invalid User");
        } else {
            Set<GrantedAuthority> grantedAuthorities = user.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toSet());
            return new org
                    .springframework
                    .security
                    .core
                    .userdetails
                    .User(user.getEmail(), user.getPassword(), grantedAuthorities);
        }

    }

//    @Override
//    public List<User> listAll() {
//        return repository.listAll();
//    }


}
