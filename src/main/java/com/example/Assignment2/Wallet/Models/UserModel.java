package com.example.Assignment2.Wallet.Models;

import javax.persistence.*;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {

    @Id
//    "0baa699c-1524-4033-b67e-de931cc98e8f"
    private Integer Id;

    @NotNull
    @Column(name = "FirstName")
    public String firstName;

    @NotNull
    @Column(name = "LastName")
    public String lastName;

    @NotNull
    @Column(name = "MobileNumber")
    public String mobileNumber;

    @NotNull
    @Column(name = "EmailID")
    public String emailID;

    @Column(name = "address1")
    public String address1;
    @Column(name = "address2")
    public String address2;

    public void SetValues(UserModel userWithoutID){
        this.Id=userWithoutID.getId();
        this.firstName = userWithoutID.getFirstName();
        this.lastName = userWithoutID.getLastName();
        this.mobileNumber = userWithoutID.getMobileNumber();
        this.emailID = userWithoutID.getEmailID();
        this.address1 = userWithoutID.getAddress1();
        this.address2 = userWithoutID.getAddress2();

    }

//    public UserModel(String userName, String firstName, String lastName, String mobileNumber, String emailID, String address1, String address2) {
//        this.userName = userName;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.mobileNumber = mobileNumber;
//        this.emailID = emailID;
//        this.address1 = address1;
//        this.address2 = address2;
//    }

//    public String getUserName(){
//        return userName;
//    }
//
//    public void setUserName(String userName)   { this.userName=userName; }


//    public Integer getId() {
//        return Id;
//    }
//
    public void setId(Integer id) {
        Id = id;
    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getMobileNumber() {
//        return mobileNumber;
//    }
//
//    public void setMobileNumber(String mobileNumber) {
//        this.mobileNumber = mobileNumber;
//    }
//
//    public String getEmailID() {
//        return emailID;
//    }
//
//    public void setEmailID(String emailID) {
//        this.emailID = emailID;
//    }
//
//    public String getAddress1() {
//        return address1;
//    }
//
//    public void setAddress1(String address1) {
//        this.address1 = address1;
//    }
//
//    public String getAddress2() {
//        return address2;
//    }
//
//    public void setAddress2(String address2) {
//        this.address2 = address2;
//    }
}
