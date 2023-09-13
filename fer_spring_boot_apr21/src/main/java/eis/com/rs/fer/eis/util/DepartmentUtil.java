package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Department;
import com.rs.fer.eis.request.AddDepartmentRequest;

public interface DepartmentUtil {
	Department loadAddDepartmentRequestToDepartment(AddDepartmentRequest request);

	
}
