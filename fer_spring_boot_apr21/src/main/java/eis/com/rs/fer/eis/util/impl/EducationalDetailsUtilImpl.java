package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Component;

import com.rs.fer.eis.entity.EducationalDetails;
import com.rs.fer.eis.mapper.SaveEducationalDetailsRequestMapper;
import com.rs.fer.eis.request.EducationalDetailsRequest;
import com.rs.fer.eis.util.EducationalDetailsUtil;
import com.rs.fer.util.DateUtil;

@Component
public class EducationalDetailsUtilImpl implements EducationalDetailsUtil {

	@Override
	public EducationalDetails loadSaveEducationalDetailsRequestToEducationalDetails(EducationalDetailsRequest request) {

		EducationalDetails educationalDetails = SaveEducationalDetailsRequestMapper.MAPPER
				.mapToEducationalDetails(request);
		educationalDetails.setCreated(DateUtil.getCurrentDate());

		return educationalDetails;

	}

}
