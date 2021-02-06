package com.example.Assignment2.Repository;

import com.example.Assignment2.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

public interface UserInterface extends JpaRepository<UserModel,Integer> {
    //user info
}
