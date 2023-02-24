
package com.rs.fer.user.util.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.user.entity.Rating;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.request.DeleteRatingRequest;
import com.rs.fer.user.request.EditRatingRequest;
import com.rs.fer.user.request.GetRatingRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.SaveRatingRequest;
import com.rs.fer.user.request.UpdateUserRequest;

@SpringBootTest
public class UserUtilImplTest {

	@InjectMocks
	private UserUtilImpl userUtilImpl;
	
	@Test
	public void testRegitrationRequest() {

		RegistrationRequest request = new RegistrationRequest();
		request.setFirstname("abc"); 
		request.setMiddlename("mno");
		request.setLastname("xyz");
		request.setEmail("sw@gmail.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("23487665");

		User user = userUtilImpl.loadRegistrationRequestToUser(request);

		boolean isExpectedNotEmpty = true;
		boolean isActualNotEmpty = (null != user.getUsername());

		assertEquals(isExpectedNotEmpty, isActualNotEmpty);

	}

	@Test
	public void testUtillLoginRequest() {

		LoginRequest request = new LoginRequest();

		request.setUsername("admin");
		request.setPassword("rs");

		User user = userUtilImpl.loadLoginRequestToUser(request);

		boolean isExpectedNotEmpty = true;
		boolean isActualNotEmpty = (null != user.getUsername() && null != user.getPassword());

		assertEquals(isExpectedNotEmpty, isActualNotEmpty);

	}

	@Test
	public void testUtillLoginRequestfailure() {

		LoginRequest request = new LoginRequest();

		// request.setUsername("admin");
		request.setPassword("rs");

		User user = userUtilImpl.loadLoginRequestToUser(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (null == user.getUsername()) || (null == user.getPassword());

		assertEquals(isExpectedEmpty, isActualEmpty);

	}
	
	@Test
	public void testResetPasswordRequest() {

		ResetPasswordRequest request = new ResetPasswordRequest();

		request.setUserId(2);
		request.setCurrentPassword("abc");
		request.setNewPassword("xyz");

		User user = userUtilImpl.loadResetPasswordRequestToUser(request);

		boolean isExpectedNotEmpty = true;
		boolean isActualNotEmpty = (0 != user.getUserId() && null != user.getPassword());

		assertEquals(isExpectedNotEmpty, isActualNotEmpty);

	}
	
	@Test
	public void testResetPasswordRequestFailure() {

		ResetPasswordRequest request = new ResetPasswordRequest();

		//request.setUserId(2);
		request.setCurrentPassword("abc");
		request.setNewPassword("xyz");

		User user = userUtilImpl.loadResetPasswordRequestToUser(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (null == user.getUsername()) || (null == user.getPassword());

		assertEquals(isExpectedEmpty, isActualEmpty);

	}


	@Test
	public void testUpdateUserUtil() {

		UpdateUserRequest request = new UpdateUserRequest();

		request.setUserId(1);

		request.setFirstname("admin");
		request.setMiddlename("rs");
		request.setLastname("suda");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rss");
		request.setMobile("4545454545");

		request.setCreated("created");
		request.setAddressId(1);

		request.setLineone("madhapur");
		request.setLinetwo("100ft");
		request.setCity("Hyd");
		request.setState("TS");
		request.setPincode("500018");
		request.setCountry("IND");
		

		User user = userUtilImpl.loadUpdateUserRequestToUser(request);

		boolean isExpectedNotEmpty = true;
		boolean isActualNotEmpty = (null != user.getUsername()); 

		assertEquals(isExpectedNotEmpty, isActualNotEmpty);
	}

	@Test
	public void testUpdateUserUtilfailure() {

		UpdateUserRequest request = new UpdateUserRequest();

		//request.setUserId(1);

		request.setFirstname("admin");
		request.setMiddlename("rs");
		request.setLastname("suda");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rss");
		request.setMobile("4545454545");

		//request.setAddressId(1);

		request.setLineone("madhapur");
		request.setLinetwo("100ft");
		request.setCity("Hyd");
		request.setState("TS");
		request.setPincode("500018");
		request.setCountry("IND");

		User user = userUtilImpl.loadUpdateUserRequestToUser(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (null != user.getUsername());
		 
		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testSaveRatingRequest() {
		
		SaveRatingRequest request = new SaveRatingRequest();
		
		request.setComments("Done");
		request.setRating(5);
		request.setReviewerId(4);
		request.setUserId(5);
		
		Rating rating = userUtilImpl.loadSaveRatingRequestToUserId(request);

		boolean isExpectedNotEmpty = true;
		boolean isActualNotEmpty = (0 != rating.getRating());
		 
		assertEquals(isExpectedNotEmpty, isActualNotEmpty);
	}
	
	@Test
	public void testSaveRatingFailure() {
		
		SaveRatingRequest request = new SaveRatingRequest();
		
		//request.setComments("Done");
		request.setRating(4);
		request.setReviewerId(3);
		request.setUserId(5);
		
		Rating rating = userUtilImpl.loadSaveRatingRequestToUserId(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (0 != rating.getRating());
		 
		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testEditRating() {
		
		EditRatingRequest request = new EditRatingRequest();
		
		request.setComments("Completed");
		request.setRating(5);
		request.setReviewerId(4);
		request.setUserId(5);
		
		Rating rating = userUtilImpl.loadEditRatingRequestToUserId(request);

		boolean isExpectedNotEmpty = true;
		boolean isActualNotEmpty = (0 != rating.getRating());
		 
		assertEquals(isExpectedNotEmpty, isActualNotEmpty);
	}
	
	@Test
	public void testEditRatingFailure() {
		
		EditRatingRequest request = new EditRatingRequest();
		
		//request.setComments("Completed");
		request.setRating(4);
		request.setReviewerId(3);
		request.setUserId(5);
		
		Rating rating = userUtilImpl.loadEditRatingRequestToUserId(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (0 != rating.getRating());
		 
		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	/*
	@Test
	public void testDeleteRating() {
		
		DeleteRatingRequest request = new DeleteRatingRequest();
		
		request.setUserId(5);
		
		Rating rating = userUtilImpl.loadDeleteRatingRequestToUserId(request);
		

		boolean isExpectedNotEmpty = true;
		boolean isActualNotEmpty = (0 != rating.getUserId());
		 
		assertEquals(isExpectedNotEmpty, isActualNotEmpty); 
	}
	
	@Test
	public void testDeleteRatingFailure() {
		
		DeleteRatingRequest request = new DeleteRatingRequest();
		
		//request.setUserId(5);
		
		Rating rating = userUtilImpl.loadDeleteRatingRequestToUserId(request);

		boolean isExpectedEmpty = true;
		boolean isActualEmpty = (0 != rating.getUserId());
		 
		assertEquals(isExpectedEmpty, isActualEmpty);
	}
	
	@Test
	public void testGetRating() {
		
		GetRatingRequest request = new GetRatingRequest();
		
		request.setUserId(5);
		
		Rating rating = userUtilImpl.loadGetRatingRequestToUserId(request);

		boolean isExpectedNotEmpty = true;
		boolean isActualNotEmpty = (0 != rating.getId());
		 
		assertEquals(isExpectedNotEmpty, isActualNotEmpty);
	}*/
	
	
	

}
