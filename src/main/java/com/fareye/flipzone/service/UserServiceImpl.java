package com.fareye.flipzone.service;

import com.fareye.flipzone.model.User;
import com.fareye.flipzone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
    public User findByEmail(String email) {
        User user = userRepository.findByUserEmailId(email);
        return user != null ? user : null;
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
