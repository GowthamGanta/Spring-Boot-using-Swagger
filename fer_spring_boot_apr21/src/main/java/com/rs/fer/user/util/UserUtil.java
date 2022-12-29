package com.rs.fer.user.util;

import com.rs.fer.user.entity.Rating;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.request.EditRatingRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.request.ResetPasswordRequest;
import com.rs.fer.user.request.SaveRatingRequest;
import com.rs.fer.user.request.UpdateUserRequest;

public interface UserUtil {
	// load resetpassword

	User loadRegistrationRequestToUser(RegistrationRequest request);

	User loadLoginRequestToUser(LoginRequest request);

	User loadResetPasswordRequestToUser(ResetPasswordRequest request);

	User loadUpdateUserRequestToUser(UpdateUserRequest request);

	Rating loadSaveRatingRequestToUserId(SaveRatingRequest request);

	Rating loadEditRatingRequestToUserId(EditRatingRequest request);

}
