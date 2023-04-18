package com.rs.fer.user.util.impl;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.rs.fer.user.entity.Address;
import com.rs.fer.user.entity.Rating;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.mapper.RegistrationRequestMapper;
import com.rs.fer.user.mapper.SaveRatingRequestMapper;
import com.rs.fer.user.mapper.UpdateUserRequestMapper;
import com.rs.fer.user.request.DeleteRatingRequest;
import com.rs.fer.user.request.EditRatingRequest;
import com.rs.fer.user.request.GetRatingRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.SaveRatingRequest;
import com.rs.fer.user.request.UpdateUserRequest;
import com.rs.fer.user.util.UserUtil;
import com.rs.fer.util.DateUtil;

@Component
public class UserUtilImpl implements UserUtil {

	@Override
	public User loadRegistrationRequestToUser(RegistrationRequest request) {

		User user = RegistrationRequestMapper.MAPPER.mapToUser(request);

		user.setCreated(DateUtil.getCurrentDate());

		String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));

		user.setOtp(otp);

		// String verificationCode = "" + random.nextInt (9000) + 1000 ;
		String uuid = UUID.randomUUID().toString();

		user.setVerificationCode(uuid);

		user.setEmailVerify("N");
		user.setMobileVerify("N");

		return user;
	}

	@Override
	public User loadLoginRequestToUser(LoginRequest request) {

		User user = new User();

		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());

		return user;
	}

	@Override
	public User loadResetPasswordRequestToUser(ResetPasswordRequest request) {
        
		User user = new User();

		user.setUserId(request.getUserId());
		user.setPassword(request.getCurrentPassword());
		
		return user;
	}

	@Override

	public User loadUpdateUserRequestToUser(UpdateUserRequest request) {

		User user = UpdateUserRequestMapper.MAPPER.mapToUser(request);
		if (user.getAddress() == null) {
			Address address = UpdateUserRequestMapper.MAPPER.mapToAddress(request);
			address.setCreated(DateUtil.getCurrentDate());
            user.setAddress(address);
		} else {
			user.getAddress().setUpdated(DateUtil.getCurrentDate());

		}

		user.setUpdated(DateUtil.getCurrentDate());
		return user;

	}

	@Override
	
	public Rating loadSaveRatingRequestToUserId(SaveRatingRequest request) {
		
		Rating rating = SaveRatingRequestMapper.MAPPER.mapToRating(request);
		rating.setCreated(DateUtil.getCurrentDate());
		rating.setUpdated("");
        
		return rating;
	}

	@Override
	public Rating loadEditRatingRequestToUserId(EditRatingRequest request) {
		Rating rating = new Rating();

		rating.setComments(request.getComments());
		rating.setRating(request.getRating());
        rating.setReviewedBy(request.getReviewerId());
        request.setUserId(request.getUserId());
        
		return rating;
	}

	@Override
	public Rating loadDeleteRatingRequestToUserId(DeleteRatingRequest request) {
		Rating rating = new Rating();
        request.setUserId(request.getUserId());
        
		return rating;
	}

	@Override
	public Rating loadGetRatingRequestToUserId(GetRatingRequest request) {
		
		Rating rating = new Rating();
        request.setUserId(request.getUserId());
        
		return rating;
		
	}

	
}
