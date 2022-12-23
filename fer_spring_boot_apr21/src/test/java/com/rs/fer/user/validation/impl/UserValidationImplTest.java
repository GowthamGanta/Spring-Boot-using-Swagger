package com.rs.fer.user.validation.impl;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.user.request.RegistrationRequest;

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
		//request.setFirstname("admin");
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
	
}
