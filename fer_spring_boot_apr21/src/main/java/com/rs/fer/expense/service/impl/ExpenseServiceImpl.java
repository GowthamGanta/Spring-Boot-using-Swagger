package com.rs.fer.expense.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.fer.expense.entity.Expense;
import com.rs.fer.expense.repository.ExpenseRepository;
import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.ExpenseReportRequest;
import com.rs.fer.expense.request.GetExpenseOptionsRequest;
import com.rs.fer.expense.request.GetExpenseRequest;
import com.rs.fer.expense.response.AddExpenseResponse;
import com.rs.fer.expense.response.DeleteExpenseResponse;
import com.rs.fer.expense.response.EditExpenseResponse;
import com.rs.fer.expense.response.ExpenseReportResponse;
import com.rs.fer.expense.response.GetExpenseOptionsResponse;
import com.rs.fer.expense.response.GetExpenseResponse;
import com.rs.fer.expense.service.ExpenseService;
import com.rs.fer.expense.util.ExpenseUtil;
import com.rs.fer.user.entity.User;
import com.rs.fer.user.repository.UserRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseUtil expenseUtil;

	@Autowired
	ExpenseRepository expenseRepository;

	@Autowired
	UserRepository userRepository;

	/**
	 * 
	 * Edit Expense by expenseId
	 * 
	 * @param request
	 * @return response
	 */

	@Override
	public EditExpenseResponse editExpense(EditExpenseRequest request) {
		EditExpenseResponse response = null;

		// User is present or not check
		Optional<Expense> expenseObj = expenseRepository.findById(request.getExpenseId());

		if (expenseObj.isPresent()) {

			// load vo to bean
			Expense expense = expenseUtil.loadEditExpenseRequestToExpense(request);

			// save bean to database
			expense = expenseRepository.save(expense);

			// load response
			// success
			response = new EditExpenseResponse(HttpStatus.OK, "000", "Expense edited successfully", null);
			response.setExpense(expense);
		} else {
			// failure
			response = new EditExpenseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "expense editing failed", null);
			// added extra line by ashwini
			// response = new EditExpenseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002",
			// "expense editing failed", null);
			response = new EditExpenseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "expense editing failed", null);

		}

		return response;

	}

	/**
	 * To delete expense based on expenseid
	 * 
	 * @param request
	 * @return response
	 */

	@Override

	public DeleteExpenseResponse deleteExpense(DeleteExpenseRequest request) {

		DeleteExpenseResponse response = null;

		Optional<Expense> expenseObj = expenseRepository.findById(request.getExpenseid());

		if (expenseObj.isPresent()) {

			// Delete expense based based on expenseid
			expenseRepository.deleteById(request.getExpenseid());

			// if expense is deleted success case
			response = new DeleteExpenseResponse(HttpStatus.OK, "000", "Expense is succesfully Deleted", null);
			response.setExpense(expenseObj.get());
		} else {
			// if expense is deleted failure case
			response = new DeleteExpenseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "Delete Expense is failed",
					null);
		}

		return response;
	}

	/**
	 * Add Expense
	 * 
	 * @param request
	 * @return response
	 */
	@Override
	public AddExpenseResponse addExpense(AddExpenseRequest request) {

		AddExpenseResponse response = null;

		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (userObj.isPresent()) {
			// load vo to bean
			Expense expense = expenseUtil.loadAddExpenseRequestToExpense(request);
			User user = userObj.get();
			user.getExpenses().add(expense);
			// save bean to database
			user = userRepository.save(user);

			response = new AddExpenseResponse(HttpStatus.OK, "000", "Expense Added is succesfully ", null);
			response.setExpense(expense);

		} else {
			// failure
			response = new AddExpenseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "User is not present", null);
		}
		return response;

	}

	@Override
	public GetExpenseResponse getExpense(GetExpenseRequest request) {

		GetExpenseResponse response = null;

		Optional<Expense> expenseObj = expenseRepository.findById(request.getExpenseId());

		if (expenseObj.isPresent()) {

			response = new GetExpenseResponse(HttpStatus.OK, "000", "fetch expense", null);

			response.setExpense(expenseObj.get());

		} else {
			// failure
			response = new GetExpenseResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No expense found", null);

		}

		return response;

	}

	@Override
	public ExpenseReportResponse expenseReport(ExpenseReportRequest request) {

		ExpenseReportResponse response = null;

		List<Expense> expenseReport = ExpenseRepository.findByUserIdAndTypeAndDateBetween(request.getUserId(), request.getType(), request.getFromDate(), request.getToDate());

		if (!expenseReport.isEmpty()) {

			response = new ExpenseReportResponse(HttpStatus.OK, "000", "fetch expense", null);

			response.setExpense(expenseReport);

		} else { // failure response = new
			response = new ExpenseReportResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No expense found", null);

		}

		return response;
	}
	
	@Override
	public GetExpenseOptionsResponse getExpenseOptions(GetExpenseOptionsRequest request) {
		GetExpenseOptionsResponse response = null;

		// To load the userObject based on userId
		Optional<User> userObj = userRepository.findById(request.getUserId());

		if (userObj.isPresent()) {
			// If expenses with that particular userId is present return expenses
			// load response
			// success
			response = new GetExpenseOptionsResponse(HttpStatus.OK, "000", "GetExpenses Success", null);
			response.setExpenses(userObj.get().getExpenses());
		} else {
			// If expenses with that particular userId is not present return response with
			// error messages
			// failure
			response = new GetExpenseOptionsResponse(HttpStatus.INTERNAL_SERVER_ERROR, "002", "No expenses", null);
		}

		return response;
	}

}
