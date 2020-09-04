package com.diracode.facebook.dao;

import com.diracode.facebook.model.Comment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
*Data access object to carryout database manipulation and definition
* on comments
* CRUD ON COMMENTS
 */

public class CommentDAO {
    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPassword;
    private Connection jdbcConnection;

    public CommentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean createComment(Comment comment) throws SQLException {
        String sql = "INSERT INTO comments (content, user_id, post_id, date) VALUES (?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, comment.getContent());
        statement.setInt(2, comment.getUserId());
        statement.setInt(3, comment.getPostId());
        statement.setString(4, comment.getLocalDate().toString());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Comment> listAllComment() throws SQLException {
        List<Comment> listComment = new ArrayList<>();

        String sql = "SELECT * FROM comments";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id"); // should you be included?
            String content = resultSet.getString("content");
            int userId = resultSet.getInt("user_id");
            int postId = resultSet.getInt("post_id");
            LocalDate timestamp = LocalDate.parse(resultSet.getString("date"));


            Comment comment = new Comment(id, content, userId, postId, timestamp);
            listComment.add(comment);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listComment;
    }

    public boolean deleteComment(Comment comment) throws SQLException {
        String sql = "DELETE FROM comments where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, comment.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateComment(Comment comment) throws SQLException {
        String sql =
                "UPDATE comments SET content = ? WHERE facebook.comments.id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, comment.getContent());
        statement.setInt(2, comment.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

}
