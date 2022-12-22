package com.rs.fer.admin.service.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;  

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.admin.request.UnblockUserRequest;
import com.rs.fer.admin.response.UnblockUserResponse;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;

@SpringBootTest
public class AdminServiceImplTest {

	@InjectMocks 
	private AdminServiceImpl adminServiceImpl;

	@Mock
	UserRepository userRepository;


	@Test
	public void testUnblockUser() {

		User user = new User();
		user.setBlockStatus("Y");
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		when(userRepository.save(Mockito.any())).thenReturn(user);
		
		UnblockUserRequest request = new UnblockUserRequest();
		UnblockUserResponse response = adminServiceImpl.unblockUser(request);

		// 3.  
		assertEquals("000", response.statusCode);

	}
	   
	
	@Test
	public void testUserNotPresent() {

		Optional<User> userObj = Optional.empty();
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		
		UnblockUserRequest request = new UnblockUserRequest();

		UnblockUserResponse response = adminServiceImpl.unblockUser(request);

		// 3.
		assertEquals("001", response.statusCode);
		
	}
	@Test
	public void testUserAlreadyUnblocked() {

		User user = new User();
		user.setBlockStatus("N");
		Optional<User> userObj = Optional.of(user);
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		UnblockUserRequest request = new UnblockUserRequest();

		UnblockUserResponse response = adminServiceImpl.unblockUser(request);

		// 3.  
		assertEquals("002", response.statusCode);

	}
}