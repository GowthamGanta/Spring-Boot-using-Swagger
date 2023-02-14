package com.rs.fer.expense.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.rs.fer.expense.entity.Expense;
import com.rs.fer.expense.request.AddExpenseRequest;
import com.rs.fer.expense.request.DeleteExpenseRequest;
import com.rs.fer.expense.request.EditExpenseRequest;
import com.rs.fer.expense.request.ExpenseReportRequest;
import com.rs.fer.expense.util.impl.ExpenseUtilImpl;
import com.rs.fer.message.entity.Message;
import com.rs.fer.message.request.SaveMessageRequest;
import com.rs.fer.message.util.impl.MessageUtilImpl;
import com.rs.fer.util.DateUtil;

	
	@SpringBootTest
	public class ExpenseUtilImplTest {

		@InjectMocks
		private ExpenseUtilImpl expenseUtilImpl;

		@Test
		public void testUtilloadAddExpenseRequestToExpense() {

			AddExpenseRequest request = new AddExpenseRequest();

			request.setType("tea");
			request.setDate("28-01-2022");
			request.setPrice(90);
			request.setNumberOfItems(5);
			request.setTotal(4);
			request.setBywhom("Myself");
			request.setUserId(1);


			Expense errorMessage = expenseUtilImpl.loadAddExpenseRequestToExpense(request);

			boolean isExpectedEmpty = true;
			boolean isActualEmpty = (0 != errorMessage.getUserId());

			assertEquals(isExpectedEmpty, isActualEmpty);

		}

		@Test
		public void testUtilloadAddExpenseRequestToExpenseFailure() {

			AddExpenseRequest request = new AddExpenseRequest();

			//request.setType("tea");
			request.setDate("28-01-2022");
			request.setPrice(90);
			request.setNumberOfItems(5);
			request.setTotal(4);
			request.setBywhom("Myself");
			//request.setUserId(1);

			Expense errorMessage = expenseUtilImpl.loadAddExpenseRequestToExpense(request);

			boolean isExpectedEmpty = false;
			boolean isActualEmpty = (0 != errorMessage.getUserId());

			assertEquals(isExpectedEmpty, isActualEmpty); 

		}
		
		@Test
		public void testUtilloadEditExpenseRequestToExpense() {

			EditExpenseRequest request = new EditExpenseRequest();

			request.setType("coffee");
			request.setDate("28-01-2022");
			request.setPrice(90);
			request.setNumberOfItems(5);
			request.setTotal(4);
			request.setBywhom("Me");
			request.setExpenseId(2);


			Expense errorMessage = expenseUtilImpl.loadEditExpenseRequestToExpense(request);

			boolean isExpectedEmpty = true;
			boolean isActualEmpty = (0 != errorMessage.getExpenseId());

			assertEquals(isExpectedEmpty, isActualEmpty);

		}
		
		@Test
		public void testUtilloadEditExpenseRequestToExpenseFailure() {

			EditExpenseRequest request = new EditExpenseRequest();

			request.setType("coffee");
			request.setDate("28-01-2022");
			request.setPrice(90);
			request.setNumberOfItems(5);
			request.setTotal(4);
			request.setBywhom("Myself");
			//request.setExpenseId(1);

			Expense errorMessage = expenseUtilImpl.loadEditExpenseRequestToExpense(request);

			boolean isExpectedEmpty = false;
			boolean isActualEmpty = (0 != errorMessage.getExpenseId());

			assertEquals(isExpectedEmpty, isActualEmpty); 

		}
		

		@Test
		public void testUtilloadDeleteExpenseRequestToExpense() {

			DeleteExpenseRequest request = new DeleteExpenseRequest();

			request.setExpenseid(1);


			Expense errorMessage = expenseUtilImpl.loadDeleteExpenseRequestToExpense(request);

			boolean isExpectedEmpty = true;
			boolean isActualEmpty = (0 != errorMessage.getExpenseId());

			assertEquals(isExpectedEmpty, isActualEmpty);

		}
		
		@Test
		public void testUtilloadDeleteExpenseRequestToExpenseFailure() {

			DeleteExpenseRequest request = new DeleteExpenseRequest();

			//request.setExpenseid(1);


			Expense errorMessage = expenseUtilImpl.loadDeleteExpenseRequestToExpense(request);

			boolean isExpectedEmpty = false;
			boolean isActualEmpty = ( null != errorMessage.getExpenseId());

			assertEquals(isExpectedEmpty, isActualEmpty);

		}
		
		@Test
		public void testUtilloadExpenseReportRequestToExpense() {

			ExpenseReportRequest request = new ExpenseReportRequest();
			
			request.setType("coffee");
			request.setFromDate("27-01-2022");
			request.setToDate("30-01-2022");
			

			Expense errorMessage = expenseUtilImpl.loadExpenseReportRequestToExpense(request);

			boolean isExpectedEmpty = true;
			boolean isActualEmpty = ( null != errorMessage.getType());

			assertEquals(isExpectedEmpty, isActualEmpty); 

		}



}
