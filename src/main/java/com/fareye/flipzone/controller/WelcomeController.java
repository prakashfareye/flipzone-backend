package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.User;
import com.fareye.flipzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;

//    @GetMapping("/getUser")
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<User> welcome(Authentication authentication) {
        String emailOfLoggedInUser = authentication.getName();
        User user = userService.findByEmail(emailOfLoggedInUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return "You are authenticated as " + authentication.getName();
    }

    @RequestMapping(value = "/api/admin/user/{username}", method = RequestMethod.GET)
    public UserDetails getListOfUser(@PathVariable String username){
        return userDetailsService.loadUserByUsername(username);
    }
}