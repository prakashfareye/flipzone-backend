package com.fareye.flipzone.service;

import com.fareye.flipzone.model.User;
import com.fareye.flipzone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class Userservice {

    @Autowired
    UserRepository userRepository;
    public void  addUser(User u) {
        userRepository.save(u);
    }

    public List<User>  getAlluser() {

        List<User> users= userRepository.findAll();
        System.out.println(users);
        return users;
    }

}
