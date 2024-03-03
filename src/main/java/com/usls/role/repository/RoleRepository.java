package com.usls.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usls.role.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {}
