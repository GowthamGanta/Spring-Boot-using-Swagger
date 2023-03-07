package com.rs.fer.follower.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rs.fer.follow.entity.Follow;


public interface FollowerRepository extends JpaRepository<Follow, Integer> {

	List<Follow> findByUserIdAndFollowerId(int userId, int followerId);

}
