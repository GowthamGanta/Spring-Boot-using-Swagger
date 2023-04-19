package com.rs.fer.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rs.fer.user.entity.Rating;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.RatingRepository;
import com.rs.fer.user.repository.UserRepository;
import com.rs.fer.user.request.DeleteRatingRequest;
import com.rs.fer.user.request.EditRatingRequest;
import com.rs.fer.user.request.GetRatingRequest;
import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.SaveRatingRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.request.VerifyEmailRequest;
import com.rs.fer.user.request.VerifyOtpRequest;
import com.rs.fer.user.response.DeleteRatingResponse;
import com.rs.fer.user.response.EditRatingResponse;
import com.rs.fer.user.response.GetRatingResponse;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.LoginResponse;
//github.com/javars100321/javars_jan21.git
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
import com.rs.fer.user.response.SaveRatingResponse;
import com.rs.fer.user.response.UpdateUserResponse;
import com.rs.fer.user.response.VerifyEmailResponse;
import com.rs.fer.user.response.VerifyOtpResponse;
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.util.UserUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserUtil userUtil;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RatingRepository ratingRepository;

	@Override
	public RegistrationResponse registration(RegistrationRequest request) {
		RegistrationResponse response = null;

		// User is present or not check
		List<User> users = userRepository.findByEmail(request.getEmail());

		if (!CollectionUtils.isEmpty(users)) {
			// User already present
			response = new RegistrationResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"User is already registered with the given email address", null);
			return response;
		}

		// load vo to bean
		User user = userUtil.loadRegistrationRequestToUser(request);

		// save bean to database
		user = userRepository.save(user);

		// load response
		if (user.getUserId() > 0) {
			// success
			response = new RegistrationResponse(HttpStatus.OK, "000", "User is succesfully registered", null);
			response.setUser(user);
		} else {
			// failure
			response = new RegistrationResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User registration is failed",
					null);
		}

		return response;
		// return null;
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		LoginResponse response = null;
		int userid = 0;

		// load vo to bean
		String username = request.getUsername();
		String password = request.getPassword();
		// List<User> findByUsernameAndPassword(String username, String password);

		// save bean to database
