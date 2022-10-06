package com.telran.phonebookframework.model;

public class User {

    String email;
    String pwd;

    public User() {
    }

    public User(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public User( String pwd) {
        this.email = generateUserEmail();
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public User setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    private String generateUserEmail() {
        return "mail" + System.currentTimeMillis() + "@mail.com";
    }

}
