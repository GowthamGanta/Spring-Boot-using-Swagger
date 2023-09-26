package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Department;
import com.rs.fer.eis.request.AddDepartmentRequest;
import com.rs.fer.eis.request.DeleteDepartmentRequest;
import com.rs.fer.eis.request.EditDepartmentRequest;

public interface DepartmentUtil {
	Department loadAddDepartmentRequestToDepartment(AddDepartmentRequest request);

	Department loadEditDepartmentRequestToDepartment(EditDepartmentRequest request);

	Department loadDeleteDepartmentRequestToDepartment(DeleteDepartmentRequest request);

}


