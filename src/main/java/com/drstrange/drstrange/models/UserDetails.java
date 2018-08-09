package com.drstrange.drstrange.models;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetails extends User implements org.springframework.security.core.userdetails.UserDetails {
    private ArrayList<String> roles;
    private User user;

    public UserDetails(ArrayList<String> roles, User user) {
        super(user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(), user.getPassword());
        this.roles = roles;
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRoles = StringUtils.collectionToCommaDelimitedString(this.roles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(userRoles);
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}

