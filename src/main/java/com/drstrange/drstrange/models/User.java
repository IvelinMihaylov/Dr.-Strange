package com.drstrange.drstrange.models;

import javax.persistence.*;

@Entity
@Table (name = "user")
public class User {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (name = "userID")
  private int id;
  
  @Column (name = "firstName")
  private String firstName;
  
  @Column (name = "lastName")
  private String lastName;
  
  @Column (name = "email")
  private String email;
  
  @Column (name = "password")
  private String password;
  
  @Column (name = "nickname")
  private String nickname;
  
  public User() {
  
  }
  
  public User(String firstName, String lastName, String email, String password, String nickname) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.nickname = nickname;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public String getNickname() {
    return nickname;
  }
  
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
}

