package com.example.Assignment2.JWT.Model;

public class AuthReq {
    public String username;
    public String password;

    public AuthReq(){
    }

    public AuthReq(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
