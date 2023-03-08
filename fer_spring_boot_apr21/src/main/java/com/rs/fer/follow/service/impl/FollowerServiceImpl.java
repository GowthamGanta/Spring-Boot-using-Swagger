package com.rs.fer.follow.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.follow.request.DeletefollowerRequest;
import com.rs.fer.follow.request.GetFollowersRequest;
import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.response.DeletefollowerResponse;
import com.rs.fer.follow.response.GetFollowersResponse;
import com.rs.fer.follow.response.SaveFollowerResponse;
import com.rs.fer.follow.service.FollowerService;
import com.rs.fer.follow.util.FollowerUtil;
import com.rs.fer.follower.repository.FollowerRepository;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;

@Service
public class FollowerServiceImpl implements FollowerService {

	@Autowired
	FollowerUtil followerUtil;
	@Autowired
	FollowerRepository followerRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public SaveFollowerResponse saveFollower(SaveFollowerRequest request) {

		SaveFollowerResponse response = null;
		Follow follow = new Follow();

		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (!userObj.isPresent()) {

			return new SaveFollowerResponse(HttpStatus.PRECONDITION_FAILED, "401", "user is not found", null);
		}

		if (userObj.isPresent()) {
			User user = userObj.get();

			if ("N".equalsIgnoreCase(user.getEmailVerify())) {

				return new SaveFollowerResponse(HttpStatus.PRECONDITION_FAILED, "402",
						"User Email Verification is Failed ", null);
			}
			if ("N".equalsIgnoreCase(user.getMobileVerify())) {

				return new SaveFollowerResponse(HttpStatus.PRECONDITION_FAILED, "403", "Enter otp", null);
			}

		}
		Optional<User> followerObj = userRepository.findById(request.getFollowerId());
		if (!followerObj.isPresent() || request.getFollowerId() <= 0) {

			return new SaveFollowerResponse(HttpStatus.PRECONDITION_FAILED, "404", "Follower is not found", null);
		}
		if (followerObj.isPresent()) {

			User follower = followerObj.get();

			if ("N".equalsIgnoreCase(follower.getEmailVerify()) || "Not".equalsIgnoreCase(follower.getEmailVerify())) {

				return new SaveFollowerResponse(HttpStatus.PRECONDITION_FAILED, "405",
						"Follower Email Verification is failed", null);
			}
			if ("N".equalsIgnoreCase(follower.getMobileVerify())
					|| "Not".equalsIgnoreCase(follower.getMobileVerify())) {

				return new SaveFollowerResponse(HttpStatus.PRECONDITION_FAILED, "406", "Enter otp", null);
			}

		}

		// load request data into follow entity

		follow = followerUtil.loadSaveFollowerRequest(request, request.getFollowerId(), request.getUserId());

		// save message

		followerRepository.save(follow);

		// response if success
		if (follow.getId() > 0) {
			response = new SaveFollowerResponse(HttpStatus.OK, "000", " Following Successfully", null);

			response.setFollower(follow);

		} else {
			// response if failure
			response = new SaveFollowerResponse(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Following  Failed", null);

		}

		return response;
	}

	@Override
	public DeletefollowerResponse deleteFollower(DeletefollowerRequest request) {

		DeletefollowerResponse response = null;

		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (!userObj.isPresent()) {

			return new DeletefollowerResponse(HttpStatus.PRECONDITION_FAILED, "501", "user is not found", null);
		}

		if (userObj.isPresent()) {
			User user = userObj.get();

			if ("N".equalsIgnoreCase(user.getEmailVerify())) {

				return new DeletefollowerResponse(HttpStatus.PRECONDITION_FAILED, "502",
						"User Email Verification is Failed ", null);
			}
			if ("N".equalsIgnoreCase(user.getMobileVerify())) {

				return new DeletefollowerResponse(HttpStatus.PRECONDITION_FAILED, "503", "Enter otp", null);
			}

		}
		List<Follow> followers = followerRepository.findByUserIdAndFollowerId(request.getUserId(),
				request.getFollowerId());
		Follow follow = followers.get(0);

		int delete = follow.getId();
		followerRepository.deleteById(delete);
		// response if success
		response = new DeletefollowerResponse(HttpStatus.OK, "000", "Follower deleted successfully", null);

		return response;
	}

	@Override
	public GetFollowersResponse getFollowers(GetFollowersRequest request) {
		
		GetFollowersResponse response = null;

		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (!userObj.isPresent()) {

			return new GetFollowersResponse(HttpStatus.PRECONDITION_FAILED, "601", "user is not found", null);
		}

		if (userObj.isPresent()) {
			User user = userObj.get();

			if ("N".equalsIgnoreCase(user.getEmailVerify())) {

				return new GetFollowersResponse(HttpStatus.PRECONDITION_FAILED, "602",
						"User Email Verification is Failed ", null);
			}
			if ("N".equalsIgnoreCase(user.getMobileVerify())) {

				return new GetFollowersResponse(HttpStatus.PRECONDITION_FAILED, "603", "Enter otp", null);
			}

		}

		// response if failure
		List<Follow> followers = followerRepository.findByUserId(request.getUserId());

		if (followers.isEmpty()) {

			response = new GetFollowersResponse(HttpStatus.OK, "001", "Followers Not found", null);

			// response if success
		} else {

			response = new GetFollowersResponse(HttpStatus.OK, "000", "fetch Followers", null);
			response.setFollower(userObj.get().getFollowers());

		}

		return response;
	}

	}


