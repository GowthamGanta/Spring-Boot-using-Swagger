package com.rs.fer.user.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.VerifyEmailRequest;

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
}
