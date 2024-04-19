package com.chatapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapplication.chat.User;


public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
