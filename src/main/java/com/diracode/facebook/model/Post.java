package com.diracode.facebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Post {
    private int id;
    private String content;
    private int userId;
    private LocalDate date;

    public Post(String content, int userId, LocalDate date) {
        this.content = content;
        this.userId = userId;
        this.date = date;
    }

    public Post(int id, String content, int userId, LocalDate date) {
        this(content, userId, date);
        this.id = id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
