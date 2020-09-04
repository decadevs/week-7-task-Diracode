package com.diracode.facebook.dao;

import com.diracode.facebook.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 *
 *
 */
public class UserDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public boolean createUser(User user) throws SQLException { // MODIFICATIONS USE PREPAREDSTATEMENT
        String sql = "INSERT INTO users (id, firstName, lastName, email, dob, gender, password) VALUES (?, ?, ?, ?, ?, ?,?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, String.valueOf(user.getId()));
        statement.setString(2, user.getFirstName());
        statement.setString(3, user.getLastName());
        statement.setString(4, user.getEmail());
        statement.setString(5, String.valueOf(user.getDob()));
        statement.setString(6, user.getGender());
        statement.setString(7, user.getPassword());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<User> listAllUsers() throws SQLException {
        List<User> listUser = new ArrayList<>();

        String sql = "SELECT * FROM users";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id"); // should you be included?
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            LocalDate dob = LocalDate.parse(resultSet.getString("dob"), DateTimeFormatter.BASIC_ISO_DATE);
            String gender = resultSet.getString("gender");
            String password = resultSet.getString("password");


            User user = new User(id, firstName, lastName, email, dob, gender, password);
            listUser.add(user);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listUser;
    }

    public boolean deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM users where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, user.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        String sql =
                "UPDATE users SET firstname = ?, lastname = ?, email = ?," +
                        "dob = ?, gender = ?, password = ? WHERE facebook.users.id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());
        statement.setDate(4, Date.valueOf(user.getDob())); //convert local date to java.sql.Date
        statement.setString(5, user.getGender());
        statement.setString(6, user.getPassword());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public User getUser(int id) throws SQLException {
        User user = null;
        String sql = "SELEct * FROM users WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            String gender = resultSet.getString("gender");
            String password = resultSet.getString("password");

            user = new User(id, firstName, lastName, email, dob, gender, password);
        }
        resultSet.close();
        statement.close();
        return user;
    }


    public User getUser(String email, String password) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            String gender = resultSet.getString("gender");

            user = new User(id, firstName, lastName, email, dob, gender, password);
        }
        resultSet.close();
        statement.close();
        return user;
    }
}
