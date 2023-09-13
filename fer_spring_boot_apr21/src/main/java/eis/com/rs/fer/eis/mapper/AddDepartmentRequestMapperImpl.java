package com.rs.fer.eis.mapper;

import com.rs.fer.eis.entity.Department;
import com.rs.fer.eis.request.AddDepartmentRequest;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T07:34:40+0530",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
public class AddDepartmentRequestMapperImpl implements AddDepartmentRequestMapper {

    @Override
    public Department mapToDepartment(AddDepartmentRequest request) {
        if ( request == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( request.getId() );
        department.setDepartmentName( request.getDepartmentName() );
        
        return department;
    }
    
}
