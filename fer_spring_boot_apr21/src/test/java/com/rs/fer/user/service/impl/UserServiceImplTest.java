package com.rs.fer.user.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.context.SpringBootTest;

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
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
import com.rs.fer.user.response.SaveRatingResponse;
import com.rs.fer.user.response.UpdateUserResponse;
import com.rs.fer.user.response.VerifyEmailResponse;
import com.rs.fer.user.response.VerifyOtpResponse;
import com.rs.fer.user.util.UserUtil;

@SpringBootTest
public class UserServiceImplTest {

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	@Mock
	RatingRepository ratingRepository;

	@Mock
	UserUtil userUtil;

	@Test
	public void testRegistration() {

		List<User> users = new ArrayList<>(1);

		User user = new User();
		user.setUserId(3);

		// Mock
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		when(userUtil.loadRegistrationRequestToUser(Mockito.any())).thenReturn(user);

		// 1.
		RegistrationRequest request = new RegistrationRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");

		// 2.
		RegistrationResponse response = userServiceImpl.registration(request);

		// 3.
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testRegistrationDuplicateEmail() {

		User user = new User();
		user.setUserId(3);

		List<User> users = new ArrayList<>(1);
		users.add(user);

		// Mock
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		when(userUtil.loadRegistrationRequestToUser(Mockito.any())).thenReturn(user);

		// 1.
		RegistrationRequest request = new RegistrationRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");

		// 2.
		RegistrationResponse response = userServiceImpl.registration(request);

		// 3.
		assertEquals("001", response.statusCode);
	}

	@Test
	public void testRegistrationFailure() {

		List<User> users = new ArrayList<>(1);

		User user = new User();
		// user.setUserId(1);

		// Mock
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		when(userUtil.loadRegistrationRequestToUser(Mockito.any())).thenReturn(user);

		// 1.
		RegistrationRequest request = new RegistrationRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");

		// 2.
		RegistrationResponse response = userServiceImpl.registration(request);

		// 3.
		assertEquals("002", response.statusCode);
	}

	@Test
	public void testLogin() {

		List<User> users = new ArrayList<>(1);

		User user = new User();
		user.setUserId(1);
		users.add(user);

		// Mock
		when(userRepository.findByUsernameAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(users);

		// 1.
		LoginRequest request = new LoginRequest();

		request.setUsername("admin");
		request.setPassword("rs");

		// 2.
		LoginResponse response = userServiceImpl.login(request);

		// 3.
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testLoginFailure() {

		List<User> users = new ArrayList<>(1);

		User user = new User();
		// user.setUserId(1);

		// Mock
		when(userRepository.findByUsernameAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(users);

		when(userRepository.save(Mockito.any())).thenThrow(MockitoException.class);

		when(userUtil.loadLoginRequestToUser(Mockito.any())).thenReturn(user);

		// 1.
		LoginRequest request = new LoginRequest();

		request.setUsername("admin");
		request.setPassword("rs");

		// 2.
		LoginResponse response = userServiceImpl.login(request);

		// 3.
		assertEquals("002", response.statusCode);
	}

	@Test
	public void testResetPassword() {

		User user = new User();
		user.setUserId(1);
		user.setPassword("rs");

		Optional<User> userObj = Optional.of(user);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		when(userRepository.save(Mockito.any())).thenReturn(user);
		// 1.
		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setCurrentPassword("rs");
		request.setNewPassword("123");

		// 2.
		ResetPasswordResponse response = userServiceImpl.resetPassword(request);

		// 3.
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testResetPasswordUserNotPresent() {

		Optional<User> userObj = Optional.empty();

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		// 1.
		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setCurrentPassword("rs");
		request.setNewPassword("123");

		// 2.
		ResetPasswordResponse response = userServiceImpl.resetPassword(request);

		// 3.
		assertEquals("002", response.statusCode);

	}

	@Test
	public void testResetPasswordMismatch() {

		User user = new User();
		// user.setUserId(1);
		user.setPassword("rs1233333");
		java.util.Optional<User> userObj = java.util.Optional.of(user);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		when(userRepository.save(Mockito.any())).thenReturn(user);
		// 1.
		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setCurrentPassword("rs");
		request.setNewPassword("123");

		// 2.
		ResetPasswordResponse response = userServiceImpl.resetPassword(request);

		// 3.
		assertEquals("002", response.statusCode);

	}

	@Test
	public void testUpdateUser() {

		User user = new User();
		user.setUserId(1);

		List<User> users = new ArrayList<>(1);

		// Mock
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);

		// 1.
		UpdateUserRequest request = new UpdateUserRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");

		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		when(userUtil.loadUpdateUserRequestToUser(Mockito.any())).thenReturn(user);

		request.setLineone("100ft");
		request.setLinetwo("road");
		request.setCity("hyd");
		request.setState("ts");
		request.setPincode("50081");
		request.setCountry("IND");

		UpdateUserResponse response = userServiceImpl.updateUser(request);

		// 3.
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testUpdateUserNotPresent() {

		List<User> users = new ArrayList<>(1);

		User user = new User();
		// user.setUserId(1);

		// Mock
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);

		// 1.
		UpdateUserRequest request = new UpdateUserRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");

		Optional<User> userObj = Optional.empty();

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		when(userUtil.loadUpdateUserRequestToUser(Mockito.any())).thenReturn(user);

		request.setLineone("100ft");
		request.setLinetwo("road");
		request.setCity("hyd");
		request.setState("ts");
		request.setPincode("50081");
		request.setCountry("IND");

		UpdateUserResponse response = userServiceImpl.updateUser(request);

		// 3.
		assertEquals("002", response.statusCode);

	}

	@Test
	public void testUpdateUserDuplicate() {

		User user = new User();
		user.setUserId(1);

		List<User> users = new ArrayList<>(1);
		users.add(user);

		// Mock
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);

		// 1.
		UpdateUserRequest request = new UpdateUserRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");

		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		when(userUtil.loadUpdateUserRequestToUser(Mockito.any())).thenReturn(user);

		request.setLineone("100ft");
		request.setLinetwo("road");
		request.setCity("hyd");
		request.setState("ts");
		request.setPincode("50081");
		request.setCountry("IND");

		UpdateUserResponse response = userServiceImpl.updateUser(request);

		// 3.
		assertEquals("001", response.statusCode);

	}

	@Test
	public void testGetUser() {

		User user = new User();
		user.setUserId(1);

		Optional<User> userObj = Optional.of(user);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		// 1.
		GetUserRequest request = new GetUserRequest();

		// 2.
		GetUserResponse response = userServiceImpl.getUser(request);

		// 3.
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testGetUserNotFound() {

		Optional<User> userObj = Optional.empty();

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		// 1.
		GetUserRequest request = new GetUserRequest();

		// 2.
		GetUserResponse response = userServiceImpl.getUser(request);

		// 3.
		assertEquals("002", response.statusCode);
	}

	@Test
	public void testVerifyEmail() {

		User user = new User();
		user.setUserId(1);
		user.setVerificationCode("abcd1234");
		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		when(userRepository.save(Mockito.any())).thenReturn(user);

		VerifyEmailRequest request = new VerifyEmailRequest();
		request.setId("1");
		request.setVerificationCode("abcd1234");
		VerifyEmailResponse response = userServiceImpl.verifyEmail(request);

		assertEquals("000", response.statusCode);
	}

	@Test
	public void testVerifyEmailIsNotPresent() {

		Optional<User> userObj = Optional.empty();

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		VerifyEmailRequest request = new VerifyEmailRequest();
		request.setId("1");
		request.setVerificationCode("abcd1234");
		VerifyEmailResponse response = userServiceImpl.verifyEmail(request);

		assertEquals("101", response.statusCode);
	}

	@Test
	public void testVerifyEmailIsMissMatch() {

		User user = new User();
		user.setUserId(2);
		user.setVerificationCode("naveen1234");
		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		VerifyEmailRequest request = new VerifyEmailRequest();
		request.setId("1");
		request.setVerificationCode("abcd1234");
		VerifyEmailResponse response = userServiceImpl.verifyEmail(request);

		assertEquals("102", response.statusCode);
	}

	@Test
	public void testVerifyOtp() {

		User user = new User();
		user.setUserId(1);
		user.setOtp("123456");

		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		when(userRepository.save(Mockito.any())).thenReturn(user);

		VerifyOtpRequest request = new VerifyOtpRequest();
		request.setId("1");
		request.setOtp("123456");

		// 2.
		VerifyOtpResponse response = userServiceImpl.verifyOtp(request);

		// 3.
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testIdAndOtpMissmatch() {

		User user = new User();

		user.setUserId(2);
		user.setOtp("1234567");
		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		when(userRepository.save(Mockito.any())).thenReturn(user);

		VerifyOtpRequest request = new VerifyOtpRequest();
		request.setId("1");
		request.setOtp("123456");
		// 2.
		VerifyOtpResponse response = userServiceImpl.verifyOtp(request);

		// 3.
		assertEquals("102", response.statusCode);
	}
	/*
	 * @Test public void testUserNotPresent() { Optional<User> userObj =
	 * Optional.empty();
	 * 
	 * when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
	 * 
	 * VerifyOtpRequest request = new VerifyOtpRequest(); request.setId("1");
	 * request.setOtp("123456"); // 2. VerifyOtpResponse response =
	 * userServiceImpl.verifyOtp(request);
	 * 
	 * // 3. assertEquals("101", response.statusCode); }
	 */

	@Test
	public void testSaveRating() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		User reviewer = new User();
		reviewer.setUserId(2);
		Optional<User> reviewerObj = Optional.of(reviewer);

		List<Rating> ratings = new ArrayList<>();

		SaveRatingRequest request = new SaveRatingRequest();
		request.setComments("found");
		request.setRating(5);
		request.setReviewerId(4);

		Rating rating = new Rating();
		rating.setUserId(2);
		ratings.add(rating);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);

		when(ratingRepository.findByUserIdAndReviewedBy(Mockito.anyInt(), Mockito.anyInt())).thenReturn(ratings);

		when(userUtil.loadSaveRatingRequestToUserId(Mockito.any())).thenReturn(rating);

		when(ratingRepository.save(Mockito.any())).thenReturn(rating);

		SaveRatingResponse response = userServiceImpl.saveRating(request);

		// 3.
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testSaveRatingFailure() {

		User user = new User();
		user.setUserId(2);
		Optional<User> userObj = Optional.of(user);

		User reviewer = new User();
		reviewer.setUserId(3);
		Optional<User> reviewerObj = Optional.of(reviewer);

		List<Rating> ratings = new ArrayList<>();

		SaveRatingRequest request = new SaveRatingRequest();
		request.setComments("found");
		request.setRating(6);
		request.setReviewerId(7);

		Rating rating = new Rating();
		// rating.setUserId(3);
		ratings.add(rating);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);

		when(ratingRepository.findByUserIdAndReviewedBy(Mockito.anyInt(), Mockito.anyInt())).thenReturn(ratings);

		when(userUtil.loadSaveRatingRequestToUserId(Mockito.any())).thenReturn(rating);

		when(ratingRepository.save(Mockito.any())).thenReturn(rating);

		SaveRatingResponse response = userServiceImpl.saveRating(request);

		// 3.
		assertEquals("106", response.statusCode);

	}

	@Test
	public void testSaveRatingGivenAlready() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		User reviewer = new User();
		reviewer.setUserId(2);
		Optional<User> reviewerObj = Optional.of(reviewer);

		List<Rating> ratings = new ArrayList<>();

		SaveRatingRequest request = new SaveRatingRequest();
		request.setComments("found");
		request.setRating(5);
		request.setReviewerId(4);

		Rating rating = new Rating();
		rating.setUserId(2);
		// ratings.add(rating);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);

		when(ratingRepository.findByUserIdAndReviewedBy(Mockito.anyInt(), Mockito.anyInt())).thenReturn(ratings);

		when(userUtil.loadSaveRatingRequestToUserId(Mockito.any())).thenReturn(rating);

		when(ratingRepository.save(Mockito.any())).thenReturn(rating);

		SaveRatingResponse response = userServiceImpl.saveRating(request);

		// 3.
		assertEquals("105", response.statusCode);

	}

	@Test
	public void testSaveRatingUserNotFound() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.empty();

		SaveRatingRequest request = new SaveRatingRequest();
		request.setComments("found");
		request.setRating(5);
		request.setReviewerId(4);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		SaveRatingResponse response = userServiceImpl.saveRating(request);

		// 3.
		assertEquals("101", response.statusCode);

	}

	@Test
	public void testSaveRatingUserIsBlocked() {

		User user = new User();
		user.setUserId(1);
		user.setBlockStatus("Y");
		Optional<User> userObj = Optional.of(user);

		SaveRatingRequest request = new SaveRatingRequest();
		request.setComments("found");
		request.setRating(5);
		request.setReviewerId(4);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		SaveRatingResponse response = userServiceImpl.saveRating(request);

		// 3.
		assertEquals("102", response.statusCode);

	}

	@Test
	public void testSaveRatingReceiverNotFound() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		SaveRatingRequest request = new SaveRatingRequest();
		request.setComments("found");
		request.setRating(5);
		request.setUserId(4);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		SaveRatingResponse response = userServiceImpl.saveRating(request);

		// 3.
		assertEquals("103", response.statusCode);

	}

