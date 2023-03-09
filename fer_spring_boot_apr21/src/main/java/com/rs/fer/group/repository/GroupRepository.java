package com.rs.fer.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.group.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}
