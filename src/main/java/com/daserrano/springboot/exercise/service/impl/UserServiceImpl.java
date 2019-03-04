package com.daserrano.springboot.exercise.service.impl;

import com.daserrano.springboot.exercise.model.User;
import com.daserrano.springboot.exercise.repository.UserRepository;
import com.daserrano.springboot.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User findById(Integer userId) {
        Optional<User> optUser = userRepository.findById(userId);
        return optUser.get();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public void updateUser(User user) {
        userRepository.save(user);

    }
}
