package com.usls.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usls.user.entity.User;


public interface UserRepository extends JpaRepository<User,UUID> {
	Optional<User> findByUserId(UUID userId);
}
