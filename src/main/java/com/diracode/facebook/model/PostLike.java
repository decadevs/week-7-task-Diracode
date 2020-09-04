package com.diracode.facebook.model;

import lombok.Data;

@Data
public class PostLike {
    private int id;
    private int postId;
    private int userId;

    public PostLike(int postId, int userId) {
        this.postId = postId;
        this.userId = userId;
    }

    public PostLike(int id, int postId, int userId) {
        this(postId, userId);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
