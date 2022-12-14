package com.rs.fer.user.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.response.LoginResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.service.impl.UserServiceImpl;
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
		
		//Mock		
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);
		
		when(userRepository.save(Mockito.any())).thenReturn(user);
		
		when(userUtil.loadLoginRequestToUser(Mockito.any())).thenReturn(user);
		
		//1.
		LoginRequest request = new LoginRequest();
		
		request.setUsername("admin");
		request.setPassword("rs");
		
		//2. 
		LoginResponse response = userServiceImpl.login(request);
		
		//3.
		//assertEquals("000", response.statusCode);
	}
	
	
	@Test
	public void testLoginFailure() {
		
		List<User> users = new ArrayList<>(1);
		
		User user = new User();
		//user.setUserId(1);
		
		//Mock		
		when(userRepository.findByEmail(Mockito.anyString())).thenReturn(users);
		
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
}

