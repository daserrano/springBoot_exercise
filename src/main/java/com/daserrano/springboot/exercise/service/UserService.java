package com.daserrano.springboot.exercise.service;

import com.daserrano.springboot.exercise.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User findById(Integer userId);

    public void saveUser(User user);

    public void deleteUser(Integer userId);

    public void updateUser(User user);
}
