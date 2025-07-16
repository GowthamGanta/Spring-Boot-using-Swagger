package com.rs.fer.ipl.validation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.ipl.request.DeleteTeamRequest;
import com.rs.fer.ipl.request.EditTeamRequest;
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
		request.setTeamCode("CSK01");

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

		new GetTeamRequest();
		int teamId = 1;
		Set<String> errorMessages = teamValidationImpl.validateGetTeamRequest(teamId);
		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);
	}

	@Test

	public void testvalidateGetTeamRequestFailure() {

		new GetTeamRequest();

		int teamId = 0;

		Set<String> errorMessages = teamValidationImpl.validateGetTeamRequest(teamId);

		boolean isExpectedEmpty = false;
		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateDeleteTeamRequest() {
		DeleteTeamRequest request = new DeleteTeamRequest();

		request.setTeamId(4);

		Set<String> errorMessages= teamValidationImpl.validateDeleteTeamRequest(request);

		boolean isExpectedEmpty = true; 

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testvalidateDeleteTeamRequestFailure() {

		DeleteTeamRequest request = new DeleteTeamRequest();

		//request.setGroupId(4);

		Set<String> errorMessages = teamValidationImpl.validateDeleteTeamRequest(request);

		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}

	@Test
	public void testValidateEditTeamRequest() {

		EditTeamRequest request = new EditTeamRequest();

		request.setTeamId(1);
		request.setName("CSK");

		Set<String> errorMessages = teamValidationImpl.validateEditTeamRequest(request);

		boolean isExpectedEmpty = true;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	
	@Test
	public void testValidateEditTeamRequestFailure() {

		EditTeamRequest request = new EditTeamRequest();

		//request.setTeamId(1);
		request.setName("CSK");

		Set<String> errorMessages = teamValidationImpl.validateEditTeamRequest(request);

		boolean isExpectedEmpty = false;

		boolean isActualEmpty = errorMessages.isEmpty();

		assertEquals(isExpectedEmpty, isActualEmpty);

	}


}
