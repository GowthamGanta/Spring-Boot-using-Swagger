package com.rs.fer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByUsernameAndPassword(String username, String password);

	List<User> findByEmail(String email);
	// List<User> findByUserIdAndPassword(int userId,String password);

	List<User> findByUserIdAndPassword(int userId, String password);

}
