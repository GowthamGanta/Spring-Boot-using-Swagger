package com.rs.fer.admin.controller;

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

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;
import com.rs.fer.admin.response.BlockUserResponse;
import com.rs.fer.admin.response.UnblockUserResponse;
import com.rs.fer.admin.service.AdminService;
import com.rs.fer.admin.validation.AdminValidation;

@SpringBootTest
public class AdminControllerTest {

	@InjectMocks
	private AdminController adminController;

	@Mock
	AdminValidation adminValidation;

	@Mock
	AdminService adminService;

	@Test
	public void testBlockUser() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		BlockUserRequest request = new BlockUserRequest();
		BlockUserResponse response = new BlockUserResponse(HttpStatus.OK, "000", "", null);

		// When
		when(adminValidation.validateBlockUserRequest(Mockito.any())).thenReturn(errorMessages);
		when(adminService.blockUser(Mockito.any())).thenReturn(response);

		// Then
		BlockUserResponse blockUserResponse = adminController.blockUser(request);

		assertEquals("000", blockUserResponse.statusCode);

	}

	@Test
	public void testBlockUserFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Id");

		BlockUserRequest request = new BlockUserRequest();

		// When
		when(adminValidation.validateBlockUserRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		BlockUserResponse response = adminController.blockUser(request);

		assertEquals("999", response.statusCode);
	}

	@Test
	public void testUnblockUser() {
		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();

		UnblockUserRequest request = new UnblockUserRequest();
		UnblockUserResponse response = new UnblockUserResponse(HttpStatus.OK, "000", "", null);

		// When
		when(adminValidation.validateUnblockUserRequest(Mockito.any())).thenReturn(errorMessages);
		when(adminService.unblockUser(Mockito.any())).thenReturn(response);

		// Then
		UnblockUserResponse unblockUserResponse = adminController.unblockUser(request);

		assertEquals("000", unblockUserResponse.statusCode);

	}

	@Test
	public void testUnblockUserFailure() {

		// Mock
		Set<String> errorMessages = new LinkedHashSet<>();
		errorMessages.add("Please enter Id");

		UnblockUserRequest request = new UnblockUserRequest();

		// When
		when(adminValidation.validateUnblockUserRequest(Mockito.any())).thenReturn(errorMessages);

		// Then
		UnblockUserResponse response = adminController.unblockUser(request);

		assertEquals("999", response.statusCode);
	}
}
