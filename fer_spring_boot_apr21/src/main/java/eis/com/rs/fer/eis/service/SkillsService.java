package com.rs.fer.eis.service;

import com.rs.fer.eis.request.DeleteSkillsRequest;
import com.rs.fer.eis.request.EditSkillsRequest;
import com.rs.fer.eis.request.GetSkillsRequest;
import com.rs.fer.eis.request.SaveSkillsRequest;
import com.rs.fer.eis.response.DeleteSkillsResponse;
import com.rs.fer.eis.response.EditSkillsResponse;
import com.rs.fer.eis.response.GetSkillsResponse;
import com.rs.fer.eis.response.SaveSkillsResponse;

public interface SkillsService {

	SaveSkillsResponse saveSkills(SaveSkillsRequest request);

	DeleteSkillsResponse deleteSkills(DeleteSkillsRequest request);

	GetSkillsResponse getSkills(GetSkillsRequest request);

	EditSkillsResponse editSkills(EditSkillsRequest request);

}
