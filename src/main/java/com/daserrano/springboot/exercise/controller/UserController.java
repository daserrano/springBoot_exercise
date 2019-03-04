package com.daserrano.springboot.exercise.controller;

import com.daserrano.springboot.exercise.model.User;
import com.daserrano.springboot.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userService.getUsers();
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable(name = "userId") Integer userId) {
        return userService.findById(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(User user) {
        userService.saveUser(user);

        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "userId") Integer userId) {
        User currentUser = userService.findById(userId);
        if (currentUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(userId);
        return new ResponseEntity<User>(currentUser, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,
                                        @PathVariable(name="userId") Integer userId) {
        User currentUser = userService.findById(userId);
        if (currentUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        currentUser.setName(user.getName());
        currentUser.setBirthDate(user.getBirthDate());

        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }


}
