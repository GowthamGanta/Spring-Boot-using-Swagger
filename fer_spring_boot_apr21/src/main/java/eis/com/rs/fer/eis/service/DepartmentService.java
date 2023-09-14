package com.rs.fer.eis.service;

import com.rs.fer.eis.request.AddDepartmentRequest;
import com.rs.fer.eis.request.DeleteDepartmentRequest;
import com.rs.fer.eis.request.EditDepartmentRequest;
import com.rs.fer.eis.request.GetDepartmentOptionsRequest;
import com.rs.fer.eis.request.GetDepartmentRequest;
import com.rs.fer.eis.response.AddDepartmentResponse;
import com.rs.fer.eis.response.DeleteDepartmentResponse;
import com.rs.fer.eis.response.EditDepartmentResponse;
import com.rs.fer.eis.response.GetDepartmentOptionsResponse;
import com.rs.fer.eis.response.GetDepartmentResponse;

public interface DepartmentService {

	AddDepartmentResponse addDepartment(AddDepartmentRequest request);

	EditDepartmentResponse editDepartment(EditDepartmentRequest request);

	GetDepartmentOptionsResponse getdepartmentOptions(GetDepartmentOptionsRequest request);

	DeleteDepartmentResponse deleteDepartment(DeleteDepartmentRequest request);

	GetDepartmentResponse getDepartment(GetDepartmentRequest request);

}


