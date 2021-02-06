package com.example.Assignment2.Repository;

import com.example.Assignment2.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUsersInterface extends JpaRepository<User,String> {
    //functions that may be needed
    //authentication users
}
