package com.daserrano.springboot.exercise.repository;

import com.daserrano.springboot.exercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
