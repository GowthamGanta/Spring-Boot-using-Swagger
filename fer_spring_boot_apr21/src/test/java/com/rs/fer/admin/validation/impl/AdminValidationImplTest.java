package com.rs.fer.admin.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;

@SpringBootTest
public class AdminValidationImplTest {

	@InjectMocks
	private AdminValidationImpl adminValidationImpl;

	@Test
	public void testValidateBlockUserRequest() {

		BlockUserRequest request = new BlockUserRequest();

		request.setId(1);

		Set<String> errorMessages = adminValidationImpl.validateBlockUserRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test

	public void testValidateBlockUserRequestFailure() {

		BlockUserRequest request = new BlockUserRequest();

		request.setId(0);

		Set<String> errorMessages = adminValidationImpl.validateBlockUserRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateUnblockUserRequest() {

		UnblockUserRequest request = new UnblockUserRequest();

		request.setId(1);

		Set<String> errorMessages = adminValidationImpl.validateUnblockUserRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test

	public void testValidateUnblockUserRequestFailure() {

		UnblockUserRequest request = new UnblockUserRequest();

		request.setId(0);

		Set<String> errorMessages = adminValidationImpl.validateUnblockUserRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
}
