package com.example.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exam.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
      public User findByUsername(String username);
}
