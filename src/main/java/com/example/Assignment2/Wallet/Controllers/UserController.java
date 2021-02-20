package com.example.Assignment2.Wallet.Controllers;

import com.example.Assignment2.Wallet.Models.UserModel;
import com.example.Assignment2.Wallet.Repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserInterface userInterface;

    @PostMapping(path = "/user")
    public @ResponseBody
    UserModel addUser(@RequestBody UserModel user){
        System.out.println("User POST API");
        if(userInterface.findById(user.getId()).isPresent()) {
            UserModel user2=userInterface.findById(user.getId()).get();
            String emailID=user.getEmailID();
            String mobileNo=user.getMobileNumber();
            if (user2.getEmailID().equals(emailID)||user2.getMobileNumber().equals(mobileNo))
            {
                String res="User Already Exists "+"at "+user.getId();
                System.out.println(res);
                return null;
            }
            else
            {
                userInterface.save(user);
                String res="User Added at Different UserName "+user.getId();
                System.out.println(res);
                return user;
            }
        }
        userInterface.save(user);
        String res= "User Added at"+user.getId();
        System.out.println(res);
        return user;
    }

    //post mapping and requesting parameters
    @PostMapping(path = "/userParams")
    public @ResponseBody
    String addUser(@RequestParam Integer userName,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam String mobileNumber,
                                        @RequestParam String emailID,
                                        @RequestParam String address1,
                                        @RequestParam String address2) {

        //intializing user
        UserModel user=new UserModel();

        //Setting params
        //since it auto generated
//        user.setId(userName);
        user.setFirstName(firstName);
        user.setMobileNumber(mobileNumber);
        user.setLastName(lastName);
        user.setEmailID(emailID);
        user.setAddress1(address1);
        user.setAddress2(address2);

        //vaildation step
        //find all user by same userName

        Optional<UserModel> user1=userInterface.findById(userName);
        if(user1.isPresent()){
            System.out.println("User Already exists at"+userName);
            UserModel user2=user1.get();
            System.out.println("Email ID: " +user2.getEmailID() +" :: New emailID: "+emailID);
            if(user2.getEmailID().equals(emailID))
            {
                String response="User added at "+user.getId()+"prev Email ID: " +user2.getEmailID() +" :: New emailID: "+emailID;
                return response;
            }
            else if(user2.getMobileNumber().equals(mobileNumber))
            {
                String response="User added at "+user.getId()+"prev phone no: " +user2.getMobileNumber() +" :: New phoneNO: "+mobileNumber;
                return response;
            }
            else
            {
//                user.setId(userName);
                userInterface.save(user);
                String response = "User added at" + user.getId() + ("UserName " + user.getId() + " Already Used, prev Email ID: " + user2.getEmailID() + " :: New emailID: " + emailID);
                return response;
            }
        }

        //setting userId since it doesnot exists
        user.setId(userName);
        //Adding to Db
        userInterface.save(user);

        return "User Added";
    }

    @GetMapping(path = "/user")
    public @ResponseBody
    Optional<UserModel> getUser(@RequestParam Integer userName){
        System.out.println("User GET API Called");
        return userInterface.findById(userName);
    }

    @GetMapping(path = "/allUsers")
    public @ResponseBody
    Iterable<UserModel> getAll(){
        System.out.println("User GET ALL API");
        return userInterface.findAll();
    }



    @PutMapping(path = "/user")
    public @ResponseBody
    UserModel updateByID(@RequestBody UserModel userModel){
        if(!userInterface.findById(userModel.getId()).isPresent())
        {
            String res="User does not exist";
            System.out.println(res);
            return null;
        }

        //update user info here
        UserModel n=userInterface.findById(userModel.getId()).get();
        n.SetValues(userModel);

        userInterface.save(n);

        String res1 = "User updated";
        System.out.println(res1);
        return n;
    }


    @DeleteMapping(path = "/user")
    public @ResponseBody
    String delByID(@RequestParam Integer userName){
        if(!userInterface.findById(userName).isPresent())
        {
            String res= "User Id Invalid";
            System.out.println(res);
            return res;
        }
        userInterface.deleteById(userName);
        String res="User Deleted";
        System.out.println(res);
        return res;
    }

}

/***
 * REST application of user management using Spring Boot and Spring Data. This application will perform basic CRUD(Create, Read , Update , Delete) operations on the User table.
 * 1.API which will create a user in the user table.
 * url:http://localhost:8080/user
 * METHOD : POST
 * input:userName , firstName, lastName, mobileNumber , emailID, address1, address2
 * Validations : same email id, userName or phone number (user already exists)
 *
 * 2.API which will read data from the database.
 * url:http://localhost:8080/user?userId=<userID>
 * METHOD: GET
 * Result: ashutosh,rathor, 999999999, ashutosh.rathor@paytm.com
 *
 * 3.Update API
 * url:http://localhost:8080/user
 * requestParam: userID
 * METHOD:(PUT)
 * validation: user should exist
 *
 * 4.API which will delete data in the user table.
 * url:http://localhost:8080/user
 * requestParam: userID
 * validation: user should exist
 * ***/
