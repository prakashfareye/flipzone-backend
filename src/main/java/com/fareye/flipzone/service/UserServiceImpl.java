package com.fareye.flipzone.service;

import com.fareye.flipzone.model.User;
import com.fareye.flipzone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new FileSystemNotFoundException("User not found")
        );
    }

    @Override
    public User updateUser(long id, User user) {
        user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.findById(id).orElseThrow(
                () -> new FileSystemNotFoundException("User not found")
        );
        userRepository.deleteById(id);
    }
}
