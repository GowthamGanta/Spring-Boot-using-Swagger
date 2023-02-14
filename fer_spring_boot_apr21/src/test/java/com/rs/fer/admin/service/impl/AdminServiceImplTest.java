package com.rs.fer.admin.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.GetBlockUserRequest;
import com.rs.fer.admin.request.GetUnblockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;
import com.rs.fer.admin.response.BlockUserResponse;
import com.rs.fer.admin.response.GetBlockUserResponse;
import com.rs.fer.admin.response.GetUnblockUserResponse;
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
	public void testUnblockUserNotPresent() {

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

	@Test
	public void testBlockUser() {
		User user = new User();
		user.setBlockStatus("Y");
		user.setUserId(1);
		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(userRepository.save(Mockito.any())).thenReturn(user);

		BlockUserRequest request = new BlockUserRequest();
		BlockUserResponse response = adminServiceImpl.blockUser(request);
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testBlockUserIsNotPresent() {

		Optional<User> userObj = Optional.empty();

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		BlockUserRequest request = new BlockUserRequest();
		BlockUserResponse response = adminServiceImpl.blockUser(request);
		assertEquals("001", response.statusCode);

	}

	@Test
	public void testUserIsAlreadyBlocked() {

		User user = new User();

		user.setBlockStatus("y");

		user.setUserId(1);

		Optional<User> userObj = Optional.of(user);

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		BlockUserRequest request = new BlockUserRequest();

		BlockUserResponse response = adminServiceImpl.blockUser(request);
		assertEquals("002", response.statusCode);

	}

	@Test
	public void testGetBlockUsers() {
		User user = new User();
		user.setBlockStatus("Y");
		List<User> users = new ArrayList<>();
		users.add(user);

		// Mock
		when(userRepository.findByBlockStatus(Mockito.anyString())).thenReturn(users);
		
		GetBlockUserRequest request = new GetBlockUserRequest();

		GetBlockUserResponse response = adminServiceImpl.getBlockUsers(request);

		// 3.
		assertEquals("000", response.statusCode);

	}

	@Test
	public void testGetBlockUserResponseFailure() {
		List<User> users = new ArrayList<>();
	

		when(userRepository.findByBlockStatus(Mockito.anyString())).thenReturn(users);
		
		GetBlockUserRequest request = new GetBlockUserRequest();

		GetBlockUserResponse response = adminServiceImpl.getBlockUsers(request);
		assertEquals("101", response.statusCode);
	}



@Test
public void testGetUnBlockUsers() {
	User user = new User();
	user.setBlockStatus("N");
	List<User> users = new ArrayList<>();
	users.add(user);

	// Mock
	when(userRepository.findByBlockStatus(Mockito.anyString())).thenReturn(users);
	
	GetUnblockUserRequest request = new GetUnblockUserRequest();

	GetUnblockUserResponse response = adminServiceImpl.getUnblockUsers(request);

	// 3.
	assertEquals("000", response.statusCode);

}

@Test
public void testGetUnBlockUserResponseFailure() {
	
	List<User> users = new ArrayList<>();

	
	when(userRepository.findByBlockStatus(Mockito.anyString())).thenReturn(users);
	
	GetUnblockUserRequest request = new GetUnblockUserRequest();

	GetUnblockUserResponse response = adminServiceImpl.getUnblockUsers(request);
	
	assertEquals("101", response.statusCode);
}

}