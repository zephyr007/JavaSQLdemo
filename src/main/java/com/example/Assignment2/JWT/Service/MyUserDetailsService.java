package com.example.Assignment2.JWT.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    String username="foo";
    String password="foo";

    //we can also add Interface to store data on my SQl or Elastic search and feed it in loadUserByUsername
    public void ChangeUsernamePassword(String u1,String p1){
        username=u1;
        password=p1;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new User(username,password,new ArrayList<>());
    }


}
