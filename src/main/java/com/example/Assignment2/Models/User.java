package com.example.Assignment2.Models;

import com.sun.istack.NotNull;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "ID")
    public String id;

    @NotNull
    @Column(name = "PassCode")
    private String pass;

    @Column(name = "Role")
    public String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
