package com.fareye.flipzone.service;

import com.fareye.flipzone.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> getUsers();

    User getUserById(long id);

    User findByEmail(String email);

    User updateUser(long id, User user);

    void deleteUserById(long id);
}