//		List<User> user = userRepository.findByUsernameAndPassword(request);

		List<User> users = userRepository.findByUsernameAndPassword(username, password);
		if (users != null && !users.isEmpty()) {
			User user1 = users.get(0);
			userid = user1.getUserId();
		}

		// load response
		if (userid > 0) {
			// success
			response = new LoginResponse(HttpStatus.OK, "000", "Welcome to user", null);
			// response.setUser(user);
		} else {
			// failure
			response = new LoginResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
					"Invalid username/password..Please try again.", null);
		}

		return response;
		// return null;
	}

	/**
	 * To get the password based on userId
	 * 
	 * @param userId
	 * @return response
	 */
	@Override
	public ResetPasswordResponse resetPassword(ResetPasswordRequest request) {
		ResetPasswordResponse response = null;
		Optional<User> userObj = userRepository.findById(request.getUserId());
		if (userObj.isPresent()) {
			User user = userObj.get();
			if (user.getPassword().equals(request.getCurrentPassword())) {

				// success
				user.setPassword(request.getNewPassword());
				userRepository.save(user);
				response = new ResetPasswordResponse(HttpStatus.OK, "000", "password changed successfully", null);
			} else {

				// failure

				response = new ResetPasswordResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
						"Current Password and password which is on the account are not matching", null);

			}

		} else {
			response = new ResetPasswordResponse(HttpStatus.PRECONDITION_FAILED, "002", "User is not foiund", null);
		}
		return response;
	}

	/**
	 * To get the user based on userid
	 * 
	 * @param userid
	 * @return response
	 */
	@Override
	public GetUserResponse getUser(GetUserRequest request) {
		GetUserResponse response = null;

		// To get the user based on userId
		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (userObj.isPresent()) {
			// If user is present
			response = new GetUserResponse(HttpStatus.OK, "000", "get User is succesfully ", null);
			response.setUser(userObj.get());

		} else {
			// If user not present
			response = new GetUserResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "get user is failed", null);

		}

		return response;
	}

	/**
	 * UpdateUser
	 * 
	 * @param request
	 * @return
	 */
	@Override

	public UpdateUserResponse updateUser(UpdateUserRequest request) {
		UpdateUserResponse response = null;

		// User is present or not check
		List<User> users = userRepository.findByEmail(request.getEmail());

		if (!CollectionUtils.isEmpty(users)) {
			// User already present
			response = new UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "001",
					"User is already registered with the given email address", null);
			return response;
		}

		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (userObj.isPresent()) {

			// load vo to bean

			User user = userUtil.loadUpdateUserRequestToUser(request);

			// save bean to database
			user = userRepository.save(user);

			// User already present
			response = new UpdateUserResponse(HttpStatus.OK, "000", "User is updated successfully", null);
			response.setUser(user);
		} else {
			// failure
			response = new UpdateUserResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User update failed", null);
		}

		return response;
	}

	@Override
	public VerifyOtpResponse verifyOtp(VerifyOtpRequest request) {
		VerifyOtpResponse response = null;

		Optional<User> userObj = userRepository.findById(Integer.parseInt(request.getId()));

		if (userObj.isPresent()) {

			User user = userObj.get();
			if (user.getOtp().equals(request.getOtp())) {

				// success

				user.setMobileVerify("Y");
				userRepository.save(user);
				response = new VerifyOtpResponse(HttpStatus.OK, "000", "Otp Updated successfully", null);
			} else {

				// failure

				response = new VerifyOtpResponse(HttpStatus.INTERNAL_SERVER_ERROR, "102",
						"Id and Otp which is on the account are not matching", null);

			}

		} else {
			response = new VerifyOtpResponse(HttpStatus.PRECONDITION_FAILED, "101", "User is not found", null);

		}

		return response;
	}

	@Override
	public VerifyEmailResponse verifyEmail(VerifyEmailRequest request) {
		VerifyEmailResponse response = null;

		Optional<User> userObj = userRepository.findById(Integer.parseInt(request.getId()));

		if (userObj.isPresent()) {
			User user = userObj.get();
			if (user.getVerificationCode().equals(request.getVerificationCode())) {

				// success
				user.setEmailVerify("Y");
				userRepository.save(user);
				response = new VerifyEmailResponse(HttpStatus.OK, "000", "VerificationCode Updated successfully", null);
			} else {

				// failure

				response = new VerifyEmailResponse(HttpStatus.INTERNAL_SERVER_ERROR, "102",
						"Id and VerificationCode which is on the account are not matching", null);

			}

		} else {
			response = new VerifyEmailResponse(HttpStatus.PRECONDITION_FAILED, "101", "User is not found", null);

		}

		return response;

	}

	@Override
	public SaveRatingResponse saveRating(SaveRatingRequest request) {
		SaveRatingResponse response = null;

		// To get the User based on userId
		Optional<User> userObj = userRepository.findById(request.getUserId());

		// If user is not present
		if (!userObj.isPresent()) {
			return new SaveRatingResponse(HttpStatus.PRECONDITION_FAILED, "101", "User is not found", null);
		}

		// User is blocked
		User user = userObj.get();
		if ("Y".equals(user.getBlockStatus())) {
			return new SaveRatingResponse(HttpStatus.PRECONDITION_FAILED, "102", "User is blocked", null);
		}

		Optional<User> reviewerObj = userRepository.findById(request.getReviewerId());
		// Current reviewer present
		if (!reviewerObj.isPresent() || request.getReviewerId() <= 0) {
			return new SaveRatingResponse(HttpStatus.PRECONDITION_FAILED, "103", "ReviewerId not present", null);
		}

		// Reviewer is blocked
		User reviewer = reviewerObj.get();
		if ("Y".equals(user.getBlockStatus()) || "S".equals(user.getBlockStatus())) {
			return new SaveRatingResponse(HttpStatus.PRECONDITION_FAILED, "104", "Reviewer is blocked", null);
		}

		// Ratings given already
		List<Rating> ratings = ratingRepository.findByUserIdAndReviewedBy(request.getUserId(), request.getReviewerId());
		if (!CollectionUtils.isEmpty(ratings)) {
			return new SaveRatingResponse(HttpStatus.PRECONDITION_FAILED, "105", "Rating given already", null);
		}
		// load vo to bean
		Rating rating = userUtil.loadSaveRatingRequestToUserId(request);

		// save bean to database
		rating = ratingRepository.save(rating);
		// load response
		if (rating.getId() > 0) {
			// success
			response = new SaveRatingResponse(HttpStatus.OK, "000", "Rating saved successfully ", null);
			response.setRating(reviewer);
		} else {
			// failure
			response = new SaveRatingResponse(HttpStatus.INTERNAL_SERVER_ERROR, "106", "Rating saved failed", null);
		}

		return response;

	}

	@Override
	public EditRatingResponse editRating(EditRatingRequest request) {

		EditRatingResponse response = null;

		// To get the User based on userId
		Optional<User> userObj = userRepository.findById(request.getUserId());

		// If user is not present
		if (!userObj.isPresent()) {
			return new EditRatingResponse(HttpStatus.PRECONDITION_FAILED, "101", "User is not found", null);
		}

		// User is blocked
		User user = userObj.get();
		
		if ("Y".equals(user.getBlockStatus())) {
			return new EditRatingResponse(HttpStatus.PRECONDITION_FAILED, "102", "User is blocked", null);
		}

		Optional<User> reviewerObj = userRepository.findById(request.getReviewerId());
		// Current reviewer present
		if (!reviewerObj.isPresent() || request.getReviewerId() <= 0) {
			return new EditRatingResponse(HttpStatus.PRECONDITION_FAILED, "103", "ReviewerId not present", null);
		}

		// Reviewer is blocked
		User reviewer = reviewerObj.get();
		if ("Y".equals(user.getBlockStatus()) || "S".equals(user.getBlockStatus())) {
			return new EditRatingResponse(HttpStatus.PRECONDITION_FAILED, "104", "Reviewer is blocked", null);
		}

		// Ratings given already
		List<Rating> ratings = ratingRepository.findByUserIdAndReviewedBy(request.getUserId(), request.getReviewerId());
		if (CollectionUtils.isEmpty(ratings)) {
			return new EditRatingResponse(HttpStatus.PRECONDITION_FAILED, "105", "No Rating found", null);
		}
		// load vo to bean
		Rating rating = userUtil.loadEditRatingRequestToUserId(request);

		// save bean to database
		rating = ratingRepository.save(rating);
		// load response
		if (rating.getUserId() > 0) {
			// success
			response = new EditRatingResponse(HttpStatus.OK, "000", "Rating Edited successfully ", null);
			response.setRating(reviewer);
		} else {
			// failure
			response = new EditRatingResponse(HttpStatus.INTERNAL_SERVER_ERROR, "106", "Rating Edited failed", null);
		}

		return response;

	}

	@Override
	public DeleteRatingResponse deleteRating(DeleteRatingRequest request) {

		DeleteRatingResponse response = null;

		// To get the User based on userId
		Optional<User> userObj = userRepository.findById(request.getUserId());

		// If user is not present
		if (!userObj.isPresent()) {
			return new DeleteRatingResponse(HttpStatus.PRECONDITION_FAILED, "101", "User is not found", null);
		}

		// User is blocked
		User user = userObj.get();
		if ("Y".equals(user.getBlockStatus())) {
			return new DeleteRatingResponse(HttpStatus.PRECONDITION_FAILED, "102", "User is blocked", null);
		}

		Optional<User> reviewerObj = userRepository.findById(request.getReviewerId());
		// Current reviewer present
		if (!reviewerObj.isPresent() || request.getReviewerId() <= 0) {
			return new DeleteRatingResponse(HttpStatus.PRECONDITION_FAILED, "103", "ReviewerId not present", null);
		}

		// Reviewer is blocked
		User reviewer = reviewerObj.get();
		if ("Y".equals(user.getBlockStatus()) || "S".equals(user.getBlockStatus())) {
			return new DeleteRatingResponse(HttpStatus.PRECONDITION_FAILED, "104", "Reviewer is blocked", null);
		}

		// Ratings given already
		List<Rating> ratings = ratingRepository.findByUserIdAndReviewedBy(request.getUserId(), request.getReviewerId());
		if (CollectionUtils.isEmpty(ratings)) {
			return new DeleteRatingResponse(HttpStatus.PRECONDITION_FAILED, "105", "Rating given already", null);
		}
		// load vo to bean
		Rating rating = userUtil.loadDeleteRatingRequestToUserId(request);

		// save bean to database
		rating = ratingRepository.save(rating);
		// load response
		if (rating.getUserId() > 0) {
			// success
			response = new DeleteRatingResponse(HttpStatus.OK, "000", "Rating deleted successfully ", null);
			response.setRating(reviewer);
		} else {
			// failure
			response = new DeleteRatingResponse(HttpStatus.INTERNAL_SERVER_ERROR, "106", "Rating deletion failed",
					null);
		}

		return response;

	}

	@Override
	public GetRatingResponse getRating(GetRatingRequest request) {

		GetRatingResponse response = null;

		// To get the User based on userId
		Optional<User> userObj = userRepository.findById(request.getUserId());

		// If user is not present
		if (!userObj.isPresent()) {
			return new GetRatingResponse(HttpStatus.PRECONDITION_FAILED, "101", "User is not found", null);
		}

		// User is blocked
		User user = userObj.get();
		if ("Y".equals(user.getBlockStatus())) {
			return new GetRatingResponse(HttpStatus.PRECONDITION_FAILED, "102", "User is blocked", null);
		}

		if (userObj.isPresent()) {
			// User user = userObj.get();

			if ("N".equalsIgnoreCase(user.getEmailVerify())) {

				return new GetRatingResponse(HttpStatus.PRECONDITION_FAILED, "103",
						"User is already registered with the given email", null);
			}
			if ("N".equalsIgnoreCase(user.getMobileVerify())) {

				return new GetRatingResponse(HttpStatus.PRECONDITION_FAILED, "104",
						"User is Already Registered with the given Number", null);
			}

		}

		// Ratings given already
		List<Rating> ratings = ratingRepository.findByUserId(request.getUserId());

		// load response
		if (ratings != null && !ratings.isEmpty()) {
			// success
			response = new GetRatingResponse(HttpStatus.OK, "000", "Rating Done successfully ", null);
			response.setRatings(ratings);
		} else {
			// failure
			response = new GetRatingResponse(HttpStatus.INTERNAL_SERVER_ERROR, "105", "Rating Fetch is failed", null);
		}

		return response;
	}

}
