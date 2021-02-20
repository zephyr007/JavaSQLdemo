package com.example.Assignment2.Wallet.Repository;

import com.example.Assignment2.Wallet.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUsersInterface extends JpaRepository<User,String> {
    //functions that may be needed
    //authentication users
}