	@Test
	public void testSaveRatingReceiverIsBlocked() {

		User user = new User();
		user.setUserId(1);
		user.setBlockStatus("S");
		Optional<User> userObj = Optional.of(user);

		SaveRatingRequest request = new SaveRatingRequest();
		request.setComments("found");
		request.setRating(5);
		// request.setUserId(4);
		request.setReviewerId(4);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		SaveRatingResponse response = userServiceImpl.saveRating(request);

		// 3.
		assertEquals("104", response.statusCode);

	}

	@Test
	public void testEditRating() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		User reviewer = new User();
		reviewer.setUserId(2);
		Optional<User> reviewerObj = Optional.of(reviewer);

		List<Rating> ratings = new ArrayList<>();

		EditRatingRequest request = new EditRatingRequest();
		request.setComments("Comment");
		request.setRating(5);
		request.setReviewerId(4);

		Rating rating = new Rating();
		rating.setUserId(2);
		ratings.add(rating);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);

		when(ratingRepository.findByUserIdAndReviewedBy(Mockito.anyInt(), Mockito.anyInt())).thenReturn(ratings);

		when(userUtil.loadSaveRatingRequestToUserId(Mockito.any())).thenReturn(rating);

		when(ratingRepository.save(Mockito.any())).thenReturn(rating);

		EditRatingResponse response = userServiceImpl.editRating(request);

		// 3.
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testEditRatingUserNotFound() {

		Optional<User> userObj = Optional.empty();

		EditRatingRequest request = new EditRatingRequest();
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		EditRatingResponse response = userServiceImpl.editRating(request);

		// 3.
		assertEquals("101", response.statusCode);

	}

	@Test
	public void testEditRatingUserBlockStatus() {

		User user = new User();
		user.setUserId(1);
		user.setBlockStatus("Y");
		Optional<User> userObj = Optional.of(user);

		EditRatingRequest request = new EditRatingRequest();
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		EditRatingResponse response = userServiceImpl.editRating(request);
		// 3.
		assertEquals("102", response.statusCode);

	}

	@Test
	public void testEditRatingReceiverNotFound() {

		User user = new User();
		user.setUserId(1);
		// user.setBlockStatus("Y");
		Optional<User> userObj = Optional.of(user);

		EditRatingRequest request = new EditRatingRequest();
		request.setUserId(1);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		EditRatingResponse response = userServiceImpl.editRating(request);

		// 3.
		assertEquals("103", response.statusCode);

	}

	@Test
	public void testEditRatingReceiverBlockStatus() {

		User user = new User();
		user.setBlockStatus("S");
		Optional<User> userObj = Optional.of(user);

		EditRatingRequest request = new EditRatingRequest();
		request.setReviewerId(1);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		EditRatingResponse response = userServiceImpl.editRating(request);
		// 3.
		assertEquals("104", response.statusCode);

	}

	@Test
	public void testEditRatingGivenAlready() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		User reviewer = new User();
		reviewer.setUserId(2);
		Optional<User> reviewerObj = Optional.of(reviewer);

		List<Rating> ratings = new ArrayList<>();

		EditRatingRequest request = new EditRatingRequest();
		request.setComments("Comment");
		request.setRating(5);
		request.setReviewerId(4);

		Rating rating = new Rating();
		rating.setUserId(2);
		// ratings.add(rating);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);

		when(ratingRepository.findByUserIdAndReviewedBy(Mockito.anyInt(), Mockito.anyInt())).thenReturn(ratings);

		when(userUtil.loadSaveRatingRequestToUserId(Mockito.any())).thenReturn(rating);

		when(ratingRepository.save(Mockito.any())).thenReturn(rating);

		EditRatingResponse response = userServiceImpl.editRating(request);

		// 3.
		assertEquals("105", response.statusCode);

	}

	@Test
	public void testEditRatingFailed() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		User reviewer = new User();
		reviewer.setUserId(2);
		Optional<User> reviewerObj = Optional.of(reviewer);

		List<Rating> ratings = new ArrayList<>();

		EditRatingRequest request = new EditRatingRequest();
		request.setComments("Comment");
		request.setRating(5);
		request.setReviewerId(4);

		Rating rating = new Rating();
		rating.setUserId(0);
		ratings.add(rating);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);

		when(ratingRepository.findByUserIdAndReviewedBy(Mockito.anyInt(), Mockito.anyInt())).thenReturn(ratings);

		when(userUtil.loadSaveRatingRequestToUserId(Mockito.any())).thenReturn(rating);

		when(ratingRepository.save(Mockito.any())).thenReturn(rating);

		EditRatingResponse response = userServiceImpl.editRating(request);

		// 3.
		assertEquals("106", response.statusCode);

	}

	@Test
	public void testDeleteRating() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		User reviewer = new User();
		reviewer.setUserId(2);
		Optional<User> reviewerObj = Optional.of(reviewer);

		List<Rating> ratings = new ArrayList<>();

		DeleteRatingRequest request = new DeleteRatingRequest();
		request.setComments("xyz");
		request.setRating(5);
		request.setReviewerId(4);

		Rating rating = new Rating();
		rating.setUserId(6);
		ratings.add(rating);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);

		when(ratingRepository.findByUserIdAndReviewedBy(Mockito.anyInt(), Mockito.anyInt())).thenReturn(ratings);

		when(userUtil.loadSaveRatingRequestToUserId(Mockito.any())).thenReturn(rating);

		when(ratingRepository.save(Mockito.any())).thenReturn(rating);

		DeleteRatingResponse response = userServiceImpl.deleteRating(request);

		// 3.
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testDeleteRatingUserNotFound() {

		DeleteRatingRequest request = new DeleteRatingRequest();

		DeleteRatingResponse response = userServiceImpl.deleteRating(request);
		assertEquals("101", response.statusCode);

	}

	@Test
	public void testDeleteRatingUserBlockStatus() {

		User user = new User();
		user.setUserId(1);
		user.setBlockStatus("Y");
		Optional<User> userObj = Optional.of(user);
		DeleteRatingRequest request = new DeleteRatingRequest();

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		DeleteRatingResponse response = userServiceImpl.deleteRating(request);
		assertEquals("102", response.statusCode);

	}

	@Test
	public void testDeleteRatingReceiverNotFound() {

		User user = new User();
		user.setUserId(1);
		// user.setBlockStatus("Y");
		Optional<User> userObj = Optional.of(user);
		DeleteRatingRequest request = new DeleteRatingRequest();
		request.setUserId(1);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		DeleteRatingResponse response = userServiceImpl.deleteRating(request);
		assertEquals("103", response.statusCode);

	}

	@Test
	public void testDeleteRatingReceiverBlockStatus() {

		User user = new User();
		user.setUserId(1);
		user.setBlockStatus("S");
		Optional<User> userObj = Optional.of(user);
		DeleteRatingRequest request = new DeleteRatingRequest();
		request.setReviewerId(1);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		DeleteRatingResponse response = userServiceImpl.deleteRating(request);
		assertEquals("104", response.statusCode);

	}

	@Test
	public void testDeleteRatingGivenAlready() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		User reviewer = new User();
		reviewer.setUserId(2);
		Optional<User> reviewerObj = Optional.of(reviewer);

		List<Rating> ratings = new ArrayList<>();

		DeleteRatingRequest request = new DeleteRatingRequest();
		request.setComments("xyz");
		request.setRating(5);
		request.setReviewerId(4);

		Rating rating = new Rating();
		rating.setUserId(6);
		// ratings.add(rating);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);

		when(ratingRepository.findByUserIdAndReviewedBy(Mockito.anyInt(), Mockito.anyInt())).thenReturn(ratings);

		when(userUtil.loadSaveRatingRequestToUserId(Mockito.any())).thenReturn(rating);

		when(ratingRepository.save(Mockito.any())).thenReturn(rating);

		DeleteRatingResponse response = userServiceImpl.deleteRating(request);

		// 3.
		assertEquals("105", response.statusCode);

	}

	@Test
	public void testDeleteRatingFailed() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		User reviewer = new User();
		reviewer.setUserId(2);
		Optional<User> reviewerObj = Optional.of(reviewer);

		List<Rating> ratings = new ArrayList<>();

		DeleteRatingRequest request = new DeleteRatingRequest();
		request.setComments("xyz");
		request.setRating(5);
		request.setReviewerId(4);

		Rating rating = new Rating();
		rating.setUserId(1);
		// ratings.add(rating);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);

		when(ratingRepository.findByUserIdAndReviewedBy(Mockito.anyInt(), Mockito.anyInt())).thenReturn(ratings);

		when(userUtil.loadSaveRatingRequestToUserId(Mockito.any())).thenReturn(rating);

		when(ratingRepository.save(Mockito.any())).thenReturn(rating);

		DeleteRatingResponse response = userServiceImpl.deleteRating(request);

		// 3.
		assertEquals("105", response.statusCode);

	}

	@Test
	public void testDeleteRatingDeletionFailed() {

		User user = new User();
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		User reviewer = new User();
		reviewer.setUserId(2);
		Optional<User> reviewerObj = Optional.of(reviewer);

		List<Rating> ratings = new ArrayList<>();

		DeleteRatingRequest request = new DeleteRatingRequest();
		request.setComments("xyz");
		request.setRating(5);
		request.setReviewerId(4);

		Rating rating = new Rating();
		rating.setUserId(0);
		ratings.add(rating);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);

		when(ratingRepository.findByUserIdAndReviewedBy(Mockito.anyInt(), Mockito.anyInt())).thenReturn(ratings);

		when(userUtil.loadSaveRatingRequestToUserId(Mockito.any())).thenReturn(rating);

		when(ratingRepository.save(Mockito.any())).thenReturn(rating);

		DeleteRatingResponse response = userServiceImpl.deleteRating(request);

		// 3.
		assertEquals("106", response.statusCode);

	}
	/*
	 * @Test public void testGetRating() {
	 * 
	 * User user = new User(); user.setUserId(1); Optional<User> userObj =
	 * Optional.of(user);
	 * 
	 * List<Rating> ratings = new ArrayList<>();
	 * 
	 * GetRatingRequest request = new GetRatingRequest();
	 * 
	 * Rating rating = new Rating(); rating.getId(); ratings.add(rating);
	 * 
	 * // Mock when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
	 * 
	 * when(userRepository.findById(Mockito.anyInt())).thenReturn(reviewerObj);
	 * 
	 * when(ratingRepository.findById(Mockito.anyInt())).thenReturn(ratings);
	 * 
	 * when(userUtil.loadGetRatingRequestToRatingId(Mockito.any())).thenReturn(
	 * rating);
	 * 
	 * when(ratingRepository.save(Mockito.any())).thenReturn(rating);
	 * 
	 * GetRatingResponse response = userServiceImpl.getRating(request);
	 * 
	 * // assertEquals("000", response.statusCode); }
	 */

	@Test
	public void testGetRating() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);
		user.setUserId(1);

		List<Rating> ratings = new ArrayList<>();

		GetRatingRequest request = new GetRatingRequest();

		Rating rating = new Rating();
		rating.setUserId(6);
		ratings.add(rating);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(ratingRepository.findByUserId(Mockito.anyInt())).thenReturn(ratings);

		GetRatingResponse response = userServiceImpl.getRating(request);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetRatingUserNotFounds() {

		Optional<User> userObj = Optional.empty();

		GetRatingRequest request = new GetRatingRequest();

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		GetRatingResponse response = userServiceImpl.getRating(request);

		assertEquals("101", response.statusCode);

	}

	@Test
	public void testGetRatingBlockStatus() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);
		user.setUserId(1);
		user.setBlockStatus("Y");

		GetRatingRequest request = new GetRatingRequest();

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		GetRatingResponse response = userServiceImpl.getRating(request);

		assertEquals("102", response.statusCode);

	}

	@Test
	public void testGetRatingUserAlreadyExists() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);
		user.setUserId(1);
		user.setEmailVerify("N");

		GetRatingRequest request = new GetRatingRequest();

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		GetRatingResponse response = userServiceImpl.getRating(request);

		assertEquals("103", response.statusCode);

	}

	@Test
	public void testGetRatingUserMobileVerify() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);
		user.setUserId(1);
		user.setMobileVerify("N");

		GetRatingRequest request = new GetRatingRequest();

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		GetRatingResponse response = userServiceImpl.getRating(request);

		assertEquals("104", response.statusCode);

	}

	@Test
	public void testGetRatingFetchFailed() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);
		user.setUserId(1);

		List<Rating> ratings = new ArrayList<>();

		GetRatingRequest request = new GetRatingRequest();

		Rating rating = new Rating();
		rating.setUserId(6);
		// ratings.add(rating);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(ratingRepository.findByUserId(Mockito.anyInt())).thenReturn(ratings);

		GetRatingResponse response = userServiceImpl.getRating(request);

		assertEquals("105", response.statusCode);

	}
}