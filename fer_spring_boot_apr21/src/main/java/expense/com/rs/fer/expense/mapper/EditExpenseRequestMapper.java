package com.rs.fer.expense.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.rs.fer.eis.mapper.EditExpenseRequestMapper;
import com.rs.fer.expense.entity.Expense;
import com.rs.fer.expense.request.EditExpenseRequest;

@Mapper
public interface EditExpenseRequestMapper {

	EditExpenseRequestMapper  MAPPER  = Mappers.getMapper(EditExpenseRequestMapper.class) ;
	
	Expense mapToExpense(EditExpenseRequest request, Expense expense);
}
