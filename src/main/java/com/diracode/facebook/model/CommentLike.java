package com.diracode.facebook.model;

public class CommentLike {
    private int id;
    private int commentId;
    private int userId;

    public CommentLike(int commentId, int userId) {
        this.commentId = commentId;
        this.userId = userId;
    }

    public CommentLike(int id, int commentId, int userId) {
        this(commentId, userId);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
