package com.rs.fer.ipl.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.request.SavePlayerRequest;

@SpringBootTest
public class PlayerValidationImplTest {

	@InjectMocks
	PlayerValidationImpl playerValidationImpl;

	@Test
	public void testValidateSavePlayerRequest() {

		SavePlayerRequest request = new SavePlayerRequest();
		request.setFirstName("Dhoni");
		request.setMiddleName("Mahi");
		request.setLastName("MS");
		request.setGender('M');
		request.setDob("10/05/2000");
		request.setRole("C");
		request.setSpecilization("AR");
		request.setJerseyNumber("7");

		Set<String> errorMessages = playerValidationImpl.validateSavePlayerRequest(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateSavePlayerRequestFailure() {

		SavePlayerRequest request = new SavePlayerRequest();
		// request.setFirstName("Dhoni");
		request.setMiddleName("Mahi");
		request.setLastName("MS");
		request.setGender('M');
		request.setDob("10/05/2000");
		request.setRole("C");
		request.setSpecilization("AR");
		request.setJerseyNumber("7");

		Set<String> errorMessages = playerValidationImpl.validateSavePlayerRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

}
