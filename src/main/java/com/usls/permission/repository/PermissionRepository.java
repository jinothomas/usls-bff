package com.usls.permission.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usls.permission.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {}
