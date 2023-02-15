package com.rs.fer.user.util.impl;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.rs.fer.user.entity.Address;
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

		User user = new User();

		user.setUserId(request.getUserId());
		user.setFirstname(request.getFirstname());
		user.setMiddlename(request.getMiddlename());
		user.setLastname(request.getLastname());
		user.setEmail(request.getEmail());
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
		user.setMobile(request.getMobile());

		if (user.getAddress() == null) {
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

	@Override
	
	public Rating loadSaveRatingRequestToUserId(SaveRatingRequest request) {
		
		Rating rating = new Rating();

		rating.setComments(request.getComments());
		rating.setRating(request.getRating());
        rating.setReviewedBy(request.getReviewerId());
        request.setUserId(request.getUserId());
        
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
