package com.diracode.facebook.dao;

import com.diracode.facebook.model.Comment;
import com.diracode.facebook.model.Post;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/*
 *Data access object to carryout database manipulation and definition
 * on comments
 * perform CRUD ON POST operations
 */

public class PostDAO {
    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPassword;
    private Connection jdbcConnection;

    public PostDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public boolean createPost(Post post) throws SQLException {
        String sql = "INSERT INTO posts (content, user_id, date) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, post.getContent());
        statement.setInt(2, post.getUserId());
        statement.setString(3, post.getDate().toString());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Post> listPosts() throws SQLException {
        List<Post> posts = new ArrayList<>();

        String sql = "SELECT * FROM posts order by date desc";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String content = resultSet.getString("content");
            int userId = resultSet.getInt("user_id");
            LocalDate timestamp = LocalDate.parse(resultSet.getString("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            Post post = new Post(id, content, userId, timestamp);
            posts.add(post);
        }

        resultSet.close();
        statement.close();

        disconnect();

        System.out.println(posts);

        return posts;
    }

    public boolean deletePost(Post post) throws SQLException {
        String sql = "DELETE FROM posts where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, post.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updatePost(Post post) throws SQLException {
        String sql =
                "UPDATE comments SET content = ? WHERE facebook.posts.id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, post.getContent());
        statement.setInt(2, post.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

}
