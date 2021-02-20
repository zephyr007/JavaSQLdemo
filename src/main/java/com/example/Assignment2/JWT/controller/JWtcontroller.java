package com.example.Assignment2.JWT.controller;

import com.example.Assignment2.JWT.Model.AuthReq;
import com.example.Assignment2.JWT.Model.AuthRes;
import com.example.Assignment2.JWT.Service.MyUserDetailsService;
import com.example.Assignment2.JWT.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class JWtcontroller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @GetMapping("/hello")
    public String getAuth(){
        return "Hello World! Server Check";
    }

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthReq authReq) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword())
            );
        } catch (BadCredentialsException e){
            System.out.println("Authorization failed");
            throw new Exception("Incorrect Username or Password",e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authReq.getUsername());

        final  String jwt= jwtTokenUtil.generateToken(userDetails);
        System.out.println("Authorization API Success");

        return ResponseEntity.ok(new AuthRes(jwt));
    }

}
