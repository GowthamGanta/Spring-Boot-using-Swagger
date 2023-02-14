
package com.rs.fer.user.util.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.user.entity.User;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
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
		String isActualNotEmpty = user.getVerificationCode();

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
		

		User errorMessages = userUtilImpl.loadUpdateUserRequestToUser(request);

		boolean isExpectedNotEmpty = true;
		String isActualNotEmpty = errorMessages.getVerificationCode();

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

		User errorMessages = userUtilImpl.loadUpdateUserRequestToUser(request);

		boolean isExpectedEmpty = false;
		String isActualEmpty = errorMessages.getVerificationCode();
		 
		assertEquals(isExpectedEmpty, isActualEmpty);
	}

}
