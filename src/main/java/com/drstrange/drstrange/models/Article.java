package com.drstrange.drstrange.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "article")
public class Article {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column (name = "articleID")
  private int id;
  
  @Column (name = "title")
  private String title;
  
  @Column (name = "author")
  private int author;
  
  @Column (name = "text")
  private String text;
  
  @Column (name = "image")
  private byte[] image;
  
  public Article() {
  }
  
  public Article(String title, int author, String text, byte[] image) {
    this.title = title;
    this.author = author;
    this.text = text;
    this.image = image;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public int getAuthor() {
    return author;
  }
  
  public void setAuthor(int author) {
    this.author = author;
  }
  
  public String getText() {
    return text;
  }
  
  public void setText(String text) {
    this.text = text;
  }
  
  public byte[] getImage() {
    return image;
  }
  
  public void setImage(byte[] image) {
    this.image = image;
  }

  @ManyToOne
  @JoinColumn (name = "userID")
  private User user;
}

