package com.rs.fer.user.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.bean.User;
import com.rs.fer.bean.Address;

import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.util.UserUtil;
import com.rs.fer.util.DateUtil;

@Component
public class UserUtilImpl implements UserUtil {

	@Override
	public User loadRegistrationRequestToUser(RegistrationRequest request) {

		User user = new User();
		// user

		user.setFirstname(request.getFirstname());
		user.setMiddlename(request.getMiddlename());
		user.setLastname(request.getLastname());
		user.setEmail(request.getEmail());
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setMobile(request.getMobile());

		user.setCreated(DateUtil.getCurrentDate());

		return user;
	}

	@Override
	public User loadResetPasswordRequestToUser(ResetPasswordRequest request) {

		return null;
	}
	
		@Override
	
	
	public User loadUpdateUserRequestToUser(UpdateUserRequest request) {

		User user = new User();

		user.setUserId(request.getUserId());
		user.setFirstname(request.getFirstname());
		user.setMiddlename(request.getMiddlename());
		user.setLastname(request.getLastname());
		user.setEmail(request.getEmail());
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setMobile(request.getMobile());

		if(user.getAddress() == null) {
			user.setAddress(new Address());
			user.getAddress().setCreated(DateUtil.getCurrentDate());
			user.getAddress().setAddressId(request.getAddressId());
			user.getAddress().setLineone(request.getLineone());
			user.getAddress().setLinetwo(request.getLinetwo());
			user.getAddress().setCity(request.getCity());
			user.getAddress().setState(request.getState());
			user.getAddress().setPincode(request.getPincode());
			user.getAddress().setCountry(request.getCountry());
			

		} else {
			user.getAddress().setUpdated(DateUtil.getCurrentDate());

		}
		
		
		user.setUpdated(DateUtil.getCurrentDate());
		return user;

	}


}
