package com.diracode.facebook.model;


import java.time.LocalDate;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String gender;
    private String password;

    public User(int id, String firstName, String lastName, String email, LocalDate dob, String gender, String password) {
        this(firstName, lastName, email, dob, gender, password);
        this.id = id;
    }

    public User(String firstName, String lastName, String email, LocalDate dob, String gender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.password = password;
    }

    public User(int id) {
        this.id = id;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
