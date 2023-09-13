package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.EducationalDetails;
import com.rs.fer.eis.request.EducationalDetailsRequest;

public interface EducationalDetailsUtil {

	EducationalDetails loadSaveEducationalDetailsRequestToEducationalDetails(EducationalDetailsRequest request);

}
