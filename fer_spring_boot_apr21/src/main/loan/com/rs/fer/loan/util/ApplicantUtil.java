package com.rs.fer.loan.util;

import com.rs.fer.loan.entity.LoanAccount;
import com.rs.fer.loan.request.SaveApplicantRequest;

public interface ApplicantUtil {

	LoanAccount loadSaveApplicantRequestToApplicant(SaveApplicantRequest request);


}
