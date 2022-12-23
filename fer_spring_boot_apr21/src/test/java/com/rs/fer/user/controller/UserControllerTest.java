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

import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.response.RegistrationResponse;
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

		assertEquals("000", response.statusCode);

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

}
