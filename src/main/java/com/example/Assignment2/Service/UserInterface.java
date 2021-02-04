package com.example.Assignment2.Service;

import com.example.Assignment2.Models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserInterface extends CrudRepository<UserModel,Integer> {

}
