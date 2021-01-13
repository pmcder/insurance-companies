package com.pmcderm.insapi.controllers;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.pmcderm.insapi.entities.User;
import com.pmcderm.insapi.security.LoginDto;
import com.pmcderm.insapi.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    

    
    private UserService userService;
    
    private static final Logger logger = LogManager.getLogger(UserController.class);
    
    
    @Autowired
    public UserController(UserService userService) {
		this.userService = userService;
	}

    @CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/signin")
    public String login(@RequestBody @Valid LoginDto loginDto) {
    logger.info("user with the following username signed in: "+ loginDto.getUsername());
       return userService.signin(loginDto.getUsername(), loginDto.getPassword()).orElseThrow(()->
       new HttpServerErrorException(HttpStatus.FORBIDDEN, "Login Failed"));
    }
	
	  @PostMapping("/signup")
	    public User signup(@RequestBody @Valid LoginDto loginDto){
	        return userService.signup(loginDto.getUsername(), loginDto.getPassword(), loginDto.getFirstName(),
	                loginDto.getLastName()).orElseThrow(() -> new RuntimeException("User already exists"));
	    }
}