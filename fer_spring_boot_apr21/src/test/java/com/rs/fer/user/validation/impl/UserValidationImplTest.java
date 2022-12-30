package com.rs.fer.user.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.user.request.DeleteRatingRequest;
import com.rs.fer.user.request.GetRatingRequest;
import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.SaveRatingRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.request.VerifyEmailRequest;
import com.rs.fer.user.request.VerifyOtpRequest;

@SpringBootTest 
public class UserValidationImplTest {

	@InjectMocks
	private UserValidationImpl userValidationImpl;

	@Test
	public void testValidateRegistrationRequest() {

		RegistrationRequest request = new RegistrationRequest();
		request.setFirstname("admin");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("23432432");

		Set<String> errorMessages = userValidationImpl.validateRegistrationRequest(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateRegistrationRequestFailure() {

		RegistrationRequest request = new RegistrationRequest();
		// request.setFirstname("admin");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("23432432");

		Set<String> errorMessages = userValidationImpl.validateRegistrationRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testverifyEmailRequest() {

		VerifyEmailRequest request = new VerifyEmailRequest();
		request.setId("1");
		request.setVerificationCode("p1a2v3i4t5h6r7a8");

		Set<String> errorMessages = userValidationImpl.verifyEmailRequest(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testverifyEmailRequestRequestFailure() {

		VerifyEmailRequest request = new VerifyEmailRequest();
		request.setId("2");
		// request.setVerificationCode("p1a2v3i4t5h6r7a8");

		Set<String> errorMessages = userValidationImpl.verifyEmailRequest(request);
 
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	@Test
	public void testValidateResetPassword() {
		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setUserId(1);  
		request.setCurrentPassword("admin");
		request.setNewPassword("rs");
				Set<String> errorMessages = userValidationImpl.validateResetPasswordRequest(request);
		
		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty(); 
		
		assertEquals(isExpectedEmpty, isActualEmpty);
		 
	}  
	@Test
	public void testValidateResetPasswordFailure() {
		
		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setUserId(1);
		request.setCurrentPassword("admin");
		//request.setNewPassword("rs");

		Set<String> errorMessages = userValidationImpl.validateResetPasswordRequest(request);
		
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();
		
		assertEquals(isExpectedEmpty, isActualEmpty);
		
	}
	@Test
	public void testverifyOtpRequest() {

		VerifyOtpRequest request = new VerifyOtpRequest();
		request.setId("1");
		request.setOtp("12345");

		Set<String> errorMessages = userValidationImpl.verifyOtpRequest(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testverifyOtpFailure() {

		VerifyOtpRequest request = new VerifyOtpRequest();
		request.setId("2");
		// request.setOtp("12345");

		Set<String> errorMessages = userValidationImpl.verifyOtpRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	@Test
	public void testValidateLoginRequest() {

		LoginRequest request = new LoginRequest();

		request.setUsername("admin");
		request.setPassword("rs");

		Set<String> errorMessages = userValidationImpl.validateLoginRequest(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	} 

	@Test
	public void testValidateLoginFailure() {

		LoginRequest request = new LoginRequest();

		// request.setUsername("admin");
		request.setPassword("rs");

		Set<String> errorMessages = userValidationImpl.validateLoginRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateGetUserRequest() {

		GetUserRequest request = new GetUserRequest();

		request.setUserId(1);

		Set<String> errorMessages = userValidationImpl.validateGetUserRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test

	public void testValidateGetUserFailure() {

		GetUserRequest request = new GetUserRequest();

		request.setUserId(0);

		Set<String> errorMessages = userValidationImpl.validateGetUserRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	@Test
	public void testValidateUpdateUser() {

		
		UpdateUserRequest request = new UpdateUserRequest();
		
		request.setUserId(1);
		
		request.setFirstname("adminn");
		request.setMiddlename("rss");
		request.setEmail("adminn@rss.com.");
		request.setUsername("adminss");
		request.setPassword("rss");
		request.setMobile("12341234");
		
		
		request.setLineone("100ft");
		request.setLinetwo("street1");
		request.setCity("hyd");
		request.setState("TS");
		request.setPincode("500018");
		request.setCountry("INDIA");
		 
		Set<String> errorMessages = userValidationImpl.validateUpdateUserRequest(request);
		 
		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();
		
		assertEquals(isExpectedEmpty, isActualEmpty);
 		
	}
	
	@Test
	public void testUpdateUserfailure() {
		
		UpdateUserRequest request = new UpdateUserRequest();
		
		request.setUserId(1);
		
		//request.setFirstname("adminn");
		request.setMiddlename("rss");
		request.setEmail("adminn@rss.com.");
		request.setUsername("adminss");
		request.setPassword("rss");
		request.setMobile("12341234");
		
		
		request.setLineone("100ft");
		request.setLinetwo("street1rs");
		request.setCity("hyd");
		request.setState("TS");
		request.setPincode("500018");
		request.setCountry("INDIA");
		
		Set<String> errorMessages = userValidationImpl.validateUpdateUserRequest(request);
 		 
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();
		
		assertEquals(isExpectedEmpty, isActualEmpty);
		
	}
	
	@Test
	public void testValidateSaveRatingRequest() {
		
		SaveRatingRequest request = new SaveRatingRequest();
		request.setComments("found");
		request.setRating(4);
		request.setReviewerId(5);
		request.setUserId(1);
		
		Set<String> errorMessages = userValidationImpl.validateSaveRatingRequest(request);
		 
		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();
		
		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testValidateSaveRatingRequestFailure() {
		
		SaveRatingRequest request = new SaveRatingRequest();
		//request.setComments("found");
		request.setRating(4);
		request.setReviewerId(5);
		request.setUserId(1);
		
		Set<String> errorMessages = userValidationImpl.validateSaveRatingRequest(request);
		 
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();
		
		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	@Test
	public void testValidateDeleteRatingRequest() {
		
		DeleteRatingRequest request = new DeleteRatingRequest();
		request.setComments("found");
		request.setRating(4);
		request.setReviewerId(5);
		request.setUserId(1);
		
		Set<String> errorMessages = userValidationImpl.validateDeleteRatingRequest(request);
		 
		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();
		
		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testValidateDeleteRatingRequestFailure() {
		
		DeleteRatingRequest request = new DeleteRatingRequest();
		//request.setComments("found");
		request.setRating(4);
		request.setReviewerId(5);
		request.setUserId(1);
		
		Set<String> errorMessages = userValidationImpl.validateDeleteRatingRequest(request);
		 
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();
		
		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testValidateGetRatingRequest() {
		
		GetRatingRequest request = new GetRatingRequest();
		request.setRatingId(1);;
		
		Set<String> errorMessages = userValidationImpl.validateGetRatingRequest(request);
		 
		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();
		
		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	 
	@Test
	public void testValidateGetRatingRequestFailure() {
		
		GetRatingRequest request = new GetRatingRequest();
		//request.setRatingId(1);;
		
		Set<String> errorMessages = userValidationImpl.validateGetRatingRequest(request);
		 
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();
		
		assertEquals(isExpectedEmpty, isActualEmpty);
	}
}
