package com.rs.fer.expense.mapper;

import com.rs.fer.expense.entity.Expense;
import com.rs.fer.expense.request.AddExpenseRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T07:34:40+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
public class AddExpenseRequestMapperImpl implements AddExpenseRequestMapper {

    @Override
    public Expense mapToExpense(AddExpenseRequest request) {
        if ( request == null ) {
            return null;
        }

        Expense expense = new Expense();

        expense.setType( request.getType() );
        expense.setDate( request.getDate() );
        expense.setPrice( request.getPrice() );
        expense.setNumberOfItems( request.getNumberOfItems() );
        expense.setTotal( request.getTotal() );
        expense.setBywhom( request.getBywhom() );
        expense.setUserId( request.getUserId() );

        return expense;
    }
}
