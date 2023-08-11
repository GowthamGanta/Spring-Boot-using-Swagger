package com.rs.fer.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.user.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

	List<Rating> findByUserIdAndReviewedBy(int userId, int reviewedById);
	
	
	List<Rating> findByRatingId(int RatingId);
	

	List<Rating> findByUserId(int userId);



	

}
