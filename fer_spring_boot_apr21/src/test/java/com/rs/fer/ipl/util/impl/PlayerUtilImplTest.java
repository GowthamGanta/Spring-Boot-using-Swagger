package com.rs.fer.ipl.util.impl;

	import static org.junit.jupiter.api.Assertions.assertEquals;

	import org.junit.jupiter.api.Test;
	import org.mockito.InjectMocks;
	import org.springframework.boot.test.context.SpringBootTest;

	import com.rs.fer.ipl.entity.Player;
	import com.rs.fer.ipl.request.SavePlayerRequest;

	@SpringBootTest
	public class PlayerUtilImplTest {

		@InjectMocks
		private PlayerUtilImpl playerUtilImpl;
		
		@Test
		public void testSavePlayerRequest() {

			SavePlayerRequest request = new SavePlayerRequest();
			request.setFirstName("abc"); 
			request.setMiddleName("mno");
			request.setLastName("xyz");
			request.setDob("28-09-2022");
			request.setGender('m');
			request.setRole("c");
			request.setSpecilization("AR");
			request.setJerseyNumber("1");
			Player player = playerUtilImpl.loadSavePlayerRequestToPlayer(request);

			boolean isExpectedNotEmpty = true;
			boolean isActualNotEmpty = (null != player.getJerseyNumber());

			assertEquals(isExpectedNotEmpty, isActualNotEmpty);

		} 
		
		@Test
		public void testSavePlayerRequestFailure() {

			SavePlayerRequest request = new SavePlayerRequest();
			request.setFirstName("abc"); 
			request.setMiddleName("mno");
			request.setLastName("xyz");
			request.setDob("28-09-2022");
			request.setGender('m');
			request.setRole("c");
			request.setSpecilization("AR");
			//request.setJerseyNumber("1");
			Player player = playerUtilImpl.loadSavePlayerRequestToPlayer(request);

			boolean isExpectedNotEmpty = false;
			boolean isActualNotEmpty = (null != player.getJerseyNumber());

			assertEquals(isExpectedNotEmpty, isActualNotEmpty);

		}


		}


