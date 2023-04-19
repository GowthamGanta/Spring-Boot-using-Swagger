package com.rs.fer.expense.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.expense.entity.Expense;
import com.rs.fer.expense.request.AddExpenseRequest;

@Mapper
public interface AddExpenseRequestMapper {

	AddExpenseRequestMapper  MAPPER  = Mappers.getMapper(AddExpenseRequestMapper.class) ;
	
	Expense mapToExpense(AddExpenseRequest request);
}
