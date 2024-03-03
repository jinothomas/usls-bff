package com.usls.groups.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usls.groups.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {}
