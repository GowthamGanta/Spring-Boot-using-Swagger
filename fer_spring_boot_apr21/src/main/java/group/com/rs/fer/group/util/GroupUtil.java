package com.rs.fer.group.util;

import com.rs.fer.group.entity.Group;
import com.rs.fer.group.request.SaveGroupRequest;

public interface GroupUtil {

	Group loadSaveGroupRequest(SaveGroupRequest request, int userId, String groupName);
}
