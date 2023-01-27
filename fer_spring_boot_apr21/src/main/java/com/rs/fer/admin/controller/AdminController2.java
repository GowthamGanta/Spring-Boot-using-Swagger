package com.rs.fer.admin.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.admin.request.BlockUserRequest;
import com.rs.fer.admin.request.UnblockUserRequest;
import com.rs.fer.admin.response.BlockUserResponse;
import com.rs.fer.admin.response.GetBlockUserResponse;
import com.rs.fer.admin.response.GetUnblockUserResponse;
import com.rs.fer.admin.response.UnblockUserResponse;
import com.rs.fer.admin.service.AdminService;
import com.rs.fer.admin.validation.AdminValidation;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.GetExpenseOptionsRequest;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.response.GetExpenseOptionsResponse;
=======
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.response.GetExpenseResponse;
>>>>>>> branch 'master' of https://github.com/GowthamGanta/Spring-Boot-using-Swagger.git
import com.rs.fer.user.request.GetUserRequest;
import com.rs.fer.user.request.LoginRequest;
import com.rs.fer.user.request.RegistrationRequest;
import com.rs.fer.user.response.GetUserResponse;
import com.rs.fer.user.response.LoginResponse;
import com.rs.fer.user.response.RegistrationResponse;
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.validation.UserValidation;

@RestController
@RequestMapping("/adminapi")
public class AdminController2 {

	@Autowired
	UserValidation userValidation;

	@Autowired
	UserService userService;

	@PostMapping("/registration")
	public RegistrationResponse registration(@RequestBody RegistrationRequest request) {

		RegistrationResponse response = null;

		Set<String> errorMessages = userValidation.validateRegistrationRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new RegistrationResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.registration(request);
		}

		return response;

	}

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {

		LoginResponse response = null;

		// int userId = ferService.login(username, password);
		Set<String> errorMessages = userValidation.validateLoginRequest(request);

		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new LoginResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = userService.login(request);
		}
		return response;
	}
	
	@PutMapping("/getExpense")
	public GetExpenseResponse getExpense(@RequestBody GetExpenseRequest request) {

		GetExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpenseRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpense(request);
		}
		return response;

	}
	
	@GetMapping("/getExpenseOptions")
	public GetExpenseOptionsResponse getExpense(@RequestBody GetExpenseOptionsRequest request) {

		GetExpenseOptionsResponse response = null;

		Set<String> errorMessages = expenseValidation.validateGetExpenseOptionsRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new GetExpenseOptionsResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.getExpenseOptions(request);
		}
		return response;
	}
	@DeleteMapping("/deleteExpense")

	public DeleteExpenseResponse deleteExpense(@ModelAttribute DeleteExpenseRequest request) {

		DeleteExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateDeleteExpenseRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new DeleteExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = expenseService.deleteExpense(request);
		}
		return response;
	}

}




