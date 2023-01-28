package com.rs.fer.admin.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.ExpenseReportRequest;
import com.rs.fer.expense.request.GetExpenseOptionsRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.EditExpenseResponse;
import com.rs.fer.expense.response.ExpenseReportResponse;
import com.rs.fer.expense.response.GetExpenseOptionsResponse;
import com.rs.fer.expense.response.GetExpenseResponse;
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.validation.ExpenseValidation;
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
import com.rs.fer.user.service.UserService;
import com.rs.fer.user.validation.UserValidation;

@RestController
@RequestMapping("/adminapi")
public class AdminController2 {

	@Autowired
	UserValidation userValidation;

	@Autowired
	ExpenseService expenseService;

	@Autowired
	ExpenseValidation expenseValidation;

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

	@GetMapping("/expenseReport")
	public ExpenseReportResponse expenseReport(@RequestBody ExpenseReportRequest request) {

		ExpenseReportResponse response = null;

		Set<String> errorMessages = expenseValidation.validateExpenseReportRequest(request);

		/*
		 * List<Expense> expenseObj =
		 * expenseReportRepository.findByUserIdAndTypeAndDateBetween(request.getUserId()
		 * , request.getType(),request.getFromDate(),request.getToDate());
		 */

		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {

			response = new ExpenseReportResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No expense found", null);

		} else {
			response = expenseService.expenseReport(request);
		}
		return response;

	}

	@PutMapping("/editExpense")
	public EditExpenseResponse editExpense(@RequestBody EditExpenseRequest request) {

		EditExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateEditExpenseRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new EditExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = expenseService.editExpense(request);
		}
		return response;

	}

	@PostMapping("/getUser")
	public GetUserResponse getUser(@RequestBody GetUserRequest request) {

		GetUserResponse response = null;

		Set<String> errorMessages = userValidation.validateGetUserRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new GetUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.getUser(request);
		}
		return response;
	}

	@PutMapping("/resetPassword")
	public ResetPasswordResponse resetPassword(@RequestBody ResetPasswordRequest request) {

		ResetPasswordResponse response = null;

		Set<String> errorMessages = userValidation.validateResetPasswordRequest(request);

		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new ResetPasswordResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.resetPassword(request);
		}
		return response;
	}

	@PutMapping("/updateUser")
	public UpdateUserResponse updateUser(@RequestBody UpdateUserRequest request) {

		UpdateUserResponse response = null;

		Set<String> errorMessages = userValidation.validateUpdateUserRequest(request);
		// return response with error messages
		if (!CollectionUtils.isEmpty(errorMessages)) {
			response = new UpdateUserResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);

		} else {
			response = userService.updateUser(request);
		}
		return response;
	}

	@PostMapping("/addExpense")
	public AddExpenseResponse addExpense(@RequestBody AddExpenseRequest request) {

		AddExpenseResponse response = null;

		Set<String> errorMessages = expenseValidation.validateAddExpenseRequest(request);
		// return response with error messages
		if (!org.springframework.util.CollectionUtils.isEmpty(errorMessages)) {
			response = new AddExpenseResponse(HttpStatus.PRECONDITION_FAILED, "999", null, errorMessages);
		} else {
			response = expenseService.addExpense(request);
		}
		return response;
	}

}
