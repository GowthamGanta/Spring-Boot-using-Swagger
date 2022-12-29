package com.rs.fer.user.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

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
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.validation.UserValidation;

@SpringBootTest
public class UserControllerTest {

	@InjectMocks
	private UserController userController;

	@Mock
	UserValidation userValidation;

	@Mock
	UserService userService;

	@Test
	public void testRegistration() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		RegistrationRequest request = new RegistrationRequest();
		RegistrationResponse response = new RegistrationResponse(HttpStatus.OK, "000", "", null);

		// When
		when(userValidation.validateRegistrationRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.registration(Mockito.any())).thenReturn(response);

		// Then
		RegistrationResponse regResponse = userController.registration(request);

		assertEquals("000", regResponse.statusCode);

	}

	@Test
	public void testRegistrationFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter First Name");

		RegistrationRequest request = new RegistrationRequest();

		// When
		when(userValidation.validateRegistrationRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		RegistrationResponse response = userController.registration(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testverifyEmail() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		VerifyEmailRequest request = new VerifyEmailRequest();
		VerifyEmailResponse response = new VerifyEmailResponse(HttpStatus.OK, "000", "", null);

		// When
		when(userValidation.verifyEmailRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.verifyEmail(Mockito.any())).thenReturn(response);

		// Then
		VerifyEmailResponse verResponse = userController.verifyEmail(request);

		assertEquals("000", verResponse.statusCode);

	}

	@Test
	public void testverifyEmailFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter verefication code");

		VerifyEmailRequest request = new VerifyEmailRequest();

		// When
		when(userValidation.verifyEmailRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		VerifyEmailResponse response = userController.verifyEmail(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testRestPasswordSucess() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		ResetPasswordRequest request = new ResetPasswordRequest();
		ResetPasswordResponse response = new ResetPasswordResponse(HttpStatus.OK, "000", "", null);

		// When
		when(userValidation.validateResetPasswordRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.resetPassword(Mockito.any())).thenReturn(response);

		// Then
		ResetPasswordResponse resetPwdResponse = userController.resetPassword(request);

		assertEquals("000", resetPwdResponse.statusCode);

	}

	@Test
	public void testResetPasswordFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter valid Password");

		ResetPasswordRequest request = new ResetPasswordRequest();

		// When
		when(userValidation.validateResetPasswordRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		ResetPasswordResponse response = userController.resetPassword(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testVerifyOtp() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		VerifyOtpRequest request = new VerifyOtpRequest();
		VerifyOtpResponse response = new VerifyOtpResponse(HttpStatus.OK, "000", "", null);

		// when
		when(userValidation.verifyOtpRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.verifyOtp(Mockito.any())).thenReturn(response);

		// Then
		VerifyOtpResponse otpResponse = userController.verifyOtp(request);

		assertEquals("000", otpResponse.statusCode);

	}

	@Test
	public void testVerifyOtpFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Otp");

		VerifyOtpRequest request = new VerifyOtpRequest();

		// When
		when(userValidation.verifyOtpRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		VerifyOtpResponse response = userController.verifyOtp(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testLogin() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		LoginRequest request = new LoginRequest();
		LoginResponse response = new LoginResponse(HttpStatus.OK, "000", "", null);

		// When
		when(userValidation.validateLoginRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.login(Mockito.any())).thenReturn(response);

		// Then
		LoginResponse regResponse = userController.login(request);

		assertEquals("000", regResponse.statusCode);

	}

	@Test
	public void testLoginFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Password");

		LoginRequest request = new LoginRequest();

		// When
		when(userValidation.validateLoginRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		LoginResponse response = userController.login(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testGetUser() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		GetUserRequest request = new GetUserRequest();
		GetUserResponse response = new GetUserResponse(HttpStatus.OK, "000", "", null);

		// When
		when(userValidation.validateGetUserRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.getUser(Mockito.any())).thenReturn(response);

		// Then
		GetUserResponse getuserResponse = userController.getUser(request);

		assertEquals("000", getuserResponse.statusCode);
	}

	@Test
	public void testGetUserFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("GetUser is  not valid");

		GetUserRequest request = new GetUserRequest();

		// When
		when(userValidation.validateGetUserRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		GetUserResponse response = userController.getUser(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testUpdateUser() {

		// mock
		Set<String> errorMessages = new LinkedHashSet<>();

		UpdateUserRequest request = new UpdateUserRequest();
		UpdateUserResponse response = new UpdateUserResponse(HttpStatus.OK, "000", "", null);

		// When
		when(userValidation.validateUpdateUserRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.updateUser(Mockito.any())).thenReturn(response);

		// Then
		UpdateUserResponse UpdtUrsresponse = userController.updateUser(request);

		assertEquals("000", UpdtUrsresponse.statusCode);

	}

	@Test
	public void testUpdateUserFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter  Valid User");

		UpdateUserRequest request = new UpdateUserRequest();

		// When
		when(userValidation.validateUpdateUserRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		UpdateUserResponse response = userController.updateUser(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testRating() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		SaveRatingRequest request = new SaveRatingRequest();
		SaveRatingResponse response = new SaveRatingResponse(HttpStatus.OK, "000", "", null);

		// When
		when(userValidation.validateSaveRatingRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.saveRating(Mockito.any())).thenReturn(response);

		// Then
		SaveRatingResponse ratingResponse = userController.saveRating(request);

		assertEquals("000", ratingResponse.statusCode);

	}

	@Test
	public void testRatingFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter  Comments");

		SaveRatingRequest request = new SaveRatingRequest();

		// When
		when(userValidation.validateSaveRatingRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		SaveRatingResponse ratingResponse = userController.saveRating(request);

		assertEquals("999", ratingResponse.statusCode);

	}

	@Test
	public void testEditRating() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		EditRatingRequest request = new EditRatingRequest();
		EditRatingResponse response = new EditRatingResponse(HttpStatus.OK, "000", "", null);

		// When
		when(userValidation.validateEditRatingRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.editRating(Mockito.any())).thenReturn(response);

		// Then
		EditRatingResponse ratingResponse = userController.editRating(request);

		assertEquals("000", ratingResponse.statusCode);

	}

	@Test
	public void testEditRatingFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter  Comments");

		EditRatingRequest request = new EditRatingRequest();

		// When
		when(userValidation.validateEditRatingRequest(Mockito.any())).thenReturn(errorMessages);

		// Then

		EditRatingResponse ratingResponse = userController.editRating(request);

		assertEquals("999", ratingResponse.statusCode);

	}
	@Test 
	public void testDeleteRating() { 
  
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		DeleteRatingRequest request = new DeleteRatingRequest();
		DeleteRatingResponse response = new DeleteRatingResponse(HttpStatus.OK, "000", "", null);
	 	
		// When
		when(userValidation.validateDeleteRatingRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.deleteRating(Mockito.any())).thenReturn(response);

		// Then
		DeleteRatingResponse deleteratingResponse = userController.deleteRating(request);

		assertEquals("000", deleteratingResponse.statusCode);

	}
	@Test
	public void testDeleteRatingFailure() {
 
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter  Comments");

		DeleteRatingRequest request = new DeleteRatingRequest();
		
		// When
		when(userValidation.validateDeleteRatingRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		DeleteRatingResponse deleteratingResponse = userController.deleteRating(request);

		assertEquals("999", deleteratingResponse.statusCode);

	}


	@Test
	public void testGetRating() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		GetRatingRequest request = new GetRatingRequest();
		GetRatingResponse response = new GetRatingResponse(HttpStatus.OK, "000", "", null);

		// When
		when(userValidation.validateGetRatingRequest(Mockito.any())).thenReturn(errorMessages);
		when(userService.getRating(Mockito.any())).thenReturn(response);

		// Then
		GetRatingResponse ratingResponse = userController.getRating(request);

		assertEquals("000", ratingResponse.statusCode);

	}

	@Test
	public void testGetRatingFailure() {
 
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter  ratings");

		GetRatingRequest request = new GetRatingRequest();

		// When
		when(userValidation.validateGetRatingRequest(Mockito.any())).thenReturn(errorMessages);

		// Then

		GetRatingResponse ratingResponse = userController.getRating(request);

		assertEquals("999", ratingResponse.statusCode);

	}
}
