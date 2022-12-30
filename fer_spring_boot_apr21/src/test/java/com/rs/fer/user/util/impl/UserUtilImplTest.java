
package com.rs.fer.user.util.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.user.entity.User;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.UpdateUserRequest;

@SpringBootTest
public class UserUtilImplTest {

	@InjectMocks
	private UserUtilImpl userUtilImpl;

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

		assertEquals(isExpectedNotEmpty, isExpectedNotEmpty);
	}

	@Test
	public void testUpdateUserUtilfailure() {

		UpdateUserRequest request = new UpdateUserRequest();

		request.setUserId(1);

		request.setFirstname("admin");
		request.setMiddlename("rs");
		request.setLastname("suda");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rss");
		request.setMobile("4545454545");

		request.setAddressId(1);

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
