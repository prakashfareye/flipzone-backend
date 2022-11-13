package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.User;
import com.fareye.flipzone.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

    @Autowired
    Userservice userService;

    @PostMapping(path = "/user")
    @CrossOrigin(origins = "http://localhost:3000")
    public String add(@RequestBody User user) throws Exception{
        userService.addUser(user);
        return "User Added Successfully";
        // return user_todo.userList;
    }
    @GetMapping(path = "/users")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<User> getusers() throws Exception
    {
        return userService.getAlluser();
    }
//    @PutMapping(path = "/user")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public List<User> updateusers(@RequestBody User user) throws Exception
//    {
//        return userService.getAlluser();
//    }
//    @DeleteMapping(path = "/userbyid")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public String deleteeuser(@RequestParam String id) throws Exception
//    {
//        Integer id1=Integer.parseInt(id);
//        userService.deleteUser(id1);
//        return "user deleted Succesfully";
//    }
//    @GetMapping(path = "/userbyid")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public User getuserbyiduser(@RequestParam String id) throws Exception
//    {
//        Integer id1=Integer.parseInt(id);
//        return  userService.getuserbyid(id1);
//    }


}
