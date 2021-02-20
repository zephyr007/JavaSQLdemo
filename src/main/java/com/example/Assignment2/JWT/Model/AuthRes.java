package com.example.Assignment2.JWT.Model;

public class AuthRes {

    private final String jwt;

    public AuthRes(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

}
