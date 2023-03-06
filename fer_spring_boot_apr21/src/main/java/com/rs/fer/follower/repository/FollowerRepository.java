package com.rs.fer.follower.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.fer.follow.entity.Follow;


public interface FollowerRepository extends JpaRepository<Follow, Integer> {

}
