package com.example.restapimongodb9.controllers;

import com.example.restapimongodb9.CustomizedResponse;
import com.example.restapimongodb9.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

//@CrossOrigin (origins = "http://localhost:3000")
@CrossOrigin (origins = "https://calm-waters-55186.herokuapp.com")

@RestController
public class AuthController
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value="/auth", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity login(@RequestBody UserModel user)
    {


        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            var response = new CustomizedResponse( "You login Successfully", null);

            return new ResponseEntity( response, HttpStatus.OK);

        }

        catch (BadCredentialsException ex)
        {


            var response = new CustomizedResponse( "You username/password were entered incorrectly..", null);

            return new ResponseEntity( response, HttpStatus.UNAUTHORIZED);
        }



    }




}
