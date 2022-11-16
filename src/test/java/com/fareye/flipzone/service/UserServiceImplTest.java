package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Address;
import com.fareye.flipzone.model.User;
import com.fareye.flipzone.repository.AddressRepository;
import com.fareye.flipzone.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    PasswordEncoder passwordEncoder;
    private User user;

    @BeforeEach
    public void setup(){
        long id=2;
        user = User.builder()
                .userId(id)
                .userName("Kajal")
                .userEmailId("k1@gmail.com")
                .password("kajal")
                .role("ROLE_USER")
                .build();
    }

    @DisplayName("JUnit Test for Create User")
    @Test
    public void createNewUserTest() {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user, userService.create(user));
    }
    @DisplayName("JUnit Test for getting Users from DB")
    @Test
    public void getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(1, userService.getUsers().size());
    }

    @DisplayName("JUnit Test for getting User using userId")
    @Test
    public void getUserByIdTest() {
        long id = 2;
        when(userRepository.findById(id)).thenReturn(Optional.ofNullable(user));
        assertEquals(user,userService.getUserById(id));
    }

    @DisplayName("JUnit Test for getting User using userId Exception case")
    @Test
    public void getUserByIdTestException() {
        long id = 2;
        assertThrows(FileSystemNotFoundException.class,()->{userService.getUserById(id);});
    }

    @DisplayName("JUnit Test for getting User using email")
    @Test
    public void getUserByEmailTest() {
        String email = "k1@gmail.com";
        when(userRepository.findByUserEmailId(email)).thenReturn(user);
        assertEquals(user,userService.findByEmail(email));
    }

    @DisplayName("JUnit Test for Updating User using userId and newUser object")
    @Test
    public void updateUserTest(){
        long id = 4;
        user.setUserId(id);
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user , userService.updateUser(user.getUserId(), user));
    }

    @DisplayName("JUnit Test for Deleting User using userId")
    @Test
    public void deleteUserTest(){
        long id = 1;
        when(userRepository.findById(id)).thenReturn(Optional.ofNullable(user));

        userService.deleteUserById(id);
        verify(userRepository, times(1)).deleteById(id);}


    @DisplayName("JUnit Test for Deleting User using userId Exception case")
    @Test
    public void deleteUserTest_Exception(){
        long id = 2;
        assertThrows(FileSystemNotFoundException.class,()->{userService.deleteUserById(id);});
    }
}

