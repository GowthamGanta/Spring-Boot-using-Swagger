package com.rs.fer.ipl.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.request.DeletePlayerRequest;
import com.rs.fer.ipl.request.GetPlayerRequest;
import com.rs.fer.ipl.request.SavePlayerRequest;
import com.rs.fer.ipl.request.UpdatePlayerRequest;

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

	@Test
	public void testValidateDeletePlayerRequest() {

		new DeletePlayerRequest();

		int playerId = 1;
		Set<String> errorMessages = playerValidationImpl.validateDeletePlayerRequest(playerId);
		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateDeletePlayerRequestFailure() {

		new DeletePlayerRequest();

		int playerId = 0;
		Set<String> errorMessages = playerValidationImpl.validateDeletePlayerRequest(playerId);
		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testvalidateGetPlayerRequest() {

		new GetPlayerRequest();

		int playerId = 1;
		Set<String> errorMessages = playerValidationImpl.validateGetPlayerRequest(playerId);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test

	public void testvalidateGetPlayerRequestFailure() {

		new GetPlayerRequest();

		int playerId = 0;

		Set<String> errorMessages = playerValidationImpl.validateGetPlayerRequest(playerId);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateUpdatePlayerRequest() {

		UpdatePlayerRequest request = new UpdatePlayerRequest();
		request.setPlayerId(3);
		request.setFirstName("Dhoni");
		request.setMiddleName("Mahi");
		request.setLastName("MS");
		request.setGender('M');
		request.setDob("10/05/2000");
		request.setRole("C");
		request.setSpecilization("AR");
		request.setJerseyNumber("7");

		Set<String> errorMessages = playerValidationImpl.validateUpdatePlayerRequest(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateUpdatePlayerRequestFailure() {

		UpdatePlayerRequest request = new UpdatePlayerRequest();
		// request.setPlayerId(3);
		request.setFirstName("Dhoni");
		request.setMiddleName("Mahi");
		request.setLastName("MS");
		request.setGender('M');
		request.setDob("10/05/2000");
		request.setRole("C");
		request.setSpecilization("AR");
		request.setJerseyNumber("7");

		Set<String> errorMessages = playerValidationImpl.validateUpdatePlayerRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

}