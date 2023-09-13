package com.rs.fer.eis.service;

import com.rs.fer.eis.request.SaveSkillsRequest;
import com.rs.fer.eis.response.SaveSkillsResponse;

public interface SkillsService {

	SaveSkillsResponse saveSkills(SaveSkillsRequest request);

}
