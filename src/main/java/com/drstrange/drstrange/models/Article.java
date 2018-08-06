package com.drstrange.drstrange.models;

import javax.persistence.*;

@Entity(name = "Article")
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articleID")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "topic")
    private String topic;

//    @Column(name = "userID", in)
    private int userId;

    @Column(name = "text")
    private String text;

    @Column(name = "image")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private User user;

    public Article() {
    }

    public Article(String title, String topic , int userId, String text, byte[] image) {
        this.title = title;
        this.topic = topic;
        this.userId = userId;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}

