package com.rs.fer.eis.util;

import com.rs.fer.eis.entity.Skills;
import com.rs.fer.eis.request.EditSkillsRequest;
import com.rs.fer.eis.request.SaveSkillsRequest;

public interface SkillsUtil {
	Skills loadSaveSkillsRequestToSkills(SaveSkillsRequest request);

	Skills loadEditSkillsRequestToSkills(EditSkillsRequest request,Skills skills);
}
