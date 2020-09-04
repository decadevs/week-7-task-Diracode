package com.diracode.facebook.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Comment {
    private int id;
    private String content;
    private int userId;
    private int postId;
    private LocalDate date;


    public Comment(int id, String content, int userId, int postId, LocalDate date) {
        this(content, userId, date, postId);
        this.id = id;
    }
    public Comment(String content, int userId, LocalDate date, int postId) {
        this.content = content;
        this.userId = userId;
        this.date = date;
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public void setLocalDate(LocalDate date) {
        this.date = date;
    }
}
