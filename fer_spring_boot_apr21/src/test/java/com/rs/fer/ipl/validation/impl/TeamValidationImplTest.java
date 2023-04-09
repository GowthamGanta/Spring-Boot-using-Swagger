package com.rs.fer.ipl.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.request.GetTeamRequest;
import com.rs.fer.ipl.request.SaveTeamRequest;

@SpringBootTest
public class TeamValidationImplTest {

	@InjectMocks
	TeamValidationImpl teamValidationImpl;

	@Test
	public void testValidateSaveTeamRequest() {

		SaveTeamRequest request = new SaveTeamRequest();
		request.setName("CSK");

		Set<String> errorMessages = teamValidationImpl.validateSaveTeamRequest(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateSaveTeamRequestFailure() {

		SaveTeamRequest request = new SaveTeamRequest();
		// request.setName("Dhoni");

		Set<String> errorMessages = teamValidationImpl.validateSaveTeamRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testvalidateGetTeamRequest() {

		GetTeamRequest request = new GetTeamRequest();

		request.setTeamId(1);

		Set<String> errorMessages = teamValidationImpl.validateGetTeamRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test

	public void testvalidateGetTeamRequestFailure() {

		GetTeamRequest request = new GetTeamRequest();

		request.setTeamId(0);

		Set<String> errorMessages = teamValidationImpl.validateGetTeamRequest(request);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

}
