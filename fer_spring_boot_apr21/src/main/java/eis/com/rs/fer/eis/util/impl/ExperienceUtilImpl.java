package com.rs.fer.eis.util.impl;

import org.springframework.stereotype.Service;

import com.rs.fer.eis.entity.Experience_Details;
import com.rs.fer.eis.mapper.EditExperienceRequestMapper;
import com.rs.fer.eis.mapper.SaveExperienceRequestMapper;
import com.rs.fer.eis.request.EditExperienceRequest;
import com.rs.fer.eis.request.SaveExperienceRequest;
import com.rs.fer.eis.util.ExperienceUtil;
import com.rs.fer.util.DateUtil;

@Service
public class ExperienceUtilImpl implements ExperienceUtil {

	@Override
	public Experience_Details loadSaveExperienceRequestToEmployee(SaveExperienceRequest request) {
		Experience_Details experience_Details = SaveExperienceRequestMapper.MAPPER.mapToDetails(request);
		experience_Details.setCreated(DateUtil.getCurrentDate());

		return experience_Details;
	}

	

	@Override
	public Experience_Details loadEditExperienceRequestToEmployee(EditExperienceRequest request,
			Experience_Details experience_Details) {
		Experience_Details experienceDetails = EditExperienceRequestMapper.MAPPER.mapToDetails(request,experience_Details);
		experienceDetails.setUpdated(DateUtil.getCurrentDate());

		return experience_Details;
	}

}
