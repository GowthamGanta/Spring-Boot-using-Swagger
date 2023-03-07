package com.rs.fer.follow.service.impl;

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

import com.rs.fer.follow.entity.Follow;
import com.rs.fer.follow.request.DeletefollowerRequest;
import com.rs.fer.follow.request.SaveFollowerRequest;
import com.rs.fer.follow.response.DeletefollowerResponse;
import com.rs.fer.follow.response.SaveFollowerResponse;
import com.rs.fer.follow.service.FollowerService;
import com.rs.fer.follow.util.FollowerUtil;
import com.rs.fer.follower.repository.FollowerRepository;
import com.rs.fer.message.entity.Message;
import com.rs.fer.message.request.DeleteMessageRequest;
import com.rs.fer.message.response.DeleteMessageResponse;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;

@SpringBootTest
public class FollowerServiceImplTest {

	@InjectMocks
	FollowerServiceImpl followerServiceImpl;

	@Mock
	FollowerService followerService;
	@Mock
	FollowerRepository followerRepository;
	@Mock
	UserRepository userRepository;
	@Mock
	FollowerUtil followerUtil;

	@Test
	public void testSaveFollower() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);

		SaveFollowerRequest request = new SaveFollowerRequest();
		request.setFollowerId(2);
		request.setUserId(1);

		Follow follow = new Follow();
		follow.setId(5);

		// mock

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(followerUtil.loadSaveFollowerRequest(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(follow);

		when(followerRepository.save(Mockito.any())).thenReturn(follow);

		SaveFollowerResponse response = followerServiceImpl.saveFollower(request);

		assertEquals("000", response.statusCode);

	}

	@Test
	public void testSaveFollowerFailure() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);

		SaveFollowerRequest request = new SaveFollowerRequest();
		request.setFollowerId(2);
		request.setUserId(1);

		Follow follow = new Follow();
		// follow.setId(5);

		// mock

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(followerUtil.loadSaveFollowerRequest(Mockito.any(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(follow);

		when(followerRepository.save(Mockito.any())).thenReturn(follow);

		SaveFollowerResponse response = followerServiceImpl.saveFollower(request);

		assertEquals("001", response.statusCode);

	}

	@Test
	public void testUserNotFound() {

		Optional<User> userObj = Optional.empty();
		SaveFollowerRequest request = new SaveFollowerRequest();

		request.setFollowerId(12);
		request.setUserId(22);

		// mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);
		SaveFollowerResponse response = followerServiceImpl.saveFollower(request);

		assertEquals("401", response.statusCode);

	}

	@Test
	public void testUserEmailVerify() {
		User user = new User();
		Optional<User> userObj = Optional.of(user);

		SaveFollowerRequest request = new SaveFollowerRequest();

		user = userObj.get();
		user.setEmailVerify("N");
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		SaveFollowerResponse response = followerServiceImpl.saveFollower(request);

		assertEquals("402", response.statusCode);

	}

	@Test
	public void testUserMobileVerify() {
		User user = new User();
		Optional<User> userObj = Optional.of(user);

		SaveFollowerRequest request = new SaveFollowerRequest();

		user = userObj.get();
		user.setMobileVerify("N");
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		SaveFollowerResponse response = followerServiceImpl.saveFollower(request);

		assertEquals("403", response.statusCode);

	}

	@Test
	public void testFollowerNotFound() {
		User user = new User();
		Optional<User> userObj = Optional.of(user);

		SaveFollowerRequest request = new SaveFollowerRequest();
		request.setUserId(13);
		// request.setFollowerId(null);

		// Mock

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		SaveFollowerResponse response = followerServiceImpl.saveFollower(request);

		assertEquals("404", response.statusCode);

	}

	@Test
	public void testFollowerMobileVerify() {
		User user = new User();
		Optional<User> userObject = Optional.of(user);

		SaveFollowerRequest request = new SaveFollowerRequest();
		// request.setUserId(13);
		request.setFollowerId(22);
		User follower = userObject.get();
		follower.setMobileVerify("Not");
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObject);

		SaveFollowerResponse response = followerServiceImpl.saveFollower(request);

		assertEquals("406", response.statusCode);

	}

	@Test
	public void testFollowerEmailVerify() {
		User user = new User();
		Optional<User> userObject = Optional.of(user);

		SaveFollowerRequest request = new SaveFollowerRequest();
		// request.setUserId(13);
		request.setFollowerId(22);
		User follower = userObject.get();
		follower.setEmailVerify("Not");
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObject);

		SaveFollowerResponse response = followerServiceImpl.saveFollower(request);

		assertEquals("405", response.statusCode);

	}

	@Test
	public void testDeleteFollower() {

		User user = new User();
		Optional<User> userObj = Optional.of(user);

		DeletefollowerRequest request = new DeletefollowerRequest();
		request.setFollowerId(2);
		request.setUserId(1);
		List<Follow> followers = new ArrayList<Follow>(1);
		Follow follow = new Follow();
		follow.setId(5);
		followers.add(follow);

		// mock

		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObj);

		when(followerRepository.findByUserIdAndFollowerId(Mockito.anyInt(), Mockito.anyInt())).thenReturn(followers);

		when(followerRepository.save(Mockito.any())).thenReturn(follow);

		DeletefollowerResponse response = followerServiceImpl.deleteFollower(request);

		assertEquals("000", response.statusCode);

	}
	@Test
	public void testDeleteFollowerNotFound() {
		Optional<Follow> follow = Optional.empty();

		DeletefollowerRequest request = new DeletefollowerRequest();
		//request.setId(13);
		request.setUserId(22);

		when(followerRepository.findById(Mockito.anyInt())).thenReturn(follow);
		DeletefollowerResponse response = followerServiceImpl.deleteFollower(request);
		assertEquals("501", response.statusCode);

	}
	
	@Test
	public void testDeleteUserEmailVerify() {
		User user = new User();
		Optional<User> userObject = Optional.of(user);

		DeletefollowerRequest request = new DeletefollowerRequest();
		user = userObject.get();
		user.setEmailVerify("N");
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObject);

		DeletefollowerResponse response = followerServiceImpl.deleteFollower(request);

		assertEquals("502", response.statusCode);

	}
	@Test
	public void testDeleteUserMobileVerify() {
		User user = new User();
		Optional<User> userObject = Optional.of(user);

		DeletefollowerRequest request = new DeletefollowerRequest();
		user = userObject.get();
		user.setMobileVerify("N");
		// Mock
		when(userRepository.findById(Mockito.anyInt())).thenReturn(userObject);

		DeletefollowerResponse response = followerServiceImpl.deleteFollower(request);

		assertEquals("503", response.statusCode);

	}
}

