package com.rs.fer.loan.util;

import com.rs.fer.loan.entity.Applicant;
import com.rs.fer.loan.request.SaveApplicantRequest;

public interface ApplicantUtil {

	Applicant loadSaveApplicantRequestToApplicant(SaveApplicantRequest request);


}
