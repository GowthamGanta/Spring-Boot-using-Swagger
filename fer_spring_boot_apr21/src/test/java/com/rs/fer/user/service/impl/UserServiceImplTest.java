package com.rs.fer.user.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;
import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.LoginResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.response.ResetPasswordResponse;
import com.rs.fer.user.response.UpdateUserResponse;
import com.rs.fer.user.util.UserUtil;




@SpringBootTest
public class UserServiceImplTest {

	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepository; 
	
	@Mock
	UserUtil userUtil;
	
	@Test
	public void testRegistration() {
		
		List<User> users = new ArrayList<>(1);
		
		User user = new User();
		user.setUserId(1);
	
		 
		//Mock		
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);
		
		when(userRepository.save(Mockito.any())).thenReturn(user);
		
		when(userUtil.loadRegistrationRequestToUser(Mockito.any())).thenReturn(user);
		
		//1.
		RegistrationRequest request = new RegistrationRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");
		
		//2.
		RegistrationResponse response = userServiceImpl.registration(request);
		
		//3.
		assertEquals("000", response.statusCode);
	}
	
	@Test
	public void testRegistrationDuplicateEmail() {
		
		User user = new User();
		user.setUserId(1);
		
		List<User> users = new ArrayList<>(1);
		users.add(user);
		
		//Mock		
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);
		
		when(userRepository.save(Mockito.any())).thenReturn(user);
		
		when(userUtil.loadRegistrationRequestToUser(Mockito.any())).thenReturn(user);
		
		//1.
		RegistrationRequest request = new RegistrationRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");
		
		//2.
		RegistrationResponse response = userServiceImpl.registration(request);
		
		//3.
		assertEquals("001", response.statusCode);
	}
	
	@Test
	public void testRegistrationFailure() {
		
		List<User> users = new ArrayList<>(1);
		
		User user = new User();
		//user.setUserId(1);
		
		//Mock		
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);
		
		when(userRepository.save(Mockito.any())).thenReturn(user);
		
		when(userUtil.loadRegistrationRequestToUser(Mockito.any())).thenReturn(user);
		
		//1.
		RegistrationRequest request = new RegistrationRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");  
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");
		 
		//2.
		RegistrationResponse response = userServiceImpl.registration(request);
		
		//3.
		assertEquals("002", response.statusCode);
	}



	@Test
	public void testLogin() {
		
		List<User> users = new ArrayList<>(1);
		
		User user = new User();
		user.setUserId(1);
		users.add(user);
		
		//Mock		
		when(userRepository.findByUsernameAndPassword(Mockito.anyString(),Mockito.anyString())).thenReturn(users);
		
			
		//1.
		LoginRequest request = new LoginRequest();
		
		request.setUsername("admin");
		request.setPassword("rs");
		
		//2. 
		LoginResponse response = userServiceImpl.login(request);
		
		//3.
		assertEquals("000", response.statusCode);
	}
	
	
	@Test
	public void testLoginFailure() {
		
		
		
		
		
		List<User> users = new ArrayList<>(1);
		
		User user = new User();
		//user.setUserId(1);
		
		//Mock		
		when(userRepository.findByUsernameAndPassword(Mockito.anyString(),Mockito.anyString())).thenReturn(users);
		
		when(userRepository.save(Mockito.any())).thenThrow(MockitoException.class);
		
		when(userUtil.loadLoginRequestToUser(Mockito.any())).thenReturn(user);
		
		//1.
		LoginRequest request = new LoginRequest();
		
		request.setUsername("admin");
		request.setPassword("rs");
		
		//2.
		LoginResponse response = userServiceImpl.login(request);
		
		//3.
		assertEquals("002", response.statusCode);
	}
	
	@Test
	public void testResetPassword()
	{

		User user = new User();
		user.setUserId(1);
		user.setPassword("rs");

		Optional<User> userObj = Optional.of(user);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		when(userRepository.save(Mockito.any())).thenReturn(user);
		// 1.
		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setCurrentPassword("rs");
		request.setNewPassword("123");

		// 2.
		ResetPasswordResponse response = userServiceImpl.resetPassword(request);

		// 3.
		assertEquals("000", response.statusCode);

	}
	@Test
	public void testResetPasswordUserNotPresent() {

		User user = null;

		Optional<User> userObj = Optional.empty();
		
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		// 1.
		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setCurrentPassword("rs");
		request.setNewPassword("123");

		// 2.
		ResetPasswordResponse response = userServiceImpl.resetPassword(request);

		// 3.
		assertEquals("002", response.statusCode);

	}
  
	@Test
	public void testResetPasswordMismatch() {

		
		User user = new User();
		// user.setUserId(1);
		user.setPassword("rs1233333");
		java.util.Optional<User> userObj = java.util.Optional.of(user);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		when(userRepository.save(Mockito.any())).thenReturn(user);
		// 1.
		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setCurrentPassword("rs");
		request.setNewPassword("123");

		// 2.
		ResetPasswordResponse response = userServiceImpl.resetPassword(request);

		// 3.
		assertEquals("002", response.statusCode);

	}
	 
	@Test
	public void testUpdateUser() {

		User user = new User();
		user.setUserId(1);

		List<User> users = new ArrayList<>(1);

		// Mock
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);

		// 1.
		UpdateUserRequest request = new UpdateUserRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");

		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		when(userUtil.loadUpdateUserRequestToUser(Mockito.any())).thenReturn(user);

		request.setLineone("100ft");
		request.setLinetwo("road");
		request.setCity("hyd");
		request.setState("ts");
		request.setPincode("50081");
		request.setCountry("IND");

		UpdateUserResponse response = userServiceImpl.updateUser(request);

		// 3.
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testUpdateUserNotPresent() {

		List<User> users = new ArrayList<>(1);

		User user = new User();
		// user.setUserId(1);

		// Mock
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);

		// 1.
		UpdateUserRequest request = new UpdateUserRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");

		Optional<User> userObj = Optional.empty();

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		when(userUtil.loadUpdateUserRequestToUser(Mockito.any())).thenReturn(user);

		request.setLineone("100ft");
		request.setLinetwo("road");
		request.setCity("hyd");
		request.setState("ts");
		request.setPincode("50081");
		request.setCountry("IND");

		UpdateUserResponse response = userServiceImpl.updateUser(request);

		// 3.
		assertEquals("002", response.statusCode);

	}

	@Test
	public void testUpdateUserDuplicate() {

		User user = new User();
		user.setUserId(1);

		List<User> users = new ArrayList<>(1);
		users.add(user);

		// Mock
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);

		// 1.
		UpdateUserRequest request = new UpdateUserRequest();
		request.setFirstname("admin");
		request.setMiddlename("k");
		request.setLastname("rs");
		request.setEmail("admin@rs.com");
		request.setUsername("admin");
		request.setPassword("rs");
		request.setMobile("2342343243");

		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		when(userUtil.loadUpdateUserRequestToUser(Mockito.any())).thenReturn(user);

		request.setLineone("100ft");
		request.setLinetwo("road");
		request.setCity("hyd");
		request.setState("ts");
		request.setPincode("50081");
		request.setCountry("IND");

		UpdateUserResponse response = userServiceImpl.updateUser(request);

		// 3.
		assertEquals("001", response.statusCode);

	}

	@Test
	public void testGetUser() {

		User user = new User();
		user.setUserId(1);

		Optional<User> userObj = Optional.of(user);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		// 1.
		GetUserRequest request = new GetUserRequest();

		// 2.
		GetUserResponse response = userServiceImpl.getUser(request);

		// 3.
		assertEquals("000", response.statusCode);
	}

	@Test
	public void testGetUserNotFound() {

		User user = new User();
		// user.setUserId(1);

		Optional<User> userObj = Optional.of(user);

		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		// 1.
		GetUserRequest request = new GetUserRequest();

		// 2.
		GetUserResponse response = userServiceImpl.getUser(request);

		// 3.
		assertEquals("000", response.statusCode);
	}
}